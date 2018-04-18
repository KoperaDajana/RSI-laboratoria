import jade.core.Agent;

public class HelloAgent extends Agent
{
    protected void setup()
    {
        System.out.println("Hello World. ");
        System.out.println("My name is "+ getLocalName());
	    this.main(null);
    }
	
	public static void main(String[] args) {
        System.out.println("Print from Main");
    }

}

