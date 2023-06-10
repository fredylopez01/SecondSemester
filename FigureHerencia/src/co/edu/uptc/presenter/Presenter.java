package co.edu.uptc.presenter;

import co.edu.uptc.model.Circunference;
import co.edu.uptc.model.Equilateral;
import co.edu.uptc.model.Escalene;
import co.edu.uptc.model.Isosceles;
import co.edu.uptc.model.Rectangle;
import co.edu.uptc.model.Square;
import co.edu.uptc.model.Triangle;
import co.edu.uptc.view.View;

public class Presenter {
	private Rectangle rectangleTest;
	private Triangle triangleTest;
	private Circunference circunferenceTest;
	private View viewTest;
	
	public Presenter() {
		viewTest = new View();
	}
	
	public static void main (String []args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
	
	public void run() {
		int option = viewTest.readInt("Que figura desea hacer:\n1.Rectangulo\n2.Triangulo");
		if(option == 1) {
			rectangleTest = new Square(viewTest.readInt("Ingrese cuanto mide un lado"));
			viewTest.showMessage("El perimetro de su cuadrado es: " + rectangleTest.perimeter() + "\nEl area: " + rectangleTest.area());
		} else if(option == 2) {
			int tipeTriangle = viewTest.readInt("Que tipo de triangulo dese hacer:\n1.Equilatero\n2.Isosceles\n3.Escaleno");
			if(tipeTriangle == 1) {
				triangleTest = triangleEquilateral();
				viewTest.showMessage("El perimetro de su triangulo es: " + triangleTest.perimeter() + "\nEl area: " + Math.round(triangleTest.area()*100)/100d);
			} else if(tipeTriangle == 2) {
				triangleTest = triangleIsosceles();
				viewTest.showMessage("El perimetro de su triangulo es: " + triangleTest.perimeter() + "\nEl area: " + Math.round(triangleTest.area()*100)/100d);
			} else if(tipeTriangle == 3) {
				triangleTest = triangleEscalene();
				viewTest.showMessage("El perimetro de su triangulo es: " + triangleTest.perimeter() + "\nEl area: " + Math.round(triangleTest.area()*100)/100d);
			}
		} else if(option == 3) {
			circunferenceTest = new Circunference(viewTest.readInt("Ingrese cuanto mide el readio"));
			viewTest.showMessage("El area del circulo es: " + circunferenceTest.area());
		}
	}
	
	public Equilateral triangleEquilateral() {
		int side = viewTest.readInt("Cuanto miden un lado");
		Equilateral equilateralTest = new Equilateral(side);
		return equilateralTest;
	}
	
	public Isosceles triangleIsosceles() {
		int sideOne = viewTest.readInt("Ingrese cuanto vale el lado diferente a los otros dos");
		int sideTwo = viewTest.readInt("Ingrese el valor de los dos laos que miden igual");
		Isosceles isoscelesTest = new Isosceles(sideOne, sideTwo);
		return isoscelesTest;
	}
	
	public Escalene triangleEscalene() {
		int sideOne = viewTest.readInt("Cuanto mide un lado");
		int isdeTwo = viewTest.readInt("Cuanto mide el otro lado");
		int isdeThree = viewTest.readInt("Cuanto mide el tercer lado lado");
		Escalene escaleneTest = new Escalene(sideOne, isdeTwo, isdeThree);
		return escaleneTest;
	}
}
