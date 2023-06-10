package co.edu.uptc.model;

public class Square extends Rectangle{
	private int side;

	public Square(int side) {
		super(side, side);
		this.side = side;
	}
	
	public int area() {
		return side*side;
	}
}
