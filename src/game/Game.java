package game;
import java.util.*;

import structures.Castle;
import userinterface.*;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import items.*;
public class Game {
	
	// Program Variables
    private Player player;
    private int screenWidth;
    private int screenHeight;
    private boolean inCastle = false;
    private Map <List<Integer>, Tile> tiles = new Hashtable<>();
    private Hotbar hotbar;
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private ArrayList<EnemyProjectile> enemyProjectiles = new ArrayList<EnemyProjectile>();
    private GraphicsProgram graphicsProgram;
    private Castle castle = null;
    
    // Main Program Function
    public Game(int screenWidth, int screenHeight, GraphicsProgram graphicsProgram, boolean load) {
        this.graphicsProgram = graphicsProgram;
        player = new Player(screenWidth / 2, screenHeight / 2,screenWidth, screenHeight, this, load);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        List <Integer> id = Arrays.asList(new Integer[] {
            0,
            0
        });
        tiles.put(id, new Tile(screenWidth, screenHeight, id, null, this));
        hotbar = new Hotbar(player.getInventory(),player);
        player.setTile(id);
        for(Structure structure:this.getCurrentTile().getStructures()){
            if(structure instanceof Castle){
                castle = (Castle) structure;
            }
        }

    }
    
    // Getter Functions ---------------------------------------------------------------------------------------------
    
    /**
	 * Gets the 'GraphicsProgram' class object of the program.
	 * 
	 * @return graphicsProgram
	 *            Graphics program of the game.
	 */
    public GraphicsProgram getGraphicsProgram() {
        return graphicsProgram;
    }  
    
    /**
	 * Gets an ArrayList of 'Projectile' objects within the program.
	 * 
	 * @return projectiles
	 *            ArrayList of projectiles currently active in-game.
	 */
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
    
    /**
	 * Gets an ArrayList of projectiles created by the enemy currently in-game.
	 * 
	 * @return enemyProjectiles
	 *            ArrayList of all currently instantiated projectiles created by enemies.
	 */
    public ArrayList<EnemyProjectile> getEnemyProjectiles() {
        return enemyProjectiles;
    }
    
    /**
	 * Gets the Hotbar class variable of the program.
	 * 
	 * @return hotbar
	 *            Class object responsible for quickly accessing the first row of inventory.
	 */
    public Hotbar getHotbar() {
        return hotbar;
    }
    
    /**
	 * Gets the Player class object within the program.
	 * 
	 * @return player
	 *            Main object controlled by the user in-game.
	 */
    public Player getPlayer() {
        return player;
    }
    
    /**
	 * Gets the Castle class variable of this class within the program.
	 * 
	 * @return castle
	 *            Current instance of a Castle object in-game.
	 */
    public Castle getCastle(){
        return castle;
    }
    
    /**
	 * Gets the status of the player currently existing inside a castle.
	 * 
	 * @return inCastle
	 *            Boolean flag stating whether the player is within a castle currently.
	 */
    public boolean isInCastle() {
        return inCastle;
    }
    
    /**
	 * Gets the entire list of tiles and currently in the program.
	 * 
	 * @return tiles
	 *            List of tiles and their respective keys in the Map class variable.
	 */
    public Map <List<Integer>, Tile> getTiles() {
        return tiles;
    }
    
    /**
	 * Gets the current tile being visited by the player in-game.
	 * 
	 * @return castle.getCastleTile()
	 *            Returns an already instantiated castle-themed tile if the
	 *            player has entered a Castle object in-game.
	 *            
	 * @return tiles.get(player.getTile())
	 * 			  Returns an already instantiated biome-themed tile if the
	 * 			  player has not entered a Castle object in-game.
	 */
    public Tile getCurrentTile() {
        if (isInCastle()) {
            return castle.getCastleTile();
        }
        else {
            return tiles.get(player.getTile());
        }
    }
    
