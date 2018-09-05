
package server;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
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
        Rectangle clientScreenDim = null;
        ObjectInputStream ois = null;

        try{
            ois = new ObjectInputStream(cSocket.getInputStream());
            clientScreenDim =(Rectangle) ois.readObject();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

       new ScreenReceiver(ois,cPanel);
       new CommandsSender(cSocket,cPanel,clientScreenDim);
    }

}
