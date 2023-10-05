package game;

public class Game {
	
	private Player player;
	
	public Game() {
		player = new Player(250, 250);
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
}
