# SQLite Frutería Ejercicio

Este ejercicio guiado contiene una base de datos SQLite3 de ejemplo basada en el una `Frutería`.


## 1. Abrir la base de datos

Desde terminal, entra en la carpeta del proyecto y abre la base de datos:

```bash
sqlite3 fruteria.db
```

## 2. Comandos útiles dentro de sqlite3

Ver ayuda general:

```sql
.help
```

Mostrar todas las tablas:

```sql
.tables
```

Mostrar el esquema completo:

```sql
.schema
```

Mostrar el esquema de una tabla concreta:

```sql
.schema producto
.schema venta
.schema compra
```

Mostrar las columnas de una tabla:

```sql
PRAGMA table_info(producto);
PRAGMA table_info(cliente);
PRAGMA table_info(proveedor);
PRAGMA table_info(venta);
PRAGMA table_info(venta_detalle);
```

Activar formato más legible:

```sql
.headers on
.mode column
```

Cambiar a formato tabla:

```sql
.mode table
```

Salir de sqlite3:

```sql
.quit
```

## 3. Tablas incluidas

- `categoria_producto`
- `proveedor`
- `cliente`
- `producto`
- `compra`
- `compra_detalle`
- `venta`
- `venta_detalle`
- `movimiento_stock`

## 4. Relación rápida del modelo

- Un `producto` pertenece a una `categoria_producto`.
- Un `producto` tiene un `proveedor` principal.
- Una `compra` pertenece a un `proveedor`.
- `compra_detalle` relaciona compras con productos.
- Una `venta` puede pertenecer a un `cliente`.
- `venta_detalle` relaciona ventas con productos.
- `movimiento_stock` registra entradas y salidas de stock.

## 5. Realiza las siguientes consultas

Este README sigue el mismo patrón del ejercicio de ejemplo que has compartido: **enunciado + solución**. Además, aquí se añade también la **salida real** de cada consulta.

> El bloque 1 contiene 30 consultas sobre una sola tabla.

> El bloque 2 contiene 30 consultas combinando tablas con `JOIN`, filtros y agregaciones.


## 6. Bloque 1: consultas sobre una sola tabla

### Ejercicio 1

**Consulta:** Obtener la primera categoría de producto.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM categoria_producto ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id nombre                 descripcion
  1  Fruta Frutas frescas de temporada
```

  </br>

 </details>

### Ejercicio 2

**Consulta:** Obtener todas las categorías de producto.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM categoria_producto ORDER BY id;
```

**Salida:**

```text
 id       nombre                    descripcion
  1        Fruta    Frutas frescas de temporada
  2      Verdura  Verduras y hortalizas frescas
  3 Frutos secos       Producto seco y envasado
  4 Complementos Huevos, miel y otros productos
```

  </br>

 </details>

### Ejercicio 3

**Consulta:** Obtener el primer proveedor.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM proveedor ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id       cif                   nombre  telefono                email    ciudad  activo
  1 B12345678 Distribuciones Atlántico 922111222 compras@atlantico.es La Laguna       1
```

  </br>

 </details>

### Ejercicio 4

**Consulta:** Obtener todos los proveedores.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM proveedor ORDER BY id;
```

**Salida:**

```text
 id       cif                   nombre  telefono                 email    ciudad  activo
  1 B12345678 Distribuciones Atlántico 922111222  compras@atlantico.es La Laguna       1
  2 B23456789         Huerta del Norte 922333444   info@huertanorte.es Tacoronte       1
  3 B34567890          Campo Fresco SL 928555666 ventas@campofresco.es     Telde       1
```

  </br>

 </details>

### Ejercicio 5

**Consulta:** Obtener el primer cliente.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM cliente ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id       dni    nombre  telefono         email    ciudad  activo
  1 11111111A Ana Pérez 600111111 ana@email.com La Laguna       1
```

  </br>

 </details>

### Ejercicio 6

**Consulta:** Obtener todos los clientes.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM cliente ORDER BY id;
```

**Salida:**

```text
 id       dni      nombre  telefono           email     ciudad  activo
  1 11111111A   Ana Pérez 600111111   ana@email.com  La Laguna       1
  2 22222222B Luis Martín 600222222  luis@email.com Santa Cruz       1
  3 33333333C  María Díaz 600333333 maria@email.com La Orotava       1
```

  </br>

 </details>

### Ejercicio 7

**Consulta:** Obtener el primer producto.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM producto ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id      codigo         nombre unidad_medida  precio_compra  precio_venta  stock_actual  stock_minimo  perecedero  activo  id_categoria  id_proveedor_principal
  1 FRU-MAN-001 Manzana Golden            kg            1.2          2.35          18.0          15.0           1       1             1                       1
```

  </br>

 </details>

### Ejercicio 8

**Consulta:** Obtener todos los productos.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM producto ORDER BY id;
```

**Salida:**

