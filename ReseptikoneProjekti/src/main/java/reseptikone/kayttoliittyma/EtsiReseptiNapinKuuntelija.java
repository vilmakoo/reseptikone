
package reseptikone.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reseptikone.logiikka.Kaappi;
import reseptikone.logiikka.Kauppalista;
import reseptikone.logiikka.reseptinhaku.Resepti;
import reseptikone.logiikka.reseptinhaku.ReseptinEtsija;

public class EtsiReseptiNapinKuuntelija implements ActionListener {

    private Kaappi kaappi;
    
    public EtsiReseptiNapinKuuntelija(Kaappi kaappi) {
        this.kaappi = kaappi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        etsiResepti();
    }
    
    public void etsiResepti() {
        ReseptinEtsija etsija = new ReseptinEtsija(this.kaappi);
        Resepti resepti = etsija.etsiKayttajanKaapissaOlevaResepti();
        if (resepti != null) {
            ReseptinNayttaja reseptinNayttaja = new ReseptinNayttaja(resepti, null);
            reseptinNayttaja.run();
        } else {
            resepti = etsija.etsiSeuraavaksiOptimaalisinResepti();
            Kauppalista kauppalista = new Kauppalista(resepti, this.kaappi.getSisalto());
            ReseptinNayttaja reseptinNayttaja = new ReseptinNayttaja(resepti, kauppalista);
            reseptinNayttaja.run();
        }
        
    }
    
}
