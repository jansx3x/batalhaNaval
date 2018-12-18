
package batalhanaval.dao;

import batalhanaval.models.Arma;
import batalhanaval.models.Coordenada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
    
    public TypedQuery<Coordenada> listarTodasCoord(){
        return manager.createQuery("FROM Coordenada",Coordenada.class);       
    }

    public List<Object[]> listaAlugueisDe(Arma a1){
	List<Object[]> coords = null;
		
        coords = this.manager.createQuery("from Coordenada a where a.a1= :a1",Object[].class)
                        .setParameter("a1",a1.getId()).getResultList();
        return coords;
	}
}