```text
 id      codigo              nombre unidad_medida  precio_compra  precio_venta  stock_actual  stock_minimo  perecedero  activo  id_categoria  id_proveedor_principal
  1 FRU-MAN-001      Manzana Golden            kg           1.20          2.35          18.0          15.0           1       1             1                       1
  2 FRU-PLA-001 Plátano de Canarias            kg           1.10          2.10          12.0          20.0           1       1             1                       1
  3 FRU-NAR-001     Naranja de zumo            kg           0.95          1.85          13.0          25.0           1       1             1                       2
  4 VER-TOM-001     Tomate ensalada            kg           1.35          2.60          16.5          12.0           1       1             2                       2
  5 VER-PAP-001         Papa bonita            kg           0.80          1.65          57.5          30.0           1       1             2                       2
  6 SEC-ALM-001      Almendra cruda            kg           6.00          9.95           4.0           5.0           0       1             3                       3
  7 COM-MIE-001       Miel de palma        unidad           4.50          7.90           5.0           4.0           0       1             4                       3
```

  </br>

 </details>

### Ejercicio 9

**Consulta:** Obtener la primera compra.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM compra ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id               fecha numero_factura  id_proveedor  subtotal  iva  total     estado        observaciones
  1 2026-04-18 08:30:00   FAC-2026-001             1      54.5 3.82  58.32 registrada Compra semanal fruta
```

  </br>

 </details>

### Ejercicio 10

**Consulta:** Obtener todas las compras.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM compra ORDER BY id;
```

**Salida:**

```text
 id               fecha numero_factura  id_proveedor  subtotal  iva  total     estado        observaciones
  1 2026-04-18 08:30:00   FAC-2026-001             1      54.5 3.82  58.32 registrada Compra semanal fruta
  2 2026-04-19 09:15:00   FAC-2026-002             2      73.0 5.11  78.11 registrada       Compra verdura
  3 2026-04-20 10:05:00   FAC-2026-003             3      57.0 3.99  60.99 registrada Complementos y secos
```

  </br>

 </details>

### Ejercicio 11

**Consulta:** Obtener el primer detalle de compra.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM compra_detalle ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id  id_compra  id_producto  cantidad  precio_unitario  descuento  total_linea
  1          1            1      20.0              1.2        0.0         24.0
```

  </br>

 </details>

### Ejercicio 12

**Consulta:** Obtener todos los detalles de compra.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM compra_detalle ORDER BY id;
```

**Salida:**

```text
 id  id_compra  id_producto  cantidad  precio_unitario  descuento  total_linea
  1          1            1      20.0             1.20       0.00         24.0
  2          1            2      15.0             1.10       0.00         16.5
  3          1            3      15.0             0.95       0.25         14.0
  4          2            4      18.0             1.35       0.00         24.3
  5          2            5      60.0             0.80       0.00         48.0
  6          3            6       5.0             6.00       0.00         30.0
  7          3            7       6.0             4.50       0.00         27.0
```

  </br>

 </details>

### Ejercicio 13

**Consulta:** Obtener la primera venta.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM venta ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id               fecha       ticket  id_cliente metodo_pago  subtotal  descuento_total  iva  total  estado
  1 2026-04-21 11:10:00 TCK-2026-001           1     tarjeta     13.55              0.5  0.0  13.05 cerrada
```

  </br>

 </details>

### Ejercicio 14

**Consulta:** Obtener todas las ventas.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM venta ORDER BY id;
```

**Salida:**

```text
 id               fecha       ticket  id_cliente metodo_pago  subtotal  descuento_total  iva  total  estado
  1 2026-04-21 11:10:00 TCK-2026-001         1.0     tarjeta     13.55              0.5  0.0  13.05 cerrada
  2 2026-04-21 13:20:00 TCK-2026-002         NaN    efectivo      9.95              0.0  0.0   9.95 cerrada
  3 2026-04-22 18:00:00 TCK-2026-003         2.0       bizum     14.20              0.2  0.0  14.00 cerrada
```

  </br>

 </details>

### Ejercicio 15

**Consulta:** Obtener el primer detalle de venta.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM venta_detalle ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id  id_venta  id_producto  cantidad  precio_unitario  descuento  total_linea
  1         1            1       2.0             2.35        0.2          4.5
```

  </br>

 </details>

### Ejercicio 16

**Consulta:** Obtener todos los detalles de venta.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM venta_detalle ORDER BY id;
```

**Salida:**

```text
 id  id_venta  id_producto  cantidad  precio_unitario  descuento  total_linea
  1         1            1       2.0             2.35        0.2         4.50
  2         1            4       1.5             2.60        0.3         3.60
  3         1            7       1.0             7.90        0.0         7.90
  4         2            6       1.0             9.95        0.0         9.95
  5         3            2       3.0             2.10        0.2         6.10
  6         3            3       2.0             1.85        0.0         3.70
  7         3            5       2.5             1.65        0.0         4.20
```

  </br>

 </details>

