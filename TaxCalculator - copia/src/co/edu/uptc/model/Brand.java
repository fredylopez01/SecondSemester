package co.edu.uptc.model;

public class Brand {
	private String name;
	private Line[] lines;
	
	public Brand(String name, Line[] lines) {
		lines = new Line[50];
		this.name = name;
		this.lines = lines;
	}
	
	
	public boolean addLine(Line line) {
		boolean add = false;
		for(int i = 0; i < lines.length; i++) {
			if(lines[i] != null && lines[i].getName().equals(line.getName())) {
				add = true;
			}
			if(lines[i] == null && !add) {
				lines[i] = line;
				add = true;
			}
		}
		return add;
	}
	
	public boolean addModel(Line line, Model model) {
		boolean add = false;
		for(int i = 0; i < lines.length; i++) {
			if(lines[i] != null && lines[i].getName().equals(line.getName()) && !add) {
				if(lines[i].addModel(model)) {
					add = true;
				}
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
	
	public Line[] getLines() {
		return lines;
	}
	
	public void setLines(Line[] lines) {
		this.lines = lines;
	}
	
}
