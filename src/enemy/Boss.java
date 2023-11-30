package enemy;


import java.awt.Color;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GRect;
import game.Enemy;
import game.Game;
import game.Item;
import items.EnemyProjectileFire;
import items.SecretItem;
public class Boss extends Enemy {
    /*
     * ok lets see
     * shield starts as red
     * then after 1 hit it becomes orange
     * then after 2 hits it becomes yellow
     * then after 3 hits it breaks
     * then the boss will be stunned for a few seconds
     * then the shield will regenerate
     * the player cannot damage the boss while the shield is up
     * the player can damage the boss while the shield is down
     */
    private GOval shield;
    private boolean shielded = true;
    private int shieldHealth = 3;
    private GRect healthBar;
    private GLabel XLabel = new GLabel("x");
    //red
    Color c = new Color(1f, 0f, 0f, .1f);
    //orange
    Color c2 = new Color(1f, 0.5f, 0f, .1f);
    //yellow
    Color c3 = new Color(1f, 1f, 0f, .1f);
    public Boss(int x, int y, Game game) {

        super(x, y, game);
        healthBar = new GRect(100, 10);
        shield = new GOval(200, 200);
        this.health = 1000;
        this.isRanged = true;
        this.healthBar.setFilled(true);
        this.healthBar.setFillColor(java.awt.Color.RED);
        this.shield.setFilled(true);
        this.shield.setFillColor(c);
        this.shield.setColor(c);
        this.bodyCompound.add(this.healthBar, this.getX() - 100, this.getY() - 150);
        //put the shield at the center of the boss
        //make the shield transparent
        shield.scale(2);
        this.bodyCompound.add(this.shield, this.getX() - 100, this.getY() - 250);
        XLabel.scale(5);
        this.bodyCompound.add(XLabel, this.getX() - 20, this.getY() - 50);
        XLabel.setVisible(false);
    }
    @Override
    protected void addObjectsToCompound(int x, int y) {
        GImage body = new GImage("media/Characters/SuperMegaUltraChicken/MegaUltraChicken.png");
        body.setSize(150, 150);
        this.bodyCompound.add(body, x - 50, y - 100);

    }
    public void updateHealthBar() {
        //updates the health bar
        this.healthBar.setSize(this.getHealth() / 10, 10);
        this.healthBar.setLocation(this.getX() - 100, this.getY() - 150);
        this.game.add(this.healthBar);
    }
    public void updateShield() {
        //updates the shield
        if (this.shieldHealth == 3) {
            XLabel.setVisible(false);
            this.shield.setVisible(true);
            this.shield.setFillColor(c);
            this.shield.setColor(c);
        }
        if (this.shieldHealth == 2) {
            this.shield.setVisible(true);
            this.shield.setFillColor(c2);
            this.shield.setColor(c2);
        }
        if (this.shieldHealth == 1) {
            this.shield.setVisible(true);
            this.shield.setFillColor(c3);
            this.shield.setColor(c3);
        }
        if (this.shieldHealth == 0) {
            this.shield.setVisible(false);
            XLabel.setVisible(true);
        }
    }
    int shieldCooldown = 500;
    boolean flashing = false;
    //make the boss flash slowly and then speed up as he gets clposer to being off cooldown
    @Override
    public void tickai(double targetx, double targety, ArrayList < Enemy > enemies, int deltaTick) {
        super.tickai(targetx, targety, enemies, deltaTick);
        updateHealthBar();
        updateShield();
        if (shieldHealth == 0 && !isDead) {
            shielded = false;
            flash(shieldCooldown);

        }
        if (!shielded) {
            shieldCooldown--;
        }
        if (shieldCooldown <= 0 || isDead) {
            shielded = true;
            shieldCooldown = 500;
            shieldHealth = 3;
            flashing = false;
            if(bodyCompound.getElementCount() > 0){
            this.bodyCompound.getElement(0).setVisible(true);
            }

        }
    }
    public void flash(int cooldown) {
        if (cooldown < 250) {
            if (cooldown % 5 == 0) {
                if (flashing) {
                    this.bodyCompound.getElement(0).setVisible(false);
                    flashing = false;
                } else {
                    this.bodyCompound.getElement(0).setVisible(true);
                    flashing = true;
                }
            }
        }
        if (cooldown < 75) {
            if (cooldown % 2 == 0) {
                if (flashing) {
                    this.bodyCompound.getElement(0).setVisible(false);
                    flashing = false;
                } else {
                    this.bodyCompound.getElement(0).setVisible(true);
                    flashing = true;
                }
            }
        } else {
            if (cooldown % 10 == 0) {
                if (flashing) {
                    this.bodyCompound.getElement(0).setVisible(false);
                    flashing = false;
                } else {
                    this.bodyCompound.getElement(0).setVisible(true);
                    flashing = true;
                }
            }
        }

    }
    @Override
    public void shootProjectile(double targetx, double targety) {
        //shoots a projectile at the player
        double x = this.getX();
        double y = this.getY();
        double dx = targetx - x;
        double dy = targety - y;
        double angle = Math.atan2(dy, dx);

        EnemyProjectileFire p = new EnemyProjectileFire(x, y, angle, this.game);
        this.game.add(p.getCompound());
        this.game.getEnemyProjectiles().add(p);
    }
    @Override
    public void attackPlayer(double targetx, double targety, int deltaTick) {

        if (isShielded()) {
            moveToward(this.getX(), targety);
            if (deltaTick % 51 == 0) {
                this.shootProjectile(targetx, targety);
            }
            if (deltaTick % 49 == 0) {
                this.shootProjectile(targetx, targety + 100);
            }
            if (deltaTick % 47 == 0) {
                this.shootProjectile(targetx, targety - 100);
            }
            if (deltaTick % 20 == 0) {
                int chance = (int)(Math.random() * 100);
                if (chance == 1) {
                    this.summonEnemy();
                }
            }
            if (deltaTick % 10 == 0) {
                int chance = (int)(Math.random() * 100);
                if (chance == 10) {
                    int y = (int)(Math.random() * 500);
                    BossSummon b = new BossSummon((int) this.getX(), y, this.game);
                    this.game.getCastle().getCastleTile().getEnemies().add(b);
                    this.game.add(b.getBody());
                }
            }
        }

    }
    public void summonEnemy() {
        //summons 3 BossSummon enemies at random Ys and at the same X as the boss
        int y = (int)(Math.random() * 500);
        int y2 = (int)(Math.random() * 500);
        int y3 = (int)(Math.random() * 500);
        BossSummon b = new BossSummon((int) this.getX(), y, this.game);
        this.game.getCastle().getCastleTile().getEnemies().add(b);
        BossSummon b2 = new BossSummon((int) this.getX(), y2, this.game);
        this.game.getCastle().getCastleTile().getEnemies().add(b2);
        BossSummon b3 = new BossSummon((int) this.getX(), y3, this.game);
        this.game.getCastle().getCastleTile().getEnemies().add(b3);
        this.game.add(b.getBody());
        this.game.add(b2.getBody());
        this.game.add(b3.getBody());
        this.bodyCompound.sendForward();
    }
    @Override
    protected Item calculateDrop() {
        return new SecretItem();
    }
    @Override
    public void setHealth(int health) {
        if (!isShielded()) {
            super.setHealth(health);
            updateHealthBar();
        }

    }
    @Override
    public void knockback(double multiplier) {
        //do nothing
    }
    public void setShieldHealth(int shieldHealth) {
        this.shieldHealth = shieldHealth;
    }
    public boolean isShielded() {
        return shielded;
    }
    public int getShieldHealth() {
        return shieldHealth;
    }
    public GOval getShieldOval() {
        return shield;
    }

}