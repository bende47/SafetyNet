package com.safetynet.metier;

import java.util.Map;


import com.safetynet.model.Safetynet;


public interface MedicalrecordMetier {
	public Safetynet addMedicalrecord(Map<?, ?> medicalRecord);
	public Safetynet updateMedicalrecord(Map<?, ?> medicalRecord);
	public Safetynet deleteMedicalrecord(Map<?, ?> medicalRecord);

}
