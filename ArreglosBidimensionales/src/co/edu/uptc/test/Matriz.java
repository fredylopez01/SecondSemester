package co.edu.uptc.test;

import java.util.Scanner;

public class Matriz {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[][] boxOne;
		boxOne = new int[3][2];
		boxOne[0][0] = 5;
		boxOne[0][1] = 6;
		boxOne[0][2] = 9;
		boxOne[1][0] = 1;
		boxOne[1][1] = 2;
		boxOne[1][2] = 4;
		boxOne[2][0] = 7;
		boxOne[2][1] = 3;
		boxOne[2][2] = 8;
		
		for(int i = 0; i < boxOne.length; i++) {
			for(int j = 0; j < boxOne[0].length; j++) {
				System.out.print(boxOne[i][j] + " ");
			}
			System.out.println();
		}
		
		int[][] matrix = {{5,8},{10,4},{7,12}};
		System.out.println("Número de filas: " + matrix.length);
		System.out.println("Número de columnas: " + matrix[0].length);
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		/**
		int[][] matrixTwo = {{5,8,11},{10,4,45},{7,12,23}};
		for(int i = 0; i < matrixTwo.length; i++) {
			for(int j = 0; j < matrixTwo[0].length; j++) {
				if(i == j) {
					System.out.print(matrix[i][j] + " ");
				}
			}
			System.out.println();
		}*/
		System.out.println("Ingrese el número que desea que sea buscado: ");
		int lookNumber = input.nextInt();
		boolean look = false;
		int positionFila = 0;
		int positionColumna = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(lookNumber == matrix[i][j]) {
					look = true;
					positionFila = i;
					positionColumna = j;
				}
			}
		}
		if (look== true) {
			System.out.println("El numero si esta en la matriz en la posición: " + positionFila + ", " + positionColumna);
		} else {
			System.out.println("El numero que busca no se encuentra en la matriz");
		}
		
	}

}
