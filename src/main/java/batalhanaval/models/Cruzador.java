
package batalhanaval.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Zetsubou
 */
@Entity
@DiscriminatorValue(value = "C")
public class Cruzador extends Arma{
    @Column(name = "qnt")
    private final int qtdDeNavios = 3;
    @Column(name = "tamanho")
    private final int tamanhoNavio = 3;
    @Column(name = "nome")
    private final String nomeNavio = "Cruzador";

    public Cruzador(){
        
    }
    
    public int getTamanhoNavio() {
            return tamanhoNavio;
    }

    public int getQtdDeNavios() {
            return qtdDeNavios;
    }

    public String getNomeNavio(){
            return nomeNavio;
    }   

    @Override
    public String toString() {
        return "Cruzador{" + "qtdDeNavios=" + qtdDeNavios + ", tamanhoNavio=" + tamanhoNavio + ", nomeNavio=" + nomeNavio + '}';
    }
       
    
}
