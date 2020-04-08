package com.safetynet.model;

public class PersonHabitant {
	private int age;
	private Person person;
	private int station;

	
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

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}
	
	public PersonHabitant(int age, Person person, int station) {
		this.person = person;
		this.station = station;
		this.age = age;
	}

	@Override
	public String toString() {
		return "PersonHabitant [person=" + person + ", station=" + station + "]";
	}

}
