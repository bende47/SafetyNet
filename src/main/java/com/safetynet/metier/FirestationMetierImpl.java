package com.safetynet.metier;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.model.Firestation;
import com.safetynet.model.Safetynet;

@Service
public class FirestationMetierImpl implements FirestationMetier {

	private static final Logger logger = LogManager.getRootLogger();

	@Autowired
	private Safetynet safetynet;

	@Override
	public Safetynet addFirestation(Map<?, ?> f) {		
		
		Firestation firestation = safetynet.getFirestations().get(Integer.parseInt(f.get("station").toString()));		
		firestation.addAddress(f.get("address").toString());
		logger.info("@RequestBody = {}", f);
		logger.info("Response {} ", safetynet.getFirestations());
		logger.info("Nombre de firestation = {}", safetynet.getFirestations().size());
		return safetynet;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map<Integer, Firestation> updateFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations) {
		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(station);
			if (fire.getAddresses().contains(stationAdress)) {
				fire.getAddresses().remove(stationAdress);
			}
			if (fire.getStation() == stationNumber) {
				fire.addAddress(stationAdress);
			}
		}
		return getfirestations;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Map<Integer, Firestation> deleteFirestation(int stationNumber, String stationAdress,
			Map<Integer, Firestation> getfirestations) {
		Set cles = getfirestations.keySet();
		Iterator it = cles.iterator();

		while (it.hasNext()) {
			Object station = it.next();
			Firestation fire = getfirestations.get(station);
			if (fire.getAddresses().contains(stationAdress)) {
				fire.getAddresses().remove(stationAdress);
			}
		}
		return getfirestations;
	}

}
