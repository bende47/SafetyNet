package com.safetynet.metier;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
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
import com.safetynet.model.PersonEnfant;
import com.safetynet.model.PersonInfo;
import com.safetynet.model.Safetynet;

@Service
public class PersonMetierImpl implements PersonMetier {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private Safetynet safetynet;
	
	private  Calendar calendar = Calendar.getInstance();
	Person person=null;

	@Override
	public List<Person> addPerson(Map<?, ?>  p) {		
		person = new Person(p.get("firstName").toString(), p.get("lastName").toString(), p.get("address").toString(), p.get("city").toString(), p.get("zip").toString(), p.get("phone").toString(), p.get("email").toString());
		safetynet.getPersons().add(person);
		logger.info("@RequestBody = {}", person);
		logger.info("Response {} ", safetynet.getPersons());
		logger.info("Nombre de personnes = {}", safetynet.getPersons().size());
		return safetynet.getPersons();
	}

	@Override
	public List<Person> updatePerson(List<Person> listPerson, Person persons, String firstname,
			String lastName) {
		for (Person person : listPerson) {
			if(person.getLastName().equals(lastName) && person.getFirstName().equals(firstname)) {
				person.setAddress(persons.getAddress());
				person.setCity(persons.getCity());
				person.setZip(persons.getZip());
				person.setPhone(persons.getPhone());
				person.setEmail(persons.getEmail());
			}
		}
		logger.info("@RequestBody = {}", persons);
		logger.info("Nombre de personnes = {}", listPerson.size());
		return listPerson;
	}

	@Override
	public List<Person> deletePersonne(String firstName, String lastName, List<Person> listPersons) {	 
	 int j=0;
	 int i=0;
		for (Person person : listPersons) {
			if(person.getLastName().equals(lastName) && person.getFirstName().equals(firstName)) {				
				j = i   ;
			}
			i++;
		}			
		listPersons.remove(j);
		logger.info(listPersons);
		return listPersons;
	}

	@Override
	public boolean personAdulte(LocalDate date) throws ParseException {
		
		/*Determiner l'annee */
		int annee=date.getYear();
		int calannee=calendar.get(Calendar.YEAR)-annee;
		
		/*Determiner le mois*/
		int mois=date.getMonthValue();
		int calmois=calendar.MONTH - mois;
		
		/*Determiner le jour*/
		int jour = date.getDayOfMonth();
		int caljour=calendar.DAY_OF_MONTH - jour;

		if (calannee > 18 || calannee == 18 && calmois >= 0 || calannee == 18 && calmois == 0 && caljour >= 0) {
			logger.debug("Adult = {}", true);
			return true;
		} else {
			logger.debug("Adult =  {}", false);
			return false;
		}
	}

	@Override
	public int determineAge(LocalDate date) throws ParseException {
		/*Determiner l'annee */
		int annee=date.getYear();
		int calannee=calendar.get(Calendar.YEAR)-annee;
		
		/*Determiner le mois*/
		int mois=date.getMonthValue();
		int calmois=calendar.MONTH - mois;
		
		/*Determiner le jour*/
		int jour = date.getDayOfMonth();
		int caljour=calendar.DAY_OF_MONTH - jour;

		if (calmois >= 0 || calmois == 0 &&  calmois>= 0) {
			logger.debug("age = {}", calannee);
			return calannee;
		} else {
			logger.debug("age = {}", calannee - 1);
			return calannee - 1;
		}
	}

	@Override
	public List<String> phoneAlert(String firestation_number, Map<Integer, Firestation> firestation,
			List<Person> listPerson) {
		
		List<String> listNumero = new ArrayList<>();
		Set<String> addresses = new HashSet<>();

		Set cles = firestation.keySet();
		Iterator it = cles.iterator();
		while (it.hasNext()) {
			Object station = it.next();
			Firestation firestations = firestation.get(Integer.parseInt(firestation_number));

			if (firestations.getStation() == Integer.parseInt(firestation_number)) {
				addresses = firestations.getAddresses();
			}
		}

		for (Person person : listPerson) {
			if (addresses.contains(person.getAddress())) {
				listNumero.add(person.getPhone());
			}
		}
		return listNumero;
	}

	@Override
	public List<PersonInfo> listPersonInfo(String firstName, String lastName, List<Person> listPerson)
			throws ParseException {
		List<PersonInfo> listInfoPersons = new ArrayList<>();

		for (Person person : listPerson) {
			if (person.getLastName().equals(lastName)) {
				int age = determineAge(person.getMedicalRecord().getBirthdate());
				PersonInfo peronInfo = new PersonInfo(person.getFirstName(), person.getLastName(), age,
						person.getAddress(), person.getCity(), person.getZip(), person.getPhone(), person.getEmail(),
						person.getMedicalRecord());
				listInfoPersons.add(peronInfo);
			}
		}
		return listInfoPersons;
	}

	@Override
	public List<String> communityEmail(String city, List<Person> listPerson) {
		List<String> listEmail = new ArrayList<>();
		for (Person person : listPerson) {
			if(person.getCity().equals(city)) {
				listEmail.add(person.getEmail());
			}
		}
		return listEmail;
	}

	@Override
	public List<PersonEnfant> listEnfant(Map<String, List<Person>> personFoyers, List<PersonEnfant> listEnfant,
			String address) throws ParseException {
		personFoyers.entrySet();
		for (Entry<String, List<Person>> entry : personFoyers.entrySet()) {
			String foyerAddress = entry.getKey();
			if (!address.equals(foyerAddress)) {
				continue;
			}
			List<Person> listFoyers = entry.getValue();
			for (Person person : listFoyers) {
				if (!personAdulte(person.getMedicalRecord().getBirthdate())) {
					int age = determineAge(person.getMedicalRecord().getBirthdate());
					PersonEnfant personEnfant = new PersonEnfant(age, person, listFoyers);
					listEnfant.add(personEnfant);
				}
			}
		}
		return listEnfant;
	}
	
	

}
