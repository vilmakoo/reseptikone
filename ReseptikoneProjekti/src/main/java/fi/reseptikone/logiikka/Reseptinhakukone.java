package fi.reseptikone.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reseptinhakukone {

//    private KaikkiAinesosat kaikkiAinesosat;
    private Scanner lukija;

    public Reseptinhakukone() {
//        this.kaikkiAinesosat = new KaikkiAinesosat();
    }

//    public List<String> listaKaikistaAinesosista() { // lista kaikista mahdollisista ainesosista
//        return this.kaikkiAinesosat.getKaikki();
//    }

    public String listaaReseptienNimet() throws FileNotFoundException { // listaa kaikkien reseptien nimet
        String lista = "";
        Scanner lukija = new Scanner(new File("reseptit/reseptienNimet.md"));
        while (lukija.hasNextLine()) {
            lista = lista + lukija.nextLine() + "\n";
        }
        return lista;
    }
    
    public void lisaaResepti(String nimi, ArrayList<String> ainesosat, String ohje) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String reseptinNimi = nimi;
        String polkuOhjeeseen = "reseptit/" + reseptinNimi + "Ohje.md";
        String polkuAinesosiin = "reseptit/" + reseptinNimi+ "Ainesosat.md";
        String polkuReseptienNimiin = "reseptit/reseptienNimet.md";
        
        PrintWriter kirjoitaOhjeeseen = new PrintWriter(polkuOhjeeseen, "UTF-8");
        PrintWriter kirjoitaAinesosiin = new PrintWriter(polkuAinesosiin, "UTF-8");
        PrintWriter kirjoitaReseptienNimiin = new PrintWriter(polkuReseptienNimiin, "UTF-8");
        
        kirjoitaOhjeeseen.println(ohje);
        
        for (String ainesosa : ainesosat) {
            kirjoitaAinesosiin.println(ainesosa);
        }
        
        kirjoitaReseptienNimiin.println(reseptinNimi);
        
        kirjoitaOhjeeseen.close();
        kirjoitaAinesosiin.close();
        kirjoitaReseptienNimiin.close();
    }

    public String tulostaKauppalista(Resepti resepti, ArrayList<String> kaapissaOlevatAinesosat) {
        Kauppalista kauppalista = new Kauppalista(resepti, kaapissaOlevatAinesosat);
        String lista = kauppalista.toString();
        return lista;
    }

    public void reseptinHaku() { // etsii resepteistä sellaisen, jossa on käyttäjän antamat ainesosat

    }

    public ArrayList<String> henkilonKaapissaOlevatAinekset() {
        Henkilo henkilo = new Henkilo();
        return henkilo.kerroKaapinSisalto();
    }
}
