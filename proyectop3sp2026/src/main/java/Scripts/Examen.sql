CREATE DATABASE parcial_p3;
USE parcial_p3;

CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50)
);

INSERT INTO usuario (username, password) VALUES ('admin', '1234');

CREATE TABLE examen (
    id_examen INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    descripcion VARCHAR(150),
    estado TINYINT(1)
);

INSERT INTO examen (nombre, descripcion, estado) VALUES
('Producto A','Desc A',1),
('Producto B','Desc B',1),
('Producto C','Desc C',1),
('Producto D','Desc D',1);
