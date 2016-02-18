package reseptikone.kayttoliittyma.nakymat;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import reseptikone.kayttoliittyma.tapahtumankuuntelijat.ReseptiNapinKuuntelija;
import reseptikone.logiikka.reseptinhaku.Resepti;

/**
 * Lista kaikista resepteistä.
 */
public class KaikkiReseptitNakyma implements Runnable {

    private ArrayList<Resepti> reseptit;
    private JFrame frame;

    /**
     * Luo kaikki reseptit sisältävän ArrayListin.
     *
     * @param reseptit lista kaikista resepteistä
     */
    public KaikkiReseptitNakyma(ArrayList<Resepti> reseptit) {
        this.reseptit = reseptit;
    }

    /**
     * Määrittelee näkymän ja luo komponentit.
     */
    @Override
    public void run() {
        frame = new JFrame("Kaikki reseptit");
        frame.setPreferredSize(new Dimension(800, 500));

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(reseptit.size(), 1));

        for (Resepti resepti : this.reseptit) {
            JButton reseptiNappi = new JButton(resepti.getNimi());
            reseptiNappi.addActionListener(new ReseptiNapinKuuntelija(resepti));
            container.add(reseptiNappi);
        }
    }

}
