package reseptikone.logiikka;

/**
 * Luokka sisältää toiminnan tiettyjä ainesosia sisältävän reseptin etsimistä varten.
 */
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import reseptikone.logiikka.tiedostojenkasittely.TiedostonLukija;

public class ReseptinEtsija {

    private ArrayList<String> kayttajanKaapinSisalto;
    private TiedostonLukija tiedostonLukija;
    private ArrayList<String> reseptienNimet;
    private HashMap<Resepti, Integer> mahdollisetReseptit;

    /**
     * Konstruktori.
     * <p>
     * Saa parametrinaan kaappi-olion, josta saadaan käyttäjän kaapissa 
     * olevat ainesosat, minkä jälkeen luodaan lista reseptien nimistä ja alustetaan 
     * HashMap, jonka avaimina ovat reseptit ja arvoina niistä puuttuvien ainesosien 
     * määrä.
     * 
     * @param kayttajanKaappi 
     */
    public ReseptinEtsija(Kaappi kayttajanKaappi) {
        kayttajanKaapinSisalto = kayttajanKaappi.getSisalto();
        listaaReseptienNimet();
        mahdollisetReseptit = new HashMap<Resepti, Integer>();
    }

    private void listaaReseptienNimet() {
        tiedostonLukija = new TiedostonLukija(new File("reseptit/reseptienNimet.md"));
        reseptienNimet = tiedostonLukija.palautaTiedostoListana();
    }
    

    private void muodostaHashMapMahdollisistaResepteista() {
        for (String reseptinNimi : reseptienNimet) {
            Resepti resepti = new Resepti(reseptinNimi);

            int kaapistaPuuttuvienAinesosienMaara = 0;

            for (String ainesosa : resepti.getAinesosat()) {
                if (!kayttajanKaapinSisalto.contains(ainesosa)) {
                    kaapistaPuuttuvienAinesosienMaara++;
                }
            }
            mahdollisetReseptit.put(resepti, kaapistaPuuttuvienAinesosienMaara);
        }
    }

    /**
     * Metodin avulla etsitään käyttäjän kaapissa oleva resepti.
     * <p>
     * Ensin muodostetaan HashMap mahdollisista resepteistä. Sen jälkeen 
     * käydään ne läpi ja valitaan sellainen, jonka ainekset ovat valmiina kaapissa. 
     * Jos sellaista ei ole, palautetaan null.
     * 
     * @return palautettava resepti
     */
    
    public Resepti etsiKayttajanKaapissaOlevaResepti() {
        muodostaHashMapMahdollisistaResepteista();

        for (Resepti resepti : mahdollisetReseptit.keySet()) {
            if (mahdollisetReseptit.get(resepti) == 0) {
                return resepti;
            }
        }
        return null;
    }
    
    /**
     * Jos ei ole valmiiksi kaapissa olevaa reseptiä, etsitään seuraavaksi optimaalisin.
     * 
     * @return resepti
     */
    public Resepti etsiSeuraavaksiOptimaalisinResepti() {
        muodostaHashMapMahdollisistaResepteista();

        int pieninPuuttuvaAinesmaara = 1000;
        String palautettavanReseptinNimi = "";

        for (Resepti resepti : mahdollisetReseptit.keySet()) {
            if (mahdollisetReseptit.get(resepti) < pieninPuuttuvaAinesmaara) {
                pieninPuuttuvaAinesmaara = mahdollisetReseptit.get(resepti);
                palautettavanReseptinNimi = resepti.getNimi();
            }
        }
        Resepti palautettavaResepti = new Resepti(palautettavanReseptinNimi);
        
        return palautettavaResepti;
    }

}