package co.edu.uptc.model;

public class Truck {
	private String licensePlate;
	private int capacity;
	private double consumption;
	
	public Truck(String licensePlate, int capacity, double consumption) {
		this.licensePlate = licensePlate;
		this.capacity = capacity;
		this.consumption = consumption;
	}
	
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getConsumption() {
		return consumption;
	}
	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}
	
}
