CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    username TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS animales (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL,
    fecha_ingreso TEXT NOT NULL,
    peso_kg REAL NOT NULL
);

INSERT OR IGNORE INTO usuarios(username,password)
VALUES ('zoo','zoo');

INSERT INTO animales(nombre,fecha_ingreso,peso_kg)
VALUES ('Leon','2024-09-10',190.0);