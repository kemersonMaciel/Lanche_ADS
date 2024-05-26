import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class Tela_Formapag extends JFrame implements ActionListener{

    ArrayList<String> Formapag = new ArrayList<>();

    JPanel painel = new JPanel();

    JLabel lbtitle = new JLabel("Escolha forma de pagamento:");
    
    JRadioButton rbpag1 = new JRadioButton("Dinheiro");
    JRadioButton rbpag2 = new JRadioButton("Pix");
    JRadioButton rbpag3 = new JRadioButton("Cartão de Crédito");
    JRadioButton rbpag4 = new JRadioButton("Cartão de Débito");

    ButtonGroup grupo = new ButtonGroup();

    JButton btfinalizar = new JButton("Finalizar Pedido");

    Tela_Formapag(){
        setTitle("Forma de Pagamento:");
        setSize(300,300);
        setLocation(600,150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        painel.setLayout(null);

        lbtitle.setBounds(45, 15,200,30);

        rbpag1.setBounds(30, 60, 150,30);
        rbpag2.setBounds(30, 90, 80,30);
        rbpag3.setBounds(30, 120, 200,30);
        rbpag4.setBounds(30, 150, 200,30);

        btfinalizar.setBackground(Color.BLACK);
        btfinalizar.setForeground(Color.WHITE);
        btfinalizar.setBounds(70,210,150,30);
        btfinalizar.addActionListener(this);

        grupo.add(rbpag1);
        grupo.add(rbpag2);
        grupo.add(rbpag3);
        grupo.add(rbpag4);

        painel.add(lbtitle);
        painel.add(rbpag1);
        painel.add(rbpag2);
        painel.add(rbpag3);
        painel.add(rbpag4);
        painel.add(btfinalizar);

        lbtitle.setFont(new Font("Serif",Font.BOLD, 16));
        rbpag1.setFont(new Font("Monospaced", Font.BOLD,14));
        rbpag2.setFont(new Font("Monospaced", Font.BOLD,14));
        rbpag3.setFont(new Font("Monospaced", Font.BOLD,14));
        rbpag4.setFont(new Font("Monospaced", Font.BOLD,14));
        btfinalizar.setFont(new Font("Dialog",Font.CENTER_BASELINE, 15));

        getContentPane().add(painel);
    }

    public static void main(String[] args) {
        Tela_Formapag formapag = new Tela_Formapag();
        formapag.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btfinalizar) {
            String pagamento = "";
            if (rbpag1.isSelected()) {
                pagamento = "Dinheiro";
            } else if (rbpag2.isSelected()) {
                pagamento = "Pix";
            } else if (rbpag3.isSelected()) {
                pagamento = "Cartão de Crédito";
            } else if (rbpag4.isSelected()) {
                pagamento = "Cartão de Débito";
            }
            if (!pagamento.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Forma de pagamento selecionada: " + pagamento);
            }else {
                JOptionPane.showMessageDialog(null, "Por favor, selecione uma forma de pagamento.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
