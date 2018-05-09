import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.SequentialBehaviour;
import jade.core.Agent;

public class Klasa_2_4 extends Agent
{
	protected void setup() {
		SequentialBehaviour sequentialBehaviour = new SequentialBehaviour();
		sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
			public void action() {
				System.out.println("Pierwszy krok");
			}
		});

		sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
			public void action() {
				System.out.println("Drugi krok");
			}
		});
		
		sequentialBehaviour.addSubBehaviour(new OneShotBehaviour() {
			public void action() {
				System.out.println("Trzeci krok");
			}
		});
		
		addBehaviour(sequentialBehaviour);
	}
}