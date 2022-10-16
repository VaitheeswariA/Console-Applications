package theatre_ticket_booking;

import java.util.*;

public class Start_Booking extends Home_Page{
	public static void main(String[] args) {
		Start_Booking cinema = new Start_Booking();
		cinema.begin();

	}

	public void begin() {
		Scanner sc = new Scanner(System.in);
		Start_Booking book_ticket = new Start_Booking();
		book_ticket.updating_movies();
		System.out.println("Its time to entertain yourself with amazing movies...Enter and Explore\n");
		//Home_Page booking_details=new Home_Page();
		boolean lets_start = true;
		while (lets_start) {
			System.out.println("1.Login \n2.Movie info \n3.Exit\n");
			int start_with = sc.nextInt();
			switch (start_with) {
			case 1: {
						sc.nextLine();
						boolean isValid_email=false;
						while(!isValid_email)
						{
							System.out.println("User Name(Email_Id):");
							String email_id=sc.nextLine();
							isValid_email=book_ticket.validate_email_id(email_id);
							if(isValid_email)
								book_ticket.setEmail_id(email_id);
							else
								System.out.println("Invalid Email Id.....enter valid email id");
						}
						//sc.nextLine();
						boolean isValid_Contact=false;
						while(!isValid_Contact)
						{
							System.out.println("Mobile Number:");
							String mobile_number=sc.nextLine(); 
							isValid_Contact=book_ticket.validate_mobile_number(mobile_number);
							if(isValid_Contact)
								book_ticket.setmobile_number(mobile_number);
							else
								System.out.println("Invalid mobile number...enter valid mobile number");
						}
						
						book_ticket.home(book_ticket);
						
						
						/*String username=book_ticket.generate_username(email_id);
						System.out.println(book_ticket.generate_username(email_id));
						book_ticket.setName(username);
						System.out.println("Your username is "+username+"\n");
						*/
						
					}
				break;
				
			case 2:{
					System.out.println("*********Ponniyin Selvan****************");
					System.out.println("Rating : Most expected movie in Tamil Industry");
					System.out.println("------------------------------------------");
					System.out.println("* "+"upcoming Indian Tamil-language epic period action film directed by Mani Ratnam");
					System.out.println();
					
					System.out.println("*********Vendhu Thanindhadhu Kadu****************");
					System.out.println("Rating : good movie");
					System.out.println("------------------------------------------");
					System.out.println("* "+"The Kindling is a 2022 Indian Tamil-language gangster film directed by Gautham Vasudev Menon, written by B. Jeyamohan");
					System.out.println();
					
					System.out.println("*********Thiruchitrambalam****************");
					System.out.println("Rating : nice entertaining movie");
					System.out.println("------------------------------------------");
					System.out.println("* "+"Indian Tamil-language romantic comedy-drama film written and directed by Mithran R Jawahar.");
					System.out.println();
					
					System.out.println("*********Viruman****************");
					System.out.println("Rating : nice village movie");
					System.out.println("------------------------------------------");
					System.out.println("* "+"Indian Tamil-language village film written and directed by M. Muthaiah");
					System.out.println();
					
					
					}
				break;
			
			case 3:{
				lets_start=false;
				}
				break;
			default:
				{
					System.out.println("We are not providing the service......Sorry for this inconvenience..");
					System.out.println("Thank you for your Understanding....Kindly try our service mentioned above:)");
				}
			}
		}

	} 
	
}
