
package batalhanaval.models;

/**
 *
 * @author Zetsubou
 */
public class PortaAviao implements Navio{
    private int qtdDeNavios = 2;
    private int tamanhoNavio = 1;
    private String nomeNavio = "Porta-Avião";
    private Jogador j1;
    
    @Override
    public int getTamanhoNavio() {
            return tamanhoNavio;
    }

    @Override
    public int getQtdDeNavios() {
            return qtdDeNavios;
    }

    @Override
    public String getNomeNavio(){
            return nomeNavio;
    }        

    public Jogador getJ1() {
        return j1;
    }

    public void setJ1(Jogador j1) {
        this.j1 = j1;
    }
    
    
}
