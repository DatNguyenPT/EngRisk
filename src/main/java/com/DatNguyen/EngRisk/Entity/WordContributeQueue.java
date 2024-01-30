package com.DatNguyen.EngRisk.Entity;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "CONTRIBUTE")
public class WordContributeQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private long score;
    private Date latestContribute;
    @ManyToOne
    private Vocab vocab;
    public WordContributeQueue(){}

    public WordContributeQueue(long id, String username, long score, Date latestContribute, Vocab vocab) {
        this.id = id;
        this.username = username;
        this.score = score;
        this.latestContribute = latestContribute;
        this.vocab = vocab;
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

    public Vocab getVocab(){
        return vocab;
    }
    public void setVocab(Vocab vocab){
        this.vocab = vocab;
    }
}
