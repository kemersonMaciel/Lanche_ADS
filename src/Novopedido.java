import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class Novopedido extends JFrame implements ActionListener {

    Produto pro;
    ArrayList<Produto> list = new ArrayList<>();

    JPanel painel = new JPanel();

    JLabel lbtitulo = new JLabel("Faça seu pedido");
    JLabel lbcliente = new JLabel("Cliente:");
    JTextField txtCliente = new JTextField();

    JLabel lbselecpedido = new JLabel("Selecione seu pedido:");
    JComboBox<String> cbopcao = new JComboBox<>();

    JLabel lbquantidade = new JLabel("Quantidade");
    JSpinner spquantidade = new JSpinner();


    JLabel lbselped = new JLabel("Pedido:");
    JLabel lbpedido = new JLabel("............");

    JButton btcontinue = new JButton("Continuar");
    JButton btadd = new JButton("Adicionar");


    Novopedido(){
        setTitle("Novo Pedido");
        setSize(340,450);
        setLocation(600, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        painel.setLayout(null);

        lbtitulo.setBounds(90, 15, 150, 30);
        lbcliente.setBounds(30,50,80,30);
        txtCliente.setBounds(30, 80, 150, 30);
        lbselecpedido.setBounds(30,120,150,30);
        cbopcao.setBounds(30,150,150,30);
        lbquantidade.setBounds(30,210,80,30);
        lbselped.setBounds(30,300,100,30);
        lbpedido.setBounds(90, 300, 150, 30);
        btcontinue.setBounds(215, 350, 90, 30);
        btcontinue.addActionListener(this);
        btadd.setBounds(215, 150, 90, 30);
        btadd.addActionListener(this);
        spquantidade.setBounds(30,240,100,30);

        painel.add(lbtitulo);
        painel.add(lbcliente);
        painel.add(txtCliente);
        painel.add(lbselecpedido);
        painel.add(lbquantidade);
        painel.add(cbopcao);
        painel.add(lbselped);
        painel.add(lbpedido);
        painel.add(btcontinue);
        painel.add(btadd);
        painel.add(spquantidade);

        getContentPane().add(painel);

        cbopcao.addItem("X-salada");
        cbopcao.addItem("Kikao");
        cbopcao.addItem("Pizza P");
        cbopcao.addItem("Refrigerante em Lata");
    }

    public static void main(String[] args) {
        Novopedido novopedido = new Novopedido();
        novopedido.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        lbpedido.setText(cbopcao.getSelectedItem().toString());
    }
}
