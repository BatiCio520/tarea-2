package controladores;

import crud.DatabaseManager;
import modelo.BloomLevel;
import modelo.Question;
import modelo.QuestionType;

import java.util.*;

public class QuizController {
    private List<Question> preguntas;
    private int currentIndex = 0;

    public void cargarPreguntasDesdeDB() throws Exception {
        DatabaseManager db = new DatabaseManager();
        this.preguntas = db.loadQuestions();
    }

    public List<Question> getPreguntas() { return preguntas; }
    public Question getActual() { return preguntas.get(currentIndex); }
    public int getIndice() { return currentIndex; }
    public void siguiente() { if (currentIndex < preguntas.size() - 1) currentIndex++; }
    public void anterior() { if (currentIndex > 0) currentIndex--; }
    public boolean esUltima() { return currentIndex == preguntas.size() - 1; }
    public boolean esPrimera() { return currentIndex == 0; }

    public Map<BloomLevel, Double> resumenPorBloom() {
        Map<BloomLevel, int[]> stats = new EnumMap<>(BloomLevel.class);
        for (Question q : preguntas) {
            stats.putIfAbsent(q.getLevel(), new int[2]);
            stats.get(q.getLevel())[1]++;
            if (q.isCorrect()) stats.get(q.getLevel())[0]++;
        }
        Map<BloomLevel, Double> resultado = new EnumMap<>(BloomLevel.class);
        for (var entry : stats.entrySet()) {
            int[] val = entry.getValue();
            resultado.put(entry.getKey(), 100.0 * val[0] / val[1]);
        }
        return resultado;
    }

    public Map<QuestionType, Double> resumenPorTipo() {
        Map<QuestionType, int[]> stats = new EnumMap<>(QuestionType.class);
        for (Question q : preguntas) {
            stats.putIfAbsent(q.getType(), new int[2]);
            stats.get(q.getType())[1]++;
            if (q.isCorrect()) stats.get(q.getType())[0]++;
        }
        Map<QuestionType, Double> resultado = new EnumMap<>(QuestionType.class);
        for (var entry : stats.entrySet()) {
            int[] val = entry.getValue();
            resultado.put(entry.getKey(), 100.0 * val[0] / val[1]);
        }
        return resultado;
    }
}
