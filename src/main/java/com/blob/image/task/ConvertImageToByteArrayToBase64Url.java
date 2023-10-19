package com.blob.image.task;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import javax.imageio.ImageIO;

public class ConvertImageToByteArrayToBase64Url {
    public static void main(String[] args) {
        String imageUrl = "https://staticimg.amarujala.com/assets/images/2018/04/22/750x506/gandhi-ji-and-charkha_1524384138.jpeg"; // Replace with the URL of the image

        try {
            // Create a URL object and open a connection to the image URL
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Check if the connection was successful (HTTP status 200 OK)
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Read the image from the input stream
                InputStream inputStream = connection.getInputStream();

                // Convert the input stream to a BufferedImage
                BufferedImage bufferedImage = ImageIO.read(inputStream);

                // Convert the BufferedImage to a byte array
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "jpg", byteArrayOutputStream);
                byte[] imageBytes = byteArrayOutputStream.toByteArray();

                // Encode the byte array as a Base64 string
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

                // Print the Base64-encoded image
                System.out.println(base64Image);

                // Close the input stream
                inputStream.close();
            } else {
                System.err.println("Failed to fetch the image. HTTP Status Code: " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

