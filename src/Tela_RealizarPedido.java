import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tela_RealizarPedido extends JFrame {
    private JTextField txtNomeCliente;
    private JComboBox<String> comboProdutos;
    private JSpinner spinnerQuantidade;
    private JTextArea textAreaPedido;
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private Pedido pedidoAtual;

    public Tela_RealizarPedido() {
        // ConfiguraÃ§Ã£o da janela de realizar pedido
        setTitle("Realizar Pedido");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurando o painel principal com layout de grid
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Campo de texto para o nome do cliente
        JLabel lblNomeCliente = new JLabel("Nome do Cliente:");
        lblNomeCliente.setBounds(20, 20, 120, 30);
        panel.add(lblNomeCliente);

        txtNomeCliente = new JTextField();
        txtNomeCliente.setBounds(150, 20, 150, 30);
        panel.add(txtNomeCliente);

        // Botão para cadastrar novo cliente
        JButton btnCadastrarCliente = new JButton("Cadastrar Cliente");
        btnCadastrarCliente.setBounds(320, 20, 145, 30);
        btnCadastrarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tela_CadastroCliente();
            }
        });
        panel.add(btnCadastrarCliente);

        // ComboBox para selecionar os produtos cadastrados
        JLabel lblProduto = new JLabel("Produto:");
        lblProduto.setBounds(20, 60, 120, 30);
        panel.add(lblProduto);

        comboProdutos = new JComboBox<>();
        for (Produto produto : Tela_CadastroProduto.getListaProdutos()) {
            comboProdutos.addItem(produto.toString());
        }
        comboProdutos.setBounds(150, 60, 150, 30);
        panel.add(comboProdutos);

        // Spinner para selecionar a quantidade de produtos
        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(20, 100, 120, 30);
        panel.add(lblQuantidade);

        spinnerQuantidade = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        spinnerQuantidade.setBounds(150, 100, 150, 30);
        panel.add(spinnerQuantidade);

        // Área de texto para exibir os dados do pedido
        JLabel lblDadosPedido = new JLabel("Dados do Pedido:");
        lblDadosPedido.setBounds(20, 140, 120, 30);
        panel.add(lblDadosPedido);

        textAreaPedido = new JTextArea();
        textAreaPedido.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaPedido);
        scrollPane.setBounds(150, 140, 290, 90);
        panel.add(scrollPane);

        // Inicializando pedido atual sem cliente associado
        pedidoAtual = new Pedido(null, null);

        // BotÃ£o para adicionar produto ao pedido
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.setBounds(150,250,100,30);
        btnAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String produtoStr = (String) comboProdutos.getSelectedItem();
                Produto produto = null;
                for (Produto p : Tela_CadastroProduto.getListaProdutos()) {
                    if (p.toString().equals(produtoStr)) {
                        produto = p;
                        break;
                    }
                }
                int quantidade = (int) spinnerQuantidade.getValue();
                ItemPedido item = new ItemPedido(produto, quantidade);
                pedidoAtual.adicionarItem(item);
                textAreaPedido.append(item.getQuantidade() + "x " + item.getProduto().getNome() + " - R$ " + item.getProduto().getValor() + "\n");
            }
        });
        panel.add(btnAdicionar);

        // BotÃ£o para continuar para a tela de pagamento
        JButton btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(270, 250, 100, 30);
        btnContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeCliente = txtNomeCliente.getText();
                if (nomeCliente.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Informe o nome do cliente!");
                    return;
                }
                // Simulando a recuperaÃ§Ã£o do cliente (idealmente deve ser buscado ou cadastrado)
                Cliente cliente = new Cliente(nomeCliente, "", "", "");
                pedidoAtual.setCliente(cliente);
                new Tela_Pagamento(pedidoAtual);
                dispose();
            }
        });
        panel.add(btnContinuar);

        // Adicionando o painel Ã  janela
        add(panel);
        setVisible(true);

        lblNomeCliente.setFont(new Font("Sans",Font.BOLD,14));
        lblProduto.setFont(new Font("Sans",Font.BOLD,14));
        lblQuantidade.setFont(new Font("Sans",Font.BOLD,14));
        lblDadosPedido.setFont(new Font("Sans",Font.BOLD,13));
        comboProdutos.setFont(new Font("Monospaced",Font.BOLD,12));
        spinnerQuantidade.setFont(new Font("Monospaced",Font.BOLD,18));
        btnCadastrarCliente.setFont(new Font("Dialog", Font.CENTER_BASELINE,13));
        btnAdicionar.setFont(new Font("Dialog", Font.CENTER_BASELINE,13));
        btnContinuar.setFont(new Font("Dialog", Font.CENTER_BASELINE,13));
    }

    public static ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }
}
