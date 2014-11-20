package trabalhofsiap;

import fsiap.ui.JanelaSelLing;
import java.io.IOException;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * Main da aplicação
 */
public class TRABALHOFSIAP {

    public static void main(String[] args) throws IOException {

        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JanelaSelLing jan = new JanelaSelLing();

    }

}
