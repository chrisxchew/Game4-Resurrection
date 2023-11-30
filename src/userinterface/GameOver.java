package userinterface;

import acm.graphics.GImage;
import acm.graphics.GRect;
import game.Saver;
import acm.graphics.GObject;
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import game.Main;
public class GameOver{
    GImage quit = new GImage("media/UI/MainMenu/quit_button.png");
    Main main;
    private ArrayList <GObject> objects;
    public GameOver(Main main){
        this.objects = new ArrayList<GObject>();
        this.main = main;
        //make background black
        GRect background = new GRect(0, 0, 2000, 2000);
        background.setFillColor(java.awt.Color.BLACK);
        background.setFilled(true);
        GImage gameover = new GImage("media/UI/GameOver/Game_Over.png");
        gameover.scale(5);
        gameover.setLocation(375, 300);

        quit.scale(5);
        quit.setLocation(450, 400);
        this.objects.add(background);
        this.objects.add(gameover);
        this.objects.add(quit);
        background.sendBackward();

    }
    public void keyPressed(MouseEvent e) {
        System.out.println(main.getElementAt(e.getX(), e.getY()));
            if (main.getElementAt(e.getX(), e.getY()) == quit){
                System.exit(0);

        }
    }
    public ArrayList<GObject> getObjects(){
        return objects;
    }

}