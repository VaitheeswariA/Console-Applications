package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import model.Customer;
import model.OrderDetails;

public class OrderProcess {
	Connection connect=null;
	PreparedStatement prepared_statement=null;
	ResultSet result_set=null;
	int rows_affected=0;
	
	public OrderProcess()
	{
		try {
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "@Jjack007");
			//System.out.println("Order process connected");
		} catch (SQLException e) {
			//System.out.println("Connection is not established");
			e.printStackTrace();
		}
	}
	
	public boolean check_table_availability(int required_table_no)
	{
		try {
			prepared_statement=connect.prepareStatement("SELECT Selected_table,table_availability FROM OrderDetails WHERE Selected_table=? ORDER BY Order_id DESC limit 1");
			prepared_statement.setInt(1, required_table_no);
			result_set=prepared_statement.executeQuery();
			while(result_set.next())
			{
				if(!(result_set.getInt(1)==required_table_no && result_set.getBoolean(2)))
					{
					System.out.println("This table is already booked...Kindly choose other tables");
					return false;
					}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	
	public boolean check_food_quantity(int selected_variety,int selected_dish,int required_quantity)
	{
		try {
			prepared_statement=connect.prepareStatement("SELECT Food_quantity FROM Food WHERE Id=? AND variety_Id=? ");
			prepared_statement.setInt(1, selected_dish);
			prepared_statement.setInt(2, selected_variety);
			result_set=prepared_statement.executeQuery();
			if(result_set.getRow()>=0)
			{
				if(!(result_set.next() && result_set.getInt(1)>=required_quantity))
					{
					System.out.println("Sorry!...we have only "+result_set.getInt(1)+" quantity of selected dish...\n Choose any other dish..");
					return false;
					}
				
			}
			else
			{
				System.out.println("We dont have food of your choice...please check our menu...");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public void insert_Ordered_foods(int selected_table,Customer user_detail,OrderDetails each_order)
	{
		try {
			prepared_statement=connect.prepareStatement("INSERT INTO OrderDetails(Customer_id,Selected_table,table_availability,Price) VALUES(?,?,?,?)");
			prepared_statement.setInt(1, user_detail.customer_id);
			prepared_statement.setInt(2, selected_table);
			prepared_statement.setBoolean(3, false);
			prepared_statement.setDouble(4,0.00);
			rows_affected=prepared_statement.executeUpdate();
			if(rows_affected>0)
				System.out.println("Order Details insertion starts...");
			
			PreparedStatement prepared_statement2=connect.prepareStatement("SELECT Order_Id FROM OrderDetails ORDER BY Order_Id DESC LIMIT 1");
			ResultSet result_set2=prepared_statement2.executeQuery();
			while(result_set2.next())
				{
				each_order.setBill_id(result_set2.getInt(1));
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void insert_ordered_foods(int selected_variety,int selected_dish,int required_quantity,OrderDetails each_order)
	{
		try {
			prepared_statement=connect.prepareStatement("SELECT Food_name,Food_price FROM Food WHERE Id=? AND Variety_Id=?");
			prepared_statement.setInt(1,selected_dish);
			prepared_statement.setInt(2, selected_variety);
			result_set=prepared_statement.executeQuery();
			String food_name="";
			double price=0.00;
			while(result_set.next())
			{
				food_name=result_set.getString(1);
				price=result_set.getDouble(2);
			}
			prepared_statement=connect.prepareStatement("INSERT INTO Orderlist VALUES(?,?,?,?)");
			prepared_statement.setInt(1, each_order.getBill_id());
			prepared_statement.setString(2, food_name);
			prepared_statement.setInt(3,required_quantity);
			prepared_statement.setDouble(4, price*required_quantity);
			rows_affected=prepared_statement.executeUpdate();
			if(rows_affected>0)
				System.out.println("User order inserted");
			
			//update quantity once ordered
			prepared_statement=connect.prepareStatement("SELECT Food_quantity FROM Food WHERE Id=? AND Variety_Id=?");
			prepared_statement.setInt(1,selected_dish );
			prepared_statement.setInt(2, selected_variety);
			result_set=prepared_statement.executeQuery();
			int current_quantity=0;
			while(result_set.next())
			{
				current_quantity=result_set.getInt(1);
			}
			
			prepared_statement=connect.prepareStatement("UPDATE Food SET Food_quantity=? WHERE Id=? AND Variety_Id=?");
			prepared_statement.setInt(1, current_quantity-required_quantity);
			prepared_statement.setInt(2,selected_dish );
			prepared_statement.setInt(3, selected_variety);
			rows_affected=prepared_statement.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public double billing(OrderDetails each_order,Customer user_detail)
	{
		double total_bill_amount=0.00;
		try {
			prepared_statement=connect.prepareStatement("SELECT each_food_price FROM Orderlist WHERE Order_id=?");
			prepared_statement.setInt(1, each_order.getBill_id());
			result_set=prepared_statement.executeQuery();
			while(result_set.next())
			{
				total_bill_amount+=result_set.getDouble(1);
			}
			total_bill_amount+=(total_bill_amount * 0.05);
			
			
			prepared_statement=connect.prepareStatement("UPDATE OrderDetails SET price=? WHERE Order_id=? AND customer_id=?");
			prepared_statement.setDouble(1, total_bill_amount);
			prepared_statement.setInt(2, each_order.getBill_id());
			prepared_statement.setInt(3, user_detail.getCustomer_id());
			rows_affected=prepared_statement.executeUpdate();
			if(rows_affected>0)
				{
				System.out.print("Billing amount processing");
				for(int i=1;i<5;i++)
					System.out.print(".");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total_bill_amount;
	}


	public void show_order_details(OrderDetails each_order,Customer user_detail,int selected_table,double bill_amount)
	{
			try {
				prepared_statement=connect.prepareStatement("SELECT * FROM Orderlist where Order_id=?");
				prepared_statement.setInt(1, each_order.getBill_id());
				result_set=prepared_statement.executeQuery();
				if(result_set.getRow()>=0)
				{
					System.out.println("Customer Name:"+user_detail.getCustomer_Name());
					System.out.println("Customer contact number:"+user_detail.getCustomer_Mobile());
					System.out.println("Table number:"+selected_table);
					System.out.println("Bill Number:"+each_order.getBill_id());
					System.out.println("\n------------------------------Ordered food details---------------------------------------------");
					System.out.printf("%-35s %-25s %-5s %-10s","ordered Item","ordered Quantity","Price per quantity","Price of each dish");
					System.out.println("\n-----------------------------------------------------------------------------------------------");
					while(result_set.next())
					{
						System.out.printf("%-35s %-25s %-5s %-10s",result_set.getString(2),result_set.getInt(3),(result_set.getDouble(4)/result_set.getInt(3)),result_set.getDouble(4));
						System.out.println();
					}
					System.out.println("\n-----------------------------------------------------------------------------------------------");
					System.out.printf("%60s %5s","Gst =","5%");
					System.out.println();
					System.out.println("\n-----------------------------------------------------------------------------------------------");
					System.out.printf("%60s %5s","Total bill amount =" ,bill_amount);
					System.out.println();
			}
				else
				{
					System.out.println("You have not ordered anything...");
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			
		//discard order
	public void discard_order(OrderDetails each_order)
	{
		try {
			prepared_statement=connect.prepareStatement("DELETE FROM Orderlist WHERE Order_id=?");
			prepared_statement.setInt(1, each_order.getBill_id());
			rows_affected=prepared_statement.executeUpdate();
			if(rows_affected >0)
			{	
				rows_affected=0;
				prepared_statement=connect.prepareStatement("DELETE FROM OrderDetails WHERE Order_id=?");
				prepared_statement.setInt(1, each_order.getBill_id());
				rows_affected=prepared_statement.executeUpdate();
				if(rows_affected>0)
					System.out.println("Your order details are discarded");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void updateTableAvailability(OrderDetails each_order)
	{
		try {
			prepared_statement=connect.prepareStatement("UPDATE OrderDetails SET table_availability=? WHERE Order_id=?");
			prepared_statement.setBoolean(1, true);
			prepared_statement.setInt(2, each_order.getBill_id());
			rows_affected=prepared_statement.executeUpdate();
			if(rows_affected>0)
			{
				System.out.println("Table availability updated");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
