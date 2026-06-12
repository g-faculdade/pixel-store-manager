package view;

import model.Produto;
import java.util.Scanner;

public class ProdutoView {

    private Scanner scanner;

    public ProdutoView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void exibirMenu() {
        System.out.println("\n=============================");
        System.out.println("      GERENCIAR PRODUTOS");
        System.out.println("=============================");
        System.out.println("1 - Cadastrar Produto Fisico");
        System.out.println("2 - Cadastrar Produto Digital");
        System.out.println("3 - Listar Produtos");
        System.out.println("4 - Editar Produto");
        System.out.println("5 - Deletar Produto");
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

    public double lerPreco() {
        System.out.print("Preco: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        return preco;
    }

    public int lerQuantidade() {
        System.out.print("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        return quantidade;
    }

    public double lerTaxaFrete() {
        System.out.print("Taxa de frete: ");
        double taxa = scanner.nextDouble();
        scanner.nextLine();
        return taxa;
    }

    public void exibirProduto(Produto produto) {
        System.out.println("\n" + produto);
    }

    public void produtoFisicoCadastrado() {
        System.out.println("Produto fisico cadastrado com sucesso!");
    }

    public void produtoDigitalCadastrado() {
        System.out.println("Produto digital cadastrado com sucesso!");
    }

    public void isEmpty() {
        System.out.println("Nenhum produto cadastrado!");
    }

    public void produtoEditado() {
        System.out.println("Produto editado com sucesso!");
    }

    public void produtoDeletado() {
        System.out.println("Produto deletado com sucesso!");
    }

    public void produtoNaoEncontrado() {
        System.out.println("Produto nao foi encontrado!");
    }

    public void erroAoCarregar() {
        System.out.println("Nenhum produto encontrado. Iniciando lista vazia.");
    }
}