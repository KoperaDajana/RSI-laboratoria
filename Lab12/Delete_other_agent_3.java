import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.proto.AchieveREInitiator;
import jade.domain.*;
import jade.domain.JADEAgentManagement.*;
import jade.content.onto.basic.*;

public class Delete_other_agent_3 extends Agent 
{
	public void setup() {

		getContentManager().registerLanguage(new jade.content.lang.sl.SLCodec(0));
		getContentManager().registerOntology(JADEManagementOntology.getInstance());

		CreateAgent ca = new CreateAgent();
		ca.setAgentName("john");
		ca.setClassName("jade.core.Agent"); //jade.core.Agent
		ca.setContainer(new ContainerID("Main-Container", null));

		Action actExpr = new Action(getAMS(), ca);

		ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
		request.addReceiver(getAMS());
		request.setOntology(JADEManagementOntology.getInstance().getName());
		request.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
		request.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
		try {
			getContentManager().fillContent(request, actExpr);
			addBehaviour(new AchieveREInitiator(this, request) {
				protected void handleInform(ACLMessage inform) {
					System.out.println("Agent successfully created");
				}
				protected void handleFailure(ACLMessage failure) {
					System.out.println("Error creating agent.\n"+failure);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}



		//Usuwanie utworzonego agenta
		addBehaviour(new WakerBehaviour(this, 2000) {
			protected void onWake() {
				KillAgent kill = new KillAgent();
				kill.setAgent(new AID("john", AID.ISLOCALNAME));
				Action act = new Action();
				act.setActor(getAMS());
				act.setAction(kill);
    
				ACLMessage req = new ACLMessage(ACLMessage.REQUEST);
				req.clearAllReceiver();
				req.addReceiver(getAMS());
				req.setOntology(JADEManagementOntology.NAME);
				req.setSender(getAID());
				req.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
				req.setProtocol(FIPANames.InteractionProtocol.FIPA_REQUEST);
				try {
					System.out.println("Deleting agent 'john'");
					getContentManager().fillContent(req, act);
					send(req);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}