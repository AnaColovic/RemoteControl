package server.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ServerStartingWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public ServerStartingWindow() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 185);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.scrollbar);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 0, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTypeServerPort = new JLabel("Type server listening port number:");
		lblTypeServerPort.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblTypeServerPort.setForeground(SystemColor.controlDkShadow);
		lblTypeServerPort.setBounds(30, 59, 218, 16);
		contentPane.add(lblTypeServerPort);
		
		JButton btnExit = new JButton("");
		btnExit.setBorderPainted(false);
		btnExit.setOpaque(false);
		btnExit.setFocusPainted(false);
		btnExit.setRolloverIcon(new ImageIcon("C:\\Users\\Nikola\\Desktop\\RemoteExitSmall.png .png"));
		btnExit.setContentAreaFilled(false);
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setIcon(new ImageIcon("C:\\Users\\Nikola\\Desktop\\RemoteExit.png"));
		btnExit.setBackground(new Color(220, 20, 60));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(255, 2, 17, 17);
		contentPane.add(btnExit);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setOpaque(false);
		textField.setBounds(91, 77, 100, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.LIGHT_GRAY);
		label.setIcon(new ImageIcon("C:\\Users\\Nikola\\Desktop\\Untitled-2.png"));
		label.setBounds(81, 77, 120, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Nikola\\Desktop\\top.png"));
		label_1.setBounds(0, 0, 275, 22);
		contentPane.add(label_1);
		
		JLabel lblNoteUsePort = new JLabel("Note: Use port number greater than 1024.");
		lblNoteUsePort.setForeground(SystemColor.controlDkShadow);
		lblNoteUsePort.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 11));
		lblNoteUsePort.setBounds(41, 156, 207, 16);
		contentPane.add(lblNoteUsePort);
		
		JButton btnOk = new JButton("");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUIControler.startSeverMainWindow(Integer.parseInt(textField.getText()));
			}
		});
		btnOk.setRolloverIcon(new ImageIcon("C:\\Users\\Nikola\\Desktop\\button-ok-small.png"));
		btnOk.setContentAreaFilled(false);
		btnOk.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOk.setOpaque(false);
		btnOk.setFocusPainted(false);
		btnOk.setBorderPainted(false);
		btnOk.setIcon(new ImageIcon("C:\\Users\\Nikola\\Desktop\\button-ok.png"));
		btnOk.setBounds(95, 107, 93, 16);
		contentPane.add(btnOk);
	}
}
