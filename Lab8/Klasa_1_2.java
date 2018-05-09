import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.FSMBehaviour;


public class Klasa_1_2 extends Agent
{
	private static final String STATE_A = "A";
	private static final String STATE_B = "B";
	private static final String STATE_C = "C";
	private static final String STATE_D = "D";
	private static final String STATE_E = "E";
	private static final String STATE_F = "F";
	
	protected void setup() {
		FSMBehaviour fsmBehaviour = new FSMBehaviour(this) {
			public int onEnd() {
				System.out.println("Koniec");
				myAgent.doDelete();
				return super.onEnd();
			}
		};
		
		
		fsmBehaviour.registerFirstState(new NamePrinter(), STATE_A);
		fsmBehaviour.registerState(new RandomGenerator(2), STATE_B);
		fsmBehaviour.registerState(new NamePrinter(), STATE_C);
		fsmBehaviour.registerState(new RandomGenerator(2), STATE_D);
		fsmBehaviour.registerLastState(new NamePrinter(), STATE_E);
	
		fsmBehaviour.registerDefaultTransition(STATE_A, STATE_B);
		fsmBehaviour.registerTransition(STATE_B, STATE_D, 0);
		fsmBehaviour.registerTransition(STATE_B, STATE_C, 1);
		fsmBehaviour.registerDefaultTransition(STATE_C, STATE_D);
		fsmBehaviour.registerTransition(STATE_D, STATE_A, 1);
		fsmBehaviour.registerTransition(STATE_D, STATE_E, 0);
		
		addBehaviour(fsmBehaviour);
	}
	
	
	private class NamePrinter extends OneShotBehaviour 
	{
		public void action() {
			System.out.println("Zachowanie " + getBehaviourName());
		}
	}
	
	
	private class RandomGenerator extends NamePrinter 
	{
		private int maxExitValue;
		private int exitValue;
		
		private RandomGenerator(int max) {
			super();
			maxExitValue = max;
		}
		
		public void action() {
			System.out.println("Zachowanie " + getBehaviourName());
			exitValue = (int)(Math.random() * maxExitValue);
			System.out.println("Wylosowano " + exitValue);
		}
		
		public int onEnd() {
			return exitValue;
		}
	}
}