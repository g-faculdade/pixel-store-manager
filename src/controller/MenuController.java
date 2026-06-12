package controller;

import view.MenuView;
import java.util.Scanner;

public class MenuController {

    private MenuView view;
    private ProdutoController produtoController;
    private ClienteController clienteController;
    private PedidoController pedidoController;

    public MenuController() {
        Scanner scanner = new Scanner(System.in);
        this.view = new MenuView(scanner);
        this.produtoController = new ProdutoController(scanner);
        this.clienteController = new ClienteController(scanner);
        this.pedidoController = new PedidoController(scanner, clienteController, produtoController);
    }

    public void iniciar() {
        int opcao;

        do {
            view.exibirMenu();
            opcao = view.lerOpcao();

            switch (opcao) {
                case 1:
                    produtoController.iniciar();
                    break;
                case 2:
                    clienteController.iniciar();
                    break;
                case 3:
                    pedidoController.iniciar();
                    break;
                case 0:
                    view.sair();
                    break;
                default:
                    view.opcaoInvalida();
            }
        } while (opcao != 0);
    }
}