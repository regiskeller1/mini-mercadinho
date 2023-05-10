import java.util.Scanner;

public class MiniMercado {
    private static ListaDeProdutos listaDeProdutos;
    private static CarrinhoDeCompras carrinhoDeCompras;
    private static Caixa caixa;
    private static Scanner scanner;

    public static void main(String[] args) {
        listaDeProdutos = new ListaDeProdutos();
        carrinhoDeCompras = new CarrinhoDeCompras();
        caixa = new Caixa();
        scanner = new Scanner(System.in);

        exibirMenu();
    }

    public static void exibirMenu() {
        int opcao = 0;

        do {
            System.out.println("\n----- MINI-MERCADO ANDERSON LANDGRAFS -----");
            System.out.println("1. Ver produtos disponíveis");
            System.out.println("2. Adicionar produto ao carrinho");
            System.out.println("3. Remover produto do carrinho");
            System.out.println("4. Visualizar carrinho de compras");
            System.out.println("5. Finalizar compra");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    listaDeProdutos.exibirProdutosDisponiveis();
                    break;
                case 2:
                    carrinhoDeCompras.adicionarProduto(listaDeProdutos);
                    break;
                case 3:
                    carrinhoDeCompras.removerProduto();
                    break;
                case 4:
                    carrinhoDeCompras.visualizarCarrinho();
                    break;
                case 5:
                    caixa.finalizarCompra(carrinhoDeCompras);
                    break;
                case 6:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);
    }
}