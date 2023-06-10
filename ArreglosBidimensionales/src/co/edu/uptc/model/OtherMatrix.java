package co.edu.uptc.model;

public class OtherMatrix {
	private int rows;
	private int columns;
	private int[][] matrix;
	
	public OtherMatrix(int rows, int columns) {
		matrix = new int[rows][columns];
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = 0;
			}
		}
	}
	
	public OtherMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public int[] sumRows() {
		int[] sumRows = new int[matrix.length];
		int sum = 0;
		for(int i = 0; i < matrix.length; i++) {
			sum = 0;
			for(int j = 0; j < matrix[0].length; j++) {
				 sum += matrix[i][j]; 
			}
			sumRows[i] = sum;
		}
		return sumRows;
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

	public boolean exchange(int rowOne, int rowTwo) {
		int copy;
		if (rowOne > 0 && rowOne <= matrix.length && rowTwo > 0 && rowTwo <= matrix.length) {
			for(int i = 0; i < matrix[0].length; i++) {
				copy = matrix[rowOne-1][i];
				matrix[rowOne-1][i] = matrix[rowTwo-1][i];
				matrix[rowTwo-1][i] = copy;
			}
			return true;
		} else {
			return false;
		}
	}
	
	public boolean multiply(int row, int scalar) {
		if(row <= matrix.length) {
			for(int j = 0; j < matrix[0].length; j++) {
			matrix[row-1][j] = scalar*matrix[row-1][j];
			}
			return true;
		} else {
			return false;
		}
	}
	
	public String readVector(int[] vector) {
		StringBuilder vectorDraw = new StringBuilder(); 
		for(int i = 0; i < vector.length; i++) {
			vectorDraw.append("[" + vector[i] + "]\n");
		}
		return vectorDraw.toString(); 
	}
	
	public String toString() {
		StringBuilder matrixDraw = new StringBuilder();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				matrixDraw.append("[" + matrix[i][j] + "] ");
			}
			matrixDraw.append("\n"); 
		}
		return matrixDraw.toString();
	}
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
}
