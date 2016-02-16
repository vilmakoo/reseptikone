
package reseptikone.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import reseptikone.logiikka.Kaappi;

public class AinesosavalinnanKuuntelija implements ActionListener{
    
    private Kaappi kaappi;
    private String ainesosa;
    
    public AinesosavalinnanKuuntelija(String ainesosa, Kaappi kaappi) {
        this.kaappi = kaappi;
        this.ainesosa = ainesosa;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.kaappi.lisaaAinesKaappiin(ainesosa);
    }
    
}
