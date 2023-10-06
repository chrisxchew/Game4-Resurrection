package game;

import java.util.*;

public class Game {
//balls
    private Player player;
    private int screenWidth;
    private int screenHeight;
    private Dictionary<List<Integer>, Tile> tiles = new Hashtable<>();
    
    public Game(int screenWidth, int screenHeight) {
        player = new Player(screenWidth/2, screenHeight/2);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        List<Integer> id = Arrays.asList(new Integer[]{0,0});
        tiles.put(id, new Tile(screenWidth,screenHeight, id));
        
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
    
    //TODO
    //returns a tiles neighbors if they exist
    public ArrayList<Tile> getNeighbors(Tile tile){
    	ArrayList<Tile> output = new ArrayList<Tile>();
    	return output;
    }
    public void moveTiles(int x, int y) {
    	List<Integer> key = new ArrayList<Integer>();
    	key.add(this.player.getTile().get(0)+x);
    	key.add(this.player.getTile().get(1)+y);
        this.player.setTile(key);
        System.out.println(player.getTile().toString());
        if(tiles.get(player.getTile())==null) {
        	tiles.put(player.getTile(), new Tile(screenWidth, screenHeight, player.getTile()));
        }
        for(Tile tile : getNeighbors(tiles.get(player.getTile()))) {
            System.out.println(tile.toString());
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