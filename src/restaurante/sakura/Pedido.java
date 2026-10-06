package restaurante.sakura;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int numero;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private String data;
    private String status;

    public Pedido(int numero, Cliente cliente, String data, String status) {
        this.numero = numero;
        this.cliente = cliente;
        this.data = data;
        this.status = status;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }

        return total;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public String getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}