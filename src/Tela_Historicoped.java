import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Tela_Historicoped extends JFrame implements ActionListener{
    
    Tela_Historicoped(){
    JPanel painel = new JPanel();
    //Adicionando pedido ao painel
    for (Pedido pedido : Tela_RealizarPedido.getListaPedidos()) {
            JTextArea textAreaPedido = new JTextArea();
            textAreaPedido.setEditable(false); // area não editada
            //append = adicionar a tela
            textAreaPedido.append("Cliente: " + pedido.getCliente().getNome() + "\n");
            textAreaPedido.append("Método de Pagamento: " + pedido.getMetodoPagamento() + "\n");
            textAreaPedido.append("Produtos:\n");
            for (ItemPedido item : pedido.getItens()) {
                textAreaPedido.append(item.getQuantidade() + "x " + item.getProduto().getNome() + " - R$ " + item.getProduto().getValor() + "\n");
            }
            textAreaPedido.append("Total: R$ " + pedido.calcularTotal() + "\n");
            textAreaPedido.append("-------------------------\n");
            painel.add(new JScrollPane(textAreaPedido)); //Scroll para visualizar a tela
        }
        setTitle("Histórico de Pedido");
        setSize(340, 450);
        setLocation(600, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        add(painel);
        setVisible(true);

    }

    public static void main(String[] args) {
        Tela_Historicoped historicoped = new Tela_Historicoped();
        historicoped.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementar a lógica de ação aqui, se necessário.
    }
}