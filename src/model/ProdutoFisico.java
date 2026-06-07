package model;

public class ProdutoFisico extends Produto {
    private double taxaFrete;

    public ProdutoFisico(int id, String nome, double preco, int quantidadeEstoque, double taxaFrete) {
        super(id, nome, preco, quantidadeEstoque);
        this.taxaFrete = taxaFrete;
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() + taxaFrete;
    }

    public double getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(double taxaFrete) {
        this.taxaFrete = taxaFrete;
    }
}