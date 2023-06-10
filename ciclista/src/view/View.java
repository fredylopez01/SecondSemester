package view;

import javax.swing.JOptionPane;

public class View {
	
	public int readInt(String message) {
		int number = Integer.parseInt(JOptionPane.showInputDialog(message));
		return number;
	}
	
	public String readString(String message) {
		String answer =JOptionPane.showInputDialog(message);
		return answer;
	}
	
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
}