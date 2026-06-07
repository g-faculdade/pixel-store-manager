package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Pedido;
import model.Produto;
import view.PedidoView;

public class PedidoController {

    private final Scanner scanner;
    private final PedidoView view;
    private final ClienteController clienteController;
    private final ProdutoController produtoController;
    private List<Pedido> pedidos = new ArrayList<>();
    private int proximoId = 1;

    public PedidoController(Scanner scanner, ClienteController clienteController, ProdutoController produtoController) {
        this.scanner = scanner;
        this.view = new PedidoView();
        this.clienteController = clienteController;
        this.produtoController = produtoController;
    }

    public void iniciar() {

        int opcao;

        do {
            view.exibirMenu();

            opcao = scanner.nextInt();
            scanner.nextLine();

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
        List<Cliente> clientes = clienteController.getClientes();
        List<Produto> produtos = produtoController.getProdutos();

        if (clientes.isEmpty()) {
            view.isEmptyClientes();
            return;
        }

        if (produtos.isEmpty()) {
            view.isEmptyProdutos();
            return;
        }

        // Exibe clientes disponíveis
        for (Cliente cliente : clientes) {
            System.out.println("\n" + cliente);
        }

        view.idCliente();
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        Cliente clienteSelecionado = null;
        for (Cliente c : clientes) {
            if (c.getId() == idCliente) {
                clienteSelecionado = c;
                break;
            }
        }

        if (clienteSelecionado == null) {
            view.clienteNaoEncontrado();
            return;
        }

        // Exibe produtos disponíveis
        for (Produto produto : produtos) {
            System.out.println("\n" + produto);
        }

        List<Produto> produtosSelecionados = new ArrayList<>();

        int idProduto;
        do {
            view.idProduto();
            idProduto = scanner.nextInt();
            scanner.nextLine();

            if (idProduto == 0) break;

            Produto produtoEncontrado = null;
            for (Produto p : produtos) {
                if (p.getId() == idProduto) {
                    produtoEncontrado = p;
                    break;
                }
            }

            if (produtoEncontrado == null) {
                view.produtoNaoEncontrado();
            } else {
                produtosSelecionados.add(produtoEncontrado);
            }

        } while (true);

        if (produtosSelecionados.isEmpty()) {
            view.nenhumProdutoSelecionado();
            return;
        }

        Pedido pedido = new Pedido(proximoId, new Date(), clienteSelecionado, produtosSelecionados);
        pedidos.add(pedido);
        proximoId++;

        view.pedidoCriado();
    }

    private void listarPedidos() {
        if (pedidos.isEmpty()) {
            view.isEmpty();
            return;
        }

        for (Pedido pedido : pedidos) {
            view.exibirPedido(pedido);
        }
    }

    private void editarPedido() {
        if (pedidos.isEmpty()) {
            view.isEmpty();
            return;
        }

        listarPedidos();

        view.idPedido();
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                List<Cliente> clientes = clienteController.getClientes();
                List<Produto> produtos = produtoController.getProdutos();

                // Selecionar novo cliente
                for (Cliente cliente : clientes) {
                    System.out.println("\n" + cliente);
                }

                view.idCliente();
                int idCliente = scanner.nextInt();
                scanner.nextLine();

                Cliente novoCliente = null;
                for (Cliente c : clientes) {
                    if (c.getId() == idCliente) {
                        novoCliente = c;
                        break;
                    }
                }

                if (novoCliente == null) {
                    view.clienteNaoEncontrado();
                    return;
                }

                // Selecionar novos produtos
                for (Produto produto : produtos) {
                    System.out.println("\n" + produto);
                }

                List<Produto> novosProdutos = new ArrayList<>();

                int idProduto;
                do {
                    view.idProduto();
                    idProduto = scanner.nextInt();
                    scanner.nextLine();

                    if (idProduto == 0) break;

                    Produto produtoEncontrado = null;
                    for (Produto p : produtos) {
                        if (p.getId() == idProduto) {
                            produtoEncontrado = p;
                            break;
                        }
                    }

                    if (produtoEncontrado == null) {
                        view.produtoNaoEncontrado();
                    } else {
                        novosProdutos.add(produtoEncontrado);
                    }

                } while (true);

                if (novosProdutos.isEmpty()) {
                    view.nenhumProdutoSelecionado();
                    return;
                }

                pedido.setCliente(novoCliente);
                pedido.setProdutos(novosProdutos);
                pedido.setValorTotal(pedido.calcularValorTotal());

                view.pedidoEditado();
                return;
            }
        }

        view.pedidoNaoEncontrado();
    }

    private void deletarPedido() {
        if (pedidos.isEmpty()) {
            view.isEmpty();
            return;
        }

        listarPedidos();

        view.idPedido();
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                pedidos.remove(pedido);
                view.pedidoDeletado();
                return;
            }
        }

        view.pedidoNaoEncontrado();
    }
}