package controller;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

import model.Book;
import model.Library_Db;
import model.Transaction_Data;
import model.User;

public class AdminProcess {
	Scanner user_input=new Scanner(System.in);
	public void addBooks(Library_Db db)
	{
		LocalDateTime current_date=LocalDateTime.now();
		db.insertBookDetail(new Book("LB1","The Phoenix Project","George Spafford","7th edition","IT Revolution Press","Fiction Novel",false,"good","english"));
		db.insertBookDetail(new Book("LB2","The Phoenix Project","George Spafford","7th edition","IT Revolution Press","Fiction Novel",true,"good","english"));
		db.insertBookDetail(new Book("LB3","The Phoenix Project","George Spafford","6th edition","IT Revolution Press","Fiction Novel",true,"damaged","english"));
		db.insertBookDetail(new Book("LB4","The Phoenix Project","George Spafford","6th edition","IT Revolution Press","Fiction Novel",true,"damaged","english"));
		db.insertBookDetail(new Book("LB5","The Phoenix Project","George Spafford","5th edition","IT Revolution Press","Fiction Novel",false,"good","english"));
		
		//Horror novels
		db.insertBookDetail(new Book("LB6","Salem's Lot","Stephen King","5th edition","IT Press","Fiction Novel",false,"good","english"));
		db.insertBookDetail(new Book("LB7","Salem's Lot","Stephen King","5th edition","IT Press","Fiction Novel",true,"good","english"));
		db.insertBookDetail(new Book("LB8","Salem's Lot","Stephen King","5th edition","IT Press","Fiction Novel",true,"good","english"));
		
		
		//user list
		//public User(String mail,String user_password,String user_name,String mobile,boolean ismember,String member_id,String notification,String pending)
		db.insertUserDetail(new User("mathi@gmail.com","mathi","mathi","9090909090",true,"LM202201","",""));
		db.insertUserDetail(new User("balu@gmail.com","balu","balu","9898989898",true,"LM202202","book return due date is 02-Oct-2022",""));
		db.insertUserDetail(new User("somu@gmail.com","somu","somu","9797979797",true,"LM202203","book return due date is 01-Oct-2022",""));
		db.insertUserDetail(new User("keerthi@gmail.com","keerthi","keerthi","9696969696",true,"LM202204","","Approved membership request"));
		db.insertUserDetail(new User("kalai@gmail.com","kalai","kalai","8989898989",true,"LM202205","","Approved membership request"));
		
		//Transaction details
		//(String b_id,String mem_id,LocalDateTime borrowed_dt,LocalDateTime return_due_dt,LocalDateTime returned_dt,boolean fined,double fine_amt,boolean paid,LocalDateTime fined_dt,LocalDateTime fine_due_dt,LocalDateTime fine_paid_dt)
		current_date=current_date.minusDays(7);
		db.insertTransactionDetail(new Transaction_Data("LB5","LM202203",current_date,current_date.plusDays(7),true,current_date.plusDays(4),false,0.00,false,null,null,null,false));
		current_date=current_date.minusDays(8);
		db.insertTransactionDetail(new Transaction_Data("LB6","LM202205",current_date,current_date.plusDays(7),true,current_date.plusDays(8),true,25.00,true,current_date.plusDays(8),current_date.plusDays(10),current_date.plusDays(8),false));
		current_date=current_date.minusDays(8);
		db.insertTransactionDetail(new Transaction_Data("LB1","LM202203",current_date,current_date.plusDays(7),false,null,false,0.00,false,null,null,null,true));
		
	}

