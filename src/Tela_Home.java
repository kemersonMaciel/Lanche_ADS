import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Tela_Home extends JFrame implements ActionListener {
    
    JMenuItem cadastrarProduto;
    JMenuItem novoPedidoItem;
    JMenuItem historicoMenuItem;

    public Tela_Home() {
        setTitle("Kome - Kome Lanche"); // Título da página
        setSize(500, 500);
        setLocation(500, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel(new GridBagLayout()); // centralizar a imagem

        JMenuBar menuBar = new JMenuBar(); // Barra de menu.

        // Barra de menu de Cadastro.
        JMenu cadastrarMenu = new JMenu("Cadastro"); 
        cadastrarProduto = new JMenuItem("Cadastrar Produto");
        cadastrarProduto.addActionListener(this);
        cadastrarMenu.add(cadastrarProduto); // incluir cadastrar produto na barra de menu.

        // Barra menu de Pedido.
        JMenu pedidoMenu = new JMenu("Pedido");
        novoPedidoItem = new JMenuItem("Novo Pedido");
        novoPedidoItem.addActionListener(this);
        historicoMenuItem = new JMenuItem("Histórico de Pedido");
        historicoMenuItem.addActionListener(this);
        pedidoMenu.add(novoPedidoItem);
        pedidoMenu.add(historicoMenuItem);

        // Barra do menu Buscar
        JMenu buscarMenu = new JMenu("Buscar");

        // adicionando os menus na Barra.
        menuBar.add(cadastrarMenu);
        menuBar.add(pedidoMenu);
        menuBar.add(buscarMenu);

        // definindo barra de menu na janela principal
        setJMenuBar(menuBar);

        // inserindo imagem
        String imagePath = "src/source/Lanche.png";
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imgLabel = new JLabel(icon);

        // centralizar a imagem 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(imgLabel, gbc);

        add(painel);

        // Configura as fontes dos menus e itens de menu
        cadastrarMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cadastrarProduto.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pedidoMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
        novoPedidoItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
        historicoMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buscarMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // tornando a tela visível
        setVisible(true);
    }

    public static void main(String[] args) {
        new Tela_Home();
    }
    
    // lincando as telas
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrarProduto) {
            Tela_CadastroProduto telacadas = new Tela_CadastroProduto();
            telacadas.setVisible(true);
        } else if (e.getSource() == novoPedidoItem) {
            Tela_RealizarPedido novopedido = new Tela_RealizarPedido();
            novopedido.setVisible(true);
        } else if (e.getSource() == historicoMenuItem) {
            Tela_Historicoped historicoped = new Tela_Historicoped();
            historicoped.setVisible(true);
        }
    }
}
