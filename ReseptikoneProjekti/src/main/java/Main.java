
import fi.reseptikone.logiikka.KaikkiAinesosat;


public class Main {

    public static void main(String[] args) {
        KaikkiAinesosat kaikkiAinesosat = new KaikkiAinesosat();
        for (String ainesosa : kaikkiAinesosat.getKaikki()) {
            System.out.println(ainesosa);
        }
    }
    
}
