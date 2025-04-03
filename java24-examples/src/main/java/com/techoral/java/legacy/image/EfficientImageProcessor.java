package com.techoral.java.legacy.image;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import javax.imageio.ImageIO;

/**
 * Demonstrates efficient image processing using Java 24's NIO for better memory management.
 * This class shows how to process large images using direct ByteBuffers
 * for better performance and memory management.
 */
public class EfficientImageProcessor {
    
    /**
     * Processes an image using direct ByteBuffer for better performance.
     * Applies a simple grayscale conversion as an example operation.
     * 
     * @param inputPath Path to the input image
     * @param outputPath Path where the processed image will be saved
     * @throws IOException if there's an error reading or writing the image
     */
    public static void processImage(String inputPath, String outputPath) throws IOException {
        BufferedImage image = ImageIO.read(new File(inputPath));
        int width = image.getWidth();
        int height = image.getHeight();
        
        // Get RGB data
        int[] pixels = image.getRGB(0, 0, width, height, null, 0, width);
        
        // Allocate direct buffer
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(pixels.length * 4); // 4 bytes per pixel
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        
        // Copy pixels to direct buffer
        intBuffer.put(pixels);
        intBuffer.flip();
        
        // Process the image in direct buffer
        processGrayscale(intBuffer);
        
        // Copy back to pixels array
        intBuffer.get(pixels);
        
        // Create output image
        BufferedImage output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        output.setRGB(0, 0, width, height, pixels, 0, width);
        
        // Save the processed image
        ImageIO.write(output, "png", new File(outputPath));
    }
    
    /**
     * Converts the image to grayscale using direct buffer.
     * 
     * @param buffer IntBuffer containing the image data
     */
    private static void processGrayscale(IntBuffer buffer) {
        for (int i = 0; i < buffer.limit(); i++) {
            int pixel = buffer.get(i);
            
            int red = (pixel >> 16) & 0xff;
            int green = (pixel >> 8) & 0xff;
            int blue = pixel & 0xff;
            
            // Calculate grayscale value
            int gray = (red + green + blue) / 3;
            
            // Set the same value for R, G, and B
            int newPixel = (gray << 16) | (gray << 8) | gray | (0xff000000);
            
            buffer.put(i, newPixel);
        }
    }
    
    public static void main(String[] args) {
        try {
            String inputPath = "input.jpg";
            String outputPath = "output_grayscale.png";
            
            long startTime = System.currentTimeMillis();
            
            processImage(inputPath, outputPath);
            
            long endTime = System.currentTimeMillis();
            System.out.println("Image processed successfully!");
            System.out.println("Processing time: " + (endTime - startTime) + "ms");
            
        } catch (IOException e) {
            System.err.println("Error processing image: " + e.getMessage());
        }
    }
} 