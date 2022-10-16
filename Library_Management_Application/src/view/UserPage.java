package view;

import java.util.Scanner;

import controller.UserProcess;
import model.Admin;
import model.Library_Db;
import model.User;

public class UserPage {
	public void user_HomePage(Library_Db db,UserProcess user_process,Admin admin_detail,String email_id)
	{
		Scanner user_input=new Scanner(System.in);
		System.out.println("**************Welcome User****************");
		boolean lets_start=true;
		while(lets_start)
		{
			System.out.println("\n1.Book List \n2.Search book \n3.Borrow book \n4.Return book \n5.Exit");
			int start_choice=user_input.nextInt();
			switch(start_choice)
			{
			case 1:
			{
				 user_process.show_book_list(db);
			}
			break;
			
			case 2:
			{
				boolean start_search=true;
				while(start_search)
				{
					int count=0;
					System.out.println("***********************************Searching books****************************************");
					System.out.println("Search book by...\n1.Book name \n2.Genre \n3.Author name \n4.publication \n5.Language \n6.Back");
					int search_choice=user_input.nextInt();
					switch(search_choice)
					{
					case 1:
					{
						user_input.nextLine();
						System.out.println("Enter book name to search");
						String book_name_choice=user_input.nextLine();
						for(int index=0;index<db.book_detail.size();index++)
						{
							if(db.book_detail.get(index).getBook_name().equalsIgnoreCase(book_name_choice))
								count++;
								
						}
						user_process.search_book_by_name(book_name_choice,count, db);
					}
					break;
					
					case 2:
					{
						user_input.nextLine();
						System.out.println("Enter book genre to search");
						String book_genre_choice=user_input.nextLine();
						for(int index=0;index<db.book_detail.size();index++)
						{
							if(db.book_detail.get(index).getBook_genre().equalsIgnoreCase(book_genre_choice))
								count++;
								
						}
						user_process.search_book_by_genre(book_genre_choice,count, db);
					}
					break;
					
					case 3:
					{
						user_input.nextLine();
						System.out.println("Enter author name to search");
						String author_choice=user_input.nextLine();
						for(int index=0;index<db.book_detail.size();index++)
						{
							if(db.book_detail.get(index).getBook_author().equalsIgnoreCase(author_choice))
								count++;
								
						}
						user_process.search_book_by_author(author_choice,count, db);
					}
					break;
					
					case 4:
					{
						user_input.nextLine();
						System.out.println("Enter publication to search");
						String publication_choice=user_input.nextLine();
						for(int index=0;index<db.book_detail.size();index++)
						{
							if(db.book_detail.get(index).getBook_publication().equalsIgnoreCase(publication_choice))
								count++;
								
						}
						user_process.search_book_by_publication(publication_choice,count, db);
					}
					break;
					
					case 5:
					{
						user_input.nextLine();
						System.out.println("Enter Language to search");
						String Language_choice=user_input.nextLine();
						for(int index=0;index<db.book_detail.size();index++)
						{
							if(db.book_detail.get(index).getBook_language().equalsIgnoreCase(Language_choice))
								count++;
								
						}
						user_process.search_book_by_language(Language_choice,count, db);
					}
					break;
					
					case 6:
					{
						start_search=false;
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
			
			case 3:
			{
				user_input.nextLine();
				user_process.show_book_list(db);
				System.out.println("Choose any of one book to borrow");
				System.out.println("Enter Book Id:");
				String book_id=user_input.nextLine();
				user_process.borrow_book(book_id,email_id,db,admin_detail);
			}
			break;
			
			case 4:
			{
				user_process.return_book(email_id,db,admin_detail,user_process);
				System.out.println("******************************************************************");
			}
			break;
			
			case 5:
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
