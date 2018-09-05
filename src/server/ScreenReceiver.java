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

    public ScreenReceiver(ObjectInputStream ois, JPanel p) {
    	cObjectInputStream = ois;
    	cPanel = p;
    	
    	start();
    }
    
    public void run() {
    	while(true) {
    		try {
				ImageIcon imgIcon = (ImageIcon)cObjectInputStream.readObject();
				System.out.println("New image received!");
				Image img = imgIcon.getImage();
				img = img.getScaledInstance(cPanel.getWidth(), cPanel.getHeight(), Image.SCALE_FAST);
				
				Graphics graphics = cPanel.getGraphics();
				graphics.drawImage(img, 0, 0, cPanel.getWidth(), cPanel.getHeight(), cPanel);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}
    }

}
