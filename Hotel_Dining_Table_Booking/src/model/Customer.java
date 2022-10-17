package model;

public class Customer {
	private String customer_Name;
	private String customer_Mobile;
	private int selected_table_no;
	Double bill_amount = 0.00;
	public int customer_id;
	
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_Name() {
		return customer_Name;
	}
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	public String getCustomer_Mobile() {
		return customer_Mobile;
	}
	public void setCustomer_Mobile(String customer_Mobile) {
		this.customer_Mobile = customer_Mobile;
	}
	public int getSelected_table_no() {
		return selected_table_no;
	}
	public void setSelected_table_no(int selected_table_no) {
		this.selected_table_no = selected_table_no;
	}
	public Double getBill_amount() {
		return bill_amount;
	}
	public void setBill_amount(Double bill_amount) {
		this.bill_amount = bill_amount;
	}
	
	
}
