/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package games_repository;

import comunication.Command;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class ClientConection implements Runnable {

    private Repository repository;
    private Socket conection;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public ClientConection(Repository repository, Socket conection) throws IOException {
        this.repository = repository;
        this.conection = conection;
        this.oos = new ObjectOutputStream(this.conection.getOutputStream());
        this.ois = new ObjectInputStream(this.conection.getInputStream());
    }

    @Override
    public void run() {
        Command commandReceived;

        do {
            try {
                commandReceived = (Command) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ClientConection.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
            if (commandReceived != null) {
                System.out.println("Comando recebido: " + commandReceived.getText());
                try {
                    switch (commandReceived.getText()) {
                        case "getGamesByName": {
                            String gamesName = (String) commandReceived.getObject();
                            oos.writeObject(this.repository.getGamesByName(gamesName));
                        }
                        break;
                        case "getGameByCod":
                            String cod = (String) commandReceived.getObject();
                            System.out.println("Codigo do jogo: "+ cod);
                            Game g = this.repository.getGameByCod(cod);
                            oos.writeObject(g);
                            break;
                        case "getGamesBySizeSmallerThan":
                            float maxSize = (float) commandReceived.getObject();
                            oos.writeObject(this.repository.getGamesBySizeSmallerThan(maxSize));
                            break;
                    }
                } catch (IOException ex) {
                    Logger.getLogger(ClientConection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } while (!commandReceived.equals(Command.abortComunicationCommand()));
    }

}
