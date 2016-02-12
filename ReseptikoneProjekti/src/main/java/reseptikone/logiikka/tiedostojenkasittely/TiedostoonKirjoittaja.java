package reseptikone.logiikka.tiedostojenkasittely;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Luokka sisältää tiedostoon kirjoittamiseen tarvittavan FileWriter-olion.
 */
public class TiedostoonKirjoittaja {

    private PrintWriter kirjoittaja;

    /**
     * Konstruktori luo FileWriterin, jonka avulla parametrina saadun polun
     * osoittamaan tiedostoon voidaan kirjoittaa.
     * 
     * @param polkuTiedostoon 
     */
    public TiedostoonKirjoittaja(String polkuTiedostoon) {
        try {
            this.kirjoittaja = new PrintWriter(new FileWriter(polkuTiedostoon, true));
        } catch (IOException ex) {
            Logger.getLogger(TiedostoonKirjoittaja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Metodi kirjoittaa tiedostoon FileWriter-luokan metodin write avulla.
     * @param kirjoitettavaAsia 
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
