
package batalhanaval.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Zetsubou
 */
@Entity
@DiscriminatorValue(value = "H")
public class HidroAviao extends Arma{
    @Column(name = "qnt")
    private final int qtdDeNavios = 2;
    @Column(name = "tamanho")
    private final int tamanhoNavio = 5;
    @Column(name = "nome")
    private final String nomeNavio = "Hidroavião";
    
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
