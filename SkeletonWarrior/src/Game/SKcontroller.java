package Game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
/**
 * This class implements a KeyListener for controlling the Skeleton character in the game.
 */
public class SKcontroller  implements KeyListener {
    private boolean shoot;
private GameLevel world;
private Clip shootSound;
    Skeleton skeleton;
    private BodyImage image2;
    private BodyImage image3;
    /**
     * Constructs a new SKcontroller with the specified Skeleton and GameLevel.
     *
     * @param skeleton The Skeleton character to control.
     * @param world    The GameLevel in which the Skeleton exists.
     */
    public SKcontroller(Skeleton skeleton, GameLevel world) {
        this.skeleton=skeleton;
this.world=world;
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("data/Retro Gun SingleShot 04.wav"));
            shootSound = AudioSystem.getClip();
            shootSound.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    /**
     * Invoked when a key has been typed.
     *
     * @param e The KeyEvent object containing information about the event.
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Invoked when a key has been pressed.
     *
     * @param e The KeyEvent object containing information about the event.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        image2 = new BodyImage("data/run.gif", 5f);
        image3=new BodyImage("data/jump.png", 5f);
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {

            skeleton.startWalking(-10);
            skeleton.removeAllImages();
            AttachedImage im2 = skeleton.addImage(image2);
            im2.flipHorizontal();
        } else if (code == KeyEvent.VK_D) {

            skeleton.startWalking(10);
            skeleton.removeAllImages();
            AttachedImage im3 = skeleton.addImage(image2);

        }
        if (code == KeyEvent.VK_SPACE) {
            skeleton.jump(15);
            skeleton.removeAllImages();
            AttachedImage im3=skeleton.addImage(image3);


        }
        if (code == KeyEvent.VK_UP) {

            if (shoot == false) {
                DynamicBody projectile1 = new DynamicBody(skeleton.getWorld(), new CircleShape(0.2f));
                Pimpact pi1 = new Pimpact();
                projectile1.setGravityScale(0);
                projectile1.addCollisionListener(pi1);
                projectile1.setPosition(new Vec2(skeleton.getPosition().x + 2.3f, skeleton.getPosition().y - 0.5f));
                projectile1.setLinearVelocity(new Vec2(10, 0));
                BodyImage bImage = new BodyImage(
                        "data/bullet.png", 0.2f);
                AttachedImage Bi = projectile1.addImage(bImage);


                if (shoot == false) {
                    // Code for shooting the first projectile
                } else {
                    // Code for shooting the second projectile
                }

            }
            if (shoot == true) {
                DynamicBody projectile2 = new DynamicBody(skeleton.getWorld(), new CircleShape(0.1f));
                Pimpact pi1 = new Pimpact();
                projectile2.setGravityScale(0);
                projectile2.addCollisionListener(pi1);
                projectile2.setPosition(new Vec2(skeleton.getPosition().x + 2.5f, skeleton.getPosition().y + 1.9f));
                projectile2.setLinearVelocity(new Vec2(10, 0));
                BodyImage bImage = new BodyImage("data/bullet.png", 0.1f);


            }
        }

    }

    /**
     * Invoked when a key has been released.
     *
     * @param e The KeyEvent object containing information about the event.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        image3 = new BodyImage("data/idle.gif", 5f);

        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            skeleton.stopWalking();
            skeleton.removeAllImages();
            AttachedImage im3 = skeleton.addImage(image3);
            skeleton.applyForce(new Vec2(10000, 0));
            im3.flipHorizontal();
        } else if (code == KeyEvent.VK_D) {
            skeleton.stopWalking();
            skeleton.removeAllImages();
            AttachedImage im3 = skeleton.addImage(image3);

            skeleton.applyForce(new Vec2(-10000, 0));
        }
        if (code == KeyEvent.VK_SPACE) {
            skeleton.jump(-5);
        }

        if (code == KeyEvent.VK_UP) {

        }
    }
    /**
     * Updates the Skeleton character controlled by this SKcontroller.
     *
     * @param newSkeleton The new Skeleton character to control.
     */
public void updateSkeleton(Skeleton newSkeleton){
        skeleton=newSkeleton;
}
/**
        * Sets the Skeleton character to be controlled by this SKcontroller.
     *
             * @param newSkeleton The new Skeleton character to control.
            */
public void setSkeleton(Skeleton newSkeleton){
        this.skeleton=newSkeleton;
}
    }
