package co.edu.uptc.model;

public class Values {
	
	public Values(Chair[][] executive, Chair[][] economic) {
		valuesExecutive(executive);
		valuesEconomic(economic);
	}
	
	public void valuesExecutive(Chair[][] executive) {
		executive = new Chair[2][4];
		for(int i = 0; i < executive.length; i++) {
			for(int j = 0; j < executive[0].length;j++) {
				if(i == 0) {
					executive[i][j] = new Chair(("A"+(j+1)));
				} else if(i == 1) {
					executive[i][j] = new Chair(("B"+(j+1)));
				}
				if(j == 0 || j == 3) {
					executive[i][j].setUbication("Window");
				} else if(j== 1 || j == 2) {
					executive[i][j].setUbication("Hallway");
				}
			}
		}
	}
	
	public void valuesEconomic( Chair[][] economic) {
		economic = new Chair[7][6];
		for(int i = 0; i < economic.length; i++) {
			for(int j = 0; j < economic[0].length;j++) {
				if(i == 0) {
					economic[i][j] = new Chair(("A"+(j+1)));
				} else if(i == 1) {
					economic[i][j] = new Chair(("B"+(j+1)));
				} else if(i == 2) {
					economic[i][j] = new Chair(("C"+(j+1)));
				} else if(i == 3) {
					economic[i][j] = new Chair(("D"+(j+1)));
				} else if(i == 4) {
					economic[i][j] = new Chair(("E"+(j+1)));
				} else if(i == 5) {
					economic[i][j] = new Chair(("F"+(j+1)));
				} else if(i == 6) {
					economic[i][j] = new Chair(("G"+(j+1)));
				}
				if(j == 0 || j == 5) {
					economic[i][j].setUbication("Window");
				} else if(j== 1 || j == 4) {
					economic[i][j].setUbication("Center");
				} else if(j== 2 || j == 3) {
					economic[i][j].setUbication("Hallway");
				} 
			}
		}
	}
}
