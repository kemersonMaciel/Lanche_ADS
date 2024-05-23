import java.util.ArrayList;

public class Teste {
    public static void main(String[] args) {

        ArrayList<Produto> list = new ArrayList<Produto>();

        Produto pro1 = new Produto ("X-salada", 12.00, 10);
        Produto pro2 = new Produto ("Kikao", 10.00, 5);
        Produto pro3 = new Produto ("Refrigerante em lata", 6.00, 9);

        list.add(pro1);
        list.add(pro2);
        list.add(pro3);

        for(Produto x: list){
            System.out.println("O Produto: " + x.getDescricao());
            System.out.println("O Valor: R$ " + x.getValor());
            System.out.println("A Quantidade disponível: " + x.getQuantidade());
            System.out.println("-------------------------------");
        }

        list.remove(pro2);

        for(Produto x: list){
            System.out.println("O produto: " + x.getDescricao());
            System.out.println("O valor: R$ " + x.getValor());
            System.out.println("A Quantidade disponível: " + x.getQuantidade());
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }

        list.add(pro2);
        for(Produto x: list){
            System.out.println("O Produto: " + x.getDescricao());
            System.out.println("O Valor: R$ " + x.getValor());
            System.out.println("A Quantidade disponível: " + x.getQuantidade());
            System.out.println("-------------------------------");
        }
    }
}