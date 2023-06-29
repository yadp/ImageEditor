import com.mortennobel.imagescaling.ResampleOp;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        ResampleOp resampleOp = new ResampleOp(400, 300);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("D:/GitHubRepos/ImageEditor/ImageEditor" +
                    "/src/main/resources/outdoor-husky-dog.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File outputFile = new File("rescaled-husky-dog.jpg");
            BufferedImage out = resampleOp.filter(bufferedImage, null);
            boolean success = ImageIO.write(out, "jpg", outputFile);
            if (success) {
                System.out.println("Image rescaled and saved successfully.");
            } else {
                System.out.println("Failed to rescale and save the image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File outputFile = new File("rescaled-husky-dog-second.jpg");
            BufferedImage secondMethod = resizeImage(bufferedImage,400,300  );
            boolean success = ImageIO.write(secondMethod, "jpg", outputFile);
            if (success) {
                System.out.println("Image rescaled and saved successfully.");
            } else {
                System.out.println("Failed to rescale and save the image.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}