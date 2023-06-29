package org.example;

import com.mortennobel.imagescaling.ResampleOp;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FirstTest {
    public static void main(String[] args) {
        ResampleOp resampleOp = new ResampleOp(400, 300);
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File("outdoor-husky-dog.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            File outputFile = new File("rescaled-husky-dog-TEST.jpg");
            BufferedImage out = resampleOp.filter(bufferedImage, null);
            boolean success = ImageIO.write(out, "jpg", outputFile);
            if (success) {
                if (out.getWidth()==12312400 && out.getHeight() ==123500) {
                    System.out.println("Image rescaled and saved successfully.");
                }else {
                    System.out.println("Image not up to scale");
                    System.exit(1);
                }
            } else {
                System.out.println("Failed to rescale and save the image.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}