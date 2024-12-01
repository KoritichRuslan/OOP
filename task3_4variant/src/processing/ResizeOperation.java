package processing;
import processor.ImageProcessor;

import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.Graphics2D;

public class ResizeOperation implements ImageProcessor {
    private final BufferedImage image;
    private final int newWidth;
    private final int newHeight;

    public ResizeOperation(BufferedImage image, int newWidth, int newHeight) {
        this.image = image;
        this.newWidth = newWidth;
        this.newHeight = newHeight;
    }

    @Override
    public BufferedImage process() {
        Image temp = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(temp, 0, 0, null);
        g2d.dispose();
        return resizedImage;
    }
}