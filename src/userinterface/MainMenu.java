package userinterface;

import java.awt.event.MouseEvent;

public class MainMenu {
    public boolean buttonPressed(int x, int y, int width, int height, MouseEvent e) {
        if(e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height) {
            return true;
        } else {
            return false;
        }
    }
}