### Ejercicio 17

**Consulta:** Obtener el primer movimiento de stock.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM movimiento_stock ORDER BY id LIMIT 1;
```

**Salida:**

```text
 id               fecha  id_producto           tipo  cantidad referencia      observaciones
  1 2026-04-23 15:55:45            1 entrada_compra      20.0   COMPRA-1 Entrada por compra
```

  </br>

 </details>

### Ejercicio 18

**Consulta:** Obtener todos los movimientos de stock.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT * FROM movimiento_stock ORDER BY id;
```

**Salida:**

```text
 id               fecha  id_producto           tipo  cantidad referencia      observaciones
  1 2026-04-23 15:55:45            1 entrada_compra      20.0   COMPRA-1 Entrada por compra
  2 2026-04-23 15:55:45            2 entrada_compra      15.0   COMPRA-1 Entrada por compra
  3 2026-04-23 15:55:45            3 entrada_compra      15.0   COMPRA-1 Entrada por compra
  4 2026-04-23 15:55:45            4 entrada_compra      18.0   COMPRA-2 Entrada por compra
  5 2026-04-23 15:55:45            5 entrada_compra      60.0   COMPRA-2 Entrada por compra
  6 2026-04-23 15:55:45            6 entrada_compra       5.0   COMPRA-3 Entrada por compra
  7 2026-04-23 15:55:45            7 entrada_compra       6.0   COMPRA-3 Entrada por compra
  8 2026-04-23 15:55:45            1   salida_venta      -2.0    VENTA-1   Salida por venta
  9 2026-04-23 15:55:45            4   salida_venta      -1.5    VENTA-1   Salida por venta
 10 2026-04-23 15:55:45            7   salida_venta      -1.0    VENTA-1   Salida por venta
 11 2026-04-23 15:55:45            6   salida_venta      -1.0    VENTA-2   Salida por venta
 12 2026-04-23 15:55:45            2   salida_venta      -3.0    VENTA-3   Salida por venta
 13 2026-04-23 15:55:45            3   salida_venta      -2.0    VENTA-3   Salida por venta
 14 2026-04-23 15:55:45            5   salida_venta      -2.5    VENTA-3   Salida por venta
```

  </br>

 </details>

### Ejercicio 19

**Consulta:** Mostrar solo nombre y ciudad de todos los proveedores.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT nombre, ciudad FROM proveedor ORDER BY nombre;
```

**Salida:**

```text
                  nombre    ciudad
         Campo Fresco SL     Telde
Distribuciones Atlántico La Laguna
        Huerta del Norte Tacoronte
```

  </br>

 </details>

### Ejercicio 20

**Consulta:** Mostrar solo nombre y ciudad de los clientes que viven en La Laguna o La Orotava.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT nombre, ciudad FROM cliente WHERE ciudad IN ('La Laguna', 'La Orotava') ORDER BY ciudad, nombre;
```

**Salida:**

```text
    nombre     ciudad
 Ana Pérez  La Laguna
María Díaz La Orotava
```

  </br>

 </details>

### Ejercicio 21

**Consulta:** Mostrar solo código, nombre y precio de venta de todos los productos.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT codigo, nombre, precio_venta FROM producto ORDER BY nombre;
```

**Salida:**

```text
     codigo              nombre  precio_venta
SEC-ALM-001      Almendra cruda          9.95
FRU-MAN-001      Manzana Golden          2.35
COM-MIE-001       Miel de palma          7.90
FRU-NAR-001     Naranja de zumo          1.85
VER-PAP-001         Papa bonita          1.65
FRU-PLA-001 Plátano de Canarias          2.10
VER-TOM-001     Tomate ensalada          2.60
```

  </br>

 </details>

### Ejercicio 22

**Consulta:** Mostrar los productos con precio de venta mayor que 2 euros.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT id, codigo, nombre, precio_venta FROM producto WHERE precio_venta > 2 ORDER BY precio_venta DESC;
```

**Salida:**

```text
 id      codigo              nombre  precio_venta
  6 SEC-ALM-001      Almendra cruda          9.95
  7 COM-MIE-001       Miel de palma          7.90
  4 VER-TOM-001     Tomate ensalada          2.60
  1 FRU-MAN-001      Manzana Golden          2.35
  2 FRU-PLA-001 Plátano de Canarias          2.10
```

  </br>

 </details>

### Ejercicio 23

**Consulta:** Mostrar los productos cuyo stock actual es menor o igual que el stock mínimo.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT id, nombre, stock_actual, stock_minimo FROM producto WHERE stock_actual <= stock_minimo ORDER BY stock_actual ASC;
```

**Salida:**

```text
 id              nombre  stock_actual  stock_minimo
  6      Almendra cruda           4.0           5.0
  2 Plátano de Canarias          12.0          20.0
  3     Naranja de zumo          13.0          25.0
