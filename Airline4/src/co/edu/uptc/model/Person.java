package co.edu.uptc.model;

/**
 * Hace reeferencia de manera abstracta a un pasajero que sera el que ocupara una silla que estra en un acion, todos son objetos
 * @author Fredy Lopez
 *
 */
public class Person {
	/**
	 * El atributo name de tipo String hace referencia al nombre de la persona, <b>pasajero</B>
	 * El atributo id es la identificación del pasajero
	 */
	private String name;
	private int id;
	
	/**
	 * Retorna el atributo name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Recibe un String que sera almacenado en el atributo name del objeto
	 * @param name Es el nombre de la persona
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Retorna el valor que este en el atributo id
	 * @return id De tipo int, es la identificación de la persona
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Cambia el valor del atributo id del objeto recibiendo por parametro un nuevo valor
	 * @param id Sera el nuevo valor para el atributo del objeto
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}
