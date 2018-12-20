import javax.swing.*;
import java.awt.*;
//import java.util.Random;

public class GameCanvas extends JPanel {
    Background background;
    Player player;
    int fps;
    boolean ran;
    public GameCanvas(int windowWidth, int windowHeight) {
        this.setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.background = new Background(windowWidth, windowHeight);
        this.player = new Player(windowWidth, windowHeight);
        this.fps = 60;
        this.ran = false;
    }
    public void run(long currentNano) {
//        this.currentNano = System.nanoTime();
        if (System.nanoTime() - currentNano >= 1000000000L / this.fps) {
            this.background.move();
            this.player.move();
            this.repaint();
            this.ran = true;
        }
    }
    @Override
    public void paint(Graphics g) {
        this.background.draw(g);
        this.player.draw(g);
    }
}
