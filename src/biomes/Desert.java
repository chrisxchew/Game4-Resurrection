package biomes;

import game.Biome;

public class Desert extends Biome{
	public Desert(){
		getColorRanges()[0] = 220;
		getColorRanges()[1] = 245;
		getColorRanges()[2] = 180;
		getColorRanges()[3] = 200;
		getColorRanges()[4] = 80;
		getColorRanges()[5] = 90;
		
		biomeName = "desert";
	}
}
