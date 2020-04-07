package com.safetynet.metier;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.PersonEnfant;
import com.safetynet.model.PersonInfo;

public interface PersonMetier {	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public List<Person> addPerson(Map<?, ?> person);
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public List<Person> updatePerson(List<Person> listPerson, Person persons, String firstname,
			String lastName);
	/**
	 * 
	 * @param p
	 * @return
	 */
	public List<Person> deletePersonne(String firstName, String lastName, List<Person> listPersons);	
	
	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public boolean personAdulte(LocalDate date) throws ParseException;
	
	/**
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public int determineAge(LocalDate date) throws ParseException;
	
	/**
	 * 
	 * @param personFoyers
	 * @param childlist
	 * @param address
	 * @return
	 * @throws ParseException
	 */	
	public  List<PersonEnfant> listEnfant(Map<String, List<Person>> personFoyers, List<PersonEnfant> childlist,
			String address) throws ParseException ;
	
	/**
	 * 
	 * @param firestationnumber
	 * @param firestation
	 * @param listPerson
	 * @return
	 */
	public List<String> phoneAlert(String firestationnumber, Map<Integer, Firestation> firestation,
			List<Person> listPerson);	
	
	/**
	 * 
	 * @param firstName
	 * @param lastName
	 * @param listPerson
	 * @return
	 * @throws ParseException
	 */
	public List<PersonInfo> listPersonInfo(String firstName, String lastName, List<Person> listPerson)
			throws ParseException ;	
	/**
	 * 
	 * @param city
	 * @param listPerson
	 * @return
	 */
	public List<String> communityEmail(String city, List<Person> listPerson);
	
}
