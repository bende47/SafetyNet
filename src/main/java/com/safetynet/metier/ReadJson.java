package com.safetynet.metier;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.model.Firestation;
import com.safetynet.model.Medicalrecord;
import com.safetynet.model.Person;
import com.safetynet.model.Safetynet;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadJson {

	private ReadJson() {		
	}
	
	public static Safetynet readJsonFile(String file) {
		try {
			
			String jsonResponse;
			List<Person> persons=new ArrayList<>();
			List<Medicalrecord> medicalrecords=new ArrayList<>();
			List<Firestation> firestations=new ArrayList<>();
 
			URL url = new URL(file);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setUseCaches(false);
			con.setDoOutput(true);
			con.setDoInput(true);

			con.setRequestProperty("X-API-KEY", "644cf981-a04e-4047-84d1-104dc6c752fb");
			con.setRequestMethod("GET");

			int httpResponse = con.getResponseCode();
			System.out.println("httpResponse: " + httpResponse);

			if (httpResponse >= HttpURLConnection.HTTP_OK && httpResponse < HttpURLConnection.HTTP_BAD_REQUEST) {
				Scanner scanner = new Scanner(con.getInputStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			} else {
				Scanner scanner = new Scanner(con.getErrorStream(), "UTF-8");
				jsonResponse = scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
				scanner.close();
			}

			ObjectMapper objectMapper = new ObjectMapper();
			Safetynet safetyNet = objectMapper.readValue(jsonResponse, Safetynet.class);
			
			for (Firestation firestation : safetyNet.getFirestations()) {
				firestations.add(firestation);	
			}
			
						
			for (Person person : safetyNet.getPersons()) {
				persons.add(person);
			} 
			
			for (Medicalrecord medicalRecord : safetyNet.getMedicalrecords()) {
				medicalrecords.add(medicalRecord);
			}
		
			return safetyNet;

		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		return null;
	
	
	}
}
