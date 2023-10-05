package game;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import acm.program.*;

public class Test_runner extends GraphicsProgram{
	Window window = new Window(1000,500);
	Game game = new Game();
	
	private ArrayList<String> key_manager = new ArrayList<String>();
	
	@Override
	public void run() {
		addKeyListeners();
		add(game.getPlayer().getPlayerGCompound());
		while(true) {
			handleKeyStrokes();
	        pause(1);
		}
	}
	
	public void handleKeyStrokes() {
		if(key_manager.contains("w")) {
			game.getPlayer().moveY(-1);
		}
		if(key_manager.contains("s")) {
			game.getPlayer().moveY(1);
		}
		if(key_manager.contains("a")) {
			game.getPlayer().moveX(-1);
		}
		if(key_manager.contains("d")) {
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
        	if(!key_manager.contains("w")) {
                key_manager.add("w");
        	}
        }
        if (keyCode == KeyEvent.VK_S) {
        	if(!key_manager.contains("s")) {
        		key_manager.add("s");
        	}
        }
        if (keyCode == KeyEvent.VK_A) {
        	if(!key_manager.contains("a")) {
        		key_manager.add("a");
        	}
        }
        if (keyCode == KeyEvent.VK_D) {
        	if(!key_manager.contains("d")) {
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
		new Test_runner().start();
	}
}
