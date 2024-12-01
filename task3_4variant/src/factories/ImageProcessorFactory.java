package factories;

import processor.ImageProcessor;

public abstract class ImageProcessorFactory {
    public abstract ImageProcessor createProcessor();
}