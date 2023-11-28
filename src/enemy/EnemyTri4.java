package enemy;


import acm.graphics.GImage;
import game.*;
import items.Cherries;
public class EnemyTri4 extends Enemy{
	private Item cherry;
	public EnemyTri4(int x, int y, Game game) {
		super(x, y, game);
		cherry = new Cherries();
		this.drops.add(cherry);
		this.setHealth(39);
	}
	
	@Override
	protected void addObjectsToCompound(int x, int y) {
		GImage body = new GImage("media/Characters/DoritoSV/DoritoSV_FaceFront4.png");
		body.setSize(50,50);
		this.bodyCompound.add(body,x-25,y-25);
	}
	
	@Override
	protected void deathEvent() {
		isDead = true;
		for(int i = 0; i < bodyCompound.getElementCount(); i++) {
				this.bodyCompound.getElement(i).setVisible(false);	
				this.isDead = true;
				cherry.getItemBody().setLocation(this.bodyCompound.getElement(0).getX(), this.bodyCompound.getElement(0).getY());
				this.bodyCompound.removeAll();
				this.bodyCompound.add(cherry.getItemBody());
		}
    }
}
