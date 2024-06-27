package Game;

import city.cs.engine.UserView;

import javax.swing.*;
import java.awt.*;
/**
 * This class represents the view of the game.
 */
public class GameView extends UserView {

    private Image background;
    public static final Font STATUS_FONT = new Font("Monospaced", Font.PLAIN, 60);

    Collectiblecoin coin;
    private Skeleton skeleton;
    private final Image coins;
    private Image c;
    private Game game;
    private GameLevel w;

    /**
     * Constructs a GameView.
     *
     * @param w      The game level.
     * @param g      The game instance.
     * @param width  The width of the view.
     * @param height The height of the view.
     */
    public GameView(GameLevel w, Game g, int width, int height) {

        super(w, width, height);
        game = g;
        this.w = w;
        background = new ImageIcon("data/level1 background.png").getImage();


        Image cI = new ImageIcon("data/coin.gif").getImage();
        coins = cI;

    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);


        g.drawString("A - MOVE LEFT", 80, 90);
        g.drawString("D - MOVE RIGHT", 80, 110);
        g.drawString("UP ARROW-SHOOT", 80, 130);
        g.drawString("SPACEBAR-JUMP", 80, 150);
        g.setFont(STATUS_FONT);


    }


    @Override

    protected void paintBackground(Graphics2D g) {
        super.paintBackground(g);


        g.drawImage(background, 0, 0, 1280, 720, this);


    }
    /**
     * Updates the background image of the view.
     *
     * @param i The new background image.
     */
    public void updateBackground(Image i) {
        background = i;
    }
}