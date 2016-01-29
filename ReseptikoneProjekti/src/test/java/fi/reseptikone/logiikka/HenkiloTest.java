
package fi.reseptikone.logiikka;

import fi.reseptikone.logiikka.Ainesosa;
import fi.reseptikone.logiikka.Henkilo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HenkiloTest {
    
    private Henkilo henkilo;
    
    public HenkiloTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        henkilo = new Henkilo();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kaapissaEiOleMitaanJosSinneEiOleLisattyMitaan() {
        assertEquals(0, henkilo.getKaapinSisalto().size());
    }
    
    @Test
    public void kaappiEiOleTyhjäJosSinneOnLisattyJotain() {
        henkilo.lisaaAinesKaappiin(new Ainesosa("banaani"));
        assertTrue(!henkilo.getKaapinSisalto().isEmpty());
    }
    
    @Test
    public void josKaappiinLisaaSamanAineksenKaksiKertaaSeOnSiellaVainKerran() {
        henkilo.lisaaAinesKaappiin(new Ainesosa("banaani"));
        henkilo.lisaaAinesKaappiin(new Ainesosa("banaani"));
        
        int maara = 0;
        for (Ainesosa ainesosa : henkilo.getKaapinSisalto()) {
            if (ainesosa.getNimi().equals("banaani")) {
                maara++;
            }
        }
        
        assertEquals(1, maara);
    }
}
