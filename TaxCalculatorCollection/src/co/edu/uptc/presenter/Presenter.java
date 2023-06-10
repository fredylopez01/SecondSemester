package co.edu.uptc.presenter;

import co.edu.uptc.model.Brand;
import co.edu.uptc.model.Line;
import co.edu.uptc.model.Model;
import co.edu.uptc.model.Range;
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
					optionCreate();
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
					break;
				case 6:
					optionTaxes();
					break;
			}
		}
		while(option != 7);
	}
	
	public int optionMenu() {
		int option;
		option = viewTest.readInt("\nBIENVENIDO AL CALCULADOR DE IMPUESTOS \n\n" + "1. Crear nuevas marcas, lineas o modelos \n2. Modificar avaluo de un carro \n3. Mostrar base de datos"
				+ "\n4. Calcular Impuesto \n5.Ver y Modificar descuentos existentes \n6. Ver y Modificar impuestos existentes \n7. Salir \n\nDigite Opción");
		return option;
	}
	
	public void optionCreate() {
		int option = viewTest.readInt("Que nuevo aspecto desea crear \n1. Marca \n2. Linea \n3. Modelo");
		if(option == 1) {
			createBrandOption();
		} else if(option == 2) {
			createLineOption();
		} else if(option == 3) {
			createModelOption();
		}	
	}
	
	public void createBrandOption() {
		if(simulatorTest.addBrand(createBrand())) {
			viewTest.showMessage("Marca creada correctamente");
		}else {
			viewTest.showMessage("La marca ya existe");
		}
	}
	
	public void createLineOption() {
		Brand brand = createBrand();
		if(simulatorTest.searchBrand(brand) != null) {
			if(simulatorTest.addLine(brand, createLine())) {
				viewTest.showMessage("Linea creada correctamente");
			} else {
				viewTest.showMessage("La linea ya existe");
			}
		} else {
			viewTest.showMessage("Marca no existente en el sistema");
		}
	}
	
	public void createModelOption() {
		Brand brand = createBrand();
		brand = simulatorTest.searchBrand(brand);
		if(brand != null) {
			Line line = createLine();
			if(simulatorTest.searchLine(brand, line) != null) {
				if(simulatorTest.addModel(brand, line, createModel())) {
					viewTest.showMessage("Modelo creado correctamente");
				} else {
					viewTest.showMessage("El modelo ya existe");
				}
			} else {
				viewTest.showMessage("Linea no existente");
			}
		} else {
			viewTest.showMessage("Marca no existente");
		}
	}
	
	public Brand createBrand() {
		return new Brand(viewTest.readString("Ingrese el nombre de la marca"));
	}
	
	public Line createLine() {
		return new Line(viewTest.readString("Ingrese el nombre de la linea"));
	}
	
	public Model createModel() {
		int year = viewTest.readInt("Ingrese el año de modelo");
		int value = viewTest.readInt("Ingrese el avaluo del auto");
		return new Model(year, value);
	}
	
	public void modifyValue() {
		Model model = searchModel();
		if(model != null) {
			int value = viewTest.readInt("Ingrese el nuevo avaluo para este automivil");
			model.setValue(value);
			viewTest.showMessage("Avaluo moficado correctamente");
		}
	}
	
	public Model searchModel() {
		Model model = null;
		Brand brand = createBrand();
		brand = simulatorTest.searchBrand(brand);
		if(brand != null) {
			Line line = createLine();
			line = simulatorTest.searchLine(brand, line);
			if(line != null) {
				model = simulatorTest.searchValue(brand, line, viewTest.readInt("Ingrese el modelo(año) del vehiculo"));
				if(model == null) {
					viewTest.showMessage("El modelo no existe en el sistema");
				}
			} else {
				viewTest.showMessage("La linea que ingreso no existe en el sistema");
			}
		} else {
			viewTest.showMessage("La marca que ingreso no existe en el sistema");
		}
		return model;
	}
	
	public String showBrands() {
		String information = "";
		for(Brand i : simulatorTest.getBrands()) {
			information += "\n-------------------" + i.getName() + "-------------------";
			information += showLines(i);
		}
		return information;
	}
	
	public String showLines(Brand brand) {
		String information = "";
		for(Line i : brand.getLines()) {
			information += "\n                    " + i.getName() + "                   ";
			information += showModels(i);
		}
		return information;
	}
	
	 public String showModels(Line line) {
		String information = "";
		for(Model i : line.getModels()) {
			information += "\n    Año: " + i.getYear() + "    Avaluo: " + i.getValue();
		}
		return information;
	}
	
	
	public void showTaxValue() {
		Model model = searchModel();
		if(model != null) {
			int taxValue = simulatorTest.taxValue(model);
			int discount = applyDiscounts(taxValue);
			if(discount > taxValue) {
				discount = taxValue;
			}
			viewTest.showMessage("Valor del avaluo de su vehiculo: " + model.getValue() + "\nValor parcial del impuesto: " + taxValue +
			 "\nValor del descuento: " + discount + "\nTotal a pagar: " + (taxValue - discount));
			
		}		
	}
	
	public int applyDiscounts(int taxValue) {
		boolean paySoon = responseDiscount(simulatorTest.getDiscounts().get(0).getName());
		boolean publicTransport = responseDiscount(simulatorTest.getDiscounts().get(1).getName()); 
		boolean enrolledInBoyaca = responseDiscount(simulatorTest.getDiscounts().get(2).getName());
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
	
	public String showDiscounts() {
		String discounts = "";
		for(int i = 0; i < simulatorTest.getDiscounts().size(); i++) {
			discounts += "------Descuento" + (i+1) + "------ \nNombre: " + simulatorTest.getDiscounts().get(i).getName() + 
					"\nPorcentaje: " + simulatorTest.getDiscounts().get(i).getPercent() + "\n\n";
		}
		return discounts;
	}
	
	public void modifyDiscounts() {
		for(int i = 0; i < simulatorTest.getDiscounts().size(); i++) {
			simulatorTest.getDiscounts().get(i).setName(viewTest.readString("Nuevo nombre para el descuento " + (i+1)));
			simulatorTest.getDiscounts().get(i).setPercent(Double.parseDouble(viewTest.readString("Nuevo porcentaje para el descuento " + (i+1))));
		}
	}
	
	public void optionTaxes() {
		int option = viewTest.readInt("1. Ver tabla de Impuestos \n2. Modificar Impuestos");
		if(option == 1) {
			viewTest.showMessage(showTaxes());
		} else if(option == 2) {
			modifyTaxes();
		}
	}
	
	public String showTaxes() {
		String discounts = "";
		for(Range i : simulatorTest.getRates()) {
			discounts += "------Impuesto------ \nMinimo: " + i.getMin()
					+ "\nMaximo: " + i.getMax() + "\nPorcentaje: " +  i.getPercent() + "\n\n";
		}
		return discounts;
	}
	
	public void modifyTaxes() {
		for(Range i : simulatorTest.getRates()) {
			i.setMin(viewTest.readInt("¿Nuevo valor para el minimo?"));
			i.setMax(viewTest.readInt("¿Nuevo maximo valor para el impuesto?"));
			i.setPercent(viewTest.readInt("¿Nuevo porcentaje para el impuesto?"));
		}
	}
	
	public void loadDates() {
		Brand brandTest = new Brand("chevrolet");
		Line lineTest = new Line("mx");
		Model modelTest = new Model(2010, 21350000);
		Brand brandTest2 = new Brand("bmw");
		Line lineTest2 = new Line("sport");
		Model modelTest2 = new Model(2020, 35000000);
		Line lineTest5 = new Line("Sprint");
		Brand brandTest3 = new Brand("Ford");
		Line lineTest3 = new Line("raptor");
		Model modelTest3 = new Model(2015, 80000000);
		Brand brandTest4 = new Brand("lamborgini");
		Line lineTest4 = new Line("murcielago");
		Model modelTest4 = new Model(2017, 300000000);
		Model modelTest5 = new Model(2004, 56000000);
		simulatorTest.addBrand(brandTest);
		simulatorTest.addLine(brandTest, lineTest);
		simulatorTest.addModel(brandTest, lineTest, modelTest);
		simulatorTest.addModel(brandTest, lineTest, modelTest2);
		simulatorTest.addBrand(brandTest2);
		simulatorTest.addLine(brandTest2, lineTest2);
		simulatorTest.addModel(brandTest2, lineTest2, modelTest2);
		simulatorTest.addModel(brandTest2, lineTest2, modelTest3);
		simulatorTest.addModel(brandTest2, lineTest2, modelTest4);
		simulatorTest.addModel(brandTest2, lineTest2, modelTest5);
		simulatorTest.addBrand(brandTest3);
		simulatorTest.addLine(brandTest3, lineTest3);
		simulatorTest.addModel(brandTest3, lineTest3, modelTest3);
		simulatorTest.addBrand(brandTest4);
		simulatorTest.addLine(brandTest4, lineTest4);
		simulatorTest.addModel(brandTest4, lineTest4, modelTest4);
		simulatorTest.addBrand(brandTest2);
		simulatorTest.addLine(brandTest2, lineTest5);
		simulatorTest.addModel(brandTest2, lineTest5, modelTest5);
	}
}
