package game;

import java.util.ArrayList;
import java.util.List;

import acm.graphics.*;
import items.*;
import userinterface.*;

public class Player {

    private int health;
    private int speed;
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
    private int velX = 0;
    private int velY = 0;
    static private String PLAYERIMGPATH = "media/Characters/Blurby/";
    static private int ATTACKCOOLDOWN = 25;
    private int invurnerableCooldown = 0;
    private Game game;
    //0 is up, 1 is down, 2 is left, 3 is right
    int facing = 0;

    GRect collisionRect;
    GRect collisionRect2;
    private GImage playerBody;
    public Player(int spawnx, int spawny, int screenWidth, int screenHeight, Game game, boolean load) {
        playerGCompound = new GCompound();
        this.inventory = new Inventory(40, screenHeight);
        this.game = game;
        playerBody = new GImage(PLAYERIMGPATH + "Blurby_FaceFront.png");
        playerBody.scale(5);


            Item item = new Sword1();
            this.inventory.add(item);
            for (int i = 0; i < 3; i++) {
                Item item2 = new Cherries();
                this.inventory.add(item2);
            }
            this.inventory.updateGraphicalInterface();
            this.healthPoints = new HealthPoints();
        if(this.inventory.getInventory().get(0) != null){
            this.currentlyEquippedItem = inventory.getInventory().get(0);
            playerGCompound.add(playerBody);
            playerGCompound.add(currentlyEquippedItem.getItemBody());
        }
        if(this.currentlyEquippedItem != null){
            this.getCurrentlyEquippedItem().getItemBody().setLocation(-50, -15);
            this.getCurrentlyEquippedItem().getItemBodyRight().setLocation(500, -15);
        }


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
        speed = 5;
        health = 20;
    }
    public boolean checkCollisionDoor(double moveX, GLine door){
            for(i = 1; i < Math.abs(moveX); i++){
                if(moveX < 0){
                    if(door.contains(getPlayerCenter().getX()-i, getPlayerCenter().getY())){
                        return true;
                    }
                }else{
                    if(door.contains(getPlayerCenter().getX()+i, getPlayerCenter().getY())){
                        return true;
                    }
                }
            
        }
        return false;
    }
    public boolean checkCollisionX(double moveX, ArrayList<GLine> colliders){
        ArrayList<GLine> colliders2 = new ArrayList<GLine>();
        for(GLine col : colliders){
            colliders2.add(col);
        }
        if(game.isInCastle()){
            //add lines for the top bottom left and right of screen
            //screen is 1000x500
            colliders2.add(new GLine(0, 0, 1000, 0));
            colliders2.add(new GLine(0, 500, 1000, 500));
            colliders2.add(new GLine(0, 0, 0, 500));
            colliders2.add(new GLine(1000, 0, 1000, 500));
        }
        for(GLine col : colliders2){
            for(i = 1; i < Math.abs(moveX)+5; i++){
                if(moveX < 0){
                    if(col.contains(getPlayerCenter().getX()-i, getPlayerCenter().getY())){
                        return false;
                    }
                }else{
                    if(col.contains(getPlayerCenter().getX()+i, getPlayerCenter().getY())){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public void tick(){
        if(invurnerableCooldown > 0){
            invurnerableCooldown--;
            if(invurnerableCooldown %2==0){
            this.playerBody.setVisible(!this.playerBody.isVisible());
            }
        }
        if(invurnerableCooldown == 0){
            this.playerBody.setVisible(true);
        }
    }
    public boolean checkCollisionY(double moveY, ArrayList<GLine> colliders){
        ArrayList<GLine> colliders2 = new ArrayList<GLine>();
        for(GLine col : colliders){
            colliders2.add(col);
        }
        if(game.isInCastle()){
            colliders2.add(new GLine(0, 0, 1000, 0));
            colliders2.add(new GLine(0, 500, 1000, 500));
            colliders2.add(new GLine(0, 0, 0, 500));
            colliders2.add(new GLine(1000, 0, 1000, 500));
        }
    for(GLine col : colliders2){
        for(i = 1; i < Math.abs(moveY)+5; i++){
            if(moveY < 0){
                if(col.contains(getPlayerCenter().getX(), getPlayerCenter().getY()-i)){
                    return false;
                }
            }else{
                if(col.contains(getPlayerCenter().getX(), getPlayerCenter().getY()+i)){
                    return false;
                }
            }
        }
    }
    return true;
    }   
    public boolean collidingWithEnemy(Enemy e) {
        //if enemy is in the same direction as the player is facing and if the enemy is within 100 pixels of the player then return true

        if(facingRight){
            if(e.getX() > this.x && e.getX() < this.x + 150 && e.getY() > this.y - 100 && e.getY() < this.y +50){
                return true;
            }
        }else{
            if(e.getX()-100 < this.x && e.getX() > this.x - 100 && e.getY() > this.y - 100 && e.getY() < this.y + 50){
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
        if(this.currentlyEquippedItem != null){
            if(this.currentlyEquippedItem instanceof Cherries){
                if(this.health < 20 ){
                    if(this.health <= 16){
                        this.health = this.health + 4;
                    }else{
                        this.health = 20;
                    }
                    this.healthPoints.updateHealthPointsIcons(this.health);
                    this.inventory.remove(this.currentlyEquippedItem);
                    removeItemInHand();
                    this.currentlyEquippedItem=null;
                    this.inventory.updateGraphicalInterface();
                    this.game.getHotbar().updateHotbar();
                }
            }
        }
        if (attackCooldown == 0) {
            if (this.getCurrentlyEquippedItem() instanceof Melee) {
                SwordSlash slash = new SwordSlash(-playerWidth*2, 0, this);
                this.playerGCompound.add(slash.getImage());
                attackCooldown = ATTACKCOOLDOWN;
                for (Enemy e: game.getCurrentTile().getEnemies()) {
                    if (collidingWithEnemy(e)) {
                        e.knockback(((Melee) this.getCurrentlyEquippedItem()).getKnockback() * -1);
                        //knockback enemy away from player
                        int SwordDamage = ((Melee) this.getCurrentlyEquippedItem()).getDamage();
                        e.setHealth(e.getHealth() - SwordDamage);

                    }
                }

                ((Melee) this.getCurrentlyEquippedItem()).attackEvent(null);
            }
            if(this.getCurrentlyEquippedItem() instanceof Ranged){
                ((Ranged) this.getCurrentlyEquippedItem()).attackEvent(
                        game.getCurrentTile().getEnemies(), 
                        isFacingRight(), 
                        this.getPlayerCenter().getX(), 
                        this.getPlayerCenter().getY(), 
                        game
                    );
            }
        }

    }

    public GPoint getPlayerCenter() {
        GPoint output = new GPoint();
        output.setLocation(this.x + (playerWidth / 2), this.y + (playerHeight / 2));
        return output;
    }
    public void changeFacingRightAnimation(boolean isFacingRight) {

        if (isFacingRight == true) {
            if(currentlyEquippedItem != null){
                if (this.getCurrentlyEquippedItem() instanceof Melee || this.getCurrentlyEquippedItem() instanceof Ranged) {
                    this.playerGCompound.remove(this.currentlyEquippedItem.getItemBody());
                    this.playerGCompound.add(this.getCurrentlyEquippedItem().getItemBodyRight());
                    this.getCurrentlyEquippedItem().getItemBodyRight().setLocation(40, -15);
                } else {
                    this.getCurrentlyEquippedItem().getItemBody().setLocation(40, 0);
                }
            }
            facing = 3;
            this.playerGCompound.add(playerBody);
        }
        if (isFacingRight == false) {
                    if(currentlyEquippedItem != null){
            if (this.getCurrentlyEquippedItem() instanceof Melee || this.getCurrentlyEquippedItem() instanceof Ranged) {
                this.playerGCompound.add(this.currentlyEquippedItem.getItemBody());
                this.getCurrentlyEquippedItem().getItemBody().setLocation(-40, -15);
                this.playerGCompound.remove(this.getCurrentlyEquippedItem().getItemBodyRight());
            } else {
                this.getCurrentlyEquippedItem().getItemBody().setLocation(-30, 0);
            }
        }
            facing = 2;
            this.playerGCompound.add(playerBody);
        }
    }

    
    //moves player G Compound to player x and player y
    public void removeItemInHand(){
        if(currentlyEquippedItem != null){
                this.playerGCompound.remove(this.getCurrentlyEquippedItem().getItemBodyRight());
                this.playerGCompound.remove(this.getCurrentlyEquippedItem().getItemBody());
        }
    }
    public void moveX(double val, Game game) {
        if (game.getCurrentTile().getDoor() != null && !game.isInCastle()) {
            if(checkCollisionDoor(val, game.getCurrentTile().getDoor())){
                game.enterCastle(game.getCastle());
            }  
        }
        if(game.isInCastle()){
            if(checkCollisionDoor(val, game.getCastle().getCastleTile().getDoor())){
                game.exitCastle();
            }
        }
    	if(checkCollisionX(val, game.getCurrentTile().getColliders())) {

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

    public void moveY(double val, Game game) {
    	if(checkCollisionY(val, game.getCurrentTile().getColliders())) {

            if (val > 0) {
                if (facingDown == false) {
                    if (!movingX) {
                        this.playerGCompound.remove(playerBody);
                        this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceFront.png");
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
                        this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceBack.png");
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
    public void friction(){
        //reduce velocityx and velocityy by 1
        if(velX > 0){
            velX--;
        }else if(velX < 0){
            velX++;
        }
        if(velY > 0){
            velY--;
        }else if(velY < 0){
            velY++;
        }
    }
    int i = 0;
    public void tickAnimation() {
        i++;
        if (facing == 0) {
            if (!movingY) {
                this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceBack.png");
            } else {
                if (i % 3 == 0) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceBack.png");
                } else if (i % 3 == 1) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Animation/Walk/Blurby_FaceBack_Walk1.png");
                } else if (i % 3 == 2) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Animation/Walk/Blurby_FaceBack_Walk2.png");
                }
            }

        } else if (facing == 1) {
            if (!movingY) {
                this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceFront.png");
            } else {
                if (i % 3 == 0) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceFront.png");
                } else if (i % 3 == 1) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Animation/Walk/Blurby_FaceFront_Walk1.png");
                } else if (i % 3 == 2) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Animation/Walk/Blurby_FaceFront_Walk2.png");
                }
            }
        } else if (facing == 2) {
            if (!movingX) {
                this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceLeft.png");
            } else {
                if (i % 3 == 0) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceLeft.png");
                } else if (i % 3 == 1) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Animation/Walk/Blurby_FaceLeft_Walk1.png");
                } else if (i % 3 == 2) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Animation/Walk/Blurby_FaceLeft_Walk2.png");
                }
            }
        } else if (facing == 3) {
            if (!movingX) {
                this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceRight.png");
            } else {
                if (i % 3 == 0) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Blurby_FaceRight.png");
                } else if (i % 3 == 1) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Animation/Walk/Blurby_FaceRight_Walk1.png");
                } else if (i % 3 == 2) {
                    this.playerBody.setImage(PLAYERIMGPATH + "Animation/Walk/Blurby_FaceRight_Walk2.png");
                }
            }
        }
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        this.healthPoints.updateHealthPointsIcons(health);
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

    public void tryMoveX(int val){
        if(velX > val){
            velX--;
        }if(velX < val){
            velX++;
        }
    }
    public void tryMoveY(int val){
        if(velY > val){
            velY--;
        }if(velY < val){
            velY++;
        }
    }
    //Deals damage to the player, 
    //deducting amount "damage" from the players health
    public void dealDamage(int damage) {
        this.health = this.health - damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
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
    public void setInventory(Inventory i2) {
        this.inventory = i2;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }
    public int getInvurnerableCooldown() {
        return invurnerableCooldown;
    }
    public void setInvurnerableCooldown(int invurnerableCooldown) {
        this.invurnerableCooldown = invurnerableCooldown;
    }
    public GObject getPlayerBody() {
        return playerBody;
    }
    public void updateCurrentItemInHand() {
        if (this.currentlyEquippedItem != null) {
            playerGCompound.remove(this.currentlyEquippedItem.getItemBody());
            playerGCompound.remove(this.currentlyEquippedItem.getItemBodyRight());
        }
        currentlyEquippedItem = inventory.getInventory().get(selectedHotbarSlot);
        if (currentlyEquippedItem != null) {
            playerGCompound.add(currentlyEquippedItem.getItemBody());
        }
        changeFacingRightAnimation(facingRight);
    }

}