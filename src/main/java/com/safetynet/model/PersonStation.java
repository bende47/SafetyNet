package com.safetynet.model;

import java.util.List;

public class PersonStation {
	
	private List<Person> listPersonStation;
	private int nbrAdult;
	private int nbrChild;
		
	public List<Person> getListPersonStation() {
		return listPersonStation;
	}
	public void setListPersonStation(List<Person> listPersonStation) {
		this.listPersonStation = listPersonStation;
	}
	public int getNbrAdult() {
		return nbrAdult;
	}
	public void setNbrAdult(int nbrAdult) {
		this.nbrAdult = nbrAdult;
	}
	public int getNbrChild() {
		return nbrChild;
	}
	public void setNbrChild(int nbrChild) {
		this.nbrChild = nbrChild;
	}
	

	public PersonStation(List<Person> listPersonStation, int nbrAdult, int nbrChild) {
		this.listPersonStation = listPersonStation;
		this.nbrAdult = nbrAdult;
		this.nbrChild = nbrChild;
	}
	
	@Override
	public String toString() {
		return "PersonStation [listPersonStation=" + listPersonStation + ", nbrAdult=" + nbrAdult + ", nbrChild="
				+ nbrChild + "]";
	}

	
	
	
	
}
