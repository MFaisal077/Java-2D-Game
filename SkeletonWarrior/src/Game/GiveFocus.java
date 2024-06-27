package Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * This class represents a mouse adapter that gives focus to the game view when the mouse enters it.
 */
public class GiveFocus extends MouseAdapter {

    private GameView view;
    /**
     * Constructs a GiveFocus object.
     *
     * @param v The game view to give focus to.
     */
   public GiveFocus(GameView v) {
       this.view = v;
   }
    /**
     * Invoked when the mouse enters a component.
     *
     * @param e The mouse event.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        e.getComponent().requestFocus();
    }

}
