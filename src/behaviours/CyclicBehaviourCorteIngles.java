package behaviours;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import data.Activitie;
import data.Data;
import data.Hotel;
import data.MessageData;
import helpers.Utils;
import jade.content.lang.sl.SLCodec;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.Envelope;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class CyclicBehaviourCorteIngles extends CyclicBehaviour{
	private Queue<AID> idsAccommodation, idsLeisure;
	public CyclicBehaviourCorteIngles(Agent agent) {
		// TODO Auto-generated constructor stub
		super(agent);
		idsAccommodation=new LinkedList<>();
		idsLeisure=new LinkedList<>();
	}
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msg=this.myAgent.blockingReceive();
		System.out.println("CI: Me ha llegado peticion");
		if(msg.getConversationId()!=null && msg.getConversationId().equals(Data.ACCOMMODATION_TYPE)) {
			System.out.println("CI: Recibo respuesta");
			Hotel hotelRecieved=null;
			try {
				hotelRecieved = (Hotel) msg.getContentObject();
			} catch (UnreadableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);    	
	   		aclMessage.addReceiver(idsAccommodation.poll());
	        aclMessage.setOntology("ontologia");
	        //el lenguaje que se define para el servicio
	        aclMessage.setLanguage(new SLCodec().getName());
	        //el mensaje se transmita en XML
	        aclMessage.setEnvelope(new Envelope());
			//cambio la codificacion de la carta
			aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
	        //aclMessage.getEnvelope().setAclRepresentation(FIPANames.ACLCodec.XML); 
			try {
				aclMessage.setContentObject((Serializable)hotelRecieved);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("CI: Envio respuesta");
			this.myAgent.send(aclMessage);
		}else if (msg.getConversationId()!=null && msg.getConversationId().equals(Data.LEISURE_TYPE)) {
			ArrayList<Activitie> activities=new ArrayList<>();
			try {
				activities = (ArrayList<Activitie>) msg.getContentObject();
			} catch (UnreadableException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);    	
	   		aclMessage.addReceiver(idsLeisure.poll());
	        aclMessage.setOntology("ontologia");
	        //el lenguaje que se define para el servicio
	        aclMessage.setLanguage(new SLCodec().getName());
	        //el mensaje se transmita en XML
	        aclMessage.setEnvelope(new Envelope());
			//cambio la codificacion de la carta
			aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
	        //aclMessage.getEnvelope().setAclRepresentation(FIPANames.ACLCodec.XML); 
			try {
				aclMessage.setContentObject((Serializable)activities);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("CI: Envio respuesta");
			this.myAgent.send(aclMessage);
		}
		else {
			try {
				MessageData dataRecieved = (MessageData) msg.getContentObject();
				if(dataRecieved.getType().equals(Data.ACCOMMODATION_TYPE_CORTE_INGLES)) {
					idsAccommodation.add(msg.getSender());
					Utils.enviarMensaje(myAgent, Data.ACCOMMODATION_TYPE, dataRecieved);
					
				}
				else if(dataRecieved.getType().equals(Data.LEISURE_TYPE_CORTE_INGLES)){
					idsLeisure.add(msg.getSender());
					Utils.enviarMensaje(myAgent, Data.LEISURE_TYPE, dataRecieved);	
				}
			} catch (UnreadableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
