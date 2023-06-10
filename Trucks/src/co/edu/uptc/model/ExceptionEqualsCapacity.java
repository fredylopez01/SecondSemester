package co.edu.uptc.model;

public class ExceptionEqualsCapacity extends Exception {
	public ExceptionEqualsCapacity(int capacity) {
		super("Existen varios camiones con la misma capacidad de carga. Maxima carga común: " + capacity + " Kg");
	}
}
