package fi.reseptikone.logiikka;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reseptinhakukone {

//    private KaikkiReseptit reseptit; // lista koneen sisältämistä resepteistä
    private KaikkiAinesosat kaikkiAinesosat;
    private Scanner lukija;

    public Reseptinhakukone() {
//        this.reseptit = new KaikkiReseptit();
        this.kaikkiAinesosat = new KaikkiAinesosat();
        this.lukija = new Scanner(System.in);
    }

    public List<String> listaKaikistaAinesosista() { // lista kaikista mahdollisista ainesosista
        return this.kaikkiAinesosat.getKaikki();
    }

//    public String listaaReseptienNimet() { // listaa koneen sisältämäien reseptien nimet
//        String lista = "";
//        for (String nimi : this.reseptit.getReseptienNimet()) {
//            lista = lista + nimi + "\n";
//        }
//        return lista;
//    }
    
//    public void lisaaResepti() { // käyttäjä voi lisätä reseptin koneeseen
//        
//    }

    public void tulostaKauppalista(Resepti resepti, ArrayList<Ainesosa> kaapissaOlevatAinesosat) {
        Kauppalista kauppalista = new Kauppalista(resepti, kaapissaOlevatAinesosat);
        System.out.println(kauppalista.toString());
    }

    public void reseptinHaku() { // etsii resepteistä sellaisen, jossa on käyttäjän antamat ainesosat

    }

    public ArrayList<Ainesosa> henkilonKaapissaOlevatAinekset() {
        Henkilo henkilo = new Henkilo();
        return henkilo.kerroKaapinSisalto();
    }
}
