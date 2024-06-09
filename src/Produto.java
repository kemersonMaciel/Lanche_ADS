public class Produto {
    private String nome;
    private Double valor;
    private Boolean ativo;

    public Produto(String nome, double valor, boolean ativo) {
        this.nome = nome;
        this.valor = valor;
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return nome + " - R$ " + valor;
    }
}
