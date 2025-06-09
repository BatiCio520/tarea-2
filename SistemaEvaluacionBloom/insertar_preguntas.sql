USE evaluacion_bloom;

INSERT INTO preguntas (enunciado, opcion1, opcion2, opcion3, opcion4, correcta, nivel_bloom, tipo, tiempo_estimado)
VALUES
('¿Qué es una variable?', 'Dato almacenado', 'Constante', 'Operador', 'Instrucción', 0, 'RECORDAR', 'MULTIPLE_CHOICE', 60),
('Una clase puede tener múltiples constructores.', 'Verdadero', 'Falso', NULL, NULL, 0, 'ENTENDER', 'TRUE_FALSE', 30),
('¿Cuál es la salida de: System.out.println(2 + 2)?', '22', '4', 'Error', '2 + 2', 1, 'APLICAR', 'MULTIPLE_CHOICE', 45),

-- Introducción a la Programación (Selección múltiple)
('¿Cuál es el propósito principal de un algoritmo?', 'Optimizar gráficos', 'Crear interfaces', 'Resolver un problema paso a paso', 'Administrar bases de datos', 2, 'RECORDAR', 'MULTIPLE_CHOICE', 60),
('¿Qué estructura permite repetir un bloque de código varias veces?', 'Condicional', 'Bucle o ciclo', 'Función', 'Clase', 1, 'APLICAR', 'MULTIPLE_CHOICE', 45),
('¿Cuál de los siguientes lenguajes se considera de alto nivel?', 'Ensamblador', 'C++', 'Python', 'Binario', 2, 'RECORDAR', 'MULTIPLE_CHOICE', 60),
('¿Qué representa una variable en programación?', 'Un bucle infinito', 'Una constante matemática', 'Un espacio de memoria para almacenar datos', 'Una condición lógica', 2, 'RECORDAR', 'MULTIPLE_CHOICE', 60),

-- Introducción a la Programación (Verdadero/Falso)
('Un lenguaje compilado necesita un intérprete para ejecutarse.', 'Verdadero', 'Falso', NULL, NULL, 1, 'ENTENDER', 'TRUE_FALSE', 30),
('Los comentarios en el código sirven para documentarlo sin afectar su ejecución.', 'Verdadero', 'Falso', NULL, NULL, 0, 'RECORDAR', 'TRUE_FALSE', 30),
('Una función no puede devolver ningún valor.', 'Verdadero', 'Falso', NULL, NULL, 0, 'RECORDAR', 'TRUE_FALSE', 30),
('Un condicional permite ejecutar código sólo si se cumple una condición específica.', 'Verdadero', 'Falso', NULL, NULL, 0, 'ENTENDER', 'TRUE_FALSE', 30),

-- Bases de Datos (Selección múltiple)
('¿Qué es una base de datos?', 'Un lenguaje de programación', 'Un sistema operativo', 'Una colección organizada de datos', 'Un modelo de interfaz', 2, 'RECORDAR', 'MULTIPLE_CHOICE', 60),
('¿Qué lenguaje se utiliza comúnmente para interactuar con bases de datos relacionales?', 'HTML', 'SQL', 'CSS', 'Java', 1, 'RECORDAR', 'MULTIPLE_CHOICE', 60),
('¿Cuál de las siguientes opciones es una clave primaria?', 'Un dato duplicado', 'Un identificador único por registro', 'Una relación entre tablas', 'Un campo nulo', 1, 'ENTENDER', 'MULTIPLE_CHOICE', 60),
('¿Qué tipo de relación representa "uno a muchos"?', 'Una tabla con varios campos clave primaria', 'Un registro relacionado con varios registros en otra tabla', 'Dos tablas independientes', 'Ninguna de las anteriores', 1, 'ENTENDER', 'MULTIPLE_CHOICE', 60),

-- Bases de Datos (Verdadero/Falso)
('Una tabla puede tener más de una clave primaria.', 'Verdadero', 'Falso', NULL, NULL, 1, 'ENTENDER', 'TRUE_FALSE', 30),
('El modelo relacional organiza los datos en filas y columnas.', 'Verdadero', 'Falso', NULL, NULL, 0, 'RECORDAR', 'TRUE_FALSE', 30),
('Un campo con valor NULL es lo mismo que un 0.', 'Verdadero', 'Falso', NULL, NULL, 1, 'ENTENDER', 'TRUE_FALSE', 30),
('Las bases de datos NoSQL son ideales para datos estructurados y relaciones complejas.', 'Verdadero', 'Falso', NULL, NULL, 1, 'ENTENDER', 'TRUE_FALSE', 30),

-- Desarrollo Web (Selección múltiple)
('¿Cuál es la función principal del HTML en el desarrollo web?', 'Dar estilo a la página', 'Realizar peticiones al servidor', 'Estructurar el contenido de una página', 'Ejecutar funciones del servidor', 2, 'RECORDAR', 'MULTIPLE_CHOICE', 60),
('¿Qué lenguaje se utiliza para aplicar estilos a una página web?', 'HTML', 'CSS', 'SQL', 'Python', 1, 'RECORDAR', 'MULTIPLE_CHOICE', 60),
('¿Cuál es el rol de JavaScript en el desarrollo web?', 'Dar estilo', 'Interactuar con bases de datos', 'Hacer páginas dinámicas e interactivas', 'Crear tablas', 2, 'ENTENDER', 'MULTIPLE_CHOICE', 60),
('¿Qué significa "responsivo" en diseño web?', 'Página con servidor dedicado', 'Compatible con bases de datos', 'Que se adapta a diferentes tamaños de pantalla', 'Que tiene muchos formularios', 2, 'ENTENDER', 'MULTIPLE_CHOICE', 60),

-- Desarrollo Web (Verdadero/Falso)
('El navegador interpreta el código HTML directamente.', 'Verdadero', 'Falso', NULL, NULL, 0, 'RECORDAR', 'TRUE_FALSE', 30),
('CSS puede cambiar el comportamiento lógico de una página web.', 'Verdadero', 'Falso', NULL, NULL, 1, 'ENTENDER', 'TRUE_FALSE', 30),
('JavaScript solo se puede ejecutar del lado del cliente.', 'Verdadero', 'Falso', NULL, NULL, 1, 'ENTENDER', 'TRUE_FALSE', 30),
('Un archivo HTML puede contener código CSS y JavaScript.', 'Verdadero', 'Falso', NULL, NULL, 0, 'RECORDAR', 'TRUE_FALSE', 30);
