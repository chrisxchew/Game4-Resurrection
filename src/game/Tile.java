package game;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import structures.boulder_1;
import structures.grassyBiomeRegularTree;
import structures.iceBiomeHill;
import structures.tree1;
import structures.Castle;
import acm.graphics.*;
import enemy.EnemyRect;
public class Tile {
    int screenWidth;
    int screenHeight;
    private Biome biome;
    private List < Integer > key;
    private ArrayList < GObject > objects = new ArrayList < GObject > ();
    private ArrayList < Structure > structures = new ArrayList < Structure > ();
    private ArrayList < Enemy > enemies = new ArrayList < Enemy > ();
    
    public ArrayList < GObject > getObjects() {
        return objects;
    }
    public void setObjects(ArrayList < GObject > objects) {
        this.objects = objects;
    }
    private Game game;
    public Tile(int screenWidth, int screenHeight, List < Integer > key, ArrayList < Tile > knownNeighbors, Game game) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.game = game;
        Random r = new Random();
        biome = rollBiomes(knownNeighbors);
        for (int i = 0; i < screenWidth / 10; i++) {
            for (int k = 0; k < screenHeight / 10; k++) {
                GRect rectToAdd = new GRect(10, 10);
                int rr = r.nextInt(biome.getColorRanges()[1] - biome.getColorRanges()[0]) + biome
                    .getColorRanges()[0];
                int rg = r.nextInt(biome.getColorRanges()[3] - biome.getColorRanges()[2]) + biome
                    .getColorRanges()[2];
                int rb = r.nextInt(biome.getColorRanges()[5] - biome.getColorRanges()[4]) + biome
                    .getColorRanges()[4];
                rectToAdd.setFilled(true);
                rectToAdd.setColor(new Color(rr, rg, rb));
                rectToAdd.setFillColor(new Color(rr, rg, rb));
                rectToAdd.setLocation(i * 10, k * 10);
                objects.add(rectToAdd);
            }
        }
        for (int i = 0; i < 10; i++) {
            if (r.nextInt(500) < 20) {
                Enemy e = new Enemy(r.nextInt(screenWidth - 50) + 50, r.nextInt(screenHeight - 50) + 50, this.game);
                enemies.add(e);
            }
            if (r.nextInt(500) < 20) {
                EnemyRect e2 = new EnemyRect(r.nextInt(screenWidth - 50) + 50, r.nextInt(screenHeight - 50) + 50, this.game);
                enemies.add(e2);
            }
        }
        generateStrutures();
        this.key = key;
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
    public void generateStrutures() {
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
                Castle castle = new Castle(200, 60);
                structures.add(castle);
                addObjects(objects, castle.getObjects());
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
    public List < Integer > getKey() {
        return key;
    }
    public void setKey(List < Integer > key) {
        this.key = key;
    }
    public String toString() {
        return (String.valueOf("[" + key.get(0)) + " , " + String.valueOf(key.get(1) + "]"));
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
}	