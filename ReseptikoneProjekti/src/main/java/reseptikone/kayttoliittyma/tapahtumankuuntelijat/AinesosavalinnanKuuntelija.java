package reseptikone.kayttoliittyma.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reseptikone.logiikka.Kaappi;

/**
 * Tapahtumankuuntelija ainesosien valintaa varten.
 */
public class AinesosavalinnanKuuntelija implements ActionListener {

    private Kaappi kaappi;
    private String ainesosa;

    /**
     * Alustaa oliomuuttujat kaappi ja ainesosa.
     * 
     * @param ainesosa valittu ainesosa
     * @param kaappi käyttäjän kaappi
     */
    public AinesosavalinnanKuuntelija(String ainesosa, Kaappi kaappi) {
        this.kaappi = kaappi;
        this.ainesosa = ainesosa;
    }

    /**
     * Painiketta painettaessa kuuntelija lisää valitun aineksen konstruktorin
     * parametrina saamaansa kaappiin.
     * @param e napin painallus
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        this.kaappi.lisaaAinesKaappiin(ainesosa);
    }

}
