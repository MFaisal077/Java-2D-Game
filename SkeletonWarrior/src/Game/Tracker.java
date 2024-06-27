package Game;


import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.geom.Point2D;
/**
 * This class tracks the position of a skeleton and updates the view accordingly.
 */
public class Tracker implements StepListener {
    private GameView view;
    private Skeleton skeleton;
    /**
     * Constructs a Tracker object with the specified view and skeleton.
     *
     * @param view     The game view to be tracked.
     * @param skeleton The skeleton whose position will be tracked.
     */
    public Tracker(GameView view,Skeleton skeleton) {
this.skeleton=skeleton;
        this.view = view;
    }
    /**
     * Empty implementation for the pre-step event.
     *
     * @param e The StepEvent object.
     */
    public void preStep(StepEvent e) {}
    /**
     * Updates the view's camera position to track the skeleton.
     *
     * @param e The StepEvent object.
     */
    public void postStep(StepEvent e) {

        Vec2 position=skeleton.getPosition();
        Vec2 camera=new Vec2(position.x+5f,position.y+10f);

        view.setCentre(camera);
    }
    /**
     * Updates the tracked skeleton.
     *
     * @param newSkeleton The new skeleton to be tracked.
     */
    public void updateSkeleton(Skeleton newSkeleton){
        skeleton=newSkeleton;
    }
}