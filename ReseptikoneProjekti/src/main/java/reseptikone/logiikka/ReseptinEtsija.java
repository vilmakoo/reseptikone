package reseptikone.logiikka;

// etsii reseptin, jossa on tietyt ainesosat, ja palauttaa sen
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

    public ReseptinEtsija(Kaappi kayttajanKaappi) {
        kayttajanKaapinSisalto = kayttajanKaappi.getSisalto();
        listaaReseptienNimet();
        mahdollisetReseptit = new HashMap<Resepti, Integer>();
    }

    private void listaaReseptienNimet() {
        tiedostonLukija = new TiedostonLukija(new File("reseptit/reseptienNimet.md"));
        reseptienNimet = tiedostonLukija.palautaTiedostoListana();
    }
    

    private void muodostaHashMapMahdollisistaResepteistä() {
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

    public Resepti etsiResepti() {
        muodostaHashMapMahdollisistaResepteistä();

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
