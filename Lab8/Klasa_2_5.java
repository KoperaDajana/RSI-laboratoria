import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;

public class Klasa_2_5 extends Agent
{	
	protected void setup() {
		System.out.println("Start");
		
		ParallelBehaviour parallelBehaviour = new ParallelBehaviour();
		
		parallelBehaviour.addSubBehaviour(new CyclicBehaviour(this) {
			public void action() {
				System.out.println("Cyclic 1");
			}
		});
		
		parallelBehaviour.addSubBehaviour(new CyclicBehaviour(this) {
			public void action() {
				System.out.println("Cyclic 2");
			}
		});
		
		addBehaviour(parallelBehaviour);
	}
}