package com.safetynet.controller;

import java.text.ParseException;
import java.util.ArrayList;
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

import com.safetynet.metier.PersonMetier;
import com.safetynet.model.Firestation;
import com.safetynet.model.Person;
import com.safetynet.model.PersonEnfant;
import com.safetynet.model.PersonInfo;
import com.safetynet.model.Safetynet;



@RestController
public class PersonController {
	@Autowired
	private Safetynet safetynet;
	
	@Autowired
	private PersonMetier personMetier;
	
	List<Person> listPerson=null;
	
	@PostMapping(value = "/person")
	public Safetynet addPerson(@RequestBody Map<?, ?> person) {		
		personMetier.addPerson(person);
		return safetynet;
	}
	
	@PutMapping(value = "/person")
	public Safetynet updatePerson(@RequestBody Person person) {		
		personMetier.updatePerson(safetynet.getPersons(), person, person.getFirstName(), person.getLastName());
		return safetynet;
	}
	
	@DeleteMapping(value = "/person")
	public Safetynet deletePerson(@RequestBody Person person) {			
		listPerson=personMetier.deletePersonne(person.getFirstName(), person.getLastName(), safetynet.getPersons());
		return safetynet;
	}
	
	@GetMapping(value = "/childAlert")
	public List<PersonEnfant> childAlert (@RequestParam String address) throws ParseException {			
		Map<String, List<Person>> personFoyers = safetynet.getPersonFoyers();
		List<PersonEnfant> listPersonEnfant = new ArrayList<>();
		return personMetier.listEnfant(personFoyers, listPersonEnfant, address);
	}
	
	@GetMapping(value = "/phoneAlert")
	public List<String> phoneAlert (@RequestParam String firestation) {			
		Map<Integer, Firestation> listFirestation = safetynet.getFirestations();
		listPerson = safetynet.getPersons();
		return personMetier.phoneAlert(firestation, listFirestation, listPerson);
	}
	
	@GetMapping(value = "/personInfo")
	public List<PersonInfo> personInfo (@RequestParam String firstName, String lastName) throws ParseException {			
		listPerson = safetynet.getPersons();
		return personMetier.listPersonInfo(firstName, lastName, listPerson);
	}
	
	@GetMapping(value = "/communityEmail")
	public List<String> communityEmail(@RequestParam String city) {
		listPerson = safetynet.getPersons();
		return personMetier.communityEmail(city, listPerson);
	}
	
	
	

}
