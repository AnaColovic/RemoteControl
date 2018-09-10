package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import server.ClientHandler;
import server.gui.GUIControler;

public class ServerMain {
    private JDesktopPane desktop = new JDesktopPane();
    private ServerSocket sc=null;
    private Socket client=null;
	
	public void serverStart(int port,JPanel desktop) {
        try {
            sc = new ServerSocket(port);
            
            client = sc.accept();
                
            new ClientHandler(this,desktop);
          
        }catch (Exception ex) {
        	clientDisconnectedProgramTerminated();
        	GUIControler.clientDisconected();
        }
	}
	public void clientDisconnectedProgramTerminated(){
			try {
				client.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	public Socket getClientSocket(){
		return this.client;
	}
}
