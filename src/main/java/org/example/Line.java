package org.example;

import java.awt.*;

public class Line {

    private int x;
     public Line(){
         this.x=200;
     }

     public void print(Graphics g){
         g.drawLine(this.x, 0, this.x, Window.WINDOW_HEIGHT);
     }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
