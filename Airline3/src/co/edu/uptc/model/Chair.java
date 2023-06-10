package co.edu.uptc.model;

	/**
	 * Objeto que hace referencia de manera abstracta a una silla de un avión
	 * @author Fredy Lopez
	 *
	 */
public class Chair {
	/**
	 * Tiene como atributos una identificacion, una ubicación y una persona 
	 * el atributo id de tipo String es dicha identificación, por su parte el atributo ubication de tipo String se model
	 * una ubicación de esa silla dentro de una <b>"avión"</b>, y por ultimo tenemos el atributo consumero que esn este caso modela 
	 * el pasajero que ocupara dicha silla y que hereda los atributos y métodos de la clase Person
	 */
	private String id;
	private String ubication;
	private Person consumer;
	
	public Person getConsumer() {
		return consumer;
	}

	public void setConsumer(Person consumer) {
		this.consumer = consumer;
	}

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
