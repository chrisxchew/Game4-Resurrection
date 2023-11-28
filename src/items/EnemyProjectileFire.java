package items;

import acm.graphics.GCompound;
import acm.graphics.GOval;
import game.Game;

public class EnemyProjectileFire extends EnemyProjectile{

    public EnemyProjectileFire(double x, double y, double angle, Game game) {
        this.x = x;
        this.y = y;
        this.angle = angle;
        this.game = game;
        this.compound.add(new GOval(10, 10));
    }

    public GCompound getCompound() {
        return compound;
    }

}
