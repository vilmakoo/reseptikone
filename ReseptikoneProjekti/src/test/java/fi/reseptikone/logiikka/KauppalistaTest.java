package fi.reseptikone.logiikka;

import fi.reseptikone.logiikka.Ainesosa;
import fi.reseptikone.logiikka.Kauppalista;
import fi.reseptikone.logiikka.Resepti;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KauppalistaTest {

    private Kauppalista kauppalista;
    private ArrayList<Ainesosa> reseptinAinekset;
    private ArrayList<Ainesosa> kaapissaOlevatAinekset;

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
        reseptinAinekset = new ArrayList<Ainesosa>();
        kaapissaOlevatAinekset = new ArrayList<Ainesosa>();
    }

    @After
    public void tearDown() {
    }

    public ArrayList<Ainesosa> resepti() {
        ArrayList<Ainesosa> ainekset = new ArrayList<Ainesosa>();
        Ainesosa maito = new Ainesosa("maito");
        Ainesosa jauho = new Ainesosa("jauho");
        ainekset.add(maito);
        ainekset.add(jauho);
        return ainekset;
    }
// Allaolevat testit pitää muokata toimiviksi! Luo johonkin metodi, joka luo reseptin.
    
//    @Test
//    public void kauppalistaOnSamaKuinReseptinAineksetJosKaapissaEiOleMitaan() throws FileNotFoundException {
//        reseptinAinekset = resepti();
//        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
//        assertEquals("maito\njauho\n", kauppalista.toString());
//    }

//    @Test
//    public void kauppalistaOnSamaKuinReseptinAineksetJosKaapissaEiMitaanReseptinAineksia() throws FileNotFoundException {
//        reseptinAinekset = resepti();
//        kaapissaOlevatAinekset.add(new Ainesosa("banaani"));
//        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
//        assertEquals("maito\njauho\n", kauppalista.toString());
//    }

//    @Test
//    public void kauppalistaMuodostuuOikeinJosKaapissaJotainReseptinAineksista() throws FileNotFoundException {
//        reseptinAinekset = resepti();
//        kaapissaOlevatAinekset.add(new Ainesosa("maito"));
//        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
//        assertEquals("jauho\n", kauppalista.toString());
//    }
}
