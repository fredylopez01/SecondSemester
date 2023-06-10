package co.edu.uptc.view;

import javax.swing.JOptionPane;

public class View {
	public int readInt(String message) {
		return Integer.parseInt(JOptionPane.showInputDialog(message));
	}
	
	public char readChar(String message) {
		return JOptionPane.showInputDialog(message).charAt(0);
	}
	
	public String readString(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
}