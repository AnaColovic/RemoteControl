package server.gui;

import java.awt.BorderLayout;
import java.awt.MouseInfo;
import java.net.Socket;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import server.*;

public class GUIControler {
	
	private static ServerStartingWindow ssw;
	private static ServerMainWindow smw;
	private static ServerMain sm;
	
	public static void main(String[] args){
		ssw=new ServerStartingWindow();
		ssw.setVisible(true);
	}
	public static void startSeverMainWindow(int port){
		smw=new ServerMainWindow();
		smw.setVisible(true);
		ssw.setVisible(false);
		sm=new ServerMain();
		sm.serverStart(port,smw.getClientDesktopPanel());
	}
	
	public static void clientDisconected(){
		smw=null;
		ssw.textInputReset();
		JOptionPane.showMessageDialog(ssw, "Client disconnected", "Program terminated", JOptionPane.INFORMATION_MESSAGE);
		ssw.setVisible(true);
	}


}
