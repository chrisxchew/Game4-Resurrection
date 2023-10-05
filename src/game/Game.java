package game;

import java.util.*;

public class Game {

    private Player player;
    private int screenWidth;
    private int screenHeight;
    private Dictionary<List<Integer>, Tile> tiles = new Hashtable<>();
    
    public Game(int screenWidth, int screenHeight) {
        player = new Player(screenWidth/2, screenHeight/2);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        List<Integer> id = Arrays.asList(new Integer[]{0,0});
        tiles.put(id, new Tile(screenWidth,screenHeight));
        
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public Tile getCurrentTile() {
    	return tiles.get(player.getTile());
    }

    public void moveTiles(int x, int y) {
        this.player.getTile().set(0, this.player.getTile().get(0)+x);
        this.player.getTile().set(1, this.player.getTile().get(1)+y);
        
        if(tiles.get(player.getTile())==null) {
        	tiles.put(player.getTile(), new Tile(screenWidth, screenHeight));
        }
        System.out.println(tiles.toString());
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
	public Dictionary<List<Integer>, Tile> getTiles() {
		return tiles;
	}
	public void setTiles(Dictionary<List<Integer>, Tile> tiles) {
		this.tiles = tiles;
	}

}