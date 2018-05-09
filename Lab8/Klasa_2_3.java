import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.core.Agent;

public class Klasa_2_3 extends Agent
{
	protected void setup() {
		ParallelBehaviour parallelBehaviour = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
		parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
			public void action() {
				System.out.println("Pierwszy krok");
			}
		});

		parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
			public void action() {
				System.out.println("Drugi krok");
			}
		});
		
		parallelBehaviour.addSubBehaviour(new OneShotBehaviour() {
			public void action() {
				System.out.println("Trzeci krok");
			}
		});
		
		addBehaviour(parallelBehaviour);
	}
}