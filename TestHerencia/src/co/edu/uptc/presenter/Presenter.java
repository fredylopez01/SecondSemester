package co.edu.uptc.presenter;

import co.edu.uptc.model.Square;
import co.edu.uptc.view.View;

public class Presenter {
	private Square squareTest;
	private View viewTest;
	
	public Presenter() {
		viewTest = new View();
		squareTest = new Square(viewTest.readInt("Ingrese cuanto mide el lado del cuadrado"));
	}
	
	public void run() {
		viewTest.showMessage("El perimetro de su cuadrado es: " + squareTest.perimeter() + "\nEl area: " + squareTest.area());
	}
	
	public static void main (String []args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
}
