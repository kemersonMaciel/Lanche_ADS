import javax.swing.*;
import java.util.ArrayList;

public class Tela_BuscarProduto extends JFrame {
    public Tela_BuscarProduto() {
        // Configuração da janela de busca de produto
        setTitle("Buscar Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblTitulo = new JLabel("Produtos Cadastrados:");
        lblTitulo.setBounds(20, 20, 200, 25);
        panel.add(lblTitulo);

        ArrayList<Produto> produtos = Tela_CadastroProduto.getListaProdutos();
        int yPos = 50; 
        for (Produto produto : produtos) {
            JLabel lblProduto = new JLabel(produto.toString());
            lblProduto.setBounds(20, yPos, 350, 25); 
            panel.add(lblProduto);
            yPos += 30; 
        }

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        Tela_CadastroProduto.getListaProdutos().add(new Produto("Produto 1", 10.0, true));
        Tela_CadastroProduto.getListaProdutos().add(new Produto("Produto 2", 20.0, true));
        Tela_CadastroProduto.getListaProdutos().add(new Produto("Produto 3", 30.0, false));

        new Tela_BuscarProduto();
    }
}
