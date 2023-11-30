package game;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import structures.boulder_1;
import structures.cactus_1;
import structures.grassyBiomeRegularTree;
import structures.iceBiomeHill;
import structures.tree1;
import structures.Castle;
import acm.graphics.*;
import enemy.*;
public class Tile {
    int screenWidth;
    int screenHeight;
    private Biome biome;
    protected List < Integer > key;
    protected ArrayList < GObject > objects = new ArrayList < GObject > ();
    protected ArrayList < Structure > structures = new ArrayList < Structure > ();
    protected ArrayList < Enemy > enemies = new ArrayList < Enemy > ();
    protected ArrayList < GLine > colliders = new ArrayList < GLine > ();
    public ArrayList < GObject > getObjects() {
        return objects;
    }
    public void setObjects(ArrayList < GObject > objects) {
        this.objects = objects;
    }
    private Game game;
    public Tile(List <Integer> key, Game game) {
        this.game = game;
        this.key = key;
    }
    public Tile(Castle castle){}
    public Tile(){}
    public Tile(int screenWidth, int screenHeight, List < Integer > key, ArrayList < Tile > knownNeighbors, Game game) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.game = game;
        this.key = key;
        Random r = new Random();
        biome = rollBiomes(knownNeighbors);
        for (int i = 0; i < screenWidth / 100; i++) {
            for (int k = 0; k < screenHeight / 100; k++) {
                GRect rectToAdd = new GRect(100, 100);
                int rr = r.nextInt(biome.getColorRanges()[1] - biome.getColorRanges()[0]) + biome
                    .getColorRanges()[0];
                int rg = r.nextInt(biome.getColorRanges()[3] - biome.getColorRanges()[2]) + biome
                    .getColorRanges()[2];
                int rb = r.nextInt(biome.getColorRanges()[5] - biome.getColorRanges()[4]) + biome
                    .getColorRanges()[4];
                rectToAdd.setFilled(true);
                rectToAdd.setColor(new Color(rr, rg, rb));
                rectToAdd.setFillColor(new Color(rr, rg, rb));
                rectToAdd.setLocation(i * 100, k * 100);
                objects.add(rectToAdd);
            }
        }
        
