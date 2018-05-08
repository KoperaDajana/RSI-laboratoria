import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Klasa_2 extends Agent 
{
	public Klasa_2() {}

    protected void setup() {
        System.out.println("Startuje");
		addBehaviour(new BehaviourOneShot(this));
        
		//doDelete();
		//System.out.println("Usunalem sie");	
    }
}

class BehaviourOneShot extends OneShotBehaviour
{
    public BehaviourOneShot(Agent a)
    {
        super(a);
    }

    public void action()
    {
        System.out.println("Wykonuje");
    }
}

   // public static void main(String[] var0) {
   // }