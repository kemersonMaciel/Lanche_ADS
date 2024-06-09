import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela_CadastroProduto extends JFrame {
    private JTextField txtProduto;
    private JTextField txtValor;
    private JCheckBox chkAtivo;
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    public Tela_CadastroProduto() {
        // ConfiguraÃ§Ã£o da janela de cadastro de produto
        setTitle("Cadastro de Produto");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com layout de grid
        JPanel panel = new JPanel();
        panel.setLayout(null); // Usar layout absoluto

        // Campo de texto para o nome do produto
        JLabel lblProduto = new JLabel("Produto:");
        lblProduto.setBounds(30, 29, 150, 30);
        panel.add(lblProduto);

        txtProduto = new JTextField();
        txtProduto.setBounds(120, 30, 150, 30);
        panel.add(txtProduto);

        // Campo de texto para o valor do produto
        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(30, 89, 100, 30);
        panel.add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(120, 90, 150, 30);
        panel.add(txtValor);

        // Checkbox para definir se o produto está ativo
        JLabel lblAtivo = new JLabel("Ativo:");
        lblAtivo.setBounds(30, 135, 100, 30);
        panel.add(lblAtivo);

        chkAtivo = new JCheckBox();
        chkAtivo.setBounds(120, 135, 200, 30);
        panel.add(chkAtivo);

        // BotÃ£o para salvar o produto
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 200, 100, 30);
        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // LÃ³gica para salvar produto
                String nome = txtProduto.getText();
                double valor = Double.parseDouble(txtValor.getText());
                boolean ativo = chkAtivo.isSelected();
                Produto produto = new Produto(nome, valor, ativo);
                listaProdutos.add(produto);
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                dispose();
            }
        });
        
        lblProduto.setFont(new Font("Sans", Font.BOLD, 15));
        lblValor.setFont(new Font("Sans", Font.BOLD, 15));
        lblAtivo.setFont(new Font("Sans", Font.BOLD,15));
        chkAtivo.setFont(new Font("Sans", Font.BOLD, 15));
        btnSalvar.setFont(new Font("Dialog", Font.CENTER_BASELINE, 14));
        txtProduto.setFont(new Font("Monospaced", Font.PLAIN, 15));
        txtValor.setFont(new Font("Monospaced", Font.PLAIN, 15));


        // Adicionando o botÃ£o de salvar ao painel
        panel.add(btnSalvar);

        // Adicionando o painel Ã  janela
        add(panel);
        setVisible(true);
    }

    public static ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }
}