import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Tela_Pagamento extends JFrame implements ActionListener {

    private Pedido pedidoAtual;
    private JButton btfinalizar;
    private JRadioButton rbDinheiro, rbPix, rbCartaoCredito, rbCartaoDebito;

    public Tela_Pagamento(Pedido pedido) {
        this.pedidoAtual = pedido;
    }

    Tela_Pagamento() {
        setTitle("Realizar Pagamento");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();

        JLabel lbtitle = new JLabel("Escolha forma de pagamento:");

        ButtonGroup grupoPagamento = new ButtonGroup();

        rbDinheiro = new JRadioButton("Dinheiro");
        rbPix = new JRadioButton("Pix");
        rbCartaoCredito = new JRadioButton("Cartão de Crédito");
        rbCartaoDebito = new JRadioButton("Cartão de Débito");
        grupoPagamento.add(rbPix);
        grupoPagamento.add(rbDinheiro);
        grupoPagamento.add(rbCartaoCredito);
        grupoPagamento.add(rbCartaoDebito);

        btfinalizar = new JButton("Finalizar Pedido");
        btfinalizar.addActionListener(this);

        lbtitle.setBounds(45, 15, 200, 30);

        rbPix.setBounds(30, 60, 150, 30);
        rbDinheiro.setBounds(30, 90, 80, 30);
        rbCartaoCredito.setBounds(30, 120, 200, 30);
        rbCartaoDebito.setBounds(30, 150, 200, 30);

        btfinalizar.setBackground(Color.BLACK);
        btfinalizar.setForeground(Color.WHITE);
        btfinalizar.setBounds(70, 210, 150, 30);

        painel.add(lbtitle);
        painel.add(rbPix);
        painel.add(rbDinheiro);
        painel.add(rbCartaoCredito);
        painel.add(rbCartaoDebito);
        painel.add(btfinalizar);

        lbtitle.setFont(new Font("Serif", Font.BOLD, 16));
        rbPix.setFont(new Font("Monospaced", Font.BOLD, 14));
        rbDinheiro.setFont(new Font("Monospaced", Font.BOLD, 14));
        rbCartaoCredito.setFont(new Font("Monospaced", Font.BOLD, 14));
        rbCartaoDebito.setFont(new Font("Monospaced", Font.BOLD, 14));
        btfinalizar.setFont(new Font("Dialog", Font.CENTER_BASELINE, 15));

        add(painel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Suponho que você já tenha uma instância de Pedido
        Pedido pedido = new Pedido();
        Tela_Pagamento formapag = new Tela_Pagamento(pedido);
        formapag.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btfinalizar) {
            String pagamento = "";
            if (rbPix.isSelected()) {
                pagamento = "Pix";
            } else if (rbDinheiro.isSelected()) {
                pagamento = "Dinheiro";
            } else if (rbCartaoCredito.isSelected()) {
                pagamento = "Cartão de Crédito";
            } else if (rbCartaoDebito.isSelected()) {
                pagamento = "Cartão de Débito";
            }
            if (!pagamento.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Forma de pagamento selecionada: " + pagamento);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione uma forma de pagamento.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
