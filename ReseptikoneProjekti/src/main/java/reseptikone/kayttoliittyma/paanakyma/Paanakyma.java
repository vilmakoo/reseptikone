package reseptikone.kayttoliittyma.paanakyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
        frame.setPreferredSize(new Dimension(1000, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(3, 1));

        JLabel teksti = new JLabel("Tämä on reseptikone. Kerro kaappisi sisältö "
                + "ja kone antaa sinulle reseptin! Voit myös saada listan kaikista resepteistä "
                + "tai lisätä omasi!");
        container.add(teksti);
        container.add(luoAinesosaValikko());
        container.add(luoAlavalikko());
    }

    private JPanel luoAinesosaValikko() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 6));
        AinesosalistojenLukija lukija = new AinesosalistojenLukija();

        for (String ainesosaKategoria : lukija.getKaikkiAinesosaKategoriat()) {
            if (ainesosaKategoria.equals("kaikki")) { // ei luoda erikseen kaikki ainesosat sisältävää listaa
                break;
            } else {
                panel.add(luoCheckBoxValikko(lukija, ainesosaKategoria));
            }
        }
        return panel;
    }

    // luodaan checkbox-valikko yhdelle ainesosakategorialle
    private JPanel luoCheckBoxValikko(AinesosalistojenLukija lukija, String ainesosaKategoria) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.PAGE_AXIS));

        for (String ainesosa : lukija.getAinesosaKategoria(ainesosaKategoria)) {
            JCheckBox checkbox = new JCheckBox(ainesosa);
            checkbox.addActionListener(new AinesosavalinnanKuuntelija(ainesosa, this.kaappi));
            lista.add(checkbox);
        }

        panel.add(new JLabel(ainesosaKategoria));

        JScrollPane scrollpane = new JScrollPane(lista);
        panel.add(scrollpane);

        return panel;
    }

    private JPanel luoAlavalikko() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        JButton etsiReseptiNappi = new JButton("etsi resepti!");
        etsiReseptiNappi.addActionListener(new EtsiReseptiNapinKuuntelija(this.kaappi));
        panel.add(etsiReseptiNappi);

        JButton listaaReseptitNappi = new JButton("listaa kaikki reseptit!");
        listaaReseptitNappi.addActionListener(new ListaaReseptitNapinKuuntelija());
        panel.add(listaaReseptitNappi);

        JButton lisaaReseptiNappi = new JButton("lisää oma reseptisi!");
        lisaaReseptiNappi.addActionListener(new ReseptinLisaysNakymanAvaaja());
        panel.add(lisaaReseptiNappi);

        JButton tyhjennaKaappiNappi = new JButton("tyhjennä ainesosat muistista");
        tyhjennaKaappiNappi.addActionListener(new TyhjennaKaappiNapinKuuntelija(kaappi, this.frame));
        panel.add(tyhjennaKaappiNappi);

        return panel;
    }
}
