package fi.reseptikone.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AinesosaTest {
    
    private Ainesosa maito;

    public AinesosaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        maito = new Ainesosa("maito");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ainesosanToStringToimiiOikeinJosMaaraAsetettu() {
        maito.asetaMaara("5 litraa");
        assertEquals("maito, 5 litraa", maito.toString());
    }
    
    @Test
    public void toStringToimiiJosMaaraaEiOleAsetettu() {
        assertEquals("maito", maito.toString());
    }
}
