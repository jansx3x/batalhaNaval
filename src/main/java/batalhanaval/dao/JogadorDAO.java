
package batalhanaval.dao;

import batalhanaval.models.Jogadores;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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
    }  
    
    public Jogadores buscaPorId(Integer id) {
        return manager.find(Jogadores.class, id);
    }
    
    public TypedQuery<Jogadores> listarTodosJogadores(){
        return manager.createQuery("FROM Jogadores",Jogadores.class);
    }
    
    public void att(Jogadores j1){
       try{
            this.manager.getTransaction().begin();
            this.manager.merge(j1);
            this.manager.getTransaction().commit();
        }catch (Exception ex) 
        {
            ex.printStackTrace();
            this.manager.getTransaction().rollback();
        } 
    }
    
}
