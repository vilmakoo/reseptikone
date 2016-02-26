package reseptikone.logiikka;

import reseptikone.logiikka.reseptinhaku.Resepti;
import java.util.ArrayList;

/**
 * Kauppalista kertoo ne ainesosat, jotka käyttäjältä puuttuvat.
 */
public class Kauppalista {

    private ArrayList<String> kauppalista;
    private ArrayList<String> reseptinAinesosat;
    private ArrayList<String> kaapissaOlevatAinesosat;

    /**
     * Konstruktori saa parametrinaan reseptin, jota ollaan tekemisissä, ja
     * listan ainesosista, jotka ovat valmiiksi käyttäjän kaapissa.
     * <p>
     * Suoritetaan oliomuuttujien alustus ja kutsutaan kauppalistan luovaa
     * metodia.
     *
     * @param resepti käyttäjän saama resepti
     * @param kaapissaOlevatAinesosat käyttäjän kaapissa olevat ainekset
     */
    public Kauppalista(Resepti resepti, ArrayList<String> kaapissaOlevatAinesosat) {
        this.kauppalista = new ArrayList<String>();
        this.reseptinAinesosat = resepti.getAinesosat();
        this.kaapissaOlevatAinesosat = kaapissaOlevatAinesosat;

        this.luoKauppalista();
    }

    private void luoKauppalista() {
        for (String ainesosa : this.reseptinAinesosat) {
            if (!this.kaapissaOlevatAinesosat.contains(ainesosa)) {
                // ehtolause tutkii, onko kaapissa reseptiin tarvittava ainesosa valmiina
                this.kauppalista.add(ainesosa);
            }
        }
    }

    /**
     * Metodi palauttaa kauppalistan merkkijonona.
     *
     * @return kauppalista
     */
    @Override
    public String toString() {
        String lista = "";
        for (String ainesosa : this.kauppalista) {
            lista = lista + ainesosa + "\n";
        }
        return lista;
    }
}
