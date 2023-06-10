package co.edu.uptc.model;

public class Matrix {
	private int[][] matrix;
	
	public Matrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public int[][] getMatrix() {
		return matrix;
	}

	public boolean isExist(int number) {
		boolean exists = false;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(number == matrix[i][j]) {
					exists = true;
				}
			}
		}
		return exists;
	}
	
	public int[] diagonal() {
		int[] arrayDiagonal = new int[matrix[0].length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(i == j) {
					arrayDiagonal[i] = matrix[i][j];
				}
			}
		}
		return arrayDiagonal;
	}
	
	public void interchangeRows(int rowOne, int rowTwo) {
		int copy;
		if (rowOne <= matrix.length && rowTwo <= matrix.length) {
			for(int i = 0; i < matrix[0].length; i++) {
				copy = matrix[rowOne][i];
				matrix[rowOne][i] = matrix[rowTwo][i];
				matrix[rowTwo][i] = copy;
			}
		}
	}
	
	public void interchangeColumns(int columnOne, int columnTwo) {
		int copy;
		if (columnOne <= matrix[0].length && columnTwo <= matrix[0].length) {
			for(int i = 0; i < matrix.length; i++) {
				copy = matrix[i][columnOne];
				matrix[i][columnOne] = matrix[i][columnTwo];
				matrix[i][columnTwo] = copy;
			}
		}
	}
	
	public void scalarProduct(int scalar) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
			matrix[i][j] = scalar*matrix[i][j];
			}
		}
	}
	
	public int[][] transposed() {
		int[][] responseTransposed = new int[matrix[0].length][matrix.length];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
			responseTransposed[j][i] = matrix[i][j];
			}
		}
		return responseTransposed;
	}
}