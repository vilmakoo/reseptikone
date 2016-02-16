package reseptikone.kayttoliittyma;

import java.util.ArrayList;
import java.util.Scanner;
import reseptikone.logiikka.Kaappi;
import reseptikone.logiikka.Kauppalista;
import reseptikone.logiikka.reseptinhaku.Resepti;
import reseptikone.logiikka.reseptinhaku.ReseptinEtsija;
import reseptikone.logiikka.tiedostojenkasittely.AinesosalistojenLukija;

public class TekstiKayttoliittyma {
    
    private AinesosalistojenLukija ainesosat;
    private Scanner lukija;
    private Kaappi kayttajanKaappi;

    // Toimii tällä hetkellä vain, jos käyttäjällä on kaapissaan kaikki ainesosat johonkin reseptiin.
    // esim appelsiini banaani maitorahka mustikka ja soijajuoma
    public TekstiKayttoliittyma() {
        ainesosat = new AinesosalistojenLukija();
        lukija = new Scanner(System.in);
    }
    
    public void suorita() {
        tulostaInfo();
        tulostaAinesosat();
        lueKayttajanValitsematAinesosat();
        
        System.out.println("");
        
        etsiResepti();
        
    }
    
    public void tulostaInfo() {
        System.out.println("Tämä on reseptikone. Kerro jääkaappisi sisältö ja "
                + "saat reseptin.");
    }
    
    public void tulostaAinesosat() {
        System.out.println("\nValittavissa olevat ainesosat ovat:\n");
        for (String ainesosa : ainesosat.getAinesosaKategoria("kaikki")) {
            System.out.println(ainesosa);
        }
    }
    
    public void lueKayttajanValitsematAinesosat() {
        System.out.println("\nValitse kaapissasi olevat ainesosat. Lopeta kirjoittamalla 'loppu'");
        kayttajanKaappi = new Kaappi();
        while (true) {
            String kayttajanKirjoittamaAsia = lukija.nextLine();
            if (kayttajanKirjoittamaAsia.equals("loppu")) {
                break;
            } else {
                kayttajanKaappi.lisaaAinesKaappiin(kayttajanKirjoittamaAsia);
            }
        }
    }
    
    public void etsiResepti() {
        ReseptinEtsija reseptinEtsija = new ReseptinEtsija(kayttajanKaappi);
        Resepti saatuResepti = reseptinEtsija.etsiKayttajanKaapissaOlevaResepti();
        
        if (saatuResepti == null) {
            saatuResepti = reseptinEtsija.etsiSeuraavaksiOptimaalisinResepti();
            System.out.println("Kaappisi sisällöstä ei saa suoraan aikaiseksi mitään ruokalajia.");
            System.out.println("Sait kuitenkin reseptin:");
            tulostaResepti(saatuResepti);
            System.out.println("\nKaapistasi puuttuu vielä (eli osta nämä):");
            Kauppalista kauppalista = new Kauppalista(saatuResepti, kayttajanKaappi.getSisalto());
            System.out.println(kauppalista.toString());
        } else {
            System.out.println("Sait reseptiksi:");
            tulostaResepti(saatuResepti);
        }
    }
    
    public void tulostaResepti(Resepti resepti) {
        System.out.println(resepti.getNimi());
            System.out.println("");
            System.out.println("Ohje:");
            System.out.println(resepti);
    }
}
