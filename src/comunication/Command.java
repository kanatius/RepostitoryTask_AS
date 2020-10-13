/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunication;

import java.io.Serializable;

/**
 *
 * @author natan
 */
public class Command implements Serializable {

    private String text;
    private Object object;

    public Command(String text, Object object) {
        this.text = text;
        this.object = object;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public static Command abortComunicationCommand() {
        return new Command("abortComunication", null);
    }

    public static Command getGamesByNameCommand() {
        return new Command("getGamesByName", null);
    }
    
    public static Command getGameByCodCommand(){
        return new Command("getGameByCod", null);
    }
    public static Command getGameSizeSmallerThanCommand(){
        return new Command("getGamesBySizeSmallerThan", null);
    }

    @Override
    public boolean equals(Object command) {
        if (command instanceof Command) {
            if (((Command) command).getText() == this.getText())           
                return true;          
        }
        return false;
    }

}
