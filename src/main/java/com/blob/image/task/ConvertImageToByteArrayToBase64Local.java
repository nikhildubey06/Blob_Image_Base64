package com.blob.image.task;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

public class ConvertImageToByteArrayToBase64Local {
    public static void main(String[] args) {
        String imagePath = "C:\\Users\\NikhilDubey\\Downloads\\Fruits.jpg"; // Replace with your image file path

        try {
            // Read the image file into a BufferedImage
            File imageFile = new File(imagePath);
            BufferedImage bufferedImage = ImageIO.read(imageFile);

            // Convert the BufferedImage to a byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
            byte[] imageBytes = byteArrayOutputStream.toByteArray();

            // Encode the byte array as a Base64 string
            String base64Image = Base64.getEncoder().encodeToString(imageBytes);

            // Print the Base64-encoded image
            System.out.println(base64Image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

