package animalComer;

public class Dog extends Animal{
	public String comer() {
		return "Estoy comiendo un mi platito en el suelo";
	}

	@Override
	public String alimentarse() {
		return "se alimenta de concenttrado";
	}
	
}
