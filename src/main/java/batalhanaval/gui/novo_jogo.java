
package batalhanaval.gui;

import batalhanaval.models.Partida;
import batalhanaval.dao.JogoDAO;
import batalhanaval.infra.EMFactory;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.persistence.EntityManager;
import javax.swing.*;
/**
 *
 * @author Zetsubou
 */
public class novo_jogo extends JFrame {
    //painel
    private final JPanel contentPane = new JPanel();
    //botões
    private final JButton voltar = new JButton("Voltar");
    private final JButton salvar = new JButton("Salvar");
    //label
    private final JLabel titulo = new JLabel("Novo Jogo");
    private final JLabel nome = new JLabel("Nome:");
    //jtextfield
    private final JTextField nom1 = new JTextField(20);
    
    public novo_jogo(){
        //frame
        setTitle("Novo Jogo");
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        setLocationRelativeTo(null);
        
        contentPane.setLayout(null);
        setContentPane(contentPane);
        
        //botões
        voltar.setBounds(10, 126, 85, 31);
        voltar.setFocusable(false);
        voltar.addActionListener(new ouvirVoltar());
        contentPane.add(voltar);
        
        salvar.setBounds(183, 126, 95, 31);
        salvar.addActionListener(new ouvirSalvar());
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
            novo_jogador n1 = new novo_jogador();
            n1.dispose();
        }
    }
    
    class ouvirSalvar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){ 
            Partida p1 = new Partida();
            p1.setNome(nom1.getText());
            p1.setStatus((short)1);
            
            JogoDAO.getInstance().salvaNovo(p1);
            
            clearFields();
            JOptionPane.showMessageDialog(contentPane,"Salvo com sucesso !");
        }
    }
    
    private void clearFields(){
       nom1.setText("");
    }
}
