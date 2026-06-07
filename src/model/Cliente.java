package model;

public class Cliente extends Pessoa {
    private String endereco;

    public Cliente(int id, String nome, String cpf, String email, String endereco) {
        super(id, nome, cpf, email);
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}