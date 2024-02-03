package com.DatNguyen.EngRisk.Entity.DTO;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

@Entity
@Table(name = "CONTRIBUTE")
public class WordContributionDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String username;
    private long score;
    private Date latestContribute;
    @ManyToOne
    @NotNull
    private VocabDTO vocabDTO;
    public WordContributionDTO(){}

    public WordContributionDTO(long id, String username, long score, Date latestContribute, VocabDTO vocabDTO) {
        this.id = id;
        this.username = username;
        this.score = score;
        this.latestContribute = latestContribute;
        this.vocabDTO = vocabDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public Date getLatestContribute() {
        return latestContribute;
    }

    public void setLatestContribute(Date latestContribute) {
        this.latestContribute = latestContribute;
    }

    public VocabDTO getVocab(){
        return vocabDTO;
    }
    public void setVocab(VocabDTO vocabDTO){
        this.vocabDTO = vocabDTO;
    }
}
