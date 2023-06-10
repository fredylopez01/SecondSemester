package animalComer;

public abstract class Animal extends SerVivo {
	public String comer() {
		return "Estoy comiendo";
	}

	@Override
	public abstract String alimentarse();
	
}
