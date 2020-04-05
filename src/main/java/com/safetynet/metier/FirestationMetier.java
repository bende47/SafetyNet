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
	
	public Safetynet addFirestation(Map<?, ?> firestation);
	public Map<Integer, Firestation> updateFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations);
	public Map<Integer, Firestation> deleteFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> firestations);	
	public  PersonStation stationNumber(String stationNumber,
			Map<Integer, Firestation> firestations,List<Person> listPerson) throws ParseException;
	public  List<PersonHabitant> fire(String address, List<Person> listPerson,
			Map<Integer, Firestation> firestations) throws ParseException;
	public  List<Person> flood(String stations, Map<Integer, Firestation> firestations,
			Map<String, List<Person>> personFoyers) throws ParseException ;
	
}
