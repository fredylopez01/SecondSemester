package co.edu.uptc.model;

import java.time.LocalDate;

public class Store {
	private Product[] products = new Product[100];
	
	public void createProduct(Product product) {
		boolean save = false;
		for(int i = 0; i < products.length; i++) {
			if(products[i] == null && !save) {
				products[i] = product;
				save = true;
			}
		}
	}
	
	public void registerDeliverySales(int barCode, int amount) {
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				if(products[i].getBarCode() == barCode) {
					products[i].setAmount((products[i].getAmount()+amount));
				}
			}
		}
	}
	
	public int available(int barCode) {
		int amount = 0;
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				if(products[i].getBarCode() == barCode) {
					amount = products[i].getAmount();
				}
			}
		}
		return amount;
	}
	
	public int verifyDueDate(LocalDate presentDate
			) {
		int barCode = 0;
		FoodProduct productVerify;
		for(int i = 0; i < products.length; i++) {
			if(products[i] instanceof FoodProduct) {
				productVerify = (FoodProduct) products[i];
				if(productVerify.getDueDate().isBefore(presentDate)) {
					barCode = productVerify.getBarCode();
				}
			}
		}
		return barCode;
	}
	
	public int amountSize(int sizeVerify) {
		Clothe clotheVerify;
		int size;
		int amount = 0;
		for(int i = 0; i < products.length; i++) {
			if(products[i] instanceof Clothe) {
				clotheVerify = (Clothe) products[i];
				size = clotheVerify.getSize();
				if(size == sizeVerify) {
					amount += clotheVerify.getAmount();
				}
			}
		}
		return amount;
	}
	
	public int amountColor(String colorVerify) {
		Clothe clotheVerify;
		int amount = 0;
		for(int i = 0; i < products.length; i++) {
			if(products[i] instanceof Clothe) {
				clotheVerify = (Clothe) products[i];
				if(clotheVerify.getColor().equalsIgnoreCase(colorVerify)) {
					amount += clotheVerify.getAmount();
				}
			}
		}
		return amount;
	}
	
	public int valueInventory() {
		int value = 0;
		for(int i = 0; i < products.length; i++) {
			if(products[i] != null) {
				value += (products[i].getAmount()*products[i].getUnitPrice());
			}
		}
		return value;
	}
}
