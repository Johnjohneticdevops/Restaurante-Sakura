package restaurante.sakura;

public class Menu {

    private Restaurante restaurante;

    public Menu(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void iniciar() {
        System.out.println("Sistema Restaurante Sakura iniciado.");
    }

    public void exibirMenu() {
        System.out.println("===== RESTAURANTE SAKURA =====");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Cadastrar produto");
        System.out.println("3 - Registrar pedido");
        System.out.println("4 - Consultar clientes");
        System.out.println("5 - Consultar produtos");
        System.out.println("6 - Consultar pedidos");
    }
}