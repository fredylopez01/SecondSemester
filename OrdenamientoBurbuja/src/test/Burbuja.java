package test;

import javax.swing.JOptionPane;

public class Burbuja {
	public int[] myArrayOne;
	
	public void startValues() {
		myArrayOne = new int[50];
		for(int i = 0; i < myArrayOne.length; i++) {
			myArrayOne[i] = (int)(Math.random()*(1000)+1);
		}
		for(int i = 0; i < myArrayOne.length; i++) {
			System.out.print(myArrayOne[i] + ", ");
		}
	}
	
	public int[] ordenBurbuja(int[] myArray) {
		for(int j = 0; j < myArray.length; j++) {
			int[] newArray = new int[myArray.length];
			for(int i = 0; i < myArray.length-1; i++) {
				if(myArray[i] > myArray[(i+1)]) {
					newArray[i] = myArray[(i+1)];
					myArray[(i+1)] = myArray[i];
					newArray[(i+1)] = myArray[i];	
				}else {
					newArray[i] = myArray[i];
					newArray[(i+1)] = myArray[(i+1)];
				}
			}
			myArray = newArray;
		}
		return myArray;
	}
	
	public void readArray(int[] myArray) {
		String arrayText = "";
		for(int i = 0; i < myArray.length; i++) {
			arrayText += myArray[i] + ", ";
		}
		JOptionPane.showMessageDialog(null, arrayText);
	}
	
	public static void main(String [] args) {
		Burbuja burbujaTest = new Burbuja();
		burbujaTest.startValues();
		int[] numberOrdened = burbujaTest.ordenBurbuja(burbujaTest.myArrayOne);
		System.out.println("");
		burbujaTest.readArray(numberOrdened);
	}
}
