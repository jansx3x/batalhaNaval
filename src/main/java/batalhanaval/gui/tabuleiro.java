
package batalhanaval.gui;

import batalhanaval.main.startJogo;
import batalhanaval.models.Jogadores;
import batalhanaval.models.Partida;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Zetsubou
 */
public class tabuleiro extends JFrame{
    //painel
    JPanel grid = new JPanel();
    JPanel jcp = new JPanel();
    JPanel armas1 = new JPanel();
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
    JLabel contPA = new JLabel("0");
    JLabel contER = new JLabel("0");
    JLabel contCZ = new JLabel("0");
    JLabel contSM = new JLabel("0");
    JLabel contHA = new JLabel("0");
    JLabel portaAviao = new JLabel("Porta Aviões");
    JLabel encoura = new JLabel("Encouraçado");
    JLabel cruzad = new JLabel("Cruzadores");
    JLabel subma = new JLabel("Submarinos");
    JLabel hidroAviao = new JLabel("Hidro-Aviões");
    JLabel contTiros = new JLabel("");
    int contadorNavio = 12;
    int contadorTiros = 3;
    
    //vetor
    int vetor[][] = new int[10][10];
    String nomeJogador;
    
    startJogo jogo = new startJogo();
    
    public tabuleiro(Partida jogador, Jogadores p1){
       
        //JFrame
        setTitle("Batalha Naval");
        setSize(740, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        JLabel novoJogo = new JLabel(jogador.getNome());
        
        
        //painel
        armas1.setBounds(515, 250, 180, 70);
        armas1.setLayout(new GridLayout(5, 2, 5, 0));

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
        
        dist.setBounds(520, 194, 150, 35);
        dist.addActionListener(new ouvirDist());
        dist.setFocusable(false);
        
        att.setBounds(400, 395, 96, 35);
	att.setFocusable(false);
        //att.addActionListener(this);
        
        voltar.setBounds(9, 395, 96, 35);
        voltar.setFocusable(false);
        voltar.addActionListener(new ouvirVoltar());
        
        //label
        novoJogo.setBounds(230, 10, 150, 30);
        novoJogo.setFont(new Font("Roboto", Font.PLAIN, 18));
        
        tirosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
        tirosRestantes.setBounds(540, 60, 150, 18);
        
        naviosRestantes.setFont(new Font("Roboto", Font.PLAIN, 15));
        naviosRestantes.setBounds(550, 110, 118, 18);
        
        contTiros.setFont(new Font("Roboto", Font.BOLD, 18));
        contTiros.setBounds(570, 78, 20, 26);
        contTiros.setText("0" + contadorTiros);
        
        contNavios.setFont(new Font("Roboto", Font.BOLD, 18));
	contNavios.setBounds(570, 131, 20, 26);
        contNavios.setText("" + contadorNavio);

        portaAviao.setFont(new Font("Roboto", Font.PLAIN, 15));
        encoura.setFont(new Font("Roboto", Font.PLAIN, 15));
        cruzad.setFont(new Font("Roboto", Font.PLAIN, 15));
        subma.setFont(new Font("Roboto", Font.PLAIN, 15));
        hidroAviao.setFont(new Font("Roboto", Font.PLAIN, 15));
        contPA.setFont(new Font("Roboto", Font.PLAIN, 15));
        contER.setFont(new Font("Roboto", Font.PLAIN, 15));
        contCZ.setFont(new Font("Roboto", Font.PLAIN, 15));
        contSM.setFont(new Font("Roboto", Font.PLAIN, 15));
        contHA.setFont(new Font("Roboto", Font.PLAIN, 15));

        armas1.add(contPA);
        armas1.add(portaAviao);
        armas1.add(contER);
        armas1.add(encoura);
        armas1.add(contCZ);
        armas1.add(cruzad);
        armas1.add(contSM);
        armas1.add(subma);
        armas1.add(contHA);
        armas1.add(hidroAviao);
        cp.add(armas1);
        cp.add(grid);
        cp.add(dist);
        cp.add(att);
        cp.add(voltar);
        cp.add(naviosRestantes);
        cp.add(tirosRestantes);
        cp.add(contNavios);
        cp.add(contTiros);
        cp.add(novoJogo);
        
        //método para escolher os locais
        //startJogo.distribuir;
        //jogo.iniciaJogo(vetor);
        
    }
    
    class ouvirDist implements ActionListener{
        public void actionPerformed(ActionEvent event){
            DistArmas a = new DistArmas();
            a.setVisible(true);
        }
    }
    
    class ouvirVoltar implements ActionListener{
        public void actionPerformed(ActionEvent event){
            setVisible(false);
            System.exit(0);
        }
    }
}
