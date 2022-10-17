package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import model.Customer;

public class AdminProcess {
	
	Connection connect=null;
	PreparedStatement prepared_statement=null;
	ResultSet result_set=null;
	int rows_affected=0;
	
	public AdminProcess()
	{
		try {
			connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "@Jjack007");
			System.out.println("Admin process connected");
		} catch (SQLException e) {
			System.out.println("Connection is not established");
			e.printStackTrace();
		}
	}
	

	public void menu_variety_details() {
		Scanner sc1 = new Scanner(System.in);
		boolean expand_menu = true;
		while (expand_menu) {
			System.out.println();
			System.out.println("Choose any category to explore dishes....");
			System.out.println(
					"1.Veg \n2.Non Veg \n3.Rice \n4.Bread \n5.Drinking Beverages \n6.Deserts \n7.Shakes \n8.Main Menu");
			int category = sc1.nextInt();
			expand_menu = (category == 8) ? false : true;
			showdishes(category);
		}
	}
	
	
	public void showdishes(int category) {
		int dish_index=0;
		System.out.println();
		switch (category) {
		case 1: {
			try {
				prepared_statement=connect.prepareStatement("SELECT Food_name,Food_Price FROM Food WHERE Variety_Id=? AND Food_Quantity>=1");
				prepared_statement.setInt(1, category);
				result_set=prepared_statement.executeQuery();
				System.out.println("--------Available varieties of dishes in veg Category-----------");
				System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				System.out.println();
				while(result_set.next()){
					System.out.printf("%-5s %-25s %-5s",++dish_index,result_set.getString(1),result_set.getString(2));
					System.out.println();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
			break;

		case 2: {
			try {
				prepared_statement=connect.prepareStatement("SELECT Food_name,Food_Price FROM Food WHERE Variety_Id=? AND Food_Quantity>=1");
				prepared_statement.setInt(1, category);
				result_set=prepared_statement.executeQuery();
				System.out.println("-------Available varieties of dishes in Non veg Category-------");
				System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				System.out.println();
				while(result_set.next()){
					System.out.printf("%-5s %-25s %-5s",++dish_index,result_set.getString(1),result_set.getString(2));
					System.out.println();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			break;

		case 3: {
			try {
				prepared_statement=connect.prepareStatement("SELECT Food_name,Food_Price FROM Food WHERE Variety_Id=? AND Food_Quantity>=1");
				prepared_statement.setInt(1, category);
				result_set=prepared_statement.executeQuery();
				System.out.println("--------Available varieties of dishes in rice Category------------");
				System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				System.out.println();
				while(result_set.next()){
					System.out.printf("%-5s %-25s %-5s",++dish_index,result_set.getString(1),result_set.getString(2));
					System.out.println();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			break;

		case 4: {
			try {
				prepared_statement=connect.prepareStatement("SELECT Food_name,Food_Price FROM Food WHERE Variety_Id=? AND Food_Quantity>=1");
				prepared_statement.setInt(1, category);
				result_set=prepared_statement.executeQuery();
				System.out.println("--------Available varieties of dishes in bread Category-----------");
				System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				System.out.println();
				while(result_set.next()){
					System.out.printf("%-5s %-25s %-5s",++dish_index,result_set.getString(1),result_set.getString(2));
					System.out.println();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			break;

		case 5: {
			try {
				prepared_statement=connect.prepareStatement("SELECT Food_name,Food_Price FROM Food WHERE Variety_Id=? AND Food_Quantity>=1");
				prepared_statement.setInt(1, category);
				result_set=prepared_statement.executeQuery();
				System.out.println("-------Available varieties of dishes in drinking beverages Category-------");
				System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
				System.out.println();
				System.out.println("------------------------------------------------------------------------");
				System.out.println();
				while(result_set.next()){
					System.out.printf("%-5s %-25s %-5s",++dish_index,result_set.getString(1),result_set.getString(2));
					System.out.println();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			break;

		case 6: {
			try {
				prepared_statement=connect.prepareStatement("SELECT Food_name,Food_Price FROM Food WHERE Variety_Id=? AND Food_Quantity>=1");
				prepared_statement.setInt(1, category);
				result_set=prepared_statement.executeQuery();
				System.out.println("-------Available varieties of dishes in desert Category-----------");
				System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				System.out.println();
				while(result_set.next()){
					System.out.printf("%-5s %-25s %-5s",++dish_index,result_set.getString(1),result_set.getString(2));
					System.out.println();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			break;

		case 7: {
			try {
				prepared_statement=connect.prepareStatement("SELECT Food_name,Food_Price FROM Food WHERE Variety_Id=? AND Food_Quantity>=1");
				prepared_statement.setInt(1, category);
				result_set=prepared_statement.executeQuery();
				System.out.println("-------Available varieties of dishes in shakes Category-----------");
				System.out.printf("%-5s %-25s %-5s","S.No","Dish Name","Price Per Quantity");
				System.out.println();
				System.out.println("----------------------------------------------------------------");
				System.out.println();
				while(result_set.next()){
					System.out.printf("%-5s %-25s %-5s",++dish_index,result_set.getString(1),result_set.getString(2));
					System.out.println();
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			break;

		case 8:
			return;

		default:
			System.out.println("We are not providing this category of varieties....Please try any of our mentiond services");
			System.out.println("Thank you for UNDERSTANDING:)");
		}
	}
	
	public int insert_user_details(Customer user_detail)
	{
		try {
			
			PreparedStatement prepared_statement1=connect.prepareStatement("INSERT INTO Customer(Customer_Name,Customer_MobileNo) VALUES(?,?)");
			prepared_statement1.setString(1, user_detail.getCustomer_Name());
			prepared_statement1.setString(2, user_detail.getCustomer_Mobile());
			rows_affected=prepared_statement1.executeUpdate();
			if(rows_affected>0)
				{
				System.out.println("Customer details are captured....");
				}
			
			PreparedStatement prepared_statement2=connect.prepareStatement("SELECT Customer_Id From Customer ORDER BY Customer_id DESC LIMIT 1");
			ResultSet result_set2=prepared_statement2.executeQuery();
			while(result_set2.next())
				{
				user_detail.setCustomer_id(result_set2.getInt(1));
				}
			//return user_detail.getCustomer_id();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user_detail.getCustomer_id();
	}
}
