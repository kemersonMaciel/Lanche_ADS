import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela_Historicoped extends JFrame implements ActionListener{

    JPanel painel = new JPanel();

    JLabel lbdia = new JLabel("DATA:");
    JComboBox<String> cbData = new JComboBox<>();
    JLabel txtcliente = new JLabel("Cliente:");
    JLabel nomecliente = new JLabel("Kemerson Maciel");
    JLabel txtpedido  = new JLabel("Pedido:");
    JLabel quantpedido = new JLabel(" 2 ");
    JLabel nomepedido = new JLabel("X-salada");
    JLabel valorpedido = new JLabel("R$ 24,00");

    Tela_Historicoped(){
        setTitle("Histórico de Pedido");
        setSize(340, 450);
        setLocation(600, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        painel.setLayout(null); 

        lbdia.setBounds(30, 10, 80, 30);
        cbData.setBounds(70, 15, 150, 20);

        txtcliente.setBounds(15, 45, 80, 30);
        txtcliente.setFont(new Font("Serif",Font.BOLD,16));
        nomecliente.setBounds(45, 65, 150, 30);
        nomecliente.setFont(new Font("Monospaced", Font.ITALIC, 15));
        txtpedido.setBounds(15, 95, 80, 30);
        txtpedido.setFont(new Font("Serif", Font.BOLD, 16));
        quantpedido.setBounds(40, 120, 150, 30);
        quantpedido.setFont(new Font("Monospaced", Font.ITALIC, 15));
        nomepedido.setBounds(70, 120, 100, 30);
        nomepedido.setFont(new Font("Monospaced", Font.ITALIC, 15));
        valorpedido.setBounds(200, 120, 150, 30);
        valorpedido.setFont(new Font("Monospaced", Font.ITALIC, 15));

        painel.add(lbdia);
        painel.add(cbData);
        painel.add(txtcliente);
        painel.add(nomecliente);
        painel.add(txtpedido);
        painel.add(quantpedido);
        painel.add(nomepedido);
        painel.add(valorpedido);

        getContentPane().add(painel);

        populateDateComboBox();

    }

    private void populateDateComboBox() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        Date start = calendar.getTime();
        
        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_YEAR));
        Date end = calendar.getTime();
        
        Calendar current = new GregorianCalendar();
        current.setTime(start);

        while (current.getTime().before(end) || current.getTime().equals(end)) {
            cbData.addItem(sdf.format(current.getTime()));
            current.add(Calendar.DATE, 1);
        }
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