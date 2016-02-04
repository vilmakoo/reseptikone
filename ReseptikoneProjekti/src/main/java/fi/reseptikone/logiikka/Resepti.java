package fi.reseptikone.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Resepti {
    
    private String nimi;
    private ArrayList<Ainesosa> ainesosat;
    private String ohje;
    private File ohjeTiedosto;
    private File ainesosaTiedosto;
    private Scanner ohjeenLukija;
    private Scanner ainesosienLukija;
    
    public Resepti(String reseptinNimi) throws FileNotFoundException {
        this.nimi = reseptinNimi;
        String reseptiTiedostonNimi = this.nimi + "/resepti.md";
        String ainesosaTiedostonNimi = this.nimi + "/ainesosat.md";
        this.ohjeTiedosto = new File(reseptiTiedostonNimi);
        this.ainesosaTiedosto = new File(ainesosaTiedostonNimi);
        this.ohjeenLukija = new Scanner(this.ohjeTiedosto);
        this.ainesosienLukija = new Scanner(this.ainesosaTiedosto);
        
        this.muodostaListaAinesosista();
        this.muodostaOhje();
    }
    
    private void muodostaListaAinesosista() {
        while (this.ainesosienLukija.hasNextLine()) {
            Ainesosa ainesosa = new Ainesosa(this.ainesosienLukija.nextLine());
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
    
    public ArrayList getAinesosat() { //palauttaa listan ainesosista
        return this.ainesosat;
    }
    
    @Override
    public String toString() {
        return this.ohje;
    }
}