```

  </br>

 </details>

### Ejercicio 24

**Consulta:** Mostrar los productos no perecederos.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT id, nombre, unidad_medida, perecedero FROM producto WHERE perecedero = 0 ORDER BY nombre;
```

**Salida:**

```text
 id         nombre unidad_medida  perecedero
  6 Almendra cruda            kg           0
  7  Miel de palma        unidad           0
```

  </br>

 </details>

### Ejercicio 25

**Consulta:** Mostrar las compras cuyo total es mayor de 60 euros.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT id, numero_factura, total FROM compra WHERE total > 60 ORDER BY total DESC;
```

**Salida:**

```text
 id numero_factura  total
  2   FAC-2026-002  78.11
  3   FAC-2026-003  60.99
```

  </br>

 </details>

### Ejercicio 26

**Consulta:** Mostrar los detalles de compra que tienen descuento.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT id, id_compra, id_producto, descuento, total_linea FROM compra_detalle WHERE descuento > 0 ORDER BY id;
```

**Salida:**

```text
 id  id_compra  id_producto  descuento  total_linea
  3          1            3       0.25         14.0
```

  </br>

 </details>

### Ejercicio 27

**Consulta:** Mostrar las ventas pagadas en efectivo o bizum.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT id, ticket, metodo_pago, total FROM venta WHERE metodo_pago IN ('efectivo', 'bizum') ORDER BY id;
```

**Salida:**

```text
 id       ticket metodo_pago  total
  2 TCK-2026-002    efectivo   9.95
  3 TCK-2026-003       bizum  14.00
```

  </br>

 </details>

### Ejercicio 28

**Consulta:** Mostrar las líneas de venta con cantidad mayor o igual que 2.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT id, id_venta, id_producto, cantidad, total_linea FROM venta_detalle WHERE cantidad >= 2 ORDER BY cantidad DESC, id;
```

**Salida:**

```text
 id  id_venta  id_producto  cantidad  total_linea
  5         3            2       3.0          6.1
  7         3            5       2.5          4.2
  1         1            1       2.0          4.5
  6         3            3       2.0          3.7
```

  </br>

 </details>

### Ejercicio 29

**Consulta:** Mostrar únicamente los movimientos de stock de salida por venta.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT id, id_producto, tipo, cantidad, referencia FROM movimiento_stock WHERE tipo = 'salida_venta' ORDER BY id;
```

**Salida:**

```text
 id  id_producto         tipo  cantidad referencia
  8            1 salida_venta      -2.0    VENTA-1
  9            4 salida_venta      -1.5    VENTA-1
 10            7 salida_venta      -1.0    VENTA-1
 11            6 salida_venta      -1.0    VENTA-2
 12            2 salida_venta      -3.0    VENTA-3
 13            3 salida_venta      -2.0    VENTA-3
 14            5 salida_venta      -2.5    VENTA-3
```

  </br>

 </details>

### Ejercicio 30

**Consulta:** Obtener el total vendido, la media, la venta máxima y la venta mínima.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT SUM(total) AS total_vendido, AVG(total) AS media_ventas, MAX(total) AS venta_maxima, MIN(total) AS venta_minima FROM venta WHERE estado = 'cerrada';
```

**Salida:**

```text
 total_vendido  media_ventas  venta_maxima  venta_minima
          37.0     12.333333          14.0          9.95
```

  </br>

 </details>


## 7. Bloque 2: consultas combinando tablas

### Ejercicio 31

**Consulta:** Mostrar cada producto junto con el nombre de su categoría.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.id,
       p.nombre AS producto,
       c.nombre AS categoria
FROM producto p
JOIN categoria_producto c ON c.id = p.id_categoria
ORDER BY p.id;
```

**Salida:**

```text
 id            producto    categoria
  1      Manzana Golden        Fruta
  2 Plátano de Canarias        Fruta
  3     Naranja de zumo        Fruta
  4     Tomate ensalada      Verdura
  5         Papa bonita      Verdura
  6      Almendra cruda Frutos secos
  7       Miel de palma Complementos
```

  </br>

 </details>

### Ejercicio 32

**Consulta:** Mostrar cada producto junto con su proveedor principal.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.id,
       p.nombre AS producto,
       pr.nombre AS proveedor
FROM producto p
JOIN proveedor pr ON pr.id = p.id_proveedor_principal
ORDER BY p.id;
```

**Salida:**

```text
 id            producto                proveedor
  1      Manzana Golden Distribuciones Atlántico
  2 Plátano de Canarias Distribuciones Atlántico
  3     Naranja de zumo         Huerta del Norte
  4     Tomate ensalada         Huerta del Norte
  5         Papa bonita         Huerta del Norte
  6      Almendra cruda          Campo Fresco SL
  7       Miel de palma          Campo Fresco SL
```

  </br>

 </details>

### Ejercicio 33

