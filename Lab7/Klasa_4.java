import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Klasa_4 extends Agent
{
	public Klasa_4() {}
	
	protected void setup() {
		System.out.println("Startuje");
		addBehaviour(new BehaviourKroki());
		
	}
}

class BehaviourKroki extends Behaviour
{
	private int krok = 1;
	public void action() {
		switch (krok) {
			case 1:
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