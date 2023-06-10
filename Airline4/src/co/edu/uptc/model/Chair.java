package co.edu.uptc.model;
	
	/**
	 * Objeto que hace referencia de manera abstracta a una silla de un avión
	 * @author Fredy Lopez
	 *
	 */
public class Chair {
	/**
	 * Tiene como atributos una identificacion, una ubicación y una persona 
	 * el atributo id de tipo String es dicha identificación 
	 * El atributo ubication de tipo String model una ubicación de esa silla dentro de una <b>"avión"</b>, y por ultimo tenemos 
	 * El atributo consumer en este caso modela el pasajero que ocupara dicha silla y que hereda los atributos y métodos de la clase Person
	 */
	private String id;
	private String ubication;
	private Person consumer;
	
	/**
	 * Retorna un objeto de tipo Person que se refiere al <b>pasajero</b>
	 * @return
	 */
	public Person getConsumer() {
		return consumer;
	}
	
	/**
	 * Recibe un objeto de tipo Person y hace que el atributo de la clase del mismo tipo llamado consumer apunte a la msima direecion en memoria
	 * @param consumer Objeto de tipo Person donde apuntara el atributo de la clase del mismo tipo
	 */
	public void setConsumer(Person consumer) {
		this.consumer = consumer;
	}
	
	/**
	 * Cambia el valor del atributo id de la clase por el nuevo recivido por parametro
	 * @param id De tipo String que tendra un valor que haga referencia a un identificador para la clase
	 */
	public Chair(String id) {
		this.id = id;
		}
	
	public String getUbication() {
		return ubication;
	}

	public void setUbication(String ubication) {
		this.ubication = ubication;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
