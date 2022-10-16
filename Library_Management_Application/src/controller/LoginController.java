package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Admin;
import model.Library_Db;
import model.User;
public class LoginController {
	public boolean check_admin(Admin admin_detail,String user_name,String password)
	{
		return (admin_detail.getEmail_id().equals(user_name)) && (admin_detail.getPassword().equals(password));
	}
	
	public boolean check_user(Library_Db db,String email,String password)
	{
		for(int index=0;index<db.user_detail.size();index++)
		{
			if(db.user_detail.get(index).getEmail_id().equals(email) && db.user_detail.get(index).getPassword().equals(password))
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	//Validation
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
