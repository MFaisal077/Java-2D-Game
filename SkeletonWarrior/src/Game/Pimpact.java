package Game;
import city.cs.engine.*;

/**
 * This class represents a collision listener that destroys certain bodies upon collision.
 */

public class Pimpact implements CollisionListener {

    @Override



    public void collide(CollisionEvent ce2) {

        ce2.getReportingBody().destroy();

        if (ce2.getOtherBody() instanceof ZombieWalking) {
            ce2.getOtherBody().destroy();





        }
    if (ce2.getOtherBody() instanceof ZombieWalking2){
        ce2.getOtherBody().destroy();
    }
    if(ce2.getOtherBody() instanceof  SkeletonSlayer){
        ce2.getOtherBody().destroy();

    }

        if(ce2.getOtherBody() instanceof ZombieWalking3){
            ce2.getOtherBody().destroy();
        }
    }
    }


