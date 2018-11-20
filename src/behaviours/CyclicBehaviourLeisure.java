package behaviours;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import data.Activitie;
import data.Data;
import data.Hotel;
import data.MessageData;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.Envelope;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class CyclicBehaviourLeisure extends CyclicBehaviour{
	private Data data;
	public CyclicBehaviourLeisure(Agent agent) {
		// TODO Auto-generated constructor stub
		super(agent);
		data=new Data();
	}
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msg=this.myAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
		System.out.println("AC: Me ha llegado peticion");
		try {
			MessageData data = (MessageData) msg.getContentObject();
			//Enviamos confirmacion
			ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);    	
	   		aclMessage.addReceiver(msg.getSender());
	        aclMessage.setOntology("ontologia");
	        //el lenguaje que se define para el servicio
	        aclMessage.setLanguage(new SLCodec().getName());
	        //el mensaje se transmita en XML
	        aclMessage.setEnvelope(new Envelope());
			//cambio la codificacion de la carta
			aclMessage.getEnvelope().setPayloadEncoding("ISO8859_1");
	        //aclMessage.getEnvelope().setAclRepresentation(FIPANames.ACLCodec.XML); 
			ArrayList<Activitie> activities= checkActivities(data);
			try {
				aclMessage.setContentObject((Serializable) activities);
				aclMessage.setConversationId(Data.LEISURE_TYPE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("AC: Envio inform");
			this.myAgent.send(aclMessage);
			
		} catch (UnreadableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private ArrayList<Activitie> checkActivities(MessageData dataMessage) {
		// TODO Auto-generated method stub
		ArrayList<Activitie> activities = new ArrayList<>();
		for(int i=0; i<data.getCities().size(); i++) {  //Recorremos ciudades
			if(data.getCities().get(i).getName().equals(dataMessage.getCityName())) {
				for(int j=0; j<data.getCities().get(i).getActivities().size(); j++) { //Recorremos Hoteles
					if(checkAvailability(data.getCities().get(i).getActivities().get(j),dataMessage)) { //Comprobamos hoteles
						activities.add(data.getCities().get(i).getActivities().get(j));
					}
				}
			}
		}
		return activities;
	}
	private boolean checkAvailability(Activitie activitie, MessageData dataMessage) {
		// TODO Auto-generated method stub
		if(activitie.getCalendar()[dataMessage.getStart()]) 
			return true;
		return false;
	}

}
