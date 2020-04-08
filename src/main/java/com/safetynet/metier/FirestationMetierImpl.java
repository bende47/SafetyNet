package com.safetynet.metier;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.PersonHabitant;
import com.safetynet.model.PersonStation;
import com.safetynet.model.Safetynet;

@Service
public class FirestationMetierImpl implements FirestationMetier {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private Safetynet safetynet;
	
	@Autowired
	private PersonMetier personMetier;

	@Override
	public Safetynet addFirestation(Map<?, ?> f) {		
		
		Firestation firestation = safetynet.getFirestations().get(Integer.parseInt(f.get("station").toString()));		
		firestation.addAddress(f.get("address").toString());
		logger.info("@RequestBody = {}", f);
		logger.info("Response {} ", safetynet.getFirestations());
		logger.info("Nombre de firestation = {}", safetynet.getFirestations().size());
		return safetynet;
	}

	@Override
	public Map<Integer, Firestation> updateFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations) {
			
		for (Entry<Integer, Firestation> keys : getfirestations.entrySet()) {
			Firestation fire = getfirestations.get(keys.getKey());
			if (fire.getAddresses().contains(stationAdress)) {
				fire.getAddresses().remove(stationAdress);
			}
			if (fire.getStation() == stationNumber) {
				fire.addAddress(stationAdress);
			}
        }
		
		return getfirestations;
	}
	
	@Override
	public Map<Integer, Firestation> deleteFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations) {
		
		for (Entry<Integer, Firestation> keys : getfirestations.entrySet()) {
			Firestation fire = getfirestations.get(keys.getKey());
			if (fire.getAddresses().contains(stationAdress)) {
				fire.getAddresses().remove(stationAdress);
			}
        }
		
		return getfirestations;
	}

	@Override
	public PersonStation stationNumber(String stationNumber, Map<Integer, Firestation> firestations,
			List<Person> listPerson) throws ParseException {
		List<Person> listPersonInfo = new ArrayList<>();
		Set<String> addresses = new HashSet<>();
		
		for (Entry<Integer, Firestation> keys : firestations.entrySet()) {
			Firestation fire = firestations.get(Integer.parseInt(stationNumber));
			if (fire.getStation() == Integer.parseInt(stationNumber)) {
				addresses = fire.getAddresses();
			}
        }

		for (Person person : listPerson) {
			if (addresses.contains(person.getAddress())) {
				listPersonInfo.add(person);
			}
		}

		int adulte = 0;
		for (Person person : listPersonInfo) {
			if (personMetier.personAdulte(person.getMedicalRecord().getBirthdate())) {
				adulte++;
			}
		}
		int enfant = listPersonInfo.size() - adulte;
		PersonStation listpersonStation = new PersonStation(listPersonInfo, adulte, enfant);

		return listpersonStation;
	}

	@Override
	public List<PersonHabitant> fire(String address, List<Person> listPerson, Map<Integer, Firestation> firestations)
			throws ParseException {
		List<PersonHabitant> listPersonHabitant = new ArrayList<>();

		for (Entry<Integer, Firestation> keys : firestations.entrySet()) {
			Firestation fire = firestations.get(keys.getKey());
			if (fire.getAddresses().contains(address)) {
				int stationNum = fire.getStation();
				for (Person person : listPerson) {
					if (person.getAddress().equals(address)) {
						int age = personMetier.determineAge(person.getMedicalRecord().getBirthdate());
						PersonHabitant persHabitant = new PersonHabitant(age, person, stationNum);
						listPersonHabitant.add(persHabitant);
					}
				}
			}
			
        }
		
		return listPersonHabitant;
	}

	@Override
	public List<Person> flood(String stations, Map<Integer, Firestation> firestations, Map<String, List<Person>> Foyers)
			throws ParseException {

		List<Person> listPersonInfo = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();
		
		for (Entry<Integer, Firestation> keys : firestations.entrySet()) {
			Firestation fire = firestations.get(Integer.parseInt(stations));
			if (fire.getStation() == Integer.parseInt(stations)) {
				addresses = fire.getAddresses();
			}
        }
		
		for (Entry<String, List<Person>> keys : Foyers.entrySet()) {
			List<Person> persons = Foyers.get(keys.getKey());
			for (Person person : persons) {
				if (addresses.contains(person.getAddress())) {
					listPersonInfo.add(person);
				}
			}
        }		

		return listPersonInfo;
	}

}
