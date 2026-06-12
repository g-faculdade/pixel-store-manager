package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import util.Serializador;
import view.ClienteView;
import view.MenuView;

public class ClienteController {

    private ClienteView view;
    private MenuView menuView;
    private List<Cliente> clientes;
    private int proximoId;

    public ClienteController(Scanner scanner) {
        this.view = new ClienteView(scanner);
        this.menuView = new MenuView(scanner);

        Object dados = Serializador.carregar("clientes.ser");
        if (dados == null) {
            view.erroAoCarregar();
            this.clientes = new ArrayList<>();
        } else {
            this.clientes = (List<Cliente>) dados;
        }

        this.proximoId = calcularProximoId();
    }

    private int calcularProximoId() {
        int maiorId = 0;
        for (Cliente cliente : clientes) {
            if (cliente.getId() > maiorId) {
                maiorId = cliente.getId();
            }
        }
        return maiorId + 1;
    }

    public void iniciar() {
        int opcao;

        do {
            view.exibirMenu();
            opcao = view.lerOpcao();

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
        String nome = view.lerNome();
        String cpf = view.lerCpf();
        String email = view.lerEmail();
        String endereco = view.lerEndereco();

        Cliente cliente = new Cliente(proximoId, nome, cpf, email, endereco);
        clientes.add(cliente);
        proximoId++;

        Serializador.salvar("clientes.ser", clientes);
        view.clienteCadastrado();
    }

    private void listarClientes() {
        if (clientes.isEmpty()) {
            view.isEmpty();
            return;
        }

        for (Cliente cliente : clientes) {
            view.exibirCliente(cliente);
        }
    }

    private void editarCliente() {
        if (clientes.isEmpty()) {
            view.isEmpty();
            return;
        }

        listarClientes();
        int id = view.lerId();

        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNome(view.lerNome());
                cliente.setCpf(view.lerCpf());
                cliente.setEmail(view.lerEmail());
                cliente.setEndereco(view.lerEndereco());

                Serializador.salvar("clientes.ser", clientes);
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
        int id = view.lerId();

        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                Serializador.salvar("clientes.ser", clientes);
                view.clienteDeletado();
                return;
            }
        }

        view.clienteNaoEncontrado();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public ClienteView getView() {
        return view;
    }
}