package com.safetynet.controller;


import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.metier.FirestationMetier;
import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.PersonHabitant;
import com.safetynet.model.PersonStation;
import com.safetynet.model.Safetynet;

@RestController
public class FirestationController {

	@Autowired
	private FirestationMetier firestationMetier;
	
	@Autowired
	private Safetynet safetynet;
	
	List<Person> listPerson=null;
	
	/*
	 * Ajout de Firestation
	 */
	 
	@PostMapping(value="/firestation")
	public  Safetynet addFirestation(@RequestBody  Map<?, ?> firestation) {
		firestationMetier.addFirestation(firestation);		
		return safetynet;
	}	
	
	/*
	 * Modification  de Firestation
	 */
	
	@PutMapping(value="/firestation")
	public Safetynet updateFirestation(@RequestBody  Map<?, ?> firestation) {
		Map<Integer, Firestation> getfirestations = safetynet.getFirestations();
		firestationMetier.updateFirestation(Integer.parseInt(firestation.get("station").toString()), firestation.get("address").toString(), getfirestations);
		return safetynet;
	}
	
	/*
	 * Suppression de firestation
	 */
	
	@DeleteMapping(value="/firestation")
	public Safetynet deleteFirestation(@RequestBody  Map<?, ?> firestation) {
		Map<Integer, Firestation> getfirestations = safetynet.getFirestations();
		firestationMetier.deleteFirestation(Integer.parseInt(firestation.get("station").toString()), firestation.get("address").toString(), getfirestations);
		return safetynet;
	}
	
	/*
	 * Liste des personnes couvertes par la caserne de pompiers correspondante
	 */
	
	@GetMapping(value="/firestation")
	public PersonStation stationNumber(@RequestParam String stationNumber) throws ParseException {
		Map<Integer, Firestation> firestations = safetynet.getFirestations();
		listPerson = safetynet.getPersons();
		return firestationMetier.stationNumber(stationNumber,firestations,listPerson);
	}
	
	
	/*
	 * Liste des habitants vivant à l’adresse donnée ainsi que le numéro de la caserne de pompiers la desservant		
	 */
	
	@GetMapping(value="/fire")
	public List<PersonHabitant> fire(@RequestParam String address) throws ParseException {
		listPerson = safetynet.getPersons();
		Map<Integer, Firestation> getfirestations = safetynet.getFirestations();
		return firestationMetier.fire(address, listPerson, getfirestations);
	}
	
	/*
	 * Liste de tous les foyers desservis par la caserne. Cette liste doit regrouper les personnes par adresse
	 */
	
	
	@GetMapping(value="/flood/stations")
	public List<Person> flood(@RequestParam String stations) throws ParseException {
		Map<Integer, Firestation> firestations = safetynet.getFirestations();
		Map<String, List<Person>> personFoyers = safetynet.getPersonFoyers();
		return firestationMetier.flood(stations, firestations, personFoyers);
	}
	
}
