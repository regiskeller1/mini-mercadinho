import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarrinhoDeCompras {
    private List<Produto> itens;
    private Scanner scanner;

    public CarrinhoDeCompras() {
        itens = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarProduto(ListaDeProdutos listaDeProdutos) {
        System.out.println("\n----- ADICIONAR PRODUTO AO CARRINHO -----");
        listaDeProdutos.exibirProdutosDisponiveis();

        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();

        Produto produtoSelecionado = null;

        for (Produto produto : listaDeProdutos.getProdutos()) {
            if (produto.getNome().equalsIgnoreCase(nomeProduto)) {
                produtoSelecionado = produto;
                break;
            }
        }

        if (produtoSelecionado != null) {
            System.out.print("Digite a quantidade desejada: ");
            int quantidade = scanner.nextInt();

            if (quantidade > 0 && quantidade <= produtoSelecionado.getQuantidadeEmEstoque()) {
                Produto produtoNoCarrinho = null;

                for (Produto item : itens) {
                    if (item.getNome().equalsIgnoreCase(nomeProduto)) {
                        produtoNoCarrinho = item;
                        break;
                    }
                }

                if (produtoNoCarrinho != null) {
                    produtoNoCarrinho.setQuantidadeEmEstoque(produtoNoCarrinho.getQuantidadeEmEstoque() + quantidade);
                } else {
                    Produto novoItem = new Produto(produtoSelecionado.getNome(), produtoSelecionado.getPreco(), quantidade);
                    itens.add(novoItem);
                }

                produtoSelecionado.setQuantidadeEmEstoque(produtoSelecionado.getQuantidadeEmEstoque() - quantidade);
                System.out.println("Produto adicionado ao carrinho com sucesso.");
            } else {
                System.out.println("Quantidade inválida ou produto fora de estoque.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void removerProduto() {
        System.out.println("\n----- REMOVER PRODUTO DO CARRINHO -----");

        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            System.out.print("Digite o nome do produto: ");
            String nomeProduto = scanner.nextLine();

            Produto produtoRemovido = null;

            for (Produto item : itens) {
                if (item.getNome().equalsIgnoreCase(nomeProduto)) {
                    produtoRemovido = item;
                    break;
                }
            }

            if (produtoRemovido != null) {
                itens.remove(produtoRemovido);
                System.out.println("Produto removido do carrinho com sucesso.");
            } else {
                System.out.println("Produto não encontrado no carrinho.");
            }
        }
    }

    public void visualizarCarrinho() {
        System.out.println("\n----- CARRINHO DE COMPRAS -----");

        if (itens.isEmpty()) {
            System.out.println("O carrinho está vazio.");
        } else {
            for (Produto item : itens) {
                System.out.println("Nome: " + item.getNome());
                System.out.println("Preço unitário: R$" + item.getPreco());
                System.out.println("Quantidade: " + item.getQuantidadeEmEstoque());
                System.out.println("Total: R$" + (item.getPreco() * item.getQuantidadeEmEstoque()));
                System.out.println("---------------------------");
            }
        }
    }
    public List<Produto> getItens() {
        return itens;
    }

    public void limparCarrinho() {
        itens.clear();
    }
}