        generateEnemies(key);
        generateStrutures();
        this.key = key;
    }
    public int getTileDifficulty(List<Integer> key) {
        //difficulty is the distance from [0,0]
        return Math.abs(key.get(0)) + Math.abs(key.get(1));
    }
    public void generateEnemies(List<Integer> key){
        Random rand = new Random();
        //the farther you are from [0,0] the more enemies there are and the harder they are
        //from 0-10 difficulty the enemies have 1% chance to spawn
        //from 11-20 difficulty the enemies have 2% chance to spawn
        //from 21-30 difficulty the enemies have 3% chance to spawn
        //from 31-40 difficulty the enemies have 4% chance to spawn
        //from 0-20 mostly lvl 1 enemies spawn and a few lvl 2 enemies spawn
        //from 21-40 mostly lvl 2 enemies spawn and a few lvl 3 enemies spawn
        //from 41-60 mostly lvl 3 enemies spawn and a few lvl 4 enemies spawn
        //from 61-80 only lvl 4 enemies spawn
        int percent_chance = 0;
        if(getTileDifficulty(key)%10 > 4){
            percent_chance = 4;
        }else{
            percent_chance = getTileDifficulty(key)%10;
        }
        for(int i = 0; i < getTileDifficulty(key)*2;i++){
            if(percentChance(percent_chance)){
                if(getTileDifficulty(key) < 20){
                    int rx = rand.nextInt(800) + 100;
                    int ry = rand.nextInt(450) + 25;
                    EnemyTri1 enemy = new EnemyTri1(rx,ry,game);
                    enemies.add(enemy);
                }
                if(getTileDifficulty(key) >= 20 && getTileDifficulty(key) < 40){
                    //50% chance to spawn a lvl 2 enemy
                    int rx = rand.nextInt(800) + 100;
                    int ry = rand.nextInt(450) + 25;
                    if(percentChance(50)){
                        EnemyTri2 enemy = new EnemyTri2(rx,ry,game);
                        enemies.add(enemy);
                    }else{
                        EnemyTri1 enemy = new EnemyTri1(rx,ry,game);
                        enemies.add(enemy);
                    }
                }
                if(getTileDifficulty(key) >= 40 && getTileDifficulty(key) < 60){
                    //50% chance to spawn a lvl 3 enemy
                    int rx = rand.nextInt(800) + 100;
                    int ry = rand.nextInt(450) + 25;
                    if(percentChance(50)){
                        EnemyTri3 enemy = new EnemyTri3(rx,ry,game);
                        enemies.add(enemy);
                    }else{
                        EnemyTri2 enemy = new EnemyTri2(rx,ry,game);
                        enemies.add(enemy);
                    }
                }
                if(getTileDifficulty(key) >= 60 && getTileDifficulty(key) < 80){
                    //50% chance to spawn a lvl 4 enemy
                    int rx = rand.nextInt(800) + 100;
                    int ry = rand.nextInt(450) + 25;
                    if(percentChance(50)){
                        EnemyTri4 enemy = new EnemyTri4(rx,ry,game);
                        enemies.add(enemy);
                    }else{
                        EnemyTri3 enemy = new EnemyTri3(rx,ry,game);
                        enemies.add(enemy);
                    }
                }
                if(getTileDifficulty(key) >= 80){
                    //50% chance to spawn a lvl 4 enemy
                    int rx = rand.nextInt(800) + 100;
                    int ry = rand.nextInt(450) + 25;
                    EnemyTri4 enemy = new EnemyTri4(rx,ry,game);
                    enemies.add(enemy);
                }
            }
        }

        
    }
    public Game getGame() {
        return game;
    }
    public boolean percentChance(int percent) {
        Random r = new Random();
        if (r.nextInt(100) < percent) {
            return true;
        }
        return false;
    }
    public void addObjects(ArrayList<GObject> objects, ArrayList<GObject> objectsToAdd){
        for(GObject obj: objectsToAdd){
            objects.add(obj);
        }
    }

    public void addColliders(ArrayList <GLine> colliders, ArrayList <GLine> linesToAdd) {
    	for(GLine line: linesToAdd) {
    		colliders.add(line);
    	}
    }
    public void generateStrutures() {
        boolean castleExists = false;
        for(int i = 0; i < 10; i++){
            if (percentChance(1) && !castleExists && key.get(0) != 0 && key.get(1) != 0) {
                Castle castle = new Castle(200, 60, this);
                structures.add(castle);
                addObjects(objects, castle.getObjects());
                addColliders(colliders, castle.getColliders());
                castleExists = true;
            }
        }
        for (int i = 0; i < 50; i++) {
            Random rnd = new Random();
            if (percentChance(1)) {
                boulder_1 rock = new boulder_1(rnd.nextInt(1000), rnd.nextInt(500));
                structures.add(rock);
                addObjects(objects, rock.getObjects());
            }
            if (percentChance(1)) {
            	if(biome.getTemp() > 21) {
                    grassyBiomeRegularTree tree = new grassyBiomeRegularTree(rnd.nextInt(1000), rnd.nextInt(500));
                    structures.add(tree);
                    addObjects(objects, tree.getObjects());
            	}
            }
            if (percentChance(1)) {
            	if(biome.getTemp() > 99) {
                    cactus_1 cactus = new cactus_1(rnd.nextInt(1000), rnd.nextInt(500));
                    structures.add(cactus);
                    addObjects(objects, cactus.getObjects());
            	}
            }
            

            if (percentChance(2)) {
                if(biome.getTemp() < 21){
                    iceBiomeHill hill = new iceBiomeHill(rnd.nextInt(1000), rnd.nextInt(500));
                    structures.add(hill);
                    addObjects(objects, hill.getObjects());
                }

            }
            if (percentChance(1)) {
            	if(biome.getTemp() == 50) {
            		tree1 tree = new tree1(rnd.nextInt(1000), rnd.nextInt(500));
                    structures.add(tree);
                    addObjects(objects, tree.getObjects());
            	}

            }
        }
    }
    public GLine getDoor() {
        for (Structure structure: structures) {
            if (structure.getDoor() != null) {
                return structure.getDoor();
            }
        }
        return null;
    }
    public List < Integer > getKey() {
        return key;
    }
    public void setKey(List < Integer > key) {
        this.key = key;
    }
    public String toString() {
        return (String.valueOf("[" + key.get(0)) + " , " + String.valueOf(key.get(1) + "]"));
    }
    public ArrayList < GLine > getColliders() {
        return colliders;
    }
    public Biome getBiome() {
        return biome;
    }
    public void setBiome(Biome biome) {
        this.biome = biome;
    }
    public ArrayList < Enemy > getEnemies() {
        return enemies;
    }
    public ArrayList < Structure > getStructures() {
        return structures;
    }
    public void setStructures(ArrayList < Structure > structures) {
        this.structures = structures;
    }
    public void setEnemies(ArrayList < Enemy > enemies) {
        this.enemies = enemies;
    }
    public void setColliders(ArrayList < GLine > colliders) {
        this.colliders = colliders;
    }
    public ArrayList<Tile> setNeighbors(ArrayList<Tile> neighbors){
        return neighbors;
    }
    private Biome rollBiomes(ArrayList < Tile > knownNeighbors) {
        Biome biome = new Biome();
        int matchingBiomes = 0;
        int needToMatch = 0;
        if (knownNeighbors == null) {
            biome = biome.chooseRandomBiome();
            return biome;
        }
        for (Tile tile: knownNeighbors) {
            if (tile != null) {
                needToMatch++;
            }
        }
        while (matchingBiomes != needToMatch) {
            matchingBiomes = 0;
            biome = biome.chooseRandomBiome();
            for (Tile tile: knownNeighbors) {
                if (tile != null) {
                    if (Math.abs(biome.getTemp() - tile.getBiome().getTemp()) < 51) {
                        matchingBiomes++;
                    }
                }
            }
        }
        return biome;
    }
    public int getDifficulty() {
        return getTileDifficulty(key);
    }
}	