USE evaluacion_bloom;

INSERT INTO preguntas (enunciado, opcion1, opcion2, opcion3, opcion4, correcta, nivel_bloom, tipo, tiempo_estimado)
VALUES
("¿Qué es una variable?", "Dato almacenado", "Constante", "Operador", "Instrucción", 0, "RECORDAR", "MULTIPLE_CHOICE", 60),
("Una clase puede tener múltiples constructores.", "Verdadero", "Falso", NULL, NULL, 0, "ENTENDER", "TRUE_FALSE", 30),
("¿Cuál es la salida de: System.out.println(2 + 2)?", "22", "4", "Error", "2 + 2", 1, "APLICAR", "MULTIPLE_CHOICE", 45);
