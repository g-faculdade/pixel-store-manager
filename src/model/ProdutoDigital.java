package model;

public class ProdutoDigital extends Produto {
    private String plataforma; // ex: Plataformas de Jogos Steam....
    private double descontoDigital = 0.10; // Desconto dos Jogos Digitais 

    public ProdutoDigital(int id, String nome, double preco, int quantidadeEstoque, String plataforma) {
        super(id, nome, preco, quantidadeEstoque);
        this.plataforma = plataforma;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() - (getPreco() * descontoDigital);
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}