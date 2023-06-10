package co.edu.uptc.presenter;

import co.edu.uptc.model.Matrix;
import co.edu.uptc.model.OtherMatrix;
import co.edu.uptc.view.View;

public class Presenter {
	private View viewTest;
	private Matrix matrixTest;
	private OtherMatrix otherMatrix;
	
	public Presenter() {
		viewTest = new View();
	}
	
	public static void main(String[] args) {
		Presenter presenterTest = new Presenter();
		int option;
		do {
			option = presenterTest.viewTest.readInt("Menu : \n1. Version 1 \n2. Version 2 - Tarea(18-05-23) \n3. Salir");
			switch(option) {
			case 1:
				presenterTest.runOne();
			case 2:
				presenterTest.runTwo();
			}
		} while(option != 3);
		presenterTest.viewTest.showMessage("Ha sido un placer. Vuelva pronto.");

	}
	
	public void runOne() {
		matrixTest = new Matrix(createMatrix());
		int option;
		do {
			option = viewTest.readInt("Menú \n \n0. Mostrar matriz\n1. Buscar numero \n2. Buscar diagonal \n3. Intercambiar filas "
					+ "\n4. Intercambiar columnas \n5. Producto escalar \n6. Transpuesta de la matriz \n7. Salir \n \nDigite opción:");
			switch(option) {
			case 0:
				showMatrix(matrixTest.getMatrix());
				break;
			case 1: 
				exists();
				break;
			case 2:
				responseDiagonal(matrixTest.diagonal());
				break;
			case 3:
				interRows();
				break;
			case 4:
				interColumns();
				break;
			case 5:
				matrixTest.scalarProduct(viewTest.readInt("Ingrese el escalar por el cual quiere que se multiplique la matriz"));
				break;
			case 6:
				showMatrix(matrixTest.transposed());
				break;
			}
		} 
		while(option != 7);
		viewTest.showMessage("Ha sido un placer. Vuelva pronto.");
	}
	
	public void runTwo() {
		otherMatrix = new OtherMatrix(createMatrix());
		int option;
		do {
			option = viewTest.readInt("Submenu \n1. Sumar filas \n2. Transpuesta \n3. Intercambiar filas \n4.Multiplicar fila \n5. Mostrar matriz \n6.Salir");
			switch(option) {
			case 1:
				viewTest.showMessage(otherMatrix.readVector(otherMatrix.sumRows()));
				break;
			case 2:
				showMatrix(otherMatrix.transposed());
				break;
			case 3:
				exchange();
				break;
			case 4:
				multiply();
				break;
			case 5:
				viewTest.showMessage(otherMatrix.toString());
				break;
				
			}
		} while(option != 6);
		viewTest.showMessage("Ha sido un placer. Vuelva pronto.");
	}
	
	public  int[][] createMatrix() {
		int filas = viewTest.readInt("Ingrese el número de filas para la nueva matriz");
		int columnas = viewTest.readInt("Ingrese el número de columnas para la nueva matriz");
		int[][] matrixUser = new int[filas][columnas];
		for(int i = 0; i < matrixUser.length; i++) {
			for(int j = 0; j < matrixUser[0].length; j++) {
				matrixUser[i][j] = (int)(Math.random()*(100)+1);
			}
		}
		return matrixUser;
	}
	
	public void showMatrix(int[][] matrix) {
		String matrixDraw = "";
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrixDraw += "[" + matrix[i][j] + "] ";
			}
			matrixDraw +="\n"; 
		}
		viewTest.showMessage(matrixDraw);
	}
	
	public void exists() {
		boolean responseExist = matrixTest.isExist(viewTest.readInt("Digite el numero que desea que sea buscado"));
		if (responseExist == true) {
			viewTest.showMessage("El numero que busca si se encuentra el la matriz");
		} else {
			viewTest.showMessage("El numero que busca NO se encuentra el la matriz");
		}
	}
	
	public void responseDiagonal(int[] arrayDiagonal) {
		String copyDiagonal = "";
		for(int i = 0; i < arrayDiagonal.length; i++) {
			copyDiagonal += arrayDiagonal[i] + ", ";
		}
		viewTest.showMessage("Los numeros de la diagonal hecha por la matriz son: " + copyDiagonal);
	}
	
	public void interRows() {
		int rowOne = viewTest.readInt("Ingrese el numero de fila que se intercambiara");
		int rowTwo = viewTest.readInt("Ingrese la fila por la que quiere que sea intercambiada");
		matrixTest.interchangeRows(rowOne, rowTwo);
	}
	
	public void interColumns() {
		int columnOne = viewTest.readInt("Ingrese el numero de columna que se intercambiara");
		int columnTwo = viewTest.readInt("Ingrese la columna por la que quiere que sea intercambiada");
		matrixTest.interchangeColumns(columnOne, columnTwo);
	}
	
	public void exchange() {
		if(otherMatrix.exchange(viewTest.readInt("Ingrese numero de la fila uno"), viewTest.readInt("Ingrese numero de la fila dos"))) {
			viewTest.showMessage(otherMatrix.toString());
		} else {
			viewTest.showMessage("Fila o columna fuera del rango");
		}
	}
	
	public void multiply() {
		if(otherMatrix.multiply(viewTest.readInt("Ingrese numero de la fila"), viewTest.readInt("Escalar"))) {
			viewTest.showMessage(otherMatrix.toString());
		} else {
			viewTest.showMessage("Fila o columna fuera del rango");
		}
	}
	
}