package reseptikone.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import reseptikone.logiikka.tiedostojenkasittely.AinesosalistojenLukija;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;

    public Kayttoliittyma() {
    }

    @Override
    public void run() {
        frame = new JFrame("Reseptinhakukone");
        frame.setPreferredSize(new Dimension(700, 500));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        JLabel teksti = new JLabel("Täällä voit kertoa jääkaappisi sisällön ja kone"
                + " antaa sinulle reseptin!");
        container.add(teksti, BorderLayout.NORTH);
        
        container.add(luoAinesosaValikko(), BorderLayout.SOUTH);
        
        
    }
    
    private JPanel luoAinesosaValikko() {
        JPanel panel = new JPanel(new GridLayout(6,2));
        AinesosalistojenLukija lukija = new AinesosalistojenLukija();
        
        for (String ainesosa : lukija.getAinesosaKategoria("kaikki")) {
            panel.add(new JButton(ainesosa));
        }
        
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}
