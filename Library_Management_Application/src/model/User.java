package model;

public class User {
	private String email_id;
	private String password;
	private String mobile_number;
	private boolean is_member;
	private String membership_id;
	private String name;
	private String admin_notification;
	private String raised_request;
	
	public static String library_code="LM20220";
	public static int counter=6;
	public User()
	{
		
	}
	public User(String mail,String user_password,String user_name,String mobile,boolean ismember,String member_id,String notification,String pending)
	{
		email_id=mail;
		password=user_password;
		name=user_name;
		mobile_number=mobile;
		is_member=ismember;
		membership_id=member_id;
		admin_notification=notification;
		raised_request=pending;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	public boolean isIs_member() {
		return is_member;
	}
	public void setIs_member(boolean is_member) {
		this.is_member = is_member;
	}
	public String getMembership_id() {
		return membership_id;
	}
	public void setMembership_id(String membership_id) {
		this.membership_id = membership_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNotification() {
		return admin_notification;
	}
	public void setNotification(String notification) {
		this.admin_notification = notification;
	}
	public String getRaised_request() {
		return raised_request;
	}
	public void setRaised_request(String raised_request) {
		this.raised_request = raised_request;
	}
	
	
	
	
}
