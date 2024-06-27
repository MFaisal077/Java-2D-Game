package Game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
/**
 * This class represents the collision event when the player character collides with a portal.
 * When the collision occurs, it checks if the level is complete. If so, it triggers the transition to the next level.
 */
public class PortalEncounter implements CollisionListener {
    GameLevel level;
    Game g;

    /**
     * Constructs a PortalEncounter instance with the specified level and game.
     * @param level The current game level.
     * @param game The game instance.
     */
    public PortalEncounter(GameLevel level,Game game){
        this.level=level;
        g=game;
    }
    /**
     * Handles the collision event between the player character and the portal.
     * If the level is complete, it triggers the transition to the next level.
     * @param collisionEvent The collision event.
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Portal){
            System.out.println("The skeleton collided with the enemy");
        if(level.isComplete()){
            g.goToNextLevel();
        }
        }
    }
}
