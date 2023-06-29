package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SecondTest {
    public static void main(String[] args) {
        try{
            BufferedImage bufferedImage = ImageIO.read(new File("D:/GitHubRepos/ImageEditor/ImageEditor" +
                    "/src/main/resources/outdoor-husky-dog.jpg"));
            BufferedImage secondMethod = resizeImage(bufferedImage,400,300  );
            if (secondMethod.getWidth()==400 && secondMethod.getHeight()==300){
                System.out.println("success");
            }else {
                System.exit(1);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    private static BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight)
            throws IOException {
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        graphics2D.dispose();
        return resizedImage;
    }
}
