package reseptikone.logiikka.reseptinhaku;

import reseptikone.logiikka.tiedostojenkasittely.TiedostonLukija;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
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
        poistaVelliJaKaakaoReseptienNimista();
    }
    
    public void poistaTiedostot() {
        File velliOhje = new File("reseptit/velliOhje.md");
        File velliAinesosat = new File("reseptit/velliAinesosat.md");
        File kaakaoOhje = new File("reseptit/kaakaoOhje.md");
        File kaakaoAinesosat = new File("reseptit/kaakaoAinesosat.md");

        velliOhje.delete();
        velliAinesosat.delete();
        kaakaoOhje.delete();
        kaakaoAinesosat.delete();
    }
    
    public void poistaVelliJaKaakaoReseptienNimista() throws FileNotFoundException, IOException {
        String nimetIlmanVelliaJaKaakaota = "";
        Scanner scanner = new Scanner(new File("reseptit/reseptienNimet.md"));
        while (scanner.hasNextLine()) {
            String rivi = scanner.nextLine();
            if (!rivi.equals("velli") && !rivi.equals("kaakao")) {
                nimetIlmanVelliaJaKaakaota += rivi + "\n";
            } else {
                break;
            }
        }
        scanner.close();
        FileWriter kirjoittaja = new FileWriter("reseptit/reseptienNimet.md");
        kirjoittaja.write(nimetIlmanVelliaJaKaakaota);
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
    
    public void lisaaToinenResepti() {
        String nimi = "kaakao";
        ArrayList<String> ainesosat = new ArrayList<String>();
        ainesosat.add("maito");
        ainesosat.add("kaakaojauhe");
        String ohje = "Tarvitset:\nmaitoa\nkaakaojauhetta\n\nLaita ainekset mukiin. Sekoita. Lämmitä halutessasi mikrossa";
        lisaaja.lisaaResepti(nimi, ainesosat, ohje);
    }

    // testit alkaa tästä
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
        lisaaToinenResepti();
        String halutaan = "Tarvitset:\nmaitoa\nkaakaojauhetta\n\nLaita ainekset mukiin. Sekoita. Lämmitä halutessasi mikrossa\n";
        lukija = new TiedostonLukija(new File("reseptit/kaakaoOhje.md"));
        assertEquals(halutaan, lukija.palautaTiedostoMerkkijonona());
        lukija.suljeLukija();
    }
    
    @Test
    public void reseptinLisaajaKirjoittaaAinesosaTiedostoonOikein() {
        this.lisaaToinenResepti();
        String halutaan = "maito\nkaakaojauhe\n";
        lukija = new TiedostonLukija(new File("reseptit/kaakaoAinesosat.md"));
        String metodiPalauttaa = "";
        for (String ainesosa : lukija.palautaTiedostoListana()) {
            metodiPalauttaa = metodiPalauttaa + ainesosa + "\n";
        }
        assertEquals(halutaan, metodiPalauttaa);
        lukija.suljeLukija();
    }
    
    @Test
    public void reseptinLisaajaKirjoittaaReseptienNimetTiedostoonReseptinNimen() {
        this.lisaaToinenResepti();
        boolean onkoOikein = false;
        lukija = new TiedostonLukija(new File("reseptit/reseptienNimet.md"));
        for (String nimi : lukija.palautaTiedostoListana()) {
            if (nimi.equals("kaakao")) {
                onkoOikein = true;
            }
        }
        assertTrue(onkoOikein);
    }
}
