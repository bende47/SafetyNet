package com.safetynet.metier;

import java.util.Map;
import com.safetynet.model.Safetynet;


public interface MedicalrecordMetier {
	/**
	 * 
	 * @param medicalRecord
	 * @return
	 */
	public Safetynet addMedicalrecord(Map<?, ?> medicalRecord);
	
	/**
	 * 
	 * @param medicalRecord
	 * @return
	 */
	public Safetynet updateMedicalrecord(Map<?, ?> medicalRecord);
	
	/**
	 * 
	 * @param medicalRecord
	 * @return
	 */
	public Safetynet deleteMedicalrecord(Map<?, ?> medicalRecord);

}
