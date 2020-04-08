package com.safetynet.model;

import java.util.List;

public class PersonEnfant {

	private int age;
	private Person person;
	private List<Person> membreFoyer;

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Person> getMembreFoyer() {
		return membreFoyer;
	}

	public void setMembreFoyer(List<Person> membreFoyer) {
		this.membreFoyer = membreFoyer;
	}
	
	public PersonEnfant(int age, Person person, List<Person> membreFoyer) {
		this.person = person;
		this.membreFoyer = membreFoyer;
		this.age = age;
	}


	@Override
	public String toString() {
		return "PersonEnfant [person=" + person + ", membreFoyer=" + membreFoyer + "]";
	}
}
