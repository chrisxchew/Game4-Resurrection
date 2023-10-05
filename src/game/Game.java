package game;

import java.util.*;

public class Game {

    private Player player;
    private int screenWidth;
    private int screenHeight;
    private Dictionary<String, Tile> tiles = new Hashtable<>();
    
    public Game(int screenWidth, int screenHeight) {
        player = new Player(screenWidth/2, screenHeight/2);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        String id = "[0, 0]";
        tiles.put(id, new Tile(screenWidth,screenHeight));
        
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Tile getCurrentTile() {
    	return tiles.get(Arrays.toString(player.getTile()));
    }

    public void moveTiles(int x, int y) {
        this.player.getTile()[0] += x;
        this.player.getTile()[1] += y;
        
        if(tiles.get(Arrays.toString(player.getTile()))==null) {
        	tiles.put(player.getTileID(), new Tile(screenWidth, screenHeight));
        }
        
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
        	System.out.println("moveTiles function usage: (0,1), (1,0)");
        }
    }
	public Dictionary<String, Tile> getTiles() {
		return tiles;
	}
	public void setTiles(Dictionary<String, Tile> tiles) {
		this.tiles = tiles;
	}

}