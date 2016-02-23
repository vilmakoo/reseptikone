package reseptikone.kayttoliittyma.nakymat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import reseptikone.kayttoliittyma.tapahtumankuuntelijat.LisaaReseptiNapinKuuntelija;
import reseptikone.kayttoliittyma.tapahtumankuuntelijat.ListavalinnanKuuntelija;
import reseptikone.logiikka.tiedostojenkasittely.AinesosalistojenLukija;

/**
 * Täällä tapahtuu reseptin lisääminen.
 */
public class ReseptinLisaysNakyma implements Runnable {

    private JFrame frame;
    private String reseptinNimi;
    private ArrayList<String> reseptinAinesosat;
    private String ohje;
    private String[] kaikkiAinesosat;
    private boolean onkoAinesosatValittu;

    public ReseptinLisaysNakyma() {
        kaikkiAinesosat = new String[100];
        muodostaListaAinesosista();
        reseptinAinesosat = new ArrayList<String>();
        onkoAinesosatValittu = false;
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

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        container.add(luoReseptinLisaysKentat(), BorderLayout.CENTER);

        JButton reseptinLisaysNappi = new JButton("Lisää resepti!");
        reseptinLisaysNappi.addActionListener(new LisaaReseptiNapinKuuntelija(reseptinNimi, reseptinAinesosat, ohje));
        container.add(reseptinLisaysNappi, BorderLayout.SOUTH);
    }

    private JPanel luoReseptinLisaysKentat() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel reseptinNimiTeksti = new JLabel("Anna reseptin nimi:");
        JTextField reseptinNimiKentta = new JTextField();
        JLabel ainesosaTeksti = new JLabel("Valitse ainesosat:");
        JList ainesosaLista = luoListaAinesosista();
        lisaaListavalinnanKuuntelija(ainesosaLista);
        JButton ainesosatValittuNappi = new JButton("ainesosat valittu!");
//        ainesosatValittuNapinKuuntelija(ainesosatValittuNappi, ainesosaLista);
        JLabel ohjeTeksti = new JLabel("Kirjoita ohje, sisältäen ainesosat ja niiden määrät:");
        JTextArea ohjeKentta = new JTextArea();

        reseptinNimi = reseptinNimiKentta.getText();
        ohje = ohjeKentta.getText();

        panel.add(reseptinNimiTeksti);
        panel.add(reseptinNimiKentta);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(ainesosaTeksti);
        panel.add(ainesosaLista);
        panel.add(new JLabel(""));
        panel.add(ainesosatValittuNappi);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(ohjeTeksti);
        panel.add(ohjeKentta);

        return panel;
    }

    private JList luoListaAinesosista() {
        JList lista = new JList(kaikkiAinesosat);
        lista.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        lista.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lista.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(lista);
        listScroller.setPreferredSize(new Dimension(150, 60));

        return lista;
    }

    private void muodostaListaAinesosista() {
        AinesosalistojenLukija lukija = new AinesosalistojenLukija();
        int i = 0;
        for (String ainesosa : lukija.getAinesosaKategoria("kaikki")) {
            kaikkiAinesosat[i] = ainesosa;
            i++;
        }
    }

    private void lisaaListavalinnanKuuntelija(JList lista) {
        lista.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    for (String ainesosa : (List<String>) lista.getSelectedValuesList()) {
                        if (!reseptinAinesosat.contains(ainesosa)) {
                            reseptinAinesosat.add(ainesosa);
                            System.out.println(ainesosa);
                        }
                    }
                }
            }

        });
    }
}
