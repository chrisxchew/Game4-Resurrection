package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;
import game.Main;
import game.Saver;

public class MainMenu implements ActionListener{
    private ArrayList<GObject> objects = new ArrayList<GObject>();
    Main main;
    boolean loadScreen = false;
    GImage background = new GImage("media/UI/MainMenu/Blue Kirby Background.png");
    GImage startButton = new GImage("media/UI/MainMenu/start_button.png");
    GImage quitButton = new GImage("media/UI/MainMenu/quit_button.png");
    GImage loadButton = new GImage("media/UI/MainMenu/load_button.png");
    GImage saveButton1 = new GImage("media/UI/MainMenu/save_button1.png");
    GImage saveButton2 = new GImage("media/UI/MainMenu/save_button2.png");
    GImage saveButton3 = new GImage("media/UI/MainMenu/save_button3.png");
    GImage backButton = new GImage("media/UI/MainMenu/back_button.png");
    GImage title = new GImage("media/UI/MainMenu/Game_4_Title.png");
    Timer timer = new Timer(10, this);
    public MainMenu(Main main) {
        this.main = main;
        loadButton.setSize(225,75);
        startButton.setSize(225,75);
        quitButton.setSize(225,75);
        saveButton1.setSize(225,75);
        saveButton2.setSize(225,75);
        saveButton3.setSize(225,75);
        backButton.setSize(225,75);
        title.setSize(900,300);
        title.setLocation(100,-300);

        timer.start();
        startButton.setLocation(500-startButton.getWidth()/2, 300-startButton.getHeight()/2);
        loadButton.setLocation(500-loadButton.getWidth()/2, 375-loadButton.getHeight()/2);
        quitButton.setLocation(500-quitButton.getWidth()/2, 450-quitButton.getHeight()/2);
        background.setSize(1000,500);
        objects.add(background);
        objects.add(startButton);
        objects.add(loadButton);
        objects.add(quitButton);
        objects.add(title);
    }
    public ArrayList<GObject> getObjects() {
        return objects;
    }
    //every timer tick we lower the title
    @Override
    public void actionPerformed(ActionEvent e) {
        if(title.getLocation().getY() < 0){
            title.move(0, 2);
        }
    }

    public void keyPressed(MouseEvent e) {
        //buttosn are 225 width
        Saver saver = new Saver();
        if(loadScreen){
            if(main.getElementAt(e.getX(), e.getY()) == saveButton1){
                if(saver.checkIfSaveExists("save1")){
                    main.loadGame("save1");
                    timer.stop();
                    return;
                }

            }else if(main.getElementAt(e.getX(), e.getY()) == saveButton2){
                if(saver.checkIfSaveExists("save2")){
                    main.loadGame("save2");
                    timer.stop();
                    return;
                }
            }else if(main.getElementAt(e.getX(), e.getY()) == saveButton3){
                if(saver.checkIfSaveExists("save3")){
                    main.loadGame("save3");
                    timer.stop();
                    return;
                }
            }else if(main.getElementAt(e.getX(), e.getY()) == backButton){
                remakeMainMenu();
                return;
            }

        }
        if(!loadScreen){
            if(main.getElementAt(e.getX(), e.getY()) == startButton && !loadScreen){
                main.startGame();
                timer.stop();
                return;
            }else if(main.getElementAt(e.getX(), e.getY()) == quitButton){
                System.exit(0);
            }else if(main.getElementAt(e.getX(), e.getY()) == loadButton){
                makeLoadScreen();
                return;
            }
        }
    }
    public void removeAllObjectsFromScreen(){
        for(GObject object: objects){
            main.remove(object);
        }
    }
    public void makeLoadScreen(){

        removeAllObjectsFromScreen();
        objects.clear();
        objects.add(background);

        Saver saver = new Saver();
        //check if save exist before adding button


        saveButton1.setLocation(500-saveButton1.getWidth()/2, 300-saveButton1.getHeight()/2);
        saveButton2.setLocation(500-saveButton2.getWidth()/2, 375-saveButton2.getHeight()/2);
        saveButton3.setLocation(500-saveButton3.getWidth()/2, 450-saveButton3.getHeight()/2);
        //put back button at top left
        backButton.setLocation(10,10);
        if(saver.checkIfSaveExists("save1")){
            objects.add(saveButton1);
        }
        if(saver.checkIfSaveExists("save2")){
            objects.add(saveButton2);
        }
        if(saver.checkIfSaveExists("save3")){
            objects.add(saveButton3);
        }
        objects.add(backButton);
        main.loadMainMenu();
        loadScreen  = true;
    }
    public void remakeMainMenu(){

        removeAllObjectsFromScreen();
        objects.clear();
        title.setLocation(100,-300);

        startButton.setLocation(500-startButton.getWidth()/2, 300-startButton.getHeight()/2);
        loadButton.setLocation(500-loadButton.getWidth()/2, 375-loadButton.getHeight()/2);
        quitButton.setLocation(500-quitButton.getWidth()/2, 450-quitButton.getHeight()/2);

        objects.add(background);
        objects.add(startButton);
        objects.add(loadButton);
        objects.add(quitButton);
        objects.add(title);
        main.loadMainMenu();
        loadScreen  = false;
    }

}
