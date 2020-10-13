/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games_repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author natan
 */


public class Game implements Serializable{
    private String cod;
    private String name;
    private float sizeInBytes;
    private List<String> genders;
    private Difficulty difficulty;
    private Evaluation evaluation;
    private String description;

    public Game(String cod, String name, float sizeInBytes, List<String> genders, Difficulty difficulty, Evaluation evaluation, String description) {
        this.cod = cod;
        this.name = name;
        this.sizeInBytes = sizeInBytes;
        this.genders = genders;
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

    public List<String> getGender() {
        return genders;
    }

    public void setGender(List<String> gender) {
        this.genders = gender;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void addGender(String gender){
        if(!this.genders.contains(gender))
            this.genders.add(gender);
    }
    public boolean removeGender(String gender){
        return this.genders.remove(gender);
    }
}
