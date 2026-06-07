package controller;

import java.util.Scanner;
import view.ProdutoView;

public class ProdutoController {

    private final Scanner scanner;
    private final ProdutoView view;

    public ProdutoController(Scanner scanner) {
        this.scanner = scanner;
        this.view = new ProdutoView();
    }

    public void iniciar() {

        int opcao;

        do {
            view.exibirMenu();

            opcao = scanner.nextInt();

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
        System.out.println("Cadastrar Produto Fisico");
    }

    private void cadastrarProdutoDigital() {
        System.out.println("Cadastrar Produto Digital");
    }

    private void listarProdutos() {
        System.out.println("Listar Produtos");
    }

    private void editarProduto() {
        System.out.println("Editar Produto");
    }

    private void deletarProduto() {
        System.out.println("Deletar Produto");
    }
}