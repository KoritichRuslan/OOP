package processing;
import processor.ImageProcessor;

import java.awt.image.BufferedImage;
import java.awt.color.ColorSpace;
import java.awt.image.ColorConvertOp;
import java.awt.Color;

public class FilterApplication implements ImageProcessor {
    private final BufferedImage image;
    private final String filterType;

    public FilterApplication(BufferedImage image, String filterType) {
        this.image = image;
        this.filterType = filterType;
    }

    @Override
    public BufferedImage process() {
        return switch (filterType) {
            case "blackAndWhite" -> applyBlackAndWhite(image);
            case "invert" -> applyInvert(image);
            default -> throw new IllegalArgumentException("Unknown filter type: " + filterType);
        };
    }

    private BufferedImage applyBlackAndWhite(BufferedImage image) {
        ColorConvertOp colorConvert = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        colorConvert.filter(image, image);
        return image;
    }

    private BufferedImage applyInvert(BufferedImage image) {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Color color = new Color(image.getRGB(x, y));
                int invertedRed = 255 - color.getRed();
                int invertedGreen = 255 - color.getGreen();
                int invertedBlue = 255 - color.getBlue();
                image.setRGB(x, y, new Color(invertedRed, invertedGreen, invertedBlue).getRGB());
            }
        }
        return image;
    }
}