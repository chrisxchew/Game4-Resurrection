package game;

public class SoundManager {
	public static final String SOUND = "sound";
	public static final String MUSIC = "Matroda - Gimme Some Keys  Insomniac Records.mp3";
	AudioPlayer audio;
	public void init() {
		audio = AudioPlayer.getInstance();
	}
	public void playSound(String sound) {
		switch(sound) {
		case "music":
			audio.playSound(SOUND, MUSIC);
			break;
		/*case "damaged":
			audio.playSound(SOUND, );
			break;
		case */
		}
	}
}

