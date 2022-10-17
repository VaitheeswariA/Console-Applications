package view;

import java.util.Scanner;

import controller.AdminProcess;
import controller.OrderProcess;
import model.Customer;
import model.OrderDetails;

public class HomePage {
	public void home_page(Customer user_detail) {
		Scanner input = new Scanner(System.in);
		AdminProcess admin_process=new AdminProcess();
		OrderProcess order_process=new OrderProcess();
		OrderDetails each_order=new OrderDetails();
		int orderstarts=0;
		double total_amount=0.00;
		int selected_table=0;
		
		boolean lets_start = true;
		while (lets_start) {
			System.out.println("\nProvide your choice to have fun with us!!!... ");
			System.out.println("**************************************************************************");
			System.out.println("1.View Food Menu \n2.Dining and Order food \n3.Order transaction details \n4.Customer Support \n5.Exit");
			int your_choice = input.nextInt();
			
			switch (your_choice) {
			case 1: {
				System.out.println("\nHurray!!!!...Here is our variety of foods...");
				admin_process.menu_variety_details();
				
			}
				break;
			case 2: {
				System.out.println("\nWe are accepting your orders...");
				boolean choose_table=true;
				while(choose_table)
				{
					System.out.println("Select table to dine in(1,2,3,4,5):");
					selected_table=input.nextInt();
					if(order_process.check_table_availability(selected_table))
					{
						user_detail.setSelected_table_no(selected_table);
						System.out.println("your choice of table is available and booked...");
						choose_table=false;
					}
					else
						choose_table=true;
				}
				boolean order_food = true;
				while (order_food) {System.out.println();
					System.out.println("\nChoose any category to explore dishes....");
					System.out.println("1.VEG \n2.NON VEG \n3.RICE \n4.BREAD \n5.DRINKING BEVERAGES \n6.DESERTS \n7.SHAKES \n8.MAIN MENU");
					int selected_category=input.nextInt();
					admin_process.showdishes(selected_category);
					input.nextLine();
					int selected_dish=0;
					int quantity=0;
					boolean isdish_available=false;
					if(!isdish_available)
					{
						System.out.print("Choose dish:");
						selected_dish=input.nextInt();
						//String selected_dish = sc.nextLine();
						System.out.print("Required quantity");
						quantity = input.nextInt();
						isdish_available=order_process.check_food_quantity(selected_category, selected_dish, quantity);
						if(!isdish_available)
							continue;
					}
					orderstarts++;
					if(orderstarts==1)
						{
						user_detail.setCustomer_id(admin_process.insert_user_details(user_detail));
						order_process.insert_Ordered_foods(selected_table,user_detail,each_order);
						}
					order_process.insert_ordered_foods(selected_category, selected_dish, quantity,each_order);
					System.out.println("\nDo you want to add any items to order?(1.yes or 2.no)");
					int start_order = input.nextInt();
					if (start_order == 2)
						order_food=false;
				}
				total_amount=order_process.billing(each_order,user_detail);
				order_process.show_order_details(each_order,user_detail,selected_table,total_amount);
				System.out.println("\nProcessing payment details....");
				System.out.println("\nPayment is successfull...your order will be served soooooon:)");
			}
				break;

			case 3: {
				if(orderstarts==0)
					System.out.println("You have no recent orders...");
				else
					{
					System.out.println("\nYour last transaction details...");
					order_process.show_order_details(each_order,user_detail,selected_table,total_amount);
					}
				
			}
				break;

			case 4: {
				System.out.println("\nWelcome Sir/Madam...How can we help you? choose the following support \n1.Order related queries \n2.Menu related queries \n3.Payment related queries \n4.exit");
				int query_choice=input.nextInt();
				boolean need_support=true;
				input.nextLine();
				while(need_support)
				{
					switch(query_choice)
					{
					case 1:
					{
						System.out.println("Please provide your query");
						String order_query=input.nextLine();
						need_support=false;
					}
					break;
					
					case 2:
					{
						System.out.println("Please provide your query");
						String menu_query=input.nextLine();
						need_support=false;
					}
					break;
					
					case 3:
					{
						System.out.println("Please provide your query");
						String payment_query=input.nextLine();
						need_support=false;
					}
					break;
					case 4:
					{
						need_support=false;
					}
					break;
					
					default:
						System.out.println("Sorry sir/madam,we are rectifying more user queries....We will add your query in future ,will provide support...");
						System.out.println("Thank you for UNDERSTANDING :)");
					}
					
				}
				System.out.println("Thank you Sir/Madam....Our executive will get back to you soon");
			}
				break;

			case 5: {
				lets_start = false;
				order_process.updateTableAvailability(each_order);
				System.out.println("\nThankyou for your visit...Visit again:)");
			}
				break;

			default:
				System.out.println("We are not providing any service like you have provided...Try any of our mentioned service");
			}
			
			
		}
	}
}
