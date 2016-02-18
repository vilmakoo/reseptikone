package reseptikone.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import reseptikone.logiikka.Kauppalista;
import reseptikone.logiikka.reseptinhaku.Resepti;

public class ReseptinNayttaja implements Runnable {

    private JFrame frame;
    private Resepti resepti;
    private Kauppalista kauppalista;

    public ReseptinNayttaja(Resepti resepti, Kauppalista kauppalista) {
        this.resepti = resepti;
        this.kauppalista = kauppalista;
    }

    @Override
    public void run() {
        frame = new JFrame("Reseptisi");
        frame.setPreferredSize(new Dimension(800, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
