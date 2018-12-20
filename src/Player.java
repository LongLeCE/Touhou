import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
    BufferedImage image;
//    BufferedImage originalImage;
    Vector2D position;
    Vector2D velocity;
    Vector2D speed;
    int windowWidth;
    int windowHeight;
    String url;
    public Player(int windowWidth, int windowHeight) {
        this.url = "assets/images/players/straight/0.png";
        this.image = SpriteUtils.loadImage(this.url);
//        this.originalImage = SpriteUtils.loadImage(this.url);
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.velocity = new Vector2D();
        this.speed = new Vector2D(6, 6);
        this.position = new Vector2D((double)(Background.oldWidth - this.image.getWidth()) / 2, this.windowHeight - this.image.getHeight());
        this.resize(this.windowWidth, this.windowHeight);
    }
    public void resize(int windowWidth, int windowHeight) {
        this.position.scaleThis((double) windowWidth / Background.oldWidth, (double) windowHeight / this.windowHeight);
        this.speed.scaleThis((double) windowWidth / Background.oldWidth, (double) windowHeight / this.windowHeight);
        int scaledImageWidth = (int) Math.round((double) this.image.getWidth() * windowWidth / Background.oldWidth);
        int scaledImageHeight = (int) Math.round((double) this.image.getHeight() * windowHeight / this.windowHeight);
        this.image = new ImageProcessing(this.url, windowWidth, windowHeight, scaledImageWidth, scaledImageHeight, this.image.getType()).scaleImage();
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
    }
    public boolean collideLeftBorder() {
        return this.position.x < 0;
    }
    public boolean collideRightBorder() {
        return this.position.x + this.image.getWidth() > this.windowWidth;
    }
    public boolean collideUpperBorder() {
        return this.position.y < 0;
    }
    public boolean collideLowerBorder() {
        return this.position.y + this.image.getHeight() > this.windowHeight;
    }
    public void move() {
        this.velocity = new Vector2D();
        if (GameWindow.isUpPress) {
            this.velocity.addThis(0, -1);
        }
        if (GameWindow.isDownPress) {
            this.velocity.addThis(0, 1);
        }
        if (GameWindow.isLeftPress) {
            this.velocity.addThis(-1, 0);
        }
        if (GameWindow.isRightPress) {
            this.velocity.addThis(1, 0);
        }
        this.position.addThis(this.velocity.scaleThis(this.speed).ellipseDownScale(this.speed));
        if (collideLeftBorder()) {
            this.position.x = 0;
        }
        else if (collideRightBorder()) {
            this.position.x = this.windowWidth - this.image.getWidth();
        }
        if (collideUpperBorder()) {
            this.position.y = 0;
        }
        else if (collideLowerBorder()) {
            this.position.y = this.windowHeight - this.image.getHeight();
        }
    }
    public void draw(Graphics g) {
        g.drawImage(this.image, (int)Math.round(this.position.x), (int)Math.round(this.position.y), null);
    }
}
