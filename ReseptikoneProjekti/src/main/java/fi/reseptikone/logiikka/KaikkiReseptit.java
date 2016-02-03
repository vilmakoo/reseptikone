package fi.reseptikone.logiikka;

import java.util.ArrayList;

public class KaikkiReseptit {
    ArrayList<Resepti> reseptit;
    
    public KaikkiReseptit() {
        this.reseptit = new ArrayList<Resepti>();
    }
    
    public void lisaaResepti(Resepti resepti) {
        this.reseptit.add(resepti);
    }
    
    public ArrayList<Resepti> getReseptit() {
        return this.reseptit;
    }
    
    public ArrayList<String> getReseptienNimet() {
        ArrayList<String> reseptienNimet = new ArrayList<String>();
        for (Resepti resepti : this.reseptit) {
            reseptienNimet.add(resepti.getNimi());
        }
        return reseptienNimet;
//        String lista = "";
//        for (String nimi : reseptienNimet) {
//            lista = lista + nimi + "\n";
//        }
//        return lista;
    }
}
