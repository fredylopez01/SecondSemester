package co.edu.uptc.model;

import java.time.LocalDate;

public class FoodProduct extends Product {
	private LocalDate manufacturingDaate;
	private LocalDate dueDate;
	
	public FoodProduct(int barCode, int unitPrice, int amount, LocalDate manufacturingDate, LocalDate dueDate) {
		super(barCode, unitPrice, amount);
		this.manufacturingDaate = manufacturingDate;
		this.dueDate = dueDate;
	}

	public LocalDate getManufacturingDaate() {
		return manufacturingDaate;
	}

	public void setManufacturingDaate(LocalDate manufacturingDaate) {
		this.manufacturingDaate = manufacturingDaate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
}
