
package reseptikone.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
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
        frame.setVisible(true);}

    private void luoKomponentit(Container container) {
        JLabel reseptinNimi = new JLabel(this.resepti.getNimi());
        container.add(reseptinNimi, BorderLayout.NORTH);
        JLabel resepti = new JLabel(this.resepti.toString());
        container.add(resepti, BorderLayout.CENTER);
        if (this.kauppalista != null) {
            JLabel kauppalista = new JLabel("Kauppalista: " + this.kauppalista.toString());
            container.add(kauppalista, BorderLayout.SOUTH);
        }
    }
    
}
