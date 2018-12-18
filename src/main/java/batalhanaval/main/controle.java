
package batalhanaval.main;

import batalhanaval.dao.CoordDAO;
import batalhanaval.dao.JogadorDAO;
import batalhanaval.dao.JogoDAO;
import batalhanaval.infra.EMFactory;
import batalhanaval.models.Coordenada;
import batalhanaval.models.Jogadores;
import batalhanaval.models.Partida;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Zetsubou
 */
public class controle {
    EntityManager manager = EMFactory.getEntityManager();
    JogadorDAO dao = new JogadorDAO(manager);
    JogoDAO dao1 = new JogoDAO(manager);
    CoordDAO dao2 = new CoordDAO(manager);
    
    
    public List<Jogadores> retornaListaJogadores (){
        List<Jogadores> strList = new ArrayList<>();
        List<Jogadores> jog = dao.listarTodosJogadores().getResultList();
        
        for(Jogadores j1 : jog) {
            Jogadores j2 = new Jogadores();
            j2.setId(j1.getId());
            j2.setNome(j1.getNome());
            strList.add(j2);
        }
        return strList;
    }
    
    public List<Partida> retornaListaJogos(){
        List<Partida> strList = new ArrayList<>();
        List<Partida> jog = dao1.listarTodosJogos().getResultList();
        
        for(Partida j1 : jog) {
            Partida j2 = new Partida();
            j2.setId(j1.getId());
            j2.setNome(j1.getNome());
            strList.add(j2);
        }
        
        return strList;
    }
    
    public Partida findJogo(int j1){
       return dao1.porId(j1);
    }
    
    public void attJogo(Partida j1){
        dao1.att(j1);
    }
    
    public void attJogador(Jogadores j1){
        dao.att(j1);
    }
    
     public Jogadores findJogador(int j1){
        return dao.buscaPorId(j1);
    }
     
     public void salvaCoord(Coordenada c2){
         dao2.salvaNovo(c2);
     }
     
     public List<Coordenada> puxaLista(){
         List<Coordenada> strList = new ArrayList<>();
        List<Coordenada> jog = dao2.listarTodasCoord().getResultList();
        
        for(Coordenada j1 : jog) {
            Coordenada j2 = new Coordenada();
            j2.setIdC(j1.getIdC());
            j2.setLinha(j1.getLinha());
            j2.setColuna(j1.getColuna());
            strList.add(j2);
        }
        
        return strList;
     }
}
