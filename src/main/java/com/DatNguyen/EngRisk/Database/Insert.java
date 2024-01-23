package com.DatNguyen.EngRisk.Database;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Insert {
    private Firestore db;  // Declare Firestore instance

    public Insert(Firestore db) {
        this.db = db;
    }

    public void setData(JSONFormat jsonFormat) throws IOException, ParseException, ExecutionException, InterruptedException {
        ApiFuture<WriteResult> future = db.collection("Vocabularies").document("Vocab").set(jsonFormat.jsonToMap());
        System.out.println("Update time : " + future.get().getUpdateTime());
    }
}
