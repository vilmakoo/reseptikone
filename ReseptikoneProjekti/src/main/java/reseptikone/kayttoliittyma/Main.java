package reseptikone.kayttoliittyma;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import reseptikone.logiikka.ReseptinLisaaja;
import reseptikone.logiikka.tiedostojenkasittely.TiedostonLukija;

public class Main {

    public static void main(String[] args) throws IOException {
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        SwingUtilities.invokeLater(kayttoliittyma);
//        ReseptinLisaaja lisaaja = new ReseptinLisaaja();
//        String nimi = "velli";
//        ArrayList<String> ainesosat = new ArrayList<String>();
//        ainesosat.add("maito");
//        ainesosat.add("jauho");
//        String ohje = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään";
//        lisaaja.lisaaResepti(nimi, ainesosat, ohje);
//        String halutaan = "Tarvitset:\nmaitoa\njauhoa\n\nSekoita ainekset keskenään\n";
//        TiedostonLukija lukija = new TiedostonLukija(new File("reseptit/velliOhje.md"));
//        System.out.println(halutaan);
//        System.out.println(lukija.palautaTiedostoMerkkijonona());
//        lukija.suljeLukija();
    }

}
