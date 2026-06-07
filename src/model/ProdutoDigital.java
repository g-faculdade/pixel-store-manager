package model;

public class ProdutoDigital extends Produto implements DescontavelInterface, CalculavelInterface {
    private String plataforma; 
    private double descontoDigital = 0.10; 

    public ProdutoDigital(int id, String nome, double preco, int quantidadeEstoque, String plataforma) {
        super(id, nome, preco, quantidadeEstoque);
        this.plataforma = plataforma;
    }

    @Override
    public double aplicarDesconto() {
        return getPreco() - (getPreco() * descontoDigital);
    }

    @Override
    public double calcularPrecoFinal() {
        return getPreco() - aplicarDesconto();
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}