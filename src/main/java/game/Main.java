package game;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Timer;

import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import items.EnemyProjectile;
import items.Melee;
import items.Projectile;
import userinterface.GameOver;
import userinterface.Hotbar;
import userinterface.Inventory;
import userinterface.MainMenu;
import userinterface.PauseMenu;
import userinterface.ToolTip;

public class Main extends GraphicsProgram{
    String save = "";
	Timer runTimer = new Timer(15, this);
    static int windowHeight = 500;
    static int windowWidth = 1000;
    double mouseX=0;
    double mouseY=0;
    PauseMenu pause = new PauseMenu(this);
    boolean mainMenuOn = true;
    private boolean inventoryDisplayed = false;
    private boolean canChangeInventoryDisplayed = true;
    private Item floatingItem;
    private MainMenu mainMenu = new MainMenu(this);
    private boolean isGameOver = false;
    Window window = new Window(windowWidth, windowHeight);
    Saver saver = new Saver();
    Game game;
    private ArrayList < String > key_manager = new ArrayList < String > ();
    public void init() {
        setSize(windowWidth, windowHeight);
        requestFocus();
    }
    public void loadMainMenu(){

        for (GObject object: mainMenu.getObjects()) {
            add(object);
        }

    }
    public void removeMainMenu(){
        for (GObject object: mainMenu.getObjects()) {
            remove(object);
        }
    }
    //Hi...
    @Override
    public void run() {
        addMouseListeners();
        loadMainMenu();
    }
    GameOver gameOver = new GameOver(this);
    public void gameOver(){

        isGameOver = true;
        removeAll();
        for(GObject object: gameOver.getObjects()){
            System.out.println(object);
            add(object);
        }
        runTimer.stop();
        System.out.println("Deleting world files");
        Saver saver = new Saver();
        if(saver.checkIfSaveExists(save)){
            saver.removeAllInSaveDirectory(save);
        }
    }
    public void startGame(){
        removeMainMenu();
        game = new Game(windowWidth, windowHeight, this, false);
        mainMenuOn = false;
        removeAll();
        addKeyListeners();
        drawTiles();
        add(game.getPlayer().getPlayerGCompound());
        addEnemySprites();
        drawUI();
        runTimer.start();
    }
    public void loadGame(String saveName){
        mainMenuOn = false;
        removeMainMenu();
        game = saver.load(saveName, this);
        save = saveName;
        removeAll();
        addKeyListeners();
        drawTiles();
        add(game.getPlayer().getPlayerGCompound());
        addEnemySprites();
        drawUI();
        runTimer.start();
    }
    public void addEnemySprites(){
        for (Enemy e: game.getCurrentTile().getEnemies()) {
            add(e.getBody());
        }
    }
    public void drawUI(){
        add(game.getHotbar().getInterface());
        add(game.getPlayer().getHealthPoints().getHealthPointsIcons());
    }
    int ticknumber = 0;
    boolean drawnCastle = false;
    @Override
    public void actionPerformed(ActionEvent e) {

            ticknumber++;
        	if (checkTileCrossing()) {
                removeAll();
                drawTiles();
                add(game.getPlayer().getPlayerGCompound());
                drawUI();
                for (Enemy enemy: game.getCurrentTile().getEnemies()) {
                    add(enemy.getBody());
                }
            }
            if(game.isInCastle() && !drawnCastle){
                removeAll();
                drawTiles();
                add(game.getPlayer().getPlayerGCompound());
                drawUI();
                for (Enemy enemy: game.getCurrentTile().getEnemies()) {
                    add(enemy.getBody());
                }
                drawnCastle = true;
            }else if(!game.isInCastle() && drawnCastle){
                removeAll();
                drawTiles();
                add(game.getPlayer().getPlayerGCompound());
                drawUI();
                for (Enemy enemy: game.getCurrentTile().getEnemies()) {
                    add(enemy.getBody());
                }
                game.getPlayer().setX(250);
                game.getPlayer().setY(250);
                drawnCastle = false;
            }
            for (Enemy enemy: new ArrayList<Enemy> (game.getCurrentTile().getEnemies())) {
            	enemy.tickai(game.getPlayer().getPlayerCenter().getX(), game.getPlayer().getPlayerCenter()
                    .getY(), game.getCurrentTile().getEnemies(), ticknumber);
                enemy.calculateEnemyPlayerCollision(game.getPlayer());
            }
            handleKeyStrokes();
            if(this.floatingItem != null) {
            	this.floatingItem.getItemBody().setLocation(mouseX, mouseY);
            }
            if(ticknumber % 10 == 0){
            this.game.getPlayer().tickAnimation();
            }
            if(this.game.getPlayer().getAttackCooldown() > 0){
                this.game.getPlayer().setAttackCooldown(this.game.getPlayer().getAttackCooldown()-1);
            }
            for(Projectile p : this.game.getProjectiles()){
                p.animate();
                p.tick();
            }
            for(EnemyProjectile p : this.game.getEnemyProjectiles()){
                p.tick();
            }
            this.game.getPlayer().tick();
            this.game.getPlayer().moveX(this.game.getPlayer().getVelX(), game);
            this.game.getPlayer().moveY(this.game.getPlayer().getVelY(), game);
            if(ticknumber%2==0){
                this.game.getPlayer().friction();
            }
            if(this.game.getPlayer().getHealth() <= 0){
                gameOver();
            }
            if(game.getHotbar() != null){
                game.getHotbar().updateHotbar();
            }
                
    }
    public void handleKeyStrokes() {
        if(!inventoryDisplayed){
            if (key_manager.contains("w")) {

                game.getPlayer().tryMoveY(-game.getPlayer().getSpeed());
                this.game.getPlayer().setMovingY(true);
            }
            if (key_manager.contains("s")) {
                game.getPlayer().tryMoveY(game.getPlayer().getSpeed());
                this.game.getPlayer().setMovingY(true);
            }
            if (key_manager.contains("a")) {
                game.getPlayer().tryMoveX(-game.getPlayer().getSpeed());
                this.game.getPlayer().setMovingX(true);
            }
            if (key_manager.contains("d")) {
                game.getPlayer().tryMoveX(game.getPlayer().getSpeed());
                this.game.getPlayer().setMovingX(true);
            }
        }
        if(key_manager.contains("e")) {
        	this.game.getPlayer().getInventory().updateGraphicalInterface();
        	calculateDisplayingInventory();
        }else {
        	canChangeInventoryDisplayed = true;
        }
    }
    public void calculateDisplayingInventory() {
    	if(inventoryDisplayed && canChangeInventoryDisplayed) {
    		remove(this.game.getPlayer().getInventory().getGraphicalInterface());
            remove(game.getPlayer().getInventory().getTrashcan());
            this.game.getHotbar().updateHotbar();
            add(this.game.getHotbar().getInterface());
    		inventoryDisplayed = false;
            if(currentToolTip != null){
                        remove(currentToolTip.getInterface());
            }
    		canChangeInventoryDisplayed = false;
            this.game.getPlayer().setMovementEnabled(true);
    	}else if(canChangeInventoryDisplayed){
            remove(this.game.getHotbar().getInterface());
            this.game.getHotbar().updateHotbar();
            add(this.game.getPlayer().getInventory().getGraphicalInterface());
            add(game.getPlayer().getInventory().getTrashcan());
            game.getPlayer().getInventory().getTrashcan().sendForward();
            inventoryDisplayed = true;
            canChangeInventoryDisplayed = false;
            this.game.getPlayer().setMovementEnabled(false);
    	}
    }
    public void drawTiles() {
        if(game.isInCastle()){
                for (GObject object: game.getCastle().getCastleTile().getObjects()) {
                    add(object);
                }
        }else{
            for (GObject object: game.getCurrentTile().getObjects()) {
                add(object);
            }
        }

    }
    public boolean checkTileCrossing() {
        if(game.isInCastle()){
            return false;
        }
        //remove tile label lines for production
        if (game.getPlayer().getX() > windowWidth - game.getPlayer().getPlayerWidth()) {
            game.moveTiles(1, 0);
            this.inventoryDisplayed = false;
            return true;
        }
        if (game.getPlayer().getX() < 0) {
            game.moveTiles(-1, 0);
            this.inventoryDisplayed = false;
            return true;
        }
        if (game.getPlayer().getY() < 0) {
            game.moveTiles(0, 1);
            this.inventoryDisplayed = false;
            return true;
        }
        if (game.getPlayer().getY() > windowHeight - game.getPlayer().getPlayerHeight()) {
            game.moveTiles(0, -1);
            this.inventoryDisplayed = false;
            return true;
        } else {
            return false;
        }
    }
    public boolean checkInventoryInteraction(MouseEvent e){

        if(e.getButton() == 1){
        Inventory i = this.game.getPlayer().getInventory();
        Hotbar h = this.game.getHotbar();
        i.getTrashcan().sendForward();
        if(inventoryDisplayed && getElementAt(e.getX(), e.getY()) == i.getTrashcan()){
            if(floatingItem != null){
                i.remove(floatingItem);
                remove(floatingItem.getItemBody());
                this.floatingItem = null;
                i.updateGraphicalInterface();
                h.updateHotbar();
                game.getPlayer().updateCurrentItemInHand();
            }
            return true;
        }
        if(inventoryDisplayed && e.getX() < 500 && e.getY() > 500-(50*i.getInventorySize()/10)){
            if(floatingItem != null && i.getClickedItem(e.getX(), e.getY()) == null){
                i.setSpecificItem(i.getClickedIndex(e.getX(), e.getY()), floatingItem);
                i.updateGraphicalInterface();
                remove(floatingItem.getItemBody());
                this.floatingItem = null;
                this.game.getHotbar().updateHotbar();
                game.getPlayer().getInventory().getTrashcan().sendForward();
                    game.getPlayer().updateCurrentItemInHand();
                return true;
            }else
            if(floatingItem != null && i.getClickedItem(e.getX(), e.getY()) != null){
                Item item = i.getClickedItem(e.getX(), e.getY());
                if(item.getClass() == floatingItem.getClass() && item instanceof Melee && floatingItem instanceof Melee && item.combinable && floatingItem.combinable){
                    item.setLabel(String.valueOf(Integer.parseInt(item.label.getLabel()) + Integer.parseInt(floatingItem.label.getLabel())));
                    i.setSpecificItem(i.getClickedIndex(e.getX(), e.getY()), item);
                    showToolTip(e.getX(), e.getY());
                    i.updateGraphicalInterface();
                    game.getHotbar().updateHotbar();
                    remove(floatingItem.getItemBody());
                    this.floatingItem = null;
                   
                    game.getPlayer().getInventory().getTrashcan().sendForward();
                    game.getPlayer().updateCurrentItemInHand();
                    return true;   
                }else{
                    Item temp = i.getClickedItem(e.getX(), e.getY());
                    i.getInventory().set(i.getInventory().indexOf(temp), this.floatingItem);
                    remove(floatingItem.getItemBody());
                    this.floatingItem = temp;
                    add(floatingItem.getItemBody());
                    i.remove(temp);
                    i.updateGraphicalInterface();
                    h.updateHotbar();
                    game.getPlayer().getInventory().getTrashcan().sendForward();
                    game.getPlayer().updateCurrentItemInHand();
                    return true;
                }

            }else{
                    this.floatingItem = i.getClickedItem(e.getX(), e.getY());
                    if(floatingItem != null){
                    i.setSpecificItem(i.getClickedIndex(e.getX(), e.getY()), null);
                    i.updateGraphicalInterface();
                    add(this.floatingItem.getItemBody());
                    h.updateHotbar();
                    game.getPlayer().getInventory().getTrashcan().sendForward();
                    game.getPlayer().updateCurrentItemInHand();
                    return true;
                }

            }
            return true;
        }

        return false;
    }
    return false;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if(isGameOver){
            gameOver.keyPressed(e);
        }
        if(mainMenuOn && e.getButton() == 1){
            mainMenu.keyPressed(e);
        }
        else if(e.getButton() == 1 && isPaused){
            pause.keyPressed(e);
        }else if(!checkInventoryInteraction(e)){
            this.game.getPlayer().attackPressed(this.game);
        }
        
    }
    ToolTip currentToolTip = null;
    public void showToolTip(int eX, int eY){
        //when the user hovers over an item in the inventory or hotbar, show a tooltip
        if(this.game != null){
            if(eX < 500 && eY > 500-(50*game.getPlayer().getInventory().getInventorySize()/10)){
                if(game.getPlayer().getInventory().getClickedItem(eX, eY) != null){
                    Item item = game.getPlayer().getInventory().getClickedItem(eX, eY);
                    if(currentToolTip != null){
                        remove(currentToolTip.getInterface());
                    }
                    currentToolTip = item.toolTip;
                    currentToolTip.getInterface().setLocation(eX, eY-100);
                    add(currentToolTip.getInterface());
                }else{
                    if(currentToolTip != null){
                        remove(currentToolTip.getInterface());
                    }
                }
            }
        }
    }
    @Override
    public void	mouseMoved(MouseEvent e){
        	this.mouseX = e.getX();
        	this.mouseY = e.getY();
            if(inventoryDisplayed){
            showToolTip(e.getX(), e.getY());
            }

    }
    public void addPauseMenuObjects(PauseMenu pauseMenu){
        for(GObject object: pauseMenu.getObjects()){
            add(object);
        }
    }
    public void removePauseMenuObjects(PauseMenu pauseMenu){
        for(GObject object: pauseMenu.getObjects()){
            remove(object);
        }
    }
    boolean isPaused = false;
    public void saveGame(String saveName){
        saver.save(this.game, saveName);
        this.save = saveName;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE && !mainMenuOn) {
            if(!isPaused){
                isPaused = true;
                this.runTimer.stop();
                addPauseMenuObjects(pause);
            }else{
                pause.setSaveScreen(false);
                isPaused = false;
                this.runTimer.start();
                removePauseMenuObjects(pause);
            }
        }
            int keyCode = e.getKeyCode();
            if (keyCode == KeyEvent.VK_W) {
                if (!key_manager.contains("w")) {
                    key_manager.add("w");
                }
            }
            if (keyCode == KeyEvent.VK_S) {
                if (!key_manager.contains("s")) {
                    key_manager.add("s");
                }
            }
            if (keyCode == KeyEvent.VK_A) {
                if (!key_manager.contains("a")) {
                    key_manager.add("a");
                }
            }
            if (keyCode == KeyEvent.VK_D) {
                if (!key_manager.contains("d")) {
                    key_manager.add("d");
                }
            }
            if (keyCode == KeyEvent.VK_E) {
                if (!key_manager.contains("e")) {
                    key_manager.add("e");
            }
            
        
        }
        //if key is between 0-9 change selected hot bar slot in player
        //1 is 0 and 0 is 10
        if(keyCode >= 48 && keyCode <= 57){
            if(keyCode == 48){
                keyCode = 58;
            }   
                this.game.getPlayer().removeItemInHand();
                this.game.getPlayer().setSelectedHotbarSlot(keyCode-49);
                game.getHotbar().updateHotbar();
                game.getPlayer().changeFacingRightAnimation(game.getPlayer().isFacingRight());
        }
        
    }



    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            key_manager.remove("w");
            this.game.getPlayer().setMovingY(false);
        }
        if (keyCode == KeyEvent.VK_S) {
            key_manager.remove("s");
            this.game.getPlayer().setMovingY(false);
        }
        if (keyCode == KeyEvent.VK_A) {
            key_manager.remove("a");
            this.game.getPlayer().setMovingX(false);
        }
        if (keyCode == KeyEvent.VK_D) {
            key_manager.remove("d");
            this.game.getPlayer().setMovingX(false);
        }
        if (keyCode == KeyEvent.VK_E) {
            key_manager.remove("e");
        }
    }
    public static void main(String[] args) {
        
        new Main().start();
    }
}