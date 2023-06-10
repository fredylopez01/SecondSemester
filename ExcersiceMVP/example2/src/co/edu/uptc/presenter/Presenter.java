package co.edu.uptc.presenter;

import co.edu.uptc.model.Square;
import co.edu.uptc.view.View;

public class Presenter {
	private View view;
	
	public Presenter() {
		view = new View();
	}
	
	public void run() {
		view.showMessage("digite lado ");
		int side = Integer.parseInt(view.readData());
		Square square = new Square(side);
		int area = square.calculateArea();
		view.showMessage("el area es " + area);
	}
	
	public static void main(String[] args) {
		Presenter test = new Presenter();
		test.run();
	}

}
