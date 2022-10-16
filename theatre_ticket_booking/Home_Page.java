package theatre_ticket_booking;

import java.util.*;
public class Home_Page extends User{
	Scanner user_input=new Scanner(System.in);
	public void home(Start_Booking book_ticket)
	{
		System.out.println("\nWe are happy to see you in this movie damaka...."+"\n");
		boolean lets_go=true;
		while(lets_go)
		{
			System.out.println("Choose any services to explore movies and entertain yourself...\n1.Movie List \n2.Book Movie Ticket \n3.Booked Ticket Details \n4.Logout\n");
			int explore_with=user_input.nextInt();
			switch(explore_with)
			{
			case 1:
			{
				book_ticket.show_movie_list();
			}
			break;
			
			case 2:
			{
				book_ticket.show_movie_list();
				//System.out.println("Choose filter to check movie and show timings availability");
				System.out.println("\n Select screen to check movie timings and ticket availability(1,2,3)\n");
				int screen_choice=user_input.nextInt();
				book_ticket.book_show(screen_choice,book_ticket);
				//
				//
				//
				//book_ticket.setbooked_movie(selected_flim);
				
			}
			break;
			
			case 3:
			{
				if(book_ticket ==null)
				{
					System.out.println("There is no available booking details");
				}
				else
				{
					book_ticket.show_booked_tickets(book_ticket);
				}
				System.out.println("Thank you....Enjoy the movie");
			}
			break;
			
			case 4:
			{
				lets_go=false;
			}
			break;
			
			default:
			{
				System.out.println("We are not providing the service......Sorry for this inconvenience..");
				System.out.println("Thank you for your Understanding....Kindly try our service mentioned above:)\n");
			}
			}
		}
		
	}
}
