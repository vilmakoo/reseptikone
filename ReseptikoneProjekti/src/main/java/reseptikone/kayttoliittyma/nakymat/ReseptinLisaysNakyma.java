package reseptikone.kayttoliittyma.nakymat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import reseptikone.kayttoliittyma.tapahtumankuuntelijat.LisaaReseptiNapinKuuntelija;

/**
 * Täällä tapahtuu reseptin lisääminen.
 */
public class ReseptinLisaysNakyma implements Runnable {

    private JFrame frame;
    private String reseptinNimi;
    private String ainesosat;
    private String ohje;

    /**
     * Määrittelee näkymän ja luo komponentit.
     * <p>
     * Komponentit: reseptin nimikenttä, ainesosakenttä ja ohjekenttä sekä
     * painike reseptin lisäämiseen.
     */
    @Override
    public void run() {
        frame = new JFrame("Lisää resepti");
        frame.setPreferredSize(new Dimension(800, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(luoReseptinLisaysKentat(), BorderLayout.CENTER);

        JButton reseptinLisaysNappi = new JButton("Lisää resepti!");
        reseptinLisaysNappi.addActionListener(new LisaaReseptiNapinKuuntelija(reseptinNimi, ainesosat, ohje));
        container.add(reseptinLisaysNappi, BorderLayout.SOUTH);
    }

    private JPanel luoReseptinLisaysKentat() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        JLabel reseptinNimiTeksti = new JLabel("Anna reseptin nimi:");
        JTextField reseptinNimiKentta = new JTextField();
        JTextArea ainesosatKentta = new JTextArea(); // ennemminki joku lista josta voi valita
        JLabel ohjeTeksti = new JLabel("Kirjoita ohje, sisältäen ainesosat ja niiden määrät:");
        JTextArea ohjeKentta = new JTextArea();

        reseptinNimi = reseptinNimiKentta.getText();
        ainesosat = ainesosatKentta.getText();
        ohje = ohjeKentta.getText();

        panel.add(reseptinNimiTeksti);
        panel.add(reseptinNimiKentta);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(ainesosatTeksti());
        panel.add(ainesosatKentta);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(ohjeTeksti);
        panel.add(ohjeKentta);

        return panel;
    }

    // erillinen JPanel, jotta koko teksti näkyisi
    private JPanel ainesosatTeksti() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        JLabel alku = new JLabel("Luettele ainesosat (yksikössä, ilman");
        JLabel loppu = new JLabel("määriä, yksi ainesosa per rivi):");
        panel.add(alku);
        panel.add(loppu);
        return panel;
    }

}
