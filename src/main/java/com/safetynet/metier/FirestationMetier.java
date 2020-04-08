package com.safetynet.metier;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.PersonHabitant;
import com.safetynet.model.PersonStation;
import com.safetynet.model.Safetynet;

public interface FirestationMetier {
	/**
	 * 
	 * @param firestation
	 * @return
	 */
	public Safetynet addFirestation(Map<?, ?> firestation);
	
	/**
	 * 
	 * @param stationNumber
	 * @param stationAdress
	 * @param getfirestations
	 * @return
	 */
	public Map<Integer, Firestation> updateFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations);
	
	/**
	 * 
	 * @param stationNumber
	 * @param stationAdress
	 * @param firestations
	 * @return
	 */
	public Map<Integer, Firestation> deleteFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> firestations);	
	
	/**
	 * 
	 * @param stationNumber
	 * @param firestations
	 * @param listPerson
	 * @return
	 * @throws ParseException
	 */
	public  PersonStation stationNumber(String stationNumber,
			Map<Integer, Firestation> firestations,List<Person> listPerson) throws ParseException;
	
	/**
	 * 
	 * @param address
	 * @param listPerson
	 * @param firestations
	 * @return
	 * @throws ParseException
	 */
	public  List<PersonHabitant> fire(String address, List<Person> listPerson,
			Map<Integer, Firestation> firestations) throws ParseException;
	
	/**
	 * 
	 * @param stations
	 * @param firestations
	 * @param personFoyers
	 * @return
	 * @throws ParseException
	 */
	public  List<Person> flood(String stations, Map<Integer, Firestation> firestations,
			Map<String, List<Person>> personFoyers) throws ParseException ;
	
}
