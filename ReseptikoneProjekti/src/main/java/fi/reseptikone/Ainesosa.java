package fi.reseptikone;

public class Ainesosa {

    private String nimi;
    private String maara;
    
    public Ainesosa(String nimi) {
        this.nimi = nimi;
    }
    
    public Ainesosa(String nimi, String maara) {
        this.nimi = maara;
        this.maara = maara;
    }
    
    public String getNimi() {
        return this.nimi;
    }
    
    public String getMaara() {
        return this.maara;
    }
}
