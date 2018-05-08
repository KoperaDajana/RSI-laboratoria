import jade.core.Agent;

public class Klasa_1 extends Agent 
{
	public Klasa_1() {}

    protected void setup() {
        System.out.println("Startuje");
        
		doDelete();
		System.out.println("Usunalem sie");	
    }

    public static void main(String[] var0) {
    }
}
