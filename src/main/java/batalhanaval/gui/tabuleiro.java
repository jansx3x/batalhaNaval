
package batalhanaval.gui;

import batalhanaval.main.startJogo;
import batalhanaval.models.Jogadores;
import batalhanaval.models.Partida;
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
    JPanel armas = new JPanel();
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
    JLabel contPA = new JLabel();
    JLabel contER = new JLabel();
    JLabel contCZ = new JLabel();
    JLabel contSM = new JLabel();
    JLabel contHA = new JLabel();
    JLabel portaAviao = new JLabel();
    JLabel encoura = new JLabel();
    JLabel cruzad = new JLabel();
    JLabel subma = new JLabel();
    JLabel hidroAviao = new JLabel();
    JLabel contTiros = new JLabel("");
    int contadorNavio = 12;
    int contadorTiros = 3;
    
    //vetor
    int vetor[][] = new int[10][10];
    String nomeJogador;
    
    startJogo jogo = new startJogo();
    
    public tabuleiro(Partida jogador){
        //JFrame
        setTitle("Batalha Naval");
        setSize(647, 415);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //painel
        armas.setBounds(510, 140, 110, 70);
        armas.setLayout(new GridLayout(5, 2, 2, 2));

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

        portaAviao.setFont(new Font("Roboto", Font.PLAIN, 15));
        portaAviao.setBounds(518, 138, 100, 18);
        encoura.setFont(new Font("Roboto", Font.PLAIN, 15));
        encoura.setBounds(518, 145, 100, 18);
        cruzad.setFont(new Font("Roboto", Font.PLAIN, 15));
        cruzad.setBounds(518, 168, 100, 18);
        subma.setFont(new Font("Roboto", Font.PLAIN, 15));
        subma.setBounds(518, 190, 100, 18);
        hidroAviao.setFont(new Font("Roboto", Font.PLAIN, 15));
        hidroAviao.setBounds(518, 210, 100, 18);
        contPA.setFont(new Font("Roboto", Font.PLAIN, 15));
        contPA.setBounds(508, 138, 100, 18);
        contER.setFont(new Font("Roboto", Font.PLAIN, 15));
        contER.setBounds(508, 145, 100, 18);
        contCZ.setFont(new Font("Roboto", Font.PLAIN, 15));
        contCZ.setBounds(508, 168, 100, 18);
        contSM.setFont(new Font("Roboto", Font.PLAIN, 15));
        contSM.setBounds(508, 190, 100, 18);
        contHA.setFont(new Font("Roboto", Font.PLAIN, 15));
        contHA.setBounds(508, 210, 100, 18);

        armas.add(portaAviao);
        armas.add(encoura);
        armas.add(cruzad);
        armas.add(subma);
        armas.add(hidroAviao);
        armas.add(contPA);
        armas.add(contER);
        armas.add(contCZ);
        armas.add(contSM);
        armas.add(contHA);
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
