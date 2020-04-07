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
	 
	@PostMapping(value="/firestation")
	public  Safetynet addFirestation(@RequestBody  Map<?, ?> firestation) {
		firestationMetier.addFirestation(firestation);		
		return safetynet;
	}
	
	@PutMapping(value="/firestation")
	public Safetynet updateFirestation(@RequestBody  Map<?, ?> firestation) {
		Map<Integer, Firestation> getfirestations = safetynet.getFirestations();
		firestationMetier.updateFirestation(Integer.parseInt(firestation.get("station").toString()), firestation.get("address").toString(), getfirestations);
		return safetynet;
	}
	
	@DeleteMapping(value="/firestation")
	public Safetynet deleteFirestation(@RequestBody  Map<?, ?> firestation) {
		Map<Integer, Firestation> getfirestations = safetynet.getFirestations();
		firestationMetier.deleteFirestation(Integer.parseInt(firestation.get("station").toString()), firestation.get("address").toString(), getfirestations);
		return safetynet;
	}
	
	@GetMapping(value="/firestation")
	public PersonStation stationNumber(@RequestParam String stationNumber) throws ParseException {
		Map<Integer, Firestation> firestations = safetynet.getFirestations();
		listPerson = safetynet.getPersons();
		return firestationMetier.stationNumber(stationNumber,firestations,listPerson);
	}
	
	@GetMapping(value="/fire")
	public List<PersonHabitant> fire(@RequestParam String address) throws ParseException {
		listPerson = safetynet.getPersons();
		Map<Integer, Firestation> getfirestations = safetynet.getFirestations();
		return firestationMetier.fire(address, listPerson, getfirestations);
	}
	
	@GetMapping(value="/flood/stations")
	public List<Person> flood(@RequestParam String stations) throws ParseException {
		Map<Integer, Firestation> firestations = safetynet.getFirestations();
		Map<String, List<Person>> personFoyers = safetynet.getPersonFoyers();
		return firestationMetier.flood(stations, firestations, personFoyers);
	}
	
}
