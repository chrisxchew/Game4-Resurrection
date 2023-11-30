package enemy;

import game.Enemy;
import game.Game;
import game.Item;

public class Boss extends Enemy{

    public Boss(int x, int y, Game game) {
        super(x, y, game);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected Item calculateDrop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateDrop'");
    }
    
}
