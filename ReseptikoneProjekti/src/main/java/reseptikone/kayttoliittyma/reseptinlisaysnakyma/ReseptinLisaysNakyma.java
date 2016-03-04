package reseptikone.kayttoliittyma.reseptinlisaysnakyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
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
 * Täällä annetaan reseptin lisäämiseen tarvittavat tiedot.
 */
public class ReseptinLisaysNakyma implements Runnable {

    private JFrame frame;
    private ArrayList<String> reseptinAinesosat;
    private JTextField reseptinNimiKentta;
    private JTextArea ohjeKentta;

    /**
     * Luo ArrayListin reseptin ainesosia varten.
     */
    public ReseptinLisaysNakyma() {
        reseptinAinesosat = new ArrayList<String>();
    }

    /**
     * Määrittelee näkymän ja luo komponentit.
     * <p>
     * Komponentit: reseptin nimikenttä, ainesosakenttä ja ohjekenttä sekä
     * painike reseptin lisäämiseen ja takaisin palaamiseen.
     */
    @Override
    public void run() {
        frame = new JFrame("Lisää resepti");
        frame.setPreferredSize(new Dimension(1000, 600));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(5, 0));
        
        container.add(reseptinNimiKentat());
        container.add(new JLabel("Valitse ainesosat:"));
        container.add(ainesosaKentat());
        container.add(ohjeKentat());
        container.add(alavalikko());
    }

    private JPanel reseptinNimiKentat() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        JLabel reseptinNimiTeksti = new JLabel("Anna reseptin nimi:");
        reseptinNimiKentta = new JTextField();

        panel.add(reseptinNimiTeksti);
        panel.add(reseptinNimiKentta);

        return panel;
    }

    private JPanel ainesosaKentat() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 6));

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
    
    private JPanel ohjeKentat() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        
        JLabel ohjeTeksti = new JLabel("Kirjoita ohje, sisältäen ainesosat ja niiden määrät:");
        ohjeKentta = new JTextArea();
        
        panel.add(ohjeTeksti);
        panel.add(ohjeKentta);
        
        return panel;
    }
    
    private JPanel alavalikko() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        
        JButton reseptinLisaysNappi = new JButton("Lisää resepti!");
        reseptinLisaysNappi.addActionListener(new LisaaReseptiNapinKuuntelija(reseptinNimiKentta, reseptinAinesosat, ohjeKentta, this.frame));

        JButton palaaTakaisinNappi = new JButton("Palaa takaisin");
        lisaaPalaaTakaisinNapinKuuntelija(palaaTakaisinNappi, this.frame);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(reseptinLisaysNappi);
        panel.add(palaaTakaisinNappi);
        
        return panel;
    }

    // luodaan checkbox-valikot samalla tavalla, kuin päänäkymässäkin
    private JPanel luoCheckBoxValikko(AinesosalistojenLukija lukija, String ainesosaKategoria) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        JPanel lista = new JPanel();
        lista.setLayout(new BoxLayout(lista, BoxLayout.PAGE_AXIS));

        for (String ainesosa : lukija.getAinesosaKategoria(ainesosaKategoria)) {
            JCheckBox checkbox = new JCheckBox(ainesosa);
            lisaaValinnanKuuntelija(checkbox, ainesosa);
            lista.add(checkbox);
        }

        panel.add(new JLabel(ainesosaKategoria));

        JScrollPane scrollpane = new JScrollPane(lista);
        panel.add(scrollpane);

        return panel;
    }

    // lisää actionlistenerin ainesosa-checkboxeille
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
