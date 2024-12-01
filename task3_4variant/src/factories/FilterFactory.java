package factories;

import processing.FilterApplication;
import processor.ImageProcessor;

import java.awt.image.BufferedImage;

public class FilterFactory extends ImageProcessorFactory {
    private final BufferedImage image;
    private final String filterType;

    public FilterFactory(BufferedImage image, String filterType) {
        this.image = image;
        this.filterType = filterType;
    }

    @Override
    public ImageProcessor createProcessor() {
        return new FilterApplication(image, filterType);
    }
}