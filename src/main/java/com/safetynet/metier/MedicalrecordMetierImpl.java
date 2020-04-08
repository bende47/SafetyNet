package com.safetynet.metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;
import com.safetynet.model.Safetynet;

@Service
public class MedicalrecordMetierImpl implements MedicalrecordMetier{
	
	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private Safetynet safetynet;

	@Override
	public Safetynet addMedicalrecord(Map<?, ?> medicalRecord) {
		String date = medicalRecord.get("birthdate").toString();
		LocalDate bithDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/MM/yyyy"));
		List<String> medications = (List<String>) medicalRecord.get("medications");
		List<String> allergies = (List<String>) medicalRecord.get("allergies");

		Medicalrecord medicalrecord = new Medicalrecord(bithDate, medications, allergies);
		List<Person> persons = safetynet.getPersons();
		for (Person person : persons) {
			if (person.getFirstName().equals(medicalRecord.get("firstName").toString()) && person.getLastName().equals(medicalRecord.get("lastName").toString())) {
				person.setMedicalRecord(medicalrecord);
			}
		}
		
		return safetynet;
	}

	@Override
	public Safetynet updateMedicalrecord(Map<?, ?> medicalRecord) {
		String date = medicalRecord.get("birthdate").toString();
		LocalDate bithDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d/MM/yyyy"));
		List<String> medications = (List<String>) medicalRecord.get("medications");
		List<String> allergies = (List<String>) medicalRecord.get("allergies");

		Medicalrecord medicalrecord = new Medicalrecord(bithDate, medications, allergies);
		List<Person> persons = safetynet.getPersons();
		for (Person person : persons) {
			if (person.getFirstName().equals(medicalRecord.get("firstName").toString()) && person.getLastName().equals(medicalRecord.get("lastName").toString())) {
				person.setMedicalRecord(medicalrecord);
			}
		}

		return safetynet;
	}

	@Override
	public Safetynet deleteMedicalrecord(Map<?, ?> medicalRecord) {
		List<Person> persons = safetynet.getPersons();
		for (Person person : persons) {
			if (person.getFirstName().equals(medicalRecord.get("firstName").toString()) && person.getLastName().equals(medicalRecord.get("lastName").toString())) {
				person.getMedicalRecord().getAllergies().clear();
				person.getMedicalRecord().getMedications().clear();
			}
		}

		return safetynet;
	}

}
