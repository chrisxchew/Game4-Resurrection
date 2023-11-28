package items;

import acm.graphics.GCompound;
import game.Game;

public abstract class EnemyProjectile {
    protected double x;
    protected double y;
    protected double angle;
    protected Game game;
    protected double speed = 10;
    protected GCompound compound = new GCompound();
    public void damagePlayer(double x, double y, Game game){
        if(game.getPlayer().getPlayerGCompound().getElementAt(x, y) != null) {
            game.getPlayer().setHealth(game.getPlayer().getHealth() - 1);
            game.remove(compound);
        }
    }
    public void tick() {
        x = this.x + speed * Math.cos(angle);
        y = this.y + speed * Math.sin(angle);
        compound.setLocation(x, y);
        if(x > 1500 || x < 0 || y > 800 || y < 0) {
            game.remove(compound);
        }

    }
}
