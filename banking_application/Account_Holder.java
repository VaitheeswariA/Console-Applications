package banking_application;

public class Account_Holder extends Bank{
	private String account_holder_name;
	private String mobile_number;
	private String email_id;
	private String account_number;
	private double account_balance;
	private double credited_amount;
	private double debited_amount;
	private String reason;
	
	Account_Holder()
	{
		
	}
	
	Account_Holder(String name,String mobile,String mail,String acc_number,double balance,double credited,double debited,String state_reason)
	{
		account_holder_name=name;
		mobile_number=mobile;
		email_id=mail;
		account_number=acc_number;
		account_balance=balance;
		credited_amount=credited;
		debited_amount=debited;
		reason=state_reason;
	}
	
	
	public String getAccount_holder_name() {
		return account_holder_name;
	}
	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	public String getemail_id() {
		return email_id;
	}
	public void setemail_id(String email_id) {
		this.email_id = email_id;
	}
	
	public double getcredited_amount() {
		return credited_amount;
	}
	public void setcredited_amount(double credited_amount) {
		this.credited_amount = credited_amount;
	}
	
	public double getdebited_amount() {
		return debited_amount;
	}
	public void setdebited_amount(double debited_amount) {
		this.debited_amount = debited_amount;
	}

	public String getreason() {
		return reason;
	}
	public void setreason(String reason) {
		this.reason = reason;
	}
	
	
}
