/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reseptikone.kayttoliittyma.tapahtumankuuntelijat;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author vilma
 */
public class ListavalinnanKuuntelija implements ListSelectionListener {
    
    private ArrayList<String> reseptinAinesosat;
    private DefaultListModel kaikkiAinesosat;
    
    public ListavalinnanKuuntelija(ArrayList<String> reseptinAinesosat, DefaultListModel kaikkiAinesosat) {
        this.reseptinAinesosat = reseptinAinesosat;
        this.kaikkiAinesosat = kaikkiAinesosat;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        
        if (!e.getValueIsAdjusting()) {
            int minIndeksi = lsm.getMinSelectionIndex();
            int maxIndeksi = lsm.getMaxSelectionIndex();
            for (int i = minIndeksi; i <= maxIndeksi; i++) {
                if (lsm.isSelectedIndex(i)) {
                    this.reseptinAinesosat.add((String) kaikkiAinesosat.get(i));
                    System.out.println(kaikkiAinesosat.get(i));
                }
            }
        }
    }
    
}
