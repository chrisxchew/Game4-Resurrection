package structures;

import java.util.ArrayList;
import java.util.List;

import acm.graphics.GImage;
import acm.graphics.GLine;
import enemy.*;
import game.Tile;

public class CastleTile extends Tile{
    private GLine door;
    private Castle parentCastle;
    public CastleTile(Castle castle) {
        super();
        this.parentCastle = castle;
        this.key = new ArrayList < Integer > ();
        this.key.add(0);
        this.key.add(0);
        GImage castleFloor = new GImage("media/Buildings/InsideOfCastle-1.png.png");
        castleFloor.setSize(1000,500);
        castleFloor.setLocation(0,0);
        door = new GLine(10,200,10,800);
        objects.add(castleFloor);
        generateEnemies();
    }
    @Override
    public void generateEnemies(List<Integer> key) {
        
    }
    public void setParentCastle(Castle parentCastle){
        this.parentCastle = parentCastle;
    }
    @Override
    public void generateStrutures(){

    }
    public GLine getDoor() {
        return door;
    }
    public void generateEnemies(){
        if(parentCastle.isBossCastle()){
           Boss b = new Boss(900,250,parentCastle.getParentTile().getGame());
            enemies.add(b);
            ChestBoss c = new ChestBoss(900,250,parentCastle.getParentTile().getGame());
            enemies.add(c);
        }else{
            //if tile difficulty is greater than 20 make the enemies enemy rect 2, else make them enemy rect 1
            if((double)parentCastle.getParentTile().getTileDifficulty(parentCastle.getParentTile().getKey()) > 20){
                //add 3 enemy rect 2s in random locations
                for(int i = 0; i < 3; i++){
                    EnemyRect2 e = new EnemyRect2((int)(Math.random()*1000),(int)(Math.random()*500),parentCastle.getParentTile().getGame());
                    enemies.add(e);
                    EnemyTri4 e2 = new EnemyTri4((int)(Math.random()*1000),(int)(Math.random()*500),parentCastle.getParentTile().getGame());
                    enemies.add(e2);
                }
                Chest2 c = new Chest2(900,250,parentCastle.getParentTile().getGame());
                enemies.add(c);
            }else{
                //add 3 enemy rect 1s in random locations
                for(int i = 0; i < 3; i++){
                    EnemyRect1 e = new EnemyRect1((int)(Math.random()*1000),(int)(Math.random()*500),parentCastle.getParentTile().getGame());
                    enemies.add(e);
                    EnemyTri2 e2 = new EnemyTri2((int)(Math.random()*1000),(int)(Math.random()*500),parentCastle.getParentTile().getGame());
                    enemies.add(e2);
                }
                //add 1 chest
                //make the chest spawn at the middle right of the screen\
                Chest c = new Chest(900,250,parentCastle.getParentTile().getGame());
                enemies.add(c);
            
            }
        }
    }
}
