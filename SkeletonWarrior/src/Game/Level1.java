package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/**
 * This is the subclass of the superclass GameLevel
 * This is my Level1 of the game.
 */
public class Level1 extends GameLevel {

    private Skeleton skeleton;
    private Portal portal;
    private ZombieWalking zombieWalking;



    private ZombieWalking2 zombieWalking2;

    private SkeletonSlayer skeletonSlayer;
    private CoinPickup coinPickup;
    /**
     * Constructs a Level1 object.
     *
     * @param game The game to which this level belongs.
     */
    public Level1(Game game) {
        super(game);

        // position Spikes


        for (int i = 0; i < 20; i++) {
            Shape shape2 = new BoxShape(50, 1.8f);
            StaticBody ground2 = new StaticBody(this, shape2);
            ground2.setPosition(new Vec2(-80 + i * 20, -60.5f));
            BodyImage groundImage2 = new BodyImage("data/level1 platform.png", 10f);
            AttachedImage gi2 = ground2.addImage(groundImage2);
            ground2.setName("ground");


        }


        Shape shape3 = new BoxShape(10, 1.8f);
        StaticBody ground3 = new StaticBody(this, shape3);
        ground3.setPosition(new Vec2(-30, -56f));

        zombieWalking = new ZombieWalking(this);
        zombieWalking.setPosition(new Vec2(-30, -54f));

        zombieWalking2 = new ZombieWalking2(this);
        zombieWalking2.setPosition(new Vec2(200, -50f));

        skeletonSlayer = new SkeletonSlayer(this);
        skeletonSlayer.setPosition(new Vec2(290, -52f));

       portal = new Portal(this);
       portal.setPosition(new Vec2(250, -55f));

        for (int i = 0; i < 8; i++) {
            Collectiblecoin b = new Collectiblecoin(this);
            b.setPosition(new Vec2(-30 + i * 3, -55f));
        }

        for (int t=0;t<6;t++){
            Shape shape2=new BoxShape(4f,0.5f);
            StaticBody ground2 = new StaticBody(this, shape2);
            ground2.setPosition(new Vec2(49+t*20 ,-48.5f));
            BodyImage groundImage2 = new BodyImage("data/Screenshot 2024-04-15 094252.png", 4f);
            AttachedImage gi2 = ground2.addImage(groundImage2);
            ground2.setName("ground");
        }



        }
    /**
     * Checks if the level is complete.
     *
     * @return True if the level is complete, otherwise false.
     */
        public boolean isComplete () {
            return getSkeleton().getCoinCount() > 5;
        }

    }
