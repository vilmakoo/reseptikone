package fi.reseptikone.logiikka;

import java.util.ArrayList;

public class Resepti {
    
    private String nimi;
    private ArrayList<Ainesosa> ainesosat;
    private String ohje;
    
    public Resepti(String nimi, ArrayList<Ainesosa> ainesosat, String ohje) {
        this.nimi = nimi;
        this.ainesosat = ainesosat;
        this.ohje = ohje;
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
        return this.ainesosat;
    }
    
    @Override
    public String toString() {
        return this.nimi + this.listaaAinesosatOhjeeseen() + "\n\n" + this.ohje;
    }
}
