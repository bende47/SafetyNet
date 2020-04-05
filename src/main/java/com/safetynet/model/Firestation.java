package com.safetynet.model;

import java.util.HashSet;
import java.util.Set;

public class Firestation {

	private int station;
	private Set<String> addresses = new HashSet<>();
	
	public Firestation() {}

	
	public Set<String> getAddresses() {
		return addresses;
	}

	public int getStation() {
		return station;
	}

	public void addAddress(String newAddress) {
		addresses.add(newAddress);
	}
	
	public Firestation(int station) {
		this.station = station;
	}


	@Override
	public String toString() {
		return "Firestation [station=" + station + ", addresses=" + addresses + "]";
	}

}
