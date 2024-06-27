package Game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * A class representing a collision listener for coin pickups.
 * <p>
 * This class is responsible for handling collisions between the player character
 * (skeleton) and collectible coins.
 */
public class CoinPickup implements CollisionListener {
    private Game game;
    private Skeleton skeleton;

private GameLevel level;
    /**
     * Constructs a CoinPickup collision listener.
     *
     * @param sk    The player character (skeleton).
     * @param level The current game level.
     */
    public CoinPickup(Skeleton sk,GameLevel level)
    {
    this.level=level;
        this.skeleton = sk;
    }
    /**
     * Handles collision events between the player character and collectible coins.
     *
     * @param e The collision event.
     */

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Collectiblecoin) {
          skeleton.addCoins();
            e.getOtherBody().destroy();


        }
    }
}
