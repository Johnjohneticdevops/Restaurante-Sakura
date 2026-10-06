package restaurante.sakura;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {

    private String nome;
    private List<Produto> produtos;
    private List<Cliente> clientes;
    private List<Pedido> pedidos;

    public Restaurante(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void criarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public List<Pedido> listarPedidos() {
        return pedidos;
    }

    public String getNome() {
        return nome;
    }
}