CREATE DATABASE IF NOT EXISTS bd_estudiojuridico;

USE bd_estudioJuridico;

-- crear tabla cliente
CREATE TABLE tb_clientes (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    rut VARCHAR(12) UNIQUE NOT NULL,
    contacto VARCHAR(50),
    direccion VARCHAR(200),
    notas TEXT,
    idAbogado INT,
    CONSTRAINT fk_abogado FOREIGN KEY (idAbogado) REFERENCES tb_abogados(id_abogado)
);

-- crear tabla abogados
CREATE TABLE tb_abogados(
id_abogado INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
especialidad VARCHAR(100),
contacto VARCHAR(50)
);



-- crear tabla causas
CREATE TABLE tb_causas(
id_causa INT AUTO_INCREMENT PRIMARY KEY,
tipo VARCHAR(50) NOT NULL,
rol VARCHAR(50) NOT NULL,
tribunal VARCHAR(100) NOT NULL,
fecha DATE NOT NULL,
estado VARCHAR(50) DEFAULT 'abierta',
detalle TEXT,
id_abogado INT,
FOREIGN KEY (id_abogado) REFERENCES tb_abogados(id_abogado) ON DELETE CASCADE
);


CREATE TABLE tb_audiencias (
    id_audiencia INT AUTO_INCREMENT PRIMARY KEY,
    id_abogado INT,
    tipo VARCHAR(100),
    rol VARCHAR(50), 
    tribunal VARCHAR(100),
    fecha DATE,
    hora VARCHAR(10), 
    lugar VARCHAR(255),
    estado VARCHAR(100),
    observaciones TEXT,
    FOREIGN KEY (id_abogado) REFERENCES tb_abogados(id_abogado)
);


-- crear tabla documentos
CREATE TABLE tb_documentos(
id_documento INT AUTO_INCREMENT PRIMARY KEY,
id_causa INT NOT NULL,
nombre VARCHAR(200) NOT NULL,
tipo VARCHAR(50),
ruta_archivo VARCHAR(300),
FOREIGN KEY (id_causa) REFERENCES tb_causas(id_causa) ON DELETE CASCADE
);

-- crear tabla usuarios
CREATE TABLE tb_usuario(
id_usuario INT AUTO_INCREMENT PRIMARY KEY,
usuario VARCHAR(100) NOT NULL,
contrasena VARCHAR(64) NOT NULL,
estado VARCHAR(10) NOT NULL
);

INSERT INTO tb_usuario (usuario, contrasena, estado)
VALUES ('admin', SHA2('admin', 256), 'activo');


