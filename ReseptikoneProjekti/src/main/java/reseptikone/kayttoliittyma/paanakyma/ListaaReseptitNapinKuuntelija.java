package reseptikone.kayttoliittyma.paanakyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import reseptikone.kayttoliittyma.reseptinakymat.KaikkiReseptitNakyma;
import reseptikone.logiikka.reseptinhaku.Resepti;
import reseptikone.logiikka.tiedostojenkasittely.TiedostonLukija;

/**
 * Tapahtumankuuntelija kaikkien reseptien listaamista varten.
 */
public class ListaaReseptitNapinKuuntelija implements ActionListener {

    private TiedostonLukija lukija;
    private ArrayList<Resepti> reseptit;

    /**
     * Luo tiedostonlukijan, jolle annetaan parametrina reseptiennimet-tiedosto,
     * ja luo ArrayListin resepteille.
     */
    public ListaaReseptitNapinKuuntelija() {
        this.lukija = new TiedostonLukija(new File("reseptit/reseptienNimet.md"));
        this.reseptit = new ArrayList<Resepti>();
        listaaReseptit();
    }

    private void listaaReseptit() {
        for (String reseptinNimi : this.lukija.palautaTiedostoListana()) {
            Resepti resepti = new Resepti(reseptinNimi);
            reseptit.add(resepti);
        }
    }

    /**
     * Nappia painettaessa luodaan näkymä, joka sisältää kaikki reseptit
     * listana.
     *
     * @param e napin painallus
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        KaikkiReseptitNakyma nakyma = new KaikkiReseptitNakyma(reseptit);
        SwingUtilities.invokeLater(nakyma);
    }
}
