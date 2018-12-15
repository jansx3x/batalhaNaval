
package batalhanaval.main;

import batalhanaval.dao.ArmaDAO;
import batalhanaval.dao.AtaqueDAO;
import batalhanaval.dao.JogadorDAO;
import javax.swing.SwingUtilities;
import batalhanaval.gui.m_principal;
import batalhanaval.infra.EMFactory;
import batalhanaval.models.Ataque;
import batalhanaval.models.Jogadores;
import javax.persistence.EntityManager;
/**
 *
 * @author Zetsubou
 */
public class principal {
    public static void main(String[] args) {
        /*SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                m_principal telaInicial = new m_principal();
                telaInicial.setVisible(true);
            }
        });	*/
        
        //teste ATAQUE
        /*
        EntityManager manager = EMFactory.getEntityManager();
        AtaqueDAO dao = new AtaqueDAO(manager);
        JogadorDAO dao1 = new JogadorDAO(manager);
        
        Jogadores j1 = new Jogadores();
        j1 = dao1.buscaPorId(1);
        Ataque atk = new Ataque();
        atk.setColuna(1);
        atk.setLinha(3);
        atk.setJ1(j1);
        
        dao.salvaNovo(atk);*/
        
        //teste ARMA
        EntityManager manager = EMFactory.getEntityManager();
        ArmaDAO dao = new ArmaDAO(manager);
        
    }
}
