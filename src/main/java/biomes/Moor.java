package biomes;

import game.Biome;

public class Moor extends Biome{
	public Moor(){
		getColorRanges()[0] = 40;
		getColorRanges()[1] = 90;
		getColorRanges()[2] = 153;
		getColorRanges()[3] = 154;
		getColorRanges()[4] = 40;
		getColorRanges()[5] = 50;
		
		biomeName = "moor";
		
		temp = 50;
	}
}
