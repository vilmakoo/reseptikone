package reseptikone.kayttoliittyma.reseptinakymat;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
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
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(reseptit.size() + 2, 1));

        for (Resepti resepti : this.reseptit) {
            JButton reseptiNappi = new JButton(resepti.getNimi());
            reseptiNappi.addActionListener(new ReseptiNapinKuuntelija(resepti));
            container.add(reseptiNappi);
        }

        container.add(new JLabel(""));

        JButton palaaTakaisinNappi = new JButton("Palaa takaisin");
        lisaaPalaaTakaisinNapinKuuntelija(palaaTakaisinNappi, this.frame);
        container.add(palaaTakaisinNappi);
    }

    private void lisaaPalaaTakaisinNapinKuuntelija(JButton nappi, final JFrame frame) {
        nappi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }

        });
    }
}
