package crud;

import modelo.BloomLevel;
import modelo.Question;
import modelo.QuestionType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {
    private static final String URL = "jdbc:mysql://localhost:3306/evaluacion_bloom";
    private static final String USER = "USER";
    private static final String PASSWORD = "ADMIN";

    public List<Question> loadQuestions() throws SQLException {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM preguntas ORDER BY RAND() LIMIT 10";
            try (PreparedStatement stmt = conn.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String prompt = rs.getString("enunciado");
                    String[] opciones = new String[]{
                            rs.getString("opcion1"),
                            rs.getString("opcion2"),
                            rs.getString("opcion3"),
                            rs.getString("opcion4")
                    };
                    int correcta = rs.getInt("correcta");
                    BloomLevel nivel = BloomLevel.valueOf(rs.getString("nivel_bloom"));
                    QuestionType tipo = QuestionType.valueOf(rs.getString("tipo"));
                    int tiempo = rs.getInt("tiempo_estimado");

                    questions.add(new Question(id, prompt, opciones, correcta, nivel, tipo, tiempo));
                }
            }
        }
        return questions;
    }
}
