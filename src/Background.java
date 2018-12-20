import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    BufferedImage image;
    BufferedImage originalImage;
    Vector2D position;
    Vector2D velocity;
    static long oldWidth;
    static long originalWidth;
    int windowWidth;
    int windowHeight;
    int partCounter;
    String url;
    public Background(int windowWidth, int windowHeight) {
        this.url = "assets/images/background/0.png";
        this.image = SpriteUtils.loadImage(this.url);
        this.originalImage = SpriteUtils.loadImage(this.url);
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.image = new ImageProcessing(this.url, windowWidth, windowHeight, this.image.getWidth(), this.image.getHeight() + this.windowHeight, this.image.getType()).makeInfinite(600 * this.windowWidth / this.originalImage.getWidth());
        Background.oldWidth = this.image.getWidth();
        Background.originalWidth = this.originalImage.getWidth();
        this.velocity = new Vector2D(0, 1);
        this.position = new Vector2D(0, this.image.getHeight() - this.windowHeight);
        if (Background.oldWidth != this.windowWidth) {
            this.resize(this.windowWidth, this.windowHeight);
        }
        this.partCounter = 0;
    }
    public void resize(int windowWidth, int windowHeight) {
        Background.oldWidth = this.image.getWidth();
        if (this.velocity.y > 0) {
            this.position.y = this.position.y * windowWidth / Background.oldWidth;
        } else {
            this.position.y = (this.position.y - this.windowHeight) * windowWidth / Background.oldWidth + windowHeight;
        }
        int scaledImageHeight = (int) Math.round((double) this.originalImage.getHeight() * windowWidth / this.originalImage.getWidth());
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.velocity.scaleThis(1, (double) windowWidth / Background.oldWidth);
        this.image = new ImageProcessing(this.url, windowWidth, windowHeight, windowWidth, scaledImageHeight, this.image.getType()).scaleImage();
        this.image = new ImageProcessing(this.url, windowWidth, windowHeight, this.image.getWidth(), this.image.getHeight() + this.windowHeight, this.image.getType()).makeInfinite(this.image, 600 * this.windowWidth / this.originalImage.getWidth());
//        System.out.println(this.image.getHeight());
    }
    public void move() {
//        if (this.position.y > 0 || this.position.y < -this.image.getHeight() + this.windowHeight) {
//            if (this.position.y > 0) {
//                this.position.y = 0;
//            }
//            else {
//                this.position.y = -this.image.getHeight() + this.windowHeight;
//            }
//            this.velocity.y *= -1;
//        }
        if (this.position.y <= 0) {
            this.position.y += this.image.getHeight() - this.windowHeight;
        }
        this.position.y -= this.velocity.y;
    }
    public void draw(Graphics g) {
        g.drawImage(this.image, 0, 0, this.windowWidth, this.windowHeight, 0, (int)Math.round(this.position.y), this.windowWidth, (int)Math.round(this.position.y) + this.windowHeight, null);
    }
}
