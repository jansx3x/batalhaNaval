
package batalhanaval.dao;

import batalhanaval.models.Arma;
import javax.persistence.EntityManager;

/**
 *
 * @author Zetsubou
 */
public class ArmaDAO {
    private EntityManager manager;
	
	public ArmaDAO(EntityManager manager) {
		this.manager = manager;
	}
    
    public void salvaNovo(Arma p1){
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
    
    public Arma buscaPorId(Integer id) {
        return manager.find(Arma.class, id);
    }
}
