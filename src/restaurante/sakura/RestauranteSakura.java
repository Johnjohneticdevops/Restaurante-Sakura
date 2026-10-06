package restaurante.sakura;

public class RestauranteSakura {

    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante("Restaurante Sakura");

        Cliente cliente = new Cliente(
                1,
                "Joao",
                "51999999999",
                "joao@email.com"
        );

        Produto produto1 = new Produto(
                1,
                "Yakisoba",
                "Prato Principal",
                35.90,
                true
        );

        Produto produto2 = new Produto(
                2,
                "Sushi",
                "Comida Japonesa",
                28.50,
                true
        );

        restaurante.cadastrarCliente(cliente);
        restaurante.cadastrarProduto(produto1);
        restaurante.cadastrarProduto(produto2);

        Pedido pedido = new Pedido(
                1,
                cliente,
                "02/10/2026",
                "Em preparo"
        );

        ItemPedido item1 = new ItemPedido(produto1, 2);
        ItemPedido item2 = new ItemPedido(produto2, 1);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);

        restaurante.criarPedido(pedido);

        System.out.println("===== RESTAURANTE SAKURA =====");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Pedido: " + pedido.getNumero());
        System.out.println("Status: " + pedido.getStatus());
        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
    }
}