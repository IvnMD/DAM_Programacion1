PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS categoria_producto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nombre TEXT NOT NULL UNIQUE,
    descripcion TEXT
);

CREATE TABLE IF NOT EXISTS proveedor (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    cif TEXT NOT NULL UNIQUE,
    nombre TEXT NOT NULL,
    telefono TEXT,
    email TEXT,
    ciudad TEXT,
    activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1))
);

CREATE TABLE IF NOT EXISTS cliente (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    dni TEXT UNIQUE,
    nombre TEXT NOT NULL,
    telefono TEXT,
    email TEXT,
    ciudad TEXT,
    activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1))
);

CREATE TABLE IF NOT EXISTS producto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    codigo TEXT NOT NULL UNIQUE,
    nombre TEXT NOT NULL,
    unidad_medida TEXT NOT NULL CHECK (unidad_medida IN ('kg','unidad','caja','bandeja')),
    precio_compra REAL NOT NULL CHECK (precio_compra >= 0),
    precio_venta REAL NOT NULL CHECK (precio_venta > 0),
    stock_actual REAL NOT NULL DEFAULT 0 CHECK (stock_actual >= 0),
    stock_minimo REAL NOT NULL DEFAULT 0 CHECK (stock_minimo >= 0),
    perecedero INTEGER NOT NULL DEFAULT 1 CHECK (perecedero IN (0,1)),
    activo INTEGER NOT NULL DEFAULT 1 CHECK (activo IN (0,1)),
    id_categoria INTEGER NOT NULL,
    id_proveedor_principal INTEGER,
    FOREIGN KEY (id_categoria) REFERENCES categoria_producto(id),
    FOREIGN KEY (id_proveedor_principal) REFERENCES proveedor(id)
);

CREATE TABLE IF NOT EXISTS compra (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    numero_factura TEXT NOT NULL UNIQUE,
    id_proveedor INTEGER NOT NULL,
    subtotal REAL NOT NULL DEFAULT 0 CHECK (subtotal >= 0),
    iva REAL NOT NULL DEFAULT 0 CHECK (iva >= 0),
    total REAL NOT NULL DEFAULT 0 CHECK (total >= 0),
    estado TEXT NOT NULL DEFAULT 'registrada' CHECK (estado IN ('registrada','cancelada')),
    observaciones TEXT,
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id)
);

