package view;

import model.Admin;
import model.Book;
import model.Library_Db;
import model.Transaction_Data;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;
import controller.AdminProcess;

public class AdminPage extends UserPage{
	public void HomePage(Admin admin_detail,AdminProcess admin_process,Library_Db db)
	{
		Scanner user_input=new Scanner(System.in);
		
		
		System.out.println("********Welcome Admin********");
		boolean lets_start=true;
		while(lets_start)
		{	
			System.out.println("1.Restock and Setup library \n2.Due Check \n3.Damage check \n4.Notifications \n5.Search book by name \n6.Logout");
			int start_choice=user_input.nextInt();
			switch(start_choice)
			{
			case 1:
			{
				if(db.book_detail.size()>0)
				{
					System.out.println("Library setup completed");
				}
				else
				{
					System.out.println("Library setup is not yet completed...contact admin for further queries...");
				}
				System.out.println("****************************************************\n");
				boolean lets_modify=true;
				while(lets_modify)
				{
					System.out.println("Do you want to do any following process?\n1.Add book \n2.Update Book Details \n3.Delete book \n4.exit");
					int modify_choice =user_input.nextInt();
					Book book_info=null;
					switch(modify_choice)
					{
					case 1:
					{
						user_input.nextLine();
						System.out.print("Book Name:");
						String book_name=user_input.nextLine();
						System.out.print("Book author:");
						String author=user_input.nextLine();
						System.out.print("Book Edition");
						String edition=user_input.nextLine();
						System.out.print("Book Publication:");
						String publication=user_input.nextLine();
						System.out.print("Book genre:");
						String genre=user_input.nextLine();
						System.out.print("Book availability:");
						boolean availability=user_input.nextBoolean();
						System.out.print("Book Status:");
						String status=user_input.nextLine();
						user_input.nextLine();
						System.out.print("Book Language:");
						String language=user_input.nextLine();
						book_info=new Book(Book.book_code+(Book.book_counter++),book_name,author,edition,publication,genre,availability,status,language);
						admin_process.addBooks(book_info,db);
					}
					break;
					
					case 2:
					{
						user_input.nextLine();
						System.out.print("Enter book id to update book details:");
						String book_id=user_input.nextLine();
						admin_process.updateBookDetails(book_id, db);
					}
					break;
					
					case 3:
					{
						user_input.nextLine();
						System.out.print("Enter book id to delete book:");
						String book_id=user_input.nextLine();
						admin_process.delete(book_id,book_info,db);
					}
					break;
					
					case 4:
					{
						lets_modify=false;
					}
					break;
					
					default:
					{
						System.out.println("We are not providing this service...Kindly try any of our services\n");
					}
					}
				}
				
				
			}
			break;
			
			case 2:
			{
				int count=0;
				for(int index=0;index<db.transaction_details.size();index++)
				{
					String membership_id;
					LocalDateTime due_date;
					int type;
					boolean live_data=db.transaction_details.get(index).isIs_live();
					if((live_data && !db.transaction_details.get(index).isIs_fined()) && (db.transaction_details.get(index).getReturn_due_Date().isBefore(LocalDateTime.now()) || db.transaction_details.get(index).getReturn_due_Date().equals(LocalDateTime.now())))
						{
							membership_id=db.transaction_details.get(index).getMembership_id();
							due_date=db.transaction_details.get(index).getReturn_due_Date();
							type=1;//return due
							count=admin_process.due_remainder(membership_id,due_date,type,index,db);
						}
					else if((live_data && !db.transaction_details.get(index).Is_paid()) &&( db.transaction_details.get(index).getFine_due_date().isBefore(LocalDateTime.now()) || db.transaction_details.get(index).getFine_due_date().equals(LocalDateTime.now())))
							{
							membership_id=db.transaction_details.get(index).getMembership_id();
							due_date=db.transaction_details.get(index).getFine_due_date();
							type=2;
							count=admin_process.due_remainder(membership_id,due_date,type,index,db);
							}
					else
					{
						System.out.println();
					}
				}
				if(count>0)
				{
					System.out.println("-----------------------------------------------------------------");
					System.out.println("*  Fine amount assigned to members and notification sent");
				}
					
				else
					System.out.println("No dues pending for today");
				System.out.println("******************************************************************************");
			}
			break;
			
			case 3:
			{
				admin_process.get_damaged_book(db);
			}
			break;
			
			case 4:
			{
				String notification="";
				System.out.println("You have a notification...");
				System.out.println("------------------------------------------------------------------");
				System.out.printf("%-15s %-8s %-20s","Member Id","Book Id","Notification");
				System.out.println("\n-------------------------------------------------------------------");
				for(Map.Entry<String, Transaction_Data> notify_info:admin_detail.user_notification.entrySet())
				{
					if(notify_info.getValue().Is_paid())
						notification="Fine paid";
					else if(notify_info.getValue().getIs_returned())
							notification="Book returned";
					else
						notification="Book borrowed";
					System.out.printf("%-15s %-8s %-20s",notify_info.getKey(),notify_info.getValue().getBook_id(),notification);
					System.out.println();
				}
				System.out.println("\n-------------------------------------------------------------------");
			}
			break;
			
			case 5:
			{
				int count=0;
				user_input.nextLine();
				System.out.println("Enter book name to search");
				String book_name_choice=user_input.nextLine();
				for(int index=0;index<db.book_detail.size();index++)
				{
					if(db.book_detail.get(index).getBook_name().equalsIgnoreCase(book_name_choice))
						count++;
						
				}
				admin_process.search_book_by_name(book_name_choice,count, db);
			}
			break;
			case 6:
			{
				lets_start=false;
			}
			break;
			
			default:
			{
				System.out.println("We are not providing this service...Kindly try any of our services\n");
			}
			}
		}
	}
}
