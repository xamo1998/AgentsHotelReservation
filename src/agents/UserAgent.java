package agents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import jade.core.Agent;
import swing.Frame;
import swing.FrameChooseTrip;
import swing.FrameLeisure;
import swing.FrameWaitTripResponse;

public class UserAgent extends Agent{
	
	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getPanel().getTripButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FrameChooseTrip chooseTrip = new FrameChooseTrip();
				chooseTrip.getBtnAceptar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(!chooseTrip.checkCorrectInterval()) {
							System.err.println("La fecha de comienzo no puede ser mayor a la de entrada.\n");
						}else {
							System.out.println("Datos correctos\nCiudad:"+chooseTrip.getCity()+"\nFecha Inicio: ");
						}
						//Pasos: 1.enviamos mensaje, 2.Esperamos respues, 3.Imprimimos
						
					}
				});
				
				chooseTrip.getBtnCancelar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						chooseTrip.dispatchEvent(new WindowEvent(chooseTrip, WindowEvent.WINDOW_CLOSING));
					}
				});
			}
		});
		
		frame.getPanel().getButtonPleasure().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				FrameLeisure frameLeisure = new FrameLeisure();
				frameLeisure.getBtnAceptar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						
					}
				});
				frameLeisure.getBtnCancelar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frameLeisure.dispatchEvent(new WindowEvent(frameLeisure, WindowEvent.WINDOW_CLOSING));
					}
				});
			}
		});
	}
 
}
