DROP TABLE IF EXISTS alquiler;
DROP TABLE IF EXISTS vehiculo;
DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
    dni TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    telefono TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    activo INTEGER NOT NULL CHECK (activo IN (0,1))
);

CREATE TABLE vehiculo (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    marca TEXT NOT NULL,
    modelo TEXT NOT NULL,
    tipo TEXT NOT NULL CHECK (tipo IN ('ECONOMICO','SUV','PREMIUM')),
    disponible INTEGER NOT NULL CHECK (disponible IN (0,1))
);

CREATE TABLE alquiler (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    dni_cliente TEXT NOT NULL,
    id_vehiculo INTEGER NOT NULL,
    fecha_inicio TEXT NOT NULL,
    fecha_fin TEXT NOT NULL,
    estado TEXT NOT NULL CHECK (estado IN ('ACTIVO','CANCELADO','FINALIZADO')),
    FOREIGN KEY (dni_cliente) REFERENCES cliente(dni),
    FOREIGN KEY (id_vehiculo) REFERENCES vehiculo(id)
);

INSERT INTO cliente VALUES ('11111111H','Ana Martin','600111222','ana@email.com',1);
INSERT INTO cliente VALUES ('22222222J','Luis Perez','611222333','luis@email.com',1);
INSERT INTO cliente VALUES ('33333333P','Marta Gomez','622333444','marta@email.com',0);
INSERT INTO cliente VALUES ('44444444A','Carlos Diaz','633444555','carlos@email.com',1);
INSERT INTO cliente VALUES ('55555555K','Laura Ruiz','644555666','laura@email.com',1);

INSERT INTO vehiculo(marca,modelo,tipo,disponible) VALUES ('Toyota','Yaris','ECONOMICO',1);
INSERT INTO vehiculo(marca,modelo,tipo,disponible) VALUES ('Nissan','Qashqai','SUV',1);
INSERT INTO vehiculo(marca,modelo,tipo,disponible) VALUES ('BMW','Serie 3','PREMIUM',1);
INSERT INTO vehiculo(marca,modelo,tipo,disponible) VALUES ('Fiat','Panda','ECONOMICO',0);

INSERT INTO alquiler(dni_cliente,id_vehiculo,fecha_inicio,fecha_fin,estado) VALUES ('11111111H',1,'2030-05-10','2030-05-12','ACTIVO');
INSERT INTO alquiler(dni_cliente,id_vehiculo,fecha_inicio,fecha_fin,estado) VALUES ('22222222J',2,'2030-05-13','2030-05-15','ACTIVO');
INSERT INTO alquiler(dni_cliente,id_vehiculo,fecha_inicio,fecha_fin,estado) VALUES ('11111111H',3,'2030-05-16','2030-05-18','CANCELADO');
