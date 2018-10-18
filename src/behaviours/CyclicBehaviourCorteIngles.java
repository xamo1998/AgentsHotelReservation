package behaviours;

import java.io.IOException;
import java.io.Serializable;

import data.ReservationData;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.FIPAAgentManagement.Envelope;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.lang.acl.UnreadableException;

public class CyclicBehaviourCorteIngles extends CyclicBehaviour{
	
	public CyclicBehaviourCorteIngles(Agent agent) {
		// TODO Auto-generated constructor stub
		super(agent);
	}
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage msg=this.myAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
		try {
			ReservationData dataRecieved = (ReservationData) msg.getContentObject();
			System.out.println("Soy corte ingles\n");
			System.out.println("City: "+dataRecieved.getCityName()+"\nStart day: "+dataRecieved.getStart()+"\nEnd day: "+dataRecieved.getEnd());
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
			try {
				aclMessage.setContentObject("Todo correcto\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.myAgent.send(aclMessage);
		} catch (UnreadableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
