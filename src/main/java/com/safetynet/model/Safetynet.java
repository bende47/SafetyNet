package com.safetynet.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "persons", "firestations", "medicalrecords" })
public class Safetynet {

	@JsonProperty("persons")
	private List<Person> persons = null;
	@JsonProperty("firestations")
	private List<Firestation> firestations = null;
	@JsonProperty("medicalrecords")
	private List<Medicalrecord> medicalrecords = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("persons")
	public List<Person> getPersons() {
		return persons;
	}

	@JsonProperty("persons")
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	@JsonProperty("firestations")
	public List<Firestation> getFirestations() {
		return firestations;
	}

	@JsonProperty("firestations")
	public void setFirestations(List<Firestation> firestations) {
		this.firestations = firestations;
	}

	@JsonProperty("medicalrecords")
	public List<Medicalrecord> getMedicalrecords() {
		return medicalrecords;
	}

	@JsonProperty("medicalrecords")
	public void setMedicalrecords(List<Medicalrecord> medicalrecords) {
		this.medicalrecords = medicalrecords;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}