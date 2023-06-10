package co.edu.uptc.presenter;

import co.edu.uptc.model.AlphabetSoup;
import co.edu.uptc.model.LogicSearch;
import co.edu.uptc.view.View;

public class Presenter {
	private View viewTest;
	private LogicSearch soupTest;
	
	public Presenter() {
		viewTest = new View();
		soupTest = new LogicSearch();
	}
	
	public void run() {
		int option;
		do {
			option = viewTest.readInt("Menú \n \n1. Mostrar Sopa de letras \n2. Buscar Palabra \n3. Contador \n4. Salir \n "
					+ "\nDigite opción:");
			switch(option) {
			case 1: 
				showMatrix(soupTest.getMatrix());
				break;
			case 2:
				found();
				break;
			case 3:
				viewTest.showMessage("Te quedan: " + soupTest.getCounter() + " palabras por encontrar");
				break;
			case 4:
				viewTest.showMessage("Ha sido un placer. Vuelva pronto.");
				System.exit(0);
				break;
			}
		} 
		while(option != 4);
		if(soupTest.getCounter() == 0) {
			viewTest.showMessage("Acaba de encontarar todas las palabras\n GANO!");
		}
	}
	
	public void showMatrix(char[][] matrix) {
		String matrixDraw = "";
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrixDraw += "[" + matrix[i][j] + "] ";
			}
			matrixDraw +="\n"; 
		}
		viewTest.showAlphabetSoup(matrixDraw);
	}
	
	public void found() {
		String word = viewTest.readString("Ingrese la palabra que encontro");
		int direction = viewTest.readInt("De que forma se encuentra la palabra: \n1. De derecha a izquierda \n2. De izquierda a derecha"
				+ "\n3. De arriba a abajo \n4. De abajo a arriba \n5. De izquierda a derceha, de abajo a arriba "
				+ "\n6. De derecha a izquierda, de abajo a arriba \n7. De derecha a izquierda, de arriba a abajo"
				+ "\n8. De izquierda a derecha, de arriba a abajo");
				
		boolean responseExist = soupTest.searchWords(word, direction);
		if (responseExist == true) {
			viewTest.showMessage("Palabra encontrada, una menos");
		} else {
			viewTest.showMessage("La palabra no se encuentra. Sigue intentando \nPor favor verifica la dirección");
		}
	}
	
	
	public static void main(String[] args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
}