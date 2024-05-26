import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class Tela_Novoped extends JFrame implements ActionListener {

    ArrayList<String> pedidos = new ArrayList<>();

    JPanel painel = new JPanel();

    JLabel lbtitulo = new JLabel("Faça seu pedido");

    JLabel lbcliente = new JLabel("Cliente:");
    JComboBox<String> cbcliente = new JComboBox<>();
    
    JLabel lbselecpedido = new JLabel("Selecione seu pedido:");
    JComboBox<String> cbopcao = new JComboBox<>();

    JLabel lbquantidade = new JLabel("Quantidade");
    JSpinner spquantidade = new JSpinner();

    JLabel lbselped = new JLabel("Dados do Pedido:");
    JLabel lbpedido1 = new JLabel("............");
    JLabel lbpedido2 = new JLabel("............");
    JLabel lbpedido3 = new JLabel("............");

    JButton btcontinue = new JButton("Continuar");
    JButton btadd = new JButton("Adicionar");
    JButton btcadasclien = new JButton("Cadastrar Cliente");

    Tela_Novoped(){
        setTitle("Novo Pedido");
        setSize(400,490);
        setLocation(600, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        painel.setLayout(null);

        lbtitulo.setBounds(150, 15, 150, 30);
        lbcliente.setBounds(30,50,80,30);
        cbcliente.setBounds(30, 80, 150, 30);
        lbselecpedido.setBounds(30,140,150,30);
        cbopcao.setBounds(30,170,150,30);
        lbquantidade.setBounds(30,210,80,30);
        lbselped.setBounds(30,300,100,30);
        lbpedido1.setBounds(30, 320, 150, 30);
        lbpedido2.setBounds(30, 340, 150, 30);
        lbpedido3.setBounds(30, 360, 150, 30);

        btcadasclien.setBounds(215,80,150,30);
        btcadasclien.addActionListener(this);

        btcontinue.setBounds(155, 400, 90, 30);
        btcontinue.addActionListener(this);

        btadd.setBounds(215, 170, 90, 30);
        btadd.addActionListener(this);

        spquantidade.setBounds(30,240,100,30);

        painel.add(lbtitulo);
        painel.add(lbcliente);
        painel.add(cbcliente);
        painel.add(lbselecpedido);
        painel.add(lbquantidade);
        painel.add(cbopcao);
        painel.add(lbselped);
        painel.add(lbpedido1);
        painel.add(lbpedido2);
        painel.add(lbpedido3);
        painel.add(btcontinue);
        painel.add(btadd);
        painel.add(btcadasclien);
        painel.add(spquantidade);

        getContentPane().add(painel);

        cbcliente.addItem("Kemerson Maciel");
        cbcliente.addItem("Luiz Carlinhos Bala");
        cbcliente.addItem("Thaissinha");
        cbcliente.addItem("Presley delas");

        cbopcao.addItem("X-salada");
        cbopcao.addItem("Kikao");
        cbopcao.addItem("Pizza P");
        cbopcao.addItem("Refrigerante em Lata");
    }

    public static void main(String[] args) {
        Tela_Novoped novopedido = new Tela_Novoped();
        novopedido.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        lbpedido1.setText(cbopcao.getSelectedItem().toString());
        if (e.getSource() == btcadasclien){
            Tela_Cadascliente cliente = new Tela_Cadascliente();
            cliente.setVisible(true);
        }else if (e.getSource() == btcontinue){
            Tela_Formapag formapag = new Tela_Formapag();
            formapag.setVisible(true);
        }
    }
}
