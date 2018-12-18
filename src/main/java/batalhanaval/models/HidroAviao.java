
package batalhanaval.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author Zetsubou
 */
@Entity
@DiscriminatorValue(value = "5")
public class HidroAviao extends Arma{
    @Column(name = "qnt")
    private final int qtdDeNavios = 2;
    @Column(name = "tamanho")
    private final int tamanhoNavio = 5;
    @Column(name = "nome")
    private final String nomeNavio = "Hidroavião";
    
    public HidroAviao(){
        
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
        return "HidroAviao";
    }   
}
