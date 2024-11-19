package exerciciotelas.classesobjetostelas.DAO;

import exerciciotelas.classesobjetostelas.Tentativa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TentativaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_fugao";
    private static final String USER = "admin";
    private static final String PASSWORD = "1234";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void registrarTentativa(int idRefeicao, String result) {
        String sql = "INSERT INTO comidas_feitas (id_refeicao, result, date_time) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRefeicao);
            stmt.setString(2, result);
            stmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tentativa> getAllTentativas() {
        List<Tentativa> tentativas = new ArrayList<>();
        String sql = "SELECT cf.id, r.nome AS refeicao, cf.result, cf.date_time " +
                "FROM comidas_feitas cf " +
                "JOIN refeicao r ON cf.id_refeicao = r.id_refeicao";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tentativa tentativa = new Tentativa();
                tentativa.setId(rs.getInt("id"));
                tentativa.setRefeicao(rs.getString("refeicao"));
                tentativa.setResult(rs.getString("result"));
                tentativa.setDateTime(rs.getString("date_time"));
                tentativas.add(tentativa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tentativas;
    }
}