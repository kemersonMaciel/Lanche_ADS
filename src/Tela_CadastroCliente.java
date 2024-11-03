import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela_CadastroCliente extends JFrame {
    private JTextField txtNome;
    private JTextField txtCPF;
    private JTextField txtTelefone;
    private JTextField txtEndereco;
    private static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public Tela_CadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null); 

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 100, 25);
        panel.add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(130, 20, 200, 25);
        panel.add(txtNome);

        JLabel lblCPF = new JLabel("CPF:");
        lblCPF.setBounds(20, 60, 100, 25);
        panel.add(lblCPF);

        txtCPF = new JTextField();
        txtCPF.setBounds(130, 60, 200, 25);
        panel.add(txtCPF);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 100, 100, 25);
        panel.add(lblTelefone);

        txtTelefone = new JTextField();
        txtTelefone.setBounds(130, 100, 200, 25);
        panel.add(txtTelefone);
        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(20, 140, 100, 25);
        panel.add(lblEndereco);

        txtEndereco = new JTextField();
        txtEndereco.setBounds(130, 140, 200, 25);
        panel.add(txtEndereco);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(130, 180, 100, 30);
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nome = txtNome.getText();
                String cpf = txtCPF.getText();
                String telefone = txtTelefone.getText();
                String endereco = txtEndereco.getText();
                Cliente cliente = new Cliente(nome, cpf, telefone, endereco);
                listaClientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                dispose();
            }
        });

        panel.add(btnSalvar);

        add(panel);
        setVisible(true);

        lblNome.setFont(new Font("Sans",Font.BOLD, 15));
        lblCPF.setFont(new Font("Sans",Font.BOLD, 15));
        lblTelefone.setFont(new Font("Sans",Font.BOLD, 15));
        lblEndereco.setFont(new Font("Sans",Font.BOLD, 15));
        btnSalvar.setFont(new Font("Dialog",Font.CENTER_BASELINE, 14));
        txtNome.setFont(new Font("Monospaced",Font.PLAIN, 15));
        txtCPF.setFont(new Font("Monospaced",Font.PLAIN, 15));
        txtEndereco.setFont(new Font("Monospaced",Font.PLAIN, 15));
        txtTelefone.setFont(new Font("Monospaced",Font.PLAIN, 15));
    }

    public static ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}
