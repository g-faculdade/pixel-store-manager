package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Produto;
import model.ProdutoDigital;
import model.ProdutoFisico;
import view.ProdutoView;

public class ProdutoController {

    private final Scanner scanner;
    private final ProdutoView view;
    private List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public ProdutoController(Scanner scanner) {
        this.scanner = scanner;
        this.view = new ProdutoView();
    }

    public void iniciar() {

        int opcao;

        do {
            view.exibirMenu();

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarProdutoFisico();
                    break;

                case 2:
                    cadastrarProdutoDigital();
                    break;

                case 3:
                    listarProdutos();
                    break;

                case 4:
                    editarProduto();
                    break;

                case 5:
                    deletarProduto();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

    private void cadastrarProdutoFisico() {
        view.lerNome();
        String nome = scanner.nextLine();

        view.lerPreco();
        double preco = scanner.nextDouble();

        view.lerQuantidade();
        int quantidade = scanner.nextInt();

        view.lerTaxaFrete();
        double taxaFrete = scanner.nextDouble();
        scanner.nextLine();

        ProdutoFisico produto = new ProdutoFisico(proximoId, nome, preco, quantidade, taxaFrete);
        produtos.add(produto);
        proximoId++;

        view.produtoFisicoCadastrado();
    }

    private void cadastrarProdutoDigital() {
        view.lerNome();
        String nome = scanner.nextLine();

        view.lerPreco();
        double preco = scanner.nextDouble();

        view.lerQuantidade();
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        ProdutoDigital produto = new ProdutoDigital(proximoId, nome, preco, quantidade);
        produtos.add(produto);
        proximoId++;

        view.produtoDigitalCadastrado();
    }

    private void listarProdutos() {
        if (produtos.isEmpty()) {
            view.isEmpty();
            return;
        }

        for (Produto produto : produtos) {
            view.exibirProduto(produto);
        }
    }

    private void editarProduto() {
        if (produtos.isEmpty()) {
            view.isEmpty();
            return;
        }

        listarProdutos();

        view.idProduto();
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                view.lerNome();
                String nome = scanner.nextLine();

                view.lerPreco();
                double preco = scanner.nextDouble();

                view.lerQuantidade();
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                produto.setNome(nome);
                produto.setPreco(preco);
                produto.setQuantidadeEstoque(quantidade);

                if (produto instanceof ProdutoFisico) {
                    view.lerTaxaFrete();
                    double taxaFrete = scanner.nextDouble();
                    scanner.nextLine();
                    ((ProdutoFisico) produto).setTaxaFrete(taxaFrete);
                }

                view.produtoEditado();
                return;
            }
        }

        view.produtoNaoEncontrado();
    }

    private void deletarProduto() {
        if (produtos.isEmpty()) {
            view.isEmpty();
            return;
        }

        listarProdutos();

        view.idProduto();
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                view.produtoDeletado();
                return;
            }
        }

        view.produtoNaoEncontrado();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
}