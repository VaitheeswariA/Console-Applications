package model;

public class Book {
	private String book_id;
	private String book_name;
	private String book_author;
	private String book_edition;
	private String book_publication;
	private String book_genre;
	private boolean book_availability;
	private String book_status;
	private String book_language;
	public static String book_code="LB";
	public static int book_counter=9;
	
	public Book(String id,String name,String author,String edition,String publication,String genre,boolean availability,String status,String lang)
	{
		book_id=id;
		book_name=name;
		book_author=author;
		book_edition=edition;
		book_publication=publication;
		book_genre=genre;
		book_availability=availability;
		book_status=status;
		book_language=lang;
	}
	
	


	public String getBook_language() {
		return book_language;
	}
	public void setBook_language(String book_language) {
		this.book_language = book_language;
	}

	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_edition() {
		return book_edition;
	}
	public void setBook_edition(String book_edition) {
		this.book_edition = book_edition;
	}
	public String getBook_publication() {
		return book_publication;
	}
	public void setBook_publication(String book_publication) {
		this.book_publication = book_publication;
	}
	public String getBook_genre() {
		return book_genre;
	}
	public void setBook_genre(String book_genre) {
		this.book_genre = book_genre;
	}
	public boolean isBook_availability() {
		return book_availability;
	}
	public void setBook_availability(boolean book_availability) {
		this.book_availability = book_availability;
	}
	public String getBook_status() {
		return book_status;
	}
	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
	
	
	
}
