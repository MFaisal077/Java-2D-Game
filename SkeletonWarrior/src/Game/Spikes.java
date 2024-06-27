package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * Represents a spikes hazard in the game.
 * <p>
 * This class inherits from the StaticBody class.
 */
public class Spikes extends StaticBody {
    private static final Shape spikeshape=new BoxShape(2,2);
    private static final BodyImage spikeImage=new BodyImage("data/Fire Trap Preview - No Background.gif",6f);
    /**
     * Constructs a spikes hazard object with the specified world.
     *
     * @param world The world in which the spikes hazard exists.
     */
    public Spikes(World world){
        super(world, spikeshape);
        AttachedImage ci=this.addImage(spikeImage);
        ci.setOffset(new Vec2(0,1));
    }

}

