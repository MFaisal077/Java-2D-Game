package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * This class represents Level 3 of the game.
 * It is a subclass of the GameLevel superclass.
 */
public class Level3 extends GameLevel {
    private Skeleton skeleton;
    private LigteningTrap ligteningTrap;

    /**
     * Constructs a Level3 object.
     *
     * @param game The game to which this level belongs.
     */
    public Level3(Game game) {
        super(game);
        Skeleton skeleton = getSkeleton();
        skeleton.setPosition(new Vec2(0, -40f));

        for (int i = 0; i < 20; i++) {
            Shape shape2 = new BoxShape(80, 2f);
            StaticBody ground2 = new StaticBody(this, shape2);
            ground2.setPosition(new Vec2(-15 + i * 17.5f, -50f));
            BodyImage groundImage2 = new BodyImage("data/Level3 platforms.png", 6.5f);
            AttachedImage gi2 = ground2.addImage(groundImage2);
            ground2.setName("ground");

            Shape shape3 = new BoxShape(70, 2f);
            StaticBody ground3 = new StaticBody(this, shape3);
            ground3.setPosition(new Vec2(450 + i * 17.5f, 5f));
            BodyImage ground3Image = new BodyImage("data/Level3 platforms.png", 6.5f);
            AttachedImage gi3 = ground3.addImage(ground3Image);
            ground3.setName("ground");


        }

        for (int i = 0; i < 8; i++) {
            Shape shape4 = new BoxShape(10, 0.5f);
            StaticBody ground4 = new StaticBody(this, shape4);
            ground4.setPosition(new Vec2(300 + i * 15f, -50f + i * 10f));
            BodyImage ground4Image = new BodyImage("data/Level3 platforms.png", 4f);
            AttachedImage gi4 = ground4.addImage(ground4Image);
            ground4.setName("ground");
        }


        for (int i = 0; i < 10; i++) {
            Shape shape4 = new BoxShape(4, 2f);
            StaticBody ground4 = new StaticBody(this, shape4);
            ground4.setPosition(new Vec2(130 + i * 15, -47f));
            BodyImage groundImage4 = new BodyImage("data/rock_1.png", 3f);
            AttachedImage gi4 = ground4.addImage(groundImage4);
            ground4.setName("rock");
        }


        for (int i = 0; i < 5; i++) {
            ligteningTrap = new LigteningTrap(this);
            ligteningTrap.setPosition(new Vec2(400 + i * 20, 2.5f));
        }
for (int i=0;i<5;i++){skeletonSlayer=new SkeletonSlayer(this);
    skeletonSlayer.setPosition(new Vec2(440+i*35,1));

}
        for (int i = 0; i < 12; i++) {
            Collectiblecoin b = new Collectiblecoin(this);
            b.setPosition(new Vec2(120 + i * 3, -43f));
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
