package com.safetynet.metier;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Person;
import com.safetynet.model.Safetynet;

@Service
public class PersonMetierImpl implements PersonMetier {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private Safetynet safetynet;


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

}
