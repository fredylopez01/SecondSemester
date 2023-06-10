package co.edu.uptc.model;

public class LogicSearch {
	private AlphabetSoup constantsTest;
	private char[][] matrixSoup;
	private int counter;

	public LogicSearch() {
		constantsTest = new AlphabetSoup();
		constantsTest.startValues();
		matrixSoup = new char[constantsTest.LETTERS_ROWS.length][constantsTest.LETTERS_ROWS[0].length];
		for (int i = 0; i < matrixSoup.length; i++) {
			for (int j = 0; j < matrixSoup[0].length; j++) {
				matrixSoup[i][j] = constantsTest.LETTERS_ROWS[i][j];
			}
		}
		counter = constantsTest.WORDS.length;
	}

	public boolean searchWords(String word,  int direction) {
		boolean isFound = false;
		for(int i = 0; i < constantsTest.WORDS.length; i++) {
			if (word.equals(constantsTest.WORDS[i])) {
				if(ishighLightWord(word, direction)) {
					isFound = true;
					counter--;
				}
			}
		}
		return isFound;
	}
	
	public boolean ishighLightWord(String word, int direction) {
		boolean ishighLight = false;
		for(int i = 0; i < matrixSoup.length; i++) {
			for(int j = 0; j < matrixSoup[0].length; j++) {
				if(matrixSoup[i][j] == word.charAt(0)) {
					switch(direction) {
					case 1:
						if(j+1-word.length() >= 0 && ishighLight == false) {
							ishighLight = 	searchHorizontaltoLeft(i, j, word);
						} 
						break;
					case 2:
						if(j+word.length() <= matrixSoup[0].length && ishighLight == false) {
							ishighLight = searchHorizontaltoRigth(i, j, word);
						}
						break;
					case 3:
						if(i+word.length() <= matrixSoup.length && ishighLight == false) {
							ishighLight = searchVerticaltoDown(i, j, word);
						}
						break;
					case 4:
						if(i+1-word.length() >= 0 && ishighLight == false) {
							ishighLight = searchVerticaltoUp(i, j, word);
						}
						break;
					case 5:
						if(j+word.length() <= matrixSoup[0].length && i+1- word.length() >= 0 && ishighLight == false) {
							ishighLight = diagonalUptoRigth(i, j, word);
						} 
						break;
					case 6:
						if(j+1-word.length() >= 0 && i+1-word.length() >= 0 && ishighLight == false) {
							ishighLight = diagonalUptoLeft(i, j, word);
						}
						break;
					case 7:
						if(j+1-word.length() >= 0 && i + word.length() <= matrixSoup.length && ishighLight == false) {
							ishighLight = diagonalDowntoLeft(i, j, word);
						}
						break;
					case 8:
						if (j+word.length() <= matrixSoup[0].length && i + word.length() <= matrixSoup.length && ishighLight == false) {
							ishighLight = diagonalDowntoRigth(i, j, word);
						}
						break;
					}
				}
			}
		}
		return ishighLight;
	}

	public boolean searchHorizontaltoRigth(int i, int j,String word) {
		boolean isFound = false;
		int verify = 1;
		for (int k = 1; k < word.length(); k++) {
			if (matrixSoup[i][j + k] == word.charAt(k)) {
				verify++;
			}
		}

		if (verify == word.length()) {
			isFound = true;
			for (int k = 0; k < word.length(); k++) {
				matrixSoup[i][j+k] = Character.toUpperCase(matrixSoup[i][j+k]);
			}
		}
		return isFound;
	}

	public boolean searchHorizontaltoLeft(int i, int j, String word) {
		boolean isFound = false;
		int verify = 1;
		for (int k = 1; k < word.length(); k++) {
			if (matrixSoup[i][j-k] == word.charAt(k)) {
				verify++;
			}
		}

		if (verify == word.length()) {
			isFound = true;
			for (int k = 0; k < word.length(); k++) {
				matrixSoup[i][j-k] = Character.toUpperCase(matrixSoup[i][j-k]);
			}
		}
		return isFound;
	}
	
	public boolean searchVerticaltoDown(int i, int j, String word) {
		boolean isFound = false;
		int verify = 1;
		for (int k = 1; k < word.length(); k++) {
			if (matrixSoup[i+k][j] == word.charAt(k)) {
				verify++;
			}
		}
		
		if (verify == word.length()) {
			isFound = true;
			for (int k = 0; k < word.length(); k++) {
			matrixSoup[i+k][j] = Character.toUpperCase(matrixSoup[i+k][j]);
			}
		}
		return isFound;
	}

	public boolean searchVerticaltoUp(int i, int j, String word) {
		boolean isFound = false;
		int verify = 1;
		for (int k = 1; k < word.length(); k++) {
			if (matrixSoup[i-k][j] == word.charAt(k)) {
				verify++;
			}
		}
		if (verify >= 3) {
			isFound = true;
			for (int k = 0; k < word.length(); k++) {
				matrixSoup[i-k][j] = Character.toUpperCase(matrixSoup[i-k][j]);
			}
		}
		return isFound;
	}

	public boolean diagonalUptoRigth(int i, int j, String word) {
		boolean isFound = false;
		int verify = 1;
		for (int k = 1; k < word.length(); k++) {
			if (matrixSoup[i-k][j+k] == word.charAt(k)) {
				verify++;
			}
		}
		if (verify == word.length()) {
			isFound = true;
			for (int k = 0; k < word.length(); k++) {
				matrixSoup[i - k][j + k] = Character.toUpperCase(matrixSoup[i-k][j + k]);
			}
		}
		return isFound;
	}

	public boolean diagonalUptoLeft(int i, int j, String word) {
		boolean isFound = false;
		int verify = 1;
		for (int k = 1; k < word.length(); k++) {
			if (matrixSoup[i - k][j - k] == word.charAt(k)) {
				verify++;
			}
		}
		if (verify == word.length()) {
			isFound = true;
			for (int k = 0; k < word.length(); k++) {
				matrixSoup[i-k][j-k] = Character.toUpperCase(matrixSoup[i-k][j-k]);
			}
		}
		return isFound;
	}

	public boolean diagonalDowntoLeft(int i, int j, String word) {
		boolean isFound = false;
		int verify = 1;
		for (int k = 1; k < word.length(); k++) {
			if (matrixSoup[i+k][j-k] == word.charAt(k)) {
				verify++;
			}
		}
		if (verify == word.length()) {
			isFound = true;
			for (int k = 0; k < word.length(); k++) {
				matrixSoup[i+k][j-k] = Character.toUpperCase(matrixSoup[i+k][j-k]);
			}
		}
		return isFound;
	}

	public boolean diagonalDowntoRigth(int i, int j, String word) {
		boolean isFound = false;
		int verify = 1;
		for (int k = 1; k < word.length(); k++) {
			if (matrixSoup[i + k][j + k] == word.charAt(k)) {
				verify++;
			}
		}
		if (verify == word.length()) {
			isFound = true;
			for (int k = 0; k < word.length(); k++) {
				matrixSoup[i + k][j + k] = Character.toUpperCase(matrixSoup[i+k][j + k]);
			}
		}
		return isFound;
	}
	
	public char[][] getMatrix() {
		return matrixSoup;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public String[] getWords() {
		return constantsTest.WORDS;
	}

}