CREATE TABLE IF NOT EXISTS compra_detalle (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_compra INTEGER NOT NULL,
    id_producto INTEGER NOT NULL,
    cantidad REAL NOT NULL CHECK (cantidad > 0),
    precio_unitario REAL NOT NULL CHECK (precio_unitario >= 0),
    descuento REAL NOT NULL DEFAULT 0 CHECK (descuento >= 0),
    total_linea REAL NOT NULL CHECK (total_linea >= 0),
    FOREIGN KEY (id_compra) REFERENCES compra(id) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE IF NOT EXISTS venta (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ticket TEXT NOT NULL UNIQUE,
    id_cliente INTEGER,
    metodo_pago TEXT NOT NULL CHECK (metodo_pago IN ('efectivo','tarjeta','bizum','transferencia')),
    subtotal REAL NOT NULL DEFAULT 0 CHECK (subtotal >= 0),
    descuento_total REAL NOT NULL DEFAULT 0 CHECK (descuento_total >= 0),
    iva REAL NOT NULL DEFAULT 0 CHECK (iva >= 0),
    total REAL NOT NULL DEFAULT 0 CHECK (total >= 0),
    estado TEXT NOT NULL DEFAULT 'cerrada' CHECK (estado IN ('cerrada','anulada')),
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE IF NOT EXISTS venta_detalle (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_venta INTEGER NOT NULL,
    id_producto INTEGER NOT NULL,
    cantidad REAL NOT NULL CHECK (cantidad > 0),
    precio_unitario REAL NOT NULL CHECK (precio_unitario >= 0),
    descuento REAL NOT NULL DEFAULT 0 CHECK (descuento >= 0),
    total_linea REAL NOT NULL CHECK (total_linea >= 0),
    FOREIGN KEY (id_venta) REFERENCES venta(id) ON DELETE CASCADE,
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE IF NOT EXISTS movimiento_stock (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    fecha TEXT NOT NULL DEFAULT CURRENT_TIMESTAMP,
    id_producto INTEGER NOT NULL,
    tipo TEXT NOT NULL CHECK (tipo IN ('entrada_compra','salida_venta','ajuste')),
    cantidad REAL NOT NULL,
    referencia TEXT,
    observaciones TEXT,
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE INDEX IF NOT EXISTS idx_producto_categoria ON producto(id_categoria);
CREATE INDEX IF NOT EXISTS idx_producto_proveedor ON producto(id_proveedor_principal);
CREATE INDEX IF NOT EXISTS idx_compra_proveedor ON compra(id_proveedor);
CREATE INDEX IF NOT EXISTS idx_venta_cliente ON venta(id_cliente);
CREATE INDEX IF NOT EXISTS idx_movimiento_producto ON movimiento_stock(id_producto);

CREATE TRIGGER IF NOT EXISTS trg_compra_detalle_ai
AFTER INSERT ON compra_detalle
BEGIN
    UPDATE producto
    SET stock_actual = stock_actual + NEW.cantidad
    WHERE id = NEW.id_producto;

    INSERT INTO movimiento_stock(id_producto, tipo, cantidad, referencia, observaciones)
    VALUES (NEW.id_producto, 'entrada_compra', NEW.cantidad, 'COMPRA-' || NEW.id_compra, 'Entrada por compra');
END;

CREATE TRIGGER IF NOT EXISTS trg_venta_detalle_ai
AFTER INSERT ON venta_detalle
BEGIN
    UPDATE producto
    SET stock_actual = stock_actual - NEW.cantidad
    WHERE id = NEW.id_producto;

    INSERT INTO movimiento_stock(id_producto, tipo, cantidad, referencia, observaciones)
    VALUES (NEW.id_producto, 'salida_venta', -NEW.cantidad, 'VENTA-' || NEW.id_venta, 'Salida por venta');
END;

CREATE TRIGGER IF NOT EXISTS trg_venta_no_stock
BEFORE INSERT ON venta_detalle
FOR EACH ROW
WHEN (SELECT stock_actual FROM producto WHERE id = NEW.id_producto) < NEW.cantidad
BEGIN
    SELECT RAISE(ABORT, 'Stock insuficiente para realizar la venta');
END;

CREATE VIEW IF NOT EXISTS vw_productos_bajo_stock AS
SELECT p.id, p.codigo, p.nombre, p.unidad_medida, p.stock_actual, p.stock_minimo
FROM producto p
WHERE p.stock_actual <= p.stock_minimo
ORDER BY p.stock_actual ASC, p.nombre ASC;

CREATE VIEW IF NOT EXISTS vw_resumen_ventas AS
SELECT v.id, v.ticket, v.fecha, COALESCE(c.nombre, 'Cliente ocasional') AS cliente,
       v.metodo_pago, v.total, v.estado
FROM venta v
LEFT JOIN cliente c ON c.id = v.id_cliente
ORDER BY v.fecha DESC;

CREATE VIEW IF NOT EXISTS vw_productos_catalogo AS
SELECT p.id, p.codigo, p.nombre, cp.nombre AS categoria, p.unidad_medida,
       p.precio_compra, p.precio_venta, p.stock_actual, p.stock_minimo,
       p.perecedero, p.activo
FROM producto p
JOIN categoria_producto cp ON cp.id = p.id_categoria
ORDER BY cp.nombre, p.nombre;

-- Datos de ejemplo

INSERT INTO categoria_producto(nombre, descripcion) VALUES
('Fruta', 'Frutas frescas de temporada'),
('Verdura', 'Verduras y hortalizas frescas'),
('Frutos secos', 'Producto seco y envasado'),
('Complementos', 'Huevos, miel y otros productos');

INSERT INTO proveedor(cif, nombre, telefono, email, ciudad, activo) VALUES
('B12345678', 'Distribuciones Atlántico', '922111222', 'compras@atlantico.es', 'La Laguna', 1),
('B23456789', 'Huerta del Norte', '922333444', 'info@huertanorte.es', 'Tacoronte', 1),
('B34567890', 'Campo Fresco SL', '928555666', 'ventas@campofresco.es', 'Telde', 1);

INSERT INTO cliente(dni, nombre, telefono, email, ciudad, activo) VALUES
('11111111A', 'Ana Pérez', '600111111', 'ana@email.com', 'La Laguna', 1),
('22222222B', 'Luis Martín', '600222222', 'luis@email.com', 'Santa Cruz', 1),
('33333333C', 'María Díaz', '600333333', 'maria@email.com', 'La Orotava', 1);

INSERT INTO producto(codigo, nombre, unidad_medida, precio_compra, precio_venta, stock_actual, stock_minimo, perecedero, activo, id_categoria, id_proveedor_principal) VALUES
('FRU-MAN-001', 'Manzana Golden', 'kg', 1.20, 2.35, 0, 15, 1, 1, 1, 1),
('FRU-PLA-001', 'Plátano de Canarias', 'kg', 1.10, 2.10, 0, 20, 1, 1, 1, 1),
('FRU-NAR-001', 'Naranja de zumo', 'kg', 0.95, 1.85, 0, 25, 1, 1, 1, 2),
('VER-TOM-001', 'Tomate ensalada', 'kg', 1.35, 2.60, 0, 12, 1, 1, 2, 2),
('VER-PAP-001', 'Papa bonita', 'kg', 0.80, 1.65, 0, 30, 1, 1, 2, 2),
('SEC-ALM-001', 'Almendra cruda', 'kg', 6.00, 9.95, 0, 5, 0, 1, 3, 3),
('COM-MIE-001', 'Miel de palma', 'unidad', 4.50, 7.90, 0, 4, 0, 1, 4, 3);

INSERT INTO compra(fecha, numero_factura, id_proveedor, subtotal, iva, total, estado, observaciones) VALUES
('2026-04-18 08:30:00', 'FAC-2026-001', 1, 54.50, 3.82, 58.32, 'registrada', 'Compra semanal fruta'),
('2026-04-19 09:15:00', 'FAC-2026-002', 2, 73.00, 5.11, 78.11, 'registrada', 'Compra verdura'),
('2026-04-20 10:05:00', 'FAC-2026-003', 3, 57.00, 3.99, 60.99, 'registrada', 'Complementos y secos');

INSERT INTO compra_detalle(id_compra, id_producto, cantidad, precio_unitario, descuento, total_linea) VALUES
(1, 1, 20, 1.20, 0, 24.00),
(1, 2, 15, 1.10, 0, 16.50),
(1, 3, 15, 0.95, 0.25, 14.00),
(2, 4, 18, 1.35, 0, 24.30),
(2, 5, 60, 0.80, 0, 48.00),
(3, 6, 5, 6.00, 0, 30.00),
(3, 7, 6, 4.50, 0, 27.00);

INSERT INTO venta(fecha, ticket, id_cliente, metodo_pago, subtotal, descuento_total, iva, total, estado) VALUES
('2026-04-21 11:10:00', 'TCK-2026-001', 1, 'tarjeta', 13.55, 0.50, 0.00, 13.05, 'cerrada'),
('2026-04-21 13:20:00', 'TCK-2026-002', NULL, 'efectivo', 9.95, 0.00, 0.00, 9.95, 'cerrada'),
('2026-04-22 18:00:00', 'TCK-2026-003', 2, 'bizum', 14.20, 0.20, 0.00, 14.00, 'cerrada');

INSERT INTO venta_detalle(id_venta, id_producto, cantidad, precio_unitario, descuento, total_linea) VALUES
(1, 1, 2, 2.35, 0.20, 4.50),
(1, 4, 1.5, 2.60, 0.30, 3.60),
(1, 7, 1, 7.90, 0.00, 7.90),
(2, 6, 1, 9.95, 0.00, 9.95),
(3, 2, 3, 2.10, 0.20, 6.10),
(3, 3, 2, 1.85, 0.00, 3.70),
(3, 5, 2.5, 1.65, 0.00, 4.20);
