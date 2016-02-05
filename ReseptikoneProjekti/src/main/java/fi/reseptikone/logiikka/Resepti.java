package fi.reseptikone.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Resepti {
    
    private String nimi;
    private ArrayList<String> ainesosat;
    private String ohje;
    private Scanner ohjeenLukija;
    private Scanner ainesosienLukija;
    
    public Resepti(String reseptinNimi) throws FileNotFoundException {
        this.nimi = reseptinNimi;
        String polkuOhjeeseen = "reseptit/" + this.nimi + "Ohje.md";
        String polkuAinesosiin = "reseptit/" + this.nimi + "Ainesosat.md";
        this.ohjeenLukija = new Scanner(new File(polkuOhjeeseen));
        this.ainesosienLukija = new Scanner(new File(polkuAinesosiin));
        
        this.muodostaListaAinesosista();
        this.muodostaOhje();
    }
    
    private void muodostaListaAinesosista() {
        this.ainesosat = new ArrayList<String>();
        while (this.ainesosienLukija.hasNextLine()) {
            String ainesosa = new String(this.ainesosienLukija.nextLine());
            this.ainesosat.add(ainesosa);
        }
    }
    
    private void muodostaOhje() {
        this.ohje = "";
        while (this.ohjeenLukija.hasNextLine()) {
            this.ohje = this.ohje + this.ohjeenLukija.nextLine() + "\n";
        }
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public ArrayList<String> getAinesosat() { //palauttaa listan ainesosista
        return this.ainesosat;
    }
    
    
    @Override
    public String toString() {
        return this.ohje;
    }
}
