package reseptikone.kayttoliittyma.paanakyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import reseptikone.kayttoliittyma.reseptinakymat.ReseptiNakyma;
import reseptikone.logiikka.Kaappi;
import reseptikone.logiikka.Kauppalista;
import reseptikone.logiikka.reseptinhaku.Resepti;
import reseptikone.logiikka.reseptinhaku.ReseptinEtsija;

/**
 * Tapahtumankuuntelija reseptin etsintää varten.
 */
public class EtsiReseptiNapinKuuntelija implements ActionListener {

    private Kaappi kaappi;

    /**
     * Alustaa oliomuuttujan kaappi.
     *
     * @param kaappi käyttäjän kaappi
     */
    public EtsiReseptiNapinKuuntelija(Kaappi kaappi) {
        this.kaappi = kaappi;
    }

    /**
     * Nappia painettaessa etsii reseptin.
     *
     * @param e napin painallus
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        etsiResepti();
    }

    private void etsiResepti() {
        ReseptinEtsija etsija = new ReseptinEtsija(this.kaappi);
        Resepti resepti = etsija.etsiKayttajanKaapissaOlevaResepti();
        if (resepti != null) {
            ReseptiNakyma reseptinNayttaja = new ReseptiNakyma(resepti, null);
            SwingUtilities.invokeLater(reseptinNayttaja);
        } else {
            resepti = etsija.etsiSeuraavaksiOptimaalisinResepti();
            Kauppalista kauppalista = new Kauppalista(resepti, this.kaappi.getSisalto());
            ReseptiNakyma reseptinNayttaja = new ReseptiNakyma(resepti, kauppalista);
            SwingUtilities.invokeLater(reseptinNayttaja);
        }

    }

}
