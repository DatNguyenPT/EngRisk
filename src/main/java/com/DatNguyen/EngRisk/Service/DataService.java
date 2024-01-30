package com.DatNguyen.EngRisk.Service;

import com.DatNguyen.EngRisk.Entity.Vocab;
import com.DatNguyen.EngRisk.Repository.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {
    @Autowired
    DataRepo dataRepo;
                                    // DATA
    public Vocab findWord(String word){
        List<Vocab>list = dataRepo.findAll();
        Vocab result = list.stream()
                .filter(element->element.getWords().equals(word))
                .findFirst()
                .orElse(null);
        return result;
    }
    public List<Vocab> sortList(List<Vocab>list){
        List<String>store = new ArrayList<>();
        for (Vocab vocab : list){
            store.add(vocab.getWords());
        }
        List<Vocab>result = new ArrayList<>();
        Collections.sort(store);
        for (String word : store){
            Vocab vocab = findWord(word);
            result.add(vocab);
        }
        return result;
    }
    public List<Vocab> findByCategory(String category){
        List<Vocab>list = dataRepo.findAll();
        List<Vocab>result = list.stream()
                .filter(element->element.getCategory().equals(category))
                .collect(Collectors.toList());
        result = sortList(result);
        return result;
    }
                                    // USER
    // Wait until finished user authorized
    public void contribute(Vocab vocab){

    }
}
