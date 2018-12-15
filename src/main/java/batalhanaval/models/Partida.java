
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
    
    @Column(name = "status")
    private short status;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jogo")
    private List<Jogador> jogadores = new ArrayList<Jogador>();

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

    public List<Jogador> getJogador(){
		return jogadores;
	}
	
    public void setJogador(List<Jogador> jogadores) {
            this.jogadores = jogadores;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
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
     
}
