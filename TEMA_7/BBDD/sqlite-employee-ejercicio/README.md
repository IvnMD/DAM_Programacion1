# SQLite Employee Ejercicio

Este proyecto contiene una base de datos SQLite3 de ejemplo basada en el esquema `Employee`.

## Archivos

- `schema.sql`: crea las tablas.
- `seed.sql`: inserta datos de ejemplo.
- `employee.db`: se generara al ejecutar los comandos.

## 1. Crear la base de datos

Desde terminal, entra en la carpeta del proyecto:

```bash
cd "sqlite-employee-ejercicio"
```

> **Los datos ya se encuentras pre-cargados**. Puedes saltar al punto **2**.

Crea la base de datos ejecutando el esquema y los datos:

```bash
sqlite3 employee.db < schema.sql
sqlite3 employee.db < seed.sql
```

Tambien puedes hacerlo en una sola linea:

```bash
sqlite3 employee.db < schema.sql && sqlite3 employee.db < seed.sql
```

## 2. Abrir la base de datos

```bash
sqlite3 employee.db
```

## 3. Comandos utiles dentro de sqlite3

Ver ayuda general:

```sql
.help
```

Mostrar todas las bases de datos abiertas:

```sql
.databases
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
.schema employee
.schema rol
.schema skill
```

Mostrar las columnas de una tabla:

```sql
PRAGMA table_info(employee);
PRAGMA table_info(rol);
PRAGMA table_info(skill);
PRAGMA table_info(employee_skill);
```

Mostrar las claves foraneas de una tabla:

```sql
PRAGMA foreign_key_list(employee);
PRAGMA foreign_key_list(skill);
PRAGMA foreign_key_list(resume);
PRAGMA foreign_key_list(employee_skill);
```

Mostrar indices de una tabla:

```sql
PRAGMA index_list(employee);
PRAGMA index_list(resume);
PRAGMA index_list(employee_skill);
```

Activar formato mas legible:

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

## 4. Tablas incluidas

- `category`
- `skill`
- `rol`
- `employee`
- `resume`
- `employee_skill`

## 5. Relacion rapida del modelo

- Un `employee` pertenece a un `rol`.
- Un `employee` puede reportar a otro `employee`.
- Un `resume` pertenece a un unico `employee`.
- Una `skill` pertenece a una `category`.
- `employee_skill` relaciona empleados con skills y su nivel.

## 6. Realiza las siguientes consultas

Antes de comenzar, repasa la documentación básica `(independiente del motor de bbdd)` para tener al día las consultas de bbdd.

