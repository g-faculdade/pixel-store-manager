package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Pedido;
import model.Produto;
import util.Serializador;
import view.ClienteView;
import view.MenuView;
import view.PedidoView;
import view.ProdutoView;

public class PedidoController {

    private Scanner scanner;
    private PedidoView view;
    private MenuView menuView;
    private ClienteView clienteView;
    private ProdutoView produtoView;
    private ClienteController clienteController;
    private ProdutoController produtoController;
    private List<Pedido> pedidos;
    private int proximoId;

    public PedidoController(Scanner scanner, ClienteController clienteController, ProdutoController produtoController) {
        this.scanner = scanner;
        this.view = new PedidoView();
        this.menuView = new MenuView();
        this.clienteView = new ClienteView();
        this.produtoView = new ProdutoView();
        this.clienteController = clienteController;
        this.produtoController = produtoController;
        this.pedidos = (List<Pedido>) Serializador.carregar("pedido.ser");
        this.proximoId = calcularProximoId();
    }

    private int calcularProximoId() {
        int maiorId = 0;
        for (Pedido pedido : pedidos) {
            if (pedido.getId() > maiorId) {
                maiorId = pedido.getId();
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
                    menuView.sair();
                    break;

                default:
                    menuView.opcaoInvalida();
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

        listarTodosClientes(clientes);
        Cliente clienteSelecionado = selecionarCliente(clientes);

        if (clienteSelecionado == null) {
            view.clienteNaoEncontrado();
            return;
        }

        listarTodosProdutos(produtos);
        List<Produto> produtosSelecionados = selecionarProdutos(produtos);

        if (produtosSelecionados.isEmpty()) {
            view.nenhumProdutoSelecionado();
            return;
        }

        pedidos.add(new Pedido(proximoId, new Date(), clienteSelecionado, produtosSelecionados));
        proximoId++;
        Serializador.salvar("pedido.ser", pedidos);
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

                listarTodosClientes(clientes);
                Cliente novoCliente = selecionarCliente(clientes);

                if (novoCliente == null) {
                    view.clienteNaoEncontrado();
                    return;
                }

                listarTodosProdutos(produtos);
                List<Produto> novosProdutos = selecionarProdutos(produtos);

                if (novosProdutos.isEmpty()) {
                    view.nenhumProdutoSelecionado();
                    return;
                }

                pedido.setCliente(novoCliente);
                pedido.setProdutos(novosProdutos);
                pedido.setValorTotal(pedido.calcularValorTotal());

                Serializador.salvar("pedido.ser", pedidos);
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
                Serializador.salvar("pedido.ser", pedidos);
                view.pedidoDeletado();
                return;
            }
        }

        view.pedidoNaoEncontrado();
    }

    private void listarTodosClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            clienteView.exibirCliente(cliente);
        }
    }

    private void listarTodosProdutos(List<Produto> produtos) {
        for (Produto produto : produtos) {
            produtoView.exibirProduto(produto);
        }
    }

    private Cliente selecionarCliente(List<Cliente> clientes) {
        view.idCliente();
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    private List<Produto> selecionarProdutos(List<Produto> produtos) {
        List<Produto> selecionados = new ArrayList<>();
        int idProduto;
        do {
            view.idProduto();
            idProduto = scanner.nextInt();
            scanner.nextLine();

            if (idProduto == 0) {
                break;
            }

            boolean encontrado = false;
            for (Produto p : produtos) {
                if (p.getId() == idProduto) {
                    selecionados.add(p);
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) view.produtoNaoEncontrado();

        } while (true);
        return selecionados;
    }
}