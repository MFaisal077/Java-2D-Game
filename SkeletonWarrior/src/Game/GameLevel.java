package Game;

import city.cs.engine.StaticBody;
import city.cs.engine.World;
import org.jbox2d.common.Vec2;

import javax.swing.*;
/**
 * This class represents a game level.
 */
public abstract class GameLevel extends World {
    SkeletonSlayer skeletonSlayer;
    private Game game;
    private GameView view;
    private JProgressBar HealthBar;
    private Skeleton skeleton;
    private int coinCount;

    Spikes spikes;

    ZombieWalking zombieWalking;
    ZombieWalking2 zombieWalking2;

    public ZombieWalking getzombieWalking() {
        return zombieWalking;
    }

    public ZombieWalking2 getZombieWalking2() {
        return zombieWalking2;
    }

    public SkeletonSlayer getSkeletonSlayer() {
        return skeletonSlayer;
    }




    public Spikes getSpikes() {
        return spikes;
    }

    /**
     * Constructs a GameLevel.
     *
     * @param game The game instance.
     */
    public GameLevel(Game game) {

        this.game = game;

        skeleton = new Skeleton(this);
        skeleton.setPosition(new Vec2(-55, -55f));
        // Multiple static bodies of platforms

        CoinPickup coinPickup2 = new CoinPickup(skeleton, game.currentLevel);
        CoinPickup coinPickup = new CoinPickup(skeleton, game.currentLevel);
        // Collision listener for coin to disappear when the skeleton collides
        skeleton.addCollisionListener(coinPickup);
        skeleton.addCollisionListener(coinPickup2);
        // ZombieDeath ZD=new ZombieDeath(this);
        // zombieWalking.addDestructionListener(ZD);
        // skeletonSlayer.addDestructionListener(ZD);

        // GiveFocus giveFocus = new GiveFocus();
        // addMouseListener(giveFocus);

        // Positions of Coins


        skeleton.addCollisionListener(new PortalEncounter(this, game));






    }
    /**
     * Retrieves the player character (skeleton).
     *
     * @return The player character.
     */
    public Skeleton getSkeleton() {
        return skeleton;
    }
    /**
     * Checks if the level is complete.
     *
     * @return True if the level is complete, otherwise false.
     */
    public abstract boolean isComplete();
}
