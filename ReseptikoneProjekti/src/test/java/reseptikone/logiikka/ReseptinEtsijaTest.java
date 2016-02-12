
package reseptikone.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReseptinEtsijaTest {
    
    private ReseptinEtsija etsija;
    private Kaappi kaappi;
    
    public ReseptinEtsijaTest() {
    }
    
    @Before
    public void setUp() throws IOException {
        kaappi = new Kaappi();
        lisaaAineksetKaappiin();
        
    }
    
    public void lisaaAineksetKaappiin() {
        kaappi.lisaaAinesKaappiin("kalja");
        kaappi.lisaaAinesKaappiin("maito");
        kaappi.lisaaAinesKaappiin("margariini");
    }
    
    public void tearDown() throws FileNotFoundException, IOException {
        File velliOhje = new File("reseptit/velliOhje.md");
        File velliAinesosat = new File("reseptit/velliAinesosat.md");

        velliOhje.delete();
        velliAinesosat.delete();
        poistaVelliReseptienNimista();
    }
    
    public void poistaVelliReseptienNimista() throws FileNotFoundException, IOException {
        String nimetIlmanVellia = "";
        Scanner lukija = new Scanner(new File("reseptit/reseptienNimet.md"));
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            if (!rivi.equals("velli")) {
                nimetIlmanVellia += rivi + "\n";
            } else {
                break;
            }
        }
        lukija.close();
        FileWriter kirjoittaja = new FileWriter("reseptit/reseptienNimet.md");
        kirjoittaja.write(nimetIlmanVellia);
        kirjoittaja.close();
    }
    
    public void lisaaResepti() throws UnsupportedEncodingException, IOException {
        String nimi = "velli";
        ArrayList<String> ainesosat = new ArrayList<String>();
        ainesosat.add("maito");
        ainesosat.add("jauho");
        String ohje = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään";
        ReseptinLisaaja reseptinLisaaja = new ReseptinLisaaja();
        reseptinLisaaja.lisaaResepti(nimi, ainesosat, ohje);
    }
    
    @Test
    public void reseptinEtsiminenPalauttaaJonkinReseptin() throws IOException {
        lisaaResepti();
        etsija = new ReseptinEtsija(kaappi);
        assertEquals("velli", etsija.etsiResepti().getNimi());
    }
}
