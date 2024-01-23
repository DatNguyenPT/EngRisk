package com.DatNguyen.EngRisk;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class EngRiskApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(EngRiskApplication.class, args);
	}

}
