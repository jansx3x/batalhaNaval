
package batalhanaval.gui;

import batalhanaval.main.GenericComboModel;
import batalhanaval.main.controle;
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
    
    controle c1 = new controle();
    
    //painel
    private JPanel contentPane = new JPanel();
    
    //lista de jogadores salvos
    private JTextField nome1 = new JTextField(30);
    
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
        nome1.setBounds(133,141,223,29);
        nome1.setFocusable(true);
        contentPane.add(nome1);
        
        addComboB1();
        
        //label
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(182,31,160,29);
        contentPane.add(titulo);
        
        labelUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        labelUsuario.setBounds(135,116,155,14);
        contentPane.add(labelUsuario);
        
        //botões
        start.setBounds(200, 246, 111, 36);
        start.setFont(new Font("Verdana", Font.PLAIN, 12));
        start.setFocusable(false);
        start.addActionListener(new ouvirStart());
        contentPane.add(start);
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
            
            
            
            /*Partida p1 = (Partida)jComboBox2.getSelectedItem();
            if(p1.getCountJogadores() >= 2){
                JOptionPane.showMessageDialog(contentPane,"Já tem 2 jogadores na partida!");
            }else{
                Jogadores j1 = (Jogadores)jComboBox1.getSelectedItem();
                j1.setJogoIdjogo(p1);
                c1.attJogador(j1);
                p1.adiciona(j1);
                p1.setCountJogadores(1);
                c1.attJogo(p1);
            
            SwingUtilities.invokeLater(new Runnable(){
                public void run(){  
                    tabuleiro t2 = new tabuleiro((Partida)jComboBox2.getSelectedItem());
                    t2.setVisible(true);
                }
            });}*/
        }
    }
     
    public void addComboB1(){
        /*
        jComboBox1.setModel(new GenericComboModel<Jogadores>(c1.retornaListaJogadores()));
    
        jComboBox2.setModel(new GenericComboModel<Partida>(c1.retornaListaJogos()));*/
    }
     
    
}
