package com.safetynet.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.metier.FirestationMetier;
import com.safetynet.model.Firestation;
import com.safetynet.model.Safetynet;

@RestController
public class FirestationController {

	@Autowired
	private FirestationMetier firestationMetier;
	
	@Autowired
	private Safetynet safetynet;
	 
	@PostMapping(value="/firestation")
	public  Safetynet addFirestation(@RequestBody  Map<?, ?> firestation) {
		firestationMetier.addFirestation(firestation);		
		return safetynet;
	}
	
	@PutMapping(value="/firestation")
	public  Safetynet updateFirestation(@RequestBody  Map<?, ?> firestation) {
		Map<Integer, Firestation> getfirestations = safetynet.getFirestations();
		firestationMetier.updateFirestation(Integer.parseInt(firestation.get("station").toString()), firestation.get("address").toString(), getfirestations);
		return safetynet;
	}
	
	@DeleteMapping(value="/firestation")
	public  Safetynet deleteFirestation(@RequestBody  Map<?, ?> firestation) {
		Map<Integer, Firestation> getfirestations = safetynet.getFirestations();
		firestationMetier.deleteFirestation(Integer.parseInt(firestation.get("station").toString()), firestation.get("address").toString(), getfirestations);
		return safetynet;
	}
	
}
