package model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {
    private int id;
    private Date dataPedido;
    private Cliente cliente;
    private List<Produto> produtos;
    private double valorTotal;

    public Pedido(int id, Date dataPedido, Cliente cliente, List<Produto> produtos) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.produtos = produtos;
        this.valorTotal = calcularValorTotal();
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.calcularPrecoFinal();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        String produtosStr = "";
        for (Produto p : produtos) {
            produtosStr = produtosStr + "\n  - " + p.getNome() + String.format(" (R$ %.2f)", p.calcularPrecoFinal());
        }
        return "ID: " + id +
                "\nData: " + dataPedido +
                "\nCliente: " + cliente.getNome() +
                "\nProdutos:" + produtosStr +
                String.format("\nValor Total: R$ %.2f", valorTotal);
    }
}