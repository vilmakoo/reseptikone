
package fi.reseptikone.logiikka;

import fi.reseptikone.logiikka.Reseptinhakukone;
import fi.reseptikone.logiikka.Ainesosa;
import java.util.ArrayList;
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
    public void tearDown() {
    }

    @Test
    public void yhdenReseptinLisayksenJalkeenKoneSisaltaaReseptin() {
        Ainesosa maito = new Ainesosa("maito");
        Ainesosa jauho = new Ainesosa("jauho");
        ArrayList<Ainesosa> vellinAinekset = new ArrayList<Ainesosa>();
        vellinAinekset.add(maito);
        vellinAinekset.add(jauho);
        kone.lisaaResepti("velli", vellinAinekset);
        
        assertEquals("velli\n", kone.listaaReseptit());
    }
    
    @Test
    public void reseptienListausToimiiKunKoneSisaltaaResepteja() {
        Ainesosa maito = new Ainesosa("maito");
        Ainesosa jauho = new Ainesosa("jauho");
        ArrayList<Ainesosa> vellinAinekset = new ArrayList<Ainesosa>();
        vellinAinekset.add(maito);
        vellinAinekset.add(jauho);
        kone.lisaaResepti("velli", vellinAinekset);
        
        Ainesosa kaakaojauhe = new Ainesosa("kaakaojauhe");
        ArrayList<Ainesosa> kaakaonAinekset = new ArrayList<Ainesosa>();
        kaakaonAinekset.add(maito);
        kaakaonAinekset.add(jauho);
        kone.lisaaResepti("kaakao", kaakaonAinekset);
        
        assertEquals("velli\nkaakao\n", kone.listaaReseptit());
    }
}
