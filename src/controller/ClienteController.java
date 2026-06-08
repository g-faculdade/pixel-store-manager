package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import view.ClienteView;
import view.MenuView;

public class ClienteController {

    private Scanner scanner;
    private ClienteView view;
    private MenuView menuView;
    private List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public ClienteController(Scanner scanner) {
        this.scanner = scanner;
        this.view = new ClienteView();
        this.menuView = new MenuView();
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
                    menuView.sair();
                    break;

                default:
                    menuView.opcaoInvalida();
            }

        } while (opcao != 0);
    }

    private void cadastrarCliente() {
        view.lerNome();
        String nome = scanner.nextLine();

        view.lerCpf();
        String cpf = scanner.nextLine();

        view.lerEmail();
        String email = scanner.nextLine();

        view.lerEndereco();
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(proximoId, nome, cpf, email, endereco);
        clientes.add(cliente);
        proximoId++;

        view.clienteCadastrado();
    }

    private void listarClientes() {
        if (clientes.isEmpty()){
            view.isEmpty();
            return;
        }
        for (Cliente cliente : clientes){
            view.exibirCliente(cliente);
        }
    }

    private void editarCliente() {
        if (clientes.isEmpty()){
            view.isEmpty();
            return;
        }
        listarClientes();

        view.idCliente();
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                view.lerNome();
                String nome = scanner.nextLine();

                view.lerCpf();
                String cpf = scanner.nextLine();

                view.lerEmail();
                String email = scanner.nextLine();

                view.lerEndereco();
                String endereco = scanner.nextLine();

                cliente.setNome(nome);
                cliente.setCpf(cpf);
                cliente.setEmail(email);
                cliente.setEndereco(endereco);

                view.clienteEditado();
                return;
            }
        }
        view.clienteNaoEncontrado();
    }

    private void deletarCliente() {
        if (clientes.isEmpty()) {
            view.isEmpty();
            return;
        }

        listarClientes();

        view.idCliente();
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                view.clienteDeletado();
                return;
            }
        }

        view.clienteNaoEncontrado();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}