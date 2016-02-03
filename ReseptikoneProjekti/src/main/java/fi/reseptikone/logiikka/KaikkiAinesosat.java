package fi.reseptikone.logiikka;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;

public class KaikkiAinesosat {
    private List<String> kaikki;
    private List<String> juomat;
    private List<String> kasvikset;
    private List<String> sailykkeet;
    private List<String> mausteetJaKastikkeet;
    private List<String> maitotuotteetTms;
    private List<String> kuivatuotteet;
    private List<String> muut;
    
    public KaikkiAinesosat() {
        this.juomat = asList("maito", "piimä", "punaviini", "valkoviini");
        this.kasvikset = asList("kurkku", "peruna", "kaali");
        this.sailykkeet = asList("mustapavut", "ananas", "tomaatit");
        this.mausteetJaKastikkeet = asList("suola", "sokeri", "tomaattimurska", "ketsuppi", 
                "pippuri", "sinappi");
        this.maitotuotteetTms = asList("jäätelö", "turkkilainen jogurtti", "soijajuoma", "maitorahka");
        this.kuivatuotteet = asList("makaroni", "soijarouhe", "riisi");
        this.muut = asList("jääpalat");
        
        this.kaikki = new ArrayList<String>();
        this.muodostaListaKaikista();
    }
    
    public void muodostaListaKaikista() {
        for (String juoma : this.juomat) {
            this.kaikki.add(juoma);
        }
        for (String kasvis : this.kasvikset) {
            this.kaikki.add(kasvis);
        }
        for (String sailyke : this.sailykkeet) {
            this.kaikki.add(sailyke);
        }
        for (String mausteTaiKastike : this.mausteetJaKastikkeet) {
            this.kaikki.add(mausteTaiKastike);
        }
        for (String maitotuoteTms : this.maitotuotteetTms) {
            this.kaikki.add(maitotuoteTms);
        }
        for (String kuivatuote : this.kuivatuotteet) {
            this.kaikki.add(kuivatuote);
        }
        for (String muu : this.muut) {
            this.kaikki.add(muu);
        }
    }
    
    public List<String> getKaikki() {
        return this.kaikki;
    }
    
    public List<String> getJuomat() {
        return this.juomat;
    }
    
    public List<String> getVihannekset() {
        return this.kasvikset;
    }
    
    public List<String> getSailykkeet() {
        return this.sailykkeet;
    }
    
    public List<String> getMausteetJaKastikkeet() {
        return this.mausteetJaKastikkeet;
    }
    
    public List<String> getMaitotuotteetTms() {
        return this.maitotuotteetTms;
    }
    
    public List<String> getKuivatuotteet() {
        return this.kuivatuotteet;
    }
    
    public List<String> getMuut() {
        return this.muut;
    }
}
