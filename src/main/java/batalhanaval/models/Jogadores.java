
package batalhanaval.models;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.*;


/**
 *
 * @author Zetsubou
 */
@Entity
@Table(name="jogador")
public class Jogadores implements Serializable {
    
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idjogador")
    private int id;
    
    @Column(name = "nome")
    private String nome;
   
    @Column(name = "status")
    private short status;
    
    @ManyToOne
    @JoinColumn(name = "jogo_idjogo", referencedColumnName = "idjogo")
    private Partida jogoIdjogo;
    
    @OneToMany(mappedBy = "j1", targetEntity = Ataque.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final List<Ataque> ataques = new ArrayList<>();
    
    @OneToMany(mappedBy = "idJogador", targetEntity = Arma.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private final List<Arma> armas = new ArrayList<>();
            
    public Jogadores(){
        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adiciona(Ataque ataque){
        ataques.add(ataque);
    }
    
    public List<Ataque> getAtaques(){
        return ataques;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Partida getJogoIdjogo() {
        return jogoIdjogo;
    }

    public void setJogoIdjogo(Partida jogoIdjogo) {
        this.jogoIdjogo = jogoIdjogo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + this.id;
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
        final Jogadores other = (Jogadores) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }


    
}
