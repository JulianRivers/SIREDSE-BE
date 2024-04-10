DROP TABLE IF EXISTS cambio_estado_radicado;
DROP TABLE IF EXISTS pqrs;
DROP TABLE IF EXISTS ourusers;
DROP TABLE IF EXISTS semillero;
DROP TABLE IF EXISTS lineas_de_investigacion;
DROP TABLE IF EXISTS estados_pqrs;
DROP TABLE IF EXISTS tipos_pqrs;


CREATE TABLE IF NOT EXISTS ourusers (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    direccion_residencia VARCHAR(255) NOT NULL,
    codigo_universidad VARCHAR(85) NOT NULL,
    celular VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    semestre_actual INT NOT NULL,
    edad INT NOT NULL,
    director_semilleros BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS semillero (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    logo VARCHAR(255) NOT NULL,
    id_grupo INT NOT NULL,
    id_lider INT NOT NULL,
    linea_investigacion INT NOT NULL
);

CREATE TABLE IF NOT EXISTS lineas_de_investigacion (
    id SERIAL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS estados_pqrs (
    id SERIAL PRIMARY KEY,
    estado VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tipos_pqrs (
   id SERIAL PRIMARY KEY,
   tipo VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cambio_estado_radicado(
   id SERIAL PRIMARY KEY,
   fecha_cambio DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS pqrs (
   id SERIAL PRIMARY KEY,
   anonimo BOOLEAN NOT NULL,
   fecha_radicado DATE,
   apellido VARCHAR(255),
   nombre VARCHAR(255),
   cedula VARCHAR(255),
   correo VARCHAR(255) NOT NULL,
   codigo_radicado VARCHAR(255) NOT NULL,
   titulo VARCHAR(255) NOT NULL,
   descripcion VARCHAR(255) NOT NULL
);

ALTER TABLE pqrs
    ADD COLUMN id_estados INT NOT NULL,
    ADD CONSTRAINT fk_estados_id FOREIGN KEY (id_estados) REFERENCES estados_pqrs (id),
    ADD COLUMN id_tipos_pqrs INT NOT NULL,
    ADD CONSTRAINT fk_tipospqrs_id FOREIGN KEY (id_tipos_pqrs) REFERENCES tipos_pqrs (id);

ALTER TABLE cambio_estado_radicado
    ADD COLUMN id_estados INT NOT NULL,
    ADD CONSTRAINT fk_estados_id FOREIGN KEY (id_estados) REFERENCES estados_pqrs (id),
    ADD COLUMN id_pqrs INT NOT NULL,
    ADD CONSTRAINT fk_pqrs_id FOREIGN KEY (id_pqrs) REFERENCES pqrs (id);

INSERT INTO ourusers (email, password, direccion_residencia, codigo_universidad, celular, role, semestre_actual, edad, director_semilleros)
VALUES
    ('admin@ufps.co', '$2a$12$Yq/jTiLjSYdtqU3vBg/MiuVM3kVtA6EWfaOvxYZ6IkXdzeUjCi7nO', 'cucuta calle 2', '1151743', '3133713137', 'ADMIN', 10, 23, false),
    ('jonnyjaimes@ufps.co', '$2a$12$Yq/jTiLjSYdtqU3vBg/MiuVM3kVtA6EWfaOvxYZ6IkXdzeUjCi7nO', 'cucuta calle 2', '1151743', '3133713137', 'USER', 10, 23, false);

INSERT INTO semillero (name, descripcion, logo, id_grupo, id_lider, linea_investigacion)
VALUES
    ('SIADSE', 'REDES', 'FOTOREDES', 1, 1 , 1);

INSERT INTO estados_pqrs (estado)
VALUES
    ('PENDIENTE'),
    ('REVISION'),
    ('RESUELTO');

INSERT INTO tipos_pqrs (tipo)
VALUES
    ('PETICION'),
    ('QUEJA'),
    ('RECLAMO'),
    ('SOLICITUD');