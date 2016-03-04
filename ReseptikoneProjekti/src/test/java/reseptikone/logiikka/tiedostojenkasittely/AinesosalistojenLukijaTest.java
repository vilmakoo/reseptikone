package reseptikone.logiikka.tiedostojenkasittely;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AinesosalistojenLukijaTest {

    private AinesosalistojenLukija listojenLukija;

    public AinesosalistojenLukijaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        listojenLukija = new AinesosalistojenLukija();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void metodiGetAinesosaJoukkoToimii() {
        String halutaan = "banaani\ntomaatti\nherkkusieni\npaprika\nsipuli\nappelsiini\nmustikka\nvalkosipuli\nchili\nomena\n"
                + "parsakaali\n"
                + "porkkana\n"
                + "kurkku\n"
                + "munakoiso\n"
                + "sitruuna\n"
                + "peruna\n"
                + "mansikka\n";
        String saadaan = "";
        for (String ainesosa : listojenLukija.getAinesosaKategoria("kasvikset")) {
            saadaan = saadaan + ainesosa + "\n";
        }
        assertEquals(halutaan, saadaan);
    }

    @Test
    public void metodiGetKaikkiAinesosaJoukotToimii() {
        String halutaan = "juomat kasvikset kuivatuotteet maitotuotteetTms sailykkeet mausteet kaikki ";
        String saadaan = "";
        for (String ainesosa : listojenLukija.getKaikkiAinesosaKategoriat()) {
            saadaan = saadaan + ainesosa + " ";
        }
        assertEquals(halutaan, saadaan);
    }
}
