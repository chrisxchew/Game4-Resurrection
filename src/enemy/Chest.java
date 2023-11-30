package enemy;

import java.util.ArrayList;

import acm.graphics.GImage;
import game.Enemy;
import game.Game;
import game.Item;
import game.Player;
import items.*;

public class Chest extends Enemy{

    public Chest(int x, int y, Game game) {
        super(x, y, game);
        
        GImage bodyImage = new GImage("media/Items/chest.png");
        bodyImage.scale(4);
        this.bodyCompound.add(bodyImage, x, y);
        this.health = 50;
    }
    @Override
	protected void addObjectsToCompound(int x, int y) {
        GImage bodyImage = new GImage("media/Items/chest.png");
        bodyImage.scale(4);
        this.bodyCompound.add(bodyImage, x, y);
        this.health = 100;
	}
    @Override
    public void tickai(double targetx, double targety, ArrayList < Enemy > enemies, int deltaTick){
        if (!this.unloaded) {
            if (damageImageOn) {
                damageImageTimer--;
                if (damageImageTimer <= 0) {
                    bodyCompound.remove(damageImage);
                    damageImageOn = false;
                }
            }
            if(statusEffect != null){
                statusEffect.tick();
            }
            if (this.isDead) {
                if (checkCollision(targetx, targety) && !game.getPlayer().getInventory().isFull()) {
                    for (Item i: drops) {
                        if (i != null) {

                            game.getPlayer().getInventory().add(i);
                            

                        }
                    }
                    this.game.getPlayer().getInventory().updateGraphicalInterface();
                    this.game.getHotbar().updateHotbar();
                    this.bodyCompound.removeAll();
                    this.unloaded = true;
                    //enemies.remove(this);
                }
            
            } else if (this.health <= 0 || enemies.size() ==1) {
                deathEvent(enemies);

            } 

        }
    }
    @Override
    public void calculateEnemyPlayerCollision(Player player) {
        //do nothing, chests can't move
        
    }
    @Override
    protected Item calculateDrop() {
        //lets do 5% chance of dropping Sword3
        //and 10% chance of dropping sword 2
        //and 45 percent chance of dropping arrow
        //and then drops cherries 100% of the time
        if(percentChance(10)){
            return new Sword3();
        }else if(percentChance(20)){
            return new Sword2();
        }else if(percentChance(50)){
            return new Arrow();
        }else{
            return new Cherries();
        }
    }
    @Override
    public void knockback(double mulitplier) {
        //do nothing, chests can't be knocked back
    }
    
}
