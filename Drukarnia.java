import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class Drukarnia
{
    static Scanner scanner = new Scanner(System.in); //umozliwia wpisywanie danych przez uzytkownika

    public static void main(String[] args)
    {
        int typDruku;           //pozwala wybrac czy druk ma byc czb, czy w kolorze
        long iloscKopii = 0;    //ilosc kopii druku zarzadana przez klienta
        short format;           //wybor formatu A2/A3/A4 itp
        boolean exit = false;   //sprawdza czy program moze sie juz zakonczyc, domyslnie ustawione na false
        char [] pozegnanie = new char[] {'K', 'o', 'n', 'i', 'e', 'c', ' ', 'p', 'r', 'o', 'c', 'e', 's', 'u', '.'};
        int [][] indeksPolozenia = new int[10][10000];  //do okreslenia polozenia juz wydrukowanego zamowienia,
        // gdzie pierwszy indeks to ID drukarki, a kolejne polozenie wsrod innych zamowien z danej drukarki


        while(exit != true)
        {
            System.out.println("Witam! Proszę wybrać typ druku \n-1- czarno-bialy\n-2- kolorowy \nTwój wybór: ");
            typDruku = scanner.nextInt();

            if(typDruku == 1) {
                System.out.println("Wybrano czarno-biały druk");
                System.out.println("Podaj ilość kopii: ");
                iloscKopii = scanner.nextInt();
                System.out.println("Podaj format druku: \n1 - A4\n2 - B4\n3 - A3\n4 - B3");
                format = scanner.nextShort();
                switch(format) {
                    case 1:
                        System.out.println("Wybrano format A4, drukuję");
                        break;
                    case 2:
                        System.out.println("Wybrano format B4, drukuję");
                        break;
                    case 3:
                        System.out.println("Wybrano format A3, drukuję");
                        break;
                    case 4:
                        System.out.println("Wybrano format B3, drukuję");
                        break;
                    default:
                        System.out.println("Nieprawidłowo wprowadzone dane");
                        break;
                }

                exit = true;
                System.out.println(pozegnanie);
            }
            else if (typDruku == 2) {
                System.out.println("Wybrano kolorowy druk");
                System.out.println("Podaj ilość kopii: ");
                iloscKopii = scanner.nextInt();
                System.out.println("Podaj format druku: \n1 - A4\n2 - B4\n3 - A3\n4 - B3");
                format = scanner.nextShort();
                switch(format) {
                    case 1:
                        System.out.println("Wybrano format A4, drukuję");
                        break;
                    case 2:
                        System.out.println("Wybrano format B4, drukuję");
                        break;
                    case 3:
                        System.out.println("Wybrano format A3, drukuję");
                        break;
                    case 4:
                        System.out.println("Wybrano format B3, drukuję");
                        break;
                    default:
                        System.out.println("Nieprawidłowo wprowadzone dane ");
                        break;
                }

                exit = true;
                System.out.println(pozegnanie);
            }
            else {
                System.out.println("Nieprawidłowo wprowadzone dane");
            }
        }

    }
}
