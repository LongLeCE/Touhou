import tklibs.SpriteUtils;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProcessing extends BufferedImage {
    int newImageWidth;
    int newImageHeight;
    int imageType;
    int windowWidth;
    int windowHeight;
    String url;
    public ImageProcessing(String url, int windowWidth, int windowHeight, int newImageWidth, int newImageHeight, int imageType) {
        super(newImageWidth, newImageHeight, imageType);
        this.newImageWidth = newImageWidth;
        this.newImageHeight = newImageHeight;
        this.imageType = imageType;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.url = url;
    }
    public ImageProcessing(int imageWidth, int imageHeight, int imageType) {
        super(imageWidth, imageHeight, imageType);
    }
    public ImageProcessing scaleImage() {
        ImageProcessing scaledImage = new ImageProcessing(this.newImageWidth, this.newImageHeight, this.imageType);
        Graphics2D graphics2D = scaledImage.createGraphics();
        if (this.windowWidth > Background.oldWidth) {
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        }
        else {
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        }
        graphics2D.drawImage(SpriteUtils.loadImage(this.url), 0, 0, this.newImageWidth, this.newImageHeight, null);
        graphics2D.dispose();
        return scaledImage;
    }
    public ImageProcessing makeInfinite(int continuity) {
        return this.makeInfinite(SpriteUtils.loadImage(this.url), continuity);
    }
    public ImageProcessing makeInfinite(BufferedImage image, int continuity) {
        BufferedImage imageChunk = new ImageProcessing(image.getWidth(), this.windowHeight, image.getType());
        Graphics2D graphics2D = imageChunk.createGraphics();
        graphics2D.drawImage(image, 0, 0, image.getWidth(), this.windowHeight, 0, image.getHeight() - this.windowHeight - continuity, image.getWidth(), image.getHeight() - continuity, null);
        graphics2D.dispose();
        ImageProcessing finalImage = new ImageProcessing(image.getWidth(), image.getHeight() + imageChunk.getHeight() - continuity, image.getType());
        graphics2D = finalImage.createGraphics();
        graphics2D.drawImage(imageChunk, 0, 0, null);
        BufferedImage blendedImage = this.continuousVerticalBlendImage(image, image, 0, 0, image.getWidth(), continuity, 0, image.getHeight() - continuity, image.getWidth(), continuity, continuity, 1);
        graphics2D.drawImage(blendedImage, 0, imageChunk.getHeight(), finalImage.getWidth(), finalImage.getHeight(), 0, 0, blendedImage.getWidth(), blendedImage.getHeight() - continuity, null);
        graphics2D.dispose();
        return finalImage;
    }
    public BufferedImage continuousVerticalBlendImage(BufferedImage base, BufferedImage overlay, int xb, int yb, int widthb, int heightb, int xo, int yo, int widtho, int heighto, int continuity, int mode) {
        int pieceHeightSrc = heighto / continuity;
        int pieceHeightDes = heightb / continuity;
        double factorStep = (double)1 / (continuity - 1);
        if (mode == 0) {
            for (int i = 0; i < continuity / 2; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float)(factorStep * 2* i));
            }
            for (int i = continuity / 2; i < continuity; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float)(1 - factorStep * 2 * i));
            }
        }
        else if (mode == 1) {
            for (int i = 0; i < continuity; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float)(1 - factorStep * i));
            }
        }
        else if (mode == 2) {
            for (int i = 0; i < continuity; i++) {
                base = this.blendImage(base, overlay, xb, yb + pieceHeightDes * i, xb + widthb, yb + pieceHeightDes * (i + 1),
                        xo, yo + pieceHeightSrc * i, xo + widtho, yo + pieceHeightSrc * (i + 1), (float)(factorStep * i));
            }
        }
        return base;
    }
    public BufferedImage blendImage(BufferedImage base, BufferedImage overlay, int xb1, int yb1, int xb2, int yb2, int xo1, int yo1, int xo2, int yo2, float factor) {
        Graphics2D graphics2D = base.createGraphics();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(factor));
        graphics2D.drawImage(overlay, xb1, yb1, xb2, yb2, xo1, yo1, xo2, yo2, null);
        graphics2D.dispose();
        return base;
    }
}
