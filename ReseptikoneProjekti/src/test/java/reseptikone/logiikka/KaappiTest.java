
package reseptikone.logiikka;

import reseptikone.logiikka.Kaappi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KaappiTest {
    
    private Kaappi kaappi;
    
    public KaappiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kaappi = new Kaappi();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kaapissaEiOleMitaanJosSinneEiOleLisattyMitaan() {
        assertEquals(0, kaappi.getSisalto().size());
    }
    
    @Test
    public void kaappiEiOleTyhjäJosSinneOnLisattyJotain() {
        kaappi.lisaaAinesKaappiin("banaani");
        assertTrue(!kaappi.getSisalto().isEmpty());
    }
    
    @Test
    public void josKaappiinLisaaSamanAineksenKaksiKertaaSeOnSiellaVainKerran() {
        kaappi.lisaaAinesKaappiin("banaani");
        kaappi.lisaaAinesKaappiin("banaani");
        
        int maara = 0;
        for (String ainesosa : kaappi.getSisalto()) {
            if (ainesosa.equals("banaani")) {
                maara++;
            }
        }
        
        assertEquals(1, maara);
    }
    
    @Test
    public void kaappiinLisattyAinesOnKaapissa() {
        kaappi.lisaaAinesKaappiin("banaani");
        assertEquals(true, kaappi.getSisalto().contains("banaani"));
    }
    
    @Test
    public void kerroKaapinSisaltoKertooKaikkiKaapissaOlevatAinekset() {
        kaappi.lisaaAinesKaappiin("banaani");
        kaappi.lisaaAinesKaappiin("appelsiini");
        kaappi.lisaaAinesKaappiin("kananmuna");
        String odotettuTulos = "banaani\nappelsiini\nkananmuna\n";
        
        String kaapinsisalto = "";
        for (String ainesosa : kaappi.getSisalto()) {
            kaapinsisalto = kaapinsisalto + ainesosa + "\n";
        }
        
        assertEquals(odotettuTulos, kaapinsisalto);
    }
    
    @Test
    public void tyhjennaKaappiPoistaaKaapinSisallon() {
        kaappi.lisaaAinesKaappiin("banaani");
        kaappi.lisaaAinesKaappiin("appelsiini");
        kaappi.tyhjennaKaappi();
        
        assertEquals(0, kaappi.getSisalto().size());
    }
}
