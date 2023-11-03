package items;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GImage;
import game.Player;

public class SwordSlash implements ActionListener{
	private double x;
	private double y;
	private GImage image;
	private Timer timer;
	private Player Owner;
	int counter = 1;
	public SwordSlash(double x,double y, Player Owner) {
		this.Owner = Owner;
		this.setX(x);
		this.setY(y);
		this.timer = new Timer(10, this);
		this.image = new GImage("",x,y);
		this.image.rotate(45);
		this.timer.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(this.Owner.isFacingRight()) {
			this.image.setLocation(x+100,y);
			this.image.setImage("media/Items/Weapons/SwordSlash/slash"+ counter + "Right.png");
		}else {

			this.image.setImage("media/Items/Weapons/SwordSlash/slash"+ counter + ".png");
		}
		
		counter++;
		if(counter == 8) {
			this.timer.stop();
			this.image.setVisible(false);
		}
	}
	public GImage getImage() {
		return image;
	}
	public void setImage(GImage image) {
		this.image = image;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
}