**Consulta:** Mostrar cada venta junto con el nombre del cliente.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT v.id,
       v.ticket,
       COALESCE(c.nombre, 'Cliente ocasional') AS cliente,
       v.total
FROM venta v
LEFT JOIN cliente c ON c.id = v.id_cliente
ORDER BY v.id;
```

**Salida:**

```text
 id       ticket           cliente  total
  1 TCK-2026-001         Ana Pérez  13.05
  2 TCK-2026-002 Cliente ocasional   9.95
  3 TCK-2026-003       Luis Martín  14.00
```

  </br>

 </details>

### Ejercicio 34

**Consulta:** Mostrar el detalle de ventas con ticket, producto, cantidad y total de línea.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT v.ticket,
       p.nombre AS producto,
       vd.cantidad,
       vd.total_linea
FROM venta_detalle vd
JOIN venta v ON v.id = vd.id_venta
JOIN producto p ON p.id = vd.id_producto
ORDER BY v.ticket, p.nombre;
```

**Salida:**

```text
      ticket            producto  cantidad  total_linea
TCK-2026-001      Manzana Golden       2.0         4.50
TCK-2026-001       Miel de palma       1.0         7.90
TCK-2026-001     Tomate ensalada       1.5         3.60
TCK-2026-002      Almendra cruda       1.0         9.95
TCK-2026-003     Naranja de zumo       2.0         3.70
TCK-2026-003         Papa bonita       2.5         4.20
TCK-2026-003 Plátano de Canarias       3.0         6.10
```

  </br>

 </details>

### Ejercicio 35

**Consulta:** Mostrar el detalle de compras con factura, producto, cantidad y total de línea.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.numero_factura,
       p.nombre AS producto,
       cd.cantidad,
       cd.total_linea
FROM compra_detalle cd
JOIN compra c ON c.id = cd.id_compra
JOIN producto p ON p.id = cd.id_producto
ORDER BY c.numero_factura, p.nombre;
```

**Salida:**

```text
numero_factura            producto  cantidad  total_linea
  FAC-2026-001      Manzana Golden      20.0         24.0
  FAC-2026-001     Naranja de zumo      15.0         14.0
  FAC-2026-001 Plátano de Canarias      15.0         16.5
  FAC-2026-002         Papa bonita      60.0         48.0
  FAC-2026-002     Tomate ensalada      18.0         24.3
  FAC-2026-003      Almendra cruda       5.0         30.0
  FAC-2026-003       Miel de palma       6.0         27.0
```

  </br>

 </details>

### Ejercicio 36

**Consulta:** Mostrar productos con categoría y proveedor principal cuyo precio de venta es mayor que 2 euros.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS producto,
       c.nombre AS categoria,
       pr.nombre AS proveedor,
       p.precio_venta
FROM producto p
JOIN categoria_producto c ON c.id = p.id_categoria
JOIN proveedor pr ON pr.id = p.id_proveedor_principal
WHERE p.precio_venta > 2
ORDER BY p.precio_venta DESC;
```

**Salida:**

```text
           producto    categoria                proveedor  precio_venta
     Almendra cruda Frutos secos          Campo Fresco SL          9.95
      Miel de palma Complementos          Campo Fresco SL          7.90
    Tomate ensalada      Verdura         Huerta del Norte          2.60
     Manzana Golden        Fruta Distribuciones Atlántico          2.35
Plátano de Canarias        Fruta Distribuciones Atlántico          2.10
```

  </br>

 </details>

### Ejercicio 37

**Consulta:** Mostrar las ventas cerradas con cliente y total mayor que 10 euros.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT v.ticket,
       COALESCE(c.nombre, 'Cliente ocasional') AS cliente,
       v.total
FROM venta v
LEFT JOIN cliente c ON c.id = v.id_cliente
WHERE v.estado = 'cerrada'
  AND v.total > 10
ORDER BY v.total DESC;
```

**Salida:**

```text
      ticket     cliente  total
TCK-2026-003 Luis Martín  14.00
TCK-2026-001   Ana Pérez  13.05
```

  </br>

 </details>

### Ejercicio 38

**Consulta:** Mostrar las compras realizadas a proveedores de Tacoronte.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.numero_factura,
       p.nombre AS proveedor,
       p.ciudad,
       c.total
FROM compra c
JOIN proveedor p ON p.id = c.id_proveedor
WHERE p.ciudad = 'Tacoronte'
ORDER BY c.id;
```

**Salida:**

```text
numero_factura        proveedor    ciudad  total
  FAC-2026-002 Huerta del Norte Tacoronte  78.11
```

  </br>

 </details>

### Ejercicio 39

**Consulta:** Mostrar los movimientos de stock de salida junto con el nombre del producto.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT m.id,
       p.nombre AS producto,
       m.tipo,
       m.cantidad,
       m.referencia
