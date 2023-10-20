package game;

public class Window {
    private int screen_width;
    private int screen_height;
    public Window(int screen_width, int screen_height) {
        this.screen_height = screen_height;
        this.screen_width = screen_width;
    }
    public int getScreen_width() {
        return screen_width;
    }
    public void setScreen_width(int screen_width) {
        this.screen_width = screen_width;
    }
    public int getScreen_height() {
        return screen_height;
    }
    public void setScreen_height(int screen_height) {
        this.screen_height = screen_height;
    }
}