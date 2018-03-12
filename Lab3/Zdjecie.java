public class Zdjecie
{
    String rodzajPapieru;
    String format;

    public Zdjecie (String format, String rodzajP)
    {
        this.format = format;
        this.rodzajPapieru = rodzajP;
    }

    public void drukuj()
    {
        System.out.println("ZDJĘCIE: \nformat: " + format + "\nrodzaj papieru: " + rodzajPapieru + "\n");
    }
}
