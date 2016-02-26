package reseptikone.logiikka.tiedostojenkasittely;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Luokka sisältää tiedostoon kirjoittamiseen tarvittavan PrintWriter-olion.
 */
public class TiedostoonKirjoittaja {

    private PrintWriter kirjoittaja;

    /**
     * Konstruktori luo PrintWriterin, jonka avulla parametrina saadun polun
     * osoittamaan tiedostoon voidaan kirjoittaa.
     *
     * @param polkuTiedostoon polku haluttuun tiedostoon
     */
    public TiedostoonKirjoittaja(String polkuTiedostoon) {
        try {
            this.kirjoittaja = new PrintWriter(new FileWriter(polkuTiedostoon, true));
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaminen ei onnistunut." + ex);
        }
    }

    /**
     * Metodi kirjoittaa tiedostoon PrintWriter-luokan metodin println avulla.
     *
     * @param kirjoitettavaAsia asia, joka halutaan kirjoittaa tiedostoon
     */
    public void kirjoita(String kirjoitettavaAsia) {
        this.kirjoittaja.println(kirjoitettavaAsia);
    }

    /**
     * Metodi sulkee FileWriterin.
     */
    public void suljeKirjoittaja() {
        this.kirjoittaja.close();
    }
}
