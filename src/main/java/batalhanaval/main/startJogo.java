
package batalhanaval.main;

import batalhanaval.models.Coordenada;
import batalhanaval.models.Cruzador;
import batalhanaval.models.Encouracado;
import batalhanaval.models.HidroAviao;
import batalhanaval.models.Navio;
import batalhanaval.models.PortaAviao;
import batalhanaval.models.Submarino;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Zetsubou
 */
public class startJogo {
    
    private Random generate = new Random();
    
    public void iniciaJogo(int[][] vetor, Coordenada idA){ 
        int linha = idA.getLinha();
        int coluna = idA.getColuna();
        boolean cabe = false;
        
        ArrayList<Navio> navios = new ArrayList<>();
        
        navios.add(new Cruzador());
        navios.add(new Encouracado());
        navios.add(new HidroAviao());
        navios.add(new PortaAviao());
        navios.add(new Submarino());
        
        // Preenche o vetor com Zeros (0)
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                vetor[i][j] = 0;
            }
        }
            
        for(int cont = 0; cont < navios.size(); cont++){
            int contador = 0;
            while(navios.get(cont).getQtdDeNavios() > contador) {				
				
                //orientação do navio. 0 Vertical. 1 Horizontal
                int orientacao = generate.nextInt(2);
				
                // Verifica se o navio cabe na posição do tabuleiro criada
                cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
				
				// Se o Navio não couber, gera outra posição
				if(cabe == false){
					while(cabe == false){
						linha = generate.nextInt(10); // Linha
						coluna = generate.nextInt(10); // Coluna
						cabe = cabeNavio(linha, coluna, orientacao, navios.get(cont).getTamanhoNavio(), vetor);
					}
				}
				
				// Se o Navio couber, distribui os navios 
				if (orientacao == 0){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						linha++;
					}
				}
				
				else if (orientacao == 1){
					for (int i = 0; i < navios.get(cont).getTamanhoNavio(); i++){
						vetor[linha][coluna] = 1;
						coluna++;
					}
				}
				contador++;
			}
		}

    }
    
    public boolean cabeNavio(int linha, int coluna, int orientacao, int tamanho, int vetor[][]){
    // Se a orientação for Vertical, trava a coluna e incrementa a linha
        if (orientacao == 0){
            if (linha > (9 - tamanho)){
                return false;
            }
            for (int row = 0; row < tamanho; row++){
                if (vetor[linha][coluna] == 0){
                    linha++;
                }
                else {
                    return false;
                }
            }
            return true;
        }
		
        // Se a orientação for Horizontal, trava a linha e incrementa a coluna
        if (orientacao == 1){
            if (coluna > (9 - tamanho)){
                return false;
            }
            for (int col = 0; col < tamanho; col++){
                if (vetor[linha][coluna] == 0){
                        coluna++;
                }
                else {
                        return false;
                }
            }
            return true;
        }
        return false;
    }
}
