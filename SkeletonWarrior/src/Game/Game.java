package Game;

import city.cs.engine.DebugViewer;
import city.cs.engine.SoundClip;
import city.cs.engine.World;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
/**
 * The main class for the game.
 * <p>
 * This class initializes the game world, creates the game view, handles level transitions,
 * and manages game music.
 */
public class Game {
    private SoundClip gameMusic;
    private int coinCount;
    GameLevel currentLevel;
    private SKcontroller controller;
    private SKcontroller sKcontroller;
    private GameView view;
    private Tracker tracker;

    private Skeleton skeleton;
    /**
     * Constructs a new Game instance.
     * <p>
     * This initializes the game world, creates the game view, and starts the game simulation.
     */
    public Game() {
//creates a new world
        currentLevel = new Level1(this);

        // make a view
        view = new GameView(currentLevel, this, 1280, 720);

        controller = new SKcontroller(currentLevel.getSkeleton(),currentLevel);

       view.addMouseListener(new GiveFocus(view));


        final JFrame frame = new JFrame("Basic world");
        frame.add(view);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false);
        JFrame debugView = new DebugViewer(currentLevel, 900, 900);


       /* try {
            gameMusic = new SoundClip("data/Retro Music - ABMU - ChipWave 01.wav");   // Open an audio input stream
            gameMusic.loop();                              // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }*/
        frame.pack();

        frame.setVisible(true);
        view.requestFocus();

        currentLevel.getSkeleton();

        view.addKeyListener(controller);

      currentLevel.addStepListener(new Tracker(view,currentLevel.getSkeleton()));
        GameCollisionListener gc = new GameCollisionListener(view, currentLevel);
        currentLevel.getSkeleton().addCollisionListener(gc);
        // start our game world simulation!

        currentLevel.start();


    }
    /**
     * Transitions the game to the next level.
     * <p>
     * This method stops the current level, loads the next level, updates the view and game state,
     * and starts the new level simulation.
     */
    public void goToNextLevel() {
        System.out.println("yes,lets go to the next level");
        if (currentLevel instanceof Level1) {
            currentLevel.stop();
            Skeleton prevSkeleton = currentLevel.getSkeleton();
            currentLevel = new Level2(this);
            view.setWorld(currentLevel);
            Image i4 = new ImageIcon("data/Level2 Background.png").getImage();
            view.updateBackground(i4);
            Skeleton newSkeleton = currentLevel.getSkeleton();
            GameCollisionListener gc = new GameCollisionListener(view, currentLevel);
            currentLevel.getSkeleton().addCollisionListener(gc);
            controller.updateSkeleton(currentLevel.getSkeleton());
         Tracker t = new Tracker(view, currentLevel.getSkeleton());
       currentLevel.addStepListener(t);
            t.updateSkeleton(currentLevel.getSkeleton());
          // JFrame debug = new DebugViewer(currentLevel, 900, 900);
          /*  try {
                gameMusic = new SoundClip("data/Retro Music Loop - PV8 - NES Style 01.wav");   // Open an audio input stream
                gameMusic.loop();                              // Set it to continous playback (looping)
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                //code in here will deal with any errors
                //that might occur while loading/playing sound
                System.out.println(e);
            }*/
           currentLevel.start();

        } else if (currentLevel instanceof Level2) {
            System.out.println("Welcome to Level3");
            currentLevel.stop();
            Skeleton prevSkeleton = currentLevel.getSkeleton();
            currentLevel = new Level3(this);
            view.setWorld(currentLevel);
            Image i5 = new ImageIcon("data/Level3 Background.png").getImage();
            view.updateBackground(i5);
            Skeleton newSkeleton = currentLevel.getSkeleton();

            GameCollisionListener gc = new GameCollisionListener(view, currentLevel);
            currentLevel.getSkeleton().addCollisionListener(gc);
            controller.updateSkeleton(currentLevel.getSkeleton());
            Tracker t = new Tracker(view, currentLevel.getSkeleton());
            currentLevel.addStepListener(t);

            //JFrame debug = new DebugViewer(currentLevel, 900, 900);
           t.updateSkeleton(currentLevel.getSkeleton());

            currentLevel.start();
        }
        else if (currentLevel instanceof Level3) {
            System.out.println("Welcome to Level4");
            System.exit(0);
        }
    }
    /**
     * The entry point of the game.
     * <p>
     * Creates and initializes a new instance of the Game class.
     *
     * @param args Command-line arguments (unused).
     */

    public static void main(String[] args) {
        //Load the Game
        new Game();


    }
}
