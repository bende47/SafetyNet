package com.safetynet;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.safetynet.metier.ReadJson;
import com.safetynet.model.Safetynet;

@SpringBootApplication
public class SafetyNetApplication {
	@Autowired
	private ReadJson readJson;

	private  String file = "./src/main/resources/data.json";
	
	public static void main(String[] args) {
		SpringApplication.run(SafetyNetApplication.class, args);
	}
	
	@Bean
	public Safetynet lectureFichier() throws IOException  {
		return readJson.readFile(file);
	}
	


}
