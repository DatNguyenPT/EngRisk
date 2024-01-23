package com.DatNguyen.EngRisk;

import com.DatNguyen.EngRisk.Database.Insert;
import com.DatNguyen.EngRisk.Database.JSONFormat;
import com.DatNguyen.EngRisk.Database.ParseJSONToSQL;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class AppConfig {
    @Bean
    public JSONFormat jsonFormat(){
        return new JSONFormat();
    }
    @Bean
    public ParseJSONToSQL parseJSONToSQL() throws IOException {return new ParseJSONToSQL();}
    @Bean
    public Firestore firestore() throws IOException {
        Resource resource = new ClassPathResource("serviceAccountKey.json");
        FileInputStream serviceAccount = new FileInputStream(resource.getFile());

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://engrisk-5435c-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
        return com.google.firebase.cloud.FirestoreClient.getFirestore();
    }
}
