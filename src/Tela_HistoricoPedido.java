import javax.swing.*;
import java.awt.*;

public class Tela_HistoricoPedido extends JFrame {
    public Tela_HistoricoPedido() {
        // Configuração da janela de histórico de pedidos
        setTitle("Histórico de Pedidos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com layout null para uso do setBounds
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // ScrollPane para o painel de pedidos
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 560, 340);
        panel.add(scrollPane);

        // Painel interno que será adicionado ao scrollPane
        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(null);
        scrollPane.setViewportView(innerPanel);

        int y = 10; // Coordenada Y inicial para os pedidos

        // Adicionando pedidos ao painel interno
        for (Pedido pedido : Tela_RealizarPedido.getListaPedidos()) {
            JTextArea textAreaPedido = new JTextArea();
            textAreaPedido.setEditable(false);
            textAreaPedido.setBounds(10, y, 530, 100);
            textAreaPedido.append("Cliente: " + pedido.getCliente().getNome() + "\n");
            textAreaPedido.append("Método de Pagamento: " + pedido.getMetodoPagamento() + "\n");
            textAreaPedido.append("Produtos:\n");
            for (ItemPedido item : pedido.getItens()) {
                textAreaPedido.append(item.getQuantidade() + "x " + item.getProduto().getNome() + " - R$ " + item.getProduto().getValor() + "\n");
            }
            textAreaPedido.append("Total: R$ " + pedido.calcularTotal() + "\n");
            textAreaPedido.append("-------------------------\n");
            innerPanel.add(textAreaPedido);
            y += 110; // Incrementa a coordenada Y para o próximo pedido
        }

        // Ajusta o tamanho do innerPanel para acomodar todos os pedidos
        innerPanel.setPreferredSize(new Dimension(550, y));

        // Adicionando o painel principal à janela
        add(panel);
        setVisible(true);
    }
}
