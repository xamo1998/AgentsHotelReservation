package agents;

import behaviours.CyclicBehaviourAccommodation;
import data.Data;
import jade.content.lang.sl.SLCodec;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class AccommodationAgent extends Agent{
	@Override
	protected void setup() {
		// TODO Auto-generated method stub
		DFAgentDescription dfd=new DFAgentDescription();
		dfd.setName(getAID());

		ServiceDescription sd=new ServiceDescription();
		sd.setName("Reservar");
		sd.setType(Data.ACCOMMODATION_TYPE);
		sd.addOntologies(Data.ONTOLOGY);
		sd.addLanguages(new SLCodec().getName());	
		dfd.addServices(sd);
		try {
			DFService.register(this,dfd);
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addBehaviour(new CyclicBehaviourAccommodation(this));
	}
}
