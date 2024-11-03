import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Tela_Home extends JFrame {
    public Tela_Home() {
        //Janela principal
        setTitle("Lanche ADS");
        setSize(500, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        // Barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Menu de Cadastro
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuItemCadastroProduto = new JMenuItem("Cadastro de Produto");
        menuItemCadastroProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tela_CadastroProduto();
            }
        });
        menuCadastro.add(menuItemCadastroProduto);

        // Menu de Pedido
        JMenu menuPedido = new JMenu("Pedido");
        JMenuItem menuItemRealizarPedido = new JMenuItem("Realizar Pedido");
        menuItemRealizarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tela_RealizarPedido();
            }
        });
        JMenuItem menuItemHistoricoPedido = new JMenuItem("Histórico de Pedido");
        menuItemHistoricoPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tela_HistoricoPedido();
            }
        });
        menuPedido.add(menuItemRealizarPedido);
        menuPedido.add(menuItemHistoricoPedido);

        // Menu de Buscar Produto
        JMenu menuBuscarProduto = new JMenu("Buscar Produto");
        JMenuItem menuItemBuscarProduto = new JMenuItem("Buscar Produto");
        menuItemBuscarProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Tela_BuscarProduto();
            }
        });
        menuBuscarProduto.add(menuItemBuscarProduto);

        menuBar.add(menuCadastro);
        menuBar.add(menuPedido);
        menuBar.add(menuBuscarProduto);

        setJMenuBar(menuBar);

        setVisible(true);

        String imagePath = "src/source/Lanche.png";
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imgLabel = new JLabel(icon);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(imgLabel, gbc);

        add(painel);

        menuCadastro.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuItemCadastroProduto.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuPedido.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuItemRealizarPedido.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuItemHistoricoPedido.setFont(new Font("Segoe UI", Font.BOLD, 14));
        menuBuscarProduto.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    public static void main(String[] args) {
        new Tela_Home();
    }
}
