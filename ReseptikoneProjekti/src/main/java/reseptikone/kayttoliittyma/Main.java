package reseptikone.kayttoliittyma;

import reseptikone.kayttoliittyma.nakymat.Paanakyma;

/**
 * Aloittaa ohjelman suorituksen.
 */
public class Main {

    public static void main(String[] args) {
//        TekstiKayttoliittyma ui = new TekstiKayttoliittyma();
//        ui.suorita();
        Paanakyma gui = new Paanakyma();
        gui.run();
    }

}
