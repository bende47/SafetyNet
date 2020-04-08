package com.safetynet.model;

public class PersonInfo {
	
	private String firstName;

	private String lastName;

	private int age;

	private String address;

	private String city;

	private String zip;

	private String phone;

	private String email;

	private Medicalrecord medicalRecord;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Medicalrecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(Medicalrecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public PersonInfo(String firstName, String lastName, int age, String address, String city, String zip, String phone,
			String email, Medicalrecord medicalRecord) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.medicalRecord = medicalRecord;
	}

	@Override
	public String toString() {
		return "PersonInfo [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", address=" + address
				+ ", city=" + city + ", zip=" + zip + ", phone=" + phone + ", email=" + email + ", medicalRecord="
				+ medicalRecord + "]";
	}

	
	
	
}
