
package batalhanaval.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zetsubou
 */
public class EMFactory {
    	private static EntityManagerFactory emf;
        
        static {
            emf = Persistence.createEntityManagerFactory("batalha1");
        }
	
	public static EntityManager getEntityManager()  {
            return emf.createEntityManager();
	}
	
	
	public static void close() {
            emf.close();
	}
}
