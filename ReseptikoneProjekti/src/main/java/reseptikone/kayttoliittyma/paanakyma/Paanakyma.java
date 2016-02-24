package reseptikone.kayttoliittyma.paanakyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import reseptikone.logiikka.Kaappi;
import reseptikone.logiikka.tiedostojenkasittely.AinesosalistojenLukija;

/**
 * Ohjelman päänäkymä, jonka kautta käyttäjä voi tehdä asioita.
 *
 * @author vilma
 */
public class Paanakyma implements Runnable {

    private JFrame frame;
    private Kaappi kaappi;

    /**
     * Luo uuden kaappi-olion, johon käyttäjän kaapin sisältö syötetään.
     */
    public Paanakyma() {
        this.kaappi = new Kaappi();
    }

    /**
     * Määrittelee näkymän ja luo komponentit.
     * <p>
     * Komponentit: aloitusteksti, ainesosavalikko, painikkeet reseptin
     * etsimiseen, lisäämiseen, kaikkien reseptien listaamiseen, ja kaapin
     * tyhjentämiseen.
     */
    @Override
    public void run() {
        frame = new JFrame("Reseptinhakukone");
        frame.setPreferredSize(new Dimension(1300, 800));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel teksti = new JLabel("Tämä on reseptikone. Kerro kaappisi sisältö "
                + "ja kone antaa sinulle reseptin!\n");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_START;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        container.add(teksti, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        container.add(luoAinesosaValikko(), c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 2;
        container.add(luoAlavalikko(), c);
    }

    private JPanel luoAinesosaValikko() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        AinesosalistojenLukija lukija = new AinesosalistojenLukija();

        for (String ainesosaKategoria : lukija.getKaikkiAinesosaKategoriat()) {
            if (ainesosaKategoria.equals("kaikki")) {
                break;
            } else {
                panel.add(luoCheckBoxValikko(lukija, ainesosaKategoria));
            }
        }
        return panel;
    }

    private JPanel luoCheckBoxValikko(AinesosalistojenLukija lukija, String ainesosaKategoria) {
        JPanel panel = new JPanel();
        panel.add(new JLabel(ainesosaKategoria.toUpperCase() + ": "));
        for (String ainesosa : lukija.getAinesosaKategoria(ainesosaKategoria)) {
            JCheckBox checkbox = new JCheckBox(ainesosa);
            checkbox.addActionListener(new AinesosavalinnanKuuntelija(ainesosa, this.kaappi));
            panel.add(checkbox);
        }
        return panel;
    }

    private JPanel luoAlavalikko() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JButton etsiReseptiNappi = new JButton("etsi resepti!");
        etsiReseptiNappi.addActionListener(new EtsiReseptiNapinKuuntelija(this.kaappi));
        panel.add(etsiReseptiNappi);

        JButton listaaReseptitNappi = new JButton("listaa kaikki reseptit!");
        listaaReseptitNappi.addActionListener(new ListaaReseptitNapinKuuntelija());
        panel.add(listaaReseptitNappi);

        JButton lisaaReseptiNappi = new JButton("lisää oma reseptisi!");
        lisaaReseptiNappi.addActionListener(new ReseptinLisaysNakymanAvaaja());
        panel.add(lisaaReseptiNappi);

        JButton tyhjennaKaappiNappi = new JButton("poista valitut ainekset muistista");
        tyhjennaKaappiNappi.addActionListener(new TyhjennaKaappiNapinKuuntelija(kaappi, this.frame));
        panel.add(tyhjennaKaappiNappi);

        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
