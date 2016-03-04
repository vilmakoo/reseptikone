package reseptikone.kayttoliittyma.reseptinakymat;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
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
     * Komponentit: reseptin nimi ja ohje sekä mahdollinen kauppalista + nappi,
     * jota painamalla pääsee takaisin.
     */
    @Override
    public void run() {
        frame = new JFrame("Resepti");
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(4, 0));

        JTextField reseptinNimi = new JTextField(this.resepti.getNimi());
        reseptinNimi.setEditable(false);
        container.add(reseptinNimi);

        JTextArea resepti = new JTextArea(this.resepti.toString());
        resepti.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resepti);
        container.add(scrollPane);

        if (this.kauppalista != null) {
            JTextArea kauppalista = new JTextArea("Kauppalista:\n" + this.kauppalista.toString());
            kauppalista.setEditable(false);
            container.add(kauppalista);
        } else {
            container.add(new JLabel(""));
        }

        container.add(palaaTakaisin());
    }
    
    private JPanel palaaTakaisin() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        
        JButton palaaTakaisinNappi = new JButton("Palaa takaisin");
        lisaaPalaaTakaisinNapinKuuntelija(palaaTakaisinNappi, this.frame);
        
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(palaaTakaisinNappi);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        
        return panel;
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
