package reseptikone.kayttoliittyma.nakymat;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import reseptikone.logiikka.Kauppalista;
import reseptikone.logiikka.reseptinhaku.Resepti;

/**
 * Näyttää reseptin.
 */
public class ReseptiNakyma implements Runnable {

    private JFrame frame;
    private Resepti resepti;
    private Kauppalista kauppalista;

    /**
     * Saa resepti-, ja kauppalista-oliot.
     * <p>
     * Kauppalista voi olla null (jos kaikki reseptiin tarvittavat ainesosat
     * ovat käyttäjän kaapissa).
     *
     * @param resepti resepti, joka näytetään
     * @param kauppalista kauppalista eli puuttuvat ainesosat
     */
    public ReseptiNakyma(Resepti resepti, Kauppalista kauppalista) {
        this.resepti = resepti;
        this.kauppalista = kauppalista;
    }

    /**
     * Määrittelee näkymän ja luo komponentit.
     * <p>
     * Komponentit: reseptin nimi ja ohje sekä mahdollinen kauppalista.
     */
    @Override
    public void run() {
        frame = new JFrame("Reseptisi");
        frame.setPreferredSize(new Dimension(1300, 800));

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel reseptinNimi = new JLabel(this.resepti.getNimi());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        container.add(reseptinNimi, c);

        JLabel resepti = new JLabel(this.resepti.toString());
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        container.add(resepti, c);

        if (this.kauppalista != null) {
            JLabel kauppalista = new JLabel("Kauppalista: " + this.kauppalista.toString());
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridwidth = 3;
            c.gridx = 0;
            c.gridy = 2;
            container.add(kauppalista, c);
        }
    }

}
