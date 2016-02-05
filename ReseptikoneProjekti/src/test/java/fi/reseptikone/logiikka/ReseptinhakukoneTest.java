
package fi.reseptikone.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
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

public class ReseptinhakukoneTest {
    
    private Reseptinhakukone kone;
    
    public ReseptinhakukoneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kone = new Reseptinhakukone();
    }
    
    @After
    public void tearDown() throws FileNotFoundException {
        File velliOhje = new File("reseptit/velliOhje.md");
        File velliAinesosat = new File("reseptit/velliAinesosat.md");
        
        velliOhje.delete();
        velliAinesosat.delete();
        
    }
    
    public void lisaaResepti() throws UnsupportedEncodingException, IOException {
        String nimi = "velli";
        ArrayList<String> ainesosat = new ArrayList<String>();
        ainesosat.add("maito");
        ainesosat.add("jauho");
        String ohje = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään";
        kone.lisaaResepti(nimi, ainesosat, ohje);
    }
    
    @Test
    public void reseptinLisayksenJalkeenReseptitHakemistoSisaltaaReseptinOhjeTiedoston() throws IOException {
        this.lisaaResepti();
        File velliOhje = new File("reseptit/velliOhje.md");
        assertEquals(true, velliOhje.exists());
    }
    
    @Test
    public void reseptinLisayksenJalkeenReseptitHakemistoSisaltaaReseptinAinesosatTiedoston() throws IOException {
        this.lisaaResepti();
        File velliAinesosat = new File("reseptit/velliAinesosat.md");
        assertEquals(true, velliAinesosat.exists());
    }
    
    @Test
    public void reseptinLisaysKirjoittaaOhjeTiedostoonOikein() throws IOException {
        this.lisaaResepti();
        String ohje = "";
        Scanner lukija = new Scanner(new File("reseptit/velliOhje.md"));
        while (lukija.hasNextLine()) {
            ohje = ohje + lukija.nextLine() + "\n";
        }
        assertEquals(ohje, "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään\n");
    }
    
    @Test
    public void reseptinLisaysKirjoittaaAinesosatTiedostoonOikein() throws IOException {
        this.lisaaResepti();
        String ainesosat = "";
        Scanner lukija = new Scanner(new File("reseptit/velliAinesosat.md"));
        while (lukija.hasNextLine()) {
            ainesosat = ainesosat + lukija.nextLine() + "\n";
        }
        assertEquals(ainesosat, "maito\njauho\n");
    }

    @Test
    public void reseptienNimienListausToimiiKunReseptejaLisatty() throws IOException {
        this.lisaaResepti();
        String nimet = "";
        Scanner lukija = new Scanner(new File("reseptit/reseptienNimet.md"));
        while (lukija.hasNextLine()) {
            nimet = nimet + lukija.nextLine() + "\n";
        }
        assertEquals(nimet, "velli\n");
    }
    
    @Test
    public void tulostaKauppalistaPalauttaaOikeanListan() throws IOException {
        lisaaResepti();
        Resepti velli = new Resepti("velli");
        
        ArrayList<String> kaapissaOlevatAinekset = new ArrayList<String>();
        kaapissaOlevatAinekset.add("jauho");
        
        assertEquals("maito\n", kone.tulostaKauppalista(velli, kaapissaOlevatAinekset));
    }
}
