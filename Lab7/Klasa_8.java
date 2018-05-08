import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class Klasa_8 extends Agent 
{
	public Klasa_8() {}

    protected void setup() {
        System.out.println("Startuje");
        
		addBehaviour(new SmallTick(this));
		
		BigTick bigTick = new BigTick(this);
		addBehaviour(bigTick);
		
		//doDelete();
		//System.out.println("Usunalem sie");	
		
		addBehaviour(new TickerBehaviour(this, 50000) {
			protected void onTick() {
			System.out.println("c) Usuwam zachowanie");
			removeBehaviour(bigTick);
			}
		});
		 
		addBehaviour(new TickerBehaviour(this, 100000) {
			protected void onTick() {
			System.out.println("d) Usuwam agenta");
			doDelete();
			}
		});
	}
}


class SmallTick extends TickerBehaviour
{
	public SmallTick(Agent a) {
		super(a, 2000);
	}

	protected void onTick() {
		System.out.println("Maly tick");
	}
}


class BigTick extends TickerBehaviour
{
	public BigTick(Agent a) {
		super(a, 5000);
	}

	protected void onTick() {
		System.out.println("DUZY TICK");
	}
}