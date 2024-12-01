package processing;
import processor.ImageProcessor;

import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class ColorCorrection implements ImageProcessor {
    private final BufferedImage image;
    private final float[] brightnessFactors;
    private final float[] offsets;

    public ColorCorrection(BufferedImage image, float[] brightnessFactors, float[] offsets) {
        this.image = image;
        this.brightnessFactors = brightnessFactors;
        this.offsets = offsets;
    }

    @Override
    public BufferedImage process() {
        RescaleOp rescaleOp = new RescaleOp(brightnessFactors, offsets, null);
        rescaleOp.filter(image, image);
        return image;
    }
}