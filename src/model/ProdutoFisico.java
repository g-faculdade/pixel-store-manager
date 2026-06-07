package model;

public class ProdutoFisico extends Produto implements FretavelInterface, CalculavelInterface {
    private double taxaFrete;

    public ProdutoFisico(int id, String nome, double preco, int quantidadeEstoque, double taxaFrete) {
        super(id, nome, preco, quantidadeEstoque);
        this.taxaFrete = taxaFrete;
    }

    @Override
    public double calcularFrete() {
        return taxaFrete;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() + calcularFrete();
    }

    public double getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(double taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    @Override
    public String toString() {
        return "ID: " + getId()
                + "\nNome: " + getNome()
                + String.format("\nPreco: R$ %.2f", getPreco())
                + "\nEstoque: " + getQuantidadeEstoque()
                + String.format("\nFrete: R$ %.2f", taxaFrete)
                + String.format("\nPreco Final: R$ %.2f", calcularPrecoFinal())
                + "\nTipo: Fisico";
    }
}