package org.example;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MyMouseMotionListener implements MouseMotionListener {

    private MainScreen mainScreen;

    public MyMouseMotionListener(MainScreen mainScreen) {
        this.mainScreen = mainScreen;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mainScreen.getLine().setX(e.getX());
        System.out.println(e.getX());

    }
}




