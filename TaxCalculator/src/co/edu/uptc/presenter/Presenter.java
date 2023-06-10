package co.edu.uptc.presenter;

import co.edu.uptc.model.Brand;
import co.edu.uptc.model.Line;
import co.edu.uptc.model.Model;
import co.edu.uptc.model.Simulator;
import co.edu.uptc.view.View;

public class Presenter {
	private View viewTest;
	private Simulator simulatorTest;
	
	public Presenter() {
		viewTest = new View();
		simulatorTest = new Simulator();
		loadDates();
	}
	
	public static void main (String [] args) {
		Presenter presenterTest = new Presenter();
		presenterTest.run();
	}
	
	public void run() {
		int option = 0;
		do {
			option = optionMenu();
			switch(option) {
				case 1:
					optionOne();
					break;
				case 2:
					modifyValue();
					break;
				case 3:
					viewTest.showMessage(showBrands());
					break;
				case 4:
					showTaxValue();
					break;
				case 5:
					optionDiscounts();
				case 6:
					optionTaxes();
					break;
			}
		}
		while(option != 7);
	}
	
	public int optionMenu() {
		int option;
		option = viewTest.readInt("\nBIENVENIDO AL CALCULADOR DE IMPUESTOS \n\n" + "1. Crear nuevas marcas, lineas o modelos \n2. Modificar avluo de un carro \n3. Mostrar base de datos"
				+ "\n4. Calcular Impuesto \n5.Ver y Modificar descuentos existentes \n6. Ver y Modificar impuestos existentes \n7. Salir");
		return option;
	}
	
	public void optionOne() {
		int option = viewTest.readInt("Que nuevo aspecto desea crear \n1. Marca \n2. Linea \n3. Modelo");
		if(option == 1) {
			if(simulatorTest.addBrand(createBrand())) {
				viewTest.showMessage("Marca creada correctamente");
			}
		} else if(option == 2) {
			if(simulatorTest.addLine(createBrand(), createLine())) {
				viewTest.showMessage("Linea creada correctamente");
			}
		} else if(option == 3) {
			if(simulatorTest.addModel(createBrand(), createLine(), createModel())) {
				viewTest.showMessage("Modelo creado correctamente");
			}
		}
			
	}
	
	public Brand createBrand() {
		Brand brand = new Brand(viewTest.readString("Ingrese el nombre de la marca"), null);
		return brand;
	}
	
	public Line createLine() {
		Line line = new Line(viewTest.readString("Ingrese el nombre de la linea"), null);
		return line;
	}
	
	public Model createModel() {
		int year = viewTest.readInt("Ingrese el año de modelo");
		int value = viewTest.readInt("Ingrese el avaluo del auto");
		Model model = new Model(year, value);
		return model;
	}
	
	public void modifyValue() {
		Model model = simulatorTest.searchValue(createBrand(), createLine(), viewTest.readInt("Ingrese el modelo(año) del vehiculo"));
		int value = viewTest.readInt("Ingrese el nuevo avaluo para este automivil");
		model.setValue(value);
	}
	
	public String showBrands() {
		String information = "";
		for(int i = 0; i < simulatorTest.getBrands().length; i++) {
			if(simulatorTest.getBrands()[i] != null) {
				information += "\n******" + simulatorTest.getBrands()[i].getName() + "******";
				information += showLines(i);
			}
		}
		return information;
	}
	
	public String showLines(int brand) {
		String information = "";
		for(int i = 0; i < simulatorTest.getBrands()[brand].getLines().length; i++) {
			if(simulatorTest.getBrands()[brand].getLines()[i] != null) {
				information += "\n--Linea: " + simulatorTest.getBrands()[brand].getLines()[i].getName();
				information += showModels(brand, i);
			}
		}
		return information;
	}
	
	public String showModels(int brand, int line) {
		String information = "";
		for(int i = 0; i < simulatorTest.getBrands()[brand].getLines()[line].getModels().length; i++) {
			if(simulatorTest.getBrands()[brand].getLines()[line].getModels()[i] != null) {
				information += "\n----Año: " + simulatorTest.getBrands()[brand].getLines()[line].getModels()[i].getYear();
				information += "    Avaluo: " + simulatorTest.getBrands()[brand].getLines()[line].getModels()[i].getValue();
			}
		}
		return information;
	}
	
	public void showTaxValue() {
		Model model = simulatorTest.searchValue(createBrand(), createLine(), viewTest.readInt("Ingrese el modelo(año) del vehiculo"));
		if(model != null) {
			int taxValue = simulatorTest.taxValue(model);
			int discount = applyDiscounts(taxValue);
			viewTest.showMessage("Valor del avaluo de su vehiculo: " + model.getValue() + "\n Valor parcial del impuesto: " + taxValue +
			 "\nValor del descuento: " + discount + "Total a pagar: " + (taxValue - discount));
			
		} else {
			viewTest.showMessage("El vehiculo con dichas caracterizticas no se encuentra en el sistema");
		}		
	}
	