> [Base de datos en sqlite3](https://github.com/jpexposito/code-learn/tree/main/primero/bae/unidad-5/sqlite)

> Las soluciones que se aportan cruzando información entre tablas esta en a través de **JOIN**. Realiza la misma consulta a través de **WHERE**.

> `La misma consulta se podría realizar de diferentes formas`.

### Ejercicio 1

**Consulta:** Obtener todos los empleados.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT *
FROM employee;
```

  </br>

 </details>

### Ejercicio 2

**Consulta:** Mostrar solo name y surname de todos los empleados.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT name, surname
FROM employee;
```

  </br>

 </details>

### Ejercicio 3

**Consulta:** Listar todos los roles ordenados por salario descendente.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT *
FROM rol
ORDER BY salary DESC;
```

  </br>

 </details>

### Ejercicio 4

**Consulta:** Mostrar los empleados contratados despues de '2022-01-01'.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT *
FROM employee
WHERE start_date > '2022-01-01'
ORDER BY start_date;
```

  </br>

 </details>

### Ejercicio 5

**Consulta:** Obtener los empleados que no tienen jefe.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT *
FROM employee
WHERE reports_to IS NULL;
```

  </br>

 </details>

### Ejercicio 6

**Consulta:** Mostrar cada empleado junto con el nombre de su rol.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       r.name AS rol_name
FROM employee e
JOIN rol r ON r.id = e.rol_id
ORDER BY e.id;
```

  </br>

 </details>

### Ejercicio 7

**Consulta:** Mostrar cada skill junto con el nombre de su categoria.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT s.id,
       s.name AS skill_name,
       c.name AS category_name
FROM skill s
JOIN category c ON c.id = s.category_id
ORDER BY s.id;
```

  </br>

 </details>

### Ejercicio 8

**Consulta:** Listar los empleados junto con todas sus skills.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       s.name AS skill_name
FROM employee e
JOIN employee_skill es ON es.employee_id = e.id
JOIN skill s ON s.id = es.skill_id
ORDER BY e.id, s.name;
```

  </br>

 </details>

### Ejercicio 9

**Consulta:** Mostrar empleado, skill y level_id.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.name || ' ' || e.surname AS employee,
       s.name AS skill,
       es.level_id
FROM employee_skill es
JOIN employee e ON e.id = es.employee_id
JOIN skill s ON s.id = es.skill_id
ORDER BY employee, skill;
```

  </br>

 </details>

### Ejercicio 10

**Consulta:** Mostrar cada empleado junto con el nombre de su jefe.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.name || ' ' || e.surname AS employee,
       m.name || ' ' || m.surname AS manager
FROM employee e
LEFT JOIN employee m ON m.id = e.reports_to
ORDER BY e.id;
```

  </br>

 </details>

### Ejercicio 11

**Consulta:** Contar cuantos empleados hay por rol.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT r.name AS rol_name,
       COUNT(e.id) AS total_employees
FROM rol r
LEFT JOIN employee e ON e.rol_id = r.id
GROUP BY r.id, r.name
ORDER BY total_employees DESC, r.name;
```

  </br>

 </details>

### Ejercicio 12

**Consulta:** Contar cuantas skills tiene cada empleado.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       COUNT(es.skill_id) AS total_skills
FROM employee e
LEFT JOIN employee_skill es ON es.employee_id = e.id
GROUP BY e.id, e.name, e.surname
ORDER BY total_skills DESC, e.id;
```

  </br>

 </details>

### Ejercicio 13

**Consulta:** Mostrar los roles que tienen mas de 2 empleados.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT r.name AS rol_name,
       COUNT(e.id) AS total_employees
FROM rol r
JOIN employee e ON e.rol_id = r.id
GROUP BY r.id, r.name
HAVING COUNT(e.id) > 2
ORDER BY total_employees DESC;
```

  </br>

 </details>

### Ejercicio 14

**Consulta:** Obtener los empleados que tienen resume.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.*
FROM employee e
JOIN resume r ON r.employee_id = e.id
ORDER BY e.id;
```

  </br>

 </details>

### Ejercicio 15

**Consulta:** Obtener los empleados que no tienen resume.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.*
FROM employee e
LEFT JOIN resume r ON r.employee_id = e.id
WHERE r.employee_id IS NULL
ORDER BY e.id;
```

  </br>

 </details>

### Ejercicio 16

**Consulta:** Calcular el salario medio de los roles.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT AVG(salary) AS avg_salary
FROM rol;
```

  </br>

 </details>

### Ejercicio 17

**Consulta:** Mostrar el salario maximo y minimo de los roles.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT MAX(salary) AS max_salary,
       MIN(salary) AS min_salary
FROM rol;
```

  </br>

 </details>

### Ejercicio 18

**Consulta:** Obtener los empleados cuyo rol cobra mas que la media salarial.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       r.name AS rol_name,
       r.salary
FROM employee e
JOIN rol r ON r.id = e.rol_id
WHERE r.salary > (SELECT AVG(salary) FROM rol)
ORDER BY r.salary DESC, e.id;
```

  </br>

 </details>

### Ejercicio 19

**Consulta:** Mostrar los empleados con mas de 3 skills.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       COUNT(es.skill_id) AS total_skills
FROM employee e
JOIN employee_skill es ON es.employee_id = e.id
GROUP BY e.id, e.name, e.surname
HAVING COUNT(es.skill_id) > 3
ORDER BY total_skills DESC, e.id;
```

  </br>

 </details>

### Ejercicio 20

**Consulta:** Obtener el jefe con mas subordinados.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT m.id,
       m.name,
       m.surname,
       COUNT(e.id) AS total_subordinates
FROM employee m
JOIN employee e ON e.reports_to = m.id
GROUP BY m.id, m.name, m.surname
ORDER BY total_subordinates DESC, m.id
LIMIT 1;
```

  </br>

 </details>

### Ejercicio 21

**Consulta:** Mostrar los empleados cuyo jefe tiene salario superior a 50000.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       m.name || ' ' || m.surname AS manager,
       mr.salary AS manager_salary
FROM employee e
JOIN employee m ON m.id = e.reports_to
JOIN rol mr ON mr.id = m.rol_id
WHERE mr.salary > 50000
ORDER BY e.id;
```

  </br>

 </details>

### Ejercicio 22

**Consulta:** Obtener las skills que no estan asignadas a ningun empleado.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT s.id,
       s.name
FROM skill s
LEFT JOIN employee_skill es ON es.skill_id = s.id
WHERE es.employee_id IS NULL
ORDER BY s.id;
```

  </br>

 </details>

### Ejercicio 23

**Consulta:** Mostrar los empleados que no tienen ninguna skill.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname
FROM employee e
LEFT JOIN employee_skill es ON es.employee_id = e.id
WHERE es.skill_id IS NULL
ORDER BY e.id;
```

  </br>

 </details>

### Ejercicio 24

**Consulta:** Obtener las categorias con numero de skills.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.id,
       c.name,
       COUNT(s.id) AS total_skills
FROM category c
LEFT JOIN skill s ON s.category_id = c.id
GROUP BY c.id, c.name
ORDER BY total_skills DESC, c.name;
```

  </br>

 </details>

### Ejercicio 25

**Consulta:** Mostrar las categorias usadas por mas empleados distintos.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT c.name AS category_name,
       COUNT(DISTINCT es.employee_id) AS total_employees
FROM category c
JOIN skill s ON s.category_id = c.id
LEFT JOIN employee_skill es ON es.skill_id = s.id
GROUP BY c.id, c.name
ORDER BY total_employees DESC, c.name;
```

  </br>

 </details>

### Ejercicio 26

**Consulta:** Obtener el empleado con mayor numero de skills.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       COUNT(es.skill_id) AS total_skills
FROM employee e
JOIN employee_skill es ON es.employee_id = e.id
GROUP BY e.id, e.name, e.surname
ORDER BY total_skills DESC, e.id
LIMIT 1;
```

  </br>

 </details>

### Ejercicio 27

**Consulta:** Mostrar los empleados con salario superior al de su jefe.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       er.salary AS employee_salary,
       m.name || ' ' || m.surname AS manager,
       mr.salary AS manager_salary
FROM employee e
JOIN rol er ON er.id = e.rol_id
JOIN employee m ON m.id = e.reports_to
JOIN rol mr ON mr.id = m.rol_id
WHERE er.salary > mr.salary
ORDER BY e.id;
```

  </br>

 </details>

### Ejercicio 28

**Consulta:** Mostrar los empleados con experience_years superior a la media.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT e.id,
       e.name,
       e.surname,
       r.experience_years
FROM employee e
JOIN resume r ON r.employee_id = e.id
WHERE r.experience_years > (SELECT AVG(experience_years) FROM resume)
ORDER BY r.experience_years DESC, e.id;
```

  </br>

 </details>

### Ejercicio 29

**Consulta:** Crear un ranking de empleados por numero de skills usando ROW_NUMBER().

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT employee_id,
       employee,
       total_skills,
       ROW_NUMBER() OVER (ORDER BY total_skills DESC, employee_id) AS ranking_position
FROM (
    SELECT e.id AS employee_id,
           e.name || ' ' || e.surname AS employee,
           COUNT(es.skill_id) AS total_skills
    FROM employee e
    LEFT JOIN employee_skill es ON es.employee_id = e.id
    GROUP BY e.id, e.name, e.surname
) ranked
ORDER BY ranking_position;
```

  </br>

 </details>

### Ejercicio 30

**Consulta:** Obtener el empleado mas antiguo dentro de cada rol usando funciones de ventana.

<details>
      <summary>PULSA PARA VER LA SOLUCIÓN</summary>
  </br>

```sql
SELECT rol_name,
       employee_id,
       employee,
       start_date
FROM (
    SELECT r.name AS rol_name,
           e.id AS employee_id,
           e.name || ' ' || e.surname AS employee,
           e.start_date,
           ROW_NUMBER() OVER (
               PARTITION BY r.id
               ORDER BY e.start_date ASC, e.id ASC
           ) AS rn
    FROM employee e
    JOIN rol r ON r.id = e.rol_id
) t
WHERE rn = 1
ORDER BY rol_name;
```

  </br>

 </details>

