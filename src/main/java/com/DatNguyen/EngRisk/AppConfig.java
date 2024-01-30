package com.DatNguyen.EngRisk;

import com.DatNguyen.EngRisk.Database.JSONFormat;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class AppConfig {
    @Bean
    public JSONFormat jsonFormat(){
        return new JSONFormat();
    }

}
