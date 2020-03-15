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
@JsonPropertyOrder({  "birthdate", "medications", "allergies" })
public class Medicalrecord {

	
	@JsonProperty("birthdate")
	private String birthdate;
	@JsonProperty("medications")
	private List<String> medications = null;
	@JsonProperty("allergies")
	private List<String> allergies = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	@JsonProperty("birthdate")
	public String getBirthdate() {
		return birthdate;
	}

	@JsonProperty("birthdate")
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	@JsonProperty("medications")
	public List<String> getMedications() {
		return medications;
	}

	@JsonProperty("medications")
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	@JsonProperty("allergies")
	public List<String> getAllergies() {
		return allergies;
	}

	@JsonProperty("allergies")
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
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