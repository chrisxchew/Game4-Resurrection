package game;
import java.util.Random;

import biomes.*;
public class Biome {
    private int[] colorRanges;
    protected String biomeName;
    protected int temp;
    public Biome() {
        colorRanges = new int[6];
    }
    public int[] getColorRanges() {
        return colorRanges;
    }
    public String toString() {
        return biomeName;
    }
    public int getTemp() {
        return temp;
    }
    public Biome chooseRandomBiome() {
        Random r = new Random();
        int i = r.nextInt(100);
        if (i < 33) {
            return new Desert();
        } 
        else if (i < 66) {

            return new Tundra();
        } else return new Moor();
    }
}