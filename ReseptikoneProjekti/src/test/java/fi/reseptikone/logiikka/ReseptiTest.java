/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.reseptikone.logiikka;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vilma
 */
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
    public void tearDown() {
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
        Reseptinhakukone kone = new Reseptinhakukone();
        kone.lisaaResepti(nimi, ainesosat, ohje);
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
