package game;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Saver {
    static int windowHeight = 500;
    static int windowWidth = 1000;
    public void Save(String saveFile, Game game) {
    	File save;
        try {
            File savesFolder = new File("saves");
            savesFolder.mkdirs();
            save = new File("saves/save.txt");

            if (save.createNewFile()) {
                System.out.println("File created: " + save.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        for(List < Integer > key : game.getTiles().keySet()) {
        	game.getTiles().get(key);
        }
        
    }

    public Game Load(String saveFile) {
        return null;

    }

}