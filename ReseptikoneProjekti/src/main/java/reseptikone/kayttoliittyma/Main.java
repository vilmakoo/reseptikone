package reseptikone.kayttoliittyma;

import javax.swing.SwingUtilities;
import reseptikone.kayttoliittyma.paanakyma.Paanakyma;
import reseptikone.kayttoliittyma.paanakyma.testi;

/**
 * Aloittaa ohjelman suorituksen.
 */
public class Main {

    public static void main(String[] args) {
//        TekstiKayttoliittyma ui = new TekstiKayttoliittyma();
//        ui.suorita();
//        Paanakyma gui = new Paanakyma();
//        SwingUtilities.invokeLater(gui);
        testi testi = new testi();
        SwingUtilities.invokeLater((Runnable) testi);
    }

}
