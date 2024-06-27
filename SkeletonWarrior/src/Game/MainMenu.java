package Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * This is the Main Menu Screen where the user can start the game,exit the game and select between different levels.
 */
public class MainMenu extends JPanel {
    private ImageIcon backgroundImage;
    /**
     * Constructs a MainMenu object.
     */
    public MainMenu() {
        // Load background image
        backgroundImage = new ImageIcon("data/f451b7114489045.Y3JvcCwxMzgwLDEwODAsNzEsMA.png");

        // Set JPanel properties
        setPreferredSize(new Dimension(backgroundImage.getIconWidth(), backgroundImage.getIconHeight()));
        setLayout(new BorderLayout());

        // Create buttons
        JButton startButton = new JButton("Start Game");
        JButton exitButton = new JButton("Exit");
       JButton AboutButton = new JButton("About");
        JButton levelButton = new JButton("Select Level");
        // Add buttons to panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        buttonPanel.add(AboutButton);
        buttonPanel.add(levelButton);
        // Add button panel to center of main menu panel
        add(buttonPanel, BorderLayout.SOUTH);

        // Button action listeners
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action to start the game
                new Game();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action to exit the game
                System.exit(0);
            }
        });

        AboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action to toggle sound
                  JOptionPane.showMessageDialog(null,"This game is designed and made by Faisal for Java coursework");
                      }
        });

        levelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add action to select level
                // Display a dialog or menu to choose the level
                String[] options = {"Level 1", "Level 2", "Level 3"};
                int choice = JOptionPane.showOptionDialog(null, "Select a level", "Level Selection", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                // Depending on the selected option, switch to the corresponding level
              /*  switch (choice) {
                    case 0:
                        // Load Level 1
                        new Game();
                        break;
                    case 1:
                        // Load Level 2

                        new Game(Level2);
                        break;
                    case 2:
                        // Load Level 3
                        new Game(Level3);
                        break;
                    default:
                        // Do nothing
                        break;
                }*/
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background image
        g.drawImage(backgroundImage.getImage(), 0, 0, null);
    }

    public static void main(String[] args) {
        // Create main menu frame
        JFrame frame = new JFrame("StickMan Legends");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create main menu panel
        MainMenu mainMenu = new MainMenu();
        frame.add(mainMenu);

        // Pack the frame and center it on the screen
        frame.pack();
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
