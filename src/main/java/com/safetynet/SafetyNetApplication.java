package com.safetynet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.safetynet.metier.ReadJson;
import com.safetynet.model.Safetynet;

@SpringBootApplication
public class SafetyNetApplication {

	private static String file = "https://s3-eu-west-1.amazonaws.com/course.oc-static.com/projects/DA+Java+EN/P5+/data.json";
	//private static String file = "./src/main/resources/data.json";
	
	public static void main(String[] args) {
		SpringApplication.run(SafetyNetApplication.class, args);
	}
	
	@Bean
	public Safetynet loadModel()  {
		return ReadJson.readJsonFile(file);
	}
	
	

}
