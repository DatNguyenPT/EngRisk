package com.DatNguyen.EngRisk.Entity;


import com.DatNguyen.EngRisk.Entity.DTO.WordContributionDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WordContributeQueue {
    private List<WordContributionDTO> list;
    public WordContributeQueue(){}
    public WordContributeQueue(List<WordContributionDTO>list){
        this.list = list;
    }
    public void contribute(WordContributionDTO word){
        if(word.getVocab() != null)
            list.add(word);
    }
    public long getSize(){
        if (list.isEmpty())
            return 0;
        return list.size();
    }

    public WordContributionDTO findContribution(){
        // Unfinished
        return null;
    }
}
