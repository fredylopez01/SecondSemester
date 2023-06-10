package co.edu.uptc.model;

public class Triangle extends Polygon implements IFigure{
	private double sideOne;
	private double sideTwo;
	private double sideThree;

	public Triangle(double sideOne, double sideTwo, double sideThree) {
		this.sideOne = sideOne;
		this.sideTwo = sideTwo;
		this.sideThree = sideThree;
	}
	
	public double perimeter() {
		return sideOne + sideTwo + sideThree;
	}

	public double area() {
		double s = (sideOne+sideTwo+sideThree)/2;
        return Math.sqrt(s*(s-sideOne)*(s-sideTwo)*(s-sideThree));
	}

	public double getSideOne() {
		return sideOne;
	}

	public void setSideOne(int sideOne) {
		this.sideOne = sideOne;
	}

	public double getSideTwo() {
		return sideTwo;
	}

	public void setSideTwo(int sideTwo) {
		this.sideTwo = sideTwo;
	}

	public double getSideThree() {
		return sideThree;
	}

	public void setSideThree(int sideThree) {
		this.sideThree = sideThree;
	}
	
}
