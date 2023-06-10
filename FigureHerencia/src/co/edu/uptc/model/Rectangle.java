package co.edu.uptc.model;

public class Rectangle extends Polygon implements IFigure{
	private double base;
	private double height;
	
	public Rectangle(double base, double height) {
		this.base = base;
		this.height = height;
	}
	
	public double perimeter() {
		return 2*base+2*height;
	}
	
	public double area() {
		return base*height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
}
