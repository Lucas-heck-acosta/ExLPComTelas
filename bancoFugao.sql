DROP DATABASE IF EXISTS sistema_fugao;

CREATE DATABASE IF NOT EXISTS sistema_fugao;
USE sistema_fugao;


DROP USER IF EXISTS 'admin'@'localhost';
CREATE USER 'admin'@'localhost' IDENTIFIED BY '1234';
GRANT INSERT, SELECT, UPDATE, DELETE ON sistema_fugao.* TO 'admin'@'localhost';

CREATE TABLE IF NOT EXISTS produto (
    id_produto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS refeicao (
    id_refeicao INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    temperatura_de_preparo INT NOT NULL
);

CREATE TABLE IF NOT EXISTS refeicao_produto (
    id_refeicao INT,
    id_produto INT,
    PRIMARY KEY (id_refeicao, id_produto),
    FOREIGN KEY (id_refeicao) REFERENCES refeicao(id_refeicao),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);

CREATE TABLE comidas_feitas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_refeicao INT,
    result VARCHAR(255),
    date_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_refeicao) REFERENCES refeicao(id_refeicao)
);

SELECT * FROM produto;
SELECT * FROM refeicao;
SELECT * FROM refeicao_produto;
SELECT * FROM comidas_feitas;