FROM movimiento_stock m
JOIN producto p ON p.id = m.id_producto
WHERE m.tipo = 'salida_venta'
ORDER BY m.id;
```

**Salida:**

```text
 id            producto         tipo  cantidad referencia
  8      Manzana Golden salida_venta      -2.0    VENTA-1
  9     Tomate ensalada salida_venta      -1.5    VENTA-1
 10       Miel de palma salida_venta      -1.0    VENTA-1
 11      Almendra cruda salida_venta      -1.0    VENTA-2
 12 Plátano de Canarias salida_venta      -3.0    VENTA-3
 13     Naranja de zumo salida_venta      -2.0    VENTA-3
 14         Papa bonita salida_venta      -2.5    VENTA-3
```

  </br>

 </details>

### Ejercicio 40

**Consulta:** Contar cuántos productos hay en cada categoría.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.nombre AS categoria,
       COUNT(p.id) AS total_productos
FROM categoria_producto c
LEFT JOIN producto p ON p.id_categoria = c.id
GROUP BY c.id, c.nombre
ORDER BY total_productos DESC, c.nombre;
```

**Salida:**

```text
   categoria  total_productos
       Fruta                3
     Verdura                2
Complementos                1
Frutos secos                1
```

  </br>

 </details>

### Ejercicio 41

**Consulta:** Contar cuántos productos tiene cada proveedor como proveedor principal.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT pr.nombre AS proveedor,
       COUNT(p.id) AS total_productos
FROM proveedor pr
LEFT JOIN producto p ON p.id_proveedor_principal = pr.id
GROUP BY pr.id, pr.nombre
ORDER BY total_productos DESC, pr.nombre;
```

**Salida:**

```text
               proveedor  total_productos
        Huerta del Norte                3
         Campo Fresco SL                2
Distribuciones Atlántico                2
```

  </br>

 </details>

### Ejercicio 42

**Consulta:** Calcular la cantidad total comprada de cada producto.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS producto,
       SUM(cd.cantidad) AS total_comprado
FROM producto p
JOIN compra_detalle cd ON cd.id_producto = p.id
GROUP BY p.id, p.nombre
ORDER BY total_comprado DESC, p.nombre;
```

**Salida:**

```text
           producto  total_comprado
        Papa bonita            60.0
     Manzana Golden            20.0
    Tomate ensalada            18.0
    Naranja de zumo            15.0
Plátano de Canarias            15.0
      Miel de palma             6.0
     Almendra cruda             5.0
```

  </br>

 </details>

### Ejercicio 43

**Consulta:** Calcular la cantidad total vendida de cada producto.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS producto,
       SUM(vd.cantidad) AS total_vendido
FROM producto p
JOIN venta_detalle vd ON vd.id_producto = p.id
GROUP BY p.id, p.nombre
ORDER BY total_vendido DESC, p.nombre;
```

**Salida:**

```text
           producto  total_vendido
Plátano de Canarias            3.0
        Papa bonita            2.5
     Manzana Golden            2.0
    Naranja de zumo            2.0
    Tomate ensalada            1.5
     Almendra cruda            1.0
      Miel de palma            1.0
```

  </br>

 </details>

### Ejercicio 44

**Consulta:** Calcular el movimiento neto de stock por producto usando la tabla de movimientos.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS producto,
       SUM(m.cantidad) AS movimiento_neto
FROM producto p
JOIN movimiento_stock m ON m.id_producto = p.id
GROUP BY p.id, p.nombre
ORDER BY movimiento_neto DESC, p.nombre;
```

**Salida:**

```text
           producto  movimiento_neto
        Papa bonita             57.5
     Manzana Golden             18.0
    Tomate ensalada             16.5
    Naranja de zumo             13.0
Plátano de Canarias             12.0
      Miel de palma              5.0
     Almendra cruda              4.0
```

  </br>

 </details>

### Ejercicio 45

**Consulta:** Calcular el total vendido por cliente.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT COALESCE(c.nombre, 'Cliente ocasional') AS cliente,
       SUM(v.total) AS total_vendido
FROM venta v
LEFT JOIN cliente c ON c.id = v.id_cliente
GROUP BY c.id, c.nombre
ORDER BY total_vendido DESC;
```

**Salida:**

```text
          cliente  total_vendido
      Luis Martín          14.00
        Ana Pérez          13.05
Cliente ocasional           9.95
```

  </br>

 </details>

### Ejercicio 46

**Consulta:** Calcular el total comprado a cada proveedor.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS proveedor,
       SUM(c.total) AS total_comprado
FROM proveedor p
JOIN compra c ON c.id_proveedor = p.id
GROUP BY p.id, p.nombre
ORDER BY total_comprado DESC;
```

**Salida:**

```text
               proveedor  total_comprado
        Huerta del Norte           78.11
         Campo Fresco SL           60.99
Distribuciones Atlántico           58.32
```

  </br>

 </details>

### Ejercicio 47

**Consulta:** Contar cuántas ventas tiene cada cliente.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT COALESCE(c.nombre, 'Cliente ocasional') AS cliente,
       COUNT(v.id) AS total_ventas
