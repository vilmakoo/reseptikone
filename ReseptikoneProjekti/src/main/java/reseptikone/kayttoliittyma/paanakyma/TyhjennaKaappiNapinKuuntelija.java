package reseptikone.kayttoliittyma.paanakyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import reseptikone.logiikka.Kaappi;

/**
 * Kuuntelija kaapin sisällön poistamiselle, jolloin voi etsiä uuden reseptin.
 *
 * @author vilma
 */
public class TyhjennaKaappiNapinKuuntelija implements ActionListener {

    private Kaappi kaappi;
    private JFrame frame;

    /**
     * Konstruktoria kutsumalla luodaan kuuntelija.
     *
     * @param kaappi käyttäjän kaappi
     * @param frame päänäkymän frame
     */
    public TyhjennaKaappiNapinKuuntelija(Kaappi kaappi, JFrame frame) {
        this.kaappi = kaappi;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kaappi.tyhjennaKaappi();
        JOptionPane.showMessageDialog(frame,
                "Done!",
                "Ilmoitus",
                JOptionPane.PLAIN_MESSAGE);
    }

}
