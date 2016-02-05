package fi.reseptikone.logiikka;

import java.util.ArrayList;

public class Henkilo {
    ArrayList<String> kaapissaOlevatAinekset;
    
    public Henkilo() {
        this.kaapissaOlevatAinekset = new ArrayList<String>();
    }
    
    public ArrayList<String> kerroKaapinSisalto() {
        return this.kaapissaOlevatAinekset;
    }
    
    public void lisaaAinesKaappiin(String ainesosa) {
        for (String kaapissaOlevaAinesosa : this.kaapissaOlevatAinekset) {
            if (kaapissaOlevaAinesosa.equals(ainesosa)) {
                return;
            }
        }
        this.kaapissaOlevatAinekset.add(ainesosa);
    }
    
    
}
