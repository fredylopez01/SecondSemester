package co.edu.uptc.model;

import java.util.TreeSet;

public class Brand implements Comparable<Brand>{
	private String name;
	private TreeSet<Line> lines;
	
	public Brand(String name) {
		lines = new TreeSet<Line>();
		this.name = name;
	}
	
	
	public boolean addLine(Line line) {
		return lines.add(line);
	}
	
	public boolean addModel(Line line, Model model) {
		boolean add = false;
		for(Line i : lines) {
			if(i.getName().equals(line.getName()) && !add) {
				if(i.addModel(model)) {
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
	
	public TreeSet<Line> getLines() {
		return lines;
	}
	
	public void setLines(TreeSet<Line> lines) {
		this.lines = lines;
	}

	@Override
	public int compareTo(Brand o) {
		return name.compareTo(o.name);
	}
	
}