FROM venta v
LEFT JOIN cliente c ON c.id = v.id_cliente
GROUP BY c.id, c.nombre
ORDER BY total_ventas DESC, cliente;
```

**Salida:**

```text
          cliente  total_ventas
        Ana Pérez             1
Cliente ocasional             1
      Luis Martín             1
```

  </br>

 </details>

### Ejercicio 48

**Consulta:** Contar cuántas compras se han hecho a cada proveedor.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS proveedor,
       COUNT(c.id) AS total_compras
FROM proveedor p
LEFT JOIN compra c ON c.id_proveedor = p.id
GROUP BY p.id, p.nombre
ORDER BY total_compras DESC, proveedor;
```

**Salida:**

```text
               proveedor  total_compras
         Campo Fresco SL              1
Distribuciones Atlántico              1
        Huerta del Norte              1
```

  </br>

 </details>

### Ejercicio 49

**Consulta:** Obtener el precio medio de venta de los productos por categoría.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.nombre AS categoria,
       AVG(p.precio_venta) AS precio_medio
FROM categoria_producto c
JOIN producto p ON p.id_categoria = c.id
GROUP BY c.id, c.nombre
ORDER BY precio_medio DESC;
```

**Salida:**

```text
   categoria  precio_medio
Frutos secos         9.950
Complementos         7.900
     Verdura         2.125
       Fruta         2.100
```

  </br>

 </details>

### Ejercicio 50

**Consulta:** Mostrar cada venta con el número de productos distintos vendidos.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT v.ticket,
       COUNT(vd.id_producto) AS lineas,
       COUNT(DISTINCT vd.id_producto) AS productos_distintos
FROM venta v
JOIN venta_detalle vd ON vd.id_venta = v.id
GROUP BY v.id, v.ticket
ORDER BY v.id;
```

**Salida:**

```text
      ticket  lineas  productos_distintos
TCK-2026-001       3                    3
TCK-2026-002       1                    1
TCK-2026-003       3                    3
```

  </br>

 </details>

### Ejercicio 51

**Consulta:** Mostrar cada compra con el número de productos distintos comprados.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.numero_factura,
       COUNT(cd.id_producto) AS lineas,
       COUNT(DISTINCT cd.id_producto) AS productos_distintos
FROM compra c
JOIN compra_detalle cd ON cd.id_compra = c.id
GROUP BY c.id, c.numero_factura
ORDER BY c.id;
```

**Salida:**

```text
numero_factura  lineas  productos_distintos
  FAC-2026-001       3                    3
  FAC-2026-002       2                    2
  FAC-2026-003       2                    2
```

  </br>

 </details>

### Ejercicio 52

**Consulta:** Mostrar qué productos ha comprado cada cliente en sus ventas.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.nombre AS cliente,
       p.nombre AS producto,
       vd.cantidad
FROM venta v
JOIN cliente c ON c.id = v.id_cliente
JOIN venta_detalle vd ON vd.id_venta = v.id
JOIN producto p ON p.id = vd.id_producto
ORDER BY c.nombre, p.nombre;
```

**Salida:**

```text
    cliente            producto  cantidad
  Ana Pérez      Manzana Golden       2.0
  Ana Pérez       Miel de palma       1.0
  Ana Pérez     Tomate ensalada       1.5
Luis Martín     Naranja de zumo       2.0
Luis Martín         Papa bonita       2.5
Luis Martín Plátano de Canarias       3.0
```

  </br>

 </details>

### Ejercicio 53

**Consulta:** Mostrar qué productos aparecen en compras de cada proveedor.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT pr.nombre AS proveedor,
       p.nombre AS producto,
       cd.cantidad
FROM compra c
JOIN proveedor pr ON pr.id = c.id_proveedor
JOIN compra_detalle cd ON cd.id_compra = c.id
JOIN producto p ON p.id = cd.id_producto
ORDER BY pr.nombre, p.nombre;
```

**Salida:**

```text
               proveedor            producto  cantidad
         Campo Fresco SL      Almendra cruda       5.0
         Campo Fresco SL       Miel de palma       6.0
Distribuciones Atlántico      Manzana Golden      20.0
Distribuciones Atlántico     Naranja de zumo      15.0
Distribuciones Atlántico Plátano de Canarias      15.0
        Huerta del Norte         Papa bonita      60.0
        Huerta del Norte     Tomate ensalada      18.0
```

  </br>

 </details>

### Ejercicio 54

**Consulta:** Mostrar por producto la cantidad comprada y la cantidad vendida.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS producto,
       COALESCE(c.total_comprado, 0) AS total_comprado,
       COALESCE(v.total_vendido, 0) AS total_vendido
FROM producto p
LEFT JOIN (
    SELECT id_producto, SUM(cantidad) AS total_comprado
    FROM compra_detalle
    GROUP BY id_producto
) c ON c.id_producto = p.id
LEFT JOIN (
    SELECT id_producto, SUM(cantidad) AS total_vendido
    FROM venta_detalle
    GROUP BY id_producto
) v ON v.id_producto = p.id
ORDER BY p.id;
```

