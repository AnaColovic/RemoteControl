package server;

import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import server.ClientHandler;

public class ServerMain {
    private JDesktopPane desktop = new JDesktopPane();
	
	public void serverStart(int port,JPanel desktop) {
        try {
            ServerSocket sc = new ServerSocket(port);
            System.out.println("Listening for clients on port: "+port);  
            Socket client = sc.accept();
                System.out.println("New client Connected to the server");
                new ClientHandler(client,desktop);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
