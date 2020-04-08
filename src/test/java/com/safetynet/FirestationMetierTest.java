package com.safetynet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.safetynet.metier.FirestationMetierImpl;
import com.safetynet.metier.PersonMetierImpl;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;
import com.safetynet.model.PersonStation;

public class FirestationMetierTest {
	
private static FirestationMetierImpl firestationMetier;
private static PersonMetierImpl personMetier;

	
	@BeforeAll
	private static void setUp() {
		firestationMetier = new FirestationMetierImpl();
		personMetier = new PersonMetierImpl();
	}
	
	@Test
	@DisplayName("Update Firestation test")
	public void updateFirestationTest() {

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("1509 Culver St");
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(1, firestation1);

		Firestation firestation = new Firestation(1);
		firestation.addAddress("1509 Culver St");
		Map<Integer, Firestation> getfirestations = new HashMap<Integer, Firestation>();
		getfirestations.put(1, firestation);
		firestationMetier.updateFirestation(1, "15010 Culver St", getfirestations);

		assertEquals(getfirestations1.toString(), getfirestations.toString());
	}

	@Test
	@DisplayName("Delete Firestation test")
	public void deleteFirestationTest() {

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(1, firestation1);

		Firestation firestation = new Firestation(1);
		firestation.addAddress("1509 Culver St");
		firestation.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations = new HashMap<Integer, Firestation>();
		getfirestations.put(1, firestation);
		firestationMetier.deleteFirestation(1, "1509 Culver St", getfirestations);

		assertEquals(getfirestations1.toString(), getfirestations.toString());
	}

	@Test
	@DisplayName("Station number test")
	public void stationNumberTest() throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "01/10/1993";
		String date2 = "01/10/2015";

		LocalDate birthdate1 = LocalDate.parse(date1, formatter);
		LocalDate birthdate2 = LocalDate.parse(date2, formatter);

		List<String> medication1 = new ArrayList<>();
		List<String> medication2 = new ArrayList<>();

		medication1.add("medication1");
		medication1.add("medication2");
		medication1.add("medication3");

		medication2.add("medication4");
		medication2.add("medication5");

		List<String> allergie1 = new ArrayList<>();
		List<String> allergie2 = new ArrayList<>();

		allergie1.add("allergie1");
		allergie1.add("allergie2");
		allergie1.add("allergie3");

		allergie2.add("allergie4");
		allergie2.add("allergie5");

		Medicalrecord Medicalrecords1 = new Medicalrecord(birthdate1, medication1, allergie1);
		Medicalrecord Medicalrecords2 = new Medicalrecord(birthdate2, medication2, allergie2);

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(2, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(person1);
		listPerson.add(person2);

		List<Person> listPersonResult = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();
				
		for (Entry<Integer, Firestation> keys : getfirestations1.entrySet()) {
			Firestation fire = getfirestations1.get(Integer.parseInt("2"));

			if (fire.getStation() == Integer.parseInt("2")) {
				addresses = fire.getAddresses();
			}
        }

		for (Person person : listPerson) {
			if (addresses.contains(person.getAddress())) {
				listPersonResult.add(person);
			}
		}

		int nbrAdult = 0;
		for (Person person : listPersonResult) {
			if (personMetier.personAdulte(person.getMedicalRecord().getBirthdate())) {
				nbrAdult++;
			}
		}

		int nbrChild = listPersonResult.size() - nbrAdult;

		PersonStation listpersonStation = new PersonStation(listPersonResult, nbrAdult, nbrChild);

		PersonStation test = firestationMetier.stationNumber("2", getfirestations1, listPerson);

		assertEquals(listpersonStation.toString(), test.toString());
	}

	

	@Test
	@DisplayName("flood test")
	public void floodTest() throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "01/10/1993";
		String date2 = "01/10/2015";

		LocalDate birthdate1 = LocalDate.parse(date1, formatter);
		LocalDate birthdate2 = LocalDate.parse(date2, formatter);

		List<String> medication1 = new ArrayList<>();
		List<String> medication2 = new ArrayList<>();

		medication1.add("medication1");
		medication1.add("medication2");
		medication1.add("medication3");

		medication2.add("medication4");
		medication2.add("medication5");

		List<String> allergie1 = new ArrayList<>();
		List<String> allergie2 = new ArrayList<>();

		allergie1.add("allergie1");
		allergie1.add("allergie2");
		allergie1.add("allergie3");

		allergie2.add("allergie4");
		allergie2.add("allergie5");

		Medicalrecord Medicalrecords1 = new Medicalrecord(birthdate1, medication1, allergie1);
		Medicalrecord Medicalrecords2 = new Medicalrecord(birthdate2, medication2, allergie2);

		Firestation firestation1 = new Firestation(1);
		firestation1.addAddress("15010 Culver St");
		Map<Integer, Firestation> getfirestations1 = new HashMap<Integer, Firestation>();
		getfirestations1.put(2, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(person1);
		listPerson.add(person2);

		Map<String, List<Person>> getFoyers = new HashMap<>();
		getFoyers.put("15010 Culver St", listPerson);

		List<Person> listPersonResult = new ArrayList<Person>();
		Set<String> addresses = new HashSet<String>();
		
		for (Entry<Integer, Firestation> keys : getfirestations1.entrySet()) {
			Firestation fire = getfirestations1.get(Integer.parseInt("2"));

			if (fire.getStation() == Integer.parseInt("2")) {
				addresses = fire.getAddresses();
			}
        }
		
		for (Entry<String, List<Person>> keys : getFoyers.entrySet()) {
			List<Person> persons = getFoyers.get(keys.getKey());
			for (Person person : persons) {
				if (addresses.contains(person.getAddress())) {
					listPersonResult.add(person);
				}
			}
        }	

		List<Person> test = firestationMetier.flood("2", getfirestations1, getFoyers);

		assertEquals(listPersonResult.toString(), test.toString());
	}
}
