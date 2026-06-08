package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Pedido;
import model.Produto;
import model.ProdutoDigital;
import model.ProdutoFisico;
import util.Serializador;
import view.MenuView;
import view.ProdutoView;

public class ProdutoController {

    private Scanner scanner;
    private ProdutoView view;
    private MenuView menuView;
    private List<Produto> produtos;
    private int proximoId;

    public ProdutoController(Scanner scanner) {
        this.scanner = scanner;
        this.view = new ProdutoView();
        this.menuView = new MenuView();
        this.produtos = (List<Produto>) Serializador.carregar("produto.ser");
        this.proximoId = calcularProximoId();
    }

    private int calcularProximoId() {
        int maiorId = 0;
        for (Produto produto : produtos) {
            if (produto.getId() > maiorId) {
                maiorId = produto.getId();
            }
        }
        return maiorId + 1;
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
                    menuView.sair();
                    break;

                default:
                    menuView.opcaoInvalida();
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

        Serializador.salvar("produto.ser", produtos);
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

        Serializador.salvar("produto.ser", produtos);
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

                Serializador.salvar("produto.ser", produtos);
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
                Serializador.salvar("produto.ser", produtos);
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