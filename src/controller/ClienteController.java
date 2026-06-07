package controller;

import java.util.Scanner;
import view.ClienteView;

public class ClienteController {

    private final Scanner scanner;
    private final ClienteView view;

    public ClienteController(Scanner scanner) {
        this.scanner = scanner;
        this.view = new ClienteView();
    }

    public void iniciar() {

        int opcao;

        do {
            view.exibirMenu();

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarCliente();
                    break;

                case 2:
                    listarClientes();
                    break;

                case 3:
                    editarCliente();
                    break;

                case 4:
                    deletarCliente();
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        System.out.println("Cadastrar Cliente");
    }

    private void listarClientes() {
        System.out.println("Listar Clientes");
    }

    private void editarCliente() {
        System.out.println("Editar Cliente");
    }

    private void deletarCliente() {
        System.out.println("Deletar Cliente");
    }
}