package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public boolean validate_mobile_number(String mobile_number)
	{
		Pattern mobile_number_pattern=Pattern.compile("(0||91)?[6-9][0-9]{9}");
		Matcher mobile_no_matcher=mobile_number_pattern.matcher(mobile_number);
		if(mobile_no_matcher.find())
			return true;
		return false;
	}
	
	public boolean validate_name(String name)
	{
		Pattern name_pattern=Pattern.compile("[a-z]{4,30}");
		Matcher name_matcher=name_pattern.matcher(name);
		if(name_matcher.find())
			return true;
		return false;
	}
}
