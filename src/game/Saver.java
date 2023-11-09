package game;

import java.io.File;
import java.io.IOException;

public class Saver {
    static int windowHeight = 500;
    static int windowWidth = 1000;
    public void Save(String saveFile) {
        try {
            File savesFolder = new File("saves");
            savesFolder.mkdirs();
            File myObj = new File("saves/save.txt");

            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Game Load(String saveFile) {
        Game output = new Game(windowWidth, windowHeight);
        output.setTiles(null);
        return null;

    }

}