
package batalhanaval.dao;

import batalhanaval.models.Jogadores;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

/**
 *
 * @author Zetsubou
 */
public class JogadorDAO {
    private final EntityManager manager;
    
    public JogadorDAO(EntityManager manager){
        this.manager = manager;
    }
    
    public void salvaNovo(Jogadores j1){
        try{
            this.manager.getTransaction().begin();
            this.manager.persist(j1);
            this.manager.getTransaction().commit();
        }catch (PersistenceException e) 
        {
            this.manager.getTransaction().rollback();
        } 
        finally 
        {
            this.manager.close();
        }      
    }  
    
    public Jogadores buscaPorId(Integer id) {
        return manager.find(Jogadores.class, id);
    }
    
    public List<Jogadores> listarTodosJogos(){
        return manager.createQuery("SELECT nome FROM jogador",Jogadores.class)
            .getResultList();
    }
}
