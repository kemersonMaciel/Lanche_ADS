import javax.swing.*;
import java.awt.*;

public class Tela_HistoricoPedido extends JFrame {
    public Tela_HistoricoPedido() {
        setTitle("Histórico de Pedidos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 560, 340);
        panel.add(scrollPane);

        JPanel innerPanel = new JPanel();
        innerPanel.setLayout(null);
        scrollPane.setViewportView(innerPanel);

        int y = 10; 

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
            y += 110;
        }

        innerPanel.setPreferredSize(new Dimension(550, y));

        add(panel);
        setVisible(true);
    }
}
