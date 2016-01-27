package fi.reseptikone;

import java.util.ArrayList;

public class Reseptinhakukone {
    
    private ArrayList<Resepti> reseptit; // lista koneen sisältämistä resepteistä
    
    public Reseptinhakukone() {
        this.reseptit = new ArrayList<Resepti>();
    }
    
    public ArrayList<String> getReseptienNimet() {
        ArrayList<String> reseptienNimet = new ArrayList<String>();
        for (Resepti resepti : this.reseptit) {
            reseptienNimet.add(resepti.getNimi());
        }
        return reseptienNimet;
    }
    
    public void listaaReseptit() { // listaa koneen sisältämät reseptit
        for (Resepti resepti : this.reseptit) {
            System.out.println(resepti + "\n\n");
        }
    }
    
    public void lisaaResepti(String nimi, ArrayList<Ainesosa> ainesosat) { // käyttäjä voi lisätä reseptin koneeseen
        Resepti resepti = new Resepti(nimi, ainesosat);
        this.reseptit.add(resepti);
    }
}
