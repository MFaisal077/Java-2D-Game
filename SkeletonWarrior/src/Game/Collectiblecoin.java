package Game;

import city.cs.engine.*;

/**
 * A class representing a collectible coin in the game.
 * <p>
 * This class inherits from StaticBody and represents a coin object that the player can collect.
 */
public class Collectiblecoin extends StaticBody {
    private static final Shape collectiblecoinshape = new CircleShape(0.5f);
    private static final BodyImage coinimage = new BodyImage("data/coin.gif", 2);
    /**
     * Constructs a collectible coin object.
     *
     * @param world The world in which the coin exists.
     */
    public Collectiblecoin(World world) {
        super(world, collectiblecoinshape);
        addImage(coinimage);

    }

}