package co.edu.uptc.model;

public class Square {
	private int side;

	public Square(int side) {
		this.side = side;
	}
	
	public int calculateArea() {
		return side * side;
	}

}
