import jade.core.*;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREInitiator;
import jade.util.leap.Iterator;
import jade.util.leap.List;
import jade.wrapper.ContainerController;
import jade.domain.*;
import jade.domain.JADEAgentManagement.*;
import jade.domain.mobility.MobileAgentDescription;
import jade.domain.mobility.MobilityOntology;
import jade.domain.mobility.MoveAction;
import jade.content.ContentElement;
import jade.content.lang.Codec.CodecException;
import jade.content.onto.OntologyException;
import jade.content.onto.UngroundedException;
import jade.content.onto.basic.*;
import java.util.Random;

public class Lottery_5 extends Agent 
{
	Random random;
	int number;
	public void setup() {
		random = new Random();
		number = 0;

		//Sprawdzanie kontenerów
		addBehaviour(new TickerBehaviour(this, 20000) { 
			protected void onTick() {
				getContentManager().registerLanguage(new jade.content.lang.sl.SLCodec(0));
				getContentManager().registerOntology(JADEManagementOntology.getInstance());
				//Zapytanie o kontenery
				QueryPlatformLocationsAction query = new QueryPlatformLocationsAction();
				Action action = new Action(getAID(),query);
			
				try {
					number++;
					ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
					msg.addReceiver(getAMS());
					msg.setLanguage(FIPANames.ContentLanguage.FIPA_SL0);
					msg.setOntology(JADEManagementOntology.getInstance().getName());
					getContentManager().fillContent(msg, action);
					send(msg);
				} catch(CodecException e) {
					e.printStackTrace();
				} catch(OntologyException e) {
					e.printStackTrace();
				}
		
				//Odbieranie informacji o kontenerach
				try {
					ACLMessage received = blockingReceive(MessageTemplate.MatchSender(getAMS()));
					ContentElement content = getContentManager().extractContent(received);
					Result result = (Result) content;
					List listOfPlatforms = (List) result.getValue();
			
					Iterator iterator = listOfPlatforms.iterator();
					//int rand = (int)Math.round(random.nextDouble()*listOfPlatforms.size()); //losowanie nr
					int rand = random.nextInt((int)listOfPlatforms.size()) + 1;
					int x = 0;
					System.out.println("Found cointainers x" + number + ": ");
					while(iterator.hasNext()) {
						x++;
						ContainerID next = (ContainerID) iterator.next();
						System.out.println("- " + next.getName());	
						if(x == rand) {
							doMove(next);
							System.out.println("Agent moved");
						}
					}
				} catch(UngroundedException e) {
					e.printStackTrace();
				} catch(CodecException e) {
					e.printStackTrace();
				} catch(OntologyException e) {
					e.printStackTrace();
				}
			}
		});
	}
}