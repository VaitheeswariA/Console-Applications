package model;

import java.time.LocalDateTime;

public class Transaction_Data {

	private String book_id;
	private String membership_id;
	private LocalDateTime borrowed_date;
	private boolean is_returned;
	private LocalDateTime return_due_Date;
	private LocalDateTime returned_date;
	private boolean is_fined;
	private double fine_amount;
	private boolean is_paid;
	private LocalDateTime fined_date;
	private LocalDateTime fine_due_date;
	private LocalDateTime fine_paid_date;
	private boolean is_live;
	
	
	public Transaction_Data(String b_id,String mem_id,LocalDateTime borrowed_dt,LocalDateTime return_due_dt,boolean returned_book,LocalDateTime returned_dt,boolean fined,double fine_amt,boolean paid,LocalDateTime fined_dt,LocalDateTime fine_due_dt,LocalDateTime fine_paid_dt,boolean live)
	{
		book_id=b_id;
		membership_id =mem_id;
		borrowed_date = borrowed_dt;
		return_due_Date=return_due_dt;
		is_returned=returned_book;
		returned_date=returned_dt;
		is_fined=fined;
		fine_amount=fine_amt;
		is_paid=paid;
		fined_date=fined_dt;
		fine_due_date=fine_due_dt;
		fine_paid_date=fine_paid_dt;
		is_live=live;
	}

	
	

	public boolean isIs_live() {
		return is_live;
	}




	public void setIs_live(boolean is_live) {
		this.is_live = is_live;
	}




	public boolean getIs_returned() {
		return is_returned;
	}




	public void setIs_returned(boolean is_returned) {
		this.is_returned = is_returned;
	}




	public String getBook_id() {
		return book_id;
	}


	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}


	public String getMembership_id() {
		return membership_id;
	}


	public void setMembership_id(String membership_id) {
		this.membership_id = membership_id;
	}


	public LocalDateTime getBorrowed_date() {
		return borrowed_date;
	}


	public void setBorrowed_date(LocalDateTime borrowed_date) {
		this.borrowed_date = borrowed_date;
	}


	public LocalDateTime getReturn_due_Date() {
		return return_due_Date;
	}


	public void setReturn_due_Date(LocalDateTime return_due_Date) {
		this.return_due_Date = return_due_Date;
	}


	public LocalDateTime getReturned_date() {
		return returned_date;
	}


	public void setReturned_date(LocalDateTime returned_date) {
		this.returned_date = returned_date;
	}


	public boolean isIs_fined() {
		return is_fined;
	}


	public void setIs_fined(boolean is_fined) {
		this.is_fined = is_fined;
	}


	public double getFine_amount() {
		return fine_amount;
	}


	public void setFine_amount(double fine_amount) {
		this.fine_amount = fine_amount;
	}


	public boolean Is_paid() {
		return is_paid;
	}


	public void setIs_paid(boolean is_paid) {
		this.is_paid = is_paid;
	}


	public LocalDateTime getFined_date() {
		return fined_date;
	}


	public void setFined_date(LocalDateTime fined_date) {
		this.fined_date = fined_date;
	}


	public LocalDateTime getFine_due_date() {
		return fine_due_date;
	}


	public void setFine_due_date(LocalDateTime fine_due_date) {
		this.fine_due_date = fine_due_date;
	}


	public LocalDateTime getFine_paid_date() {
		return fine_paid_date;
	}


	public void setFine_paid_date(LocalDateTime fine_paid_date) {
		this.fine_paid_date = fine_paid_date;
	}
	
	
	
	
	
	

}
