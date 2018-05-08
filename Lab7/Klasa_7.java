import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;

public class Klasa_7 extends Agent
{
	public Klasa_7() {}
	
	protected void setup() {
		System.out.println("Startuje");
		addBehaviour(new BehaviourKroki(this));
		addBehaviour(new Behaviour1(this));  //a
		
	}
}



class Behaviour1 extends OneShotBehaviour 
{
	public Behaviour1(Agent a) {
		super(a);
	}
	
	public void action() {
		System.out.println("Klasa_7. Pierwsze");
	}
}

class Behaviour2 extends OneShotBehaviour 
{
	public Behaviour2(Agent a) {
		super(a);
	}
	
	public void action() {
		System.out.println("Klasa_7. Drugie");
	}
}



class BehaviourKroki extends Behaviour
{
	private int krok = 1;
	Agent pom;
	
	public BehaviourKroki(Agent a) {
		super(a);
		pom = a;
	}
	
	public void action() {
		switch (krok) {
			case 1:
				pom.addBehaviour(new Behaviour2(pom));		//b
				System.out.println("Pierwszy krok");
				krok++;
				break;
			
			case 2:
				System.out.println("Drugi krok");
				krok++;
				break;
				
			case 3:
				System.out.println("Trzeci krok");
				krok++;
				break;
		}
	}
	
	// oznajmia, że zrobione i usuwa się z listy zadań agenta
	public boolean done() {
		return krok == 4;
	}
}	