import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.SimpleBehaviour;
import java.util.Scanner;

public class Klasa_6 extends Agent
{
	public Klasa_6() {}
	
	protected void setup() {
		System.out.println("Startuje");
		addBehaviour(new BehaviourNumber());
	
	}
}

class BehaviourNumber extends SimpleBehaviour
{
	boolean end; //sprawdza czy usunąć działanie - jeśli liczba jest ujemna
	int number; 
	
	public void action() {
		System.out.println("Zachowanie startuje");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj liczbe: ");
		number = scanner.nextInt();
		
		if(number < 0) {
			System.out.println("Liczba mniejsza od 0, usuwam zadanie");
			end = true;
		}
	}
	
	// oznajmia, że zrobione i usuwa się z listy zadań agenta
	public boolean done() {
		if(end) {
			System.out.println("Zachowanie zakończone");
		}
		return end;
	}
}	