import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela_CadastroProduto extends JFrame implements ActionListener {

    private JTextField txtProduto;
    private JTextField txtValor;
    private JCheckBox chAtivo;
    private JButton btsalvar;
    
    // Declaração e inicialização da lista de produtos
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    Tela_CadastroProduto() {
        setTitle("Cadastrar Produto");
        setSize(310, 320);
        setLocation(600, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel(null);

        JLabel lbtitle = new JLabel("Cadastre os seus produtos!");
        JLabel lbdesc = new JLabel("Produto:");
        txtProduto = new JTextField();
        JLabel lbvalor = new JLabel("Valor:");
        txtValor = new JTextField();
        chAtivo = new JCheckBox("Ativo");

        btsalvar = new JButton("Salvar");
        btsalvar.addActionListener(this);
        btsalvar.setBackground(Color.BLACK);
        btsalvar.setForeground(Color.WHITE);

        // Define as posições e tamanhos
        lbtitle.setBounds(50, 15, 300, 30);
        lbdesc.setBounds(15, 60, 80, 30);
        txtProduto.setBounds(100, 60, 150, 30);
        lbvalor.setBounds(15, 120, 80, 30);
        txtValor.setBounds(100, 120, 150, 30);
        chAtivo.setBounds(100, 150, 150, 30);
        btsalvar.setBounds(100, 210, 100, 30);

        // Ajusta as fontes
        lbtitle.setFont(new Font("Serif", Font.BOLD, 16));
        lbdesc.setFont(new Font("Sans", Font.BOLD, 15));
        lbvalor.setFont(new Font("Sans", Font.BOLD, 15));
        chAtivo.setFont(new Font("Sans", Font.BOLD, 15));
        btsalvar.setFont(new Font("Dialog", Font.CENTER_BASELINE, 14));
        txtProduto.setFont(new Font("Monospaced", Font.PLAIN, 15));
        txtValor.setFont(new Font("Monospaced", Font.PLAIN, 15));

        // Adiciona os componentes ao painel
        painel.add(lbtitle);
        painel.add(lbdesc);
        painel.add(txtProduto);
        painel.add(lbvalor);
        painel.add(txtValor);
        painel.add(chAtivo);
        painel.add(btsalvar);

        // Adiciona o painel à janela
        add(painel);
        setVisible(true);
    }

    //retornando lista de produto
    public static ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    //ação de clicar nos botão salvar e coletar os dados
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btsalvar) {
            String d = txtProduto.getText();
            try {
                Double v = Double.parseDouble(txtValor.getText());
                boolean disponivel = chAtivo.isSelected();
                Produto pro = new Produto(d, v, disponivel);
                listaProdutos.add(pro);
                JOptionPane.showMessageDialog(null, "Produto Adicionado e disponível para pedidos");
                txtProduto.setText("");
                txtValor.setText("");
                chAtivo.setSelected(false);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido para o preço", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Tela_CadastroProduto();
    }
}
