package server;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JPanel;

import server.EnumCommands;



public class CommandsSender implements KeyListener, MouseMotionListener, MouseListener{

	private Socket cSocket = null;
	private JPanel cPanel = null;
	private Rectangle clientScreenDim = null;
	private PrintWriter pw = null;
	
	public CommandsSender(Socket s, JPanel p, Rectangle r) {
		cSocket = s;
		cPanel = p;
		clientScreenDim = r;
		
		 cPanel.addKeyListener(this);
	     cPanel.addMouseListener(this);
	     cPanel.addMouseMotionListener(this);
	     
	     try {
			pw = new PrintWriter(cSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		System.out.println("Mouse Pressed");
        pw.println(EnumCommands.PRESS_MOUSE.getAbbrev());
        int button = arg0.getButton();
        int xButton = 16;
        if (button == 3) {
            xButton = 4;
        }
        pw.println(xButton);
        pw.flush();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		 System.out.println("Mouse Released");
	        pw.println(EnumCommands.RELEASE_MOUSE.getAbbrev());
	        int button = arg0.getButton();
	        int xButton = 16;
	        if (button == 3) {
	            xButton = 4;
	        }
	        pw.println(xButton);
	        pw.flush();
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		double xScale = clientScreenDim.getWidth()/cPanel.getWidth();
        System.out.println("xScale: " + xScale);
        double yScale = clientScreenDim.getHeight()/cPanel.getHeight();
        System.out.println("yScale: " + yScale);
        System.out.println("Mouse Moved");
        pw.println(EnumCommands.MOVE_MOUSE.getAbbrev());
        pw.println((int)(arg0.getX() * xScale));
        pw.println((int)(arg0.getY() * yScale));
        pw.flush();
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		System.out.println("Key Pressed");
        pw.println(EnumCommands.PRESS_KEY.getAbbrev());
        pw.println(arg0.getKeyCode());
        pw.flush();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("Key Pressed");
        pw.println(EnumCommands.PRESS_KEY.getAbbrev());
        pw.println(arg0.getKeyCode());
        pw.flush();
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
