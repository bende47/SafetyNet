package com.safetynet.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.metier.MedicalrecordMetier;
import com.safetynet.model.Safetynet;

@RestController
public class MedicalrecordController {

	@Autowired
	private MedicalrecordMetier medicalrecordMetier;
	
	@Autowired
	private Safetynet safetynet;
	 
	@PostMapping(value="/medicalRecord")
	public  Safetynet addMedicalRecord(@RequestBody  Map<?, ?> medicalRecord) {
		medicalrecordMetier.addMedicalrecord(medicalRecord);		
		return safetynet;
	}
	
	@PutMapping(value="/medicalRecord")
	public  Safetynet updateMedicalRecord(@RequestBody  Map<?, ?> medicalRecord) {
		medicalrecordMetier.updateMedicalrecord(medicalRecord);
		return safetynet;
	}
	
	@DeleteMapping(value="/medicalRecord")
	public  Safetynet deleteMedicalRecord(@RequestBody  Map<?, ?> medicalRecord) {
		medicalrecordMetier.deleteMedicalrecord(medicalRecord);
		return safetynet;
	}
	
}
