CREATE DATABASE evaluacion_bloom;
USE evaluacion_bloom;

CREATE TABLE preguntas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    enunciado TEXT NOT NULL,
    opcion1 VARCHAR(255),
    opcion2 VARCHAR(255),
    opcion3 VARCHAR(255),
    opcion4 VARCHAR(255),
    correcta INT NOT NULL,
    nivel_bloom ENUM('RECORDAR','ENTENDER','APLICAR','ANALIZAR','EVALUAR','CREAR') NOT NULL,
    tipo ENUM('MULTIPLE_CHOICE','TRUE_FALSE') NOT NULL,
    tiempo_estimado INT NOT NULL
);
