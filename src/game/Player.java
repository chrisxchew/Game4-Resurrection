package game;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.*;
import items.*;
import userinterface.*;

public class Player {

    private double health;
    private double speed;
    private GCompound playerGCompound;
    private int x;
    private int y;
    private List < Integer > tile = new ArrayList < Integer > (2);
    private int playerHeight;
    private int playerWidth;
    private Item currentlyEquippedItem;
    private Inventory inventory;
    private boolean facingRight = false;
    private HealthPoints healthPoints;
    private boolean movementEnabled = true;
    private boolean facingDown = true;
    private boolean movingX = false;
    private boolean movingY = false;
    private int selectedHotbarSlot = 0;
    //0 is up, 1 is down, 2 is left, 3 is right
    int facing = 0;

    GRect collisionRect;
    GRect collisionRect2;
    private GImage playerBody;
    public Player(int spawnx, int spawny, int screenWidth, int screenHeight) {
        playerGCompound = new GCompound();
        this.inventory = new Inventory(40, screenHeight);
        //remove after testing
        playerBody = new GImage("media/Characters/Blurby/Blurby_FaceFront.png");
        playerBody.scale(5);
        for (int i = 0; i < 10; i++) {
            Item item = new Cherries();
            this.inventory.add(item);
        }
        for (int i = 0; i < 10; i++) {
            Item item = new Sword1();
            this.inventory.add(item);

        }
        this.inventory.updateGraphicalInterface();
        this.healthPoints = new HealthPoints();

        this.currentlyEquippedItem = inventory.getInventory().get(0);
        playerGCompound.add(playerBody);
        playerGCompound.add(currentlyEquippedItem.getItemBody());
        this.getCurrentlyEquippedItem().getItemBody().setLocation(-50, -15);
        this.getCurrentlyEquippedItem().getItemBodyRight().setLocation(500, -15);

        collisionRect = new GRect(50, 50);
        collisionRect2 = new GRect(50, 50);
        collisionRect.move(50, 0);
        collisionRect2.move(-50, 0);

        playerGCompound.setLocation(spawnx, spawny);
        this.x = spawnx;
        this.y = spawny;
        this.tile.add(null);
        this.tile.add(null);
        this.tile.set(0, 0);
        this.tile.set(1, 0);
        playerWidth = 50;
        playerHeight = 50;
    }
    public boolean collidingWithEnemy(Enemy e) {
        if (
            e.getY() > this.y - 100 &&
            e.getY() < this.y + 50
        ) {
            if ((e.getX() > this.x + 50 &&
                    e.getX() < this.x + 100) ||
                (e.getX() > this.x - 50 &&
                    e.getX() < this.x)) {
                return true;
            }
        }
        return false;
    }
    public boolean isFacingRight() {
        return facingRight;
    }
    public void setFacingRight(boolean facingRight) {
        this.facingRight = facingRight;
    }
    private int attackCooldown = 0;
    public void setAttackCooldown(int attackCooldown) {
        this.attackCooldown = attackCooldown;
    }
    public int getAttackCooldown() {
        return attackCooldown;
    }
    public void attackPressed(Game game) {
        if (attackCooldown == 0) {
            if (this.getCurrentlyEquippedItem() instanceof Melee) {
                SwordSlash slash = new SwordSlash(-100, 0, this);
                this.playerGCompound.add(slash.getImage());
                attackCooldown = 25;
                for (Enemy e: game.getCurrentTile().getEnemies()) {
                    if (collidingWithEnemy(e)) {
                        e.knockback(-5);
                        e.setHealth(e.getHealth() - 1);

                    }
                }

                ((Melee) this.getCurrentlyEquippedItem()).attackEvent(null);
            }
        }

    }

    public GPoint getPlayerCenter() {
        GPoint output = new GPoint();
        output.setLocation(this.x + (playerWidth / 2), this.y + (playerHeight / 2));
        return output;
    }
    public void updateMeeleItem(boolean isFacingRight) {

    }
    public void changeFacingRightAnimation(boolean isFacingRight) {
        if (isFacingRight == true) {
            if (this.getCurrentlyEquippedItem() instanceof Melee) {
                this.playerGCompound.remove(this.currentlyEquippedItem.getItemBody());
                this.playerGCompound.add(this.getCurrentlyEquippedItem().getItemBodyRight());
                this.getCurrentlyEquippedItem().getItemBodyRight().setLocation(40, -15);
            } else {
                this.getCurrentlyEquippedItem().getItemBody().setLocation(40, 0);
            }
            facing = 3;
            this.playerGCompound.add(playerBody);
        }
        if (isFacingRight == false) {
            if (this.getCurrentlyEquippedItem() instanceof Melee) {
                this.playerGCompound.add(this.currentlyEquippedItem.getItemBody());
                this.getCurrentlyEquippedItem().getItemBody().setLocation(-40, -15);
                this.playerGCompound.remove(this.getCurrentlyEquippedItem().getItemBodyRight());
            } else {
                this.getCurrentlyEquippedItem().getItemBody().setLocation(-30, 0);
            }
            facing = 2;
            this.playerGCompound.add(playerBody);
        }
    }
    //moves player G Compound to player x and player y
    public void moveX(int val) {
        if (movementEnabled) {
            if (val > 0) {
                changeFacingRightAnimation(facingRight);
                this.facingRight = true;
            }
            if (val < 0) {
                changeFacingRightAnimation(facingRight);
                this.facingRight = false;
            }
            this.x += val;
            playerGCompound.move(val, 0);
        }
    }

