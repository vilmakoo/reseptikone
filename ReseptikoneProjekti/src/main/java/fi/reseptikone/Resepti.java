package fi.reseptikone;

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
    
    public String listaaAinesosat() {
        String listaus = "";
        for (Ainesosa ainesosa : this.ainesosat) {
            listaus = "\n" + ainesosa.getMaara() + " " + ainesosa.getNimi();
        }
        return listaus;
    }
    
    @Override
    public String toString() {
        return this.nimi + this.listaaAinesosat();
    }
}
