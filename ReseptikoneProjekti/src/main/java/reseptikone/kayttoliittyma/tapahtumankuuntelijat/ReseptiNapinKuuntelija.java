package reseptikone.kayttoliittyma.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import reseptikone.kayttoliittyma.nakymat.ReseptiNakyma;
import reseptikone.logiikka.reseptinhaku.Resepti;

/**
 * Tapahtumankuuntelija reseptin näkemistä varten.
 * <p>
 * Resepti-napit ovat KaikkiReseptitNakymassa.
 */
public class ReseptiNapinKuuntelija implements ActionListener {

    private Resepti resepti;

    /**
     * Alustaa oliomuuttujan resepti.
     *
     * @param resepti resepti joka halutaan nähdä
     */
    public ReseptiNapinKuuntelija(Resepti resepti) {
        this.resepti = resepti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        naytaResepti();
    }

    private void naytaResepti() {
        ReseptiNakyma nayttaja = new ReseptiNakyma(resepti, null);
        SwingUtilities.invokeLater(nayttaja);
    }

}
