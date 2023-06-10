package co.edu.uptc.model;

public class AlphabetSoup {
	public final int NUMBER_ROWS = 10;
	public final int NUMBER_COLUMNS = 10;
	
	public char[][] LETTERS_ROWS = new char[NUMBER_ROWS][NUMBER_COLUMNS];
	public String[] WORDS = new String[8];
	
	public void startValues() {
		WORDS[0] = "computador";
		WORDS[1] = "mouse";
		WORDS[2] = "teclado";
		WORDS[3] = "interfaz";
		WORDS[4] = "celular";
		WORDS[5] = "disco";
		WORDS[6] = "memoria";
		WORDS[7] = "ram";
		
		for(int j = 0; j < WORDS[0].toCharArray().length; j++) {
			LETTERS_ROWS[0][j] = WORDS[0].toCharArray()[j];
		}
		
		for(int j = 0; j < WORDS[1].toCharArray().length; j++) {
			LETTERS_ROWS[9][6-j] = WORDS[1].toCharArray()[j];
		}
		
		for(int j = 0; j < WORDS[2].toCharArray().length; j++) {
			LETTERS_ROWS[1+j][1+j] = WORDS[2].toCharArray()[j];
		}
		
		for(int j = 0; j < WORDS[3].toCharArray().length; j++) {
			LETTERS_ROWS[8-j][8] = WORDS[3].toCharArray()[j];
		}
		
		for(int j = 0; j < WORDS[4].toCharArray().length; j++) {
			LETTERS_ROWS[1+j][0] = WORDS[4].toCharArray()[j];
		}
		
		for(int j = 0; j < WORDS[5].toCharArray().length; j++) {
			LETTERS_ROWS[9-j][j] = WORDS[5].toCharArray()[j];
		}
		
		for(int j = 0; j < WORDS[6].toCharArray().length; j++) {
			LETTERS_ROWS[9-j][7-j] = WORDS[6].toCharArray()[j];
		}
		
		for(int j = 0; j < WORDS[7].toCharArray().length; j++) {
			LETTERS_ROWS[1+j][7-j] = WORDS[7].toCharArray()[j];
		}
		
		for(int i = 0; i < LETTERS_ROWS.length; i++) {
			for(int j = 0; j < LETTERS_ROWS[0].length; j++) {
				if (LETTERS_ROWS[i][j] == 0) {
					LETTERS_ROWS[i][j] = "abcdefghijklmnopqrstuvwxyz".charAt((int)(Math.random()*(25)+1));
				}
			}
		}
		
		
	}
	
}