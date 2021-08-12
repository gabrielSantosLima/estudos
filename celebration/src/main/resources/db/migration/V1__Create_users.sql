CREATE TABLE users(
    id SERIAL NOT NULL,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO users(name, email) VALUES ('Gabriel Lima', 'teste@gmail.com');
INSERT INTO users(name, email) VALUES ('Fabiano Lima', 'teste@hotmail.com');
INSERT INTO users(name, email) VALUES ('Jorge Lima', 'teste@dominio.com');