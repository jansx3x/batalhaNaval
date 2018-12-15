
package batalhanaval.gui;

import batalhanaval.main.startJogo;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Zetsubou
 */
public class tabuleiro extends JFrame{
    //painel
    JPanel grid = new JPanel();
    JPanel jcp = new JPanel();
    Container cp;
    
    //botões
    JButton[][] Botoes = new JButton[10][10];
    JButton dist = new JButton("Distribuir Navios");
    JButton att = new JButton("Atualizar");
    JButton voltar = new JButton("Voltar");
    
    //labels
    JLabel naviosRestantes = new JLabel("Meus Navios");
    JLabel tirosRestantes = new JLabel("Tiros Restantes");
    JLabel contNavios = new JLabel("");
    JLabel contTiros = new JLabel("");
    int contadorNavio = 12;
    int contadorTiros = 3;
    
    //vetor
    int vetor[][] = new int[10][10];
    String nomeJogador;
    
    startJogo jogo = new startJogo();
    
    public tabuleiro(String nomeJogador){
        //JFrame
        setTitle("Batalha Naval");
        setSize(647, 415);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Container
        setContentPane(jcp);
        cp = getContentPane();
        cp.setLayout(null);
        
        //botões
        grid.setBounds(3, 58, 497, 325);
        grid.setLayout(new GridLayout(10, 10, 2, 2));
        
        for (int linha = 0; linha < 10; linha++){
            for (int coluna = 0; coluna < 10; coluna++){
                Botoes[linha][coluna] = new JButton("");
                //Botoes[linha][coluna].addActionListener();
                Botoes[linha][coluna].setFocusable(false);
                grid.add(Botoes[linha][coluna]);
            }
        }
        
        dist.setBounds(520, 194, 96, 35);
        dist.setFocusable(false);
        
        att.setBounds(520, 214, 96, 35);
	att.setFocusable(false);
        //att.addActionListener(this);
        
        voltar.setBounds(520, 254, 96, 35);
        voltar.setFocusable(false);
        //voltar.addActionListener(this);
        
        //label
        naviosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
        naviosRestantes.setBounds(510, 50, 150, 18);
        
        tirosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
        tirosRestantes.setBounds(510, 100, 118, 18);
        
        contNavios.setFont(new Font("Roboto", Font.BOLD, 18));
        contNavios.setBounds(530, 68, 20, 26);
        contNavios.setText("" + contadorNavio);
        
        contTiros.setFont(new Font("Roboto", Font.BOLD, 18));
	contTiros.setBounds(530, 121, 20, 26);
        contTiros.setText("0" + contadorTiros);

        cp.add(grid);
        cp.add(dist);
        cp.add(att);
        cp.add(voltar);
        cp.add(naviosRestantes);
        cp.add(tirosRestantes);
        cp.add(contNavios);
        cp.add(contTiros);
        
        //método para escolher os locais
        //startJogo.distribuir;
        //jogo.iniciaJogo(vetor);
        
    }
}
