package reseptikone.kayttoliittyma.reseptinlisaysnakyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import reseptikone.logiikka.tiedostojenkasittely.AinesosalistojenLukija;

/**
 * Täällä tapahtuu reseptin lisääminen.
 */
public class ReseptinLisaysNakyma implements Runnable {

    private JFrame frame;
    private String reseptinNimi;
    private ArrayList<String> reseptinAinesosat;
    private String ohje;

    public ReseptinLisaysNakyma() {
        reseptinAinesosat = new ArrayList<String>();
    }

    /**
     * Määrittelee näkymän ja luo komponentit.
     * <p>
     * Komponentit: reseptin nimikenttä, ainesosakenttä ja ohjekenttä sekä
     * painike reseptin lisäämiseen.
     */
    @Override
    public void run() {
        frame = new JFrame("Lisää resepti");
        frame.setPreferredSize(new Dimension(1300, 800));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(7, 2));

        JLabel reseptinNimiTeksti = new JLabel("Anna reseptin nimi:");
        JTextField reseptinNimiKentta = new JTextField();

        JLabel ainesosaTeksti = new JLabel("Valitse ainesosat:");
        JPanel ainesosaValikko = luoAinesosaValikko();
        JScrollPane scrollPane = new JScrollPane(ainesosaValikko);

        JLabel ohjeTeksti = new JLabel("Kirjoita ohje, sisältäen ainesosat ja niiden määrät:");
        JTextArea ohjeKentta = new JTextArea();

        JButton reseptinLisaysNappi = new JButton("Lisää resepti!");
        reseptinLisaysNappi.addActionListener(new LisaaReseptiNapinKuuntelija(reseptinNimiKentta, reseptinAinesosat, ohjeKentta, this.frame));

        JButton palaaTakaisinNappi = new JButton("Palaa takaisin");
        lisaaPalaaTakaisinNapinKuuntelija(palaaTakaisinNappi, this.frame);

        container.add(reseptinNimiTeksti);
        container.add(reseptinNimiKentta);
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(ainesosaTeksti);
        container.add(scrollPane);
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(ohjeTeksti);
        container.add(ohjeKentta);
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(reseptinLisaysNappi);
        container.add(palaaTakaisinNappi);
    }

    private JPanel luoAinesosaValikko() {
        JPanel panel = new JPanel();
        AinesosalistojenLukija lukija = new AinesosalistojenLukija();
        panel.setLayout(new GridLayout(lukija.getAinesosaKategoria("kaikki").size(), 0));

        for (String ainesosa : lukija.getAinesosaKategoria("kaikki")) {
            JCheckBox checkbox = new JCheckBox(ainesosa);
            lisaaValinnanKuuntelija(checkbox, ainesosa);
            panel.add(checkbox);
        }
        return panel;
    }

    private void lisaaValinnanKuuntelija(JCheckBox checkbox, final String ainesosa) {
        checkbox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                reseptinAinesosat.add(ainesosa);
            }

        });
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
