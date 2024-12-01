package factories;

import processing.ColorCorrection;
import processor.ImageProcessor;

import java.awt.image.BufferedImage;

public class ColorCorrectionFactory extends ImageProcessorFactory {
    private final BufferedImage image;
    private final float[] brightnessFactors;
    private final float[] offsets;

    public ColorCorrectionFactory(BufferedImage image, float[] brightnessFactors, float[] offsets) {
        this.image = image;
        this.brightnessFactors = brightnessFactors;
        this.offsets = offsets;
    }

    @Override
    public ImageProcessor createProcessor() {
        return new ColorCorrection(image, brightnessFactors, offsets);
    }
}