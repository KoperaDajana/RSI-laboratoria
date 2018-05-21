import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.*;


public class ag_odb extends Agent
{
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				ACLMessage msg = receive();
				if (msg != null) {
					if(msg.getPerformative() == ACLMessage.REQUEST) {
					//inform
						ACLMessage reply = msg.createReply();
						reply.setPerformative(ACLMessage.INFORM);
						reply.setContent("wykonalem");
						send(reply);
					}
					else 
						if(msg.getPerformative() == ACLMessage.CFP) {
					//request	
						System.out.println(msg.getContent());
						ACLMessage reply = msg.createReply();
						reply.setPerformative(ACLMessage.REQUEST);
						reply.setContent("raz jeszcze" );
						send(reply);
					}
					else {
					//inne
						ACLMessage reply = msg.createReply();
						reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
						reply.setContent("inne");
						send(reply);
					}
				}			
				block();
			}
		});
	}	
}