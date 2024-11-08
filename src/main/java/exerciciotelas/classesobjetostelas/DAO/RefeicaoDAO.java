package exerciciotelas.classesobjetostelas.DAO;

import exerciciotelas.classesobjetostelas.Refeicao;
import exerciciotelas.classesobjetostelas.Produto;

import java.sql.*;
import java.util.List;

public class RefeicaoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_fugao";
    private static final String USER = "admin";
    private static final String PASSWORD = "1234";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addRefeicao(Refeicao refeicao) {
        String sqlRefeicao = "INSERT INTO refeicao (nome, temperatura_de_preparo) VALUES (?, ?)";
        String sqlRefeicaoProduto = "INSERT INTO refeicao_produto (id_refeicao, id_produto) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmtRefeicao = conn.prepareStatement(sqlRefeicao, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtRefeicaoProduto = conn.prepareStatement(sqlRefeicaoProduto)) {

            // Insert into refeicao table
            stmtRefeicao.setString(1, refeicao.getNome());
            stmtRefeicao.setInt(2, refeicao.getTemperaturaDePreparo());
            stmtRefeicao.executeUpdate();

            // Get generated id_refeicao
            try (ResultSet generatedKeys = stmtRefeicao.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idRefeicao = generatedKeys.getInt(1);
                    refeicao.setId(idRefeicao);

                    // Insert into refeicao_produto table
                    for (Produto produto : refeicao.getProdutos()) {
                        if (produto.getId() > 0) { // Ensure the product has a valid ID
                            stmtRefeicaoProduto.setInt(1, idRefeicao);
                            stmtRefeicaoProduto.setInt(2, produto.getId());
                            stmtRefeicaoProduto.addBatch();
                        } else {
                            System.err.println("Produto " + produto.getNome() + " does not have a valid ID.");
                        }
                    }
                    stmtRefeicaoProduto.executeBatch();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods (getAllRefeicoes, updateRefeicao, deleteRefeicao) can be added here
}