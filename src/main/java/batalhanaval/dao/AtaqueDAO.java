
package batalhanaval.dao;

import batalhanaval.models.Ataque;
import javax.persistence.EntityManager;

/**
 *
 * @author Zetsubou
 */
public class AtaqueDAO {
    private EntityManager manager;
	
	public AtaqueDAO(EntityManager manager) {
		this.manager = manager;
	}
    
    public void salvaNovo(Ataque p1){
        try{
            this.manager.getTransaction().begin();
            this.manager.persist(p1);
            this.manager.getTransaction().commit();
        }catch (Exception ex) 
        {
            ex.printStackTrace();
            this.manager.getTransaction().rollback();
        }finally 
        {
            this.manager.close();
        } 
    } 
}
