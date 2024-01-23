package com.DatNguyen.EngRisk.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "GRAMMAR")
public class Grammar {
    @Id
    @NotNull
    private String grammarType;
    @NotNull
    private String category;
    @NotNull
    private String usingSituation;
    @NotNull
    private String possitiveFormula;
    @NotNull
    private String negativeFormula;
    @NotNull
    private String questionFormula;
    @NotNull
    private String exampleSentence;

    public Grammar(){}

    public Grammar(String grammarType, String category, String usingSituation, String possitiveFormula, String negativeFormula, String questionFormula, String exampleSentence) {
        this.grammarType = grammarType;
        this.category = category;
        this.usingSituation = usingSituation;
        this.possitiveFormula = possitiveFormula;
        this.negativeFormula = negativeFormula;
        this.questionFormula = questionFormula;
        this.exampleSentence = exampleSentence;
    }

    public String getGrammarType() {
        return grammarType;
    }

    public void setGrammarType(String grammarType) {
        this.grammarType = grammarType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsingSituation() {
        return usingSituation;
    }

    public void setUsingSituation(String usingSituation) {
        this.usingSituation = usingSituation;
    }

    public String getPossitiveFormula() {
        return possitiveFormula;
    }

    public void setPossitiveFormula(String possitiveFormula) {
        this.possitiveFormula = possitiveFormula;
    }

    public String getNegativeFormula() {
        return negativeFormula;
    }

    public void setNegativeFormula(String negativeFormula) {
        this.negativeFormula = negativeFormula;
    }

    public String getQuestionFormula() {
        return questionFormula;
    }

    public void setQuestionFormula(String questionFormula) {
        this.questionFormula = questionFormula;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }
}
