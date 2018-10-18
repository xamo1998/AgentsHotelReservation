package agents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import data.Data;
import data.ReservationData;
import helpers.Utils;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;
import swing.Frame;
import swing.FrameChooseTrip;
import swing.FrameLeisure;
import swing.FrameWaitTripResponse;

public class UserAgent extends Agent{
	private Agent currentAgent;
	@Override
	protected void setup() {
		this.currentAgent=this;
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
							return;
						}
						//Pasos: 1.enviamos mensaje, 2.Esperamos respues, 3.Imprimimos
						ReservationData data = new ReservationData(chooseTrip.getCity(),Data.ACCOMMODATION_TYPE,chooseTrip.getStartDay(), chooseTrip.getEndDay());
						Utils.enviarMensaje(currentAgent, Data.ACCOMMODATION_TYPE, data);
						ACLMessage msg=currentAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("ontologia")));
						try {
							System.out.println("Mensaje: "+msg.getContentObject());
						} catch (UnreadableException e2) {
							// TODO: handle exception
						}
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
