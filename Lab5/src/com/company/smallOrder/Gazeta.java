package com.company.smallOrder;

import java.io.Serializable;

public class Gazeta implements Serializable     //implementacja interfejsu Serializable na rzecz serializacji
{
    String nazwaGazety;
    long iloscStron = 0;

    public Gazeta (String nazwa, long ilosc) //stworzenie konstruktora sparametryzowanego dla Gazety
    {
        this.nazwaGazety = nazwa;
        this.iloscStron = ilosc;
    }

    //stworzenie metod, ktore umozliwiaja pobranie nazw poszczegolnych pol klasy
    public String getNazwaGazety() {
        return nazwaGazety;
    }

    public long getIloscStron() {
        return iloscStron;
    }

    //stworzenie metod, ktore umozliwiaja ustawienie nazw Klasy
    public void setNazwaGazety(String nazwaGazety) {
        this.nazwaGazety = nazwaGazety;
    }

    public void setIloscStron(long iloscStron) {
        this.iloscStron = iloscStron;
    }

    public void drukuj()
    {
        System.out.println("GAZETA: "+ nazwaGazety +" \nilosc stron: "+ iloscStron + "\n");
    }
}