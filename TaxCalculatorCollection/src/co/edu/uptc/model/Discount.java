package co.edu.uptc.model;

public class Discount implements Comparable<Discount>{
	private String name;
	private double percent;
	
	public Discount(String name, double percent) {
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double d) {
		this.percent = d;
	}

	@Override
	public int compareTo(Discount o) {
		return name.compareTo(o.name);
	}
	
}
