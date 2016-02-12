package reseptikone.logiikka.tiedostojenkasittely;

import java.io.File;
import java.util.ArrayList;

/**
 * Luokka lukee kaikki mahdolliset ainesosat sisältäviä tiedostoja ja sisältää metodeja
 * joiden avulla niistä voidaan luoda palautettavia ArrayListeja.
 */
public class AinesosalistojenLukija {

    private TiedostonLukija lukija;
    private ArrayList<String> ainesosaKategoriat; // lista kaikista ainesosakategorioista

    /**
     * Konstruktori luo ArrayListin, joka sisältää kaikkien ainesosakategorioiden 
     * nimet.
     */
    public AinesosalistojenLukija() {
        this.ainesosaKategoriat = new ArrayList<String>();
        this.ainesosaKategoriat.add("juomat");
        this.ainesosaKategoriat.add("kasvikset");
        this.ainesosaKategoriat.add("kuivatuotteet");
        this.ainesosaKategoriat.add("maitotuotteetTms");
        this.ainesosaKategoriat.add("sailykkeet");
        this.ainesosaKategoriat.add("kaikki");
    }
    
    /**
     * @return lista ainesosakategorioiden nimistä
     */
    public ArrayList<String> getKaikkiAinesosaKategoriat() {
        return this.ainesosaKategoriat;
    }

    private ArrayList<String> muodostaArrayList(String ainesosaKategorianNimi) {
        String polku = muodostaPolkuTiedostoon(ainesosaKategorianNimi);
        this.lukija = new TiedostonLukija(new File(polku));
        ArrayList<String> lista = this.lukija.palautaTiedostoListana();
        this.lukija.suljeLukija();
        return lista;
    }

    private String muodostaPolkuTiedostoon(String tiedostonNimi) {
        return "ainesosat/" + tiedostonNimi + ".md";
    }

    /**
     * Palauttaa tietyn kategorian (esimerkiksi juomat) sisältämien ainesosien nimet.
     * <p>
     * Kutsuu metodia muodostaArrayList, joka lukee ainesosat tiedostosta
     * ja muodostaa niistä ArrayListin.
     * 
     * @param ainesosaKategorianNimi
     * @return lista ainesosista
     */
    public ArrayList<String> getAinesosaKategoria(String ainesosaKategorianNimi) {
        return muodostaArrayList(ainesosaKategorianNimi);
    }
}
