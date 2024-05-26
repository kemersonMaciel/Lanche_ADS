import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;



public class Historicopedido extends JFrame implements ActionListener{

   JPanel painel = new JPanel();

   JLabel lbtitulo = new JLabel("Últimos Pedidos");
   JLabel lbcliente = new JLabel("Cliente");
   JLabel lbdia = new JLabel("Dia");
   JComboBox<String> cbopcao = new JComboBox<>();
   JTextField txtcliente = new JTextField();
   JTextField txtdia = new JTextField();
    


   Historicopedido(){
        setTitle("Histórico de Pedido");
        setSize(340,450);
        setLocation(600, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        painel.setLayout(null);

        lbtitulo.setBounds(90, 15,150,30);
        lbcliente.setBounds(30, 50, 80, 30);
        txtcliente.setBounds(30, 80, 150, 30);
        lbdia.setBounds(30, 120, 280, 30);
        txtdia.setBounds(100, 140, 150, 30);
        cbopcao.setBounds(30,150,150,30);
       
        painel.add(lbtitulo);
        painel.add(lbcliente);
        painel.add(txtcliente);
        painel.add(lbdia);
        painel.add(cbopcao);

        getContentPane().add(painel);

        cbopcao.addItem("segunda-feira");
        cbopcao.addItem("terça-feira");
        cbopcao.addItem("quarta-feira");
        cbopcao.addItem("quinta-feira");
        cbopcao.addItem("sexta-feira");
        cbopcao.addItem("sábado");
        cbopcao.addItem("domingo");
        

    }

    public static void main(String[] args) {
        Historicopedido historicopedido = new Historicopedido();
        historicopedido.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}