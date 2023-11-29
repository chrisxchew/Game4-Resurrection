package structures;

import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;
import game.Enemy;
import game.Structure;

public class CastleTile {
    private ArrayList < GObject > objects = new ArrayList < GObject > ();
    private ArrayList < Enemy > enemies = new ArrayList < Enemy > ();
    public CastleTile() {
        GImage castleFloor = new GImage("media/Buildings/InsideOfCastle-1.png");
        castleFloor.setLocation(0,0);
        castleFloor.setSize(1000,500);
        objects.add(castleFloor);
    }
}
