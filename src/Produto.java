public class Produto {

    private String descricao;
    private Double valor;
    private Boolean disponivel;

    Produto(){}

    public Produto (String descricao, Double valor, Boolean disponivel){
        super();
        this.descricao = descricao;
        this.valor = valor;
        this.disponivel = disponivel;
    }

    public String getDescricao(){
        return descricao;
    }
    public Double getValor(){
        return valor;
    }  
    public boolean isDisponivel(){
        return disponivel;
    }
}