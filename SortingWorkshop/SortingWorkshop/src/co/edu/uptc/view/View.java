package co.edu.uptc.view;

import javax.swing.JOptionPane;

public class View {
	
	public String readData(String text) {
		String message = JOptionPane.showInputDialog(text);
		return message;
	}

	public void showInformation(String text) {
		JOptionPane.showMessageDialog(null, text);
	}
}