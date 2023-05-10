import java.util.ArrayList;
import java.util.List;

public class ListaDeProdutos {
    private List<Produto> produtos;

    public ListaDeProdutos() {
        produtos = new ArrayList<>();

        // Adicione os produtos desejados à lista de produtos
        produtos.add(new Produto("Arroz", 10.0, 20));
        produtos.add(new Produto("Feijão", 8.0, 15));
        produtos.add(new Produto("Macarrão", 5.0, 30));
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void exibirProdutosDisponiveis() {
        System.out.println("\n----- PRODUTOS DISPONÍVEIS -----");

        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: R$" + produto.getPreco());
            System.out.println("Quantidade em estoque: " + produto.getQuantidadeEmEstoque());
            System.out.println("---------------------------");
        }
    }
}