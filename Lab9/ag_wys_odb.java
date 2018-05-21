import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.*;
import java.util.Random;
import jade.core.AID;

public class ag_wys_odb extends Agent
{
	protected void setup() {
		System.out.println("ag_wys_odb");
		addBehaviour(new Behaviour1());
		addBehaviour(new Behaviour2());
	}
	
	private class Behaviour1 extends OneShotBehaviour {
		public void action() {
			int i = (int)(Math.random()*2);
	
			if (i == 0) {
				ACLMessage message = new ACLMessage(ACLMessage.CFP);
				message.setContent("Komunikat typu CFP");
				message.addReceiver(new AID("Ala", false));
				send(message);
			} else {
				ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
				message.setContent("Komunikat typu Request");
				message.addReceiver(new AID("Ala", false));
				send(message);
			}
		}
	}
	
	private class Behaviour2 extends CyclicBehaviour {
		public void action() {
			ACLMessage message = receive();
			if (message != null) {
				System.out.println(message.getContent()); 	//wypisanie na ekranie
				if(message.getPerformative() == ACLMessage.INFORM) {
					System.out.println("Typ inform -> usuwanie");
					this.myAgent.doDelete();
				} else {
					this.myAgent.addBehaviour(new Behaviour1());
				}
			}
		}
	}
}