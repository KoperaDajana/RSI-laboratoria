import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.AMSService;
import jade.domain.FIPAAgentManagement.*;
import jade.lang.acl.*;
import java.util.Random;

public class ag_pl extends Agent
{
	protected void setup() {
		addBehaviour(new CyclicBehaviour(this) {
			public void action() {
				MessageTemplate message = MessageTemplate.MatchLanguage("polski");
				ACLMessage messageMSG = receive(message);
				if(messageMSG != null) {
					System.out.println(messageMSG.getContent());
				}
				else
					block();
			}
		});
	}
}