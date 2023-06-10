package co.edu.uptc.view;

import java.util.Scanner;

public class ConsoleView implements Iview{
	private Scanner input = new Scanner(System.in);

	@Override
	public void showMessage(String message) {
		System.out.println(message);
		
	}

	@Override
	public String readString(String message) {
		showMessage(message);
		return input.nextLine();
	}

	@Override
	public int readInt(String message) {
		showMessage(message);
		return input.nextInt();
	}
	
	
}
