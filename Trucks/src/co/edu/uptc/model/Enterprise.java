package co.edu.uptc.model;

public class Enterprise {
	private Truck[] trucks;
	
	public Enterprise(int size) {
		trucks = new Truck[size];
	}
	
	public String maxCapacity() throws ExceptionEqualsCapacity {
		selectionSort();
		if(trucks[0].getCapacity() == trucks[1].getCapacity()) {
			throw new ExceptionEqualsCapacity(trucks[0].getCapacity());
		}
		String response = trucks[0].getLicensePlate();
		return response;
	}
	
	public void selectionSort() {
		Truck truck = null;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i] != null && trucks[i+1] != null && trucks[i].getCapacity() < trucks[i+1].getCapacity()) {
				truck = trucks[i];
				trucks[i] = trucks[i+1];
				trucks[i+1] = truck;
			}
		}
	}

	public int totalCapacity() {
		int total = 0;
		for(int i = 0; i < trucks.length; i++) {
			if(trucks[i] != null) {
				total += trucks[i].getCapacity();
			}
		}
		return total;
	}
	
	public double avgConsumption() {
		double average = 0;
		int div = 0;
		for(int i = 0; i < trucks.length; i++) {
			if(trucks[i] != null) {
				average += trucks[i].getConsumption();
				div++;
			}
		}
		return average/div;
	}
	
	public boolean addTruck(Truck truck) throws ExceptionEquals {
		boolean isSave = false;
		for(int i = 0; i < trucks.length; i++) {
			if(trucks[i] != null) {
				if(truck.getLicensePlate().equals(trucks[i].getLicensePlate()) && !isSave) {
					throw new ExceptionEquals();
				}
			}
			if(trucks[i] == null && !isSave) {
				trucks[i] = truck;
				isSave = true;
			}
		}
		return isSave;
	}
	
	public boolean searchTruck(String plate) {
		boolean isSearch = false;
		for(int i = 0; i < trucks.length; i++) {
			if(trucks[i] != null) {
				if(trucks[i].getLicensePlate().equals(plate)) {
					isSearch = true;
				}
			}
		}
		return isSearch;
	}

	
	public Truck[] getTrucks() {
		return trucks;
	}

	public void setTrucks(Truck[] trucks) {
		this.trucks = trucks;
	}
	
}
