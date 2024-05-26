public class Cliente {
    private String nome;
    private String cpf;
    private String fone;
    private String endereco;

    public Cliente(String nome, String cpf, String fone, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.fone = fone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getFone() {
        return fone;
    }

    public String getEndereco() {
        return endereco;
    }
}