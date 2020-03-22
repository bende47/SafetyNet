package com.safetynet.metier;

import java.util.List;

import com.safetynet.model.Person;

public interface PersonMetier {	
	public List<Person> addPerson(Person p);
	public List<Person> updatePerson(Person p);
	public List<Person> deletePersonne(Person p);	
}
