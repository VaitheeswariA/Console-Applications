package model;

import java.util.*;

public class Library_Db {
	
	public ArrayList<User> user_detail =new ArrayList<>();
	public ArrayList<Book> book_detail =new ArrayList<>();
 	public ArrayList<Transaction_Data> transaction_details =new ArrayList<>();;
 	
 	
 	
 	//User
 	public void insertUserDetail(ArrayList<User> users_detail)
 	{
 		this.user_detail.addAll(users_detail);
 	}
 	
 	public void insertUserDetail(User user_detail)
 	{
 		this.user_detail.add(user_detail);
 	}
 	
 	public ArrayList<User> getUserDetail()
 	{
 		return this.user_detail;
 	}
 	
 	//Book
 	public void insertBookDetail(ArrayList<Book> books_detail)
 	{
 		this.book_detail.addAll(books_detail);
 	}
 	
 	public void insertBookDetail(Book book_detail)
 	{
 		this.book_detail.add(book_detail);
 	}
 	
 	public ArrayList<Book> getBookDetail()
 	{
 		return this.book_detail;
 	}
 	
 	//Transaction_Data
 	public void insertTransactionDetail(ArrayList<Transaction_Data> transactions_detail)
 	{
 		this.transaction_details.addAll(transactions_detail);
 	}
 	
 	public void insertTransactionDetail(Transaction_Data transaction_detail)
 	{
 		this.transaction_details.add(transaction_detail);
 	}
 	
 	public ArrayList<Transaction_Data> getTransactionDetail()
 	{
 		return this.transaction_details;
 	}

}
