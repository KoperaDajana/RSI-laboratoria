package com.company;

import com.company.bigOrder.Książka;
import com.company.smallOrder.Plakat;

import java.io.*;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main extends File
{
    int typDruku;           //pozwala wybrac czy druk ma byc czb, czy w kolorze
    long iloscKopii = 0;    //ilosc kopii druku zarzadana przez klienta
    short format;           //wybor formatu A2/A3/A4 itp
    boolean exit = false;   //sprawdza czy program moze sie juz zakonczyc, domyslnie ustawione na false
    char [] pozegnanie = new char[] {'K', 'o', 'n', 'i', 'e', 'c', ' ', 'p', 'r', 'o', 'c', 'e', 's', 'u', '.'};
    int [][] indeksPolozenia = new int[10][10000];  //do okreslenia polozenia juz wydrukowanego zamowienia,
    // gdzie pierwszy indeks to ID drukarki, a kolejne polozenie wsrod innych zamowien z danej drukarki

    static Scanner scanner = new Scanner(System.in); //umozliwia wpisywanie danych przez uzytkownika


    public Main(String s){ super(s); }


    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("DRUKARNIA - tworzenie obiektow: \n");

        // wprowadzanie z klawiatury------------------------------------------------------------------------------------
        int n;
        System.out.println("Podaj ilość kopii dla Gazet: ");
        n = scanner.nextInt();

        for(int i=0; i<n; i++){
            //użycie klasy Gazeta bez wcześniejszego jej importowania
            com.company.smallOrder.Gazeta gazeta = new com.company.smallOrder.Gazeta("Vogule", 15); //stworzenie gazety
            gazeta.drukuj();
        }

        // zapis danych do pliku tekstowego-----------------------------------------------------------------------------
        PrintWriter zapis = new PrintWriter("Zapis.txt");
        Książka ksiazka = new Książka("Andrzej Piaseczny", "Piasek w naturze", "Nowa Era", 140);
        ksiazka.drukuj();
        zapis.println(ksiazka);
        zapis.close();



        // odczyt z pliku, który zawiera zmiennoprzecinkowe liczby------------------------------------------------------
        System.out.println("Odczyt z pliku zawierający liczby przecinkowe: ");
//        File plik = new File("C:/Users/Dajana/Documents/IO/Semestr VI/Rozproszona sztuczna " +
//                "inteligencja/Ćwiczenia/L5/Zmiennoprzecinkowe.txt");
//        Scanner odczyt = new Scanner(new File("C:/Users/Dajana/Documents/IO/Semestr VI/Rozproszona sztuczna " +
//                "inteligencja/Ćwiczenia/L5/Zmiennoprzecinkowe.txt")); //"Zmiennoprzecinkowe.txt"));
//        double liczbyOdczyt = odczyt.nextDouble();
//        System.out.println(liczbyOdczyt + "\n");
        try {
            FileInputStream fileInputStream = new FileInputStream("C:/Users/Dajana/Documents/IO/Semestr VI/Rozproszona sztuczna " +
                "inteligencja/Ćwiczenia/Lab5/Zmiennoprzecinkowe.txt");

            // Odczytywanie jednego bajtu z pliku
            int b = fileInputStream.read();

            while(b != -1) {            // dopóki jest bajt
                // Rzutowanie na typ znakowy
                System.out.print((char) b);
                b = fileInputStream.read();
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("\n");


        // serializacja ------------------------------------------------------------------------------------------------
        Plakat plakat = new Plakat("Madonna 1996", 120, "A2");
        //plakat.getIloscStron(); //sprawdzanie rozszerzenia klasy Plakat przez metody klasy Gazeta
        //plakat.drukuj();

        // zapis do pliku
        PrintWriter zapisSerial = new PrintWriter("PlakatSerial.txt");
        zapisSerial.println(plakat.getIloscStron() + plakat.getNazwaGazety());
        zapisSerial.close();
       // System.out.println("Sprawdzenie roszczerzenia klas dla klasy 'Plakat': \nużycie dziedziczonej metody " +
              // "'getIloscStron' z klasy 'Gazeta': \n" + plakat.getIloscStron() + "\n");


        //odczyt z pliku zapisany w wyniku serializacji
        File file = new File("PlakatSerial.txt");
        Scanner in = new Scanner(file);

        String odczytSerial = in.nextLine();
        System.out.println(odczytSerial + "\n");


        System.out.println("Sprawdzam tusz w drukarce...");
        // obsługa wyjątków - lab4
        boolean obecnoscTuszuDrukarki = false;       //tuszu nie ma
        try{
            if(obecnoscTuszuDrukarki){
                System.out.println("Tusz obecny w drukarce, przechodze do drukowania...");
            }
            else {
                throw new MyException("Błąd -------> Zgłoszenie braku tuszu");
            }
        } catch (MyException ex) {
                System.out.println(ex);
        }
    }
}


// utworzenie wlasnej klasy wątków i przykład jej użycia
class MyException extends Exception {

    public MyException(String string1) {
        super(string1);
    }
}