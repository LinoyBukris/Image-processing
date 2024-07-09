package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class MenuPanel extends JPanel {

    private final int AMOUNT_BUTTONS = 10;
    private int x;
    private int y;
    private int width;
    private int height;
    private MyImage image;
    private int currentButton;



    public MenuPanel(int x, int y, int width, int height, MyImage image){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setBounds(x,y,width,height);
        this.image = image;
        this.currentButton=0;
        this.setBackground(Color.LIGHT_GRAY);
        GridLayout gridLayout = new GridLayout(6,2); //יצירת "תבנית" (layout)
        this.setLayout(gridLayout);
        JButton blackWhite = new JButton("black and white");
        add(blackWhite);
        blackWhite.addActionListener((event) -> {
            setCurrentButton(1);
        });

        JButton grayscale =new JButton("grayscale");
        add(grayscale);
        grayscale.addActionListener((event)->{
            setCurrentButton(2);
        });

        JButton colorShiftRight = new JButton("colorShiftRight");
        add(colorShiftRight);
        colorShiftRight.addActionListener((event)->{
            setCurrentButton(3);
        });

        JButton colorShifLeft =new JButton("colorShifLeft");
        add(colorShifLeft);
        colorShifLeft.addActionListener((event)->{
            setCurrentButton(4);
        });

        JButton negative =new JButton("negative");
        add(negative);
        negative.addActionListener((event)->{
            setCurrentButton(5);
        });

        JButton mirror =new JButton("mirror");
        add(mirror);
        mirror.addActionListener((event)->{
            setCurrentButton(6);
        });

        JButton eliminateRed =new JButton("eliminateRed");
        add(eliminateRed);
        eliminateRed.addActionListener((event)->{
            setCurrentButton(7);
        });

        JButton sepia =new JButton("sepia");
        add(sepia);
        sepia.addActionListener((event)->{
            setCurrentButton(8);
        });

        JButton addNoise =new JButton("addNoise");
        add(addNoise);
        addNoise.addActionListener((event)->{
            setCurrentButton(9);
        });

        JButton vignette =new JButton("vignette");
        add(vignette);
        vignette.addActionListener((event)->{
            setCurrentButton(10);
        });

        JButton darker =new JButton("darker");
        add(darker);
        darker.addActionListener((event)->{
            setCurrentButton(11);
        });

        JButton restart =new JButton("restart");
        add(restart);
        restart.addActionListener((event)->{
            setCurrentButton(12);
        });






        loop();
    }



    public void loop(){
        new Thread(()->{
            while (true) {
                System.out.println(this.currentButton);
                switch (this.currentButton) {
                    case 0:
                        System.out.println("not choose a filter");
                        break;
                    case 1:
                        image.onlyBlackWhite();
                        break;
                    case 2:
                        image.grayscale();
                        break;
                    case 3:
                        image.colorShiftRight();
                        break;
                    case 4:
                        image.colorShifLeft();
                        break;
                    case 5:
                        image.negative();
                        break;
                    case 6:
                        image.mirror();
                        break;
                    case 7:
                        image.eliminateRed();
                        break;
                    case 8:
                        image.sepia();
                        break;
                    case 9:
                        image.addNoise();
                        break;
                    case 10:
                        image.vignette();
                        break;
                    case 11:
                        image.darker();
                        break;
                    case 12:
                        image.restart();
                        image.dispaly();
                        break;
                }
            }}).start();
    }

    public void setCurrentButton(int currentButton){
        this.currentButton=currentButton;
    }






}
