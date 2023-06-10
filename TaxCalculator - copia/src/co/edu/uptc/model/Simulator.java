package co.edu.uptc.model;

public class Simulator {
	private Brand[] brands;
	private Range[] rates;
	private Discount[] discounts;
	
	public Simulator() {
		brands = new Brand[100];
		rates = new Range[3];
		rates[0] = new Range(0.015, 0, 30000000);
		rates[1] = new Range(0.02, 30000000, 70000000);
		rates[2] = new Range(0.025, 70000000, 1999999999);
		discounts = new Discount[3];
		discounts[0] = new Discount("Pago Oportuno", 0.10);
		discounts[1] = new Discount("Transporte publico", 50000);
		discounts[2] = new Discount("Matriculado en Boyaca", 0.20);
	}

	public boolean addBrand(Brand brand) {
		boolean add = false;
		for(int i = 0; i<brands.length; i++) {
			if(brands[i] != null && brands[i].getName().equals(brand.getName())) {
				add = true;
			}
			if(brands[i] == null && !add) {
				brands[i] = brand;
				add = true;
			}
		}
		return add;
	}
	
	public boolean addLine(Brand brand, Line line) {
		boolean add = false;
		for(int i = 0; i<brands.length; i++) {
			if(brands[i] != null && brands[i].getName().equals(brand.getName()) && !add) {
				if(brands[i].addLine(line)) {
					add = true;
				}
			}
		}
		return add;
	}
	
	public boolean addModel(Brand brand, Line line, Model model) {
		boolean add = false;
		for(int i = 0; i<brands.length; i++) {
			if(brands[i] != null && brands[i].getName().equals(brand.getName()) && !add) {
				if(brands[i].addModel(line, model)) {
					add = true;
				}
			}
		}
		return add;
	}
	
	public int taxValue(Model model) {
		int taxValue = 0;
		for(int i = 0; i < rates.length; i++) {
			if(model.getValue() > rates[i].getMin() && model.getValue() < rates[i].getMax()) {
				taxValue = (int) (model.getValue()*rates[i].getPercent());
			}
		}
		return taxValue;
	}
	
	public int calculateDiscount(int taxValue, boolean paySoon, boolean publicTransport, boolean enrolledInBoyaca) {
		int discount = 0;
		if(paySoon) {
			discount += taxValue*discounts[0].getPercent();
		} 
		if(publicTransport) {
			discount += discounts[1].getPercent();
		}
		if(enrolledInBoyaca) {
			discount += taxValue*discounts[2].getPercent();
		}
		return discount;
	}
	
	public void modifyValue() {
		
	}
	
	public Model searchValue(Brand brand, Line line, int year) {
		Model model = null;
		Brand brandVerify = searchBrand(brand);
		if( brandVerify != null) {
			Line lineVerify = searcheLine(brandVerify, line);
			if(lineVerify != null) {
				Model modelVerify = searchModel(lineVerify, year);
				if(modelVerify != null) {
					model = modelVerify;
				} 
			}
		}
		return model;
	}

	public Brand searchBrand(Brand brand) {
		Brand brandResult = null;
		for(int i = 0; i < brands.length; i++) {
			if(brands[i] != null && brands[i].getName().equals(brand.getName())) {
				brandResult = brands[i];
			}
		}
		return brandResult;
	}
	
	public Line searcheLine(Brand brand, Line line) {
		Line lineResult = null;
		for(int i = 0; i < brand.getLines().length; i++) {
			if(brand.getLines()[i] != null && brand.getLines()[i].getName().equals(line.getName())) {
				lineResult = brand.getLines()[i];
			}
		}
		return lineResult;
	}
	
	public Model searchModel(Line line, int year) {
		Model modelResult = null;
		for(int i = 0; i < line.getModels().length; i++) {
			if(line.getModels()[i] != null && line.getModels()[i].getYear() == year) {
				modelResult = line.getModels()[i];
			}
		}
		return modelResult;
	}
	
	public Brand[] getBrands() {
		return brands;
	}

	public void setBrands(Brand[] brands) {
		this.brands = brands;
	}

	public Discount[] getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Discount[] discounts) {
		this.discounts = discounts;
	}

	public Range[] getRates() {
		return rates;
	}

	public void setRates(Range[] rates) {
		this.rates = rates;
	}
	
}
