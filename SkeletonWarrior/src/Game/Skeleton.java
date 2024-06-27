package Game;

import city.cs.engine.*;
/**
 * Represents a Skeleton  in the game.
 * <p>
 * This class inherits from the Walker class.
 */
public class Skeleton extends Walker {
    private Body body;
private int coinCount;



    private static final Shape skeletonshape = new BoxShape(2, 4);


    private static final BodyImage skeletonimage = new BodyImage("data/idle.gif", 5f);

    private int credits = 0;


    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }

    /**
     * Constructs a Skeleton object and initializes it with the specified World.
     *
     * @param world The World in which the Skeleton exists.
     */
    public Skeleton(World world) {
        super(world, skeletonshape);
        addImage(skeletonimage);

        coinCount=0;

    }

    /**
     * Increases the coin count of the Skeleton by 1.
     */
public void addCoins(){
        coinCount++;
    System.out.println(" " +"Coin Count=" + coinCount);
}
    /**
     * Returns the current coin count of the Skeleton.
     *
     * @return The coin count of the Skeleton.
     */
public int getCoinCount()
{
    return coinCount;
}
}
