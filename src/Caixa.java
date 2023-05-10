import java.util.List;

public class Caixa {
    public void finalizarCompra(CarrinhoDeCompras carrinhoDeCompras) {
        List<Produto> itens = carrinhoDeCompras.getItens();

        if (itens.isEmpty()) {
            System.out.println("\nNão há itens no carrinho.");
        } else {
            double total = 0;

            System.out.println("\n----- FINALIZAR COMPRA -----");
            System.out.println("Itens do carrinho:");

            for (Produto item : itens) {
                System.out.println("Nome: " + item.getNome());
                System.out.println("Preço unitário: R$" + item.getPreco());
                System.out.println("Quantidade: " + item.getQuantidadeEmEstoque());
                System.out.println("Total: R$" + (item.getPreco() * item.getQuantidadeEmEstoque()));
                System.out.println("---------------------------");

                total += item.getPreco() * item.getQuantidadeEmEstoque();
            }

            System.out.println("Total da compra: R$" + total);
            System.out.println("Compra finalizada. Obrigado!");
            carrinhoDeCompras.limparCarrinho();
        }
    }
}