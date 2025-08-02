package LibrarySystem;


import java.util.Objects;

public abstract class EX {
	
	protected double price;
	protected String ex_name;

	public EX(double price, String ex_name) {
		this.price = price;
		this.ex_name = ex_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getEx_name() {
		return ex_name;
	}
	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}
	
}
