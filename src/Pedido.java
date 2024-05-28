
import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<ItemPedido> itens;
    private String metodoPagamento;
    private LocalDate datapedido;

    public Pedido(Cliente cliente, LocalDate dataPedido) {
        this.cliente = cliente;
        this.datapedido = dataPedido;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getValor() * item.getQuantidade();
        }
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodopagamento) {
        this.metodoPagamento = metodopagamento;
    }

    public LocalDate getDataPedido() {
        return datapedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.datapedido = dataPedido;
    }

}
