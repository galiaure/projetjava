package com.humanbooster.jdbc.objects;

import java.sql.Date;

public class Basket {
	
	private int id;
	private String brand;
	private String color;
	private double price;
	private Date date;
	private User user;
	
	public Basket (String brand, String color, double price){
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	public Basket (int id, String brand, String color, double price){
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", brand=" + brand + ", color=" + color + ", price=" + price + ", date=" + date
				+ ", user=" + user + "]";
	}
}
