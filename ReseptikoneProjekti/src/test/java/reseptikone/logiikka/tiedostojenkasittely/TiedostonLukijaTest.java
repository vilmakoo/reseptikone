
package reseptikone.logiikka.tiedostojenkasittely;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import reseptikone.logiikka.ReseptinLisaaja;

public class TiedostonLukijaTest {
    
    private TiedostonLukija lukija;
    
    public TiedostonLukijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
    
    public void lisaaResepti() {
        ReseptinLisaaja lisaaja = new ReseptinLisaaja();
        String nimi = "velli";
        ArrayList<String> ainesosat = new ArrayList<String>();
        ainesosat.add("maito");
        ainesosat.add("jauho");
        String ohje = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään";
        lisaaja.lisaaResepti(nimi, ainesosat, ohje);
    }

    @Test
    public void tiedostonLukeminenOnnistuu() {
        String polkuTiedostoonJuomat = "ainesosat/juomat.md";
        lukija = new TiedostonLukija(new File(polkuTiedostoonJuomat));
        assertEquals("kalja\npunaviini\nomenamehu\npiimä\nappelsiinimehu\n", lukija.palautaTiedostoMerkkijonona());
        lukija.suljeLukija();
    }
    
    @Test
    public void ainesosaTiedostonLukeminenOnnistuu() {
        this.lisaaResepti();
        String halutaan = "maito\njauho\n";
        lukija = new TiedostonLukija(new File("reseptit/velliAinesosat.md"));
        String metodiPalauttaa = "";
        for (String ainesosa : lukija.palautaTiedostoListana()) {
            metodiPalauttaa = metodiPalauttaa + ainesosa + "\n";
        }
        assertEquals(halutaan, metodiPalauttaa);
        lukija.suljeLukija();
    }
}
