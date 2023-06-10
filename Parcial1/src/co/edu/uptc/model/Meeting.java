package co.edu.uptc.model;

public class Meeting {
	public final int MAX_ASSISTANTS = 100;
	private Assistant[] assistants;
	
	public Meeting() {
		assistants = new Assistant[MAX_ASSISTANTS];
	}
	
	public void addParticipant(Assistant assistant) {
		boolean add = false;
		for(int i = 0; i<assistants.length; i++) {
			if(assistants[i] == null && !add) {
				assistants[i] = assistant;
				add = true;
			}
		}
	}
	
	public void removeParticipant(int id) {
		for(int i = 0; i<assistants.length; i++) {
			if(assistants[i].getId() == id) {
				assistants[i] = null;
			}
		}
	}
	
	public int countParticipants() {
		int numParticipan = 0;
		for(int i = 0; i<assistants.length; i++) {
			if(assistants[i] != null) {
				numParticipan++;
			}
		}
		return numParticipan;
	}
	
	public int countAdulStudents() {
		Student studentTest;
		int numAdults = 0;
		for(int i = 0; i<assistants.length; i++) {
			if(assistants[i] instanceof Student) {
				studentTest = (Student) assistants[i];
				if(studentTest.isAdult()){
					numAdults++;
				}
			}
		}
		return numAdults;
	}
	
	public int countTeacherByProfession(int profession) {
		Teacher teacherTest;
		int numTeachers = 0;
		for(int i = 0; i<assistants.length; i++) {
			if(assistants[i] instanceof Teacher) {
				teacherTest = (Teacher) assistants[i];
				if(teacherTest.getProfession() == profession){
					numTeachers++;
				}
			}
		}
		return numTeachers;
	}
	
	public String dependencyWithMoreNumber() {
		Worker workerTest;
		int numTalentHuman = 0;
		int numTesorery = 0;
		int numJuridica = 0;
		String dependency = "";
		for(int i = 0; i<assistants.length; i++) {
			if(assistants[i] instanceof Worker) {
				workerTest = (Worker) assistants[i];
				if(workerTest.getDependency() == 1){
					numTalentHuman++;
				} else if(workerTest.getDependency() == 2) {
					numTesorery++;
				} else if(workerTest.getDependency() == 3) {
					numJuridica++;
				}
			}
		}
		if(numTalentHuman > numTesorery && numTalentHuman > numJuridica) {
			dependency = "Talento Humano";
		} else if(numTesorery > numTalentHuman && numTesorery > numJuridica) {
			dependency = "Tesoreria";
		} else if(numJuridica > numTalentHuman && numJuridica > numTesorery) {
			dependency = "Juridica";
		}
		return dependency;
	}

	public Assistant[] getAssistants() {
		return assistants;
	}

	public void setAssistants(Assistant[] assistants) {
		this.assistants = assistants;
	}
	
}
