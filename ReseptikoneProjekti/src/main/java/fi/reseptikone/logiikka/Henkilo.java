package fi.reseptikone.logiikka;

import java.util.ArrayList;

public class Henkilo {
    ArrayList<Ainesosa> kaapissaOlevatAinekset;
    
    public Henkilo() {
        this.kaapissaOlevatAinekset = new ArrayList<Ainesosa>();
    }
    
    public ArrayList<Ainesosa> kerroKaapinSisalto() {
        return this.kaapissaOlevatAinekset;
    }
    
    public void lisaaAinesKaappiin(Ainesosa ainesosa) {
        for (Ainesosa kaapissaOlevaAinesosa : this.kaapissaOlevatAinekset) {
            if (kaapissaOlevaAinesosa.getNimi().equals(ainesosa.getNimi())) {
                return;
            }
        }
        this.kaapissaOlevatAinekset.add(ainesosa);
    }
    
    
}
