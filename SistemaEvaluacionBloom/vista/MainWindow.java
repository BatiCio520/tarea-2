package vista;

import controladores.QuizController;
import modelo.BloomLevel;
import modelo.Question;
import modelo.QuestionType;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class MainWindow extends JFrame {
    private QuizController controller;
    private JTextArea preguntaArea;
    private JRadioButton[] opciones;
    private JButton siguienteBtn, anteriorBtn, enviarBtn, resumenBtn;
    private ButtonGroup grupo;

    public MainWindow() {
        super("Sistema de Evaluación - Taxonomía de Bloom");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        controller = new QuizController();

        JPanel top = new JPanel();
        JButton cargar = new JButton("Cargar Preguntas desde BD");
        top.add(cargar);
        add(top, BorderLayout.NORTH);

        JPanel centro = new JPanel(new GridLayout(6, 1));
        preguntaArea = new JTextArea();
        preguntaArea.setEditable(false);
        centro.add(preguntaArea);
        opciones = new JRadioButton[4];
        grupo = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            opciones[i] = new JRadioButton();
            grupo.add(opciones[i]);
            centro.add(opciones[i]);
        }
        add(centro, BorderLayout.CENTER);

        JPanel abajo = new JPanel();
        anteriorBtn = new JButton("← Anterior");
        siguienteBtn = new JButton("Siguiente →");
        enviarBtn = new JButton("Enviar Respuestas");
        resumenBtn = new JButton("Ver Resumen");

        abajo.add(anteriorBtn);
        abajo.add(siguienteBtn);
        abajo.add(enviarBtn);
        abajo.add(resumenBtn);
        add(abajo, BorderLayout.SOUTH);

        cargar.addActionListener(e -> {
            try {
                controller.cargarPreguntasDesdeDB();
                mostrarPregunta();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        anteriorBtn.addActionListener(e -> { guardarRespuesta(); controller.anterior(); mostrarPregunta(); });
        siguienteBtn.addActionListener(e -> { guardarRespuesta(); controller.siguiente(); mostrarPregunta(); });
        enviarBtn.addActionListener(e -> {
            guardarRespuesta();
            mostrarResumenCompleto();
        });

        resumenBtn.addActionListener(e -> mostrarResumenCompleto());

        setVisible(true);
    }

    private void mostrarPregunta() {
        Question q = controller.getActual();
        preguntaArea.setText(q.getPrompt());
        String[] opts = q.getOptions();
        for (int i = 0; i < opciones.length; i++) {
            opciones[i].setText(opts[i]);
            opciones[i].setVisible(opts[i] != null);
        }
        grupo.clearSelection();
        if (q.getUserAnswer() != -1 && q.getUserAnswer() < opciones.length) {
            opciones[q.getUserAnswer()].setSelected(true);
        }
        anteriorBtn.setEnabled(!controller.esPrimera());
        siguienteBtn.setEnabled(!controller.esUltima());
    }

    private void guardarRespuesta() {
        for (int i = 0; i < opciones.length; i++) {
            if (opciones[i].isSelected()) {
                controller.getActual().setUserAnswer(i);
                break;
            }
        }
    }

    private void mostrarResumenCompleto() {
        Map<BloomLevel, Double> porBloom = controller.resumenPorBloom();
        Map<QuestionType, Double> porTipo = controller.resumenPorTipo();
        StringBuilder resumen = new StringBuilder("Resumen de Resultados:\n\nPor Nivel de Bloom:\n");
        porBloom.forEach((nivel, val) -> resumen.append(nivel).append(": ").append(String.format("%.2f%%\n", val)));
        resumen.append("\nPor Tipo de Pregunta:\n");
        porTipo.forEach((tipo, val) -> resumen.append(tipo).append(": ").append(String.format("%.2f%%\n", val)));

        resumen.append("\n\nDetalle de preguntas:\n");
        int i = 1;
        for (Question q : controller.getPreguntas()) {
            String estado = q.isCorrect() ? "✔ Correcta" : "✘ Incorrecta";
            resumen.append(i++).append(") ").append(q.getPrompt()).append(" [").append(estado).append("]\n");
        }

        JOptionPane.showMessageDialog(this, resumen.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
