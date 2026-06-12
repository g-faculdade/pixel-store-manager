package view;

import model.Pedido;
import java.util.Scanner;

public class PedidoView {

    private Scanner scanner;

    public PedidoView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void exibirMenu() {
        System.out.println("\n=============================");
        System.out.println("      GERENCIAR PEDIDOS");
        System.out.println("=============================");
        System.out.println("1 - Criar Pedido");
        System.out.println("2 - Listar Pedidos");
        System.out.println("3 - Editar Pedido");
        System.out.println("4 - Deletar Pedido");
        System.out.println("0 - Voltar");
        System.out.println("=============================");
        System.out.print("Escolha uma opcao: ");
    }

    public int lerOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public int lerIdCliente() {
        System.out.print("Digite o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public int lerIdProduto() {
        System.out.print("Digite o ID do produto (0 para finalizar): ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public int lerIdPedido() {
        System.out.print("Digite o ID do pedido: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public void exibirPedido(Pedido pedido) {
        System.out.println("\n" + pedido);
    }

    public void pedidoCriado() {
        System.out.println("Pedido criado com sucesso!");
    }

    public void pedidoEditado() {
        System.out.println("Pedido editado com sucesso!");
    }

    public void pedidoDeletado() {
        System.out.println("Pedido deletado com sucesso!");
    }

    public void pedidoNaoEncontrado() {
        System.out.println("Pedido nao encontrado!");
    }

    public void isEmpty() {
        System.out.println("Nenhum pedido cadastrado!");
    }

    public void isEmptyClientes() {
        System.out.println("Nenhum cliente cadastrado! Cadastre um cliente primeiro.");
    }

    public void isEmptyProdutos() {
        System.out.println("Nenhum produto cadastrado! Cadastre um produto primeiro.");
    }

    public void clienteNaoEncontrado() {
        System.out.println("Cliente nao encontrado!");
    }

    public void produtoNaoEncontrado() {
        System.out.println("Produto nao encontrado!");
    }

    public void nenhumProdutoSelecionado() {
        System.out.println("Nenhum produto selecionado. Pedido nao criado.");
    }

    public void erroAoCarregar() {
        System.out.println("Nenhum pedido encontrado. Iniciando lista vazia.");
    }
}