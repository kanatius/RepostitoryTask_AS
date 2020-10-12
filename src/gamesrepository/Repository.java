/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamesrepository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natan
 */
public class Repository {
    List<Game> games;
    
    
    public void addGame(Game game){
        this.games.add(game);
    }
    public void removeGame(Game game){
        this.games.remove(game);
    }
    public List<Game> getGamesByName(String nome){
        List<Game> gamesList = new ArrayList<Game>();
        
        for(Game game : this.games){
            if(game.getNome().contains(nome))
                gamesList.add(game);
        }
        return gamesList;
    }
    public List<Game> getGamesBySizeSmallerThan(float tamanho){
        List<Game> gamesList = new ArrayList<Game>();
        for(Game game : this.games){
            if(game.getSizeInBytes() <= tamanho)
                gamesList.add(game);
        }
        return gamesList;
    }
    public List<Game> getGamesBySizeBiggerThan(float tamanho){
        List<Game> gamesList = new ArrayList<Game>();
        for(Game game : this.games){
            if(game.getSizeInBytes() >= tamanho)
                gamesList.add(game);
        }
        return gamesList;
    }
    
    public List<Game> getGamesByDifficulty(Difficulty dif){
        List<Game> gamesList = new ArrayList<Game>();
        for(Game game : this.games){
            if(game.getDifficulty() == dif)
                gamesList.add(game);
        }
        return gamesList;
    }
}
