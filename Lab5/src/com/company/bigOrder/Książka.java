package com.company.bigOrder;


public class Książka
{
    String autor;
    String tytul;
    String wydawnictwo;
    long iloscStron;

    public Książka(String aut, String tyt, String wyd, long ilStr)
    {
        this.autor = aut;
        this.tytul = tyt;
        this.wydawnictwo = wyd;
        this.iloscStron = ilStr;
    }


    public void drukuj()
    {
        System.out.println("KSIĄŻKA: "+ autor +" \nTytuł: "+ tytul +" \nWydawnictwo: "+ wydawnictwo +" \nilosc " +
                "stron: " + iloscStron + "\n");
    }
}
