package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
/**
 * This class represents a portal in the game world.
 * When the player character collides with the portal, it typically triggers level completion or transition.
 */
public class Portal extends StaticBody {
    private static final Shape PortalShape=new CircleShape(2);
    private static final BodyImage PortalImage=new BodyImage("data/portal.gif",9f);
    /**
     * Constructs a portal object in the specified world.
     *
     * @param world The world in which the portal exists.
     */
    public Portal(World world) {
        super(world, PortalShape);
        AttachedImage ci = this.addImage(PortalImage);
        ci.setOffset(new Vec2(0, 1));
    }
}
