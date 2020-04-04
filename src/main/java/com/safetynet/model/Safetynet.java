package com.safetynet.model;

import java.util.List;
import java.util.Map;


public class Safetynet {


	private List<Person> persons;
	private Map<Integer, Firestation> firestations;
	private Map<String, List<Person>> foyers;

	public Safetynet(List<Person> persons, Map<Integer, Firestation> firestations,
			Map<String, List<Person>> foyer) {
		this.persons = persons;
		this.firestations = firestations;
		this.foyers = foyer;
	}

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

	public Map<String, List<Person>> getFoyer() {
		return foyers;
	}

	public void setFoyer(Map<String, List<Person>> foyer) {
		this.foyers = foyer;
	}

	@Override
	public String toString() {
		return "SafetyNetModel [persons=" + persons + ", firestations=" + firestations + ", foyer=" + foyers + "]";
	}

}
