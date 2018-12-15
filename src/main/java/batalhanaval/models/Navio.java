
package batalhanaval.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Zetsubou
 */
public interface Navio {
    public int getTamanhoNavio();
    public int getQtdDeNavios();	
    public String getNomeNavio();
}
