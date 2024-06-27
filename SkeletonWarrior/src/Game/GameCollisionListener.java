package Game;

import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * This class handles collisions between the player character and enemies/traps.
 * <p>
 * When the player character collides with an enemy or trap, the player character is destroyed.
 */

public class GameCollisionListener implements CollisionListener {
    private GameLevel level;
    private GameView view;
    /**
     * Constructs a GameCollisionListener.
     *
     * @param view  The game view.
     * @param level The current game level.
     */
    public GameCollisionListener(GameView view,GameLevel level) {
        this.view = view;
       this.level=level;

    }

    /**
     * Handles collision events.
     *
     * @param collisionEvent The collision event.
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {
// if Skeleton collides with any of these bodies the skeleton is destroyed
        if (collisionEvent.getOtherBody() instanceof Spikes ||
                collisionEvent.getOtherBody() instanceof ZombieWalking ||
                 collisionEvent.getOtherBody() instanceof ZombieWalking2 || collisionEvent.getOtherBody() instanceof SkeletonSlayer || collisionEvent.getOtherBody() instanceof ZombieWalking3 || collisionEvent.getOtherBody() instanceof ToxicTrap || collisionEvent.getOtherBody() instanceof LigteningTrap) {
            collisionEvent.getReportingBody().destroy();


        }


    }}