package com.safetynet.metier;

import java.io.IOException;
import java.util.List;

import com.safetynet.model.Person;
import com.safetynet.model.Safetynet;

public interface ReadJson {

	public  Safetynet readFile(String file) throws IOException;
	public  Person searchPerson(String firstName, String lastName, List<Person> persons) ;
	
}
