
package server;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class ClientHandler extends Thread {


    private Socket cSocket = null;
    private JPanel cPanel =null;
    
    public ClientHandler(Socket cSocket, JPanel desktop) {
        this.cSocket = cSocket;
        this.cPanel = desktop;
        start();
    }
    public void run(){

        //used to represent client screen size
        Rectangle clientScreenDim = null;
        //Used to read screenshots and client screen dimension
        ObjectInputStream ois = null;

        try{
            //Read client screen dimension
            ois = new ObjectInputStream(cSocket.getInputStream());
            clientScreenDim =(Rectangle) ois.readObject();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        //Start recieveing screenshots
       new ScreenReceiver(ois,cPanel);
        //Start sending events to the client
        new CommandsSender(cSocket,cPanel,clientScreenDim);
    }

}
