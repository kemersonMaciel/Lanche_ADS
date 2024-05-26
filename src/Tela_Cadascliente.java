import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela_Cadascliente extends JFrame implements ActionListener {

    ArrayList<String> clientes = new ArrayList<>();


    JPanel painel = new JPanel();

    JLabel lbtitle = new JLabel("Cadastre um novo cliente:");

    JLabel lbnome = new JLabel("Nome:");
    JLabel lbcpf = new JLabel("CPF:");
    JLabel lbfone = new JLabel("Celular:");
    JLabel lbendereco = new JLabel("Endereço:");

    JTextField txtnome = new JTextField();
    JTextField txtcpf = new JTextField();
    JTextField txtfone = new JTextField();
    JTextField txtendereco = new JTextField();

    JButton btcadastrar = new JButton("Cadastrar");

    Tela_Cadascliente(){
        setTitle("Cadastrar Cliente");
        setSize(310,400);
        setLocation(600, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        painel.setLayout(null);

        lbtitle.setBounds(70, 20, 200, 30);
        lbnome.setBounds(30, 60, 80, 30);
        txtnome.setBounds(100, 60, 150, 30);
        lbcpf.setBounds(30, 120, 80, 30);
        txtcpf.setBounds(100,120,150, 30);
        lbfone.setBounds(30, 180, 80,30);
        txtfone.setBounds(100, 180, 150, 30);
        lbendereco.setBounds(30, 240, 80, 30);
        txtendereco.setBounds(100, 240, 150, 30);

        btcadastrar.setBounds(100, 300, 100, 30);
        btcadastrar.addActionListener(this);

        painel.add(lbtitle);
        painel.add(lbnome);
        painel.add(txtnome);
        painel.add(lbcpf);
        painel.add(txtcpf);
        painel.add(lbfone);
        painel.add(txtfone);
        painel.add(lbendereco);
        painel.add(txtendereco);
        painel.add(btcadastrar);

        getContentPane().add(painel);

    }

    public static void main(String[] args) {
        Tela_Cadascliente cliente = new Tela_Cadascliente();
        cliente.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btcadastrar){
            String nome = txtnome.getText();
            String cpf = txtcpf.getText();
            String fone = txtfone.getText();
            String endereco = txtendereco.getText();

            clientes.add("Nome: " + nome + ", CPF: " + cpf + ", Celular: " + fone + ", Endereço: " + endereco);

            JOptionPane.showMessageDialog(this, "Cliente Cadastrado com Sucesso");

            txtnome.setText("");
            txtcpf.setText("");
            txtfone.setText("");
            txtendereco.setText("");
        }
    }
}