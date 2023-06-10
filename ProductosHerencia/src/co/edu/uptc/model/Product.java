package co.edu.uptc.model;

public class Product {
	private int barCode;
	private int unitPrice;
	private int amount;
	
	public Product(int barCode, int unitPrice, int amount) {
		this.barCode = barCode;
		this.unitPrice = unitPrice;
		this.amount = amount;
	}
	
	public int getBarCode() {
		return barCode;
	}
	public void setBarCode(int barCode) {
		this.barCode = barCode;
	}
	public int getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
