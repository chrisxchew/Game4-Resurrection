package items;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GOval;
import game.Game;

public class EnemyProjectileFire extends EnemyProjectile{

    public EnemyProjectileFire(double x, double y, double angle, Game game) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.game = game;
        GImage image = new GImage("media/Items/EnemyProjectile/FireBall.png");
        this.compound.add(image);
    }

    public GCompound getCompound() {
        return compound;
    }

}
