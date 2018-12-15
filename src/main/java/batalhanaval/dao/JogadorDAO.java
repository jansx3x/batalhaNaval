
package batalhanaval.dao;

import batalhanaval.models.Jogador;
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
    
    public void salvaNovo(Jogador j1){
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
}
