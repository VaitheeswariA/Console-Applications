package model;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

public class Admin {

	private String email_id ;
	private String password;
	private String name;
	private String mobile_number;
	public LinkedHashMap<String,String> pending_request=new LinkedHashMap<>();
	public LinkedHashMap<String,Transaction_Data> user_notification=new LinkedHashMap<>();
	private String notify_message;
	
	
	public Admin()
	{
		email_id="admin@gmail.com";
		password="admin";
		name="Vaitheeswari";
		mobile_number="9876543210";
		pending_request.put("arul@gmail.com", "Membership request");
		LocalDateTime current_date=LocalDateTime.now();
		user_notification.put("LM202201", new Transaction_Data("LB2","LM202201",current_date,current_date.plusDays(7),false,null,false,0.00,false,null,null,null,true));
		notify_message="Borrowed book";
	}
	
	
	
	
	public String getNotify_message() {
		return notify_message;
	}




	public void setNotify_message(String notify_message) {
		this.notify_message = notify_message;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	
	
	

}
