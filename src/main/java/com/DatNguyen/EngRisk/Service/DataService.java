package com.DatNguyen.EngRisk.Service;

import com.DatNguyen.EngRisk.Entity.DTO.VocabDTO;
import com.DatNguyen.EngRisk.Repository.DataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Component
public class DataService {
    @Autowired
    DataRepo dataRepo;
                                    // DATA
    public VocabDTO findWord(String word){
        List<VocabDTO>list = dataRepo.findAll();
        VocabDTO result = list.stream()
                .filter(element->element.getWords().equals(word))
                .findFirst()
                .orElse(null);
        return result;
    }
    public List<VocabDTO> sortList(List<VocabDTO>list){
        List<String>store = new ArrayList<>();
        for (VocabDTO vocabDTO : list){
            store.add(vocabDTO.getWords());
        }
        List<VocabDTO>result = new ArrayList<>();
        Collections.sort(store);
        for (String word : store){
            VocabDTO vocabDTO = findWord(word);
            result.add(vocabDTO);
        }
        return result;
    }
    public List<VocabDTO> findByCategory(String category){
        List<VocabDTO>list = dataRepo.findAll();
        List<VocabDTO>result = list.stream()
                .filter(element->element.getCategory().equals(category))
                .collect(Collectors.toList());
        result = sortList(result);
        return result;
    }
}
