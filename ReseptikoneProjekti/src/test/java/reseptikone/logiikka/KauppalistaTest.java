package reseptikone.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KauppalistaTest {

    private Kauppalista kauppalista;
    private ArrayList<String> kaapissaOlevatAinekset;
    private ReseptinLisaaja reseptinLisaaja;

    public KauppalistaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kaapissaOlevatAinekset = new ArrayList<String>();
        reseptinLisaaja = new ReseptinLisaaja();
    }

    @After
    public void tearDown() throws FileNotFoundException, IOException {
        File velliOhje = new File("reseptit/velliOhje.md");
        File velliAinesosat = new File("reseptit/velliAinesosat.md");

        velliOhje.delete();
        velliAinesosat.delete();
        poistaVelliReseptienNimista();
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
    
    public void lisaaResepti() throws UnsupportedEncodingException, IOException {
        String nimi = "velli";
        ArrayList<String> ainesosat = new ArrayList<String>();
        ainesosat.add("maito");
        ainesosat.add("jauho");
        String ohje = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään";
        reseptinLisaaja.lisaaResepti(nimi, ainesosat, ohje);
    }

    public ArrayList<String> resepti() {
        ArrayList<String> ainekset = new ArrayList<String>();
        String maito = "maito";
        String jauho = "jauho";
        ainekset.add(maito);
        ainekset.add(jauho);
        return ainekset;
    }
    
    @Test
    public void kauppalistaOnSamaKuinReseptinAineksetJosKaapissaEiOleMitaan() throws FileNotFoundException, IOException {
        lisaaResepti();
        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
        assertEquals("maito\njauho\n", kauppalista.toString());
    }

    @Test
    public void kauppalistaOnSamaKuinReseptinAineksetJosKaapissaEiMitaanReseptinAineksia() throws FileNotFoundException, IOException {
        kaapissaOlevatAinekset.add("banaani");
        lisaaResepti();
        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
        assertEquals("maito\njauho\n", kauppalista.toString());
    }

    @Test
    public void kauppalistaMuodostuuOikeinJosKaapissaJotainReseptinAineksista() throws FileNotFoundException, IOException {
        lisaaResepti();
        kaapissaOlevatAinekset.add("maito");
        kauppalista = new Kauppalista(new Resepti("velli"), kaapissaOlevatAinekset);
        assertEquals("jauho\n", kauppalista.toString());
    }
}
