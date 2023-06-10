package model;
import model.Ciclist;

public class Team {
	private Ciclist[] team; 
	
	public void startValues() {
		team = new Ciclist[12];
	}
	
	public boolean registerCyclist(Ciclist ciclistVerify) {
		boolean save = false;
		for (int i = 0; i < team.length && save == false; i++) {
			if(team[i] == null) {
				team[i] = ciclistVerify;
				save = true;
			}
		}
		return save;
	}
	
	public Ciclist viewInformationCiclist(int numberCiclist) {
		Ciclist ciclistVerify = null;
		for (int i = 0; i < team.length && ciclistVerify == null; i++) {
			if (team[i] != null) {
				if(team[i].getNumber() == numberCiclist) {
					ciclistVerify = team[i];
				}
			}
		}
		return ciclistVerify;
	}
	
	public int vacancies() {
		int numberVacancies = 0;
		for (int i = 0; i < team.length; i++) {
			if(team[i] == null) {
				numberVacancies++;
			}
		}
		return numberVacancies;
	}
	
	public int averageAge() {
		int addition = 0, divider = 0, average = 0;
		for (int i = 0; i < team.length; i++) {
			if(team[i] != null) {
				addition = addition + team[i].getAge();
				divider = divider + 1;
			}
		}
		if (divider >= 1) {
			average= addition/divider;
		} else {
			average = 0;
		}
		return average;
	}
	
	public boolean disassociationCyclist(int numCiclistDisassociation ) {
		boolean eliminate = false;
		for (int i = 0; i < team.length && eliminate == false; i++) {
			if(team[i] != null) {
				if(team[i].getNumber() == numCiclistDisassociation) {
					team[i] = null;
					eliminate = true;
				}
			}
		}
		return eliminate;
	}
}