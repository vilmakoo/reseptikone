package reseptikone.kayttoliittyma.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import reseptikone.logiikka.reseptinhaku.ReseptinLisaaja;

/**
 * Tapahtumankuuntelija reseptin lisäämistä varten.
 * <p>
 * Ei tee vielä mitään.
 */
public class LisaaReseptiNapinKuuntelija implements ActionListener {

    private String nimi;
    private ArrayList<String> ainesosat;
    private String ohje;
    private ReseptinLisaaja lisaaja;

    /**
     * Alustaa oliomuuttujat nimi ja ohje ja muodostaa listan ainesosista.
     * @param nimi reseptin nimi
     * @param ainesosat reseptin ainesosat
     * @param ohje reseptin ohje
     */
    public LisaaReseptiNapinKuuntelija(String nimi, ArrayList<String> ainesosat, String ohje) {
        this.nimi = nimi;
        this.ohje = ohje;
        this.ainesosat = ainesosat;
        this.lisaaja = new ReseptinLisaaja();
    }

    /**
     * Nappia painettaessa lisää reseptin koneeseen.
     *
     * @param e napin painallus
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        lisaaResepti();
    }

    private void lisaaResepti() {
        lisaaja.lisaaResepti(nimi, ainesosat, ohje);
    }

}