    /**
	 * Gets tiles in the four cardinal directions of a given tile (normally the current tile stood on).
	 * 
	 * @param tile
	 * 			  Key value of the current tile.
	 * @return output
	 *            ArrayList of surrounding tiles.
	 */
    public ArrayList<Tile> getNeighbors(List<Integer> tile) {
        ArrayList <Tile> output = new ArrayList<Tile> ();
        int index0 = tile.get(0);
        int index1 = tile.get(1);
        
        output.add(tiles.get(
            new ArrayList < Integer > (Arrays.asList(index0 + 1, index1))));
        output.add(tiles.get(
            new ArrayList < Integer > (Arrays.asList(index0 - 1, index1))));
        output.add(tiles.get(
            new ArrayList < Integer > (Arrays.asList(index0, index1 + 1))));
        output.add(tiles.get(
            new ArrayList < Integer > (Arrays.asList(index0, index1 - 1))));
        
        return output;
    }
    
    // Setter Functions ---------------------------------------------------------------------------------------------
    
    /**
	 * Sets the current Player variable of the program to a new instance of the Player class.
	 * 
	 * @param player
	 *            New instance of the in-game character controlled by the player.
	 */
    public void setPlayer(Player player) {
        this.player = player;
    }   
    
    /**
	 * Sets a list of tile objects and their respective keys to the Map class variable
	 * 
	 * @param tiles
	 *            List of tile objects and their respective keys.
	 */
    public void setTiles(Map<List<Integer>, Tile> tiles) {
        this.tiles = tiles;
    }
    
    /**
	 * Sets the Hotbar variable of the program to the instance of a given Hotbar object.
	 * 
	 * @param hotbar
	 *            Instance of a Hotbar class.
	 */
    public void setHotBar(Hotbar hotbar) {
        this.hotbar = hotbar;
    }
    
    /**
	 * Sets the Inventory variable of the program to the instance of a given Inventory object.
	 * 
	 * @param i
	 *            Instance of a Inventory class.
	 */
    public void setInventory(Inventory i) {
        this.player.setInventory(i);
    }
    
    // Tile Movement Functions -------------------------------------------------------------------------------------
    
    /**
	 * Moves the player to adjacent tile on the x or y axis.
	 * If a tile already exists at the specific location vector, move to that tile.
	 * Otherwise, if the tile doesn't already exist, instantiate the new tile to that
	 * location vector and move the player to it.
	 */
    public void moveTiles(int x, int y) {
        List < Integer > key = new ArrayList < Integer > ();
        key.add(this.player.getTile().get(0) + x);
        key.add(this.player.getTile().get(1) + y);
        this.player.setTile(key);

        if (tiles.get(player.getTile()) == null) {
            tiles.put(player.getTile(), new Tile(screenWidth, screenHeight, player.getTile(),
                getNeighbors(player.getTile()), this));
        }
        
        // Determine the position of the player object based on where they exited the previous tile.
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
            this.player.setY(screenHeight - player.getPlayerHeight() - 1);
        } 
        else {
            System.out.println("moveTiles function usage: (0,1), (1,0)");
        }
        
        for(Structure structure:tiles.get(key).getStructures()) {
            if (structure instanceof Castle) {
                castle = (Castle) structure;
            }
        }
    }
    
    /**
	 * Has the player enter a castle object and positions them at the entrance of the castle tile.
	 * 
	 * @param castle
	 *            Castle object of current tile in-game.
	 */
    public void enterCastle(Castle castle){
        inCastle = true;
        this.castle = castle;
        this.player.setX(50);
        this.player.setY(200);
    }
    
    /**
	 * Exits the player out of a castle and positions them outside the doors of the structure on the tile
	 * they entered from.
	 */
    public void exitCastle(){
        inCastle = false;
        this.player.setX(10);
        this.player.setY(275);
    }
    
    /**
	 * Refreshes the instance of a castle on a current tile for continuity.
	 */
    public void refreshCastle() {
        for (Structure s : getCurrentTile().getStructures()) {
            if (s instanceof Castle) {
                castle = (Castle) s;
            }
        }
    }
    
    // Graphical Object Functions ----------------------------------------------------------------------------------
    
    /**
	 * Adds a GraphicalObject(GObject) to the graphicsProgram. 
	 * 
	 * @param obj
	 *            Instance of a GraphicalObject(GObject).
	 */
    public void add(GObject obj){
        this.graphicsProgram.add(obj);
    }
    
    /**
	 * Removes a GraphicalObject(GObject) from the graphicsProgram.
	 * 
	 * @param obj
	 *            Instance of a GraphicalObject(GObject) in-game.
	 */
    public void remove(GObject obj){
        this.graphicsProgram.remove(obj);
    }
}