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
    private Resepti palautettavaResepti;

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

            int kaapistaPuuttuvatAinekset = 0;

            for (String ainesosa : resepti.getAinesosat()) {
                if (!kayttajanKaapinSisalto.contains(ainesosa)) {
                    kaapistaPuuttuvatAinekset++;
                }
            }
            mahdollisetReseptit.put(resepti, kaapistaPuuttuvatAinekset);
        }
    }

    /**
     * Metodin avulla etsitään käyttäjälle palautettava resepti.
     * <p>
     * Ensin muodostetaan HashMap mahdollisista resepteistä. Sen jälkeen 
     * käydään ne läpi ja valitaan optimaalisin. Jos yhtään sellaista reseptiä, 
     * joka olisi valmiina käyttäjän kaapissa, ei ole, tulostetaan kauppalista.
     * 
     * @return palautettava resepti
     */
    public Resepti etsiResepti() {
        muodostaHashMapMahdollisistaResepteista();

        int pieninPuuttuvaAinesmaara = kayttajanKaapinSisalto.size();

        for (Resepti resepti : mahdollisetReseptit.keySet()) {
            if (mahdollisetReseptit.get(resepti) < pieninPuuttuvaAinesmaara) {
                pieninPuuttuvaAinesmaara = mahdollisetReseptit.get(resepti);
                palautettavaResepti = resepti;
            }
        }

        if (pieninPuuttuvaAinesmaara > 0) {
            Kauppalista kauppalista = new Kauppalista(palautettavaResepti, kayttajanKaapinSisalto);
            System.out.println(kauppalista);
        }
        return palautettavaResepti;
    }

}
