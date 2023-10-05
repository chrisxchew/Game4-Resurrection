package game;

import acm.program.*;

public class Test_runner extends GraphicsProgram{
	Window window = new Window(500,500);
	Game game = new Game();
	@Override
	public void run() {
		
		add(game.getPlayer().getPlayerGCompound());
	}
	
	public void init() {
		setSize(window.getScreen_width(), window.getScreen_height());
		requestFocus();
	}
	
	public static void main(String[] args) {
		new Test_runner().start();
	}
}
