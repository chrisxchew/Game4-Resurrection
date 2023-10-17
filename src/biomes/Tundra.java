package biomes;

import game.Biome;

public class Tundra extends Biome{
	public Tundra(){
		getColorRanges()[0] = 180;
		getColorRanges()[1] = 200;
		getColorRanges()[2] = 250;
		getColorRanges()[3] = 254;
		getColorRanges()[4] = 250;
		getColorRanges()[5] = 254;
		
		biomeName = "tundra";
	}
}
