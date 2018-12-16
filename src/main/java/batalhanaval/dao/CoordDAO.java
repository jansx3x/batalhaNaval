
package batalhanaval.dao;

import batalhanaval.models.Coordenada;
import javax.persistence.EntityManager;

/**
 *
 * @author Zetsubou
 */
public class CoordDAO {
    private EntityManager manager;
	
	public CoordDAO(EntityManager manager) {
		this.manager = manager;
	}    
    
    public void salvaNovo(Coordenada p1){
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
}
