package presenter;

import java.util.Scanner;
import model.Square;
import co.edu.uptc.view.View;

public class Test {
	private Scanner input;
	private View bView;
	
	public void test() {
		input = new Scanner(System.in);
		bView = new View();
	}
	
	public void run() {
		int side = bView.readInt("Ingrese el valor del lado del cuadrado");
		Square square = new Square(side);
		int area = square.calculateArea();
		bView.showMessage("El area del cuadrado es: " + area);
	}

	public static void main(String[] args) {
		Test verify = new Test();
		verify.test();
		verify.run();
	}

}
