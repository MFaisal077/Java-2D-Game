package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * This class represents a lightning trap in the game.
 * It is a subclass of the StaticBody class.
 */
public class LigteningTrap extends StaticBody{
    private static final Shape spikeshape = new BoxShape(2, 4);
    private static final BodyImage spikeImage = new BodyImage("data/Lightning Trap Preview - No Background.gif", 6f);
    /**
     * Constructs a LigteningTrap object.
     *
     * @param world The world in which the lightning trap exists.
     */
    public LigteningTrap(World world) {
        super(world, spikeshape);
        AttachedImage ci = this.addImage(spikeImage);
        ci.setOffset(new Vec2(0, 1));
    }
}
