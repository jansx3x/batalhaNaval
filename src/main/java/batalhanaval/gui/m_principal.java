
package batalhanaval.gui;

import javax.swing.*;
import batalhanaval.models.Jogadores;
import batalhanaval.models.Partida;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Zetsubou
 */
public class m_principal extends JFrame {
    
    //painel
    private JPanel contentPane = new JPanel();
    
    //lista de jogadores salvos
    private JComboBox<Jogadores> jComboBox1 = new JComboBox();
    private JComboBox<Partida> jComboBox2 = new JComboBox();
    
    //labels
    private JLabel titulo = new JLabel("Batalha Naval");
    private JLabel labelUsuario = new JLabel("Escolha o usuário:");
    private JLabel labelJogo = new JLabel("Escolha um jogo:");
    
    //botões
    private JButton start = new JButton("Começar");
    private JButton nJogador = new JButton("Novo Jogador");
    private JButton nJogo = new JButton("Novo Jogo");
    
    public m_principal(){
        
        //JFrame
        setTitle("Batalha Naval");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,507,409);
        
        //painel
        contentPane.setBorder(null);
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        //combobox
        jComboBox1.setBounds(133,141,223,29);
        jComboBox1.setFocusable(false);
        contentPane.add(jComboBox1);
        
        jComboBox2.setBounds(133,201,223,29);
        jComboBox2.setFocusable(false);
        contentPane.add(jComboBox2);
        
        //label
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(182,31,160,29);
        contentPane.add(titulo);
        
        labelUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        labelUsuario.setBounds(135,116,155,14);
        contentPane.add(labelUsuario);
        
        labelJogo.setFont(new Font("Arial", Font.PLAIN, 14));
        labelJogo.setBounds(135, 176, 155, 15);
        contentPane.add(labelJogo);
        
        //botões
        start.setBounds(200, 246, 111, 36);
        start.setFont(new Font("Verdana", Font.PLAIN, 12));
        start.setFocusable(false);
        start.addActionListener(new ouvirStart());
        contentPane.add(start);
        
        nJogador.setFont(new Font("Verdana", Font.PLAIN, 12));
        nJogador.setBounds(100, 298, 121, 36);
        nJogador.setFocusable(false);
        nJogador.addActionListener(new ouvirJogador());
        contentPane.add(nJogador);
        
        nJogo.setBounds(272, 298, 111, 36);
        nJogo.setFocusable(false);
        nJogo.setFont(new Font("Verdana", Font.PLAIN, 12));
        nJogo.addActionListener(new ouvirJogo());
        contentPane.add(nJogo);
    }
    
    class ouvirJogador implements ActionListener{ 
        public void actionPerformed(ActionEvent event){
            SwingUtilities.invokeLater(new Runnable() {
		public void run() {
                    novo_jogador n1 = new novo_jogador();
                    n1.setVisible(true);					
		}
            });
        }
    }
    
    class ouvirJogo implements ActionListener{
        public void actionPerformed(ActionEvent event){
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    novo_jogo n2 = new novo_jogo();
                    n2.setVisible(true);
                }
            });
        }
    }
    
     class ouvirStart implements ActionListener{
        public void actionPerformed(ActionEvent event){
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){
                    tabuleiro t2 = new tabuleiro((String)jComboBox1.getSelectedItem());
                    t2.setVisible(true);
                }
            });
        }
    }
    
}
