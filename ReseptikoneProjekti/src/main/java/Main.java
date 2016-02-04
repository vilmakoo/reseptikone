
import fi.reseptikone.logiikka.KaikkiAinesosat;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter tulos = new PrintWriter("reseptit/resepti.md");
        
        tulos.println("Tässä kirjoittelen tekstiä");
        tulos.println("Toivottavasti tämä toimii");
        tulos.close();
        
//    private static Scanner lukija = new Scanner(System.in);
//
//    public static void main(String[] args) throws FileNotFoundException {
//
//        PrintWriter tulos = new PrintWriter("gradu.txt");
//
//        System.out.println("Kirjoittamasi teksti menee tiedostoon gradu.txt");
//        System.out.println("(ctrl-d lopettaa!)\n");
//
//        while (lukija.hasNextLine()) {
//            String rivi = lukija.nextLine();
//            tulos.println(rivi);
//        }
//
//        tulos.close();   // !!
//        System.out.println("Työt tehty!\n");
//
//    }
}

}
