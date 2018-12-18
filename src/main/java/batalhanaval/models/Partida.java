
package batalhanaval.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author Zetsubou
 */
@Entity
@Table(name="jogo")
public class Partida implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idjogo")
    private int id;  
    
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(mappedBy = "jogoIdjogo", targetEntity = Jogadores.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Jogadores> jogadores = new ArrayList<>();
    
    @OneToMany(mappedBy = "ataques2", targetEntity = Ataque.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ataque> ataques2 = new ArrayList<Ataque>();
    
    public Partida() {
  
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

    public List<Jogadores> getJogador(){
	return jogadores;
	}
	
    public void adiciona(Jogadores joga) {
        jogadores.add(joga);
    }

    public List<Ataque> getAtaques2() {
        return ataques2;
    }

    public void adicionaAtaques2(Ataque atk2) {
        ataques2.add(atk2);
    }
 
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
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
        final Partida other = (Partida) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
     
    @Override
    public String toString() {
        return this.nome;
    }
}
