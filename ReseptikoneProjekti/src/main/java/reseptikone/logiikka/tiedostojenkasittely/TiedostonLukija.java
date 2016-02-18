package reseptikone.logiikka.tiedostojenkasittely;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka sisältää tiedostonlukemiseen liittyviä metodeja.
 */
public class TiedostonLukija {

    private Scanner lukija;

    /**
     * Konstruktori luo uuden Scanner-olion, jonka avulla luetaan parametrina
     * saatua tiedostoa.
     *
     * @param tiedosto tiedosto, joka halutaan lukea
     */
    public TiedostonLukija(File tiedosto) {
        try {
            this.lukija = new Scanner(tiedosto, "UTF-8");
        } catch (Exception e) {
            System.out.println("Tapahtui virhe yritettäessä lukea tiedostoa, jota ei ole." + e);
        }
    }

    /**
     * Metodi lukee tiedoston sisällön ja muodostaa siitä merkkijonon.
     *
     * @return tiedoston sisältämä teksti
     */
    public String palautaTiedostoMerkkijonona() {
        String teksti = "";
        while (lukija.hasNextLine()) {
            teksti += lukija.nextLine() + "\n";
        }
        return teksti;
    }

    /**
     * Erillinen metodi listoja sisältävien tiedostojen (esimerkiksi ainesosa
     * tiedostojen) lukemiseen.
     * <p>
     * Luetaan tiedoston sisältö ja muodostetaan ArrayList.
     *
     * @return lista
     */
    public ArrayList<String> palautaTiedostoListana() {
        ArrayList<String> lista = new ArrayList<String>();
        while (this.lukija.hasNextLine()) {
            String rivi = this.lukija.nextLine();
            lista.add(rivi);
        }
        return lista;
    }

    /**
     * Sulkee scannerin.
     */
    public void suljeLukija() {
        lukija.close();
    }
}
