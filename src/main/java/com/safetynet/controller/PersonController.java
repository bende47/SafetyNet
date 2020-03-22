package com.safetynet.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.metier.PersonMetier;
import com.safetynet.model.Person;
import com.safetynet.model.Safetynet;



@RestController
public class PersonController {
	@Autowired
	private Safetynet safetynet;
	
	@Autowired
	private PersonMetier personMetier;

	
	@PostMapping(value = "/person")
	public Safetynet addPerson(@RequestBody Person person) {		
		personMetier.addPerson(person);
		return safetynet;
	}
	
	@PutMapping(value = "/person")
	public Safetynet updatePerson(@RequestBody Person person) {		
		personMetier.updatePerson(person);
		return safetynet;
	}
	
	@DeleteMapping(value = "/person")
	public Safetynet deletePerson(@RequestBody Person person) {	
		
		List<Person> listPerson = safetynet.getPersons();		
		listPerson=personMetier.deletePersonne(person);
		return safetynet;
	}
	
	
	

}
