package com.DatNguyen.EngRisk.Entity.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "VOCAB")
public class VocabDTO {
    @Id
    @NotNull
    private String words;
    @NotNull
    private String category;
    @NotNull
    private String wordType;
    @NotNull
    private String pronoun;
    @NotNull
    private String exampleSentence;

    public VocabDTO(){}

    public VocabDTO(String words, String category, String wordType, String pronoun, String exampleSentence) {
        this.words = words;
        this.category = category;
        this.wordType = wordType;
        this.pronoun = pronoun;
        this.exampleSentence = exampleSentence;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWordType() {
        return wordType;
    }

    public void setWordType(String wordType) {
        this.wordType = wordType;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }
}
