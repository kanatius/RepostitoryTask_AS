/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games_repository;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class GamesRepository {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket servidor = new ServerSocket(100);

            Repository rep = new Repository();

//            for (int i = 0; i < 20; i++) {
//                System.out.println(generateNumber(100, 50));
//            }
            Difficulty[] difficulties = Difficulty.values();
            Evaluation[] evaluations = Evaluation.values(); 
            
            rep.addGame(new Game("1",  "Among Us", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("2",  "Quantum Break", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("3",  "League of Legends", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("4",  "DOTA 2", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("5",  "Perfect World", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("6",  "Ragnarok", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("7",  "Fall Guys", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("8",  "Tomb Raider", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("9",  "Project Cars", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("10",  "Counter Strike", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("11",  "Warframe", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("12",  "Naruto Online", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("13",  "Legend Online", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("14",  "Phasmophobia", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("15",  "Cyberpunk 2077", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("16",  "The Witcher 3", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("17",  "Forza Horizon", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("18",  "Grand Theft Auto V", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("19",  "Dark Souls", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            rep.addGame(new Game("20",  "Need For Speed Most Wanted", generateNumber(10000000, 100000), new ArrayList<String>(), difficulties[generateNumber(0,3)], evaluations[generateNumber(0,3)], ""));
            
            while (true) {
                Socket conexao = servidor.accept();               
                ClientConection clientConection = new ClientConection(rep, conexao);
                System.out.println("Conexao estabelecida");
                new Thread(clientConection).start();
            }
        } catch (IOException ex) {
            Logger.getLogger(GamesRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static int generateNumber(float maior, float menor) {
        Random gerador = new Random();
        return (int) Math.floor(gerador.nextFloat() * (maior - menor) + menor);
    }
}
