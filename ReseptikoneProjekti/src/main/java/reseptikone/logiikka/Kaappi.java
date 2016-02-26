package reseptikone.logiikka;

import java.util.ArrayList;

/**
 * Luokka kuvaa käyttäjän kaapin sisältöä.
 */
public class Kaappi {

    private ArrayList<String> kaapissaOlevatAinekset;

    /**
     * Konstruktori alustaa ArrayListin, joka sisältää kaapin ainekset.
     */
    public Kaappi() {
        this.kaapissaOlevatAinekset = new ArrayList<String>();
    }

    public ArrayList<String> getSisalto() {
        return this.kaapissaOlevatAinekset;
    }

    /**
     * Metodi lisää ainesosan kaapissaOleviinAineksiin.
     * <p>
     * Käyttäjälle annetaan lista kaikista ainesosista, joista hän sitten
     * valitsee ne, jotka ovat kaapissaan. Tämän metodin avulla ne lisätään
     * kaappi-olion ArrayListiin.
     *
     * @param ainesosa Käyttäjän kaapissa oleva ainesosa.
     */
    public void lisaaAinesKaappiin(String ainesosa) {
        for (String kaapissaOlevaAinesosa : this.kaapissaOlevatAinekset) {
            if (kaapissaOlevaAinesosa.equals(ainesosa)) {
                return;
            }
        }
        this.kaapissaOlevatAinekset.add(ainesosa);
    }

    /**
     * Tyhjentää kaapissaOlevatAinekset-arraylistin.
     */
    public void tyhjennaKaappi() {
        kaapissaOlevatAinekset = new ArrayList<String>();
    }
}
