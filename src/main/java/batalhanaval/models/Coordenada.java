
package batalhanaval.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Zetsubou
 */
@Entity
@Table(name="coord")
public class Coordenada{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idC;
    private int linha;
    private int coluna;
    

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
}
