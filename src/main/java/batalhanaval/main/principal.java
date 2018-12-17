
package batalhanaval.main;

import batalhanaval.dao.ArmaDAO;
import batalhanaval.dao.AtaqueDAO;
import batalhanaval.dao.CoordDAO;
import batalhanaval.dao.JogadorDAO;
import javax.swing.SwingUtilities;
import batalhanaval.gui.m_principal;
import batalhanaval.infra.EMFactory;
import batalhanaval.models.Arma;
import batalhanaval.models.Ataque;
import batalhanaval.models.Coordenada;
import batalhanaval.models.Cruzador;
import batalhanaval.models.Encouracado;
import batalhanaval.models.HidroAviao;
import batalhanaval.models.Jogadores;
import batalhanaval.models.PortaAviao;
import batalhanaval.models.Submarino;
import javax.persistence.EntityManager;
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
        CoordDAO dao1 = new CoordDAO(manager);
        
        Coordenada coord = new Coordenada();
        coord.setA1(dao.buscaPorId(1));
        coord.setColuna(8);
        coord.setLinha(4);
        dao1.salvaNovo(coord);
        
        /*dao.salvaNovo(navio1);
        Encouracado navio2 = new Encouracado();
        dao.salvaNovo(navio2);
        HidroAviao navio3 = new HidroAviao();
        dao.salvaNovo(navio3);
        PortaAviao navio4 = new PortaAviao();
        dao.salvaNovo(navio4);
        Submarino navio5 = new Submarino();
        dao.salvaNovo(navio5);
        */        
        manager.close();
   
    }
}
