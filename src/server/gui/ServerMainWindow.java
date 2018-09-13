package server.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ServerMainWindow extends JFrame {
	private JPanel panel_1=null;
	
	public ServerMainWindow() {
		setUndecorated(true);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Show the frame in a maximized state
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
        
        getContentPane().setLayout(new BorderLayout(0, 0));
        
        //Creating top panel with JLabel "client screen" and exit button
        JPanel panel = new JPanel();
        panel.setBackground(SystemColor.controlDkShadow);
        panel.setBorder(new LineBorder(new Color(105, 105, 105), 5, true));
        panel.setPreferredSize(new Dimension(10, 30));
        getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new BorderLayout(0, 0));
        
        JLabel lblClientScreen = new JLabel("client screen");
        panel.add(lblClientScreen, BorderLayout.WEST);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(null);
        panel_2.setOpaque(false);
        panel_2.setBackground(SystemColor.controlDkShadow);
        panel.add(panel_2, BorderLayout.EAST);
        
        JButton btnMinimize = new JButton("");
        btnMinimize.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		GUIControler.minimizeServerMainWindow();
        	}
        	
        });
        btnMinimize.setToolTipText("Minimize");
        btnMinimize.setContentAreaFilled(false);
        btnMinimize.setBorderPainted(false);
        btnMinimize.setBorder(null);
        btnMinimize.setFocusPainted(false);
        btnMinimize.setRolloverIcon(new ImageIcon(ServerMainWindow.class.getResource("/Images/RemoteMinimizeSmall.png")));
        btnMinimize.setIcon(new ImageIcon(ServerMainWindow.class.getResource("/Images/RemoteMinimize.png")));
        panel_2.add(btnMinimize);
        
        JButton btnX = new JButton("");
        panel_2.add(btnX);
        btnX.setToolTipText("Exit");
        btnX.setBorder(null);
        btnX.setFocusPainted(false);
        btnX.setContentAreaFilled(false);
        btnX.setBorderPainted(false);
        btnX.setOpaque(false);
        btnX.setIcon(new ImageIcon(ServerMainWindow.class.getResource("/Images/RemoteExit.png")));
        btnX.setRolloverIcon(new ImageIcon(ServerMainWindow.class.getResource("/Images/RemoteExitSmall.png .png")));
        btnX.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
        
        panel_1 = new JPanel();
        getContentPane().add(panel_1, BorderLayout.CENTER);

	}
	public JPanel getClientDesktopPanel(){
		return panel_1;
	}
	public void allowListeners(){
		panel_1.setFocusable(true);
		this.setVisible(true);
	}
}
