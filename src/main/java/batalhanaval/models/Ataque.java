
package batalhanaval.models;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Zetsubou
 */
@Entity
@Table(name="ataque")
public class Ataque implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idataque")
    private Integer idataque;
    
    @Column(name = "linha")
    private int linha;
    
    @Column(name = "coluna")
    private int coluna;
    
    @ManyToOne
    @JoinColumn(name = "jogador_idjogador", nullable=false)
    private Jogadores j1;

    public Ataque(){
        
    }

    public Integer getIdataque() {
        return idataque;
    }

    public void setIdataque(Integer idataque) {
        this.idataque = idataque;
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

    public Jogadores getJ1() {
        return j1;
    }

    public void setJ1(Jogadores j1) {
        this.j1 = j1;
    }
    
    @Override
    public String toString() {
        return "batalhanaval.models.Ataque[ idataque=" + idataque + " ]";
    }
    
    
}
