package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.*;

public abstract class Enemy implements ActionListener {
    protected ArrayList < Item > drops = new ArrayList < Item > ();
    protected GCompound bodyCompound;
    private double x;
    private double y;
    protected boolean isDead = false;
    private double speed = 1;
    private int health = 14;
    protected Game game;
    Timer timer;
    double velocityMultiplier = -2;
    protected boolean unloaded = false;
    protected Item drop;
    public Enemy(int x, int y, Game game) {
        bodyCompound = new GCompound();
        this.x = x;
        this.y = y;
        this.game = game;
        addObjectsToCompound(x, y);
        this.timer = new Timer(10, this);
        drop = calculateDrop();
        this.drops.add(drop);
    }

    protected void addObjectsToCompound(int x, int y) {
        GImage bodyImage = new GImage("media/Characters/DoritoSV/DoritoSV_FaceFront.png");
        bodyImage.scale(4);
        this.bodyCompound.add(bodyImage, x, y);
    }
    public GObject getBody() {
        return bodyCompound;
    }
    public void setBody(GCompound body) {
        this.bodyCompound = body;
    }
    public void moveX(double val) {
        this.x += val;
        bodyCompound.move(val, 0);
    }

    public void moveY(double val) {
        this.y += val;
        bodyCompound.move(0, val);
    }
    public void knockback(double mulitplier) {

        velocityMultiplier = velocityMultiplier * mulitplier;
        if (timer != null) {
            this.timer.stop();
        }

        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        velocityMultiplier -= 0.5;
        if (velocityMultiplier <= -2) {
            this.timer.stop();
            velocityMultiplier = -2;
        }
    }
    protected boolean percentChance(int percent) {
        int chance = (int)(Math.random() * 100);
        if (chance < percent) {
            return true;
        }
        return false;
    }

    protected void deathEvent() {
        isDead = true;
        for (int i = 0; i < bodyCompound.getElementCount(); i++) {
            this.bodyCompound.getElement(i).setVisible(false);
            this.isDead = true;
            if (drop != null) {
                drop.getItemBody().setLocation(this.bodyCompound.getElement(0).getX(), this.bodyCompound.getElement(0).getY());
                this.bodyCompound.removeAll();
                this.bodyCompound.add(drop.getItemBody());
            } else {
                this.bodyCompound.removeAll();
                this.unloaded = true;
            }


        }
    }

    protected abstract Item calculateDrop();

    public void tickai(double targetx, double targety, ArrayList < Enemy > enemies) {
        if (!this.unloaded) {
            if (this.isDead) {
                if (Math.abs(this.x - targetx) < 100 && Math.abs(this.y - targety) < 100) {
                    if ((this.x - targetx) != 0) {
                        moveX(((this.x - targetx) / (Math.abs(this.x - targetx))) * -speed);
                    }
                    if ((this.y - targety) != 0) {
                        moveY(((this.y - targety) / (Math.abs(this.y - targety))) * -speed);
                    }
                }
                if (checkCollision(targetx, targety)) {
                    for (Item i: drops) {
                        if (i != null) {
                            game.getPlayer().getInventory().add(i);
                        }
                    }
                    this.game.getPlayer().getInventory().updateGraphicalInterface();
                    this.bodyCompound.removeAll();
                    this.unloaded = true;
                }
            } else if (this.health <= 0) {
                deathEvent();

            } else {
                if ((this.x - targetx) != 0) {
                    moveX(((this.x - targetx) / (Math.abs(this.x - targetx))) * velocityMultiplier);
                }
                if ((this.y - targety) != 0) {
                    moveY(((this.y - targety) / (Math.abs(this.y - targety))) * velocityMultiplier);
                }
            }

        }
    }

    public boolean checkCollision(double targetx, double targety) {
        //if 25 pixels away from target, return true else return false
        if (Math.abs(this.x - targetx) < 25 && Math.abs(this.y - targety) < 25) {
            return true;
        }
        return false;
    }

    public boolean isUnloaded() {
        return unloaded;
    }
    public void setUnloaded(boolean unloaded) {
        this.unloaded = unloaded;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public boolean isDead() {
        return isDead;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getSpeed() {
        return speed;
    }
}