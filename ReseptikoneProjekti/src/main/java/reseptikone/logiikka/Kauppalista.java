package reseptikone.logiikka;

import java.util.ArrayList;

public class Kauppalista { 

    private ArrayList<String> kauppalista;
    private ArrayList<String> reseptinAinesosat;
    private ArrayList<String> kaapissaOlevatAinesosat;

    // kauppalistan luovalle konstruktorille annetaan resepti, jota ollaan tekemässä,
    // sekä lista ainesosista, jotka ovat valmiiksi kaapissa
    public Kauppalista(Resepti resepti, ArrayList<String> kaapissaOlevatAinesosat) {
        this.kauppalista = new ArrayList<String>();
        this.reseptinAinesosat = resepti.getAinesosat();
        this.kaapissaOlevatAinesosat = kaapissaOlevatAinesosat;
        
        this.luoKauppalista(); // konstruktori kutsuu kauppalistan luovaa metodia
    }
    
    private void luoKauppalista() {
        for (String ainesosa : this.reseptinAinesosat) {
            if (!this.kaapissaOlevatAinesosat.contains(ainesosa)) {
                // ehtolause tutkii, onko kaapissa reseptiin tarvittava ainesosa valmiina
                this.kauppalista.add(ainesosa);
            }
        }
    }
    
    @Override
    public String toString() { // palauttaa kauppalistan Stringinä
        String lista = "";
        for (String ainesosa : this.kauppalista) {
            lista = lista + ainesosa + "\n";
        }
        return lista;
    }
}
