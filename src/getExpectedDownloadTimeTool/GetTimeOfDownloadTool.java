/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getExpectedDownloadTimeTool;

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
public class GetTimeOfDownloadTool {

    public static void main(String[] args) {

        try {
            //conexao com o servidor
            Socket conection = new Socket("localhost", 100);

            //canais de comunicação
            ObjectInputStream ois;
            ObjectOutputStream oos;
            ois = new ObjectInputStream(conection.getInputStream());
            oos = new ObjectOutputStream(conection.getOutputStream());

            while (true) {
                String nome = JOptionPane.showInputDialog("Digite o nome do jogo");
                Command command = Command.getGamesByNameCommand();
                command.setObject(nome); //set conteudo do comando = nome do jogo
                oos.writeObject(command); //envia comando
                List<Game> games = (ArrayList<Game>) ois.readObject(); //recebe jogos

                String gameCod;
                command = Command.getGameByCodCommand();

                if (games.size() > 1) {
                    String mens = "Digite o código do jogo\n\n";

                    for (Game game : games) {
                        mens += game.getCod() + ": " + game.getNome() + "\n\n";
                    }
                    String option = JOptionPane.showInputDialog(mens);
                    command.setObject(option); //set código do jogo    
                } else if (games.size() == 1) {
                    command.setObject(games.get(0).getCod());
                }

                oos.writeObject(command);
                Game gameReceived = (Game) ois.readObject();

                if (gameReceived != null) {
                    float sizeMb = gameReceived.getSizeInBytes() / 1024;

                    float netSpeedBit = 1024 * Float.parseFloat(JOptionPane.showInputDialog("Digite a velocidade da sua internet(MB)"));
                    float netSpeedByte = netSpeedBit / 8;
                    float downloadTimeInSec = gameReceived.getSizeInBytes() / netSpeedByte; //calcula o tempo de download em segundos
                    float downloadTimeInMinutes = downloadTimeInSec / 60; //converte o tempo de download para minutos
                    float downloadTimeInHours = downloadTimeInMinutes / 60;//converte o tempo de download para horas

                    int dtHours = (int) Math.floor(downloadTimeInHours);
                    int dtMinLasts = (int) downloadTimeInMinutes - dtHours * 60; //retira as horas fechadas e deixa somente os minutos (menor que 60)
                    int dtSecLasts = (int) downloadTimeInSec - dtMinLasts * 60;

                    DecimalFormat deci = new DecimalFormat("0.00");
                    JOptionPane.showMessageDialog(null, "O jogo " + gameReceived.getNome() + " tem " + deci.format(sizeMb)
                            + "MB de tamanho. Com a velocidade de conexão inserida, espara-se que o jogo seja baixado em por volta de " + dtHours
                            + " horas " + dtMinLasts + " minutos e " + dtSecLasts + " segundos");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(GetTimeOfDownloadTool.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetTimeOfDownloadTool.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
