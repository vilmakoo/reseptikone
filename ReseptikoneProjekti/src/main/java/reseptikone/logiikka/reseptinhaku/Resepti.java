package reseptikone.logiikka.reseptinhaku;

import reseptikone.logiikka.tiedostojenkasittely.TiedostonLukija;
import java.io.File;
import java.util.ArrayList;

/**
 * Luokka, joka sisältää tiedot reseptistä (nimen, ainesosat ja ohjeen).
 */
public class Resepti {
    
    private String nimi;
    private ArrayList<String> ainesosat;
    private String ohje;
    private TiedostonLukija ohjeenLukija;
    private TiedostonLukija ainesosienLukija;
    private String polkuOhjeeseen;
    private String polkuAinesosiin;
    
    /**
     * Konstruktori luo resepti-olion.
     * <p>
     * Konstruktorille annetaan reseptin nimi ja se kutsuu muodostaResepti-metodia,
     * joka lukee reseptin tiedot tiedostoista.
     * 
     * @param reseptinNimi reseptin nimi merkkijonona.
     */
    public Resepti(String reseptinNimi) {
        this.nimi = reseptinNimi;
        this.muodostaResepti(); // eli luetaan reseptitiedostoista ohje ja ainesosat
    }
    
    private void muodostaResepti() {
        this.muodostaTiedostoPolut();
        this.muodostaListaAinesosista();
        this.muodostaOhje();
    }
    
    private void muodostaTiedostoPolut() {
        this.polkuOhjeeseen = "reseptit/" + this.nimi + "Ohje.md";
        this.polkuAinesosiin = "reseptit/" + this.nimi + "Ainesosat.md";
    }
    
    private void muodostaListaAinesosista() {
        this.ainesosienLukija = new TiedostonLukija(new File(polkuAinesosiin));
        this.ainesosat = this.ainesosienLukija.palautaTiedostoListana();
    }
    
    private void muodostaOhje() {
        this.ohjeenLukija = new TiedostonLukija(new File(polkuOhjeeseen));
        this.ohje = this.ohjeenLukija.palautaTiedostoMerkkijonona();
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public ArrayList<String> getAinesosat() { //palauttaa listan ainesosista
        return this.ainesosat;
    }
    
    /**
     * Palauttaa reseptin merkkijonona eli käytännössä ohje-tiedostosta luetun
     * ohjeen, joka sisältää myös reseptin ainesosat.
     * 
     * @return reseptin ohje
     */
    @Override
    public String toString() {
        return this.ohje;
    }
}
