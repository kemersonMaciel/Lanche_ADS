import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Tela_Home implements ActionListener {
    
    Produto pro;

    JFrame tela = new JFrame("Lanche ADS");

    JMenuBar mb = new JMenuBar();
    JMenu cadastrarMenu = new JMenu("Cadastro");
    JMenuItem cadastrarProduto = new JMenuItem("Cadastrar Produto");
    JMenu pedidoMenu = new JMenu("Pedido");
    JMenuItem novoPedidoItem = new JMenuItem("Novo Pedido");
    JMenuItem historicoMenuItem = new JMenuItem("Histórico de Pedido");
    JMenu buscarMenu = new JMenu("Buscar");

        void criarTela(){
            tela.setSize(500,500);
            tela.setLocation(500,150);
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            mb.add(cadastrarMenu);
            mb.add(pedidoMenu);
            mb.add(buscarMenu);

            cadastrarMenu.add(cadastrarProduto);

            pedidoMenu.add(novoPedidoItem);
            pedidoMenu.add(historicoMenuItem);

            tela.setJMenuBar(mb);

            cadastrarProduto.addActionListener(this);
            novoPedidoItem.addActionListener(this);

            tela.setVisible(true);
        }


        public static void main(String[] args) {
        Tela_Home tela1 = new Tela_Home();
        tela1.criarTela();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == cadastrarProduto){
                Tela_Cadasprod telacadas = new Tela_Cadasprod();
                telacadas.setVisible(true);
            } else if (e.getSource() == novoPedidoItem){
                Tela_Novoped novopedido = new Tela_Novoped();
                novopedido.setVisible(true);
            }
        }    
    }
