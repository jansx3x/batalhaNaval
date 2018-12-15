
package batalhanaval.main;

import javax.swing.SwingUtilities;
import batalhanaval.gui.m_principal;
/**
 *
 * @author Zetsubou
 */
public class principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                m_principal telaInicial = new m_principal();
                telaInicial.setVisible(true);
            }
        });		
    }
}
