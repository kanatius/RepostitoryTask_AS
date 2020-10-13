/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games_repository;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natan
 */
public class Repository {
    List<Game> games;

    public Repository() {
        this.games = new ArrayList<Game>();
    }
    
    public void addGame(Game game){
        this.games.add(game);
    }
    public void removeGame(Game game){
        this.games.remove(game);
    }
    public List<Game> getGamesByName(String nome){
        List<Game> gamesList = new ArrayList<Game>();
        
        for(Game game : this.games){
            if(game.getNome().toLowerCase().contains(nome.toLowerCase()))
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
    
    public List<Game> getGamesHarderThan(Difficulty dif){
        List<Game> gamesList = new ArrayList<Game>();
        for(Game game : this.games){
            if( game.getDifficulty().ordinal() > dif.ordinal())
                gamesList.add(game);
        }
        return gamesList;
    }
    
    public List<Game> getGamesEasyerThan(Difficulty dif){
        List<Game> gamesList = new ArrayList<Game>();
        for(Game game : this.games){
            if( game.getDifficulty().ordinal() < dif.ordinal())
                gamesList.add(game);
        }
        return gamesList;
    }
    
    public Game getGameByCod(String cod){
        for(Game game : this.games)
            if(game.getCod().equals(cod))
                return game;
        return null;
    }
}
