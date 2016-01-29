package fi.reseptikone.logiikka;

import java.util.ArrayList;

public class Resepti {
    
    private String nimi;
    private ArrayList<Ainesosa> ainesosat;
    
    public Resepti(String nimi, ArrayList<Ainesosa> ainesosat) {
        this.nimi = nimi;
        this.ainesosat = ainesosat;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public String listaaAinesosatOhjeeseen() { //listaa ainesosien nimet JA määrät
        String listaus = "";
        for (Ainesosa ainesosa : this.ainesosat) {
            listaus = "\n" + ainesosa;
        }
        return listaus;
    }
    
    public ArrayList listaaAinesosat() { //palauttaa listan ainesosista
        ArrayList<Ainesosa> nimet = new ArrayList<Ainesosa>();
        for (Ainesosa ainesosa : this.ainesosat) {
            nimet.add(ainesosa);
        }
        return nimet;
    }
    
    public String ohje() {
        return this.nimi + this.listaaAinesosatOhjeeseen();
    }
}
