package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JFrame{

    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT=750;

    public static final int BUTTON_WIDTH = 150;
    public static final int BUTTON_HEIGHT = 80;

    public static final int TEXT_WIDTH = 280;
    public static final int TEXT_HEIGHT = 25;

    public static final int INPUT_WIDTH = 440;
    public static final int INPUT_HEIGHT = 25;


    private BufferedImage image;

    private MenuPanel menuPanel;
    private MainScreen mainScreen;
    private MyImage myImage;
    private JButton button1;
    private JButton button2;
    private JLabel text;
    private JTextField input;
    private JLabel error;
    private boolean canContnue;






    public Window() {
        this.setTitle("Image processing");
        this.setVisible(true);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);




        this.text = new JLabel("Enter a path to the desired image: (press here->)");
        this.text.setBounds((WINDOW_WIDTH-TEXT_WIDTH-INPUT_WIDTH)/2,WINDOW_HEIGHT/5,TEXT_WIDTH,TEXT_HEIGHT);
        this.add(this.text);

        this.input = new JTextField(50);
        this.input.setBackground(Color.gray);
        this.input.setBounds(text.getX()+TEXT_WIDTH, WINDOW_HEIGHT/5, INPUT_WIDTH, INPUT_HEIGHT);
        this.add(this.input);

        this.error = new JLabel("The file does not exist, try again");
        this.error.setBounds((WINDOW_WIDTH-TEXT_WIDTH)/2,(WINDOW_HEIGHT-TEXT_HEIGHT)/3, TEXT_WIDTH, TEXT_HEIGHT);
        this.add(this.error);
        this.error.setVisible(false);

        this.button1 = new JButton("enter");
        this.button1.setBounds((WINDOW_WIDTH-BUTTON_WIDTH)/2, (WINDOW_HEIGHT-BUTTON_HEIGHT)/2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(button1);

        this.button2 = new JButton("continue");
        this.button2.setBounds((WINDOW_WIDTH-BUTTON_WIDTH)/2, (WINDOW_HEIGHT-BUTTON_HEIGHT)/2, BUTTON_WIDTH, BUTTON_HEIGHT);
        this.add(button2);
        this.button2.setVisible(false);

        this.button1.addActionListener((event1)->{
            image = loadImage(input.getText());
            if (canContnue){
                this.button1.setVisible(false);
                this.text.setVisible(false);
                this.input.setVisible(false);
                this.error.setVisible(false);
                this.button2.setVisible(true);

            }else{
                this.error.setVisible(true);

            }



        button2.addActionListener((event2)->{
            button2.setVisible(false);

            setLayout(null);


            this.mainScreen = new MainScreen(WINDOW_WIDTH/3, 0, 2*WINDOW_WIDTH/3, WINDOW_HEIGHT);
            this.myImage = new MyImage(image, mainScreen);
            this.menuPanel = new MenuPanel(0,0,WINDOW_WIDTH/3, WINDOW_HEIGHT, myImage);
            this.add(menuPanel);
            this.add(mainScreen);
            myImage.dispaly();






        });


        });
    }

    private BufferedImage loadImage(String path) {
        BufferedImage image = null;
        try {
            File file = new File(path);
            if (!file.exists()) {
                this.canContnue = false;
                throw new IOException("File not found: " + path);

            }else {
                this.canContnue = true;
            }
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }




}
