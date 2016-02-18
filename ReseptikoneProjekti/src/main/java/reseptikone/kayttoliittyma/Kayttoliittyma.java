package reseptikone.kayttoliittyma;

import java.awt.BorderLayout;
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
        c.gridy = 3;
        container.add(luoAinesosaValikko(), c);

        JButton etsiReseptiNappi = new JButton("etsi resepti!");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END;
        c.gridwidth = 1;
        c.gridx = 2;
        c.gridy = 6;
        etsiReseptiNappi.addActionListener(new EtsiReseptiNapinKuuntelija(this.kaappi));
        container.add(etsiReseptiNappi, c);
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
