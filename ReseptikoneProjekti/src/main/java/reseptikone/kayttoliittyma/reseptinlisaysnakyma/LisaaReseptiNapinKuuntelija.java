package reseptikone.kayttoliittyma.reseptinlisaysnakyma;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import reseptikone.logiikka.reseptinhaku.ReseptinLisaaja;
import reseptikone.logiikka.tiedostojenkasittely.TiedostonLukija;

/**
 * Tapahtumankuuntelija reseptin lisäämistä varten.
 * <p>
 * Ei tee vielä mitään.
 */
public class LisaaReseptiNapinKuuntelija implements ActionListener {

    private JTextField nimiKentta;
    private ArrayList<String> ainesosat;
    private JTextArea ohjeKentta;
    private ReseptinLisaaja lisaaja;
    private TiedostonLukija lukija;
    private JFrame frame;

    /**
     * Alustaa oliomuuttujat nimi ja ohje ja muodostaa listan ainesosista.
     *
     * @param nimiKentta reseptinlisäysnäkymässä oleva kenttä, johon nimi
     * kirjoitetaan
     * @param ainesosat reseptin ainesosat
     * @param ohjeKentta reseptinlisäysnäkymässä oleva kenttä, johon ohje
     * kirjoitetaan
     * @param frame reseptinlisäysnäkymän frame, tarvitaan dialogi-ikkunoiden
     * näyttämiseen
     */
    public LisaaReseptiNapinKuuntelija(JTextField nimiKentta, ArrayList<String> ainesosat, JTextArea ohjeKentta, JFrame frame) {
        this.nimiKentta = nimiKentta;
        this.ohjeKentta = ohjeKentta;
        this.ainesosat = ainesosat;
        this.lisaaja = new ReseptinLisaaja();
        lukija = new TiedostonLukija(new File("reseptit/reseptienNimet.md"));
        this.frame = frame;
    }

    /**
     * Nappia painettaessa lisää reseptin koneeseen.
     *
     * @param e napin painallus
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (nimiKentta.getText().isEmpty() || lukija.palautaTiedostoMerkkijonona().contains(nimiKentta.getText())) {
            JOptionPane.showMessageDialog(frame,
                    "Resepti tarvitsee uniikin nimen!",
                    "Virhe!",
                    JOptionPane.ERROR_MESSAGE);
        } else if (ainesosat.isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    "Resepti tarvitsee ainesosia!",
                    "Virhe!",
                    JOptionPane.ERROR_MESSAGE);
        } else if (ohjeKentta.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    "Resepti tarvitsee ohjeen!",
                    "Virhe!",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            lisaaResepti();
            JOptionPane.showMessageDialog(frame,
                    "Done!",
                    "Ilmoitus",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void lisaaResepti() {
        String nimi = nimiKentta.getText();
        String ohje = ohjeKentta.getText();
        lisaaja.lisaaResepti(nimi, ainesosat, ohje);
    }
}
