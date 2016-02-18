package reseptikone.kayttoliittyma.tapahtumankuuntelijat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reseptikone.kayttoliittyma.nakymat.ReseptinLisaysNakyma;

/**
 * Tapahtumankuuntelija reseptinlisäysnäkymän avaamiselle.
 * <p>
 * Tätä käytetään, kun päänäkymästä painetaan reseptinlisäysnappia.
 */
public class ReseptinLisaysNakymanAvaaja implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        ReseptinLisaysNakyma reseptinLisaysNakyma = new ReseptinLisaysNakyma();
        reseptinLisaysNakyma.run();
    }

}
