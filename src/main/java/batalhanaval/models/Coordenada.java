
package batalhanaval.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Zetsubou
 */
@Entity
@Table(name="coord")
public class Coordenada implements Serializable{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idcoord")
    private int idC;
    private int linha;
    private int coluna;
    
    @ManyToOne
    @JoinColumn(name="arma_idarma", referencedColumnName = "idarma")
    private Arma arma_idarma;

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

    public Arma getArma_idarma() {
        return arma_idarma;
    }

    public void setArma_idarma(Arma arma_idarma) {
        this.arma_idarma = arma_idarma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idC;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coordenada other = (Coordenada) obj;
        if (this.idC != other.idC) {
            return false;
        }
        return true;
    }
  
}
