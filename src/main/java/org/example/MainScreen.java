package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MainScreen extends JPanel {

    private int x;
    private int y;
    private int width;
    private int height;
    private Line line;
    private MouseListener mouseListener;



    public MainScreen(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.setBounds(x, y, width, height);
        this.line = new Line();
        addMouseMotionListener(new MyMouseMotionListener(this));

        this.setBackground(Color.lightGray);
        this.setLayout(new BorderLayout());


    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        this.line.print(g);



    }


    public Line getLine() {
        return line;
    }




}

