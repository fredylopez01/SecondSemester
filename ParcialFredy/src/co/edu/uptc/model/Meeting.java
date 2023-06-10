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
			if(assistants[i] != null && assistants[i].getId() == id) {
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
	
	public int countTeacherByProfession(Profession profession) {
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
	
	public Dependency dependencyWithMoreNumber() {
		int numTalentHuman = 0;
		int numTesorery = 0;
		int numJuridica = 0;
		for(int i = 0; i<assistants.length; i++) {
			if(assistants[i] instanceof Worker) {
				if(((Worker) assistants[i]).getDependency() == Dependency.TALENTO_HUMANO){
					numTalentHuman++;
				} else if(((Worker) assistants[i]).getDependency() == Dependency.TESORERIA) {
					numTesorery++;
				} else if(((Worker) assistants[i]).getDependency() == Dependency.JURIDICA) {
					numJuridica++;
				}
			}
		}
		return increasedDependency(numTalentHuman, numTesorery, numJuridica);
	}
	
	public Dependency increasedDependency(int numTalentHuman, int numTesorery, int numJuridica) {
		Dependency dependency = null;
		if(numTalentHuman > numTesorery && numTalentHuman > numJuridica) {
			dependency = Dependency.TALENTO_HUMANO;
		} else if(numTesorery > numTalentHuman && numTesorery > numJuridica) {
			dependency = Dependency.TESORERIA;
		} else if(numJuridica > numTalentHuman && numJuridica > numTesorery) {
			dependency = Dependency.JURIDICA;
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

