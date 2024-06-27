package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * This class represents Level 2 of the game.
 * It is a subclass of the GameLevel superclass.
 */
public class Level2 extends GameLevel {
    private SKcontroller sKcontroller;
    private Skeleton skeleton;
    private Portal portal;
    private ZombieWalking2 zombieWalking2;
private SkeletonSlayer skeletonSlayer ;
private ToxicTrap toxicTrap;
private Spikes spikes;
    /**
     * Constructs a Level2 object.
     *
     * @param game The game to which this level belongs.
     */
    public Level2(Game game) {
        super(game);
        Skeleton skeleton = getSkeleton();
        skeleton.setPosition(new Vec2(0, -60f));

        portal = new Portal(this);
        portal.setPosition(new Vec2(580, -13f));

        for (int i = 0; i < 50; i++) {
            Shape shape2 = new BoxShape(50, 1.8f);
            StaticBody ground2 = new StaticBody(this, shape2);
            ground2.setPosition(new Vec2(-60 + i * 20, -60.5f));
            BodyImage groundImage2 = new BodyImage("data/log of block.png", 6f);
            AttachedImage gi2 = ground2.addImage(groundImage2);
            ground2.setName("ground");

            Shape shape3 = new BoxShape(50, 1.8f);
            StaticBody ground3 = new StaticBody(this, shape3);
            ground3.setPosition(new Vec2(-60 + i * 20, -65f));
            BodyImage groundImage3 = new BodyImage("data/log of block.png", 6f);
            AttachedImage gi3 = ground3.addImage(groundImage3);
            ground3.setName("ground");
        }


        for (int i = 0; i < 5; i++) {
            Shape shape5 = new BoxShape(10, 0.5f);
            StaticBody stairs2 = new StaticBody(this, shape5);
            stairs2.setPosition(new Vec2(120 + i * 20, -55 + i * 8));
            BodyImage stairsImage2 = new BodyImage("data/level2 platform .png", 2*2f);
            AttachedImage im5 = stairs2.addImage(stairsImage2);
            stairs2.setName("stairs");
        }

        zombieWalking2 = new ZombieWalking2(this);
        zombieWalking2.setPosition(new Vec2(50, -46f));

        zombieWalking2=new ZombieWalking2(this);
        zombieWalking2.setPosition(new Vec2(500, -23f));

 for (int i = 0; i < 35; i++) {
     Shape shape5 = new BoxShape(10, 0.5f);
     StaticBody stairs2 = new StaticBody(this, shape5);
     stairs2.setPosition(new Vec2(230+i*10, -23f));
     BodyImage stairsImage2 = new BodyImage("data/level2 platform .png", 2*2f);
     AttachedImage im5 = stairs2.addImage(stairsImage2);
     stairs2.setName("stairs");
 }
skeletonSlayer=new SkeletonSlayer(this);
 skeletonSlayer.setPosition(new Vec2(320,-15f));

 for (int i=0; i<3;i++) {
     toxicTrap = new ToxicTrap(this);
     toxicTrap.setPosition(new Vec2(340 + i * 30, -19f));

 }

        for (int i = 0; i < 15; i++) {
            Collectiblecoin b = new Collectiblecoin(this);
            b.setPosition(new Vec2(-7 + i * 3, -55f));
        }
    }
    /**
     * Checks if the level is complete.
     *
     * @return True if the level is complete, otherwise false.
     */
    @Override
    public boolean isComplete() {
        return getSkeleton().getCoinCount() > 5;
    }
}
