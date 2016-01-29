package fi.reseptikone.logiikka;

import java.util.ArrayList;

public class Kauppalista {

    private ArrayList<Ainesosa> kauppalista;
    private ArrayList<Ainesosa> reseptinAinesosat;
    private ArrayList<Ainesosa> kaapissaOlevatAinesosat;

    // kauppalistan luovalle konstruktorille annetaan resepti, jota ollaan tekemässä,
    // sekä lista ainesosista, jotka ovat valmiiksi kaapissa
    public Kauppalista(Resepti resepti, ArrayList<Ainesosa> kaapissaOlevatAinesosat) {
        this.kauppalista = new ArrayList<Ainesosa>();
        this.reseptinAinesosat = resepti.listaaAinesosat();
        this.kaapissaOlevatAinesosat = kaapissaOlevatAinesosat;
        
        this.luoKauppalista(); // konstruktori luo kauppalistan
    }
    
    public ArrayList<String> kaapissaOlevienAinesosienNimet() {
        ArrayList<String> nimet = new ArrayList<String>();
        for (Ainesosa ainesosa : this.kaapissaOlevatAinesosat) {
            nimet.add(ainesosa.getNimi());
        }
        return nimet;
    }
    
    public void luoKauppalista() {
        for (Ainesosa ainesosa : this.reseptinAinesosat) {
            if (!this.kaapissaOlevienAinesosienNimet().contains(ainesosa.getNimi())) {
                // ehtolause tutkii, onko kaapissa reseptiin tarvittava ainesosa valmiina
                this.kauppalista.add(ainesosa);
            }
        }
    }
    
    @Override
    public String toString() { // palauttaa kauppalistan Stringinä
        String lista = "";
        for (Ainesosa ainesosa : this.kauppalista) {
            lista = lista + ainesosa.getNimi() + "\n";
        }
        return lista;
    }
}
