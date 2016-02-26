package reseptikone.logiikka.reseptinhaku;

import reseptikone.logiikka.tiedostojenkasittely.TiedostoonKirjoittaja;
import java.util.ArrayList;

/**
 * Luokka luo tiedostot reseptille ja kirjoittaa niihin ainesosat ja ohjeen.
 */
public class ReseptinLisaaja {

    private String polkuOhjeeseen;
    private String polkuAinesosiin;
    private String polkuReseptienNimiin;
    private TiedostoonKirjoittaja kirjoittaja;
    private String reseptinNimi;

    /**
     * Konstruktoria kutsuttaessa luodaan ReseptinLisaaja-olio.
     */
    public ReseptinLisaaja() {

    }

    /**
     * Metodi lisää reseptin reseptit-hakemistoon.
     * <p>
     * Metodille annetaan reseptin tiedot ja se kutsuu luokan metodeja, joiden
     * avulla luodaan polut luotaviin tiedostoihin ja kirjoitetaan tiedostoihin
     * ohje ja ainesosat ja lisätään reseptin nimi tiedostoon reseptienNimet.
     *
     * @param nimi reseptin nimi
     * @param ainesosat reseptin ainesosat listana
     * @param ohje reseptin ohje
     */
    public void lisaaResepti(String nimi, ArrayList<String> ainesosat, String ohje) {
        this.reseptinNimi = nimi;

        this.muodostaPolut();

        this.kirjoitaOhjeeseen(ohje);
        this.kirjoitaAinesosiin(ainesosat);
        this.kirjoitaReseptienNimiin();
    }

    // muodostaa polut reseptin ohje- ja aineosatiedostoon sekä reseptienNimiin
    // ja tallentaa ne oliomuuttujiin
    private void muodostaPolut() {
        this.polkuOhjeeseen = "reseptit/" + reseptinNimi + "Ohje.md";
        this.polkuAinesosiin = "reseptit/" + reseptinNimi + "Ainesosat.md";
        this.polkuReseptienNimiin = "reseptit/reseptienNimet.md";
    }

    // kirjoittaa ohjeen ohjetiedostoon
    private void kirjoitaOhjeeseen(String ohje) {
        this.kirjoittaja = new TiedostoonKirjoittaja(polkuOhjeeseen);
        this.kirjoittaja.kirjoita(ohje);
        this.kirjoittaja.suljeKirjoittaja();

    }

    // kirjoittaa ainesosat ainesosatiedostoon
    private void kirjoitaAinesosiin(ArrayList<String> ainesosat) {
        this.kirjoittaja = new TiedostoonKirjoittaja(polkuAinesosiin);
        for (String ainesosa : ainesosat) {
            this.kirjoittaja.kirjoita(ainesosa);
        }
        this.kirjoittaja.suljeKirjoittaja();
    }

    // lisää reseptin nimen muiden reseptien nimien joukkoon
    private void kirjoitaReseptienNimiin() {
        this.kirjoittaja = new TiedostoonKirjoittaja(polkuReseptienNimiin);
        this.kirjoittaja.kirjoita(reseptinNimi);
        this.kirjoittaja.suljeKirjoittaja();
    }
}
