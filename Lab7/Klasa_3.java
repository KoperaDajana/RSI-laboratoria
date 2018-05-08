import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;

public class Klasa_3 extends Agent 
{
	public Klasa_3() {}

    protected void setup() {
        System.out.println("Startuje");
		addBehaviour(new CyclicBehaviour() {
			public void action() {
				System.out.println("Wykonuje");
			}
		});
        
		//doDelete();
		//System.out.println("Usunalem sie");	
    }
}
