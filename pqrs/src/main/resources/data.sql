
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


CREATE TABLE IF NOT EXISTS estados_pqrs (
    id SERIAL PRIMARY KEY,
    estado VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tipos_pqrs (
   id SERIAL PRIMARY KEY,
   tipo VARCHAR(255)
);

INSERT INTO ourusers (email, password, direccion_residencia, codigo_universidad, celular, role, semestre_actual, edad, director_semilleros)
VALUES
    ('admin@ufps.co', '$2a$12$Yq/jTiLjSYdtqU3vBg/MiuVM3kVtA6EWfaOvxYZ6IkXdzeUjCi7nO', 'cucuta calle 2', '1151743', '3133713137', 'Admin', 10, 23, false),
    ('jonnyjaimes@ufps.co', '$2a$12$Yq/jTiLjSYdtqU3vBg/MiuVM3kVtA6EWfaOvxYZ6IkXdzeUjCi7nO', 'cucuta calle 2', '1151743', '3133713137', 'USER', 10, 23, false);


INSERT INTO estados_pqrs (estado)
VALUES
    ('PENDIENTE'),
    ('REVISIÓN'),
    ('RESUELTO');

INSERT INTO tipos_pqrs (tipo)
VALUES
    ('PETICION'),
    ('QUEJA'),
    ('RECLAMO'),
    ('SOLICITUD');