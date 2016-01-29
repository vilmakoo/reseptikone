package fi.reseptikone.logiikka;

import java.util.ArrayList;

public class Reseptinhakukone {
    
    private ArrayList<Resepti> reseptit; // lista koneen sisältämistä resepteistä
    private ArrayList<Ainesosa> kaikkiAinesosat; //lista kaikista ainesosista
    
    public Reseptinhakukone() {
        this.reseptit = new ArrayList<Resepti>();
    }
    
    public String listaaReseptit() { // listaa koneen sisältämäien reseptien nimet
        ArrayList<String> reseptienNimet = new ArrayList<String>();
        for (Resepti resepti : this.reseptit) {
            reseptienNimet.add(resepti.getNimi());
        }
        String lista = "";
        for (String nimi : reseptienNimet) {
            lista = lista + nimi + "\n";
        }
        return lista;
    }
    
    public void lisaaResepti(String nimi, ArrayList<Ainesosa> ainesosat) { // käyttäjä voi lisätä reseptin koneeseen
        Resepti resepti = new Resepti(nimi, ainesosat);
        this.reseptit.add(resepti);
    }
    
    public void tulostaKauppalista(Resepti resepti, ArrayList<Ainesosa> kaapissaOlevatAinesosat) {
        Kauppalista kauppalista = new Kauppalista(resepti, kaapissaOlevatAinesosat);
        System.out.println(kauppalista.toString());
    }
    
    public void reseptinHaku() {
        // tulostaa kaikki ainesosat
        // käyttäjä syöttää kaapissaan olevat ainekset metodissa kaapissaOlevienAinestenSyotto
        // kone hakee reseptin jossa on tarvittavat ainekset
    }
    
    public ArrayList<Ainesosa> henkilonKaapissaOlevatAinekset() {
        Henkilo henkilo = new Henkilo();
        return henkilo.getKaapinSisalto();
    }
}
