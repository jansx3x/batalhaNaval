
package batalhanaval.main;

import javax.swing.SwingUtilities;
import batalhanaval.gui.tabuleiro;
import batalhanaval.models.Jogadores;
import batalhanaval.models.Partida;
/**
 *
 * @author Zetsubou
 */
public class principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                controle c1 = new controle();
                Partida p1 = (c1.findJogo(1));
                Jogadores j1 = (c1.findJogador(1));
                tabuleiro telaInicial = new tabuleiro(p1, j1);
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
        /*
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
                
        manager.close();*/
   
    }
}
