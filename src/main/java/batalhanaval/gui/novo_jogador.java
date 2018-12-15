
package batalhanaval.gui;

import batalhanaval.dao.JogadorDAO;
import batalhanaval.infra.EMFactory;
import batalhanaval.models.Jogador;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.swing.*;
/**
 *
 * @author Zetsubou
 */
public class novo_jogador extends JFrame {
    //painel
    private final JPanel contentPane = new JPanel();
    //botões
    private final JButton voltar = new JButton("Voltar");
    private final JButton salvar = new JButton("Salvar");
    //label
    private final JLabel titulo = new JLabel("Novo Jogador");
    private final JLabel nome = new JLabel("Nome:");
    //jtextfield
    private final JTextField nom1 = new JTextField(20);
    
    public novo_jogador(){
        //frame
        setTitle("Novo Jogador");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        setLocationRelativeTo(null);
        //setIconImage(new javax.swing.ImageIcon(getClass().getResource("/batalhanaval.gui/user-filled-person-shape.png")).getImage());
        
        //painel
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        //botões
        voltar.setBounds(10, 10, 45, 31);
        //voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/batalhanaval.gui/web-page-home.png")));
        voltar.setFocusable(false);
        voltar.addActionListener(new ouvirVoltar());
        contentPane.add(voltar);
        
        salvar.setBounds(183, 126, 95, 31);
        voltar.addActionListener(new ouvirSalvar());
        contentPane.add(salvar);
        
        //label
        titulo.setFont(new Font("Verdana", Font.BOLD, 16));
        titulo.setBounds(95, 11, 170, 29);
        contentPane.add(titulo);
        
        nome.setFont(new Font("Verdana", Font.PLAIN, 12));
        nome.setBounds(20, 72, 50, 15);
        contentPane.add(nome);
        
        //TextField
        nom1.setBounds(68, 68, 180, 25);
        contentPane.add(nom1);
        
    }
    
    class ouvirVoltar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            //fechar frame
        }
    }
    
    class ouvirSalvar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            EntityManager ma1 = EMFactory.getEntityManager();
            JogadorDAO jo1 = new JogadorDAO(ma1);
            
            Jogador j1 = new Jogador();
            j1.setNome(nom1.getText());
            j1.setStatus((short)0);
            
            jo1.salvaNovo(j1);
            EMFactory.close();
        }
    }
}
