package hb.pojos;

import java.util.Date;

import hb.utils.DateManager;

public class Flower {
	
	private int id;
	private String name;
	private String description;
	private Date expiryDate;
	private String color;
	
	public Flower(int id, String name, String description, Date expiryDate, String color){
		this.id = id;
		this.name = name;
		this.description = description;
		this.color = color;
		this.expiryDate = expiryDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Flower [id=" + id + ", name=" + name + ", description=" + description + ", expiryDate=" + DateManager.transformDateToString(expiryDate)
				+ ", color=" + color + "]";
	}
}
