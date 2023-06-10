package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.TreeSet;

public class Simulator {
	private TreeSet<Brand> brands;
	private TreeSet<Range> rates;
	private ArrayList<Discount> discounts;
	
	public Simulator() {
		brands = new TreeSet<Brand>();
		rates = new TreeSet<Range>();
		discounts = new ArrayList<Discount>();
		rates.add(new Range(0.015, 0, 30000000));
		rates.add(new Range(0.02, 30000000, 70000000));
		rates.add(new Range(0.025, 70000000, 1999999999));
		discounts.add(new Discount("Pago Oportuno", 0.10));
		discounts.add(new Discount("Transporte publico", 50000));
		discounts.add(new Discount("Matriculado en Boyaca", 0.20));
	}

	public boolean addBrand(Brand brand) {
		return brands.add(brand);
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
		for(Range i : rates) {
			if(model.getValue() > i.getMin() && model.getValue() < i.getMax()) {
				taxValue = (int) (model.getValue()*i.getPercent());
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
		for(Line i : brand.getLines()) {
			if(i.getName().equals(line.getName())) {
				return i;
			}
		}
		return lineResult;
	}
	
	public Model searchModel(Line line, int year) {
		Model modelResult = null;
		for(Model i : line.getModels()) {
			if(i.getYear() == year) {
				modelResult = i;
			}
		}
		return modelResult;
	}
	
	public TreeSet<Brand> getBrands() {
		return brands;
	}

	public void setBrands(TreeSet<Brand> brands) {
		this.brands = brands;
	}

	public ArrayList<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(ArrayList<Discount> discounts) {
		this.discounts = discounts;
	}

	public TreeSet<Range> getRates() {
		return rates;
	}

	public void setRates(TreeSet<Range> rates) {
		this.rates = rates;
	}
	
}
