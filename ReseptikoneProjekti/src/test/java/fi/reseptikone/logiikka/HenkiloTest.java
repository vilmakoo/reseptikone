
package fi.reseptikone.logiikka;

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
        assertEquals(0, henkilo.kerroKaapinSisalto().size());
    }
    
    @Test
    public void kaappiEiOleTyhjäJosSinneOnLisattyJotain() {
        henkilo.lisaaAinesKaappiin("banaani");
        assertTrue(!henkilo.kerroKaapinSisalto().isEmpty());
    }
    
    @Test
    public void josKaappiinLisaaSamanAineksenKaksiKertaaSeOnSiellaVainKerran() {
        henkilo.lisaaAinesKaappiin("banaani");
        henkilo.lisaaAinesKaappiin("banaani");
        
        int maara = 0;
        for (String ainesosa : henkilo.kerroKaapinSisalto()) {
            if (ainesosa.equals("banaani")) {
                maara++;
            }
        }
        
        assertEquals(1, maara);
    }
    
    @Test
    public void kaappiinLisattyAinesOnKaapissa() {
        henkilo.lisaaAinesKaappiin("banaani");
        assertEquals(true, henkilo.kerroKaapinSisalto().contains("banaani"));
    }
    
    @Test
    public void kerroKaapinSisaltoKertooKaikkiKaapissaOlevatAinekset() {
        henkilo.lisaaAinesKaappiin("banaani");
        henkilo.lisaaAinesKaappiin("appelsiini");
        henkilo.lisaaAinesKaappiin("kananmuna");
        String odotettuTulos = "banaani\nappelsiini\nkananmuna\n";
        
        String kaapinsisalto = "";
        for (String ainesosa : henkilo.kerroKaapinSisalto()) {
            kaapinsisalto = kaapinsisalto + ainesosa + "\n";
        }
        
        assertEquals(odotettuTulos, kaapinsisalto);
    }
}
