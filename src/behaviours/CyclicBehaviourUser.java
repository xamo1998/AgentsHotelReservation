package behaviours;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class CyclicBehaviourUser extends CyclicBehaviour{
	private String city;
	public CyclicBehaviourUser(Agent agent) {
		// TODO Auto-generated constructor stub
		super(agent);
	}	
	
	@Override
	public void action() {
		// TODO Auto-generated method stub
		ACLMessage message= this.myAgent.blockingReceive(MessageTemplate.and(MessageTemplate.MatchPerformative(ACLMessage.REQUEST), MessageTemplate.MatchOntology("ontologia")));
	}

}
