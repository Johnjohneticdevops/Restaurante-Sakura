package restaurante.sakura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL =
            "jdbc:mysql://localhost:3306/restaurante_sakura";

    private static final String USUARIO = "root";

    private static final String SENHA = "SUA_SENHA";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }

    public static void main(String[] args) {
        try {
            Connection conexao = conectar();

            System.out.println("CONEXÃO REALIZADA COM SUCESSO!");

            conexao.close();

        } catch (SQLException e) {
            System.out.println("ERRO NA CONEXÃO:");
            e.printStackTrace();
        }
    }
}