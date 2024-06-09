import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela_Pagamento extends JFrame {
    private Pedido pedidoAtual;

    public Tela_Pagamento(Pedido pedido) {
        this.pedidoAtual = pedido;

        // Configuração da janela de pagamento
        setTitle("Realizar Pagamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Painel principal com layout null para uso do setBounds
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Label para o método de pagamento
        JLabel lblMetodoPagamento = new JLabel("Método de Pagamento:");
        lblMetodoPagamento.setBounds(20, 20, 150, 25);
        panel.add(lblMetodoPagamento);

        // Grupo de botões de rádio para métodos de pagamento
        ButtonGroup grupoPagamento = new ButtonGroup();
        JRadioButton rbPix = new JRadioButton("Pix");
        rbPix.setBounds(20, 50, 150, 25);
        JRadioButton rbDinheiro = new JRadioButton("Dinheiro");
        rbDinheiro.setBounds(20, 80, 150, 25);
        JRadioButton rbCartaoCredito = new JRadioButton("Cartão de Crédito");
        rbCartaoCredito.setBounds(20, 110, 150, 25);
        JRadioButton rbCartaoDebito = new JRadioButton("Cartão de Débito");
        rbCartaoDebito.setBounds(20, 140, 150, 25);
        grupoPagamento.add(rbPix);
        grupoPagamento.add(rbDinheiro);
        grupoPagamento.add(rbCartaoCredito);
        grupoPagamento.add(rbCartaoDebito);
        panel.add(rbPix);
        panel.add(rbDinheiro);
        panel.add(rbCartaoCredito);
        panel.add(rbCartaoDebito);

        // Botão para finalizar o pedido
        JButton btnFinalizar = new JButton("Finalizar");
        btnFinalizar.setBounds(150, 180, 100, 30);
        btnFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String metodoPagamento = "";
                if (rbPix.isSelected()) {
                    metodoPagamento = "Pix";
                } else if (rbDinheiro.isSelected()) {
                    metodoPagamento = "Dinheiro";
                } else if (rbCartaoCredito.isSelected()) {
                    metodoPagamento = "Cartão de Crédito";
                } else if (rbCartaoDebito.isSelected()) {
                    metodoPagamento = "Cartão de Débito";
                }
                if (metodoPagamento.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Selecione um método de pagamento!");
                    return;
                }
                pedidoAtual.setMetodoPagamento(metodoPagamento);
                Tela_RealizarPedido.getListaPedidos().add(pedidoAtual);
                JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso!");
                dispose();
            }
        });
        panel.add(btnFinalizar);

        // Adicionando o painel à janela
        add(panel);
        setVisible(true);
    }
}
