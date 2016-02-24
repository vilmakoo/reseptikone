package reseptikone.kayttoliittyma;

import javax.swing.SwingUtilities;
import reseptikone.kayttoliittyma.paanakyma.Paanakyma;

/**
 * Aloittaa ohjelman suorituksen.
 */
public class Main {

    public static void main(String[] args) {
//        TekstiKayttoliittyma ui = new TekstiKayttoliittyma();
//        ui.suorita();
        Paanakyma gui = new Paanakyma();
        SwingUtilities.invokeLater(gui);
    }

}
