import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Lab3
{
   // static Scanner scanner = new Scanner(System.in); //umozliwia wpisywanie danych przez uzytkownika
    int typDruku;           //pozwala wybrac czy druk ma byc czb, czy w kolorze
    long iloscKopii = 0;    //ilosc kopii druku zarzadana przez klienta
    short format;           //wybor formatu A2/A3/A4 itp
    boolean exit = false;   //sprawdza czy program moze sie juz zakonczyc, domyslnie ustawione na false
    char [] pozegnanie = new char[] {'K', 'o', 'n', 'i', 'e', 'c', ' ', 'p', 'r', 'o', 'c', 'e', 's', 'u', '.'};
    int [][] indeksPolozenia = new int[10][10000];  //do okreslenia polozenia juz wydrukowanego zamowienia,
    // gdzie pierwszy indeks to ID drukarki, a kolejne polozenie wsrod innych zamowien z danej drukarki


    //stworzenie abstrakcyjnej klasy z abstrakcyjnym obiektem
    public abstract class MyAbstractClass
    {
        abstract void myMethod();
    }

    //stworzenie konstruktora Lab3
    public Lab3 (int typ, long ilosc, short form) {
        this.typDruku = typ;
        this.iloscKopii = ilosc;
        this.format = form;
    }

    public static void main(String[] args)
    {
        System.out.println("DRUKARNIA - tworzenie obiektow: \n");

        Gazeta gazeta = new Gazeta("Vogule", 15); //stworzenie gazety
        gazeta.drukuj();

        Książka ksiazka = new Książka("Andrzej Piaseczny", "Piasek w naturze", "Nowa Era", 140);
        ksiazka.drukuj();

        Plakat plakat = new Plakat("Madonna 1996", 120, "A2");
        plakat.getIloscStron(); //sprawdzanie rozszerzenia klasy Plakat przez metody klasy Gazeta
        plakat.drukuj();

        System.out.println("Sprawdzenie roszczerzenia klas dla klasy 'Plakat': \nużycie dziedziczonej metody " +
                "'getIloscStron' z klasy 'Gazeta': \n" + plakat.getIloscStron() + "\n");

        Zdjecie zdjecie = new Zdjecie("A5", "fotograficzny błysk");
        zdjecie.drukuj();
    }
}
