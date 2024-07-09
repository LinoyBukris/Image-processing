package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.util.Random;

public class MyImage {
    private BufferedImage originalImage;
    private BufferedImage disaplyImage;
    private MainScreen panel;
    private JLabel imageLabel;


    public MyImage(BufferedImage originalImage, MainScreen panel) {
        this.originalImage = originalImage;
        this.disaplyImage = deepCopy(originalImage);
        this.panel = panel;
        this.imageLabel = new JLabel();

    }

    public void dispaly() {

        imageLabel.setIcon(new ImageIcon(this.disaplyImage));
        this.panel.add(imageLabel, BorderLayout.CENTER);
        this.panel.revalidate();
        this.panel.repaint();
    }

    public BufferedImage getOriginalImage() {
        return originalImage;
    }

    public BufferedImage getDisaplyImage() {
        return disaplyImage;
    }


    public void restart() {
        this.disaplyImage = deepCopy(originalImage);
        ;
    }

    private BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }


    // כל הפונקציות

    public void onlyBlackWhite() {
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                if ((colorPicture.getGreen() + colorPicture.getRed() + colorPicture.getBlue()) / 3 > 122.5) {
                    this.disaplyImage.setRGB(x, y, Color.WHITE.getRGB());
                } else {
                    this.disaplyImage.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }
        dispaly();
    }


    public void grayscale() {
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                int average = (colorPicture.getRed() + colorPicture.getGreen() + colorPicture.getBlue()) / 3;
                Color colorAverage = new Color(average, average, average);
                this.disaplyImage.setRGB(x, y, colorAverage.getRGB());
            }
        }
        dispaly();
    }

    public void colorShiftRight() {
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                Color colorShiftRight = new Color(
                        colorPicture.getGreen(),
                        colorPicture.getBlue(),
                        colorPicture.getRed());
                this.disaplyImage.setRGB(x, y, colorShiftRight.getRGB());
            }
        }
        dispaly();
    }


    public void colorShifLeft() {
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                Color colorShifLeft = new Color(
                        colorPicture.getBlue()
                        , colorPicture.getRed()
                        , colorPicture.getGreen()
                );

                this.disaplyImage.setRGB(x, y, colorShifLeft.getRGB());
            }
        }
        dispaly();
    }

    public void negative() {
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                Color negativeColor = new Color(
                        255 - colorPicture.getRed(),
                        255 - colorPicture.getGreen(),
                        255 - colorPicture.getBlue()
                );

                this.disaplyImage.setRGB(x, y, negativeColor.getRGB());
            }
        }
        dispaly();
    }

    public void mirror() {
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                Color currentColor = new Color(this.originalImage.getRGB(x, y));
                Color mirrorColor = new Color(this.originalImage.getRGB(this.originalImage.getWidth() - x - 1, y));
                this.disaplyImage.setRGB(x, y, mirrorColor.getRGB());
                this.disaplyImage.setRGB(this.originalImage.getWidth() - x - 1, y, currentColor.getRGB());
            }
        }
        dispaly();
    }

    public void eliminateRed() {
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                Color eliminateRed = new Color(
                        0,
                        colorPicture.getGreen(),
                        colorPicture.getBlue()
                );

                this.disaplyImage.setRGB(x, y, eliminateRed.getRGB());
            }
        }
        dispaly();
    }

    public void sepia() {
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                int red = colorPicture.getRed();
                int green = colorPicture.getGreen();
                int blue = colorPicture.getBlue();

                int tr = (int)(0.393 * red + 0.769 * green + 0.189 * blue);
                int tg = (int)(0.349 * red + 0.686 * green + 0.168 * blue);
                int tb = (int)(0.272 * red + 0.534 * green + 0.131 * blue);

                // Ensure values are within the 0-255 range
                if (tr > 255) {
                    tr = 255;
                }
                if (tg > 255) {
                    tg = 255;
                }
                if (tb > 255) {
                    tb = 255;
                }

                Color sepiaColor = new Color(tr, tg, tb);
                this.disaplyImage.setRGB(x, y, sepiaColor.getRGB());
            }
        }
        dispaly();
    }

    public void addNoise() {
        restart();
        Random random = new Random();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                int noiseR = Math.min(Math.max(colorPicture.getRed() + random.nextInt(50) - 25, 0), 255);
                int noiseG = Math.min(Math.max(colorPicture.getGreen() + random.nextInt(51) - 25, 0), 255);
                int noiseB = Math.min(Math.max(colorPicture.getBlue() + random.nextInt(51) - 25, 0), 255);

                Color noisyColor = new Color(noiseR, noiseG, noiseB);

                this.disaplyImage.setRGB(x, y, noisyColor.getRGB());
            }
        }
        dispaly();
    }

    public void vignette(){
        sepia();
        Random random = new Random();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                int noiseR = Math.min(Math.max(colorPicture.getRed() + random.nextInt(50) - 25, 0), 255);
                int noiseG = Math.min(Math.max(colorPicture.getGreen() + random.nextInt(51) - 25, 0), 255);
                int noiseB = Math.min(Math.max(colorPicture.getBlue() + random.nextInt(51) - 25, 0), 255);

                Color noisyColor = new Color(noiseR, noiseG, noiseB);

                this.disaplyImage.setRGB(x, y, noisyColor.getRGB());
            }
        }
        dispaly();
    }

    public void darker(){
        restart();
        for (int x = 0; x < this.panel.getLine().getX() && x < this.originalImage.getWidth(); x++) {
            for (int y = 0; y < this.originalImage.getHeight(); y++) {
                int currentColor = this.originalImage.getRGB(x, y);
                Color colorPicture = new Color(currentColor);
                int red = colorPicture.getRed(), green = colorPicture.getGreen(), blue = colorPicture.getBlue();
                Color darkerColor = new Color((int) (red * 0.6667), (int) (green * 0.6667), (int) (blue * 0.6667));
                this.disaplyImage.setRGB(x, y, darkerColor.getRGB());


            }
        }
        dispaly();

    }


}











