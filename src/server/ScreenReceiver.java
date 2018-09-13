package server;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ScreenReceiver extends Thread{

	private ClientHandler cHandler=null;
    private ObjectInputStream cObjectInputStream = null;
    private JPanel cPanel = null;

    public ScreenReceiver(ClientHandler ch, ObjectInputStream ois, JPanel p) {
    	cHandler=ch;
    	cObjectInputStream = ois;
    	cPanel = p;
    	
    	start();
    }
    

	public void run() {
    	
    		try {
    			while(true) {
				ImageIcon imgIcon = (ImageIcon)cObjectInputStream.readObject();
				Image img = imgIcon.getImage();
				img = img.getScaledInstance(cPanel.getWidth(), cPanel.getHeight(), Image.SCALE_FAST);
				
				Graphics graphics = cPanel.getGraphics();
				graphics.drawImage(img, 0, 0, cPanel.getWidth(), cPanel.getHeight(), cPanel);
    			}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				cHandler.terminate();
    	}
    }

}
