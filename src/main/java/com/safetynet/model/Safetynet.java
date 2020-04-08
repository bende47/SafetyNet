package com.safetynet.model;

import java.util.List;
import java.util.Map;


public class Safetynet {


	private List<Person> persons;
	private Map<Integer, Firestation> firestations;
	private Map<String, List<Person>> personFoyers;
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public Map<Integer, Firestation> getFirestations() {
		return firestations;
	}
	public void setFirestations(Map<Integer, Firestation> firestations) {
		this.firestations = firestations;
	}
	public Map<String, List<Person>> getPersonFoyers() {
		return personFoyers;
	}
	public void setPersonFoyers(Map<String, List<Person>> personFoyers) {
		this.personFoyers = personFoyers;
	}
	public Safetynet(List<Person> persons, Map<Integer, Firestation> firestations,
			Map<String, List<Person>> personFoyers) {
		this.persons = persons;
		this.firestations = firestations;
		this.personFoyers = personFoyers;
	}
	
	@Override
	public String toString() {
		return "Safetynet [persons=" + persons + ", firestations=" + firestations + ", personFoyers=" + personFoyers
				+ "]";
	}

	
	
}
