package com.safetynet.model;

import java.time.LocalDate;
import java.util.List;

public class Medicalrecord {

	private LocalDate birthdate;

	private List<String> medications;

	private List<String> allergies;

	public Medicalrecord(LocalDate birthdate, List<String> medications, List<String> allergies) {
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public List<String> getMedications() {
		return medications;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	@Override
	public String toString() {
		return "Medicalrecord [birthdate=" + birthdate + ", medications=" + medications + ", allergies=" + allergies
				+ "]";
	}

}
