package com.DatNguyen.EngRisk.Service;

import com.DatNguyen.EngRisk.Entity.DTO.User;
import com.DatNguyen.EngRisk.Entity.DTO.VocabDTO;
import com.DatNguyen.EngRisk.Entity.WordContributeQueue;
import com.DatNguyen.EngRisk.Entity.DTO.WordContributionDTO;
import com.DatNguyen.EngRisk.Repository.ContributeRepo;
import com.DatNguyen.EngRisk.Repository.UserRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
@Service
public class UserService {
    @Autowired
    private DataService dataService;
    // For data contribution
    @Autowired
    private WordContributeQueue wordContributeQueue;
    @Autowired
    private User user;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ContributeRepo contributeRepo;

    // SERVER
    public User getUser(String userName){
        return userRepo.findAll().stream()
                .filter(user -> user.getUsername().equals(userName))
                .findFirst()
                .orElse(null);
    }

    // Add new word to dataset (only non-existed words)
    public boolean acceptContribution(WordContributionDTO contribution) throws IOException {
        VocabDTO vocabDTO = dataService.findWord(contribution.getVocab().getWords());
        if (vocabDTO == null){
            Gson gson = new Gson();
            gson.toJson(contribution.getVocab(), new FileWriter("Data.json"));
            // Add user's score
            contribution.setScore(contribution.getScore() + 5); // Add 5 points
            contributeRepo.save(contribution);
            return true;
        }
        return false;
    }



    // USER
    // Wait until finished user authorized
    public void contribute(VocabDTO vocabDTO){
        WordContributionDTO wordContributionDTO = new WordContributionDTO();
        wordContributionDTO.setVocab(vocabDTO);
        String userName = user.getUsername();
        wordContributionDTO.setUsername(userName);
        Date time = Date.valueOf(LocalDate.now());
        wordContributionDTO.setLatestContribute(time);
        wordContributionDTO.setId(wordContributeQueue.getSize() + 1);
        wordContributionDTO.setScore(0); // Only get score if user's contribution is accepted
        wordContributeQueue.contribute(wordContributionDTO); // Add to queue
    }
}
