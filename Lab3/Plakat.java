public class Plakat extends Gazeta //klasa plakat dziedziczy po gazecie
{
    String format;

    public Plakat(String nazwaPlakatu, long kopia, String format)
    {
        super(nazwaPlakatu, kopia);
        this.format = format;
    }


    public void drukuj()
    {
        System.out.println("PLAKAT: " + nazwaGazety + " \nilosc: " + iloscStron + " \nformat: " + format + "\n");
    }
}
