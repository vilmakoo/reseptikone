
package reseptikone.logiikka.reseptinhaku;

import reseptikone.logiikka.reseptinhaku.ReseptinLisaaja;
import reseptikone.logiikka.reseptinhaku.Resepti;
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

public class ReseptiTest {
    
    private Resepti velli;
    
    public ReseptiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        this.lisaaResepti();
        velli = new Resepti("velli");
    }
    
    @After
    public void tearDown() throws IOException {
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
        ReseptinLisaaja lisaaja = new ReseptinLisaaja();
        lisaaja.lisaaResepti(nimi, ainesosat, ohje);
    }
    
    @Test
    public void getNimiPalauttaaReseptinNimenOikein() {
        assertEquals("velli", velli.getNimi());
    }
    
    @Test
    public void getAinesosatPalauttaaAinesosatOikein() {
        String ainesosat = "maito\njauho\n";
        
        String metodinPalauttamatAinesosat = "";
        for (String ainesosa : velli.getAinesosat()) {
            metodinPalauttamatAinesosat += ainesosa + "\n";
        }
        
        assertEquals(ainesosat, metodinPalauttamatAinesosat);
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals(velli.toString(), "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään\n");
    }
}
