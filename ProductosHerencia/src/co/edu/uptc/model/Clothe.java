package co.edu.uptc.model;

public class Clothe extends Product{
	private String color;
	private int size;
	
	public Clothe(int barCode, int unitPrice, int amount, String color, int size) {
		super(barCode, unitPrice, amount);
		this.color = color;
		this.size = size;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
}
