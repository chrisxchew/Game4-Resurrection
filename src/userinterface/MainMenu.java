package userinterface;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.*;
import game.Main;

public class MainMenu {
    private ArrayList<GObject> objects = new ArrayList<GObject>();
    Main main;
    public MainMenu(Main main) {
        this.main = main;
        GImage background = new GImage("media/UI/MainMenu/Blue Kirby Background.png");
        GImage startButton = new GImage("media/UI/MainMenu/start_button.png");
        GImage quitButton = new GImage("media/UI/MainMenu/quit_button.png");
        startButton.scale(6);
        quitButton.scale(6);
        startButton.setLocation(500-startButton.getWidth()/2, 350-startButton.getHeight()/2);
        quitButton.setLocation(500-quitButton.getWidth()/2, 425-quitButton.getHeight()/2);

        background.setSize(1000,500);
        objects.add(background);
        objects.add(startButton);
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
        if(buttonPressed(500-300/2, 350-100/2, 225, 100, e)) {
            main.startGame();
        }
        if(buttonPressed(500-300/2, 425-100/2, 225, 100, e)) {
            System.exit(0);
        }
    }
}
