import jade.core.Agent;

public class HelloWorldAgent extends Agent{

	protected void setup()
	{
		Object[] obj = getArguments();
		int licznik = Integer.parseInt(obj[0].toString());
		System.out.println("Passed argument = "+licznik);
		for(int i=0;i<licznik;i++)
			System.out.println("Test Agenta : "+i);
	}
}
