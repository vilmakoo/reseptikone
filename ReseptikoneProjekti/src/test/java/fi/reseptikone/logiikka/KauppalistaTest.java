package fi.reseptikone.logiikka;

import fi.reseptikone.logiikka.Kauppalista;
import fi.reseptikone.logiikka.Resepti;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KauppalistaTest {

    private Kauppalista kauppalista;
    private ArrayList<String> reseptinAinekset;
    private ArrayList<String> kaapissaOlevatAinekset;
    private Reseptinhakukone kone;

    public KauppalistaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        reseptinAinekset = new ArrayList<String>();
        kaapissaOlevatAinekset = new ArrayList<String>();
        kone = new Reseptinhakukone();
    }

    @After
    public void tearDown() {
    }
    
    public void lisaaResepti() throws UnsupportedEncodingException, IOException {
        String nimi = "velli";
        ArrayList<String> ainesosat = new ArrayList<String>();
        ainesosat.add("maito");
        ainesosat.add("jauho");
        String ohje = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään";
        kone.lisaaResepti(nimi, ainesosat, ohje);
    }

//    public ArrayList<String> resepti() {
//        ArrayList<String> ainekset = new ArrayList<String>();
//        String maito = "maito";
//        String jauho = "jauho";
//        ainekset.add(maito);
//        ainekset.add(jauho);
//        return ainekset;
//    }
    
    @Test
    public void kauppalistaOnSamaKuinReseptinAineksetJosKaapissaEiOleMitaan() throws FileNotFoundException, IOException {
        lisaaResepti();
        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
        assertEquals("maito\njauho\n", kauppalista.toString());
    }

    @Test
    public void kauppalistaOnSamaKuinReseptinAineksetJosKaapissaEiMitaanReseptinAineksia() throws FileNotFoundException, IOException {
        kaapissaOlevatAinekset.add("banaani");
        lisaaResepti();
        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
        assertEquals("maito\njauho\n", kauppalista.toString());
    }

    @Test
    public void kauppalistaMuodostuuOikeinJosKaapissaJotainReseptinAineksista() throws FileNotFoundException, IOException {
        lisaaResepti();
        kaapissaOlevatAinekset.add("maito");
        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
        assertEquals("jauho\n", kauppalista.toString());
    }
}
