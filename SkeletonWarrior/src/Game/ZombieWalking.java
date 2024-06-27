package Game;

import city.cs.engine.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.jbox2d.common.Vec2;
/**
 * Represents a walking zombie in the game.
 * <p>
 * This class inherits from the Walker class and implements the StepListener interface.
 */
public class ZombieWalking extends Walker implements StepListener {
private static final Vec2 START_POSITION = new Vec2(0,0);
    private static final BodyImage Zimage = new BodyImage("data/ezgif.com-reverse (1).gif", 5f);
    private static final Shape Zshape = new BoxShape(2,3);
    private final int SPEED = 3;
    private float left, right;
    private final int RANGE = 5;
private boolean attacked =false;
    /**
     * Constructs a ZombieWalking object with the specified World.
     *
     * @param world The World in which the zombie exists.
     */
    public ZombieWalking(World world){
        super(world,Zshape);
        addImage(Zimage);
        world.addStepListener(this);
        startWalking(SPEED);
    }
    /**
     * Sets the position of the zombie.
     *
     * @param position The position to set.
     */
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }
    /**
     * Handles pre-step events.
     *
     * @param stepEvent The StepEvent object.
     */
    @Override
    public void preStep(StepEvent stepEvent) {
        this.removeAllImages();
        AttachedImage ZAimage =  this.addImage(Zimage);

        if (getPosition().x > right){
            startWalking(-SPEED);
        }
        if (getPosition().x < left){
            ZAimage.flipHorizontal();
            startWalking(SPEED);
        }

        }






    /**
     * Handles post-step events.
     *
     * @param stepEvent The StepEvent object.
     */
   public void postStep(StepEvent stepEvent) {

    }

}
