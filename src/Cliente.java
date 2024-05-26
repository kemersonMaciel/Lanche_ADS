import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Cliente extends JFrame implements ActionListener {

    ArrayList<String> Cliente = new ArrayList<>();

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
