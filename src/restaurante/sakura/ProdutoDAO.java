package restaurante.sakura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void cadastrar(Produto produto) throws SQLException {

        String sql = "INSERT INTO produtos "
                + "(id, nome, categoria, preco, disponivel) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setString(3, produto.getCategoria());
            stmt.setDouble(4, produto.getPreco());
            stmt.setString(5, produto.isDisponivel() ? "Sim" : "Não");

            stmt.executeUpdate();
        }
    }

    public List<Produto> listar() throws SQLException {

        List<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM produtos ORDER BY id";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPreco(rs.getDouble("preco"));

                produto.setDisponivel(
                    rs.getString("disponivel").equalsIgnoreCase("Sim")
                );

                produtos.add(produto);
            }
        }

        return produtos;
    }

    public void alterar(Produto produto) throws SQLException {

        String sql = "UPDATE produtos SET "
                + "nome = ?, categoria = ?, preco = ?, disponivel = ? "
                + "WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCategoria());
            stmt.setDouble(3, produto.getPreco());
            stmt.setString(4, produto.isDisponivel() ? "Sim" : "Não");
            stmt.setInt(5, produto.getId());

            stmt.executeUpdate();
        }
    }

    public void excluir(int id) throws SQLException {

        String sql = "DELETE FROM produtos WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }public Produto buscarPorId(int id) throws SQLException {

    String sql = "SELECT * FROM produtos WHERE id = ?";

    try (Connection conexao = Conexao.conectar();
         PreparedStatement stmt = conexao.prepareStatement(sql)) {

        stmt.setInt(1, id);

        try (ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {

                Produto produto = new Produto();

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setCategoria(rs.getString("categoria"));
                produto.setPreco(rs.getDouble("preco"));

                produto.setDisponivel(
                    rs.getString("disponivel").equalsIgnoreCase("Sim")
                );

                return produto;
            }
        }
    }

    return null;
}
}

