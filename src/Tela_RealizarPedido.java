import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Tela_RealizarPedido extends JFrame implements ActionListener{
    private JTextField txtNomeCliente;
    private JComboBox<String> comboProdutos;
    private JSpinner spinnerQuantidade;
    private JTextArea textAreaPedido;
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private Pedido pedidoAtual;
    private JButton btCadastrarCliente;
    private JButton btContinuar;


    public Tela_RealizarPedido(){
        
        setTitle("Realizar Pedido");
        setSize(400,490);
        setLocation(600, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    JPanel painel = new JPanel();

    JLabel lbtitulo = new JLabel("Faça seu pedido");

    // Cliente + Botão cadastrar novo cliente
    JLabel lbcliente = new JLabel("Cliente:");
    txtNomeCliente = new JTextField();
    JButton btCadastrarCliente = new JButton("Cadastrar Cliente");
    btCadastrarCliente.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent e){
            new Tela_CadastroCliente();
        }
    });
    
    //comboBox pra seleção de produtos cadastrados
    JLabel lbselecpedido = new JLabel("Selecione seu pedido:");
    JComboBox<String> cbopcao = new JComboBox<>();
    for (Produto produto : Tela_CadastroProduto.getListaProdutos()){
        cbopcao.addItem(produto.toString());
    }

    //Spinner para selecionar a quantidade de produtos
    JLabel lbquantidade = new JLabel("Quantidade");
    JSpinner spquantidade = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

    //Área para exibir dados do pedido
    JLabel lbdados = new JLabel("Dados do Pedido:");
    JTextArea textAreaPedido = new JTextArea(); //
    textAreaPedido.setEditable(false); // não pode ser editado
    JScrollPane scrollPane = new JScrollPane(textAreaPedido); //barra de rolagem

    //inciar pedido sem cliente
    pedidoAtual = new Pedido (null, null);
    
    
    JButton btAdicionar = new JButton("Adicionar");
    btAdicionar.addActionListener(new ActionListener() {
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
        textAreaPedido.append(item.getQuantidade() + "x" + item.getProduto().getNome() + " - R$" + item.getProduto().getValor() + "\n");
        }
    });
    JButton btContinuar = new JButton("Continuar");
    btContinuar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            String nomeCliente = txtNomeCliente.getText();
            if (nomeCliente.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Informe o nome do cliente!");
                return;
            }

            Cliente cliente = new Cliente(nomeCliente," "," "," ");
            pedidoAtual.setCliente(cliente);
            new Tela_Pagamento(pedidoAtual);
        }
    });

        lbtitulo.setBounds(130, 15, 150, 30);
        lbcliente.setBounds(30,50,80,30);
        lbselecpedido.setBounds(30,140,200,30);
        cbopcao.setBounds(30,170,150,30);
        lbquantidade.setBounds(30,210,100,30);
        lbdados.setBounds(30,300,150,30);

        btCadastrarCliente.setBackground(Color.BLACK);
        btCadastrarCliente.setForeground(Color.WHITE);
        btCadastrarCliente.setBounds(215,80,150,30);

        btContinuar.setBackground(Color.BLACK);
        btContinuar.setForeground(Color.WHITE);
        btContinuar.setBounds(140, 400, 120, 30);
        
        btAdicionar.setBackground(Color.BLACK);
        btAdicionar.setForeground(Color.WHITE);
        btAdicionar.setBounds(215, 170, 150, 30);

        spquantidade.setBounds(30,240,100,30);

        painel.add(lbtitulo);
        painel.add(lbcliente);
        painel.add(lbselecpedido);
        painel.add(lbquantidade);
        painel.add(cbopcao);
        painel.add(lbdados);
        painel.add(btContinuar);
        painel.add(btAdicionar);
        painel.add(btCadastrarCliente);
        painel.add(spquantidade);

        lbtitulo.setFont(new Font("Serif", Font.BOLD, 18));
        lbcliente.setFont(new Font("Sans",Font.BOLD,15));
        lbselecpedido.setFont(new Font("Sans",Font.BOLD,15));
        lbquantidade.setFont(new Font("Sans",Font.BOLD,15));
        lbdados.setFont(new Font("Sans",Font.BOLD,15));
        cbopcao.setFont(new Font("Monospaced",Font.BOLD,12));
        spquantidade.setFont(new Font("Monospaced",Font.BOLD,18));
        btCadastrarCliente.setFont(new Font("Dialog", Font.CENTER_BASELINE,13));
        btAdicionar.setFont(new Font("Dialog", Font.CENTER_BASELINE,13));
        btContinuar.setFont(new Font("Dialog", Font.CENTER_BASELINE,13));

        add(painel);
        setVisible(true);
    }
    public static void main(String[] args) {
        // Suponho que você já tenha uma instância de Pedido
        Pedido pedido = new Pedido();
        Tela_Pagamento formapag = new Tela_Pagamento(pedido);
        formapag.setVisible(true);
    }

    public static ArrayList<Pedido> getListaPedidos(){
        return listaPedidos;
    }    


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btCadastrarCliente){
            Tela_CadastroCliente cliente = new Tela_CadastroCliente();
            cliente.setVisible(true);
        } else if (e.getSource() == btContinuar){
            Tela_Pagamento formapag = new Tela_Pagamento();
            formapag.setVisible(true);
        }
    }
}
