package com.DatNguyen.EngRisk.DataRController;

import com.DatNguyen.EngRisk.Service.DataService;
import com.DatNguyen.EngRisk.Entity.DTO.VocabDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/dataAPI")
public class DataServerController {
    private DataService dataService;

    public DataServerController(DataService dataService) {
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
        VocabDTO result = dataService.findWord(word);
        if (result != null)
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>("No word founded", HttpStatus.BAD_REQUEST);
    }
    @PostMapping(value = "/findbycategory")
    public ResponseEntity<?>findByCategory(@RequestParam String category){
        List<VocabDTO> result = dataService.findByCategory(category);
        if (!result.isEmpty())
            return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>("No category founded", HttpStatus.BAD_REQUEST);
    }
}
