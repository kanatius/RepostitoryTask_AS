/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchForSmallGamesTool;

import comunication.Command;
import games_repository.Game;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author natan
 */
public class searchGamesBySize {

    public static void main(String[] args) {

        try {
            //conexao com o servidor
            Socket conection = new Socket("localhost", 100);

            //canais de comunicação
            ObjectInputStream ois;
            ObjectOutputStream oos;
            ois = new ObjectInputStream(conection.getInputStream());
            oos = new ObjectOutputStream(conection.getOutputStream());
            float maxSize;
            do {
                maxSize = Float.parseFloat(JOptionPane.showInputDialog("Digite o tamanho max do jogo (em MB)")) * 1024;
                Command command = Command.getGameSizeSmallerThanCommand();
                command.setObject(maxSize); //set conteudo do comando = nome do jogo
                oos.writeObject(command); //envia comando
                List<Game> games = (ArrayList<Game>) ois.readObject(); //recebe jogos

                DecimalFormat deciF = new DecimalFormat("0.00");
                
                String mens = "";
                for (Game game : games) {
                    float gameSizeMb = game.getSizeInBytes()/1024;
                    
                    mens += game.getCod() + ": " + game.getNome() + "\nTamanho:" + deciF.format(gameSizeMb) + "MB \n\n";
                }
                JOptionPane.showMessageDialog(null, ("Jogos encontrados para você:\n\n" + mens));

            } while (maxSize > 0);
       
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(searchGamesBySize.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
