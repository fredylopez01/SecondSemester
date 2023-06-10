package co.edu.uptc.presenter;

import java.time.LocalDate;
import java.time.LocalTime;

import co.edu.uptc.model.Clothe;
import co.edu.uptc.model.FoodProduct;
import co.edu.uptc.model.Product;
import co.edu.uptc.model.Store;
import co.edu.uptc.view.View;

public class Presenter {
	private Store storeTest;
	private View viewTest;
	
	public Presenter() {
		storeTest = new Store();
		viewTest = new View();
	}
	
	public static void main (String [] args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
	
	public void run() {
		LocalDate presentDay = LocalDate.now();
		int option = 0;
		do {
			option = viewTest.readInt(presentDay + " " + LocalTime.now() + "\nBIENVENIDO AL SISTEMA DE NUESTRA TIENDA\n\n"+ "1. Crear un nuevo producto "
					+ "\n2. Registrar el suministro y las ventas de un producto"
					+ "\n3. Verificar la cantidad disponible de un producto "
					+ "\n4. Verificar si en el inventario se encuentran alimentos vencidos"
					+ "\n5. Verificar la cantidad existente de prendas de una talla o color determinado"
					+ "\n6. Calcular el valor total del inventario del almacén\n7) Salir");
			switch(option) {
				case 1:
					storeTest.createProduct(createProduct());
					break;
				case 2:
					registerDeliverySales();
					break;
				case 3:
					viewTest.showMessage("Las unidades disponibles del producto son: " + storeTest.available(viewTest.readInt("Ingrese el codigo de barras del producto")));
					break;
				case 4:
					viewTest.showMessage("Alimento vencido identificado con el codigo de barras: " + storeTest.verifyDueDate(presentDay));
					break;
				case 5:
					viewTest.showMessage("La cantidad de prendas verificadas por los criterios es: "+ verifySizeOrColor());
					break;
				case 6: 
					viewTest.showMessage("Valor del inventario: " + storeTest.valueInventory());
					break;
			}
		}
		while(option != 7);
	}
	
	public Product createProduct() {
		Product productTest = null;
		int tipeProduct = viewTest.readInt("Que tipo de producto desea crear: \n1. Producto alimenticio \n2.Prendas de vestir"
				+ "\n3. Producto general");
		int barCode = viewTest.readInt("Ingrese el código de barras");
		int unitPrice = viewTest.readInt("Ingrese el valor unitario");
		int amount = viewTest.readInt("Ingrese la cantidad del producto");
		if(tipeProduct == 1) {
			productTest = createFoodProduct(barCode, unitPrice, amount);
		} else if(tipeProduct == 2) {
			productTest = createClothe(barCode, unitPrice, amount);
		} else if(tipeProduct == 3) {
			productTest = new Product(barCode, unitPrice, amount);
		}
		return productTest;
	}
	
	public Product createFoodProduct(int barCode, int unitPrice, int amount) {
		viewTest.showMessage("Ingrese la fecha de fabicacion del producto");
		LocalDate manufacturingDate = createDate();
		viewTest.showMessage("Ingrese la fecha de vencimiento del producto");
		LocalDate dueDate = createDate();
		Product foodTest = new FoodProduct(barCode, unitPrice, amount, manufacturingDate, dueDate);
		return foodTest;
	}
	
	public LocalDate createDate() {
		byte day = (byte)viewTest.readInt("Ingrese el dia");
		byte month = (byte)viewTest.readInt("Ingrese el mes");
		byte year = (byte)viewTest.readInt("Ingrese el año");
		LocalDate dateTest = LocalDate.of(year, month, day);
		return dateTest;
	}
	
	public Product createClothe(int barCode, int unitPrice, int amount) {
		String color = viewTest.readString("Ingrese el color de la prenda");
		int size = viewTest.readInt("Ingrese la talla");
		Product clothe = new Clothe(barCode, unitPrice, amount, color, size);
		return clothe;
	}
	
	public void registerDeliverySales() {
		int barCode = viewTest.readInt("Ingrese el codigo de barras del producto");
		int deliverySales = viewTest.readInt("Ingrese accón: \n1. Suminstrar \n2. Vender");
		int amount = viewTest.readInt("Ingrese que la cantidad");
		if(deliverySales == 1) {
			storeTest.registerDeliverySales(barCode, amount);
		} else if(deliverySales == 2) {
			storeTest.registerDeliverySales(barCode, -amount);
		}
	}
	
	public int verifySizeOrColor() {
		int amount = 1;
		int option = viewTest.readInt("Por cual especificación desea buscar la prenda: \n1. Talla \n2. Color");
		if(option == 1) {
			amount = storeTest.amountSize(viewTest.readInt("Ingrese la talla para verificar la cantidad"));
		} else if(option == 2) {
			amount = storeTest.amountColor(viewTest.readString("Ingrese el color para verificar la cantidad"));
		}
		return amount;
	}
}
