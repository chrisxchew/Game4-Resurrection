package userinterface;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.*;
import game.Main;

public class MainMenu {
    private ArrayList<GObject> objects = new ArrayList<GObject>();
    Main main;
    boolean loadScreen = false;
    public MainMenu(Main main) {
        this.main = main;
        GImage background = new GImage("media/UI/MainMenu/Blue Kirby Background.png");
        GImage startButton = new GImage("media/UI/MainMenu/start_button.png");
        GImage quitButton = new GImage("media/UI/MainMenu/quit_button.png");
        GImage loadButton = new GImage("media/UI/MainMenu/load_button.png");
        loadButton.scale(6);
        startButton.scale(6);
        quitButton.scale(6);
        startButton.setLocation(500-startButton.getWidth()/2, 300-startButton.getHeight()/2);
        loadButton.setLocation(500-loadButton.getWidth()/2, 375-loadButton.getHeight()/2);
        quitButton.setLocation(500-quitButton.getWidth()/2, 450-quitButton.getHeight()/2);
        background.setSize(1000,500);
        objects.add(background);
        objects.add(startButton);
        objects.add(loadButton);
        objects.add(quitButton);
    }
    public boolean buttonPressed(int x, int y, int width, int height, MouseEvent e) {
        if(e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height) {
            return true;
        } else {
            return false;
        }
    }
    public ArrayList<GObject> getObjects() {
        return objects;
    }
    public void keyPressed(MouseEvent e) {
        //buttosn are 225 width

        if(buttonPressed(500-225/2, 300-225/2, 225, 225, e)) {
            main.startGame();
        }
        if(buttonPressed(500-225/2, 375-225/2, 225, 225, e)) {
            //main.loadGame();
        }
        if(buttonPressed(500-225/2, 450-225/2, 225, 225, e)) {
            System.exit(0);
        }
    }
    public void makeLoadScreen(){
        loadScreen  = true;
        objects.clear();
        GImage background = new GImage("media/UI/MainMenu/Blue Kirby Background.png");
        GImage loadScreen = new GImage("media/UI/MainMenu/load_screen.png");
        loadScreen.scale(6);
        loadScreen.setLocation(500-loadScreen.getWidth()/2, 250-loadScreen.getHeight()/2);
        background.setSize(1000,500);
        objects.add(background);
        objects.add(loadScreen);
    }
    public void remakeMainMenu(){
        loadScreen = false;
        objects.clear();
        GImage background = new GImage("media/UI/MainMenu/Blue Kirby Background.png");
        GImage startButton = new GImage("media/UI/MainMenu/start_button.png");
        GImage quitButton = new GImage("media/UI/MainMenu/quit_button.png");
        GImage loadButton = new GImage("media/UI/MainMenu/load_button.png");
        loadButton.scale(6);
        startButton.scale(6);
        quitButton.scale(6);
        startButton.setLocation(500-startButton.getWidth()/2, 300-startButton.getHeight()/2);
        loadButton.setLocation(500-loadButton.getWidth()/2, 375-loadButton.getHeight()/2);
        quitButton.setLocation(500-quitButton.getWidth()/2, 450-quitButton.getHeight()/2);
        background.setSize(1000,500);
        objects.add(background);
        objects.add(startButton);
        objects.add(loadButton);
        objects.add(quitButton);
        main.loadMainMenu();
    }

}
