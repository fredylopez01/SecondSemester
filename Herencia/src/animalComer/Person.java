package animalComer;

public class Person extends Animal {
	public String comer() {
		return "Estoy comiendo en la mesa con cubiertos";
	}

	@Override
	public String alimentarse() {
		return "Se alimenta de todo un poquito";
	}
}
