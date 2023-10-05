package game;

public class Game {

    private Player player;
    private int screenWidth;
    private int screenHeight;
    public Game(int screenWidth, int screenHeight) {
        player = new Player(500, 250);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void moveTiles(int x, int y) {
        this.player.getTile()[0] += x;
        this.player.getTile()[1] += y;
        if (x == 1) {
            this.player.setX(1);
        }
        else if (x == -1) {
            this.player.setX(screenWidth - player.getPlayerWidth() - 1);
        }
        else if (y == -1) {
            this.player.setY(1);
        }
        else if (y == 1) {
            this.player.setY(screenHeight - player.getPlayerHeight()-1);
        }
        else {
        	System.out.println("function usage: (0,1), (1,0)");
        }
    }
}