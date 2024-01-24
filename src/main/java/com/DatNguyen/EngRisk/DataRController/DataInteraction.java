package com.DatNguyen.EngRisk.DataRController;

import com.DatNguyen.EngRisk.Database.JSONFormat;
import com.DatNguyen.EngRisk.Database.Service.DataService;
import com.DatNguyen.EngRisk.Entity.Vocab;
import com.google.cloud.firestore.Firestore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/dataAPI")
public class DataInteraction {
    private JSONFormat jsonFormat;
    private Firestore db;
    private DataService dataService;

    public DataInteraction(JSONFormat jsonFormat, Firestore db, DataService dataService) {
        this.jsonFormat = jsonFormat;
        this.db = db;
        this.dataService = dataService;
    }

    @GetMapping(value = "/insertdata")
    public ResponseEntity<?> insert() throws IOException {
        String fetching = "python " + "C:\\Users\\Hii\\Desktop\\Mini Projects\\DataToFireStore(EngRisk)\\main.py" + "\"";
        String[] commandToExecute = new String[]{"cmd.exe", "/c", fetching};
        Runtime.getRuntime().exec(commandToExecute);
        return new ResponseEntity<>("Upload Complete", HttpStatus.OK);
    }

    @PostMapping(value = "/findword")
    public ResponseEntity<?>getWord(@RequestParam String word) throws ExecutionException, InterruptedException {
        Vocab result = dataService.getWord(word);
        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>("No word founded", HttpStatus.BAD_REQUEST);
    }
}
