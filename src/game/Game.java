package game;

public class Game {

    private Player player;

    public Game() {
        player = new Player(500, 250);
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
        if (x == -1) {
            //TODO Add window dexterity
            this.player.setX(949);
        }
        if (y == -1) {
            //TODO Add window dexterity
            this.player.setY(1);
        }
        if (y == 1) {
            this.player.setY(449);
        }

    }
}