	public int due_remainder(String membership_id,LocalDateTime due_dt,int type,int tran_index,Library_Db db)
	{
		int count=0;
		int user_index=0;
		int days_count=0;
		double due_amount=0;
		for(int index=0;index<db.user_detail.size();index++)
		{
			if(db.user_detail.get(index).getMembership_id().equals(membership_id))
			{
				user_index=index;
				break;
			}
		}
		switch(type)
		{
		case 1:
		{
			//return due
			if(db.transaction_details.get(tran_index).getReturn_due_Date().isBefore(LocalDateTime.now()))
			{
				days_count=Period.between(LocalDateTime.now().toLocalDate(), due_dt.toLocalDate()).getDays();
				due_amount=25 * Math.abs(days_count);
				db.transaction_details.get(tran_index).setFine_amount(due_amount);
				db.transaction_details.get(tran_index).setIs_fined(true);
				db.transaction_details.get(tran_index).setFine_due_date(LocalDateTime.now().plusDays(2));
				db.user_detail.get(user_index).setNotification("Fined for "+days_count+" day(s)");
				//System.out.println("Fine amount sent to member :"+db.user_detail.get(user_index).getName());
				count++;
				if(count==1)
				{
					System.out.println("--------------------------------------------------------------------------");
					System.out.printf("%-15s %-20s %-15s %-10s","Member Id","Due reason","Due amount","Due date");
					System.out.println();
					System.out.println("---------------------------------------------------------------------------");
				}
				System.out.printf("%-15s %-20s %-10s %-10s",db.transaction_details.get(tran_index).getMembership_id(),"Book return due",db.transaction_details.get(tran_index).getFine_amount(),db.transaction_details.get(tran_index).getFine_due_date().toLocalDate());
				System.out.println();
				
			}
			else
			{
				db.user_detail.get(user_index).setNotification("return book, due date :"+due_dt);
				count++;
			}
			
		}
		break;
		
		case 2:
		{
			if(db.transaction_details.get(tran_index).getFine_due_date().isBefore(LocalDateTime.now()))
			{
				days_count=Period.between(LocalDateTime.now().toLocalDate(), due_dt.toLocalDate()).getDays();
				if(days_count >30)
				{
					System.out.println("Your membership is cancelled...to renew the membership pay amount");
					return count;
				}
				due_amount = (50 *  Math.abs(days_count))+ db.transaction_details.get(tran_index).getFine_amount();
				db.transaction_details.get(user_index).setFine_amount(due_amount);
				db.transaction_details.get(tran_index).setIs_paid(false);
				db.transaction_details.get(tran_index).setFine_due_date(LocalDateTime.now().plusDays(2));
				count++;
				if(count==1)
				{
					System.out.println("--------------------------------------------------------------------------");
					System.out.printf("%-15s %-20s %-10s %-10s","Member Id","Due reason","Due amount","Due date");
					System.out.println();
					System.out.println("---------------------------------------------------------------------------");
				}
				System.out.printf("%-15s %-20s %-10s %-10s",db.transaction_details.get(tran_index).getMembership_id(),"Fine due",db.transaction_details.get(tran_index).getFine_amount(),db.transaction_details.get(tran_index).getFine_due_date().toLocalDate());
				System.out.println();
			}
		}
		break;
		
		}
		
		return count;
	}

	public void get_damaged_book(Library_Db db)
	{
		int serial_no=0;
		System.out.println("***************************Damaged book details*******************************");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.printf("%-5s %-8s %-20s %25s %-20s","S.No","Book Id","Book Name","Author Name","Edition");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		for(int index=0;index<db.book_detail.size();index++)
		{
			if(db.book_detail.get(index).getBook_status().equals("damaged"))
			{
				System.out.printf("%-5s %-8s %-20s %25s %-20s",(++serial_no),db.book_detail.get(index).getBook_id(),db.book_detail.get(index).getBook_name(),db.book_detail.get(index).getBook_author(),db.book_detail.get(index).getBook_edition());
				System.out.println();
			}
		}
		System.out.println("----------------------------------------------------------------------------------");
	}

	public void addBooks(Book book_info,Library_Db db)
	{
		db.insertBookDetail(book_info);
		System.out.println("Book added successfully!...");
	}
	
	public void updateBookDetails(String book_id,Library_Db db)
	{
		Book book_detail=null;
		for(int index=0;index<db.book_detail.size();index++)
		{
			if(db.book_detail.get(index).getBook_id().equals(book_id))
			{
				db.book_detail.remove(index);
				break;
			}
		}
		System.out.println("Enter book details to update");
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
		book_detail=new Book(book_id,book_name,author,edition,publication,genre,availability,status,language);
		addBooks(book_detail,db);
		
	}

	public void delete(String book_id,Book b,Library_Db db)
	{
		for(int index=0;index<db.book_detail.size();index++)
		{
			if(db.book_detail.get(index).getBook_id().equals(book_id))
				
				{
				db.book_detail.remove(index);
				System.out.println("Removed successfully");
				}
		}
	}
	
	public void search_book_by_name(String book_name_choice,int count,Library_Db db)
	{
		if(count==0)
			System.out.println("Sorry!There is no results for your search..");
		else
		{
			int serial_no=0;
			System.out.println("***********************************************Book List****************************************************");
			System.out.println("------------------------------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s %-6s","S.No","Book Id","Book Name","Author Name","Genre","Available","Book status");
			System.out.println("\n------------------------------------------------------------------------------------------------------------");
			for(int index=0;index<db.book_detail.size();index++)
			{
				if(db.book_detail.get(index).getBook_name().equalsIgnoreCase(book_name_choice))
				{
					System.out.printf("%-5s %-8s %-20s %-25s %-10s %-5s %-6s",(++serial_no),db.book_detail.get(index).getBook_id(),db.book_detail.get(index).getBook_name(),db.book_detail.get(index).getBook_author(),db.book_detail.get(index).getBook_genre(),db.book_detail.get(index).isBook_availability(),db.book_detail.get(index).getBook_status());
					System.out.println();
				}
			}
			System.out.println("----------------------------------------------------------------------------------------------------------------");
		}
	}
	
	
}
