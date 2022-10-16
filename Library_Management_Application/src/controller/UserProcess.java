package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import model.Admin;
import model.Book;
import model.Library_Db;
import model.Transaction_Data;
import model.User;

public class UserProcess {
	Scanner user_input=new Scanner(System.in);
	
	
	public boolean check_existing_user(String email,Library_Db db)
	{
		for(int user_index=0;user_index<db.getUserDetail().size();user_index++)
		{
			if(db.getUserDetail().get(user_index).getEmail_id().equals(email))
				return true;
		}
		return false;
	}
	
	
	public void show_book_list(Library_Db db)
	{
		int serial_no=0;
		System.out.println("***********************************************Book List****************************************************");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-8s %-25s %-25s %-15s %-5s %-6s","S.No","Book Id","Book Name","Author Name","Genre","Available","Status");
		System.out.println("\n------------------------------------------------------------------------------------------------------------");
		for(int index=0;index<db.book_detail.size();index++)
		{
			System.out.printf("%-5s %-8s %-25s %-25s %-15s %-5s %-6s",(++serial_no),db.book_detail.get(index).getBook_id(),db.book_detail.get(index).getBook_name(),db.book_detail.get(index).getBook_author(),db.book_detail.get(index).getBook_genre(),db.book_detail.get(index).isBook_availability(),db.book_detail.get(index).getBook_status());
			System.out.println();
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	}
	
	public void search_book_by_name(String book_name_choice,int count, Library_Db db)
	{
		if(count==0)
			System.out.println("Sorry!There is no results for your search..");
		else
		{
			int serial_no=0;
			System.out.println("***********************************************Book List****************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s","S.No","Book Id","Book Name","Author Name","Genre","Available");
			System.out.println("\n------------------------------------------------------------------------------------------------------------");
			for(int index=0;index<db.book_detail.size();index++)
			{
				if(db.book_detail.get(index).getBook_name().equalsIgnoreCase(book_name_choice))
				{
					System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s",(++serial_no),db.book_detail.get(index).getBook_id(),db.book_detail.get(index).getBook_name(),db.book_detail.get(index).getBook_author(),db.book_detail.get(index).getBook_genre(),db.book_detail.get(index).isBook_availability());
					System.out.println();
				}
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
	
	public void search_book_by_genre(String book_genre_choice,int count,Library_Db db)
	{
		if(count==0)
			System.out.println("Sorry!There is no results for your search..");
		else
		{
			int serial_no=0;
			System.out.println("***********************************************Book List****************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s","S.No","Book Id","Book Name","Author Name","Genre","Available");
			System.out.println("\n------------------------------------------------------------------------------------------------------------");
			for(int index=0;index<db.book_detail.size();index++)
			{
				if(db.book_detail.get(index).getBook_genre().equalsIgnoreCase(book_genre_choice))
				{
					System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s",(++serial_no),db.book_detail.get(index).getBook_id(),db.book_detail.get(index).getBook_name(),db.book_detail.get(index).getBook_author(),db.book_detail.get(index).getBook_genre(),db.book_detail.get(index).isBook_availability());
					System.out.println();
				}
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
	}
	
	
	public void search_book_by_author(String author_choice,int count,Library_Db db)
	{
		if(count==0)
			System.out.println("Sorry!There is no results for your search..");
		else
		{
			int serial_no=0;
			System.out.println("***********************************************Book List****************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s %-6s","S.No","Book Id","Book Name","Author Name","Genre","Available","Status");
			System.out.println("\n------------------------------------------------------------------------------------------------------------");
			for(int index=0;index<db.book_detail.size();index++)
			{
				if(db.book_detail.get(index).getBook_author().equalsIgnoreCase(author_choice))
				{
					System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s %-6s",(++serial_no),db.book_detail.get(index).getBook_id(),db.book_detail.get(index).getBook_name(),db.book_detail.get(index).getBook_author(),db.book_detail.get(index).getBook_genre(),db.book_detail.get(index).isBook_availability(),db.book_detail.get(index).getBook_status());
					System.out.println();
				}
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
	}
	
	public void search_book_by_publication(String publication_choice,int count,Library_Db db)
	{
		if(count==0)
			System.out.println("Sorry!There is no results for your search..");
		else
		{
			int serial_no=0;
			System.out.println("***********************************************Book List****************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s %-6s","S.No","Book Id","Book Name","Author Name","Genre","Available","Status");
			System.out.println("\n------------------------------------------------------------------------------------------------------------");
			for(int index=0;index<db.book_detail.size();index++)
			{
				if(db.book_detail.get(index).getBook_publication().equalsIgnoreCase(publication_choice))
				{
					System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s %-6s",(++serial_no),db.book_detail.get(index).getBook_id(),db.book_detail.get(index).getBook_name(),db.book_detail.get(index).getBook_author(),db.book_detail.get(index).getBook_genre(),db.book_detail.get(index).isBook_availability(),db.book_detail.get(index).getBook_status());
					System.out.println();
				}
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
	}
	
	public void search_book_by_language(String Language_choice,int count,Library_Db db)
	{
		if(count==0)
			System.out.println("Sorry!There is no results for your search..");
		else
		{
			int serial_no=0;
			System.out.println("***********************************************Book List****************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s","S.No","Book Id","Book Name","Author Name","Genre","Available");
			System.out.println("\n------------------------------------------------------------------------------------------------------------");
			for(int index=0;index<db.book_detail.size();index++)
			{
				if(db.book_detail.get(index).getBook_language().equalsIgnoreCase(Language_choice))
				{
					System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s",(++serial_no),db.book_detail.get(index).getBook_id(),db.book_detail.get(index).getBook_name(),db.book_detail.get(index).getBook_author(),db.book_detail.get(index).getBook_genre(),db.book_detail.get(index).isBook_availability());
					System.out.println();
				}
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
	}

	public void borrow_book(String book_choice,String email,Library_Db db,Admin admin_detail)
	{
		
		ArrayList<User> user_info=new ArrayList<>();
		LocalDateTime current_date=LocalDateTime.now();
		ArrayList<Transaction_Data> live_transact_info=new ArrayList<>();
		Book book_info = null;
		Transaction_Data current_transaction;
		
		for(int user_index=0;user_index<db.user_detail.size();user_index++)
		{
			if(db.getUserDetail().get(user_index).getEmail_id().equals(email))
				user_info.add(db.user_detail.get(user_index));
		}
		
		for(int tran_index=0;tran_index<db.transaction_details.size();tran_index++)
		{
			if((db.getTransactionDetail().get(tran_index).getMembership_id().equals(user_info.get(0).getMembership_id())) &&(db.getTransactionDetail().get(tran_index).isIs_live()))
			{
				live_transact_info.add(db.getTransactionDetail().get(tran_index));
			}
		}
		
		for(int book_index=0;book_index<db.getBookDetail().size();book_index++)
		{
			if(db.getBookDetail().get(book_index).getBook_id().equals(book_choice))
			{
				book_info=db.getBookDetail().get(book_index);
			}
		}
		
		if(live_transact_info.size()==0 && book_info.isBook_availability())
		{
					//db.insertTransactionDetail();
					//Transaction_Data(String b_id,String mem_id,LocalDateTime borrowed_dt,LocalDateTime return_due_dt,boolean returned_book,LocalDateTime returned_dt,boolean fined,double fine_amt,boolean paid,LocalDateTime fined_dt,LocalDateTime fine_due_dt,LocalDateTime fine_paid_dt,boolean live)
					current_transaction=new Transaction_Data(book_choice,user_info.get(0).getMembership_id(),current_date,current_date.plusDays(7),false,null,false,0.00,false,null,null,null,true);
					db.insertTransactionDetail(current_transaction);
					admin_detail.user_notification.put(user_info.get(0).getMembership_id(), current_transaction);
					System.out.println("Borrowed book details updated and sent notification to admin.....");
					System.out.println("----------------------------------------------------------------------------------------");
					System.out.printf("%-8s %-20s %-8s","Book Id","Book Name","Return due date");
					System.out.println("\n---------------------------------------------------------------------------------------");
					System.out.printf("%-8s %-20s %-8s",current_transaction.getBook_id(),book_info.getBook_name(),current_transaction.getReturn_due_Date().toLocalDate());
					System.out.println("\n----------------------------------------------------------------------------------------");
			
		}
		else if(!book_info.isBook_availability())
		{
			System.out.println("The book is not available....Please try some other book");
		}
		else 
		{
			System.out.println("Sorry!..Not allowed...You have not completed previous book transaction or fine due process....");
		}
		System.out.println("***************************************************************************************************");
	}

	public void return_book(String email_id,Library_Db db,Admin admin_detail,UserProcess user_process)
	{
		Transaction_Data live_transaction;
		live_transaction=user_process.get_live_transactions(email_id,user_process,db,admin_detail);
		
	}
	
	public Transaction_Data get_live_transactions(String email_id,UserProcess user_process,Library_Db db,Admin admin_detail)
	{
		Transaction_Data live_transaction=null;
		User user_info=null;
		Book book_info=null;
		LocalDateTime current_date=LocalDateTime.now();
		for(int user_index=0;user_index<db.user_detail.size();user_index++)
		{
			if(db.getUserDetail().get(user_index).getEmail_id().equals(email_id))
			{
				user_info=db.getUserDetail().get(user_index);
			}
		}
		for(int tran_index=0;tran_index<db.transaction_details.size();tran_index++)
		{
			/*System.out.println(db.transaction_details.get(tran_index).getMembership_id());
			System.out.println(user_info.getMembership_id());
			System.out.println(db.transaction_details.get(tran_index).isIs_live());*/
			//System.out.println(db.transaction_details.get(tran_index).getMembership_id().equals(user_info.getMembership_id()));
			if(db.transaction_details.get(tran_index).getMembership_id().equals(user_info.getMembership_id()))
			{
				if(db.transaction_details.get(tran_index).isIs_live())
						live_transaction=db.transaction_details.get(tran_index);
			}
		}
		
		for(int book_index=0;book_index<db.getBookDetail().size();book_index++)
		{
			if(live_transaction!=null && db.getBookDetail().get(book_index).getBook_id().equals(live_transaction.getBook_id()))
			{
				book_info=db.getBookDetail().get(book_index);
			}
		}
		
		if(live_transaction==null)
		{
			System.out.println("There is no live transaction for you");
			
		}
		else 
		{
			System.out.println("*********************Pending transaction*****************");
			System.out.println("Member Id 	:"+user_info.getMembership_id());
			System.out.println("Member Name :"+user_info.getName());
			if(live_transaction.isIs_fined())
			{
				System.out.println("\n---------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-5s %-20s %-20s %-20s %-8s %-20s","Book Id","Book Name","Return due date","Fined Date","Fine amount","Fine due date");
				System.out.println("\n\n--------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-5s %-20s %-20s %-20s %-8s %-20s",book_info.getBook_id(),book_info.getBook_name(),live_transaction.getReturn_due_Date().toLocalDate(),live_transaction.getFined_date().toLocalDate(),live_transaction.getFine_amount(),live_transaction.getFine_due_date().toLocalDate());
				System.out.println();
				System.out.println("\n--------------------------------------------------------------------------------------------------------------------");
				System.out.print("Do you want to pay fine amount(1.yes or 2.no):");
				int fine_choice=user_input.nextInt();
				if(fine_choice==1)
				{
					live_transaction.setIs_paid(true);;
					live_transaction.setFine_paid_date(current_date);
					live_transaction.setIs_live(false);
					admin_detail.user_notification.put(user_info.getMembership_id(), live_transaction);
					
				}
				else
				{
					System.out.println("Please pay your fine on or before due date");
				}
				
			
			}
			else 
			{
				System.out.println("\n------------------------------------------------------------------");
				System.out.printf("%-5s %-20s %-20s","Book Id","Book Name","Return due date");
				System.out.println();
				System.out.println("---------------------------------------------------------------------");
				System.out.printf("%-5s %-20s %-20s",book_info.getBook_id(),book_info.getBook_name(),live_transaction.getReturn_due_Date().toLocalDate());
				System.out.println();
				System.out.println("\n--------------------------------------------------------------------");
				
				System.out.println("Do you want to return book? (1.yes or 2.no):");
				int return_choice=user_input.nextInt();
				if(return_choice==1)
				{
					live_transaction.setIs_returned(true);
					live_transaction.setReturned_date(current_date);
					live_transaction.setIs_live(false);
					admin_detail.user_notification.put(user_info.getMembership_id(), live_transaction);
					System.out.println("Book returned...");
				}
				else
				{
					System.out.println("Please return the book before due date");
				}
			}
		}
		return live_transaction;
	}
}
