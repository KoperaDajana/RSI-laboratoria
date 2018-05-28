import jade.core.Agent;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPANames;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.FIPAAgentManagement.Property;
import jade.core.behaviours.CyclicBehaviour;

import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class wykonawca extends Agent 
{
  DFAgentDescription dfAgentDescription;
  ServiceDescription serviceDescription;
  protected void setup() {
	try {
  		dfAgentDescription = new DFAgentDescription();
	    dfAgentDescription.setName(getAID()); 
	    serviceDescription = new ServiceDescription();
	    serviceDescription.setType("POTEGA");
	    serviceDescription.setName(getLocalName());
	    dfAgentDescription.addServices(serviceDescription);
	         
	    DFService.register(this, dfAgentDescription);   
  	} catch (FIPAException fe) {
  		fe.printStackTrace();
  	}
	
	//przygotowanie szablonu odbioru wiadomości
	MessageTemplate messageTemplate = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
	addBehaviour( new CyclicBehaviour() { //liczy potęgę
		public void action() {
			ACLMessage msg = blockingReceive(messageTemplate);
			if(msg != null) {
				System.out.println("Odebrano REQUEST msg: " + msg.getContent());
				Double number = Double.parseDouble(msg.getContent());
				
				if(number != null) {
					System.out.println("Wylosowano: " + (number));
					number = number * number;
					AID sender = msg.getSender();
				
					ACLMessage reply = msg.createReply();
					reply.setPerformative(ACLMessage.INFORM);
					reply.setContent(Double.toString(number));
					send(reply);
					
					doDelete();
				}
			}
		}
	});
	} 
  
	protected void takeDown() {
		try {
			DFService.deregister(this); 
			System.out.println("Wykonawca - usuwanie");
		} catch (Exception e) {}
		}
}