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

import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;


public class Panel extends JPanel{
	private JButton buttonPleasure, tripButton;
	public Panel() {
		setLayout(null);
		tripButton = new JButton("Realizar un viaje");
		tripButton.setBounds(10, 118, 390, 23);
		//JLabel pic= new JLabel(new ImageIcon(image));
		//add(pic, BorderLayout.NORTH);*/
		add(tripButton);
		
		buttonPleasure = new JButton("Actividades de ocio");
		buttonPleasure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonPleasure.setBounds(10, 152, 390, 23);
		add(buttonPleasure);
		
		JLabel lblViajesElCorte = new JLabel("Viajes el Corte Ingl\u00E9s");
		lblViajesElCorte.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblViajesElCorte.setHorizontalAlignment(SwingConstants.CENTER);
		lblViajesElCorte.setBounds(10, 11, 390, 96);
		add(lblViajesElCorte);
		
			
		
	}
	public JButton getButtonPleasure() {
		return buttonPleasure;
	}
	public JButton getTripButton() {
		return tripButton;
	}
	
	
	
}