**Salida:**

```text
           producto  total_comprado  total_vendido
     Manzana Golden            20.0            2.0
Plátano de Canarias            15.0            3.0
    Naranja de zumo            15.0            2.0
    Tomate ensalada            18.0            1.5
        Papa bonita            60.0            2.5
     Almendra cruda             5.0            1.0
      Miel de palma             6.0            1.0
```

  </br>

 </details>

### Ejercicio 55

**Consulta:** Mostrar cada producto con su margen bruto y su categoría.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS producto,
       c.nombre AS categoria,
       ROUND(p.precio_venta - p.precio_compra, 2) AS margen
FROM producto p
JOIN categoria_producto c ON c.id = p.id_categoria
ORDER BY margen DESC, producto;
```

**Salida:**

```text
           producto    categoria  margen
     Almendra cruda Frutos secos    3.95
      Miel de palma Complementos    3.40
    Tomate ensalada      Verdura    1.25
     Manzana Golden        Fruta    1.15
Plátano de Canarias        Fruta    1.00
    Naranja de zumo        Fruta    0.90
        Papa bonita      Verdura    0.85
```

  </br>

 </details>

### Ejercicio 56

**Consulta:** Comparar el total guardado de cada venta con la suma de sus líneas.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT v.ticket,
       v.total AS total_venta,
       ROUND(SUM(vd.total_linea), 2) AS suma_lineas
FROM venta v
JOIN venta_detalle vd ON vd.id_venta = v.id
GROUP BY v.id, v.ticket, v.total
ORDER BY v.id;
```

**Salida:**

```text
      ticket  total_venta  suma_lineas
TCK-2026-001        13.05        16.00
TCK-2026-002         9.95         9.95
TCK-2026-003        14.00        14.00
```

  </br>

 </details>

### Ejercicio 57

**Consulta:** Mostrar las compras a proveedores activos cuyo total supera 60 euros.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.numero_factura,
       p.nombre AS proveedor,
       c.total
FROM compra c
JOIN proveedor p ON p.id = c.id_proveedor
WHERE p.activo = 1
  AND c.total > 60
ORDER BY c.total DESC;
```

**Salida:**

```text
numero_factura        proveedor  total
  FAC-2026-002 Huerta del Norte  78.11
  FAC-2026-003  Campo Fresco SL  60.99
```

  </br>

 </details>

### Ejercicio 58

**Consulta:** Mostrar los productos bajo stock junto con su categoría y proveedor principal.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT p.nombre AS producto,
       c.nombre AS categoria,
       pr.nombre AS proveedor,
       p.stock_actual,
       p.stock_minimo
FROM producto p
JOIN categoria_producto c ON c.id = p.id_categoria
JOIN proveedor pr ON pr.id = p.id_proveedor_principal
WHERE p.stock_actual <= p.stock_minimo
ORDER BY p.stock_actual ASC;
```

**Salida:**

```text
           producto    categoria                proveedor  stock_actual  stock_minimo
     Almendra cruda Frutos secos          Campo Fresco SL           4.0           5.0
Plátano de Canarias        Fruta Distribuciones Atlántico          12.0          20.0
    Naranja de zumo        Fruta         Huerta del Norte          13.0          25.0
```

  </br>

 </details>

### Ejercicio 59

**Consulta:** Mostrar las ventas realizadas a clientes de La Laguna.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT v.ticket,
       c.nombre AS cliente,
       c.ciudad,
       v.total
FROM venta v
JOIN cliente c ON c.id = v.id_cliente
WHERE c.ciudad = 'La Laguna'
ORDER BY v.id;
```

**Salida:**

```text
      ticket   cliente    ciudad  total
TCK-2026-001 Ana Pérez La Laguna  13.05
```

  </br>

 </details>

### Ejercicio 60

**Consulta:** Crear un ranking de productos por cantidad total vendida.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT producto,
       total_vendido,
       ROW_NUMBER() OVER (ORDER BY total_vendido DESC, producto) AS ranking
FROM (
    SELECT p.nombre AS producto,
           SUM(vd.cantidad) AS total_vendido
    FROM producto p
    JOIN venta_detalle vd ON vd.id_producto = p.id
    GROUP BY p.id, p.nombre
) t
ORDER BY ranking;
```

**Salida:**

```text
           producto  total_vendido  ranking
Plátano de Canarias            3.0        1
        Papa bonita            2.5        2
     Manzana Golden            2.0        3
    Naranja de zumo            2.0        4
    Tomate ensalada            1.5        5
     Almendra cruda            1.0        6
      Miel de palma            1.0        7
```

  </br>

 </details>
