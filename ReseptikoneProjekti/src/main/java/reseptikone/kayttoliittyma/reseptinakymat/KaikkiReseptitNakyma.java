package reseptikone.kayttoliittyma.reseptinakymat;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import reseptikone.logiikka.reseptinhaku.Resepti;

/**
 * Lista kaikista resepteistä.
 */
public class KaikkiReseptitNakyma implements Runnable {

    private ArrayList<Resepti> reseptit;
    private JFrame frame;
    private JList listaResepteista;
    private String[] reseptitTaulukkona;

    /**
     * Luo kaikki reseptit sisältävän ArrayListin.
     *
     * @param reseptit lista kaikista resepteistä
     */
    public KaikkiReseptitNakyma(ArrayList<Resepti> reseptit) {
        this.reseptit = reseptit;
    }

    /**
     * Määrittelee näkymän ja luo komponentit.
     */
    @Override
    public void run() {
        frame = new JFrame("Kaikki reseptit");
        frame.setPreferredSize(new Dimension(1000, 500));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.setLayout(new GridLayout(2, 3));

        reseptitTaulukkona = new String[reseptit.size()];
        int indeksi = 0;

        for (Resepti resepti : this.reseptit) {
            reseptitTaulukkona[indeksi] = resepti.getNimi();
            indeksi++;
        }

        listaResepteista = new JList(reseptitTaulukkona);
        listaResepteista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaResepteista.setLayoutOrientation(JList.VERTICAL);
        listaResepteista.setVisibleRowCount(-1);
        
        JScrollPane scrollpane = new JScrollPane(listaResepteista);
        
        container.add(new JLabel(""));
        container.add(scrollpane);
        container.add(new JLabel(""));
        container.add(new JLabel(""));
        container.add(alavalikko());
        container.add(new JLabel(""));
    }

    private JPanel alavalikko() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 0));

        JButton naytaResepti = new JButton("Näytä valittu resepti");
        naytaResepti.addActionListener(new ReseptiNapinKuuntelija(listaResepteista, this.frame, reseptitTaulukkona));
        
        JButton palaaTakaisinNappi = new JButton("Palaa takaisin");
        lisaaPalaaTakaisinNapinKuuntelija(palaaTakaisinNappi, this.frame);

        panel.add(new JLabel(""));
        panel.add(naytaResepti);
        panel.add(palaaTakaisinNappi);
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
