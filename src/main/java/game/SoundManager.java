package game;

public class SoundManager {
	public static final String SOUND = "sound";
	public static final String MENU = "Matroda - Gimme Some Keys  Insomniac Records.mp3";
	public static final String HIT = "Fall Damage Health Hit (Nr. 2  Fortnite Sound) - Sound Effect for editing.mp3";
	public static final String DUNGEON = "Undertale OST꞉ 006 - Uwa!! So Temperate♫.mp3";
	public static final String GAME = "Virtual Paradise.mp3";
	public static final String SWING = "Swing Sound  Popular Free Sound Effects  #copyrightfree  [ Copyright Free Gun & Weapon Sounds ].mp3";
	public static final String FIRE = "Minecraft Fireball Sound Effect.mp3";
	public static final String ARROW = "BowArrow Shot  Sound Effect.mp3";
	public static final String ENEMY = "Minecraft - Slime Big (Nr. 3) - Sound Effect  Best Quality #Shorts.mp3";
	public static final String CLICK = "Wooden Button Click Sound Effect.mp3";


	AudioPlayer audio;
	public void init() {
		audio = AudioPlayer.getInstance();
	}
	public void playSound(String sound) {
		switch(sound) {
		case "music":
			audio.playSound(SOUND, MENU);
			break;
		case "game":
			audio.playSound(SOUND, GAME);
			break;
		case "hit":
			audio.playSound(SOUND, HIT);
			break;
		case "dungeon":
			audio.playSound(SOUND, DUNGEON);
			break;
		case "swing":
			audio.playSound(SOUND, SWING);
			break;
		case "fire":
			audio.playSound(SOUND, FIRE);
			break;
		case "arrow":
			audio.playSound(SOUND, ARROW);
			break;
		case "enemy":
			audio.playSound(SOUND, ENEMY);
			break;
		case "click":
			audio.playSound(SOUND, CLICK);
		}
		
		
	}
}

