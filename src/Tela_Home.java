import java.awt.Color;
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

public class Tela_Home implements ActionListener {
    
    Produto pro;

    JFrame tela = new JFrame("Kome-Kome Lanche");
    JPanel painel = new JPanel(new GridBagLayout());

    JMenuBar mb = new JMenuBar();
    JMenu cadastrarMenu = new JMenu("Cadastro");
    JMenuItem cadastrarProduto = new JMenuItem("Cadastrar Produto");
    JMenu pedidoMenu = new JMenu("Pedido");
    JMenuItem novoPedidoItem = new JMenuItem("Novo Pedido");
    JMenuItem historicoMenuItem = new JMenuItem("Histórico de Pedido");
    JMenu buscarMenu = new JMenu("Buscar");

    void criarTela() {
        tela.setSize(500, 500);
        tela.setLocation(500, 150);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.getContentPane().setBackground(new Color(47, 51, 53)); // Configura a cor de fundo do JFrame

        mb.add(cadastrarMenu);
        mb.add(pedidoMenu);
        mb.add(buscarMenu);

        cadastrarMenu.add(cadastrarProduto);
        pedidoMenu.add(novoPedidoItem);
        pedidoMenu.add(historicoMenuItem);

        cadastrarProduto.addActionListener(this);
        novoPedidoItem.addActionListener(this);
        historicoMenuItem.addActionListener(this);

        tela.setJMenuBar(mb);

        String imagePath = "src/source/Lanche.png";
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel imgLabel = new JLabel(icon);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(imgLabel, gbc);

        painel.setBackground(new Color(47, 51, 53)); // Configura a cor de fundo do painel
        tela.add(painel);
        tela.setVisible(true);

        // Configura as fontes dos menus e itens de menu
        cadastrarMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
        cadastrarProduto.setFont(new Font("Segoe UI", Font.BOLD, 14));
        pedidoMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
        novoPedidoItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
        historicoMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 14));
        buscarMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    public static void main(String[] args) {
        Tela_Home tela1 = new Tela_Home();
        tela1.criarTela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrarProduto) {
            Tela_Cadasprod telacadas = new Tela_Cadasprod();
            telacadas.setVisible(true);
        } else if (e.getSource() == novoPedidoItem) {
            Tela_Novoped novopedido = new Tela_Novoped();
            novopedido.setVisible(true);
        } else if (e.getSource() == historicoMenuItem) {
            Tela_Historicoped historicoped = new Tela_Historicoped();
            historicoped.setVisible(true);
        }
    }
}
