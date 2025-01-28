package enemy;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class SoundManager {
	public static final String SOUND = "sounds";
	public static final String MENU = "Matroda - Gimme Some Keys  Insomniac Records.mp3";
	public static final String HIT = "Damage Impact Sound Effect.mp3";
	public static final String DUNGEON = "Undertale OST꞉ 006 - Uwa!! So Temperate♫.mp3";
	public static final String GAME = "Virtual Paradise.mp3";
	public static final String SWING = "sword slash (sound effects)  mani creation .mp3";
	public static final String FIRE = "Fireball Sound Effect.mp3";
	public static final String ARROW = "Arrow Fly By Sound Effect.mp3";
	public static final String ENEMY = "MInecraft Slime - Sound Effect (HD).mp3";
	public static final String CLICK = "Button Sound Effects (Copyright Free).mp3";
	public static final String EAT = "Monster Eating Sound Effect.mp3";
	public static final String WALK = "HD - Squidward Walking Sound Effect.mp3";

	AudioPlayer audio;
	
	public void init() {
		audio = AudioPlayer.getInstance();
	}
	
	public void playSound(String sound) {
		switch(sound) {
		case "menu":
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
			break;
		case "eat":
			audio.playSound(SOUND, EAT);
			break;
		case "walk":
			audio.playSound(SOUND, WALK);
			break;
		}
	}
	
	public void stopSound(String sound) {
		switch(sound) {
		case "menu":
			audio.stopSound(SOUND, MENU);
			break;
		case "game":
			audio.stopSound(SOUND, GAME);
			break;
		case "hit":
			audio.stopSound(SOUND, HIT);
			break;
		case "dungeon":
			audio.stopSound(SOUND, DUNGEON);
			break;
		case "swing":
			audio.stopSound(SOUND, SWING);
			break;
		case "fire":
			audio.stopSound(SOUND, FIRE);
			break;
		case "arrow":
			audio.stopSound(SOUND, ARROW);
			break;
		case "enemy":
			audio.stopSound(SOUND, ENEMY);
			break;
		case "click":
			audio.stopSound(SOUND, CLICK);
			break;
		case "eat":
			audio.stopSound(SOUND, EAT);
			break;
		case "walk":
			audio.stopSound(SOUND, WALK);
			break;
		}
	}
	
	public void pauseSound(String sound) {
		switch(sound) {
		case "menu":
			audio.pauseSound(SOUND, MENU);
			break;
		case "game":
			audio.pauseSound(SOUND, GAME);
			break;
		case "hit":
			audio.pauseSound(SOUND, HIT);
			break;
		case "dungeon":
			audio.pauseSound(SOUND, DUNGEON);
			break;
		case "swing":
			audio.pauseSound(SOUND, SWING);
			break;
		case "fire":
			audio.pauseSound(SOUND, FIRE);
			break;
		case "arrow":
			audio.pauseSound(SOUND, ARROW);
			break;
		case "enemy":
			audio.pauseSound(SOUND, ENEMY);
			break;
		case "click":
			audio.pauseSound(SOUND, CLICK);
			break;
		case "eat":
			audio.pauseSound(SOUND, EAT);
			break;
		case "walk":
			audio.pauseSound(SOUND, WALK);
			break;
		}
	}
	
	public void repeatSound(String sound) {
		switch(sound) {
		case "menu":
			audio.playSound(SOUND, MENU, true);
			break;
		case "game":
			audio.playSound(SOUND, GAME, true);
			break;
		case "hit":
			audio.playSound(SOUND, HIT, true);
			break;
		case "dungeon":
			audio.playSound(SOUND, DUNGEON, true);
			break;
		case "swing":
			audio.playSound(SOUND, SWING, true);
			break;
		case "fire":
			audio.playSound(SOUND, FIRE, true);
			break;
		case "arrow":
			audio.playSound(SOUND, ARROW, true);
			break;
		case "enemy":
			audio.playSound(SOUND, ENEMY, true);
			break;
		case "click":
			audio.playSound(SOUND, CLICK, true);
			break;
		case "eat":
			audio.playSound(SOUND, EAT, true);
			break;
		case "walk":
			audio.playSound(SOUND, WALK, true);
			break;
		}
	}
	
	public void shortSound(String sound) {
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        PauseTransition delay1 = new PauseTransition(Duration.seconds(1));
        PauseTransition delay2 = new PauseTransition(Duration.seconds(2));
		switch(sound) {
		case "menu":
			audio.playSound(SOUND, MENU);
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, MENU);
	        });
	        delay.play();
			break;
		case "game":
			audio.playSound(SOUND, GAME);
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, GAME);
	        });
	        delay.play();
			break;
		case "hit":
			audio.playSound(SOUND, HIT);
			delay2.setOnFinished(event -> {
	            audio.stopSound(SOUND, HIT);
	        });
	        delay2.play();
			break;
		case "dungeon":
			audio.playSound(SOUND, DUNGEON);
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, DUNGEON);
	        });
	        delay.play();
			break;
		case "swing":
			audio.playSound(SOUND, SWING);
			delay1.setOnFinished(event -> {
	            audio.stopSound(SOUND, SWING);
	        });
	        delay1.play();
			break;
		case "fire":
			audio.playSound(SOUND, FIRE);
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, FIRE);
	        });
	        delay.play();
			break;
		case "arrow":
			audio.playSound(SOUND, ARROW);
			delay1.setOnFinished(event -> {
	            audio.stopSound(SOUND, ARROW);
	        });
	        delay1.play();
			break;
		case "enemy":
			audio.playSound(SOUND, ENEMY);
			delay1.setOnFinished(event -> {
	            audio.stopSound(SOUND, ENEMY);
	        });
	        delay1.play();
			break;
		case "click":
			audio.playSound(SOUND, CLICK);
			delay1.setOnFinished(event -> {
	            audio.stopSound(SOUND, CLICK);
	        });
	        delay1.play();
			break;
		case "eat":
			audio.playSound(SOUND, EAT);
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, EAT);
	        });
	        delay.play();
			break;
		case "walk":
			audio.playSound(SOUND, WALK);
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, WALK);
	        });
	        delay.play();
			break;
		}
	}
	
}