	public int applyDiscounts(int taxValue) {
		boolean paySoon = responseDiscount(simulatorTest.getDiscounts()[0].getName());
		boolean publicTransport = responseDiscount(simulatorTest.getDiscounts()[1].getName()); 
		boolean enrolledInBoyaca = responseDiscount(simulatorTest.getDiscounts()[2].getName());
		return simulatorTest.calculateDiscount(taxValue, paySoon, publicTransport, enrolledInBoyaca);
	}
	
	public boolean responseDiscount(String message) {
		String messageDefault = "Aplica al descuento de: ";
		return viewTest.readBoolean(messageDefault + message);
	}
	
	public void optionDiscounts() {
		int option = viewTest.readInt("1. Ver tabla de descuentos \n2. Modificar Descuentos: ");
		if(option == 1) {
			viewTest.showMessage(showDiscounts());
		} else if(option == 2) {
			modifyDiscounts();
		}
	}
	
	public void modifyDiscounts() {
		for(int i = 0; i < simulatorTest.getDiscounts().length; i++) {
			simulatorTest.getDiscounts()[i].setName(viewTest.readString("Nuevo nombre para el descuento " + (i+1)));
			simulatorTest.getDiscounts()[i].setPercent(Double.parseDouble(viewTest.readString("Nuevo porcentaje para el descuento " + (i+1))));
		}
	}
	
	public String showDiscounts() {
		String discounts = "";
		for(int i = 0; i < simulatorTest.getDiscounts().length; i++) {
			discounts += "*****Descuento" + (i+1) + "***** \nNombre: " + simulatorTest.getDiscounts()[i].getName() + 
					"\nPorcentaje: " + simulatorTest.getDiscounts()[i].getPercent() + "\n\n";
		}
		return discounts;
	}
	
	public void optionTaxes() {
		int option = viewTest.readInt("1. Ver tabla de Impuestos \n2. Modificar Impuestos");
		if(option == 1) {
			viewTest.showMessage(showTaxes());
		} else if(option == 2) {
			modifyTaxes();
		}
	}
	
	public void modifyTaxes() {
		for(int i = 0; i < simulatorTest.getRates().length; i++) {
			simulatorTest.getRates()[i].setMin(viewTest.readInt("Ingrese el nuevo valor para el minimo " + (i+1)));
			simulatorTest.getRates()[i].setMax(viewTest.readInt("Nuevo maximo valor para el impuesto " + (i+1)));
			simulatorTest.getRates()[i].setPercent(viewTest.readInt("Nuevo porcentaje para el impuesto " + (i+1)));
		}
	}
	
	public String showTaxes() {
		String discounts = "";
		for(int i = 0; i < simulatorTest.getRates().length; i++) {
			discounts += "*****Impuesto" + (i+1) + "***** \nMinimo: " + simulatorTest.getRates()[i].getMin()
					+ "\nMaximo: " + simulatorTest.getRates()[i].getMax() + "\nPorcentaje: " +  simulatorTest.getRates()[i].getPercent() + "\n\n";
		}
		return discounts;
	}
	
	public void loadDates() {
		Brand brandTest = new Brand("chevrolet", null);
		Line lineTest = new Line("mx", null);
		Model modelTest = new Model(2010, 2000);
		Brand brandTest2 = new Brand("bmw", null);
		Line lineTest2 = new Line("sport", null);
		Model modelTest2 = new Model(2020, 20000000);
		Brand brandTest3 = new Brand("Ford", null);
		Line lineTest3 = new Line("raptor", null);
		Model modelTest3 = new Model(2015, 80000000);
		Brand brandTest4 = new Brand("lamborgini", null);
		Line lineTest4 = new Line("murcielago", null);
		Model modelTest4 = new Model(2017, 300000000);
		simulatorTest.addBrand(brandTest);
		simulatorTest.addLine(brandTest, lineTest);
		simulatorTest.addModel(brandTest, lineTest, modelTest);
		simulatorTest.addBrand(brandTest2);
		simulatorTest.addLine(brandTest2, lineTest2);
		simulatorTest.addModel(brandTest2, lineTest2, modelTest2);
		simulatorTest.addBrand(brandTest3);
		simulatorTest.addLine(brandTest3, lineTest3);
		simulatorTest.addModel(brandTest3, lineTest3, modelTest3);
		simulatorTest.addBrand(brandTest4);
		simulatorTest.addLine(brandTest4, lineTest4);
		simulatorTest.addModel(brandTest4, lineTest4, modelTest4);
		simulatorTest.addBrand(brandTest2);
		simulatorTest.addLine(brandTest2, lineTest3);
		simulatorTest.addModel(brandTest2, lineTest3, modelTest4);
	}
}
