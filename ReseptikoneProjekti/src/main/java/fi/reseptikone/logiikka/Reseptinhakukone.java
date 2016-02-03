package fi.reseptikone.logiikka;

import java.util.ArrayList;
import java.util.List;

public class Reseptinhakukone {
    
    private KaikkiReseptit reseptit; // lista koneen sisältämistä resepteistä
    private KaikkiAinesosat kaikkiAinesosat;
    
    public Reseptinhakukone() {
        this.reseptit = new KaikkiReseptit();
        this.kaikkiAinesosat = new KaikkiAinesosat();
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
    
    public void lisaaResepti(String nimi, ArrayList<Ainesosa> ainesosat, String ohje) { // käyttäjä voi lisätä reseptin koneeseen
        Resepti resepti = new Resepti(nimi, ainesosat, ohje);
        this.reseptit.lisaaResepti(resepti);
    }
    
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
