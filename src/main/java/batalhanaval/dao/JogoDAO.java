
package batalhanaval.dao;

import batalhanaval.models.Partida;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Zetsubou
 */
public class JogoDAO {
    private EntityManager manager;
	
	public JogoDAO(EntityManager manager) {
		this.manager = manager;
	}
    
    public void salvaNovo(Partida p1){
        try{
            this.manager.getTransaction().begin();
            this.manager.persist(p1);
            this.manager.getTransaction().commit();
        }catch (Exception ex) 
        {
            ex.printStackTrace();
            this.manager.getTransaction().rollback();
        }
    } 
    
    public List<Object[]> listaJogadoresDe(Partida jogo){
        List<Object[]> jogadores = null;

        jogadores = this.manager.createQuery("select j.nome from jogador j inner join j.jogo l  where l.jogo= :jogo",Object[].class)
                        .setParameter("jogo",jogo.getId()).getResultList();
        return jogadores;
    }
    
    public void att(Partida p1){
        try{
            this.manager.getTransaction().begin();
            this.manager.merge(p1);
            this.manager.getTransaction().commit();
        }catch (Exception ex) 
        {
            ex.printStackTrace();
            this.manager.getTransaction().rollback();
        } 
    }
    
    public TypedQuery<Partida> listarTodosJogos(){
        return manager.createQuery("FROM Partida WHERE status = 1",Partida.class);
            
    }
    
    public Partida porId(int id) {
	return this.manager.find(Partida.class,id);
	}
    
}
