package game;
import java.util.*;

import items.Projectile;
import userinterface.*;
import acm.program.GraphicsProgram;
public class Game {
    private Player player;
    private int screenWidth;
    private int screenHeight;
    private Map < List < Integer > , Tile > tiles = new Hashtable < > ();
    private Hotbar hotbar;
    private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
    private GraphicsProgram graphicsProgram;
    public Game(int screenWidth, int screenHeight, GraphicsProgram graphicsProgram) {
        this.graphicsProgram = graphicsProgram;
        player = new Player(screenWidth / 2, screenHeight / 2,screenWidth, screenHeight);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        List < Integer > id = Arrays.asList(new Integer[] {
            0,
            0
        });
        tiles.put(id, new Tile(screenWidth, screenHeight, id, null, this));
        hotbar = new Hotbar(player.getInventory(),player);
    }
    public GraphicsProgram getGraphicsProgram() {
        return graphicsProgram;
    }  
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
    public Hotbar getHotbar() {
        return hotbar;
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
    public ArrayList < Tile > getNeighbors(List < Integer > tile) {
        ArrayList < Tile > output = new ArrayList < Tile > ();
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
    public void moveTiles(int x, int y) {
        List < Integer > key = new ArrayList < Integer > ();
        key.add(this.player.getTile().get(0) + x);
        key.add(this.player.getTile().get(1) + y);
        this.player.setTile(key);
        if (tiles.get(player.getTile()) == null) {
            tiles.put(player.getTile(), new Tile(screenWidth, screenHeight, player.getTile(),
                getNeighbors(player.getTile()), this));
        }
        if (x == 1) {
            this.player.setX(1);
        } else if (x == -1) {
            this.player.setX(screenWidth - player.getPlayerWidth() - 1);
        } else if (y == -1) {
            this.player.setY(1);
        } else if (y == 1) {
            this.player.setY(screenHeight - player.getPlayerHeight() - 1);
        } else {
            System.out.println("moveTiles function usage: (0,1), (1,0)");
        }
    }
    public Map < List < Integer > , Tile > getTiles() {
        return tiles;
    }
    public void setTiles(Map < List < Integer > , Tile > tiles) {
        this.tiles = tiles;
    }
    public void calculateEnemyPlayerCollision(){
        for(Enemy enemy: this.getCurrentTile().getEnemies()){
            if(!enemy.isDead()){
                if(enemy.getBody().getBounds().intersects(player.getPlayerGCompound().getBounds())){
                    player.setHealth(player.getHealth()-1);
                    player.getHealthPoints().updateHealthPointsIcons(player.getHealth());
                    //if enemy is above player, subtract 20 from velx
                    if(enemy.getY() < player.getPlayerCenter().getY()){
                        player.setVelY(-8);
                    }
                    //if enemy is below player, add 20 to velx
                    else if(enemy.getY() > player.getPlayerCenter().getY()){
                        player.setVelY(8);
                    }
                    //if enemy is to the left of player, subtract 20 from vely
                    if(enemy.getX() < player.getPlayerCenter().getX()){
                        player.setVelX(8);
                    }
                    //if enemy is to the right of player, add 20 to vely
                    else if(enemy.getX() > player.getPlayerCenter().getX()){
                        player.setVelX(-8);
                    }

                }
            }

        }
        
    }
}