package reseptikone.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import reseptikone.logiikka.Kaappi;
import reseptikone.logiikka.tiedostojenkasittely.AinesosalistojenLukija;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Kaappi kaappi;

    public Kayttoliittyma() {
        this.kaappi = new Kaappi();
    }

    @Override
    public void run() {
        frame = new JFrame("Reseptinhakukone");
        frame.setPreferredSize(new Dimension(800, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JLabel teksti = new JLabel("Tämä on reseptikone. Kerro kaappisi sisältö "
                + "ja kone antaa sinulle reseptin!\n");
        container.add(teksti, BorderLayout.NORTH);

        container.add(luoAinesosaValikko(), BorderLayout.WEST);

        JButton etsiReseptiNappi = new JButton("etsi resepti!");
        etsiReseptiNappi.addActionListener(new EtsiReseptiNapinKuuntelija(this.kaappi));
        container.add(etsiReseptiNappi, BorderLayout.PAGE_END);
    }

    private JPanel luoAinesosaValikko() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        AinesosalistojenLukija lukija = new AinesosalistojenLukija();

        for (String ainesosaKategoria : lukija.getKaikkiAinesosaKategoriat()) {
            if (ainesosaKategoria.equals("kaikki")) {
                break;
            } else {
                panel.add(luoCheckBoxValikko(ainesosaKategoria));
            }
        }
        return panel;
    }

    private JPanel luoCheckBoxValikko(String ainesosaKategoria) {
        JPanel panel = new JPanel();
        AinesosalistojenLukija lukija = new AinesosalistojenLukija();
        panel.add(new JLabel(ainesosaKategoria.toUpperCase() + ": "));
        for (String ainesosa : lukija.getAinesosaKategoria(ainesosaKategoria)) {
            JCheckBox checkbox = new JCheckBox(ainesosa);
            checkbox.addActionListener(new AinesosavalinnanKuuntelija(ainesosa, this.kaappi));
            panel.add(checkbox);
        }
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
