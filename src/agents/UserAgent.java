package agents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.ws.FaultAction;

import org.omg.CORBA.PRIVATE_MEMBER;

import data.Activitie;
import data.Booking;
import data.Data;
import data.Hotel;
import data.MessageData;
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
	private ArrayList<Booking>bookingsList= new ArrayList<>();
	@Override
	protected void setup() {
		this.currentAgent=this;
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getPanel().getExitButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int option=JOptionPane.showConfirmDialog(frame.getFocusOwner(), "¿Estas seguro de que deseas salir del programa?","Cuidado", JOptionPane.YES_NO_OPTION);
				//JOptionPane.showMessageDialog(frame.getFocusOwner(),"No hay fechas disponibles","¿Estas seguro?",JOptionPane.OK_CANCEL_OPTION);
				if(option==JOptionPane.YES_OPTION)frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

			}
		});
		frame.getPanel().getGroupButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StringBuilder cadenaTabla = new StringBuilder();

				cadenaTabla.append("+----------------------------------------------------------------------------+\n");
				cadenaTabla.append(String.format("%50s\n", "DESARROLLADORES"));
				cadenaTabla.append("+----------------------------------------------------------------------------+\n");
				cadenaTabla.append(String.format("%5s%20s%27s%15s\n", "NOMBRE", "APELLIDOS", "DNI", "GRUPO"));
				cadenaTabla.append("+----------------------------------------------------------------------------+\n");
				cadenaTabla.append(String.format("%6s%20s%20s%10s\n", "NACHO", "ARROYO CRESPO", "70920385T", "A1"));
				cadenaTabla.append(String.format("%5s%20s%14s%10s\n", "HÉCTOR", "CHAMORRO ÁLVAREZ", "70908107G", "A1"));
				cadenaTabla.append("+----------------------------------------------------------------------------+\n");
				JOptionPane.showMessageDialog(frame.getFocusOwner(), cadenaTabla, "Participantes", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		frame.getPanel().getMyBookings().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StringBuilder bookings= new StringBuilder();
				bookings.append("==============================================================================\n");
				bookings.append(String.format("%30s%30s%30s%30s%30s\n", "Ciudad","Hotel","Comiezo","Fin",""));
				bookings.append("==============================================================================\n");
		        for(int i=0; i<bookingsList.size();i++) {
		        	bookings.append((String.format("%30s%30s%30s%30s%30s\n",
		        			bookingsList.get(i).getCityName(),
		        			bookingsList.get(i).getHotelName(),
		        			bookingsList.get(i).getStart(),
		        			bookingsList.get(i).getEnd(),
		        			"")));
		        	
		        }
				JOptionPane.showMessageDialog(frame.getFocusOwner(), bookings, "Reservas", JOptionPane.INFORMATION_MESSAGE);

			}

		});
		
		
		frame.getPanel().getTripButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.getPanel().getTripButton().setEnabled(false);
				FrameChooseTrip chooseTrip = new FrameChooseTrip();
				chooseTrip.getBtnAceptar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						if(!chooseTrip.checkCorrectInterval()) {
							JOptionPane.showMessageDialog(chooseTrip.getFocusOwner(),"La fecha de comienzo no puede ser mayor a la de entrada.\n","ERROR",JOptionPane.ERROR_MESSAGE);
							return;
						}
						//Pasos: 1.enviamos mensaje, 2.Esperamos respues, 3.Imprimimos
						MessageData data = new MessageData(chooseTrip.getCity(),Data.ACCOMMODATION_TYPE_CORTE_INGLES,chooseTrip.getStartDay(), chooseTrip.getEndDay());
						Utils.enviarMensaje(currentAgent, Data.ACCOMMODATION_TYPE_CORTE_INGLES, data);
						ACLMessage msg=currentAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("ontologia")));
						try {
							Hotel hotel=(Hotel) msg.getContentObject();
							if(hotel==null) {
								//System.out.println("No hay fechas disponibles\n");
								JOptionPane.showMessageDialog(chooseTrip.getFocusOwner(),"No hay fechas disponibles","ERROR",JOptionPane.ERROR_MESSAGE);
							}else {
								bookingsList.add(new Booking(hotel.getName(), getCityName(hotel), chooseTrip.getStartDay(), chooseTrip.getEndDay()));

								//System.out.println("Se ha reservado para el Hotel: "+hotel.getName()+
								//		"\nFecha: "+chooseTrip.getStartDay()+"-"+chooseTrip.getEndDay()+
								//		"\nCiudad: "+chooseTrip.getCity());
								JOptionPane.showMessageDialog(chooseTrip.getFocusOwner(), "Se ha reservado para el Hotel: "+hotel.getName()+
										"\nFecha: "+chooseTrip.getStartDay()+"-"+chooseTrip.getEndDay()+
										"\nCiudad: "+chooseTrip.getCity(), "Reserva completada", JOptionPane.INFORMATION_MESSAGE);
								
								chooseTrip.dispatchEvent(new WindowEvent(chooseTrip, WindowEvent.WINDOW_CLOSING));
							}
						} catch (UnreadableException e2) {
							// TODO: handle exception
						}
						frame.getPanel().getTripButton().setEnabled(true);
					}
				});
				
				chooseTrip.getBtnCancelar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame.getPanel().getTripButton().setEnabled(true);
						chooseTrip.dispatchEvent(new WindowEvent(chooseTrip, WindowEvent.WINDOW_CLOSING));
					}
				});
			}
		});
		
		frame.getPanel().getButtonPleasure().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				frame.getPanel().getButtonPleasure().setEnabled(false);
				FrameLeisure frameLeisure = new FrameLeisure();
				frameLeisure.getBtnAceptar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						MessageData data= new MessageData(frameLeisure.getCityName(),Data.LEISURE_TYPE_CORTE_INGLES, frameLeisure.getDay());
						Utils.enviarMensaje(currentAgent, Data.LEISURE_TYPE_CORTE_INGLES, data);
						ACLMessage msg=currentAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("ontologia")));
						try {
							ArrayList<Activitie> activities = (ArrayList<Activitie>) msg.getContentObject();
							if(activities.size()==0)
								JOptionPane.showMessageDialog(frameLeisure.getFocusOwner(),"No hay ninguna actividad","ERROR",JOptionPane.ERROR_MESSAGE);

							else {
								String message="\n";
								for(int i=0; i<activities.size();i++) {
									System.out.println(""+i);
									message=message.concat("Actividad "+(i+1)+": "+activities.get(i).getName()+"\n");
								}
								message=message.concat("\n");
								System.out.println(message);
								JOptionPane.showMessageDialog(frameLeisure.getFocusOwner(), message, "Listado actividades", JOptionPane.INFORMATION_MESSAGE);
								frameLeisure.dispatchEvent(new WindowEvent(frameLeisure, WindowEvent.WINDOW_CLOSING));
							}
						} catch (UnreadableException e2) {
							// TODO: handle exception
						}
						frame.getPanel().getButtonPleasure().setEnabled(true);
					}
				});
				frameLeisure.getBtnCancelar().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						frame.getPanel().getButtonPleasure().setEnabled(true);
						frameLeisure.dispatchEvent(new WindowEvent(frameLeisure, WindowEvent.WINDOW_CLOSING));
					}
				});
			}
		});
		
	}
	private String getCityName(Hotel hotel){
		String cityName="";
		Data data= new Data();
		for(int i=0; i<data.getCities().size(); i++) {
			for(int j=0; j<data.getCities().get(i).getHotels().size();j++) {
				if(data.getCities().get(i).getHotels().get(j).getName().equals(hotel.getName()))
					return data.getCities().get(i).getName();
			}
			
		}
		
		return cityName;
	}
 
}
