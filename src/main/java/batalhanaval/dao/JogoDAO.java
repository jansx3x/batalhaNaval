
package batalhanaval.dao;

import batalhanaval.models.Partida;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zetsubou
 */
public class JogoDAO {
    private static JogoDAO instance;
    protected EntityManager entityManager;
    
    public static JogoDAO getInstance(){
       if (instance == null){
            instance = new JogoDAO();
       }

       return instance;
    }
    
    private JogoDAO() {
       entityManager = getEntityManager();
     }
    
    private EntityManager getEntityManager() {
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("batalha1");
       if (entityManager == null) {
            entityManager = factory.createEntityManager();
       }
       return entityManager;
    }
    
    public void salvaNovo(Partida p1){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(p1);
            entityManager.getTransaction().commit();
        }catch (Exception ex) 
        {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        } 
    } 
    
}
