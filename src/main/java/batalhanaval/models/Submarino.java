
package batalhanaval.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Zetsubou
 */
@Entity
@DiscriminatorValue(value = "S")
public class Submarino extends Arma{
    @Column(name = "qnt")
    private final int qtdDeNavios = 3;
    @Column(name = "tamanho")
    private final int tamanhoNavio = 4;
    @Column(name = "nome")
    private final String nomeNavio = "Submarino";
    
    public Submarino(){
        
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
}
