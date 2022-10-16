package theatre_ticket_booking;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Theatre {
	Scanner user_input=new Scanner(System.in);
	public static Map<Integer,LinkedHashMap<String,ArrayList<String>>> Theatre=new LinkedHashMap<>();//Screen number-->(moviename,show timing)
	
	//Moviename,(show timings)
	public static LinkedHashMap<String,ArrayList<String>> screen1=new LinkedHashMap<>();
	public static LinkedHashMap<String,ArrayList<String>> screen2=new LinkedHashMap<>();
	public static LinkedHashMap<String,ArrayList<String>> screen3=new LinkedHashMap<>();
	
	
	//(Show timing,available tickets)
	public static LinkedHashMap<String,Integer> screen1_tickets=new LinkedHashMap<>();
	public static LinkedHashMap<String,Integer> screen2_tickets=new LinkedHashMap<>();
	public static LinkedHashMap<String,Integer> screen3_tickets=new LinkedHashMap<>();
	
	
	public void updating_movies()
	{
		//Moviename,(show timings)
		screen1.put("Ponniyin Selvan", new ArrayList<>(Arrays.asList("10.00 AM","6.00 PM")));
		screen1.put("Vendhu Thanindhadhu Kaadu", new ArrayList<>(Arrays.asList("2.00 PM","10.00 PM")));
		
		screen2.put("Thiruchitrambalam", new ArrayList<>(Arrays.asList("10.00 AM","2.00 PM")));
		screen2.put("Viruman", new ArrayList<>(Arrays.asList("6.00 PM","10.00 PM")));
		
		screen3.put("Avathar 3D",new ArrayList<>(Arrays.asList("10.00 AM","6.00 PM")));
		
		
		//Screen number-->(moviename,show timing)
		Theatre.put(1, screen1);
		Theatre.put(2, screen2);
		Theatre.put(3, screen3);
		
		
		//(Show timing,available tickets)
		screen1_tickets.put("10.00 AM", 20);
		screen1_tickets.put("6.00 PM", 20);
		screen1_tickets.put("2.00 PM", 20);
		screen1_tickets.put("10.00 PM", 20);
		
		
		screen2_tickets.put("10.00 AM", 25);
		screen2_tickets.put("6.00 PM", 25);
		screen2_tickets.put("2.00 PM", 25);
		screen2_tickets.put("10.00 PM", 25);
		
		screen3_tickets.put("10.00 AM", 50);
		screen3_tickets.put("6.00 PM", 50);
		
		
	}
	
	
	public String generate_username(String email_id)
	{
		int index=0;
		for(index=0;index<email_id.length();index++)
		{
			if(email_id.charAt(index)=='@')
			{
				System.out.println();
				return email_id.substring(0, index);
			}
				
		}
		return email_id.substring(0, index);
	}

	
	
	public void show_movie_list()
	{
		System.out.println("*************Available movies****************");
		int serial_no;
		for(Map.Entry<Integer,LinkedHashMap<String,ArrayList<String>>> screen:Theatre.entrySet())
		{
			LinkedHashMap<String,ArrayList<String>> each_screen=screen.getValue();
			System.out.println();
			System.out.println("Screen "+screen.getKey()+":");
			System.out.println("-------------------------------------");
			System.out.printf("%-5s %-45s","S_No","Movies Name");
			System.out.println();
			System.out.println("-------------------------------------");
			serial_no=0;
			for(Map.Entry<String,ArrayList<String>> movies:each_screen.entrySet())
			{
				System.out.printf("%-5s %-45s",(++serial_no),movies.getKey());
				System.out.println();
			}
		}
		System.out.println("***********************************************");
		System.out.println();
	}
	
	public void book_show(int screen_choice,Start_Booking book_ticket)
	{
		LinkedHashMap<String,ArrayList<String>> movie=new LinkedHashMap<>();
		ArrayList<String> show_timing=new ArrayList<>();
		String each_movie="";
		String flim_time="";
		String flim_name="";
		if(screen_choice<=0 || screen_choice>3)
		{
			System.out.println("We are not providing the service......Sorry for this inconvenience..");
			System.out.println("Thank you for your Understanding....Kindly try our service mentioned above:)\n");
		}
		else
		{
			System.out.println("Available movies of screen "+screen_choice+" is here.....block your time now!!!!!");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
			System.out.printf("%-5s %-25s %-30s","S.No","Movie Name","Available show timing");
			System.out.println();
			System.out.println("-------------------------------------------------------------------------");
			movie=Theatre.get(screen_choice);
			int movie_list_number=0;
			for(Map.Entry<String,ArrayList<String>> shows:movie.entrySet())
			{
				show_timing=shows.getValue();
				for(String show_time:show_timing)
				{
					System.out.printf("%-5s %-25s %-30s",(++movie_list_number),shows.getKey(),show_time);
					System.out.println();
					//flim_time=show_time;
					//flim_name=shows.getKey();
				}
			}
			System.out.println();
			book_ticket.setselected_screen(screen_choice);
		}
		System.out.println("Choose movie to check ticket availability");
		int movie_choice=user_input.nextInt();
		book_ticket.show_ticket_availability(screen_choice,movie_choice,book_ticket);
		System.out.println("Number of tickets to book show:");
		int ticket_quantity=user_input.nextInt();
		double payable_amount=0.00;
		if(book_ticket.check_ticket_quantity(ticket_quantity,book_ticket))
		{
			payable_amount=calculate_ticket_price(ticket_quantity);
			book_ticket.setbill_amount(payable_amount);
			book_ticket.show_payment_details(ticket_quantity,book_ticket);
			System.out.println();
			book_ticket.setbooked_ticket_count(ticket_quantity);
			book_ticket.update_tickets_availability(book_ticket);
			//book_ticket.show_booked_tickets(book_ticket);
		}
		else
		{
			System.out.println("Sorry!...Tickets are not available for selected show");
		}
		
	}
	
	public void show_ticket_availability(int screen_choice,int movie_choice,Start_Booking book_ticket)
	{
		LinkedHashMap<String,ArrayList<String>> screen=new LinkedHashMap<>();
		String each_movie="";
		ArrayList<String> each_movie_time=new ArrayList<>();
		int movie_index=0;
		if(movie_choice>4 || movie_choice<=0)
		{
			System.out.println("We are not providing the service......Sorry for this inconvenience..");
			System.out.println("Thank you for your Understanding....Kindly try our service mentioned above:)\n");
		}
		else
		{
				movie_index=0;
				screen=Theatre.get(screen_choice);
				for(Map.Entry<String,ArrayList<String>> movie:screen.entrySet())
				{
					each_movie_time=movie.getValue();
					each_movie=movie.getKey();
					for(int index=0;index<each_movie_time.size();index++)
					{
						if(movie_choice==(++movie_index))
						{
							show_tickets__availability(screen_choice,each_movie,each_movie_time.get(index),book_ticket);
						}
					}
				}
			
		}
	}
	
	public void show_tickets__availability(int screen_choice,String each_movie,String timing,Start_Booking book_ticket)
	{
		int serial_no=0;
		System.out.println("\n-----------------------------------------------------------------------");
		System.out.printf("%-5s %-35s %-5s %-10s","S.No","Movie Name","Show Timing","Available Tickets");
		System.out.println();
		System.out.println("\n-----------------------------------------------------------------------\n");
		book_ticket.setbooked_movie(each_movie);
		book_ticket.setbooked_show_time(timing);
		switch(screen_choice)
		{
		case 1:
		{
				System.out.printf("%-5s %-35s %-5s %-10s",(++serial_no),each_movie,timing,screen1_tickets.get(timing));
				System.out.println();
		}
		break;
		
		case 2:
		{
			System.out.printf("%-5s %-35s %-5s %-10s",(++serial_no),each_movie,timing,screen2_tickets.get(timing));
			System.out.println();
		}
		break;
		
		case 3:
		{
			System.out.printf("%-5s %-35s %-5s %-10s",(++serial_no),each_movie,timing,screen3_tickets.get(timing));
			System.out.println();
		}
		break;
		}
		System.out.println();
		
	}
	
	public boolean check_ticket_quantity(int required_quantity,Start_Booking book_ticket)
	{
		boolean is_ticket_available= false;
		int current_quantity=0;
		switch(book_ticket.getselected_screen())
		{
		case 1:
		{
			current_quantity=screen1_tickets.get(book_ticket.getbooked_show_time());
			//System.out.println(screen1_tickets.get(book_ticket.getbooked_show_time()));
			if( current_quantity >=required_quantity)
			{
				is_ticket_available=true;
			}
		}
		break;
		
		case 2:
		{
			if(screen2_tickets.get(book_ticket.getbooked_show_time()) >=required_quantity)
			{
				is_ticket_available=true;
			}
		}
		break;
		
		case 3:
		{
			if(screen2_tickets.get(book_ticket.getbooked_show_time()) >=required_quantity)
			{
				is_ticket_available=true;
			}
		}
		break;
		}
		return is_ticket_available;
	}
	
	public double calculate_ticket_price(int ticket_quantity)
	{
		double ticket_price=120 * ticket_quantity;
		double gst_percent=0.28;
		ticket_price+=(ticket_price * 0.28);
		return ticket_price;
	}
	
	public void update_tickets_availability(Start_Booking book_ticket)
	{
		//int quantity_to_update=0;
		switch(book_ticket.getselected_screen())
		{
		case 1:
		{
			//quantity_to_update=screen1_tickets.get(book_ticket.getbooked_show_time())-book_ticket.getbooked_ticket_count();
			screen1_tickets.put(book_ticket.getbooked_show_time(),screen1_tickets.get(book_ticket.getbooked_show_time())-book_ticket.getbooked_ticket_count());
		}
		break;
		
		case 2:
		{
			screen2_tickets.put(book_ticket.getbooked_show_time(),screen2_tickets.get(book_ticket.getbooked_show_time())-book_ticket.getbooked_ticket_count());
		}
		break;
		
		case 3:
		{
			screen3_tickets.put(book_ticket.getbooked_show_time(),screen3_tickets.get(book_ticket.getbooked_show_time())-book_ticket.getbooked_ticket_count());
		}
		break;
		}
	}
	
	
	public void show_payment_details(int quantity,Start_Booking book_ticket)
	{
		int serial_no=0;
		System.out.println("Screen:"+book_ticket.getselected_screen());
		System.out.println("Show time:"+book_ticket.getbooked_show_time());
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.printf("%-5s %-25s %-15s %-25s","S_No","Movie Name","No of tickets","Price per Ticket");
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.printf("%-5s %-25s %-15s %-25s",(++serial_no),book_ticket.getbooked_movie(),quantity,120.00);
		System.out.println();
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.printf("%-45s %-25s","Gst for movie ticket","28%");
		System.out.println();
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.printf("%-45s %-25s","Total payable amount",book_ticket.getbill_amount());
		System.out.println();
	}
	
	public void show_booked_tickets(Start_Booking book_ticket)
	{
		int serial_no=0;
		System.out.println("Screen:"+book_ticket.getselected_screen());
		System.out.println("Show time:"+book_ticket.getbooked_show_time());
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.printf("%-5s %-25s %-15s","S_No","Movie Name","No of tickets");
		System.out.println("\n----------------------------------------------------------------------------------");
		System.out.printf("%-5s %-25s %-15s",(++serial_no),book_ticket.getbooked_movie(),book_ticket.getbooked_ticket_count());
		System.out.println();
		System.out.println("\n----------------------------------------------------------------------------------\n");
		System.out.printf("%-45s %-25s","Total paid amount",book_ticket.getbill_amount());
		System.out.println();
	}

	public boolean validate_mobile_number(String mobile_number)
	{
		Pattern mobile_number_pattern=Pattern.compile("(0||91)?[6-9][0-9]{9}");
		Matcher mobile_no_matcher=mobile_number_pattern.matcher(mobile_number);
		if(mobile_no_matcher.find())
			return true;
		return false;
	}
	
	public boolean validate_email_id(String email_id)
	{
		Pattern email_id_pattern=Pattern.compile("([a-z]{1,10})([@][a-z]{1,5}[.][a-z && (com)]{3})$");
		Matcher email_id_matcher=email_id_pattern.matcher(email_id);
		if(email_id_matcher.find())
			return true;
		return false;
	}
}
