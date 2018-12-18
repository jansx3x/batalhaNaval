
package batalhanaval.gui;

import batalhanaval.main.controle;
import batalhanaval.models.Jogadores;
import javax.swing.*;
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
    private JLabel labelUsuario = new JLabel("Nome do Jogo:");
    
    //botões
    private JButton start = new JButton("Começar");
    
    Partida new1 = new Partida();
    Jogadores p1 = new Jogadores();
    
    public m_principal(){
        
        //JFrame
        setTitle("Batalha Naval");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,407,309);
        
        //painel
        contentPane.setBorder(null);
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        //combobox
        nome1.setBounds(25,125,223,29);
        nome1.setFocusable(true);
        contentPane.add(nome1);
        
        //label
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setBounds(132,31,160,29);
        contentPane.add(titulo);
        
        labelUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        labelUsuario.setBounds(25,106,155,14);
        contentPane.add(labelUsuario);
        
        //botões
        start.setBounds(145, 206, 111, 36);
        start.setFont(new Font("Verdana", Font.PLAIN, 12));
        start.setFocusable(false);
        start.addActionListener(new ouvirStart());
        contentPane.add(start);    
    }
    
    class ouvirStart implements ActionListener{
        public void actionPerformed(ActionEvent event){
            
            new1.setNome(nome1.getText());
            c1.attJogo(new1);
            p1 = c1.findJogador(1);
            p1.setJogoIdjogo(new1);
            c1.attJogador(p1);

            SwingUtilities.invokeLater(new Runnable(){
                public void run(){  
                    tabuleiro t2 = new tabuleiro(new1, p1);
                    t2.setVisible(true);
                }
            });}
        }
}

