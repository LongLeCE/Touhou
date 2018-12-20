import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    public static int originalHeight;
    public static boolean isUpPress;
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    GameCanvas canvas;
    public GameWindow(int windowWidth, int windowHeight, int minWidth, int minHeight) {
        this.setMinimumSize(new Dimension(minWidth + 16, minHeight + 39));
        this.canvas = new GameCanvas(windowWidth, windowHeight);
//        this.setSize(windowWidth + 16, windowHeight + 39);
        GameWindow.originalHeight = windowHeight;
        this.setTitle("Game Touhou");
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(canvas);
        this.setupEventListener();
        this.setVisible(true);
        this.pack();
    }
    public void setupEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    GameWindow.isUpPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    GameWindow.isLeftPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    GameWindow.isDownPress = true;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    GameWindow.isRightPress = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    GameWindow.isUpPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    GameWindow.isLeftPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    GameWindow.isDownPress = false;
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    GameWindow.isRightPress = false;
                }
            }
        });
    }
}
