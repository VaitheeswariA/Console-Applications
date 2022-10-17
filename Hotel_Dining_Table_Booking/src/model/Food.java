package model;

public class Food {
	private int variety_Id;
	private String name;
	private int quantity;
	private double price;
	
	
	
	public int getVariety_Id() {
		return variety_Id;
	}
	public void setVariety_Id(int variety_Id) {
		this.variety_Id = variety_Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
