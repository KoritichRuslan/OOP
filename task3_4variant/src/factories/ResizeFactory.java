package factories;

import processing.ResizeOperation;
import processor.ImageProcessor;

import java.awt.image.BufferedImage;

public class ResizeFactory extends ImageProcessorFactory {
    private final BufferedImage image;
    private final int newWidth;
    private final int newHeight;

    public ResizeFactory(BufferedImage image, int newWidth, int newHeight) {
        this.image = image;
        this.newWidth = newWidth;
        this.newHeight = newHeight;
    }

    @Override
    public ImageProcessor createProcessor() {
        return new ResizeOperation(image, newWidth, newHeight);
    }
}