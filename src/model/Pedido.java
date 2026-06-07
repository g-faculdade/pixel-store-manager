package model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pedido {
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id);
        sb.append("\nData: ").append(sdf.format(dataPedido));
        sb.append("\nCliente: ").append(cliente.getNome());
        sb.append("\nProdutos:");
        for (Produto p : produtos) {
            sb.append("\n  - ").append(p.getNome())
              .append(String.format(" (R$ %.2f)", p.calcularPrecoFinal()));
        }
        sb.append(String.format("\nValor Total: R$ %.2f", valorTotal));
        return sb.toString();
    }
}