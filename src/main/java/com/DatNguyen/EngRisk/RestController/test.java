package com.DatNguyen.EngRisk.RestController;

import com.DatNguyen.EngRisk.Database.Insert;
import com.DatNguyen.EngRisk.Database.JSONFormat;
import com.google.cloud.firestore.Firestore;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/dataAPI")
public class test {
    private JSONFormat jsonFormat;
    private Firestore db;

    public test(JSONFormat jsonFormat, Firestore db) {
        this.jsonFormat = jsonFormat;
        this.db = db;
    }

    @GetMapping(value = "/insertdata")
    public void insert() throws IOException, ParseException, ExecutionException, InterruptedException {
        Insert insert = new Insert(db);
        insert.setData(jsonFormat);
    }
}
