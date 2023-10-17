package game;

public class Biome {
	private int[] colorRanges;
	protected String biomeName;
	public Biome() {
		colorRanges = new int[6];
	}
	public int[] getColorRanges() {
		return colorRanges;
	}
	public String toString() {
		return biomeName;
	}
}
