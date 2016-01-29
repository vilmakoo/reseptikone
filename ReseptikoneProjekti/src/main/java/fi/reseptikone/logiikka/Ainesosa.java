package fi.reseptikone.logiikka;

public class Ainesosa {

    private String nimi;
    private String maara;

    public Ainesosa(String nimi) {
        this.nimi = nimi;
    }

    public void asetaMaara(String maara) {
        this.maara = maara;
    }

    public String getNimi() {
        return this.nimi;
    }

    public String getMaara() {
        return this.maara;
    }

    @Override
    public String toString() {
        if (this.maara != null) {
            return this.nimi + ", " + this.maara;
        } else {
            return this.nimi;
        }
    }
}
