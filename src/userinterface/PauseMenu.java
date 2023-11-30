package userinterface;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;
import game.Main;

public class PauseMenu {
    boolean saveScreen = false;
    private GImage pause = new GImage("media/UI/MainMenu/pause_button.png");
    private GImage saveButton = new GImage("media/UI/MainMenu/save_button.png");
    private GImage quitButton = new GImage("media/UI/MainMenu/quit_button.png");
    private GImage saveButton1 = new GImage("media/UI/MainMenu/save_button1.png");
    private GImage saveButton2 = new GImage("media/UI/MainMenu/save_button2.png");
    private GImage saveButton3 = new GImage("media/UI/MainMenu/save_button3.png");
    private GImage backButton = new GImage("media/UI/MainMenu/back_button.png");
    private ArrayList<GObject> objects = new ArrayList<GObject>();
    Main main;
    public PauseMenu(Main main) {
        this.main = main;
        pause.setSize(800,400);
        pause.setLocation(100,-35);
        objects.add(pause);
        saveButton.setSize(225,75);
        quitButton.setSize(225,75);
        saveButton1.setSize(225,75);
        saveButton2.setSize(225,75);
        saveButton3.setSize(225,75);
        backButton.setSize(225,75);
        saveButton.setLocation(500-saveButton.getWidth()/2, 350-saveButton.getHeight()/2);
        quitButton.setLocation(500-quitButton.getWidth()/2, 425-quitButton.getHeight()/2);
        saveButton1.setLocation(500-saveButton1.getWidth()*3/2, 350-saveButton1.getHeight()/2);
        saveButton2.setLocation(500-saveButton2.getWidth()/2, 350-saveButton2.getHeight()/2);
        saveButton3.setLocation(500+saveButton3.getWidth()/2, 350-saveButton3.getHeight()/2);
        backButton.setLocation(500-backButton.getWidth()/2, 425-backButton.getHeight()/2);
        objects.add(saveButton);
        objects.add(quitButton);

    }
    public void keyPressed(MouseEvent e){
        if(saveScreen){
            if(main.getElementAt(e.getX(), e.getY()) == saveButton1){
                main.saveGame("save1");
                saveScreen = false;
                main.removePauseMenuObjects(this);
                objects.remove(saveButton1);
                objects.remove(saveButton2);
                objects.remove(saveButton3);
                objects.remove(backButton);
                objects.add(saveButton);
                objects.add(quitButton);
                main.addPauseMenuObjects(this);
                return;
            }
            if(main.getElementAt(e.getX(), e.getY()) == saveButton2){
                main.saveGame("save2");
                saveScreen = false;
                main.removePauseMenuObjects(this);
                objects.remove(saveButton1);
                objects.remove(saveButton2);
                objects.remove(saveButton3);
                objects.remove(backButton);
                objects.add(saveButton);
                objects.add(quitButton);
                main.addPauseMenuObjects(this);
                return;
            }
            if(main.getElementAt(e.getX(), e.getY()) == saveButton3){
                main.saveGame("save3");
                saveScreen = false;
                main.removePauseMenuObjects(this);
                objects.remove(saveButton1);
                objects.remove(saveButton2);
                objects.remove(saveButton3);
                objects.remove(backButton);
                objects.add(saveButton);
                objects.add(quitButton);
                main.addPauseMenuObjects(this);
                return;
            }
            if(main.getElementAt(e.getX(), e.getY()) == backButton){
                saveScreen = false;
                main.removePauseMenuObjects(this);
                objects.remove(saveButton1);
                objects.remove(saveButton2);
                objects.remove(saveButton3);
                objects.remove(backButton);
                objects.add(saveButton);
                objects.add(quitButton);
                main.addPauseMenuObjects(this);
                return;
            }   
        }else
        if(main.getElementAt(e.getX(), e.getY()) == saveButton){
            saveScreen = true;
            main.removePauseMenuObjects(this);
            objects.remove(saveButton);
            objects.remove(quitButton);
            objects.add(saveButton1);
            objects.add(saveButton2);
            objects.add(saveButton3);
            objects.add(backButton);
            main.addPauseMenuObjects(this);

            return;
        }
        if(main.getElementAt(e.getX(), e.getY()) == quitButton){
            System.exit(0);
        }
    }
    public ArrayList<GObject> getObjects() {
        return objects;
    }
    public void setSaveScreen(boolean saveScreen) {
        this.saveScreen = saveScreen;
        if(saveScreen){
            main.removePauseMenuObjects(this);
            objects.remove(saveButton);
            objects.remove(quitButton);
            objects.add(saveButton1);
            objects.add(saveButton2);
            objects.add(saveButton3);
            objects.add(backButton);
            main.addPauseMenuObjects(this);
        }else{
            main.removePauseMenuObjects(this);
            objects.remove(saveButton1);
            objects.remove(saveButton2);
            objects.remove(saveButton3);
            objects.remove(backButton);
            objects.add(saveButton);
            objects.add(quitButton);
            main.addPauseMenuObjects(this);
        }
    }
}
