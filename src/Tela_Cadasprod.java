import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela_Cadasprod extends JFrame implements ActionListener {

    Produto pro;
    ArrayList<Produto> list = new ArrayList<>();

    JPanel painel = new JPanel();

    JLabel lbtitle = new JLabel("Cadastre os seus produtos!");
    JLabel lbdesc = new JLabel("Produto:");
    JLabel lbvalor = new JLabel("Valor:");
    JCheckBox cbox1 = new JCheckBox("Ativo");

    JTextField txtdesc = new JTextField();
    JTextField txtvalor = new JTextField();

    JButton btcadastrar = new JButton("Cadastar");

    Tela_Cadasprod(){
        setTitle("Cadastrar Produto");
        setSize(310,320);
        setLocation(600, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        painel.setLayout(null);

        lbtitle.setBounds(50,15,300,30);
        lbdesc.setBounds(15,60,80,30);
        txtdesc.setBounds(100,60,150,30);
        lbvalor.setBounds(15, 120, 80, 30);
        txtvalor.setBounds(100, 120, 150, 30);
        cbox1.setBounds(100,150,150,30);
        
        btcadastrar.setBackground(Color.BLACK);
        btcadastrar.setForeground(Color.WHITE);
        btcadastrar.setBounds(100, 210, 100, 30);
        btcadastrar.addActionListener(this);

        painel.add(lbtitle);
        painel.add(lbdesc);
        painel.add(txtdesc);
        painel.add(lbvalor);
        painel.add(txtvalor);
        painel.add(cbox1);
        painel.add(btcadastrar);
        
        lbtitle.setFont(new Font("Serif", Font.BOLD, 16));
        lbdesc.setFont(new Font("Sans", Font.BOLD,15));
        lbvalor.setFont(new Font("Sans", Font.BOLD, 15));
        cbox1.setFont(new Font("Sans", Font.BOLD, 15));
        btcadastrar.setFont(new Font("Dialog", Font.CENTER_BASELINE,14));
        txtdesc.setFont(new Font("Monospaced",Font.PLAIN,15));
        txtvalor.setFont(new Font("Monospaced",Font.PLAIN,15));

        getContentPane().add(painel);
    }
    public static void main(String[] args) {
        Tela_Cadasprod telacadas = new Tela_Cadasprod();
        telacadas.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btcadastrar) {
            String d = txtdesc.getText();
            try{
                Double v = Double.parseDouble(txtvalor.getText());
                boolean disponivel = cbox1.isSelected();
                pro = new Produto(d, v, disponivel);
                list.add(pro);
                JOptionPane.showMessageDialog(null, "Produto Adicionado e disponível para pedidos");
                txtdesc.setText("");
                txtvalor.setText("");
                cbox1.setSelected(false);
            } catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Por favor, insira um valor válido para o preço", "Erro",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}