package controller;

import java.util.Scanner;
import view.PedidoView;

public class PedidoController {

    private final Scanner scanner;
    private final PedidoView view;

    public PedidoController(Scanner scanner) {
        this.scanner = scanner;
        this.view = new PedidoView();
    }

    public void iniciar() {

        int opcao;

        do {
            view.exibirMenu();

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    criarPedido();
                    break;

                case 2:
                    listarPedidos();
                    break;

                case 3:
                    editarPedido();
                    break;

                case 4:
                    deletarPedido();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

    private void criarPedido() {
        System.out.println("Criar Pedido");
    }

    private void listarPedidos() {
        System.out.println("Listar Pedidos");
    }

    private void editarPedido() {
        System.out.println("Editar Pedido");
    }

    private void deletarPedido() {
        System.out.println("Deletar Pedido");
    }
}