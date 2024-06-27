package Game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Represents a Skeleton Slayer enemy in the game.
 * <p>
 * This class inherits from the Walker class and implements the StepListener interface.
 */
public class SkeletonSlayer extends Walker implements StepListener {

private Skeleton skeleton;
    private static final BodyImage BossImage=new BodyImage("data/SkeletonSlayer.gif",10f);
    private static final Shape BossShape=new BoxShape(4 ,5);
    private final int SPEED = 3;
    private float up,down;
    private final int RANGE = 5;
    private static final  float attackRange = 5;
    private static final int attackspeed=10;
    /**
     * Constructs a SkeletonSlayer object and initializes it with the specified World.
     *
     * @param world The World in which the SkeletonSlayer exists.
     */
    public SkeletonSlayer(World world){
        super(world,BossShape);
        addImage(BossImage);
        world.addStepListener(this);
        startWalking(SPEED);

    }
    /**
     * Sets the position of the SkeletonSlayer object.
     *
     * @param position The position vector to set.
     */
    public void setPosition(Vec2 position){
        super.setPosition(position);
        up=position.y+RANGE;
        down=position.y-RANGE;
    }


    /**
     * Called just before each simulation step.
     *
     * @param stepEvent The StepEvent object containing information about the step.
     */


    @Override
    public void preStep(StepEvent stepEvent) {
        this.removeAllImages();
        AttachedImage Boss1Image=this.addImage(BossImage);
if(getPosition().y<down){
    startWalking(SPEED);
    Boss1Image.flipHorizontal();
}
if(getPosition().y<up){
    Boss1Image.flipHorizontal();
    startWalking(-SPEED);
}

    }
    /**
     * Called just after each simulation step.
     *
     * @param stepEvent The StepEvent object containing information about the step.
     */
    @Override
    public void postStep(StepEvent stepEvent) {

    }

}