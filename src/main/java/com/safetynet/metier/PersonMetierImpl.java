package com.safetynet.metier;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.PersonInfo;
import com.safetynet.model.Safetynet;

@Service
public class PersonMetierImpl implements PersonMetier {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private Safetynet safetynet;
	
	private  Calendar calendar = Calendar.getInstance();

	@Override
	public List<Person> addPerson(Person p) {
		safetynet.getPersons().add(p);
		logger.info("@RequestBody = {}", p);
		logger.info("Response {} ", safetynet.getPersons());
		logger.info("Nombre de personnes = {}", safetynet.getPersons().size());
		return safetynet.getPersons();
	}

	@Override
	public List<Person> updatePerson(Person p) {
		for (Person person : safetynet.getPersons()) {
			if(person.getLastName().equals(p.getLastName()) && person.getFirstName().equals(p.getFirstName())) {
				person.setAddress(p.getAddress());
				person.setCity(p.getCity());
				person.setZip(p.getZip());
				person.setPhone(p.getPhone());
				person.setEmail(p.getEmail());
			}
		}
		logger.info("@RequestBody = {}", p);
		logger.info("Response {}", safetynet.getPersons());
		logger.info("Nombre de personnes = {}", safetynet.getPersons().size());
		return safetynet.getPersons();
	}

	@Override
	public List<Person> deletePersonne(Person p) {	 
	 int j=0;
	 int i=0;
	 List<Person> lp=safetynet.getPersons();		
		for (Person person : lp) {
			if(person.getLastName().equals(p.getLastName()) && person.getFirstName().equals(p.getFirstName())) {				
				j = i   ;
			}
			i++;
		}			
		lp.remove(j);
		logger.info("Response {}", lp);
		return lp;
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
			logger.debug("age = ", calannee);
			return calannee;
		} else {
			logger.debug("age = ", calannee - 1);
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
	
	

}
