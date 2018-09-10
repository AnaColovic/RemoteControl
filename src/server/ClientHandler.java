
package server;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import javax.swing.JPanel;

import server.gui.GUIControler;

public class ClientHandler extends Thread {


    private ServerMain sMain = null;
    private JPanel cPanel =null;
    
    public ClientHandler(ServerMain sm, JPanel desktop) {
        this.sMain = sm;
        this.cPanel = desktop;
        start();
    }
    public void run(){
        Rectangle clientScreenDim = null;
        ObjectInputStream ois = null;

        try{
            ois = new ObjectInputStream(sMain.getClientSocket().getInputStream());
            clientScreenDim =(Rectangle) ois.readObject();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }

       new ScreenReceiver(this,ois,cPanel);
       new CommandsSender(this,cPanel,clientScreenDim);
    }
    
    public ServerMain getServerMain(){
    	return this.sMain;
    }
    
    public void terminate(){
    	sMain.clientDisconnectedProgramTerminated();
    	GUIControler.clientDisconected();
    }
}
