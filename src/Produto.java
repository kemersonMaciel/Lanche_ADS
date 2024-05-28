public class Produto {

    private String nome;
    private Double valor;
    private Boolean ativo;


    public Produto (String nome, Double valor, Boolean ativo){
        super();
        this.nome = nome;
        this.valor = valor;
        this.ativo = ativo;
    }

    public String getNome(){
        return nome;
    }
    public Double getValor(){
        return valor;
    }  
    public boolean isAtivo(){
        return ativo;
    }
    @Override
    public String toString(){
        return nome + " - R$ " + valor;
    }
}