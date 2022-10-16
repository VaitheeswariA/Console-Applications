package banking_application;

import java.util.*;
public class MyProfile extends Bank{
	Scanner input=new Scanner(System.in);
	public void my_profile(String email_id,String password,Bank account)
	{
		boolean go_to_submenu=true;
		while(go_to_submenu)
		{
			System.out.println("************************WISH YOU SAFEST BANKING********************************");
			System.out.println("Choose any service to start exploring our services \n1.Check Balance or Bank Statement \n2.Deposite amount \n3.Withdraw amount \n4.Transfer amount \n5.Logout");
			int explore_with=input.nextInt();
			switch(explore_with)
			{
			case 1:
			{
				account.bank_statement(email_id,account);
			}
			break;
			
			case 2:
			{
				System.out.println("Enter amount to deposit to your account");
				account.deposit_amount(input.nextDouble(),email_id,account);
			}
			break;
			
			case 3:
			{
				System.out.println("Enter amount to withdraw from your account");
				account.withdraw_amount(input.nextDouble(), email_id, account);
			}
			break;
			
			case 4:
			{
				
				ArrayList<Account_Holder> linked_receivers=account.show_linked_accounts(email_id, account);
				if(linked_receivers==null)
				{
					System.out.println("Please provide account details to transfer amount.........");
					System.out.print("Account Holder user name(email_Id ):");
					input.nextLine();
					String receiver_name=input.nextLine();
					System.out.print("Account Number :");
					String receiver_account_number=input.nextLine();
					System.out.print("IFSC Code :");
					String receivers_ifsc_code=input.nextLine();
					System.out.print("Enter amount to transfer:");
					double amount=input.nextDouble();
					account.transfer_amount(email_id, receiver_name, receiver_account_number, receivers_ifsc_code, amount, account);
				}
				else
				{
					System.out.println("Choose account to transfer amount..");
					int user_choice=input.nextInt();
					System.out.println("Enter amount to transfer :");
					double amount=input.nextDouble();
					for(int index=0;index<linked_receivers.size();index++)
					{
						if((user_choice)==(index+1))
						{
							account.transfer_amount(email_id,linked_receivers.get(index).getemail_id() , linked_receivers.get(index).getAccount_number(),Bank.ifsc_code,amount, account);
						}
					}
				}
				
			}
			break;
			
			case 5:
			{
				go_to_submenu=false;
			}
			break;
			
			default:
			{
				System.out.println("We are not providing this service...please try our service mentioned below...");
			}
			}
		}
		
	}
}
