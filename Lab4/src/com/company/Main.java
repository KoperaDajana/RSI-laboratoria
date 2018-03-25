package com.company;

import com.company.bigOrder.Książka;        //zaimportowanie Książki
import com.company.smallOrder.Plakat;        //zaimportowanie klasy Plakat


public class Main
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

    //stworzenie konstruktora Main
    public Main (int typ, long ilosc, short form) {
        this.typDruku = typ;
        this.iloscKopii = ilosc;
        this.format = form;
    }

    public static void main(String[] args) throws MyException
    {
        System.out.println("DRUKARNIA - tworzenie obiektow: \n");

        //użycie klasy Gazeta bez wcześniejszego jej importowania
        com.company.smallOrder.Gazeta gazeta = new com.company.smallOrder.Gazeta("Vogule", 15); //stworzenie gazety
        gazeta.drukuj();


        //try {
            Książka ksiazka = new Książka("Andrzej Piaseczny", "Piasek w naturze", "Nowa Era", 140);
            //if(ksiazka.ilStr == 0)
            ksiazka.drukuj();

          //  } catch (){

        //}

        Plakat plakat = new Plakat("Madonna 1996", 120, "A2");
        plakat.getIloscStron(); //sprawdzanie rozszerzenia klasy Plakat przez metody klasy Gazeta
        plakat.drukuj();

        System.out.println("Sprawdzenie roszczerzenia klas dla klasy 'Plakat': \nużycie dziedziczonej metody " +
               "'getIloscStron' z klasy 'Gazeta': \n" + plakat.getIloscStron() + "\n");


        // obsługa wyjątków - stworzenie bloku try catch dla sprawdzenia obecnosci tuszu w drukarce
        // jesli obecny - wypisuje komunikat, jeśli nie rzuca wyjątek, który korzysta z własnej stworzonej klasy obslugi
        // MyException, wypisuje komunikat i wychodząc z bloku wyjatek jest łapany przez catch, ktory nastepnie wypisuje
        // komunikat o nazwie wyjatku
        boolean obecnoscTuszuDrukarki = false;       //tuszu nie ma
        try{
            if(obecnoscTuszuDrukarki){
                System.out.println("Tusz obecny w drukarce przechodze do drukowania.");
            }
            else {
                System.out.println("Błąd.");
                throw new MyException("Zgłoszenie braku tuszu w drukarce");
            }
        } catch (MyException ex) {
                System.out.println(ex.toString());
        }

    }
}


// utworzenie wlasnej klasy wątków i przykład jej użycia
class MyException extends Exception {

    public MyException(String string1) {
        super(string1);
    }
}