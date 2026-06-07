package view;

import model.Produto;

public class ProdutoView {
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

    public void idProduto() {
        System.out.print("Digite o ID: ");
    }

    public void lerNome() {
        System.out.print("Nome: ");
    }

    public void lerPreco() {
        System.out.print("Preco: ");
    }

    public void lerQuantidade() {
        System.out.print("Quantidade em estoque: ");
    }

    public void lerTaxaFrete() {
        System.out.print("Taxa de frete: ");
    }

    public void produtoFisicoCadastrado() {
        System.out.println("Produto fisico cadastrado com sucesso!");
    }

    public void produtoDigitalCadastrado() {
        System.out.println("Produto digital cadastrado com sucesso!");
    }

    public void exibirProduto(Produto produto) {
        System.out.println("\n" + produto);
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
}