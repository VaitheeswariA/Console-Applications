package banking_application;

import java.util.*;
public class Start_Banking extends MyProfile{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HomePage homePageObj=new HomePage();
		homePageObj.begin();
	}
	
	public void begin()
	{
		HomePage banking_details=new HomePage();
		Account_Holder holder=new Account_Holder();
		Bank account=new Bank();
		banking_details.add_account(account);
		
		Scanner user_input=new Scanner(System.in);
		boolean isStarted=true;
		
		while(isStarted)
		{
			System.out.println("**********Welcome to the Most Safest Bank of India application***********");
			System.out.println("Choose any service to use our banking services......\n1.Create Account \n2.Login \n3.Exit \n");
			int starts_with=user_input.nextInt();
			user_input.nextLine();
			switch(starts_with)
			{
			case 1:
			{
				boolean isAccount_Created=false;
				while(!isAccount_Created)
				{
					System.out.println("Please enter your details to create account...");
					boolean isValid_name=false;
					while(!isValid_name)
					{
						System.out.print("Name :");
						String name=user_input.nextLine();
						isValid_name=account.validate_name(name);
						if(isValid_name)
							holder.setAccount_holder_name(name);
						else
							System.out.println("Name should contain only alphabets....Enter valid input");
					}
					boolean isValid_mobile_number=false;
					while(!isValid_mobile_number)
					{
						System.out.print("Mobile Number:");
						String mobile_number=user_input.nextLine();
						isValid_mobile_number=account.validate_mobile_number(mobile_number);
						if(isValid_mobile_number)
							holder.setMobile_number(mobile_number);
						else
							System.out.println("Invalid mobile number....please enter a valid mobile number");
					}
					boolean isValid_email_id=false;
					while(!isValid_email_id)
					{
						System.out.print("Email Id:");
						String email_id=user_input.nextLine();
						isValid_email_id=account.validate_email_id(email_id);
						if(isValid_email_id)
							holder.setemail_id(email_id);
						else
							System.out.println("Invalid email id....Enter a valid email id");
					}
					System.out.print("password :");
					String password=user_input.nextLine();
					if(account.create_account(holder))
					{
						System.out.println("Account created successfully..\nuser name :"+holder.getAccount_holder_name()+" \nAccount Number:"+holder.getAccount_number()+"\n Account balance :"+holder.getAccount_balance()+"\n");
						account.account_detail.put(holder.getemail_id(), holder);
						account.login_detail.put(holder.getemail_id(), password);
						isAccount_Created=true;
					}
					
				}
				System.out.println();
					
			}
			break;
			
			case 2:
			{
				System.out.print("Email id :");
				String current_user_email=user_input.nextLine();
				System.out.print("Psssword :");
				String current_user_password=user_input.nextLine();
				if(account.login_detail.get(current_user_email).equals(current_user_password))
				{
					banking_details.my_profile(current_user_email, current_user_password,account);
				}
				else
				{
					System.out.println("Incorrect user name or password");
				}
				 
				
			}
			break;
			
			case 3:
			{
				isStarted=false;
			}
			break;
			
			default:
			{
				System.out.println("We are not providing this service...please try our service mentioned below...\n");
			}
			}
		}
	}

}
