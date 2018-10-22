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
	private Queue<AID> ids;
	public CyclicBehaviourCorteIngles(Agent agent) {
		// TODO Auto-generated constructor stub
		super(agent);
		ids=new LinkedList<>();
	}
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msg=this.myAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
		System.out.println("CI: Me ha llegado peticion");
		ids.add(msg.getSender());
		try {
			MessageData dataRecieved = (MessageData) msg.getContentObject();
			if(dataRecieved.getType().equals(Data.ACCOMMODATION_TYPE_CORTE_INGLES)) {
				Utils.enviarMensaje(myAgent, Data.ACCOMMODATION_TYPE, dataRecieved);
				ACLMessage msgRecieved=myAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("ontologia")));
				System.out.println("CI: Recibo respuesta");
				Hotel hotelRecieved= (Hotel) msgRecieved.getContentObject();
				
				ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);    	
		   		aclMessage.addReceiver(ids.poll());
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
			}
			else {
				System.out.println("CI: Recibo LEISURE");
				Utils.enviarMensaje(myAgent, Data.LEISURE_TYPE, dataRecieved);
				ACLMessage msgRecieved=myAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.INFORM), MessageTemplate.MatchOntology("ontologia")));
				System.out.println("CI: Recibo respuesta");
				ArrayList<Activitie> activities= (ArrayList<Activitie>) msgRecieved.getContentObject();
				
				ACLMessage aclMessage = new ACLMessage(ACLMessage.INFORM);    	
		   		aclMessage.addReceiver(ids.poll());
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
			
		} catch (UnreadableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
