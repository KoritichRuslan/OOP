import factories.ColorCorrectionFactory;
import factories.FilterFactory;
import factories.ImageProcessorFactory;
import factories.ResizeFactory;
import processor.ImageProcessor;

import javax.imageio.ImageIO; // читання зображень
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class ImageProcessingApp {
    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File("src/resource/human.png"));

        float[] brightnessFactors = {0.5f, 0.5f, 0.5f};
        float[] offsets = {0, 0, 0};
        BufferedImage colorCorrectedImage = copyImage(originalImage);
        ImageProcessorFactory colorFactory = new ColorCorrectionFactory(colorCorrectedImage, brightnessFactors, offsets);
        ImageProcessor colorProcessor = colorFactory.createProcessor();
        colorProcessor.process();
        ImageIO.write(colorCorrectedImage, "png", new File("output_corrected.png"));


        BufferedImage filteredImage = copyImage(originalImage);
        ImageProcessorFactory filterFactory = new FilterFactory(filteredImage, "invert");
        ImageProcessor filterProcessor = filterFactory.createProcessor();
        filterProcessor.process();
        ImageIO.write(filteredImage, "png", new File("output_filtered.png"));


        BufferedImage resizedImage = copyImage(originalImage);
        ImageProcessorFactory resizeFactory = new ResizeFactory(resizedImage, 800, 600);
        ImageProcessor resizeProcessor = resizeFactory.createProcessor();
        BufferedImage processedResizedImage = resizeProcessor.process();
        ImageIO.write(processedResizedImage, "png", new File("output_resized.png"));
    }

    public static BufferedImage copyImage(BufferedImage source) {
        BufferedImage copy = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = copy.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return copy;
    }
}