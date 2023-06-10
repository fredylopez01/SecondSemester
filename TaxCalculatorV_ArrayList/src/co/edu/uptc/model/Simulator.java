package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.TreeSet;

public class Simulator {
	private ArrayList<Brand> brands;
	private ArrayList<Range> rates;
	private ArrayList<Discount> discounts;
	
	public Simulator() {
		brands = new ArrayList<Brand>();
		rates = new ArrayList<Range>();
		discounts = new ArrayList<Discount>();
		rates.add(new Range(0.015, 0, 30000000));
		rates.add(new Range(0.02, 30000000, 70000000));
		rates.add(new Range(0.025, 70000000, 1999999999));
		discounts.add(new Discount("Pago Oportuno", 0.10));
		discounts.add(new Discount("Transporte publico", 50000));
		discounts.add(new Discount("Matriculado en Boyaca", 0.20));
	}

	public boolean addBrand(Brand brand) {
		boolean add = false;
		for(Brand i : brands) {
			if(i.getName().equals(brand.getName())) {
				add = true;
			}
		}
		if(!add) {
			brands.add(brand);
			add = true;
		}
		return add;
	}
	
	public boolean addLine(Brand brand, Line line) {
		boolean add = false;
		for(Brand i : brands) {
			if(i.getName().equals(brand.getName())) {
				return i.addLine(line);
			}
		}
		return add;
	}
	
	public boolean addModel(Brand brand, Line line, Model model) {
		boolean add = false;
		for(Brand i : brands) {
			if(i.getName().equals(brand.getName())) {
				return i.addModel(line, model);
			}
		}
		return add;
	}
	
	public int taxValue(Model model) {
		int taxValue = 0;
		for(int i = 0; i < rates.size(); i++) {
			if(model.getValue() > rates.get(i).getMin() && model.getValue() < rates.get(i).getMax()) {
				taxValue = (int) (model.getValue()*rates.get(i).getPercent());
			}
		}
		return taxValue;
	}
	
	public int calculateDiscount(int taxValue, boolean paySoon, boolean publicTransport, boolean enrolledInBoyaca) {
		int discount = 0;
		if(paySoon) {
			discount += taxValue*discounts.get(0).getPercent();
		} 
		if(publicTransport) {
			discount += discounts.get(1).getPercent();
		}
		if(enrolledInBoyaca) {
			discount += taxValue*discounts.get(2).getPercent();
		}
		return discount;
	}
	
	public void modifyValue() {
		
	}
	
	public Model searchValue(Brand brand, Line line, int year) {
		Model model = null;
		Brand brandVerify = searchBrand(brand);
		if( brandVerify != null) {
			Line lineVerify = searchLine(brandVerify, line);
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
		for(Brand i : brands) {
			if(i.getName().equals(brand.getName())) {
				brandResult = i;
			}
		}
		return brandResult;
	}
	
	public Line searchLine(Brand brand, Line line) {
		Line lineResult = null;
		for(int i = 0; i < brand.getLines().size(); i++) {
			if(brand.getLines().get(i).getName().equals(line.getName())) {
				return brand.getLines().get(i);
			}
		}
		return lineResult;
	}
	
	public Model searchModel(Line line, int year) {
		Model modelResult = null;
		for(int i = 0; i < line.getModels().size(); i++) {
			if(line.getModels().get(i).getYear() == year) {
				modelResult = line.getModels().get(i);
			}
		}
		return modelResult;
	}
	
	public ArrayList<Brand> getBrands() {
		return brands;
	}

	public void setBrands(ArrayList<Brand> brands) {
		this.brands = brands;
	}

	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(ArrayList<Discount> discounts) {
		this.discounts = discounts;
	}

	public ArrayList<Range> getRates() {
		return rates;
	}

	public void setRates(ArrayList<Range> rates) {
		this.rates = rates;
	}
	
}
