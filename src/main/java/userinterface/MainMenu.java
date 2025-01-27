package userinterface;

import java.awt.Font;
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
    boolean howToPlayScreen = false;
    GImage background = new GImage("media/UI/MainMenu/Blue Kirby Background.png");
    GImage startButton = new GImage("media/UI/MainMenu/start_button.png");
    GImage quitButton = new GImage("media/UI/MainMenu/quit_button.png");
    GImage loadButton = new GImage("media/UI/MainMenu/load_button.png");
    GImage saveButton1 = new GImage("media/UI/MainMenu/save_button1.png");
    GImage saveButton2 = new GImage("media/UI/MainMenu/save_button2.png");
    GImage saveButton3 = new GImage("media/UI/MainMenu/save_button3.png");
    GImage backButton = new GImage("media/UI/MainMenu/back_button.png");
    GImage title = new GImage("media/UI/MainMenu/Game_4_Title.png");
    GImage howToPlay = new GImage("media/UI/MainMenu/HowToPlay.png");
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
        howToPlay.setSize(225,75);
        title.setSize(900,300);
        title.setLocation(100,-300);

        timer.start();
        howToPlay.setLocation(10, 500-howToPlay.getHeight()-10);
        startButton.setLocation(500-startButton.getWidth()/2, 300-startButton.getHeight()/2);
        loadButton.setLocation(500-loadButton.getWidth()/2, 375-loadButton.getHeight()/2);
        quitButton.setLocation(500-quitButton.getWidth()/2, 450-quitButton.getHeight()/2);
        background.setSize(1000,500);
        objects.add(background);
        objects.add(startButton);
        objects.add(loadButton);
        objects.add(quitButton);
        objects.add(title);
        objects.add(howToPlay);
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
        if(howToPlayScreen){
            if(main.getElementAt(e.getX(), e.getY()) == backButton){
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
            }else if(main.getElementAt(e.getX(), e.getY()) == howToPlay){
                makeHowToPlayScreen();
                howToPlayScreen = true;
                return;
            }
        }
    }
    public void removeAllObjectsFromScreen(){
        for(GObject object: objects){
            main.remove(object);
        }
    }
    public void makeHowToPlayScreen(){
        
        removeAllObjectsFromScreen();
        objects.clear();

        //make a new font
        Font font = new Font("Arial", Font.BOLD, 10);

        GImage w = new GImage("media/UI/Keyboard/Letters/Key_W.png");
        GImage a = new GImage("media/UI/Keyboard/Letters/Key_A.png");
        GImage s = new GImage("media/UI/Keyboard/Letters/Key_S.png");
        GImage d = new GImage("media/UI/Keyboard/Letters/Key_D.png");
        GImage e = new GImage("media/UI/Keyboard/Letters/Key_E.png");
        GImage mouse = new GImage("media/UI/Mouse/Mouse_LeftClick.png");
        GImage zero = new GImage("media/UI/Keyboard/Numbers/Key_0.png");
        GImage one = new GImage("media/UI/Keyboard/Numbers/Key_1.png");
        GImage two = new GImage("media/UI/Keyboard/Numbers/Key_2.png");
        GImage three = new GImage("media/UI/Keyboard/Numbers/Key_3.png");
        GImage four = new GImage("media/UI/Keyboard/Numbers/Key_4.png");
        GImage five = new GImage("media/UI/Keyboard/Numbers/Key_5.png");
        GImage six = new GImage("media/UI/Keyboard/Numbers/Key_6.png");
        GImage seven = new GImage("media/UI/Keyboard/Numbers/Key_7.png");
        GImage eight = new GImage("media/UI/Keyboard/Numbers/Key_8.png");
        GImage nine = new GImage("media/UI/Keyboard/Numbers/Key_9.png");
        GImage esc = new GImage("media/UI/Keyboard/Special/Key_Escape.png");
        GLabel move = new GLabel("Move");
        GLabel use = new GLabel("Use");
        GLabel selectItem = new GLabel("Select Item");
        GLabel inventory = new GLabel("Inventory");
        GLabel pause = new GLabel("Pause");
        GLabel samLabel = new GLabel("Sam: I spent 250+ hours on this game");
        GLabel chrisLabel = new GLabel("Chris: I still dont really know what a rave is");
        GLabel andrewLabel = new GLabel("Andrew: Keeps going to those cult meetings");
        GLabel juanLabel = new GLabel("Juan: Told me the green salsa wasnt spicy");

        GImage Sam = new GImage("media/UI/Sam.jpg");
        GImage Chris = new GImage("media/UI/Chris.png");
        GImage Andrew = new GImage("media/UI/Andrew.png");
        GImage Juan = new GImage("media/UI/Juan.png");

        move.setFont(font);
        use.setFont(font);
        selectItem.setFont(font);
        inventory.setFont(font);
        samLabel.setFont(font);
        chrisLabel.setFont(font);
        andrewLabel.setFont(font);
        juanLabel.setFont(font);
        pause.setFont(font);


        mouse.setSize(100,100);
        w.setSize(50,50);
        a.setSize(50,50);
        s.setSize(50,50);
        d.setSize(50,50);
        e.setSize(50,50);
        Sam.setSize(100,125);
        Chris.setSize(100,100);
        Andrew.setSize(100,100);
        Juan.setSize(100,100);


        zero.setSize(50,50);
        one.setSize(50,50);
        two.setSize(50,50);
        three.setSize(50,50);
        four.setSize(50,50);
        five.setSize(50,50);
        six.setSize(50,50);
        seven.setSize(50,50);
        eight.setSize(50,50);
        nine.setSize(50,50);

        w.setLocation(100, 100);
        a.setLocation(50, 150);
        s.setLocation(100, 150);
        d.setLocation(150, 150);
        e.setLocation(500,250);
        mouse.setLocation(100, 250);
        esc.setLocation(500, 300);
        pause.setLocation(500, 350);

        move.setLocation(225, 150);
        use.setLocation(225, 300);
        selectItem.setLocation(250, 375);
        //make the numbers 0-9 side by side
        zero.setLocation(50, 400);
        one.setLocation(100, 400);
        two.setLocation(150, 400);
        three.setLocation(200, 400);
        four.setLocation(250, 400);
        five.setLocation(300, 400);
        six.setLocation(350, 400);
        seven.setLocation(400, 400);
        eight.setLocation(450, 400);
        nine.setLocation(500, 400);
        Sam.setLocation(650, 50);
        samLabel.setLocation(775, 150);
        Chris.setLocation(650, 200);
        chrisLabel.setLocation(775, 250);
        andrewLabel.setLocation(775, 350);
        juanLabel.setLocation(775, 450);
        Andrew.setLocation(650, 300);
        Juan.setLocation(650, 400);
        inventory.setLocation(450,275);
        esc.setSize(50,50);
        pause.setLocation(450,325);
        objects.add(background);
        objects.add(pause);
        objects.add(esc);
        objects.add(samLabel);
        objects.add(Sam);
        objects.add(backButton);
        objects.add(w);
        objects.add(a);
        objects.add(s);
        objects.add(d);
        objects.add(e);
        objects.add(mouse);
        objects.add(zero);
        objects.add(one);
        objects.add(two);
        objects.add(three);
        objects.add(four);
        objects.add(five);
        objects.add(six);
        objects.add(seven);
        objects.add(eight);
        objects.add(nine);
        objects.add(move);
        objects.add(use);
        objects.add(selectItem);
        objects.add(chrisLabel);
        objects.add(Chris);
        objects.add(andrewLabel);
        objects.add(Andrew);
        objects.add(juanLabel);
        objects.add(Juan);
        objects.add(inventory);
        main.loadMainMenu();
    }
    public void makeLoadScreen(){

        removeAllObjectsFromScreen();
        objects.clear();
        objects.add(background);

        Saver saver = new Saver();
        saveButton1.setLocation(500-saveButton1.getWidth()/2, 300-saveButton1.getHeight()/2);
        saveButton2.setLocation(500-saveButton2.getWidth()/2, 375-saveButton2.getHeight()/2);
        saveButton3.setLocation(500-saveButton3.getWidth()/2, 450-saveButton3.getHeight()/2);
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
        objects.add(howToPlay);
        objects.add(startButton);
        objects.add(loadButton);
        objects.add(quitButton);
        objects.add(title);
        main.loadMainMenu();
        loadScreen  = false;
    }

}
