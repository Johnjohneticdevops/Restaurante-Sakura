package restaurante.sakura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {

    public int cadastrarPedido(int clienteId, double total) throws SQLException {

        String sql = "INSERT INTO pedidos (cliente_id, total) VALUES (?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(
                 sql,
                 java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, clienteId);
            stmt.setDouble(2, total);

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                return rs.getInt(1);
            }
        }

        return 0;
    }

    public void cadastrarItem(
            int pedidoId,
            int produtoId,
            int quantidade,
            double preco,
            double subtotal) throws SQLException {

        String sql = "INSERT INTO itens_pedido "
                + "(pedido_id, produto_id, quantidade, preco, subtotal) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, pedidoId);
            stmt.setInt(2, produtoId);
            stmt.setInt(3, quantidade);
            stmt.setDouble(4, preco);
            stmt.setDouble(5, subtotal);

            stmt.executeUpdate();
        }
    }
}