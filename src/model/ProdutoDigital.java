package model;

public class ProdutoDigital extends Produto implements DescontavelInterface, CalculavelInterface {
    private double descontoDigital = 0.10;

    public ProdutoDigital(int id, String nome, double preco, int quantidadeEstoque) {
        super(id, nome, preco, quantidadeEstoque);
    }

    @Override
    public double aplicarDesconto() {
        return getPreco() - (getPreco() * descontoDigital);
    }

    @Override
    public double calcularPrecoFinal() {
        return aplicarDesconto();
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nNome: " + getNome()
                + String.format("\nPreco: R$ %.2f", getPreco())
                + "\nEstoque: " + getQuantidadeEstoque()
                + String.format("\nPreco Final (c/ desconto 10%%): R$ %.2f", calcularPrecoFinal())
                + "\nTipo: Digital";
    }
}