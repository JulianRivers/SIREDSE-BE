
CREATE TABLE IF NOT EXISTS estados_pqrs (
    id SERIAL PRIMARY KEY,
    estado VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tipos_pqrs (
   id SERIAL PRIMARY KEY,
   tipo VARCHAR(255)
);


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