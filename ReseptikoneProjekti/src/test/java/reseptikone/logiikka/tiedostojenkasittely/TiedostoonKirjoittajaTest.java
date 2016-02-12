package reseptikone.logiikka.tiedostojenkasittely;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TiedostoonKirjoittajaTest {

    private TiedostoonKirjoittaja kirjoittaja;

    public TiedostoonKirjoittajaTest() {
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
    public void tearDown() {
        File testitiedosto = new File("testi");
        testitiedosto.delete();
    }

    @Test
    public void tiedostoonKirjoittaminenOnnistuu() {
        kirjoittaja = new TiedostoonKirjoittaja("testi");
        kirjoittaja.kirjoita("testi");
        kirjoittaja.kirjoita("testaan");
        kirjoittaja.suljeKirjoittaja();

        TiedostonLukija lukija = new TiedostonLukija(new File("testi"));
        assertEquals("testi\ntestaan\n", lukija.palautaTiedostoMerkkijonona());

        lukija.suljeLukija();
    }
}
