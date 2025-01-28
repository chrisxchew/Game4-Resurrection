package game;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class SoundManager {
	public static final String SOUND = "sounds";
	public static final String MENU = "Matroda - Gimme Some Keys  Insomniac Records.mp3";
	public static final String HIT = "Fall Damage Health Hit (Nr. 2  Fortnite Sound) - Sound Effect for editing.mp3";
	public static final String DUNGEON = "Undertale OST꞉ 006 - Uwa!! So Temperate♫.mp3";
	public static final String GAME = "Virtual Paradise.mp3";
	public static final String SWING = "Swing Sound  Popular Free Sound Effects  #copyrightfree  [ Copyright Free Gun & Weapon Sounds ].mp3";
	public static final String FIRE = "Minecraft Fireball Sound Effect.mp3";
	public static final String ARROW = "BowArrow Shot  Sound Effect.mp3";
	public static final String ENEMY = "Minecraft - Slime Big (Nr. 3) - Sound Effect  Best Quality #Shorts.mp3";
	public static final String CLICK = "Wooden Button Click Sound Effect.mp3";
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
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, HIT);
	        });
	        delay.play();
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
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, SWING);
	            System.out.println("Stopped after 3 seconds.");
	        });
	        delay.play();
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
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, ARROW);
	        });
	        delay.play();
			break;
		case "enemy":
			audio.playSound(SOUND, ENEMY);
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, ENEMY);
	            System.out.println("Stopped after 3 seconds.");
	        });
	        delay.play();
			break;
		case "click":
			audio.playSound(SOUND, CLICK);
			delay.setOnFinished(event -> {
	            audio.stopSound(SOUND, CLICK);
	        });
	        delay.play();
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

