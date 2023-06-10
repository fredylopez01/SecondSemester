package co.edu.uptc.carrosPolimorfismo;

public class TransportCar extends Car{
	public int carga;

	public TransportCar(String marca, String modelo, int carga) {
		super(marca, modelo);
		this.carga = carga;
	}
	
	public String mostrarDatos() {
		return "Datos del Carro Carga: \nMarca: " + getMarca() + "\nModelo: " + getModelo() + "Peso que puede cargar: " + carga;
	}
}
