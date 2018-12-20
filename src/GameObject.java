import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject {
    public BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public Vector2D speed;
    public GameObject() {
        this.position = new Vector2D();
    }
    public void run() {

    }
    public void draw(Graphics g) {

    }
}
