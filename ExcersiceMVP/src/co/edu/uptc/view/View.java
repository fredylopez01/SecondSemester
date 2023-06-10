package co.edu.uptc.view;

import java.util.Scanner;

public class View {
	private Scanner input;
	
	public View() {
		input = new Scanner(System.in);
	}
	
	public int readInt(String message) {
		System.out.println(message);
		return Integer.parseInt(input.nextLine());
	}
	
	public void showMessage(String message) {
		System.out.println(message);
	}
}
