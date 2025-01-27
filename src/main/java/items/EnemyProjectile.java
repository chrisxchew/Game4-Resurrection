package items;

import acm.graphics.GCompound;
import game.Game;
import game.Player;

public abstract class EnemyProjectile {
    protected double x;
    protected double y;
    protected double angle;
    protected Game game;
    protected double speed = 5;
    protected GCompound compound = new GCompound();
    private boolean unloaded = false;
    public void damagePlayer(double x, double y, Game game){
        //if distance from the playercenter to the projectile is less than the radius of the player (25)
        if(!unloaded){
            if(Math.sqrt(Math.pow(x - game.getPlayer().getPlayerCenter().getX(), 2) + Math.pow(y - game.getPlayer().getPlayerCenter().getY(), 2)) < 25) {
                if(game.getPlayer().getInvurnerableCooldown() <= 0){
                    Player player = game.getPlayer();
                    player.setHealth(player.getHealth()-1);
                    player.getHealthPoints().updateHealthPointsIcons(player.getHealth());
                    player.setInvurnerableCooldown(100);
                    game.remove(compound);
                    unloaded = true;
                }

            }
        }

    }
    public void tick() {
        x = this.x + speed * Math.cos(angle);
        y = this.y + speed * Math.sin(angle);
        compound.setLocation(x, y);
        if(x > 1500 || x < 0 || y > 800 || y < 0) {
            game.remove(compound);
        }
        damagePlayer(x, y, game);
        
    }
}
