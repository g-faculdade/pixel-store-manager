package view;

import model.Cliente;
import java.util.Scanner;

public class ClienteView {

    private Scanner scanner;

    public ClienteView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void exibirMenu() {
        System.out.println("\n=============================");
        System.out.println("      GERENCIAR CLIENTES");
        System.out.println("=============================");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Listar Clientes");
        System.out.println("3 - Editar Cliente");
        System.out.println("4 - Deletar Cliente");
        System.out.println("0 - Voltar");
        System.out.println("=============================");
        System.out.print("Escolha uma opcao: ");
    }

    public int lerOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public int lerId() {
        System.out.print("Digite o ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public String lerNome() {
        System.out.print("Nome: ");
        return scanner.nextLine();
    }

    public String lerCpf() {
        System.out.print("CPF: ");
        return scanner.nextLine();
    }

    public String lerEmail() {
        System.out.print("Email: ");
        return scanner.nextLine();
    }

    public String lerEndereco() {
        System.out.print("Endereço: ");
        return scanner.nextLine();
    }

    public void exibirCliente(Cliente cliente) {
        System.out.println("\n" + cliente);
    }

    public void clienteCadastrado() {
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void isEmpty() {
        System.out.println("Nenhum cliente cadastrado!");
    }

    public void clienteEditado() {
        System.out.println("Cliente editado com sucesso!");
    }

    public void clienteDeletado() {
        System.out.println("Cliente deletado com sucesso!");
    }

    public void clienteNaoEncontrado() {
        System.out.println("Cliente não foi encontrado!");
    }

    public void erroAoCarregar() {
        System.out.println("Nenhum cliente encontrado. Iniciando lista vazia.");
    }
}