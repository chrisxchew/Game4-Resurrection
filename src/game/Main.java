package game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import acm.graphics.*;
import acm.program.*;

public class Main extends GraphicsProgram {
	static int windowHeight = 500;
	static int windowWidth = 1000;
    Window window = new Window(windowWidth, windowHeight);
    Game game = new Game(windowWidth, windowHeight);

    private ArrayList < String > key_manager = new ArrayList < String > ();

    @Override
    public void run() {
        addKeyListeners();
        add(game.getPlayer().getPlayerGCompound());

        GLabel tileLabel = new GLabel(String.valueOf(game.getPlayer().getTile()[0]) + ", " + String.valueOf(game.getPlayer().getTile()[1]));

        add(tileLabel);

        while (true) {

            //for testing		
            //TODO for production, add window dexterity
            if (game.getPlayer().getX() > windowWidth - game.getPlayer().getPlayerWidth()) {
                game.moveTiles(1, 0);

                tileLabel.setLabel((game.getPlayer().getTile()[0]) + ", " + String.valueOf(game.getPlayer().getTile()[1]));

            }
            if (game.getPlayer().getX() < 0) {
                game.moveTiles(-1, 0);

                tileLabel.setLabel((game.getPlayer().getTile()[0]) + ", " + String.valueOf(game.getPlayer().getTile()[1]));

            }

            if (game.getPlayer().getY() < 0) {
                game.moveTiles(0, 1);
                tileLabel.setLabel((game.getPlayer().getTile()[0]) + ", " + String.valueOf(game.getPlayer().getTile()[1]));

            }
            if (game.getPlayer().getY() > windowHeight - game.getPlayer().getPlayerHeight()) {
                game.moveTiles(0, -1);
                tileLabel.setLabel((game.getPlayer().getTile()[0]) + ", " + String.valueOf(game.getPlayer().getTile()[1]));

            }

            System.out.print(game.getPlayer().getX());
            System.out.print(" ; ");
            System.out.println(game.getPlayer().getY());

            tileLabel.setLocation(windowWidth/2, windowHeight/2);

            handleKeyStrokes();
            pause(1);
        }
    }

    public void handleKeyStrokes() {
        if (key_manager.contains("w")) {
            game.getPlayer().moveY(-1);
        }
        if (key_manager.contains("s")) {
            game.getPlayer().moveY(1);
        }
        if (key_manager.contains("a")) {
            game.getPlayer().moveX(-1);
        }
        if (key_manager.contains("d")) {
            game.getPlayer().moveX(1);
        }
    }

    public void init() {
        setSize(window.getScreen_width(), window.getScreen_height());
        requestFocus();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            if (!key_manager.contains("w")) {
                key_manager.add("w");
            }
        }
        if (keyCode == KeyEvent.VK_S) {
            if (!key_manager.contains("s")) {
                key_manager.add("s");
            }
        }
        if (keyCode == KeyEvent.VK_A) {
            if (!key_manager.contains("a")) {
                key_manager.add("a");
            }
        }
        if (keyCode == KeyEvent.VK_D) {
            if (!key_manager.contains("d")) {
                key_manager.add("d");
            }
        }
    }
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            key_manager.remove("w");
        }
        if (keyCode == KeyEvent.VK_S) {
            key_manager.remove("s");
        }
        if (keyCode == KeyEvent.VK_A) {
            key_manager.remove("a");
        }
        if (keyCode == KeyEvent.VK_D) {
            key_manager.remove("d");
        }
    }

    public static void main(String[] args) {
        new Main().start();
    }
}