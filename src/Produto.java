public class Produto {

    private String descricao;
    private Double valor;
    private Integer quantidade;

    Produto(){}

    public Produto (String descricao, Double valor, Integer quantidade){
        super();
        this.descricao = descricao;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getDescricao(){
        return descricao;
    }
    public Double getValor(){
        return valor;
    }  
    public Integer getQuantidade(){
        return quantidade;
    }
}