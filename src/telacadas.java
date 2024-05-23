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

public class telacadas extends JFrame implements ActionListener {

    Produto pro;
    ArrayList<Produto> list = new ArrayList<>();

    JPanel painel = new JPanel();

    JLabel lbdesc = new JLabel("Produto:");
    JLabel lbvalor = new JLabel("Valor:");
    JLabel lbquantidade = new JLabel("Quantidade:");
    JCheckBox c1 = new JCheckBox("Disponível");

    JTextField txtdesc = new JTextField();
    JTextField txtvalor = new JTextField();
    JTextField txtquantidade = new JTextField();

    JButton btsalvar = new JButton("Cadastar");
    JButton btlistar = new JButton("Listar");

    telacadas(){
        setTitle("Cadastrar Produto");
        setSize(300,350);
        setLocation(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painel.setLayout(null);

        lbdesc.setBounds(25,40,80,30);
        txtdesc.setBounds(100,40,150,30);
        lbvalor.setBounds(25, 90, 80, 30);
        txtvalor.setBounds(100, 90, 150, 30);
        lbquantidade.setBounds(20, 140, 80, 30);
        txtquantidade.setBounds(100, 140, 150, 30);
        c1.setBounds(100,170,150,30);

        btsalvar.setBounds(30, 210, 100, 30);
        btsalvar.addActionListener(this);
        btlistar.setBounds(150, 210, 100, 30);
        btlistar.addActionListener(this);

        painel.add(lbdesc);
        painel.add(txtdesc);
        painel.add(lbvalor);
        painel.add(txtvalor);
        painel.add(lbquantidade);
        painel.add(txtquantidade);
        painel.add(c1);
        painel.add(btsalvar);
        painel.add(btlistar);

        getContentPane().add(painel);
    }

    public static void main(String[] args) {
        telacadas telacadas = new telacadas();
        telacadas.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== btsalvar) {
            String d = txtdesc.getText() ;
            Double v = Double.parseDouble(txtvalor.getText());
            Integer q = Integer.parseInt(txtquantidade.getText());
            pro = new Produto(d, v, q);
            list.add(pro);
            JOptionPane.showMessageDialog(null, "Produto Adicionado e disponível para pedidos");
            txtdesc.setText("");
            txtvalor.setText("");
            txtquantidade.setText("");
        }

        if (e.getSource() == btlistar) {
            JOptionPane.showMessageDialog(null, " Produto: " + pro.getDescricao() + "\n valor: R$ " + pro.getValor() + "\n Quantidade disponível: " + pro.getQuantidade());
        }
    }
}