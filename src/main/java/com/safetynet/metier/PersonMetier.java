package com.safetynet.metier;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.PersonInfo;

public interface PersonMetier {	
	public List<Person> addPerson(Person p);
	public List<Person> updatePerson(Person p);
	public List<Person> deletePersonne(Person p);	
	
	public boolean personAdulte(LocalDate date) throws ParseException;
	public int determineAge(LocalDate date) throws ParseException;
	public List<String> phoneAlert(String firestationnumber, Map<Integer, Firestation> firestation,
			List<Person> listPerson);	
	public List<PersonInfo> listPersonInfo(String firstName, String lastName, List<Person> listPerson)
			throws ParseException ;	
	public List<String> communityEmail(String city, List<Person> listPerson);
	
}
