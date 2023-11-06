package game;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import structures.Rock;
import structures.grassyBiomeRegularTree;
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
    public Tile(int screenWidth, int screenHeight, List < Integer > key, ArrayList < Tile > knownNeighbors) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
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
                Enemy e = new Enemy(r.nextInt(screenWidth - 50) + 50, r.nextInt(screenHeight - 50) + 50);
                enemies.add(e);
            }
            if (r.nextInt(500) < 20) {
                EnemyRect e2 = new EnemyRect(r.nextInt(screenWidth - 50) + 50, r.nextInt(screenHeight - 50) + 50);
                enemies.add(e2);
            }
        }
        generateStrutures();
        this.key = key;
    }
    public void generateStrutures() {
        for (int i = 0; i < 50; i++) {
            Random rnd = new Random();
            if (rnd.nextInt(100) == 5) {
                Rock rock = new Rock(rnd.nextInt(1000), rnd.nextInt(500));
                structures.add(rock);
                for (GObject obj: rock.getObjects()) {
                    objects.add(obj);
                }
            }
            if (rnd.nextInt(100) == 5) {
            	if(biome.getTemp() > 21) {
                    grassyBiomeRegularTree tree = new grassyBiomeRegularTree(rnd.nextInt(1000), rnd.nextInt(500));
                    structures.add(tree);
                    for (GObject obj: tree.getObjects()) {
                        objects.add(obj);
                    }
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