
package reseptikone.kayttoliittyma.tapahtumankuuntelijat;

import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_BACK_SPACE;
import java.awt.event.KeyListener;

public class NappaimistonKuuntelija implements KeyListener {
    
    private StringBuilder mihinKirjoitetaan;
    
    public NappaimistonKuuntelija() {
        this.mihinKirjoitetaan = new StringBuilder();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        mihinKirjoitetaan.append(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == VK_BACK_SPACE) {
            mihinKirjoitetaan.deleteCharAt(mihinKirjoitetaan.length() - 1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public String getTeksti() {
        return this.mihinKirjoitetaan.toString();
    }
}