    public void moveY(int val) {
        if (movementEnabled) {
            if (val > 0) {
                if (facingDown == false) {
                    if (!movingX) {
                        this.playerGCompound.remove(playerBody);
                        this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceFront.png");
                        facing = 1;
                        this.playerGCompound.add(playerBody);
                    } else {
                        changeFacingRightAnimation(facingRight);
                    }

                }
                this.facingDown = true;
            } else if (val < 0) {
                if (facingDown == true) {
                    if (!movingX) {
                        this.playerGCompound.remove(playerBody);
                        this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceBack.png");
                        facing = 0;
                        this.playerGCompound.add(playerBody);
                    } else {
                        changeFacingRightAnimation(facingRight);
                    }

                }
                this.facingDown = false;

            }
            this.y += val;
            playerGCompound.move(0, val);
        }

    }
    int i = 0;
    public void tickAnimation() {
        i++;
        if (facing == 0) {
            if (!movingY) {
                this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceBack.png");
            } else {
                if (i % 3 == 0) {
                    this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceBack.png");
                } else if (i % 3 == 1) {
                    this.playerBody.setImage("media/Characters/Blurby/Animation/Walk/Blurby_FaceBack_Walk1.png");
                } else if (i % 3 == 2) {
                    this.playerBody.setImage("media/Characters/Blurby/Animation/Walk/Blurby_FaceBack_Walk2.png");
                }
            }

        } else if (facing == 1) {
            if (!movingY) {
                this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceFront.png");
            } else {
                if (i % 3 == 0) {
                    this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceFront.png");
                } else if (i % 3 == 1) {
                    this.playerBody.setImage("media/Characters/Blurby/Animation/Walk/Blurby_FaceFront_Walk1.png");
                } else if (i % 3 == 2) {
                    this.playerBody.setImage("media/Characters/Blurby/Animation/Walk/Blurby_FaceFront_Walk2.png");
                }
            }
        } else if (facing == 2) {
            if (!movingX) {
                this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceLeft.png");
            } else {
                if (i % 3 == 0) {
                    this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceLeft.png");
                } else if (i % 3 == 1) {
                    this.playerBody.setImage("media/Characters/Blurby/Animation/Walk/Blurby_FaceLeft_Walk1.png");
                } else if (i % 3 == 2) {
                    this.playerBody.setImage("media/Characters/Blurby/Animation/Walk/Blurby_FaceLeft_Walk2.png");
                }
            }
        } else if (facing == 3) {
            if (!movingX) {
                this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceRight.png");
            } else {
                if (i % 3 == 0) {
                    this.playerBody.setImage("media/Characters/Blurby/Blurby_FaceRight.png");
                } else if (i % 3 == 1) {
                    this.playerBody.setImage("media/Characters/Blurby/Animation/Walk/Blurby_FaceRight_Walk1.png");
                } else if (i % 3 == 2) {
                    this.playerBody.setImage("media/Characters/Blurby/Animation/Walk/Blurby_FaceRight_Walk2.png");
                }
            }
        }
    }
    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getSelectedHotbarSlot() {
        return selectedHotbarSlot;
    }
    public void setSelectedHotbarSlot(int selectedHotbarSlot) {
        this.selectedHotbarSlot = selectedHotbarSlot;
        if (this.currentlyEquippedItem != null) {
            playerGCompound.remove(this.currentlyEquippedItem.getItemBody());
        }

        if (currentlyEquippedItem instanceof Melee) {
            playerGCompound.remove(this.currentlyEquippedItem.getItemBodyRight());
        }
        this.currentlyEquippedItem = this.inventory.getInventory().get(selectedHotbarSlot);
        if (this.currentlyEquippedItem != null) {
            playerGCompound.add(this.currentlyEquippedItem.getItemBody());
        }

    }
    //Deals damage to the player, 
    //deducting amount "damage" from the players health
    public void dealDamage(double damage) {
        this.health = this.health - damage;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public GCompound getPlayerGCompound() {
        return playerGCompound;
    }

    public void setPlayerGCompound(GCompound playerGCompound) {
        this.playerGCompound = playerGCompound;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        this.playerGCompound.setLocation(x, this.playerGCompound.getLocation().getY());
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        this.playerGCompound.setLocation(this.playerGCompound.getLocation().getX(), y);
    }

    public List < Integer > getTile() {
        return tile;
    }

    public void setTile(List < Integer > tile) {
        this.tile = tile;
    }

    public int getPlayerHeight() {
        return playerHeight;
    }

    public void setPlayerHeight(int playerHeight) {
        this.playerHeight = playerHeight;
    }

    public int getPlayerWidth() {
        return playerWidth;
    }

    public void setPlayerWidth(int playerWidth) {
        this.playerWidth = playerWidth;
    }
    public boolean isMovementEnabled() {
        return movementEnabled;
    }
    public void setMovementEnabled(boolean movementEnabled) {
        this.movementEnabled = movementEnabled;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Item getCurrentlyEquippedItem() {
        return currentlyEquippedItem;
    }

    public void setCurrentlyEquippedItem(Item currentlyEquippedItem) {
        this.currentlyEquippedItem = currentlyEquippedItem;
    }

    public HealthPoints getHealthPoints() {
        return healthPoints;
    }
    public void setMovingX(boolean movingX) {
        this.movingX = movingX;
    }
    public void setMovingY(boolean movingY) {
        this.movingY = movingY;
    }
}