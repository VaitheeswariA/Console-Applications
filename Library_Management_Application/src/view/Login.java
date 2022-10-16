package view;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.AdminProcess;
import controller.LoginController;
import controller.UserProcess;
import model.Admin;
import model.Library_Db;
import model.User;


public class Login extends AdminPage{

	public static void main(String[] args) {
		Login start=new Login();
		start.begin(start);
	}
	

	public void begin(Login start)
	{
		LoginController login=new LoginController();
		Admin admin_detail=new Admin();
		User user_detail=new User();
		AdminProcess admin_process=new AdminProcess();
		UserProcess user_process=new UserProcess();
		Library_Db db=new Library_Db();
		admin_process.addBooks(db);
		
		Scanner user_input=new Scanner(System.in);
		System.out.println("***********Welcome to the source of knowledge********");
		boolean lets_start=true;
		
		while(lets_start)
		{
			System.out.println("1.Admin Login \n2.User Login \n3.New member?Sign up \n4.Exit");
			int start_choice=user_input.nextInt();
			switch(start_choice)
			{
			case 1:
			{
				user_input.nextLine();
				boolean isValid=false;
				while(!isValid)
				{
					System.out.print("Email Id:");
					String email=user_input.nextLine();
					System.out.print("Password :");
					String password =user_input.nextLine();
					isValid=login.check_admin(admin_detail,email,password);
					
					if(isValid)start.HomePage(admin_detail,admin_process,db);
					else System.out.println("Invalid username or password...enter correct details");		
				}
				
			}
			break;
			
			case 2:
			{
				user_input.nextLine();
				boolean isValidUser=false;
				while(!isValidUser)
				{
					System.out.print("Email Id:");
					String email=user_input.nextLine();
					System.out.print("Password :");
					String password =user_input.nextLine();
					isValidUser=login.check_user(db,email,password);
					
					if(isValidUser)start.user_HomePage(db,user_process,admin_detail,email);
					else System.out.println("Invalid username or password...enter correct details");
						
				}
			}
			break;
			
			case 3:
			{
				System.out.println("Enter details to create membership in this library");
				System.out.print("Name :");
				String name=user_input.nextLine();
				user_input.nextLine();
				System.out.print("Email Id :");
				String email=user_input.nextLine();
				System.out.println("Create Password :");
				String password=user_input.nextLine();
				System.out.println("Mobile Number :");
				String mobile=user_input.nextLine();
				boolean is_existing_user=user_process.check_existing_user(email,db);
				if(is_existing_user)
					System.out.println("You are already have account...please proceed with sign in");
				else
				{
					//User(String mail,String user_password,String user_name,String mobile,boolean ismember,String member_id,String notification,String pending)
					db.insertUserDetail(new User(email,password,name,mobile,true,(User.library_code+(++User.counter)),"Accepted Membership request",""));
					System.out.println("Account created successfully");
				}
				
			}
			break;
			
			case 4:
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
