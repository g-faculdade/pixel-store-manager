package view;

import model.Cliente;

public class ClienteView {
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

    public void idCliente(){
        System.out.print("Digite o ID: ");
    }

    public void lerNome(){
        System.out.print("Nome: ");
    }

    public void lerCpf(){
        System.out.print("CPF: ");
    }

    public void lerEmail(){
        System.out.print("Email: ");
    }

    public void lerEndereco(){
        System.out.print("Endereço: ");
    }

    public void clienteCadastrado(){
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void exibirCliente(Cliente cliente) {
        System.out.println("\n" + cliente);
    }

    public void isEmpty(){
        System.out.println("Nenhum cliente cadastrado!");
    }

    public void clienteEditado(){
        System.out.println("Clienten editado com sucesso!");
    }

    public void clienteDeletado(){
        System.out.println("Cliente deletado com sucesso!");
    }

    public void clienteNaoEncontrado(){
        System.out.println("Cliente não foi encontrado!");
    }
}