package server;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ScreenReceiver extends Thread{

    private ObjectInputStream cObjectInputStream = null;
    private JPanel cPanel = null;
    private boolean continueLoop = true;

    public ScreenReceiver(ObjectInputStream ois, JPanel p) {

    }

}
