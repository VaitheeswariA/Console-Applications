package banking_application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class Bank {
	
		Scanner user_input=new Scanner(System.in);
		
		LinkedHashMap<String,Account_Holder> account_detail=new LinkedHashMap<>();
		LinkedHashMap<String,String> login_detail=new LinkedHashMap<>();
		LinkedHashMap<String,ArrayList<Account_Holder>> linked_accounts=new LinkedHashMap<>();
		public static String bank_code="MSBI";
		public static String branch_code="20220900";
		public static String ifsc_code="MSBI002022";
		public static int account_number_counter=6;
	
		
		
		public void add_account(Bank account)
		{
			account.account_detail.put("vaithees@gmail.com",new Account_Holder("vaithees","9999999999","vaithees@gmail.com","202209001",20000.00,10000.00,0.00,"Credited money"));
			account.account_detail.put("arul@gmail.com",new Account_Holder("arul","8888888888","arul@gmail.com","202209002",27000.00,0.00,5000.00,"Debited money"));
			account.account_detail.put( "thavanesh@gmail.com",new Account_Holder("thavanesh","9898989898","thavanesh@gmail.com","202209003",25000.00,15000.00,0.00,"Credited money"));
			account.account_detail.put("mathi@gmail.com",new Account_Holder("mathi","9797979797","mathi@gmail.com","202209004",30000.00,10000.00,0.00,"Credited money"));
			account.account_detail.put("ashwin@gmail.com",new Account_Holder("ashwin","7979797979","ashwin@gmail.com","202209005",40000.00,0.00,10000.00,"Debited money"));
			 
			 
			account.login_detail.put("vaithees@gmail.com", "9999999999");
			account.login_detail.put("arul@gmail.com", "8888888888");
			account.login_detail.put("thavanesh@gmail.com", "9898989898");
			account.login_detail.put("mathi@gmail.com", "9797979797");
			account.login_detail.put("ashwin@gmail.com", "7979797979");
			
			account.linked_accounts.put("vaithees@gmail.com",new ArrayList<>(Arrays.asList(account.account_detail.get("arul@gmail.com"),account.account_detail.get("thavanesh@gmail.com"),account.account_detail.get("mathi@gmail.com"),account.account_detail.get("ashwin@gmail.com"))));
			account.linked_accounts.put("arul@gmail.com",new ArrayList<>(Arrays.asList(account.account_detail.get("vaithees@gmail.com"),account.account_detail.get("thavanesh@gmail.com"),account.account_detail.get("mathi@gmail.com"),account.account_detail.get("ashwin@gmail.com"))));
			account.linked_accounts.put("mathi@gmail.com",new ArrayList<>(Arrays.asList(account.account_detail.get("vaithees@gmail.com"),account.account_detail.get("thavanesh@gmail.com"),account.account_detail.get("arul@gmail.com"),account.account_detail.get("ashwin@gmail.com"))));
		}
		
		public boolean create_account(Account_Holder holder)
		{
			boolean isUser_exist=false;
			if(login_detail.containsKey(holder.getemail_id()))
			{
				isUser_exist=true;
			}
			
			if(!isUser_exist)
			{
				holder.setAccount_number(branch_code+(account_number_counter++));
				System.out.println("Deposting initial amount to the account......\n");
				holder.setAccount_balance(1000.00);
				holder.setcredited_amount(1000.00);
				holder.setdebited_amount(0.00);
				holder.setreason("Credited:Initial account creation amount");
			}
			else
				System.out.println("User already exist with the given email id.....");
			return (!isUser_exist);
		}
		
		
		public void bank_statement(String email_id,Bank account)
		{
			int serial_no=0;
			String reason=account.account_detail.get(email_id).getreason();
			double amount=(account.account_detail.get(email_id).getcredited_amount()>0)? account.account_detail.get(email_id).getcredited_amount():account.account_detail.get(email_id).getdebited_amount();
			System.out.println("Account Number:"+account_detail.get(email_id).getAccount_number());
			System.out.println("Account Holder:"+account_detail.get(email_id).getAccount_holder_name());
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-45s %-20s","S.No","Credited/Debited reason","Credited/Debited amount");
			System.out.println();
			System.out.println("----------------------------------------------------------------------------------------");
			System.out.printf("%-5s %-45s %-20s",(++serial_no),reason,amount);
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------------");
			System.out.printf("%-50s %-20s","Account Balance",account.account_detail.get(email_id).getAccount_balance());
			System.out.println();
			System.out.println("------------------------------------------------------------------------------------------");
		}
		
		public void deposit_amount(double amount,String email_id,Bank account)
		{
			Account_Holder each_detail=account_detail.get(email_id);
			each_detail.setAccount_balance(each_detail.getAccount_balance()+amount);
			each_detail.setreason("Self deposite");
			each_detail.setcredited_amount(amount);
			each_detail.setdebited_amount(0.00);
			System.out.println("\nAmount deposited successfully to your account\n");
			account.bank_statement(email_id, account);
		}
		
		public void withdraw_amount(double amount,String email_id,Bank account)
		{
			Account_Holder each_detail=account_detail.get(email_id);
			if(each_detail.getAccount_balance()>=(amount+500))
			{
				each_detail.setAccount_balance(each_detail.getAccount_balance()-amount);
				each_detail.setcredited_amount(0.00);
				each_detail.setdebited_amount(amount);
				each_detail.setreason("Withdraw money");
				System.out.println("********Collect your cash*********");
				System.out.println("Transaction completed successfully......");
			}
			else if (each_detail.getAccount_balance()>=amount && each_detail.getAccount_balance()<(amount+500))
			{
				each_detail.setAccount_balance(each_detail.getAccount_balance()-amount);
				each_detail.setcredited_amount(0.00);
				each_detail.setdebited_amount(amount);
				each_detail.setreason("Withdraw money");
				System.out.println("Please maintain minimum balance of 500 rupees....\n");
				System.out.println("Your current account balance is"+each_detail.getAccount_balance());
			}
			else
			{
				System.out.println("Sorry!....insufficient balance...\n");
				System.out.println("Your current account balance is"+each_detail.getAccount_balance());
			}
			System.out.println();
			
		}
		
		public ArrayList<Account_Holder> show_linked_accounts(String email_id,Bank account)
		{
			ArrayList<Account_Holder> receivers_accounts=account.linked_accounts.get(email_id);
			if(receivers_accounts==null)
			{
				System.out.println("You have not linked any accounts....");
			}
			else
			{
				int serial_no=0;
				System.out.println("\nLinked accounts to transfer money");
				System.out.println("------------------------------------------------------");
				System.out.println("Bank Name:"+"Safest Bank of India");
				System.out.println("IFSC Code:"+Bank.ifsc_code);
				System.out.println("-------------------------------------------------------");
				System.out.printf("%-5s %-20s %-25s","S.No","Account Number","Account Holder Name");
				System.out.println("\n--------------------------------------------------------");
				for(int index=0;index<receivers_accounts.size();index++)
				{
					System.out.printf("%-5s %-20s %-25s",(++serial_no),receivers_accounts.get(index).getAccount_number(),receivers_accounts.get(index).getAccount_holder_name());
					System.out.println();
				}
				System.out.println("\n--------------------------------------------------------");
				System.out.println();
			}
			return receivers_accounts;
		}
		
		
		public void transfer_amount(String my_email,String receiver_email,String account_no,String ifsc_code,double amount,Bank account)
		{	
			Account_Holder sender_account_detail=account.account_detail.get(my_email);
			Account_Holder receiver_account_detail=account.account_detail.get(receiver_email);
			
			
			if(sender_account_detail.getAccount_balance()>=amount)
			{
				//sender account update
				sender_account_detail.setAccount_balance(sender_account_detail.getAccount_balance()-amount);
				sender_account_detail.setdebited_amount(amount);
				sender_account_detail.setreason("Transferred Money to "+receiver_account_detail.getAccount_holder_name());
				sender_account_detail.setcredited_amount(0.00);
				
				//reciever account update
				receiver_account_detail.setAccount_balance(receiver_account_detail.getAccount_balance()+amount);
				receiver_account_detail.setcredited_amount(amount);
				receiver_account_detail.setreason("Credited Money from "+sender_account_detail.getAccount_holder_name());
				receiver_account_detail.setdebited_amount(0.00);
				System.out.println("Amount transferred successfully.......");
			}
			else
			{
				System.out.println("Sorry!.....Insufficient balance to transfer amount....");
			}
			System.out.println();
		}
		
		
		//Validation part
	
		public boolean validate_name(String name)
		{
			Pattern name_pattern=Pattern.compile("[a-z]{1,20}");
			Matcher name_matcher=name_pattern.matcher(name);
			if(name_matcher.find())
				return true;
			return false;
		}
		
		
		public boolean validate_mobile_number(String mobile_number)
		{
			Pattern mobile_number_pattern =Pattern.compile("(0||91)?[6-9][0-9]{9}");
			Matcher mobile_number_matcher=mobile_number_pattern.matcher(mobile_number);
			if(mobile_number_matcher.find())
				return true;
			return false;
		}
		
		public boolean validate_email_id(String email_id)
		{
			Pattern email_id_pattern =Pattern.compile("([a-z]{1,15})([@][a-z]{1,5}[.][a-z && (com)]{3})");
			Matcher email_id_matcher=email_id_pattern.matcher(email_id);
			if(email_id_matcher.find())
				return true;
			return false;
		}

}
