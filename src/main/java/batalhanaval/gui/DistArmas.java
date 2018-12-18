
package batalhanaval.gui;

import batalhanaval.main.controle;
import batalhanaval.models.Arma;
import batalhanaval.models.Coordenada;
import batalhanaval.models.Cruzador;
import batalhanaval.models.Encouracado;
import batalhanaval.models.HidroAviao;
import batalhanaval.models.PortaAviao;
import batalhanaval.models.Submarino;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author Zetsubou
 */
public class DistArmas extends JFrame{
    int qntCoord = 0;
    int armaSelecionada = 0;
    int ori = 0;
    PortaAviao pa = new PortaAviao();
    Encouracado ec = new Encouracado();
    Cruzador cr = new Cruzador();
    Submarino sb = new Submarino();
    HidroAviao hd = new HidroAviao();
    controle ct1 = new controle();
    
    //painel
    JPanel painel = new JPanel();
    JPanel grid = new JPanel();
    Container cp;
    //botões
    JButton[][] Botoes = new JButton[10][10];
    JButton voltar = new JButton("Voltar");
    //Labels
    public static JLabel select = new JLabel("Selecione uma armas:");
    JLabel showOri = new JLabel("Orientação: ");
    JLabel exp = new JLabel("<html>0 - horizontal<br/>1 - Vertical</html>");
    //combobox
    JComboBox cb1 = new JComboBox();
    Arma[] weapons = {
        pa, ec, cr, sb, hd};
    
    public DistArmas(){
        //JFrame
        setTitle("Distribuição de Armas");
        setSize(740, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Container
        setContentPane(painel);
        cp = getContentPane();
        cp.setLayout(null);
        
        //botões
        grid.setBounds(3, 58, 497, 325);
        grid.setLayout(new GridLayout(10, 10, 2, 2));
        
        for (int linha = 0; linha < 10; linha++){
            for (int coluna = 0; coluna < 10; coluna++){
                Botoes[linha][coluna] = new JButton("");
                Botoes[linha][coluna].addActionListener(new ouvirBotao());
                Botoes[linha][coluna].setFocusable(false);
                grid.add(Botoes[linha][coluna]);
            }
        }
        
        //label
        select.setFont(new Font("Roboto", Font.PLAIN, 15));
        select.setBounds(520, 192, 150, 35);
        
        showOri.setFont(new Font("Roboto", Font.PLAIN, 12));
        showOri.setBounds(520, 252, 100, 26);
        showOri.setText("Orientação: " + ori);
        exp.setFont(new Font("Roboto", Font.PLAIN, 12));
        exp.setBounds(520, 280, 100, 26);
        
        //combox
        cb1.setBounds(520, 220, 150, 35);
        cb1.setFocusable(false);
        cb1.addItemListener(new comboArmas());
        preencherCB();
        
        cp.add(grid);
        cp.add(select);
        cp.add(cb1);
        cp.add(showOri);
        cp.add(exp);
    }
    
    class comboArmas implements ItemListener{
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                    Arma a1 = (Arma)e.getItem();
                    armaSelecionada = a1.getTipo();
                if(armaSelecionada == 0){
                    select.setText("Selecione uma arma");    
                } else{
                    if(armaSelecionada == 1)
                        select.setText("Porta-Avião selecionado");
                    if(armaSelecionada == 2)
                        select.setText("Encouraçado selecionado");
                    if(armaSelecionada == 3)
                        select.setText("Cruzador selecionado");
                    if(armaSelecionada == 4)
                        select.setText("Submarino selecionado");
                    if(armaSelecionada == 5)
                        select.setText("Hidro-Avião selecionado");
                }
            }
        }
    }    
    
    class ouvirBotao implements ActionListener{
        public void actionPerformed(ActionEvent event){
            for (int linha = 0; linha < 10; linha++){
                for (int coluna = 0; coluna < 10; coluna++) {
                    if (event.getSource() == Botoes[linha][coluna]) {
                        Coordenada c1 = new Coordenada();
                        c1.setColuna(coluna);
                        c1.setLinha(linha);
                        c1.setA1((Arma) cb1.getSelectedItem());
                        if(TemVizinhos(c1)) {
                            ct1.salvaCoord(c1);
                        }
                        JOptionPane.showMessageDialog(null,"Salvo");
                    }
                }
            }
        }
    }
    
    private void preencherCB(){
        for(int i = 0; i < weapons.length; i++) {
            cb1.addItem(weapons[i]);
        }
    }
    
    int getLinha(Coordenada c1){
        return c1.getLinha();
    }
    
    int getColuna(Coordenada c1){
        return c1.getColuna();
    }
    
    int[] Norte(Coordenada c1){
        int cdn[]= new int[2];
        if(getLinha(c1) == 0){
            return null;
        }else{
            cdn[0] = getLinha(c1) - 1;
            cdn[1] = getColuna(c1);
        }
        return cdn;
    } 
    
    int[] Sul(Coordenada c1){
        int cdn[]= new int[2];
        if(getLinha(c1) == 9){
            return null;
        }else{
            cdn[0] = getLinha(c1) + 1;
            cdn[1] = getColuna(c1);
        }
        return cdn;
    }
    
    int[] Leste(Coordenada c1){
        int cdn[]= new int[2];
        if(getColuna(c1) == 9){
            return null;
        }else{
            cdn[0] = getLinha(c1);
            cdn[1] = getColuna(c1) + 1;
        }
        return cdn;
    }
    
    int[] Oeste(Coordenada c1){
        int cdn[]= new int[2];
        if(getColuna(c1) == 0){
            return null;
        }else{
            cdn[0] = getLinha(c1);
            cdn[1] = getColuna(c1) - 1;
        }
        return cdn;
    }
    
    public boolean TemVizinhos(Coordenada c1){
        return true;
    }
    
}
