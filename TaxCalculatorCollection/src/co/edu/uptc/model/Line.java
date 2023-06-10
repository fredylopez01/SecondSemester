package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.TreeSet;

public class Line implements Comparable<Line>{
	private String name;
	private TreeSet<Model> models;
	
	public Line(String name) {
		models = new TreeSet<Model>();
		this.name = name;
	}
	
	public boolean addModel(Model model) {
		return models.add(model);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeSet<Model> getModels() {
		return models;
	}

	public void setModels(TreeSet<Model> models) {
		this.models = models;
	}

	@Override
	public int compareTo(Line o) {
		return name.compareTo(o.name);
	}
	
}
