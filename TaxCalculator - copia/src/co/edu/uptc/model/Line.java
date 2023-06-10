package co.edu.uptc.model;

public class Line {
	private String name;
	private Model[] models;
	
	public Line(String name, Model[] models) {
		models = new Model[40];
		this.name = name;
		this.models = models;
	}
	
	public boolean addModel(Model model) {
		boolean add = false;
		for(int i = 0; i<models.length; i++) {
			if(models[i] != null && models[i].getYear() == (model.getYear())) {
				add = true;
			}
			if(models[i] == null && !add) {
				models[i] = model;
				add = true;
			}
		}
		return add;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Model[] getModels() {
		return models;
	}

	public void setModels(Model[] models) {
		this.models = models;
	}
	
}
