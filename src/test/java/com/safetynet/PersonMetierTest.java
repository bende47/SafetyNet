package com.safetynet;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.safetynet.metier.PersonMetierImpl;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;
import com.safetynet.model.PersonInfo;

public class PersonMetierTest {
	
	private static PersonMetierImpl personMetier;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	String date1 = "10/10/1993";
	LocalDate birthdate1 = LocalDate.parse(date1, formatter);
	
	@BeforeAll
	private static void setUp() {
		personMetier = new PersonMetierImpl();
	}

	@Test
	@DisplayName("Update Person Test")
	public void updatePersonTest() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "01/01/2000";
		String date2 = "01/01/2020";

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
		getfirestations1.put(1, firestation1);

		Person person1 = new Person("Bende", "Kouame", "15010 Culver St", "city1", "69100", "123-123", "bendejustin@gmail.com");
		Person person2 = new Person("Bende", "adou", "15010 Culver St", "city1", "69100", "123-123", "bendejustin@gmail.com");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);
		List<Person> listPerson = new ArrayList<>();
		listPerson.add(person1);
		listPerson.add(person2);

		List<Person> test = personMetier.updatePerson(listPerson, person1, "Bende", "Kouame");

		assertEquals(listPerson.toString(), test.toString());
	}

	@Test
	@DisplayName("Delete Person test")
	public void deletePersonMetierTest() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/2010";

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
		getfirestations1.put(1, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);

		List<Person> listPerson1 = new ArrayList<>();
		listPerson1.add(person1);
		listPerson1.add(person2);

		List<Person> listPerson2 = new ArrayList<>();
		listPerson2.add(person2);

		List<Person> test = personMetier.deletePersonne("name1", "lastname1", listPerson1);

		assertEquals(listPerson2.toString(), test.toString());
	}

	@Test
	@DisplayName("phone Alert test")
	public void phoneAlertMetier() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/2010";

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
		getfirestations1.put(1, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);

		List<Person> listPerson1 = new ArrayList<>();
		listPerson1.add(person1);
		listPerson1.add(person2);
		List<String> phoneList = new ArrayList<>();
		phoneList.add("123-123");
		phoneList.add("123-123");

		List<String> test = personMetier.phoneAlert("1", getfirestations1, listPerson1);

		assertEquals(phoneList.toString(), test.toString());
	}

	@Test
	@DisplayName("Person info test")
	public void personInfoMetierTest() throws ParseException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/2010";

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
		getfirestations1.put(1, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);

		List<Person> listPerson1 = new ArrayList<>();
		listPerson1.add(person1);
		listPerson1.add(person2);

		PersonInfo person3 = new PersonInfo("name1", "lastname1", 35, "15010 Culver St", "city1", "007", "123-123",
				"de@de.fr", Medicalrecords1);
		PersonInfo person4 = new PersonInfo("name2", "lastname2", 9, "15010 Culver St", "city1", "007", "123-123",
				"de@de.fr", Medicalrecords2);

		List<PersonInfo> listPerson2 = new ArrayList<>();
		listPerson2.add(person3);

		List<PersonInfo> test = personMetier.listPersonInfo("name1", "lastname1", listPerson1);

		assertEquals(listPerson2.toString(), test.toString());
	}

	@Test
	@DisplayName("Community Email test")
	public void communityEmailMetier() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date1 = "03/06/1984";
		String date2 = "03/06/2010";

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
		getfirestations1.put(1, firestation1);

		Person person1 = new Person("name1", "lastname1", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		Person person2 = new Person("name2", "lastname2", "15010 Culver St", "city1", "007", "123-123", "de@de.fr");
		person1.setMedicalRecord(Medicalrecords1);
		person2.setMedicalRecord(Medicalrecords2);

		List<Person> listPerson1 = new ArrayList<>();
		listPerson1.add(person1);
		listPerson1.add(person2);

		List<String> mailList = new ArrayList<>();
		mailList.add("de@de.fr");
		mailList.add("de@de.fr");

		List<String> test = personMetier.communityEmail("city1", listPerson1);

		assertEquals(mailList.toString(), test.toString());
	}
	
	

	@Test
	@DisplayName("Person adulte")
	public void personAdulteTest() throws ParseException {
		boolean adulte = personMetier.personAdulte(birthdate1);
		assertEquals(true, adulte);
	}

	@Test
	@DisplayName("Calcul age")
	public void determinerAgeTest() throws ParseException {
		int age = personMetier.determineAge(birthdate1);
		assertEquals(26, age);
	}
	
}
