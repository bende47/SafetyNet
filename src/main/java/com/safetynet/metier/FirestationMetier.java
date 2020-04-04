package com.safetynet.metier;


import java.util.Map;

import com.safetynet.model.Firestation;
import com.safetynet.model.Safetynet;

public interface FirestationMetier {
	
	public Safetynet addFirestation(Map<?, ?> firestation);
	public Map<Integer, Firestation> updateFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations);
	public Map<Integer, Firestation> deleteFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations);	
	
}
