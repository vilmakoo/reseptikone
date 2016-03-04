package reseptikone.kayttoliittyma.reseptinakymat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import reseptikone.logiikka.reseptinhaku.Resepti;

/**
 * Tapahtumankuuntelija reseptin näkemistä varten.
 * <p>
 * Lista resepteistä on KaikkiReseptitNakymassa.
 */
public class ReseptiNapinKuuntelija implements ActionListener {

    private String valittuResepti;
    private JFrame frame;

    /**
     * Lisää reseptit sisältävään listaan listavalinnankuuntelijan.
     * 
     * @param listaResepteista JList, joka sisältää reseptien nimet
     * @param frame KaikkiReseptitNakyman frame
     * @param reseptitTaulukkona kaikki reseptit taulukkona
     */
    public ReseptiNapinKuuntelija(JList listaResepteista, JFrame frame, String[] reseptitTaulukkona) {
        this.frame = frame;
        lisaaListavalinnanKuuntelija(listaResepteista, this.frame, reseptitTaulukkona);
    }
    
    // lisää reseptilistalle, joka on siis JList, selectionlistenerin
    private void lisaaListavalinnanKuuntelija(final JList lista, JFrame frame, final String[] reseptit) {
        lista.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting() == false) {
                    valittuResepti = reseptit[lista.getSelectedIndex()]; // valittu resepti on reseptitaulukossa
                    // samassa indeksissä kuin listassakin
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (valittuResepti == null) { // jos reseptiä ei ole valittu, tulee virheilmoitus
            JOptionPane.showMessageDialog(frame,
                    "Valitse jokin resepti!",
                    "Virhe!",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            naytaResepti();
        }
    }

    private void naytaResepti() { // käytännössä luo reseptinäkymän ja avaa sen
        ReseptiNakyma nayttaja = new ReseptiNakyma(new Resepti(valittuResepti), null);
        SwingUtilities.invokeLater(nayttaja);
    }

}
