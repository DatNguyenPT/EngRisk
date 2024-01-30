package com.DatNguyen.EngRisk.DataRController;

import com.DatNguyen.EngRisk.Database.JSONFormat;
import com.DatNguyen.EngRisk.Service.DataService;
import com.DatNguyen.EngRisk.Entity.Vocab;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/dataAPI")
public class DataInteraction {
    private JSONFormat jsonFormat;
    private DataService dataService;

    public DataInteraction(JSONFormat jsonFormat, DataService dataService) {
        this.jsonFormat = jsonFormat;
        this.dataService = dataService;
    }

    @GetMapping(value = "/insertdata")
    public ResponseEntity<?> insert() throws IOException {
        String fetching = "python " + "C:\\Users\\Hii\\Desktop\\Side Projects\\InsertDataToMySQL\\main.py" + "\"";
        String[] commandToExecute = new String[]{"cmd.exe", "/c", fetching};
        Runtime.getRuntime().exec(commandToExecute);
        return new ResponseEntity<>("Upload Complete", HttpStatus.OK);
    }

    @PostMapping(value = "/findword")
    public ResponseEntity<?>findWord(@RequestParam String word){
        Vocab result = dataService.findWord(word);
        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>("No word founded", HttpStatus.BAD_REQUEST);
    }
    @PostMapping(value = "/findbycategory")
    public ResponseEntity<?>findByCategory(@RequestParam String category){
        List<Vocab> result = dataService.findByCategory(category);
        if (!result.isEmpty())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>("No category founded", HttpStatus.BAD_REQUEST);
    }
}
