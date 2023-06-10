package co.edu.uptc.model;

public class Circunference implements IFigure{
	private double radio;
	
	public Circunference(double radio) {
		this.radio = radio;
	}
	
	public double area() {
		return PI*Math.pow(radio, 2);
	}

}
