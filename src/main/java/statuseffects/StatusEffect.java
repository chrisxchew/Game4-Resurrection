package statuseffects;

import acm.graphics.GImage;
import game.Enemy;

public abstract class StatusEffect {
    public abstract void tick();
    protected int duration;
    protected int timeLeft;
    protected GImage imageEffect;
    protected Enemy owner;
}
