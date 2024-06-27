package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class ZombieWalking3 extends Walker implements StepListener {
    private static final BodyImage Zimage = new BodyImage("data/ezgif.com-animated-gif-maker (1).gif", 4f);
    private static final Shape Zshape = new BoxShape(1,2);
    private final int SPEED = 3;
    private float left, right;
    private final int RANGE = 9;
    public ZombieWalking3(World world) {
        super(world, Zshape);
        addImage(Zimage);
        world.addStepListener(this);
        startWalking(SPEED);
    }
    public void setPosition(Vec2 position) {
        super.setPosition(position);
        left = position.x-RANGE;
        right = position.x+RANGE;
    }

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

    @Override
    public void postStep(StepEvent stepEvent) {

    }
}
