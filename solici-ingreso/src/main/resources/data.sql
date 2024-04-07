
DROP TABLE IF EXISTS lineas_investigacion;
DROP TABLE IF EXISTS solicitud_ingreso_semillero CASCADE;
DROP TABLE IF EXISTS cambio_estado_solicitud;
DROP TABLE IF EXISTS semillero;
DROP TABLE IF EXISTS ourusers;
DROP TABLE IF EXISTS estados_solicitud CASCADE ;



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

CREATE TABLE IF NOT EXISTS solicitud_ingreso_semillero (
    id SERIAL PRIMARY KEY,
    fecha_actualizacion DATE NOT NULL,
    fecha_creacion DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS cambio_estado_solicitud (
    id SERIAL PRIMARY KEY,
    fecha_cambio DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS lineas_de_investigacion (
    id SERIAL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS estados_solicitud (
    id SERIAL PRIMARY KEY,
    estado VARCHAR(255)
);

ALTER TABLE solicitud_ingreso_semillero
    ADD COLUMN id_ourusers INT NOT NULL,
    ADD CONSTRAINT fk_ourusers_id FOREIGN KEY (id_ourusers) REFERENCES ourusers (id),
    ADD COLUMN id_estados INT NOT NULL,
    ADD CONSTRAINT fk_estados_id FOREIGN KEY (id_estados) REFERENCES estados_solicitud (id),
    ADD COLUMN id_semillero INT NOT NULL,
    ADD CONSTRAINT fk_semillero_id FOREIGN KEY (id_semillero) REFERENCES semillero (id);

ALTER TABLE cambio_estado_solicitud
    ADD COLUMN id_estados INT NOT NULL,
    ADD CONSTRAINT fk_estados_id FOREIGN KEY (id_estados) REFERENCES estados_solicitud (id),
    ADD COLUMN id_solicitud INT NOT NULL,
    ADD CONSTRAINT fk_solicitud_id FOREIGN KEY (id_solicitud) REFERENCES solicitud_ingreso_semillero (id);

INSERT INTO ourusers (email, password, direccion_residencia, codigo_universidad, celular, role, semestre_actual, edad, director_semilleros)
VALUES
    ('admin@ufps.co', '$2a$12$Yq/jTiLjSYdtqU3vBg/MiuVM3kVtA6EWfaOvxYZ6IkXdzeUjCi7nO', 'cucuta calle 2', '1151743', '3133713137', 'ADMIN', 10, 23, false),
    ('jonnyjaimes@ufps.co', '$2a$12$Yq/jTiLjSYdtqU3vBg/MiuVM3kVtA6EWfaOvxYZ6IkXdzeUjCi7nO', 'cucuta calle 2', '1151743', '3133713137', 'USER', 10, 23, false);

INSERT INTO semillero (name, descripcion, logo, id_grupo, id_lider, linea_investigacion)
VALUES
    ('SIADSE', 'REDES', 'FOTOREDES', 1, 1 , 1);

INSERT INTO estados_solicitud (estado)
VALUES
    ('PENDIENTE'),
    ('RECHAZADO'),
    ('APROBADO');
