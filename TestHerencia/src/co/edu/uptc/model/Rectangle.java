package co.edu.uptc.model;

public class Rectangle {
	private int base;
	private int height;
	
	public Rectangle(int base, int height) {
		this.base = base;
		this.height = height;
	}
	
	public int perimeter() {
		return 2*base+2*height;
	}

	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
