package object;

public class Basket {
	private String brand;
	private String color;
	private int price;
	private String login;

	public Basket(String brand,String color,int price,String login) {
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.login = login;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "Basket [brand=" + brand + ", color=" + color + ", price=" + price + ", login=" + login + "]";
	}
	
	

}
