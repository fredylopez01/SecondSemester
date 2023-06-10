package co.edu.uptc.model;

/**
 * Contiene toda la logica de la aplicaion
 * @author Fredy Lopez
 *
 */
public class AirplaneFlight {
	private Chair[][] executive;
	private Chair[][] economic;
	
	/**
	 * Método constructor donde se inicializan todas los atributos de la clase, en este caso los atributos son dos matrices de 
	 * tipo Chair
	 */
	public AirplaneFlight() {
		executive = new Chair[2][4];
		economic = new Chair[7][6];
		for(int i = 0; i < executive.length; i++) {
			for(int j = 0; j < executive[0].length;j++) {
				if(i == 0) {
					executive[i][j] = new Chair(("A"+(j+1)));
				} else if(i == 1) {
					executive[i][j] = new Chair(("B"+(j+1)));
				}
				if(j == 0 || j == 3) {
					executive[i][j].setUbication("Window");
				} else if(j== 1 || j == 2) {
					executive[i][j].setUbication("Hallway");
				}
			}
		}
		for(int i = 0; i < economic.length; i++) {
			for(int j = 0; j < economic[0].length;j++) {
				if(i == 0) {
					economic[i][j] = new Chair(("A"+(j+1)));
				} else if(i == 1) {
					economic[i][j] = new Chair(("B"+(j+1)));
				} else if(i == 2) {
					economic[i][j] = new Chair(("C"+(j+1)));
				} else if(i == 3) {
					economic[i][j] = new Chair(("D"+(j+1)));
				} else if(i == 4) {
					economic[i][j] = new Chair(("E"+(j+1)));
				} else if(i == 5) {
					economic[i][j] = new Chair(("F"+(j+1)));
				} else if(i == 6) {
					economic[i][j] = new Chair(("G"+(j+1)));
				}
				if(j == 0 || j == 5) {
					economic[i][j].setUbication("Window");
				} else if(j== 1 || j == 4) {
					economic[i][j].setUbication("Center");
				} else if(j== 2 || j == 3) {
					economic[i][j].setUbication("Hallway");
				} 
			}
		}
	}
	
	/**
	 * Busca si hay espacios desocupados "sillas" y devuelve la afirmación
	 * @param matrizClass Es un criterio de busqueda para saber en cual matriz buscar
	 * @return Un booleano que afirma si hay espacios o no
	 */
	public boolean isChairByClass(Chair[][] matrizClass) {
		boolean isSpace = false;
		for(int i = 0; i < matrizClass.length; i++) {
			for(int j = 0; j < matrizClass[0].length; j++) {
				if(matrizClass[i][j].getConsumer() == null && !isSpace) {
					isSpace = true;
				} 
			}
		}
		return isSpace;
	}
	
	/**
	 * Busca espacios de una matriz que tengan el atributo ubication igual al recivido
	 * @param ubication Critero para saber si cuales casillas tienen este mismo atributo
	 * @param matrizClass Es un criterio de busqueda para saber en cual matriz buscar
	 * @return
	 */
	public boolean isChairsByUbication(String ubication, Chair[][] matrizClass) {
		boolean isSpace = false;
		for(int i = 0; i < matrizClass.length; i++) {
			for(int j = 0; j < matrizClass[0].length; j++) {
				if(matrizClass[i][j].getUbication().equals(ubication) && matrizClass[i][j].getConsumer() == null  && !isSpace) {
					isSpace = true;
				}
			}
		}
		return isSpace;
	}
	
	/**
	 * Llena uno de los espacios de la matriz recibida por parametro con información que también es recibida como parametro
	 * @param matrizClass Es un criterio de busqueda para saber en cual matriz buscar
	 * @param ubication Critero para saber si cuales casillas tienen este mismo atributo
	 * @param id Sera el nuevo valor del atributo del objeto de tipo Person contenido en el objeto Chair
	 * @param name Sera el nuevo valor del atributo del objeto de tipo Person contenido en el objeto Chair
	 * @return
	 */
	public Chair reserveChair(Chair[][] matrizClass, String ubication,int id, String name) {
		Chair reserve = null;
		for(int i = 0; i < matrizClass.length; i++) {
			for(int j = 0; j < matrizClass[0].length; j++) {
				if(matrizClass[i][j].getUbication().equals(ubication) && matrizClass[i][j].getConsumer()== null && reserve == null) {
					Person consumer = new Person();
					consumer.setId(id);
					consumer.setName(name);
					matrizClass[i][j].setConsumer(consumer);
					reserve = matrizClass[i][j];
				}
			}
		}
		return reserve;
	}
	
	/**
	 * Busca una casilla (silla) de la matriz dada por parametro que tenga el mismo atributo id y la retona
	 * @param matrizClass Es un criterio de busqueda para saber en cual matriz buscar
	 * @param id Es recibido para compararlo con el atributo que tiene cada objeto de la matriz
	 * @return Un objeto de tipo Chair que es aquel que cumplio con los requerimientos de busqueda
	 */
	public Chair searchInformation(Chair[][] matrizClass, String id) {
		Chair isReserve = null;
		for(int i = 0; i < matrizClass.length; i++) {
			for(int j = 0; j < matrizClass[0].length; j++) {
				if(matrizClass[i][j].getId().equalsIgnoreCase(id) && isReserve == null) {
					isReserve = matrizClass[i][j];
				}
			}
		}
		return isReserve;
	}

	/**
	 * Retorna la matriz executive
	 * @return Una matriz dee tipo Chair
	 */
	public Chair[][] getExecutive() {
		return executive;
	}
	
	/**
	 * Retorna la matriz economic
	 * @return Una matriz dee tipo Chair
	 */
	public Chair[][] getEconomic() {
		return economic;
	}
	
}