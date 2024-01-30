package com.DatNguyen.EngRisk.Service;

import com.DatNguyen.EngRisk.Entity.Vocab;
import com.DatNguyen.EngRisk.Repository.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {
    @Autowired
    DataRepo dataRepo;
    public Vocab findWord(String word){
        List<Vocab>list = dataRepo.findAll();
        Vocab result = list.stream()
                .filter(element->element.getWords().equals(word))
                .findFirst()
                .orElse(null);
        return result;
    }
    public List<Vocab> findByCategory(String category){
        List<Vocab>list = dataRepo.findAll();
        List<Vocab>result = list.stream()
                .filter(element->element.getCategory().equals(category))
                .collect(Collectors.toList());
        return result;
    }

    // Wait until finished user authorized
    public void contribute(Vocab vocab){

    }
}
