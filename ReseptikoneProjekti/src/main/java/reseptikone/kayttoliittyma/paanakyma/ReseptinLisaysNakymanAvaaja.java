package reseptikone.kayttoliittyma.paanakyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import reseptikone.kayttoliittyma.reseptinlisaysnakyma.ReseptinLisaysNakyma;

/**
 * Tapahtumankuuntelija reseptinlisäysnäkymän avaamiselle.
 * <p>
 * Tätä käytetään, kun päänäkymästä painetaan reseptinlisäysnappia. 
 * Avaa reseptinlisäysnäkymän.
 */
public class ReseptinLisaysNakymanAvaaja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ReseptinLisaysNakyma reseptinLisaysNakyma = new ReseptinLisaysNakyma();
        SwingUtilities.invokeLater(reseptinLisaysNakyma);
    }

}
