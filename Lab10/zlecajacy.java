import java.util.Random;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

public class zlecajacy extends Agent
{
	zlecajacy myAgent;
		
	protected void setup() {
		myAgent = this;
		Random generator = new Random();
		int number;
	
		number = (int)(Math.round(generator.nextDouble() * 100));
		System.out.println("Wylosowano: " + number);
				
		addBehaviour(new TickerBehaviour(this, 2000) {
		    protected void onTick() {
				System.out.println("Wyszukiwanie POTEGA");
		        DFAgentDescription dfAgentDescription = new DFAgentDescription();
		        ServiceDescription serviceDescription = new ServiceDescription();
		        serviceDescription.setType("POTEGA");
		        dfAgentDescription.addServices(serviceDescription);
				  
		        SearchConstraints ALL = new SearchConstraints();
		        
				try {
		            DFAgentDescription[] result = DFService.search(myAgent, dfAgentDescription, ALL);
		            System.out.println("Trafienia: " + result.length);
		            if(result.length > 0) {
						System.out.println("Wysylanie");
						ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
						msg.addReceiver(result[0].getName());
						msg.setContent(Integer.toString(number));
						send(msg);
						
						ACLMessage msg2 = blockingReceive(MessageTemplate.MatchPerformative(ACLMessage.INFORM));
						if(msg2 != null) {
							System.out.println("Odebrano wiadomosc: " + msg2.getContent());						
							myAgent.doDelete();
						} else {
							block();
						}
					}
				} catch (FIPAException fe) { 
					System.out.println("Blad"); 
				}
			}
		 });
	}
	
	
	protected void takeDown() {
		System.out.println("Zlecajacy - usuwanie");
	}
}