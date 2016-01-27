
package fi.reseptikone;

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
        kone = new Reseptinhakukone();
        
//        Ainesosa maito = new Ainesosa("maitoa", "2 litraa");
//        Ainesosa jauho = new Ainesosa("jauhoja", "5 desilitraa");
//        ArrayList<Ainesosa> vellinAinekset = new ArrayList<Ainesosa>();
//        vellinAinekset.add(maito);
//        vellinAinekset.add(jauho);
//        kone.lisaaResepti("velli", vellinAinekset);
//        
//        
//        Ainesosa kaakaojauhe = new Ainesosa("kaakaojauhetta", "3 teelusikallista");
//        ArrayList<Ainesosa> kaakaonAinekset = new ArrayList<Ainesosa>();
//        kaakaonAinekset.add(maito);
//        kaakaonAinekset.add(jauho);
//        kone.lisaaResepti("kaakao", kaakaonAinekset);
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
    }

//    @Test
//    public void reseptienListausToimii() {
//        assertEquals("velli\n2 litraa maitoa\n5 desilitraa jauhoja\n\nkaakao\n2 litraa maito\n3 teelusikallista kaakaojauhetta", kone.listaaReseptit());
//    }
    
    @Test
    public void reseptinLisaysToimii() {
        Ainesosa maito = new Ainesosa("maitoa", "2 litraa");
        Ainesosa jauho = new Ainesosa("jauhoja", "5 desilitraa");
        ArrayList<Ainesosa> vellinAinekset = new ArrayList<Ainesosa>();
        vellinAinekset.add(maito);
        vellinAinekset.add(jauho);
        kone.lisaaResepti("velli", vellinAinekset);
        
        assertEquals(true, kone.getReseptienNimet().contains("velli"));
    }
}
