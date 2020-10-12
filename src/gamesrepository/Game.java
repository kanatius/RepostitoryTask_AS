/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesrepository;

/**
 *
 * @author natan
 */
public class Game {
    private String cod;
    private String name;
    private float sizeInBytes;
    private String[] gender;
    private Difficulty difficulty;
    private Evaluation evaluation;
    private String description;

    public Game(String cod, String name, float sizeInBytes, String[] gender, Difficulty difficulty, Evaluation evaluation, String description) {
        this.cod = cod;
        this.name = name;
        this.sizeInBytes = sizeInBytes;
        this.gender = gender;
        this.difficulty = difficulty;
        this.evaluation = evaluation;
        this.description = description;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public float getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(float sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public String[] getGender() {
        return gender;
    }

    public void setGender(String[] gender) {
        this.gender = gender;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    public String getDescricao() {
        return description;
    }

    public void setDescricao(String description) {
        this.description = description;
    }
     
}
