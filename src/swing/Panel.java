package swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;


public class Panel extends JPanel{
	private JButton buttonPleasure, tripButton, exitButton, groupButton, myBookings;
	public Panel() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		tripButton = new JButton("Realizar un viaje");
		tripButton.setBounds(56, 84, 279, 23);
		//JLabel pic= new JLabel(new ImageIcon(image));
		//add(pic, BorderLayout.NORTH);*/
		add(tripButton);
		
		buttonPleasure = new JButton("Actividades de ocio");
		buttonPleasure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonPleasure.setBounds(56, 120, 279, 23);
		add(buttonPleasure);
		
		JLabel lblViajesElCorte = new JLabel("Viajes el Corte Ingl\u00E9s");
		lblViajesElCorte.setForeground(Color.WHITE);
		lblViajesElCorte.setBackground(Color.WHITE);
		lblViajesElCorte.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblViajesElCorte.setHorizontalAlignment(SwingConstants.CENTER);
		lblViajesElCorte.setBounds(0, 0, 380, 96);
		add(lblViajesElCorte);
		
		exitButton = new JButton("Salir");
		exitButton.setBounds(143, 236, 97, 25);
		add(exitButton);
		
		myBookings = new JButton("Mis reservas");
		myBookings.setBounds(56, 156, 279, 25);
		add(myBookings);
		
		groupButton = new JButton("Grupo");
		groupButton.setBounds(143, 194, 97, 25);
		add(groupButton);		
		//Icon icon=new ImageIcon(getClass().getResource("/resources/make_trip.png"));
		//System.out.println(icon);
		//JButton btnNewButton = new JButton();
		//btnNewButton.setBounds(10, 71, 166, 128);
		//add(btnNewButton);
		
			
		
	}
	public JButton getButtonPleasure() {
		return buttonPleasure;
	}
	public JButton getTripButton() {
		return tripButton;
	}
	public JButton getExitButton() {
		return exitButton;
	}
	public JButton getGroupButton() {
		return groupButton;
	}
	public JButton getMyBookings() {
		return myBookings;
	}
	
}
