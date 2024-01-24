package com.DatNguyen.EngRisk.Database.Service;

import com.DatNguyen.EngRisk.Entity.Vocab;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class DataService {
    @Autowired
    private Firestore firestore;
    //Only admin can retrieve the collections
    private CollectionReference getVocabCollection(){
        return firestore.collection("Vocabularies");
    }

    //Save new words
    public String saveNewWord(Vocab vocab) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult>collectionApiFuture = getVocabCollection().document(vocab.getWords()).set(vocab);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public Vocab getWord(String word) throws ExecutionException, InterruptedException {
        // Assuming "Vocabularies" is the collection name
        CollectionReference vocabulariesCollection = getVocabCollection();

        // Query to find documents where the "words" field is equal to the provided word
        Query query = vocabulariesCollection.whereEqualTo("words", word);

        // Execute the query
        ApiFuture<QuerySnapshot> querySnapshot = query.get();

        // Check if there are any matching documents
        if (!querySnapshot.get().isEmpty()) {
            // Assuming you only expect one matching document; adjust accordingly if needed
            DocumentSnapshot documentSnapshot = querySnapshot.get().getDocuments().get(0);

            // Convert the document to the Vocab class
            return documentSnapshot.toObject(Vocab.class);
        } else {
            return null;
        }
    }


}
