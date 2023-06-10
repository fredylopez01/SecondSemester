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
	 * Returna una valor boolean el cual me dice si hay espacios vacios en una matiz determinada por el parametro optionClass
	 * @param optionClass Hace referencia a la clase seleccionada por el usuario y que ayudara a saber que matiz revisar
	 * @return Un valor booleano el cual me dice si hay o no hay espacios en la matriz
	 */
	public boolean isChairsByClass(int optionClass) {
		boolean isSpace = false;
		if(optionClass == 1) {
			if(isChairExecutive() && !isSpace) {
				isSpace = true;
			}
		} else if(optionClass == 2){
			if(isChairEconomic() && !isSpace) {
				isSpace = true;
			}
		}
		return isSpace;
	}
	
	/**
	 * Es un auxiliar del metodo isChairsByClass. 
	 * Retorna un valor booleano para hacer saber si hay espacios vacios de la matiz executive
	 * @return booleano isSpace que informa si hay espcios
	 */
	public boolean isChairExecutive() {
		boolean isSpace = false;
		for(int i = 0; i < executive.length; i++) {
			for(int j = 0; j < executive[0].length; j++) {
				if(executive[i][j].getConsumer() == null && !isSpace) {
					isSpace = true;
				} 
			}
		}
		return isSpace;
	}
	
	/**
	 * Método auxiliar del método isChairByClass
	 * Retorna un valor booleano para hacer saber si hay espacios vacios de la matiz economic 
	 * @return booleano isSpace que informa de espacios vacios
	 */
	public boolean isChairEconomic() {
		boolean isSpace = false;
		for(int i = 0; i < executive.length; i++) {
			for(int j = 0; j < executive[0].length; j++) {
				if(executive[i][j].getConsumer() == null && !isSpace) {
					isSpace = true;
				} 
			}
		}
		return isSpace;
	}
	
	/**
	 * Revisa si existen espacios vacios en la matriz executive comparando el atributo ubication de cada casilla de la matiz con
	 * el parametro recivido
	 * @param ubication Hace referencia al atributo de cada espacio de la matriz que sera comparado para poder darle un valor 
	 * a la variable auxiliar isSpace
	 * @return booleano isSpace que informa de espacios vacios en la matriz que tengan el atributo ubication igual al parametro 
	 * recibido
	 */
	public boolean isExecutiveChairsByUbication(String ubication) {
		boolean isSpace = false;
		for(int i = 0; i < executive.length; i++) {
			for(int j = 0; j < executive[0].length; j++) {
				if(executive[i][j].getUbication().equals(ubication) && executive[i][j].getConsumer() == null  && !isSpace) {
					isSpace = true;
				}
			}
		}
		return isSpace;
	}
	
	/**
	 * Realiza la misma cción del método isExecutiveChairsByUbication con l leve diferencia de que ahora busca en la matriz 
	 * economic
	 * @param ubication Se refiere al atributo ubication que tiene cada espacio de la matriz, el cual sera comparado y usado 
	 * como criterio de busquedad de espacio vacios
	 * @return booleano isSpace que informa de espacios vacios en la matriz que tengan el atributo ubication igual al parametro 
	 * recibido
	 */
	public boolean isEconomicChairsByUbication(String ubication) {
		boolean isSpace = false;
		for(int i = 0; i < economic.length; i++) {
			for(int j = 0; j < economic[0].length; j++) {
				if(economic[i][j].getUbication().equals(ubication) && economic[i][j].getConsumer() == null && !isSpace) {
					isSpace = true;
				}
			}
		}
		return isSpace;
	}
	
	/**
	 * Ayuda a llenar los espacios de las matices dependiendo con los parametros elige diferente matriz, además llama
	 *  a los metodos reserveChairExecutive() y reserveChairEconomic() que son especializados en buscar espacios que cumplan 
	 *  con los requerirmientos que estan dados por los paramtros recibidos
	 * @param optionClass Se refiere a que matriz elige el usuario para que se llene uno de susu espacios
	 * @param ubication Hace referencia al atibuto que tienen todas las casillas de la matriz y el cual es comparado
	 * @param id Hace alusion al atributo que tiene el objeto contenido en cada espacio de las maticeslas, este atributo 
	 * contiene el numero de identificacion de una persona
	 * para cada espacio de cada una de las matrices
	 * @param name Indica el atributo
	 * @return
	 */
	public Chair reserveChair(int optionClass, String ubication,int id, String name) {
		Chair isReserve = null;
		if(optionClass == 1) {
			if(isReserve == null) {
				isReserve = reserveChairExecutive(ubication, id, name);
			}
		} else if(optionClass == 2) {
			if(isReserve == null) {
				isReserve = reserveChairEconomic(ubication, id, name);
			}
		}
		return isReserve;
	}
	
	public Chair reserveChairExecutive(String ubication,int id, String name) {
		Chair reserve = null;
		for(int i = 0; i < executive.length; i++) {
			for(int j = 0; j < executive[0].length; j++) {
				if(executive[i][j].getUbication().equals(ubication) && executive[i][j].getConsumer()== null && reserve == null) {
					Person consumer = new Person();
					consumer.setId(id);
					consumer.setName(name);
					executive[i][j].setConsumer(consumer);
					reserve = executive[i][j];
				}
			}
		}
		return reserve;
	}
	
	public Chair reserveChairEconomic(String ubication,int id, String name) {
		Chair reserve = null;
		for(int i = 0; i < economic.length; i++) {
			for(int j = 0; j < economic[0].length; j++) {
				if(economic[i][j].getUbication().equals(ubication) && economic[i][j].getConsumer()== null && reserve == null) {
					Person consumer = new Person();
					consumer.setId(id);
					consumer.setName(name);
					economic[i][j].setConsumer(consumer);
					reserve = economic[i][j];
				}
			}
		}
		return reserve;
	}
	
	public Chair searchInformation(int optionClass, String id) {
		Chair isReserve = null;
		if(optionClass == 1) {
			for(int i = 0; i < executive.length; i++) {
				for(int j = 0; j < executive[0].length; j++) {
					if(executive[i][j].getId().equalsIgnoreCase(id) && isReserve == null) {
						isReserve = executive[i][j];
					}
				}
			}
		} else if(optionClass == 2) {
			for(int i = 0; i < economic.length; i++) {
				for(int j = 0; j < economic[0].length; j++) {
					if(economic[i][j].getId().equalsIgnoreCase(id) && isReserve == null) {
						isReserve = economic[i][j];
					}
				}
			}
		}
		return isReserve;
	}

	public Chair[][] getExecutive() {
		return executive;
	}

	public void setExecutive(Chair[][] executive) {
		this.executive = executive;
	}

	public Chair[][] getEconomic() {
		return economic;
	}

	public void setEconomic(Chair[][] economic) {
		this.economic = economic;
	}
	
}