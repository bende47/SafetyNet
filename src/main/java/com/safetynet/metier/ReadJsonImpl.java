package com.safetynet.metier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;
import com.safetynet.model.Safetynet;;

@Service
public class ReadJsonImpl implements ReadJson{

	@Override
	public Safetynet readFile(String file) throws IOException {
		
		byte[] bytes = Files.readAllBytes(new File(file).toPath());
		JsonIterator iteration = JsonIterator.parse(bytes);

		Any any = iteration.readAny();
		Any personAny = any.get("persons");
		List<Person> persons = new ArrayList<>();
		Map<String, List<Person>> foyers = new HashMap<>();
		personAny.forEach(personJson -> {
			String firstName = personJson.get("firstName").toString();
			String lastName = personJson.get("lastName").toString();
			String address = personJson.get("address").toString();
			String city = personJson.get("city").toString();
			String zip = personJson.get("zip").toString();
			String phone = personJson.get("phone").toString();
			String email = personJson.get("email").toString();

			Person person = new Person(firstName, lastName, address, city, zip, phone, email);
			persons.add(person);
			List<Person> foyer = foyers.computeIfAbsent(address, temp -> new ArrayList<>());
			foyer.add(person);
		});

		Any firestationsAny = any.get("firestations");
		Map<Integer, Firestation> firestations = new HashMap<>();
		firestationsAny.forEach(firestationAny -> {
			int id = firestationAny.get("station").toInt();
			String address = firestationAny.get("address").toString();

			Firestation firestation = firestations.computeIfAbsent(id, currentId -> new Firestation(currentId));
			firestation.addAddress(address);
		});

		Any medicalRecordsAny = any.get("medicalrecords");
		medicalRecordsAny.forEach(medicalRecordAny -> {
			String firstName = medicalRecordAny.get("firstName").toString();
			String lastName = medicalRecordAny.get("lastName").toString();
			String birthdateStr = medicalRecordAny.get("birthdate").toString();
			LocalDate birthdate = LocalDate.parse(birthdateStr, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

			List<String> medications = new ArrayList<>();
			Any medicationsAny = medicalRecordAny.get("medications");
			medicationsAny.forEach(medicationAny -> medications.add(medicationAny.toString()));

			List<String> allergies = new ArrayList<>();
			Any allergiesAny = medicalRecordAny.get("allergies");
			allergiesAny.forEach(allergyAny -> allergies.add(allergyAny.toString()));

			searchPerson(firstName, lastName, persons)
					.setMedicalRecord(new Medicalrecord(birthdate, medications, allergies));

		});

		Safetynet safetyNet = new Safetynet(persons, firestations, foyers);

		return safetyNet;
	}

	@Override
	public Person searchPerson(String firstName, String lastName, List<Person> persons) {
		return persons.stream()
				.filter(person -> firstName.equals(person.getFirstName()) && lastName.equals(person.getLastName()))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("person " + firstName + " " + lastName + " not found"));
	}

	
	

}
