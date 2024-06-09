import javax.swing.*;
import java.util.ArrayList;

public class Tela_BuscarProduto extends JFrame {
    public Tela_BuscarProduto() {
        // Configuração da janela de busca de produto
        setTitle("Buscar Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com layout null para uso do setBounds
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Label título
        JLabel lblTitulo = new JLabel("Produtos Cadastrados:");
        lblTitulo.setBounds(20, 20, 200, 25);
        panel.add(lblTitulo);

        // Adicionando produtos ao painel
        ArrayList<Produto> produtos = Tela_CadastroProduto.getListaProdutos();
        int yPos = 50; // Posição inicial y
        for (Produto produto : produtos) {
            JLabel lblProduto = new JLabel(produto.toString());
            lblProduto.setBounds(20, yPos, 350, 25); // Ajustar largura conforme necessário
            panel.add(lblProduto);
            yPos += 30; // Incrementar a posição y para o próximo produto
        }

        // Adicionando o painel à janela
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Simular a adição de alguns produtos para teste
        Tela_CadastroProduto.getListaProdutos().add(new Produto("Produto 1", 10.0, true));
        Tela_CadastroProduto.getListaProdutos().add(new Produto("Produto 2", 20.0, true));
        Tela_CadastroProduto.getListaProdutos().add(new Produto("Produto 3", 30.0, false));

        // Exibir a tela de buscar produto
        new Tela_BuscarProduto();
    }
}
