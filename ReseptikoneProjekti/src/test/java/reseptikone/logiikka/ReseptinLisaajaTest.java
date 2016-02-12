package reseptikone.logiikka;

import reseptikone.logiikka.tiedostojenkasittely.TiedostonLukija;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ReseptinLisaajaTest {

    private ReseptinLisaaja lisaaja;
    private TiedostonLukija lukija;

    public ReseptinLisaajaTest() {
    }

    @Before
    public void setUp() {
        lisaaja = new ReseptinLisaaja();
    }

    @After
    public void tearDown() throws IOException {
        poistaTiedostot();
        poistaVelliReseptienNimista();
    }
    
    public void poistaTiedostot() {
        File velliOhje = new File("reseptit/velliOhje.md");
        File velliAinesosat = new File("reseptit/velliAinesosat.md");

        velliOhje.delete();
        velliAinesosat.delete();
    }
    
    public void poistaVelliReseptienNimista() throws FileNotFoundException, IOException {
        String nimetIlmanVellia = "";
        Scanner lukija = new Scanner(new File("reseptit/reseptienNimet.md"));
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            if (!rivi.equals("velli")) {
                nimetIlmanVellia += rivi + "\n";
            } else {
                break;
            }
        }
        lukija.close();
        FileWriter kirjoittaja = new FileWriter("reseptit/reseptienNimet.md");
        kirjoittaja.write(nimetIlmanVellia);
        kirjoittaja.close();
    }

    public void lisaaResepti() {
        String nimi = "velli";
        ArrayList<String> ainesosat = new ArrayList<String>();
        ainesosat.add("maito");
        ainesosat.add("jauho");
        String ohje = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään";
        lisaaja.lisaaResepti(nimi, ainesosat, ohje);
    }

    @Test
    public void reseptinLisayksenJalkeenReseptitHakemistoSisaltaaReseptinOhjeTiedoston() {
        this.lisaaResepti();
        File velliOhje = new File("reseptit/velliOhje.md");
        assertEquals(true, velliOhje.exists());
    }

    @Test
    public void reseptinLisayksenJalkeenReseptitHakemistoSisaltaaReseptinAinesosatTiedoston() {
        this.lisaaResepti();
        File velliAinesosat = new File("reseptit/velliAinesosat.md");
        assertEquals(true, velliAinesosat.exists());
    }
    
    @Test
    public void reseptinLisaysKirjoittaaOhjeTiedostoonOikein() {
        this.lisaaResepti();
        String halutaan = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään\n";
        lukija = new TiedostonLukija(new File("reseptit/velliOhje.md"));
        System.out.println("halutaan: " + halutaan);
        System.out.println("saadaan: " + lukija.palautaTiedostoMerkkijonona());
        assertEquals(halutaan, lukija.palautaTiedostoMerkkijonona());
        lukija.suljeLukija();
    }
    
    @Test
    public void reseptinLisaajaKirjoittaaAinesosaTiedostoonOikein() {
        this.lisaaResepti();
        String halutaan = "maito\njauho\n";
        lukija = new TiedostonLukija(new File("reseptit/velliAinesosat.md"));
        String metodiPalauttaa = "";
        for (String ainesosa : lukija.palautaTiedostoListana()) {
            metodiPalauttaa = metodiPalauttaa + ainesosa + "\n";
        }
        assertEquals(halutaan, metodiPalauttaa);
        lukija.suljeLukija();
    }
}
