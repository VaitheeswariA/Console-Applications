package theatre_ticket_booking;

public class User extends Theatre{
	private String email_id;
	private String name;
	private String mobile_number;
	private int selected_screen;
	private String booked_movie;
	private int booked_ticket_count;
	private double bill_amount;
	private String booked_show_time;
	
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getmobile_number() {
		return mobile_number;
	}
	public void setmobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	public String getbooked_movie() {
		return booked_movie;
	}
	public void setbooked_movie(String booked_movie) {
		this.booked_movie = booked_movie;
	}
	
	public int getselected_screen() {
		return selected_screen;
	}
	public void setselected_screen(int selected_screen) {
		this.selected_screen = selected_screen;
	}
	
	public int getbooked_ticket_count() {
		return booked_ticket_count;
	}
	public void setbooked_ticket_count(int booked_ticket_count) {
		this.booked_ticket_count = booked_ticket_count;
	}
	
	public double getbill_amount() {
		return bill_amount;
	}
	public void setbill_amount(double bill_amount) {
		this.bill_amount = bill_amount;
	}
	
	public String getbooked_show_time() {
		return booked_show_time;
	}
	public void setbooked_show_time(String booked_show_time) {
		this.booked_show_time = booked_show_time;
	}
}
