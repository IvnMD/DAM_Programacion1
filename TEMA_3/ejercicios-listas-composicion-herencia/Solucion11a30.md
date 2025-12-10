# ✅ **EJERCICIO 11 – COMPOSICIÓN: Persona y Dirección**

*Tema: una Persona TIENE una Dirección*

---

## 📌 `Direccion.java`

```java
package com.docencia.composicion.ejercicio11;

/**
 * Clase Direccion: ejemplo sencillo de composición.
 * Representa información postal básica.
 *
 * Comentada línea a línea.
 */
public class Direccion {

    // Campo que representa la calle (incluye número si se quiere)
    private final String calle;

    // Ciudad donde está la dirección
    private final String ciudad;

    // Código postal (cadena por si incluye letras)
    private final String codigoPostal;

    /**
     * Constructor con parámetros obligatorios.
     */
    public Direccion(String calle, String ciudad, String codigoPostal) {
        // Asignamos directamente los parámetros recibidos
        this.calle = calle;           
        this.ciudad = ciudad;         
        this.codigoPostal = codigoPostal; 
    }

    // Getters simples
    public String getCalle() { return calle; }
    public String getCiudad() { return ciudad; }
    public String getCodigoPostal() { return codigoPostal; }

    /**
     * Devuelve la dirección en formato humano legible.
     */
    public String formateada() {
        return calle + ", " + ciudad + " (" + codigoPostal + ")";
    }

    @Override
    public String toString() {
        return formateada();
    }
}
```

---

## 📌 `Persona.java`

```java
package com.docencia.composicion.ejercicio11;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Persona: demuestra COMPOSICIÓN.
 * Una persona TIENE una dirección.
 */
public class Persona {

    // Datos básicos
    private final String nombre;
    private final int edad;

    // Composición: una Persona contiene una Dirección
    private Direccion direccion;

    /**
     * Constructor principal.
     */
    public Persona(String nombre, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion; // puede ser null
    }

    // Getters habituales
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public Direccion getDireccion() { return direccion; }

    // Setter para poder cambiar dirección
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + ") - " +
                (direccion != null ? direccion.formateada() : "Sin dirección");
    }

    /**
     * Método de utilidad:
     * Filtra una lista de personas por ciudad.
     */
    public static List<Persona> filtrarPorCiudad(List<Persona> lista, String ciudad) {
        List<Persona> resultado = new ArrayList<>();

        if (lista == null || ciudad == null) return resultado;

        for (Persona p : lista) {
            if (p == null) continue;
            Direccion d = p.getDireccion();

            if (d != null && ciudad.equals(d.getCiudad())) {
                resultado.add(p);
            }
        }

        return resultado;
    }
}
```

---

## 📌 `Ejercicio11Test.java`

```java
package com.docencia.composicion.ejercicio11;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test completo del Ejercicio 11.
 */
public class Ejercicio11Test {

    @Test
    void testPersonaYDireccion() {
        Direccion d1 = new Direccion("Calle Falsa 123", "Madrid", "28080");
        Direccion d2 = new Direccion("Av. Marítima 10", "Las Palmas", "35001");

        Persona p1 = new Persona("Ana", 30, d1);
        Persona p2 = new Persona("Luis", 22, d2);
        Persona p3 = new Persona("Clara", 40, null);

        assertEquals("Calle Falsa 123", p1.getDireccion().getCalle());
        assertTrue(p3.toString().contains("Sin dirección"));

        List<Persona> lista = Arrays.asList(p1, p2, p3);

        List<Persona> enMadrid = Persona.filtrarPorCiudad(lista, "Madrid");
        assertEquals(1, enMadrid.size());
        assertEquals("Ana", enMadrid.get(0).getNombre());

        List<Persona> enRoma = Persona.filtrarPorCiudad(lista, "Roma");
        assertTrue(enRoma.isEmpty());
    }
}
```

---

# ✅ **EJERCICIO 12 – COMPOSICIÓN: Coche y Motor**

*Tema: un Coche TIENE un Motor*

---

## 📌 `Motor.java`

```java
package com.docencia.composicion.ejercicio12;

/**
 * Ejercicio 12: clase Motor
 * Representa un motor que puede encenderse/apagarse.
 */
public class Motor {

    private boolean encendido;

    public Motor() {
        this.encendido = false;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public boolean isEncendido() {
        return encendido;
    }

    @Override
    public String toString() {
        return encendido ? "Motor encendido" : "Motor apagado";
    }
}
```

---

## 📌 `Coche.java`

```java
package com.docencia.composicion.ejercicio12;

/**
 * Clase Coche que usa composición:
 * Un coche TIENE un motor.
 */
public class Coche {

    private final String modelo;

    // Composición: el coche contiene un motor
    private final Motor motor;

    public Coche(String modelo) {
        this.modelo = modelo;
        this.motor = new Motor(); // composición fuerte: se crea dentro
    }

    public String getModelo() { return modelo; }
    public Motor getMotor() { return motor; }

    public void arrancar() {
        motor.encender();
    }

    public void detener() {
        motor.apagar();
    }

    @Override
    public String toString() {
        return modelo + " -> " + motor.toString();
    }
}
```

---

## 📌 `Ejercicio12Test.java`

```java
package com.docencia.composicion.ejercicio12;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test del Ejercicio 12.
 */
public class Ejercicio12Test {

    @Test
    void testCocheYMotor() {
        Coche c = new Coche("Toyota");

        assertFalse(c.getMotor().isEncendido());

        c.arrancar();
        assertTrue(c.getMotor().isEncendido());

        c.detener();
        assertFalse(c.getMotor().isEncendido());
    }
}
```

---

Perfecto — continúo con los **Ejercicios 13 y 14**, con código **completamente comentado línea a línea** y tests JUnit para copiar/pegar.

---

# ✅ **EJERCICIO 13 – COMPOSICIÓN: Biblioteca y Libro**

**Paquete:** `com.docencia.composicion.ejercicio13`
**Objetivo:** diseñar `Libro` y `Biblioteca` con métodos para agregar, buscar por autor y eliminar por título.

---

## 📌 `Libro.java`

```java
package com.docencia.composicion.ejercicio13;

/**
 * Clase Libro: representa un libro con título, autor y año de publicación.
 * Comentarios línea a línea para aprender el diseño por composición.
 */
public class Libro {

    // Título del libro
    private final String titulo;

    // Autor del libro
    private final String autor;

    // Año de publicación (entero)
    private final int año;

    /**
     * Constructor completo.
     *
     * @param titulo título del libro (puede ser null si se quisiera permitir, pero evitamos)
     * @param autor  autor del libro
     * @param año    año de publicación
     */
    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }

    // Getter para título
    public String getTitulo() {
        return titulo;
    }

    // Getter para autor
    public String getAutor() {
        return autor;
    }

    // Getter para año
    public int getAño() {
        return año;
    }

    @Override
    public String toString() {
        // Representación legible del libro
        return titulo + " - " + autor + " (" + año + ")";
    }
}
```

---

## 📌 `Biblioteca.java`

```java
package com.docencia.composicion.ejercicio13;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Biblioteca: encapsula una colección de libros.
 * Provee métodos para agregar, buscar por autor y eliminar por título.
 */
public class Biblioteca {

    // Lista interna que contiene los libros. Se mantiene privada para encapsulación.
    private final List<Libro> libros = new ArrayList<>();

    /**
     * Agrega un libro a la biblioteca.
     * Si el libro es null, no hace nada.
     *
     * @param libro libro a agregar
     */
    public void agregarLibro(Libro libro) {
        if (libro == null) return; // validación defensiva
        libros.add(libro);
    }

    /**
     * Busca y devuelve una lista de libros escritos por el autor dado.
     * - Mantiene el orden de inserción.
     * - Devuelve una nueva lista para evitar exponer la lista interna.
     *
     * @param autor nombre del autor a buscar (si es null devuelve lista vacía)
     * @return lista de libros del autor
     */
    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        if (autor == null) return resultado;
        for (Libro l : libros) {
            // Comprobamos igualdad de cadenas (autor exacto)
            if (autor.equals(l.getAutor())) {
                resultado.add(l);
            }
        }
        return resultado;
    }

    /**
     * Elimina el primer libro cuyo título coincida exactamente con el dado.
     * Devuelve true si se eliminó un libro, false si no se encontró.
     *
     * @param titulo título del libro a eliminar
     * @return true si se eliminó, false si no
     */
    public boolean eliminarLibroPorTitulo(String titulo) {
        if (titulo == null) return false;
        // Iteramos con índice para poder remover de forma segura
        for (int i = 0; i < libros.size(); i++) {
            if (titulo.equals(libros.get(i).getTitulo())) {
                libros.remove(i);
                return true; // eliminamos sólo la primera coincidencia
            }
        }
        return false;
    }

    /**
     * Devuelve una copia de la lista de libros actual.
     * Esto protege la lista interna de modificaciones externas.
     *
     * @return copia de la lista de libros
     */
    public List<Libro> getLibros() {
        return new ArrayList<>(libros);
    }
}
```

---

## 📌 `Ejercicio13Test.java`

```java
package com.docencia.composicion.ejercicio13;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 13 (Biblioteca y Libro).
 */
public class Ejercicio13Test {

    @Test
    void testAgregarBuscarEliminar() {
        Biblioteca b = new Biblioteca();

        Libro l1 = new Libro("Java para todos", "Ana López", 2018);
        Libro l2 = new Libro("Algoritmos en Java", "Pedro Ruiz", 2015);
        Libro l3 = new Libro("Programación avanzada", "Ana López", 2020);

        // Agregamos libros a la biblioteca
        b.agregarLibro(l1);
        b.agregarLibro(l2);
        b.agregarLibro(l3);

        // Buscar por autor "Ana López" debería devolver l1 y l3, en ese orden.
        List<Libro> anaLibros = b.buscarPorAutor("Ana López");
        assertEquals(2, anaLibros.size());
        assertEquals("Java para todos", anaLibros.get(0).getTitulo());
        assertEquals("Programación avanzada", anaLibros.get(1).getTitulo());

        // Eliminar por título: eliminar "Algoritmos en Java"
        boolean eliminado = b.eliminarLibroPorTitulo("Algoritmos en Java");
        assertTrue(eliminado);

        // Verificamos que la lista interna ya no contiene ese título
        List<Libro> todos = b.getLibros();
        assertEquals(2, todos.size());
        assertFalse(todos.stream().anyMatch(x -> "Algoritmos en Java".equals(x.getTitulo())));

        // Intentar eliminar un título inexistente devuelve false
        assertFalse(b.eliminarLibroPorTitulo("No existe"));
    }
}
```

---

# ✅ **EJERCICIO 14 – COMPOSICIÓN: Universidad, Facultad y Estudiante**

**Paquete:** `com.docencia.composicion.ejercicio14`
**Objetivo:** diseñar `Estudiante`, `Facultad` y `Universidad` con métodos para agregar estudiantes, obtener todos los estudiantes y buscar por id.

---

## 📌 `Estudiante.java`

```java
package com.docencia.composicion.ejercicio14;

/**
 * Clase Estudiante: representa a un estudiante con id y nombre.
 */
public class Estudiante {

    // Identificador único del estudiante (por ejemplo "A12345")
    private final String id;

    // Nombre del estudiante
    private final String nombre;

    /**
     * Constructor simple.
     *
     * @param id     identificador único (no null recomendado)
     * @param nombre nombre del estudiante
     */
    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}
```

---

## 📌 `Facultad.java`

```java
package com.docencia.composicion.ejercicio14;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase Facultad: contiene una lista de estudiantes.
 * Demuestra composición: la Facultad TIENE Estudiantes.
 */
public class Facultad {

    // Nombre de la facultad (por ejemplo "Ingeniería")
    private final String nombre;

    // Lista interna de estudiantes
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public Facultad(String nombre) {
        this.nombre = nombre;
    }

    // Getter del nombre
    public String getNombre() { return nombre; }

    // Agregar estudiante (si el argumento no es null)
    public void agregarEstudiante(Estudiante e) {
        if (e == null) return;
        estudiantes.add(e);
    }

    // Devuelve copia de la lista de estudiantes
    public List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    /**
     * Busca un estudiante por id en esta facultad.
     * Devuelve Optional.empty() si no lo encuentra.
     */
    public Optional<Estudiante> buscarPorId(String id) {
        if (id == null) return Optional.empty();
        for (Estudiante e : estudiantes) {
            if (id.equals(e.getId())) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }
}
```

---

## 📌 `Universidad.java`

```java
package com.docencia.composicion.ejercicio14;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase Universidad: contiene múltiples facultades.
 * Ofrece utilidades para obtener todos los estudiantes y buscar por id en la universidad completa.
 */
public class Universidad {

    // Nombre de la universidad
    private final String nombre;

    // Lista de facultades (composición)
    private final List<Facultad> facultades = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    // Agrega una facultad (si no es null)
    public void agregarFacultad(Facultad f) {
        if (f == null) return;
        facultades.add(f);
    }

    /**
     * Devuelve una lista con todos los estudiantes de todas las facultades.
     * Se devuelve una nueva lista con copias (referencias) para no exponer estructuras internas.
     */
    public List<Estudiante> obtenerTodosEstudiantes() {
        List<Estudiante> resultado = new ArrayList<>();
        for (Facultad f : facultades) {
            resultado.addAll(f.getEstudiantes());
        }
        return resultado;
    }

    /**
     * Busca un estudiante por id en todas las facultades y devuelve el primer match.
     * Usa Optional para expresar la posible ausencia del estudiante.
     */
    public Optional<Estudiante> buscarEstudiantePorId(String id) {
        if (id == null) return Optional.empty();
        for (Facultad f : facultades) {
            Optional<Estudiante> encontrado = f.buscarPorId(id);
            if (encontrado.isPresent()) return encontrado;
        }
        return Optional.empty();
    }
}
```

---

## 📌 `Ejercicio14Test.java`

```java
package com.docencia.composicion.ejercicio14;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 14: Universidad, Facultad y Estudiante.
 */
public class Ejercicio14Test {

    @Test
    void testUniversidadFacultadEstudiante() {
        // Crear estudiantes
        Estudiante e1 = new Estudiante("S001", "María");
        Estudiante e2 = new Estudiante("S002", "José");
        Estudiante e3 = new Estudiante("S003", "Lucía");

        // Crear facultades y añadir estudiantes
        Facultad f1 = new Facultad("Ciencias");
        Facultad f2 = new Facultad("Letras");

        f1.agregarEstudiante(e1);
        f1.agregarEstudiante(e2);
        f2.agregarEstudiante(e3);

        // Crear universidad y añadir facultades
        Universidad u = new Universidad("UniversidadX");
        u.agregarFacultad(f1);
        u.agregarFacultad(f2);

        // Obtener todos los estudiantes: debe contener e1,e2,e3
        List<Estudiante> todos = u.obtenerTodosEstudiantes();
        assertEquals(3, todos.size());

        // Buscar estudiante por id existente
        Optional<Estudiante> buscado = u.buscarEstudiantePorId("S002");
        assertTrue(buscado.isPresent());
        assertEquals("José", buscado.get().getNombre());

        // Buscar id inexistente
        assertTrue(u.buscarEstudiantePorId("NO-EXISTE").isEmpty());
    }
}
```

---

# ✅ **EJERCICIO 15 – COMPOSICIÓN: Carrito de compra y Producto**

**Paquete:** `com.docencia.composicion.ejercicio15`
**Objetivo:** diseñar `Producto` (id, nombre, precio) y `Carrito` (lista de productos) con operaciones: agregar, eliminar por id, calcular total, contar por nombre.

---

## 📌 `Producto.java`

```java
package com.docencia.composicion.ejercicio15;

/**
 * Clase Producto: representa un producto simple con id, nombre y precio.
 *
 * Comentarios línea a línea para comprender el diseño.
 */
public class Producto {

    // Identificador único del producto (por ejemplo "P001")
    private final String id;

    // Nombre del producto (por ejemplo "Manzana")
    private final String nombre;

    // Precio unitario del producto (double para permitir decimales)
    private final double precio;

    /**
     * Constructor que inicializa todos los campos.
     *
     * @param id     identificador del producto (no null recomendado)
     * @param nombre nombre del producto
     * @param precio precio unitario (>= 0)
     */
    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters (inmutabilidad: solo getters, campos finales)
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        // Representación útil para debug
        return id + " - " + nombre + " : " + precio;
    }
}
```

---

## 📌 `Carrito.java`

```java
package com.docencia.composicion.ejercicio15;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Carrito: contiene una lista de productos y operaciones típicas:
 * - agregar producto
 * - eliminar producto por id
 * - calcular total
 * - contar productos por nombre
 *
 * Comentarios en cada parte para explicar decisiones.
 */
public class Carrito {

    // Lista interna que contiene los productos añadidos al carrito.
    // Se mantiene privada para preservar encapsulación.
    private final List<Producto> productos = new ArrayList<>();

    /**
     * Agrega un producto al carrito.
     * Si el producto es null, no hace nada.
     *
     * @param p producto a agregar
     */
    public void agregarProducto(Producto p) {
        if (p == null) return;
        productos.add(p);
    }

    /**
     * Elimina el primer producto cuyo id coincida con el id dado.
     * Devuelve true si se eliminó algún producto, false si no se encontró.
     *
     * @param id identificador del producto a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    public boolean eliminarProductoPorId(String id) {
        if (id == null) return false;
        // Iteramos por índice para poder eliminar de forma segura
        for (int i = 0; i < productos.size(); i++) {
            if (id.equals(productos.get(i).getId())) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Calcula el total sumando los precios de todos los productos.
     *
     * @return total del carrito
     */
    public double calcularTotal() {
        double total = 0.0;
        for (Producto p : productos) {
            // asumimos precios válidos; no comprobamos NaN/Inf para simplicidad
            total += p.getPrecio();
        }
        return total;
    }

    /**
     * Cuenta cuántos productos en el carrito tienen exactamente el nombre dado.
     *
     * @param nombre nombre a comparar
     * @return cantidad de productos con ese nombre
     */
    public long contarPorNombre(String nombre) {
        if (nombre == null) return 0;
        long contador = 0;
        for (Producto p : productos) {
            if (nombre.equals(p.getNombre())) contador++;
        }
        return contador;
    }

    /**
     * Devuelve una copia de la lista de productos (para no exponer la lista interna).
     *
     * @return copia de los productos
     */
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }
}
```

---

## 📌 `Ejercicio15Test.java`

```java
package com.docencia.composicion.ejercicio15;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

/**
 * Tests para Ejercicio 15 - Carrito y Producto.
 */
public class Ejercicio15Test {

    @Test
    void testCarritoOperacionesBasicas() {
        Producto p1 = new Producto("P1", "Manzana", 0.5);
        Producto p2 = new Producto("P2", "Pan", 1.2);
        Producto p3 = new Producto("P3", "Manzana", 0.5);

        Carrito c = new Carrito();

        // Agregar productos
        c.agregarProducto(p1);
        c.agregarProducto(p2);
        c.agregarProducto(p3);

        // Total esperado = 0.5 + 1.2 + 0.5 = 2.2
        assertEquals(2.2, c.calcularTotal(), 1e-9);

        // Contar por nombre "Manzana" debe ser 2
        assertEquals(2, c.contarPorNombre("Manzana"));

        // Eliminar por id P2 (Pan)
        assertTrue(c.eliminarProductoPorId("P2"));

        // Ahora total = 0.5 + 0.5 = 1.0
        assertEquals(1.0, c.calcularTotal(), 1e-9);

        // Eliminar id inexistente devuelve false
        assertFalse(c.eliminarProductoPorId("NO-EXISTE"));

        // getProductos devuelve copia (modificar la copia no afecta al carrito)
        List<Producto> copia = c.getProductos();
        int tamAntes = copia.size();
        copia.clear();
        assertEquals(tamAntes, c.getProductos().size());
    }
}
```

---

# ✅ **EJERCICIO 16 – COMPOSICIÓN: Agenda de Contactos con Teléfonos**

**Paquete:** `com.docencia.composicion.ejercicio16`
**Objetivo:** diseñar `Telefono`, `Contacto`, `Agenda` con métodos: añadir teléfono, borrar por tipo, buscar por nombre/número.

---

## 📌 `Telefono.java`

```java
package com.docencia.composicion.ejercicio16;

/**
 * Clase Telefono: representa un teléfono con tipo (movil, casa...) y número.
 */
public class Telefono {

    // Tipo del teléfono, por ejemplo "movil", "casa"
    private final String tipo;

    // Número de teléfono (almacenado como String por si contiene prefijos)
    private final String numero;

    public Telefono(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }

    public String getTipo() { return tipo; }
    public String getNumero() { return numero; }

    @Override
    public String toString() {
        return tipo + ": " + numero;
    }
}
```

---

## 📌 `Contacto.java`

```java
package com.docencia.composicion.ejercicio16;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Contacto: representa un contacto con nombre y una lista de teléfonos.
 * Demuestra composición: Contacto TIENE Teléfonos.
 */
public class Contacto {

    // Nombre del contacto
    private final String nombre;

    // Lista interna de teléfonos
    private final List<Telefono> telefonos = new ArrayList<>();

    public Contacto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    /**
     * Devuelve una copia de la lista de teléfonos para no exponer la interna.
     */
    public List<Telefono> getTelefonos() {
        return new ArrayList<>(telefonos);
    }

    /**
     * Añade un teléfono al contacto (si no es null).
     *
     * @param t teléfono a añadir
     */
    public void addTelefono(Telefono t) {
        if (t == null) return;
        telefonos.add(t);
    }

    /**
     * Borra todos los teléfonos cuyo tipo coincide con el tipo dado.
     * Si tipo == null, borra los teléfonos cuyo tipo sea null.
     *
     * @param tipo tipo a eliminar
     */
    public void borrarTelefonosPorTipo(String tipo) {
        // Usamos removeIf con la condición adecuada
        telefonos.removeIf(t -> tipo == null ? t.getTipo() == null : tipo.equals(t.getTipo()));
    }

    /**
     * Comprueba si el contacto tiene el número proporcionado.
     *
     * @param numero número a buscar
     * @return true si lo contiene
     */
    public boolean tieneNumero(String numero) {
        if (numero == null) return false;
        for (Telefono t : telefonos) {
            if (numero.equals(t.getNumero())) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre + " (" + telefonos.size() + " teléfonos)";
    }
}
```

---

## 📌 `Agenda.java`

```java
package com.docencia.composicion.ejercicio16;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase Agenda: contiene una lista de contactos y operaciones de búsqueda.
 */
public class Agenda {

    // Lista interna de contactos
    private final List<Contacto> contactos = new ArrayList<>();

    /**
     * Añade un contacto a la agenda (si no es null).
     *
     * @param c contacto a añadir
     */
    public void agregarContacto(Contacto c) {
        if (c == null) return;
        contactos.add(c);
    }

    /**
     * Busca un contacto por nombre (coincidencia exacta) y devuelve Optional.
     *
     * @param nombre nombre a buscar
     * @return Optional<Contacto> con el primer match o empty si no existe
     */
    public Optional<Contacto> buscarPorNombre(String nombre) {
        if (nombre == null) return Optional.empty();
        for (Contacto c : contactos) {
            if (nombre.equals(c.getNombre())) return Optional.of(c);
        }
        return Optional.empty();
    }

    /**
     * Busca un contacto que tenga el número dado (busca entre los teléfonos de cada contacto).
     *
     * @param numero número buscado
     * @return Optional<Contacto> si se encuentra
     */
    public Optional<Contacto> buscarPorNumero(String numero) {
        if (numero == null) return Optional.empty();
        for (Contacto c : contactos) {
            if (c.tieneNumero(numero)) return Optional.of(c);
        }
        return Optional.empty();
    }

    /**
     * Devuelve copia de la lista de contactos.
     */
    public List<Contacto> getContactos() {
        return new ArrayList<>(contactos);
    }
}
```

---

## 📌 `Ejercicio16Test.java`

```java
package com.docencia.composicion.ejercicio16;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 16 - Agenda, Contacto y Telefono.
 */
public class Ejercicio16Test {

    @Test
    void testAgendaContactoTelefono() {
        // Creamos contactos y teléfonos
        Contacto c1 = new Contacto("Mario");
        c1.addTelefono(new Telefono("movil", "600111222"));
        c1.addTelefono(new Telefono("casa", "922333444"));

        Contacto c2 = new Contacto("Laura");
        c2.addTelefono(new Telefono("movil", "600999888"));

        Agenda agenda = new Agenda();
        agenda.agregarContacto(c1);
        agenda.agregarContacto(c2);

        // Buscar por nombre
        Optional<Contacto> buscado = agenda.buscarPorNombre("Mario");
        assertTrue(buscado.isPresent());
        assertEquals("Mario", buscado.get().getNombre());

        // Buscar por número
        Optional<Contacto> porNumero = agenda.buscarPorNumero("600999888");
        assertTrue(porNumero.isPresent());
        assertEquals("Laura", porNumero.get().getNombre());

        // Borrar teléfonos por tipo
        c1.borrarTelefonosPorTipo("casa");
        assertFalse(c1.tieneNumero("922333444"));

        // Buscar número que no existe debe devolver empty
        assertTrue(agenda.buscarPorNumero("000000").isEmpty());
    }
}
```

---

# ✅ **EJERCICIO 17 – COMPOSICIÓN: Empresa y Empleado**

**Paquete:** `com.docencia.composicion.ejercicio17`
**Objetivo:** diseñar `Empleado` (id, nombre, salario) y `Empresa` (lista de empleados) con métodos para agregar, calcular salario total y buscar por id.

-----

## 📌 `Empleado.java`

```java
package com.docencia.composicion.ejercicio17;

/**
 * Clase Empleado: representa a un trabajador con id, nombre y salario.
 * El uso de 'final' promueve inmutabilidad, práctica recomendada.
 */
public class Empleado {

    // Identificador único del empleado
    private final String id;

    // Nombre completo del empleado
    private final String nombre;

    // Salario bruto anual (usamos double para el salario)
    private final double salario;

    /**
     * Constructor completo del Empleado.
     *
     * @param id      identificador único
     * @param nombre  nombre del empleado
     * @param salario salario anual
     */
    public Empleado(String id, String nombre, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    // Getters
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }

    @Override
    public String toString() {
        // Representación amigable para debug y visualización
        return "ID: " + id + ", Nombre: " + nombre + ", Salario: " + salario;
    }
}
```

-----

## 📌 `Empresa.java`

```java
package com.docencia.composicion.ejercicio17;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase Empresa: demuestra composición. La Empresa TIENE Empleados.
 * Ofrece métodos de gestión básicos.
 */
public class Empresa {

    // Nombre de la empresa (campo simple)
    private final String nombre;

    // Composición: la lista de empleados. Se mantiene privada para encapsulación.
    private final List<Empleado> empleados = new ArrayList<>();

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    /**
     * Agrega un empleado a la empresa.
     * Realiza validación defensiva (no permite agregar null).
     *
     * @param e empleado a agregar
     */
    public void agregarEmpleado(Empleado e) {
        if (e == null) return;
        empleados.add(e);
    }

    /**
     * Calcula la suma total de los salarios de todos los empleados.
     *
     * @return salario total de la empresa
     */
    public double calcularSalarioTotal() {
        double total = 0.0;
        for (Empleado e : empleados) {
            total += e.getSalario();
        }
        return total;
    }

    /**
     * Busca un empleado por su identificador único.
     * Usa Optional para manejar el caso de no encontrar el empleado.
     *
     * @param id identificador a buscar
     * @return Optional<Empleado> con el empleado encontrado o Optional.empty()
     */
    public Optional<Empleado> buscarPorId(String id) {
        if (id == null) return Optional.empty();
        for (Empleado e : empleados) {
            // Compara la ID de forma exacta
            if (id.equals(e.getId())) {
                return Optional.of(e);
            }
        }
        return Optional.empty();
    }

    /**
     * Devuelve una copia de la lista de empleados.
     * Esto protege la lista interna de modificaciones externas.
     *
     * @return copia de la lista de empleados
     */
    public List<Empleado> getEmpleados() {
        return new ArrayList<>(empleados);
    }
}
```

-----

## 📌 `Ejercicio17Test.java`

```java
package com.docencia.composicion.ejercicio17;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 17 (Empresa y Empleado).
 */
public class Ejercicio17Test {

    @Test
    void testEmpresaEmpleadoOperaciones() {
        // Creamos empleados
        Empleado e1 = new Empleado("E101", "Alice", 50000.0);
        Empleado e2 = new Empleado("E102", "Bob", 65000.0);

        // Creamos empresa y agregamos empleados
        Empresa miEmpresa = new Empresa("TechSolutions");
        miEmpresa.agregarEmpleado(e1);
        miEmpresa.agregarEmpleado(e2);

        // 1. Calcular Salario Total: 50000.0 + 65000.0 = 115000.0
        assertEquals(115000.0, miEmpresa.calcularSalarioTotal(), 1e-9);

        // 2. Buscar por ID existente
        Optional<Empleado> buscado1 = miEmpresa.buscarPorId("E101");
        assertTrue(buscado1.isPresent());
        assertEquals("Alice", buscado1.get().getNombre());

        // 3. Buscar por ID inexistente
        Optional<Empleado> buscado2 = miEmpresa.buscarPorId("E999");
        assertTrue(buscado2.isEmpty());

        // 4. Verificar tamaño de la lista de empleados
        assertEquals(2, miEmpresa.getEmpleados().size());
    }
}
```

-----

# ✅ **EJERCICIO 18 – COMPOSICIÓN: Pedido y LineaPedido**

**Paquete:** `com.docencia.composicion.ejercicio18`
**Objetivo:** diseñar `LineaPedido` (producto, cantidad, precioUnitario) y `Pedido` (lista de líneas) con métodos para agregar línea y calcular el total del pedido.

-----

## 📌 `LineaPedido.java`

```java
package com.docencia.composicion.ejercicio18;

/**
 * Clase LineaPedido: representa un item dentro de un pedido.
 * Contiene la información del producto, la cantidad y el precio en el momento del pedido.
 */
public class LineaPedido {

    // Nombre del producto en esta línea
    private final String producto;

    // Cantidad solicitada (entero)
    private final int cantidad;

    // Precio unitario al momento de realizar el pedido (double)
    private final double precioUnitario;

    /**
     * Constructor completo.
     *
     * @param producto nombre del producto
     * @param cantidad cantidad (debe ser > 0)
     * @param precioUnitario precio por unidad
     */
    public LineaPedido(String producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Getters
    public String getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }

    /**
     * Calcula el subtotal de esta línea (Cantidad * Precio Unitario).
     *
     * @return subtotal de la línea
     */
    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return producto + " x" + cantidad + " @ " + precioUnitario + " = " + calcularSubtotal();
    }
}
```

-----

## 📌 `Pedido.java`

```java
package com.docencia.composicion.ejercicio18;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Pedido: demuestra composición. Un Pedido TIENE LineasPedido.
 * Centraliza la gestión de las líneas y el cálculo total.
 */
public class Pedido {

    // Identificador único del pedido (opcional)
    private final String idPedido;

    // Lista interna de LineasPedido. Composición.
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdPedido() { return idPedido; }

    /**
     * Agrega una LineaPedido al pedido.
     * Realiza validación defensiva.
     *
     * @param linea LineaPedido a agregar
     */
    public void agregarLinea(LineaPedido linea) {
        if (linea == null) return;
        lineas.add(linea);
    }

    /**
     * Calcula el total sumando los subtotales de todas las líneas.
     *
     * @return total del pedido
     */
    public double calcularTotal() {
        double total = 0.0;
        for (LineaPedido linea : lineas) {
            total += linea.calcularSubtotal();
        }
        return total;
    }

    /**
     * Devuelve una copia de la lista de líneas del pedido.
     *
     * @return copia de la lista de LineasPedido
     */
    public List<LineaPedido> getLineas() {
        return new ArrayList<>(lineas);
    }
}
```

-----

## 📌 `Ejercicio18Test.java`

```java
package com.docencia.composicion.ejercicio18;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 18 (Pedido y LineaPedido).
 */
public class Ejercicio18Test {

    @Test
    void testPedidoCalculoTotal() {
        // Creamos un pedido
        Pedido p = new Pedido("P987");

        // Creamos líneas de pedido
        // Línea 1: 2 x "Bolígrafo" @ 1.50 -> Subtotal = 3.00
        LineaPedido l1 = new LineaPedido("Bolígrafo", 2, 1.50);

        // Línea 2: 5 x "Cuaderno" @ 4.00 -> Subtotal = 20.00
        LineaPedido l2 = new LineaPedido("Cuaderno", 5, 4.00);

        // Agregamos las líneas al pedido
        p.agregarLinea(l1);
        p.agregarLinea(l2);

        // El subtotal de l1 es 3.00
        assertEquals(3.00, l1.calcularSubtotal(), 1e-9);

        // El subtotal de l2 es 20.00
        assertEquals(20.00, l2.calcularSubtotal(), 1e-9);

        // El total esperado del pedido es 3.00 + 20.00 = 23.00
        assertEquals(23.00, p.calcularTotal(), 1e-9);

        // Agregamos una línea más
        // Línea 3: 1 x "Goma" @ 0.50 -> Subtotal = 0.50
        p.agregarLinea(new LineaPedido("Goma", 1, 0.50));

        // Nuevo total: 23.00 + 0.50 = 23.50
        assertEquals(23.50, p.calcularTotal(), 1e-9);

        // Verificamos que hay 3 líneas
        assertEquals(3, p.getLineas().size());
    }
}
```

---

# ✅ **EJERCICIO 19 – COMPOSICIÓN: Tienda y Sección**

**Paquete:** `com.docencia.composicion.ejercicio19`
**Objetivo:** diseñar `Seccion` (nombre, lista de productos) y `Tienda` (lista de secciones) con métodos para agregar secciones y obtener la lista consolidada de todos los productos.

-----

## 📌 `Producto.java`

*Reutilizamos una clase `Producto` simple para este ejercicio, definiéndola para consistencia del paquete.*

```java
package com.docencia.composicion.ejercicio19;

/**
 * Clase Producto simple (reutilizada de ejercicios anteriores).
 */
public class Producto {

    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return nombre + " (" + precio + ")";
    }
}
```

-----

## 📌 `Seccion.java`

```java
package com.docencia.composicion.ejercicio19;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Seccion: demuestra composición. Una Sección TIENE Productos.
 * Agrupa productos por nombre de sección (e.g., "Alimentación").
 */
public class Seccion {

    // Nombre de la sección (e.g., "Electrónica")
    private final String nombre;

    // Lista de productos contenidos en esta sección
    private final List<Producto> productos = new ArrayList<>();

    public Seccion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    /**
     * Agrega un producto a esta sección (si no es null).
     *
     * @param p producto a agregar
     */
    public void agregarProducto(Producto p) {
        if (p == null) return;
        productos.add(p);
    }

    /**
     * Devuelve una copia de la lista de productos de esta sección.
     *
     * @return copia de los productos de la sección
     */
    public List<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    @Override
    public String toString() {
        return nombre + " (" + productos.size() + " productos)";
    }
}
```

-----

## 📌 `Tienda.java`

```java
package com.docencia.composicion.ejercicio19;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Tienda: demuestra composición anidada. La Tienda TIENE Secciones,
 * y cada Sección TIENE Productos.
 */
public class Tienda {

    // Nombre de la tienda
    private final String nombre;

    // Lista de secciones que componen la tienda
    private final List<Seccion> secciones = new ArrayList<>();

    public Tienda(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    /**
     * Agrega una sección a la tienda (si no es null).
     *
     * @param s sección a agregar
     */
    public void agregarSeccion(Seccion s) {
        if (s == null) return;
        secciones.add(s);
    }

    /**
     * Obtiene una lista consolidada con TODOS los productos
     * de TODAS las secciones de la tienda.
     *
     * @return lista de todos los productos
     */
    public List<Producto> obtenerTodosProductos() {
        List<Producto> todos = new ArrayList<>();
        // Iteramos sobre las secciones
        for (Seccion s : secciones) {
            // Agregamos todos los productos de cada sección a la lista consolidada
            todos.addAll(s.getProductos());
        }
        return todos;
    }

    /**
     * Devuelve una copia de la lista de secciones (para proteger la interna).
     */
    public List<Seccion> getSecciones() {
        return new ArrayList<>(secciones);
    }
}
```

-----

## 📌 `Ejercicio19Test.java`

```java
package com.docencia.composicion.ejercicio19;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 19 (Tienda y Sección).
 */
public class Ejercicio19Test {

    @Test
    void testTiendaSeccionConsolidacion() {
        // 1. Crear Productos
        Producto p1 = new Producto("Leche", 1.0);
        Producto p2 = new Producto("Pan", 1.5);
        Producto p3 = new Producto("TV 4K", 500.0);
        Producto p4 = new Producto("Cargador USB", 15.0);

        // 2. Crear Secciones y agregar productos
        Seccion s1 = new Seccion("Alimentacion");
        s1.agregarProducto(p1);
        s1.agregarProducto(p2);
        assertEquals(2, s1.getProductos().size());

        Seccion s2 = new Seccion("Electronica");
        s2.agregarProducto(p3);
        s2.agregarProducto(p4);
        assertEquals(2, s2.getProductos().size());

        // 3. Crear Tienda y agregar secciones
        Tienda t = new Tienda("SuperCentro");
        t.agregarSeccion(s1);
        t.agregarSeccion(s2);

        // 4. Consolidar todos los productos
        List<Producto> todos = t.obtenerTodosProductos();
        // Esperamos 4 productos en total (2 de S1 + 2 de S2)
        assertEquals(4, todos.size());

        // 5. Verificar que contiene un producto de cada sección
        assertTrue(todos.stream().anyMatch(p -> p.getNombre().equals("Leche")));
        assertTrue(todos.stream().anyMatch(p -> p.getNombre().equals("TV 4K")));
    }
}
```

-----

# ✅ **EJERCICIO 20 – COMPOSICIÓN: Avion y Alas**

**Paquete:** `com.docencia.composicion.ejercicio20`
**Objetivo:** diseñar `Ala` (largo, motor) y `Avion` (dos alas, modelo) y métodos para encender/apagar ambos motores.

-----

## 📌 `Motor.java`

*Reutilizamos la clase `Motor` del Ejercicio 12 para representar el motor de cada ala.*

```java
package com.docencia.composicion.ejercicio20;

/**
 * Clase Motor simple (reutilizada del Ejercicio 12).
 */
public class Motor {

    private boolean encendido;

    public Motor() {
        this.encendido = false;
    }

    public void encender() {
        encendido = true;
    }

    public void apagar() {
        encendido = false;
    }

    public boolean isEncendido() {
        return encendido;
    }

    @Override
    public String toString() {
        return encendido ? "Motor encendido" : "Motor apagado";
    }
}
```

-----

## 📌 `Ala.java`

```java
package com.docencia.composicion.ejercicio20;

/**
 * Clase Ala: demuestra composición. Un Ala TIENE un Motor.
 * Además tiene un atributo simple para su longitud.
 */
public class Ala {

    // Longitud del ala en metros
    private final double longitud;

    // Composición: cada ala tiene su propio motor
    private final Motor motor;

    public Ala(double longitud) {
        this.longitud = longitud;
        // Composición fuerte: se crea el Motor dentro del constructor del Ala
        this.motor = new Motor();
    }

    public double getLongitud() { return longitud; }
    public Motor getMotor() { return motor; }

    /**
     * Enciende el motor de esta ala.
     */
    public void encenderMotor() {
        motor.encender();
    }

    /**
     * Apaga el motor de esta ala.
     */
    public void apagarMotor() {
        motor.apagar();
    }

    /**
     * Comprueba si el motor del ala está encendido.
     */
    public boolean motorEncendido() {
        return motor.isEncendido();
    }

    @Override
    public String toString() {
        return "Ala (" + longitud + "m) - " + motor.toString();
    }
}
```

-----

## 📌 `Avion.java`

```java
package com.docencia.composicion.ejercicio20;

/**
 * Clase Avion: demuestra composición. Un Avión TIENE dos Alas.
 * Es un ejemplo de composición donde el contenedor tiene múltiples instancias
 * de un componente.
 */
public class Avion {

    // Nombre o modelo del avión
    private final String modelo;

    // Composición: Ala izquierda
    private final Ala alaIzquierda;

    // Composición: Ala derecha
    private final Ala alaDerecha;

    /**
     * Constructor. Crea el avión y sus dos alas con una longitud dada.
     */
    public Avion(String modelo, double longitudAla) {
        this.modelo = modelo;
        // Las alas se crean en el constructor del Avión, demostrando composición fuerte
        this.alaIzquierda = new Ala(longitudAla);
        this.alaDerecha = new Ala(longitudAla);
    }

    public String getModelo() { return modelo; }
    public Ala getAlaIzquierda() { return alaIzquierda; }
    public Ala getAlaDerecha() { return alaDerecha; }

    /**
     * Enciende ambos motores (izquierdo y derecho).
     */
    public void encenderMotores() {
        alaIzquierda.encenderMotor();
        alaDerecha.encenderMotor();
    }

    /**
     * Apaga ambos motores (izquierdo y derecho).
     */
    public void apagarMotores() {
        alaIzquierda.apagarMotor();
        alaDerecha.apagarMotor();
    }

    /**
     * Comprueba si ambos motores están encendidos.
     *
     * @return true si ambos motores están ON
     */
    public boolean motoresEncendidos() {
        return alaIzquierda.motorEncendido() && alaDerecha.motorEncendido();
    }

    @Override
    public String toString() {
        return modelo + " [Izquierda: " + alaIzquierda + ", Derecha: " + alaDerecha + "]";
    }
}
```

-----

## 📌 `Ejercicio20Test.java`

```java
package com.docencia.composicion.ejercicio20;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 20 (Avión y Alas).
 */
public class Ejercicio20Test {

    @Test
    void testAvionControlMotores() {
        // Crear un avión con alas de 15.5m
        Avion a = new Avion("Boeing 737", 15.5);

        // Inicialmente, los motores deben estar apagados
        assertFalse(a.getAlaIzquierda().motorEncendido());
        assertFalse(a.getAlaDerecha().motorEncendido());
        assertFalse(a.motoresEncendidos());

        // Encender ambos motores
        a.encenderMotores();
        assertTrue(a.getAlaIzquierda().motorEncendido());
        assertTrue(a.getAlaDerecha().motorEncendido());
        assertTrue(a.motoresEncendidos());

        // Apagar solo el motor derecho directamente
        a.getAlaDerecha().apagarMotor();
        assertTrue(a.getAlaIzquierda().motorEncendido());
        assertFalse(a.getAlaDerecha().motorEncendido());
        assertFalse(a.motoresEncendidos()); // Ambos deben estar ON

        // Apagar ambos usando el método del avión
        a.apagarMotores();
        assertFalse(a.motoresEncendidos());
    }
}
```
-----

# ✅ **EJERCICIO 21 – COMPOSICIÓN: Vuelo y Pasajero**

**Paquete:** `com.docencia.composicion.ejercicio21`
**Objetivo:** diseñar `Pasajero` (nombre, asiento) y `Vuelo` (lista de pasajeros) con métodos para agregar pasajero, buscar por asiento y contar pasajeros.

-----

## 📌 `Pasajero.java`

```java
package com.docencia.composicion.ejercicio21;

/**
 * Clase Pasajero: representa a una persona con su nombre y número de asiento asignado.
 */
public class Pasajero {

    // Nombre completo del pasajero
    private final String nombre;

    // Número de asiento (ej. "15A", "22B")
    private final String asiento;

    /**
     * Constructor que inicializa los datos del pasajero.
     *
     * @param nombre nombre del pasajero
     * @param asiento número de asiento
     */
    public Pasajero(String nombre, String asiento) {
        this.nombre = nombre;
        this.asiento = asiento;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getAsiento() { return asiento; }

    @Override
    public String toString() {
        return nombre + " (Asiento: " + asiento + ")";
    }
}
```

-----

## 📌 `Vuelo.java`

```java
package com.docencia.composicion.ejercicio21;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Clase Vuelo: demuestra composición. Un Vuelo TIENE Pasajeros.
 * Centraliza la gestión de los pasajeros a bordo.
 */
public class Vuelo {

    // Identificador del vuelo (ej. "IB3138")
    private final String numeroVuelo;

    // Lista interna de pasajeros a bordo (composición)
    private final List<Pasajero> pasajeros = new ArrayList<>();

    public Vuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getNumeroVuelo() { return numeroVuelo; }

    /**
     * Agrega un pasajero al vuelo.
     * Realiza validación defensiva.
     *
     * @param p pasajero a agregar
     */
    public void agregarPasajero(Pasajero p) {
        if (p == null) return;
        pasajeros.add(p);
    }

    /**
     * Busca un pasajero por el número de asiento (coincidencia exacta).
     * Usa Optional para manejar la ausencia de un pasajero en ese asiento.
     *
     * @param asiento número de asiento a buscar
     * @return Optional<Pasajero> si se encuentra, o Optional.empty()
     */
    public Optional<Pasajero> buscarPorAsiento(String asiento) {
        if (asiento == null) return Optional.empty();
        for (Pasajero p : pasajeros) {
            if (asiento.equals(p.getAsiento())) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    /**
     * Devuelve el número total de pasajeros en el vuelo.
     *
     * @return cantidad de pasajeros
     */
    public int contarPasajeros() {
        return pasajeros.size();
    }

    /**
     * Devuelve una copia de la lista de pasajeros.
     */
    public List<Pasajero> getPasajeros() {
        return new ArrayList<>(pasajeros);
    }
}
```

-----

## 📌 `Ejercicio21Test.java`

```java
package com.docencia.composicion.ejercicio21;

import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 21 (Vuelo y Pasajero).
 */
public class Ejercicio21Test {

    @Test
    void testVueloGestionPasajeros() {
        // Crear un vuelo
        Vuelo v = new Vuelo("UX1090");

        // Crear pasajeros
        Pasajero p1 = new Pasajero("Daniela", "10A");
        Pasajero p2 = new Pasajero("Ricardo", "25C");

        // Agregar pasajeros
        v.agregarPasajero(p1);
        v.agregarPasajero(p2);

        // 1. Contar pasajeros
        assertEquals(2, v.contarPasajeros());

        // 2. Buscar por asiento existente
        Optional<Pasajero> buscado1 = v.buscarPorAsiento("10A");
        assertTrue(buscado1.isPresent());
        assertEquals("Daniela", buscado1.get().getNombre());

        // 3. Buscar por asiento inexistente
        Optional<Pasajero> buscado2 = v.buscarPorAsiento("15B");
        assertTrue(buscado2.isEmpty());

        // 4. Agregar otro pasajero
        v.agregarPasajero(new Pasajero("Elena", "10B"));
        assertEquals(3, v.contarPasajeros());
    }
}
```

-----

# ✅ **EJERCICIO 22 – COMPOSICIÓN: Archivo y Permisos**

**Paquete:** `com.docencia.composicion.ejercicio22`
**Objetivo:** diseñar `Permisos` (lectura, escritura, ejecución) y `Archivo` (nombre, tamaño, permisos) con métodos para modificar permisos.

-----

## 📌 `Permisos.java`

```java
package com.docencia.composicion.ejercicio22;

/**
 * Clase Permisos: representa los permisos de un archivo (R, W, X).
 * Usamos booleanos para simplicidad.
 */
public class Permisos {

    // Permiso de lectura
    private boolean lectura;

    // Permiso de escritura
    private boolean escritura;

    // Permiso de ejecución
    private boolean ejecucion;

    /**
     * Constructor con parámetros iniciales.
     */
    public Permisos(boolean lectura, boolean escritura, boolean ejecucion) {
        this.lectura = lectura;
        this.escritura = escritura;
        this.ejecucion = ejecucion;
    }

    // Getters
    public boolean isLectura() { return lectura; }
    public boolean isEscritura() { return escritura; }
    public boolean isEjecucion() { return ejecucion; }

    // Setters (permiten modificar los permisos)
    public void setLectura(boolean lectura) { this.lectura = lectura; }
    public void setEscritura(boolean escritura) { this.escritura = escritura; }
    public void setEjecucion(boolean ejecucion) { this.ejecucion = ejecucion; }

    /**
     * Devuelve una cadena legible con los permisos (ej. "rwx", "r-x").
     */
    public String aCadena() {
        return (lectura ? "r" : "-") +
               (escritura ? "w" : "-") +
               (ejecucion ? "x" : "-");
    }

    @Override
    public String toString() {
        return aCadena();
    }
}
```

-----

## 📌 `Archivo.java`

```java
package com.docencia.composicion.ejercicio22;

/**
 * Clase Archivo: demuestra composición. Un Archivo TIENE Permisos.
 * La gestión de la lógica de permisos se delega a la clase Permisos.
 */
public class Archivo {

    // Nombre del archivo
    private final String nombre;

    // Tamaño en bytes
    private final long tamaño;

    // Composición: el archivo tiene un objeto Permisos asociado
    private Permisos permisos;

    /**
     * Constructor.
     *
     * @param nombre nombre del archivo
     * @param tamaño tamaño en bytes
     * @param permisos objeto Permisos iniciales
     */
    public Archivo(String nombre, long tamaño, Permisos permisos) {
        this.nombre = nombre;
        this.tamaño = tamaño;
        // Asignación directa: Composición (si Permisos se creara aquí sería más fuerte)
        this.permisos = permisos;
    }

    public String getNombre() { return nombre; }
    public long getTamaño() { return tamaño; }
    public Permisos getPermisos() { return permisos; } // Exponemos el objeto Permisos

    // Setter para cambiar completamente el objeto Permisos (útil para inmutabilidad)
    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    /**
     * Modifica el permiso de lectura delegando la llamada a la clase Permisos.
     */
    public void modificarLectura(boolean valor) {
        if (permisos != null) {
            permisos.setLectura(valor);
        }
    }

    /**
     * Modifica el permiso de escritura.
     */
    public void modificarEscritura(boolean valor) {
        if (permisos != null) {
            permisos.setEscritura(valor);
        }
    }

    /**
     * Comprueba si se puede ejecutar el archivo.
     */
    public boolean puedeEjecutar() {
        return permisos != null && permisos.isEjecucion();
    }

    @Override
    public String toString() {
        return nombre + " (" + tamaño + " bytes) - Permisos: " +
               (permisos != null ? permisos.aCadena() : "Sin permisos");
    }
}
```

-----

## 📌 `Ejercicio22Test.java`

```java
package com.docencia.composicion.ejercicio22;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 22 (Archivo y Permisos).
 */
public class Ejercicio22Test {

    @Test
    void testArchivoGestionPermisos() {
        // Crear permisos iniciales: r-x (Lectura y Ejecución)
        Permisos pInicial = new Permisos(true, false, true);

        // Crear archivo
        Archivo a = new Archivo("documento.txt", 1024, pInicial);

        // 1. Comprobar estado inicial
        assertTrue(a.getPermisos().isLectura());
        assertFalse(a.getPermisos().isEscritura());
        assertTrue(a.puedeEjecutar());
        assertEquals("r-x", a.getPermisos().aCadena());

        // 2. Modificar permiso de escritura (W) a true
        a.modificarEscritura(true);
        assertTrue(a.getPermisos().isEscritura());
        assertEquals("rwx", a.getPermisos().aCadena());

        // 3. Modificar permiso de lectura (R) a false
        a.modificarLectura(false);
        assertFalse(a.getPermisos().isLectura());
        assertEquals("-wx", a.getPermisos().aCadena());
        
        // 4. Comprobar método delegado
        assertTrue(a.puedeEjecutar());
    }
}
```

---

# ✅ **EJERCICIO 23 – COMPOSICIÓN: Biblioteca y Libro**

**Paquete:** `com.docencia.composicion.ejercicio23`
**Objetivo:** diseñar `Libro` (título, autor) y `Biblioteca` (lista de libros) con métodos para agregar libro, buscar por título y buscar por autor.

-----

## 📌 `Libro.java`

```java
package com.docencia.composicion.ejercicio23;

/**
 * Clase Libro: representa un ítem en la biblioteca.
 * Incluye título y autor.
 */
public class Libro {

    // Título del libro
    private final String titulo;

    // Autor del libro
    private final String autor;

    /**
     * Constructor.
     *
     * @param titulo título del libro
     * @param autor autor del libro
     */
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }

    @Override
    public String toString() {
        return titulo + " - " + autor;
    }
}
```

-----

## 📌 `Biblioteca.java`

```java
package com.docencia.composicion.ejercicio23;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase Biblioteca: demuestra composición. Una Biblioteca TIENE Libros.
 * Proporciona métodos de búsqueda y gestión de su colección.
 */
public class Biblioteca {

    // Nombre de la biblioteca
    private final String nombre;

    // Lista interna de Libros (Composición)
    private final List<Libro> libros = new ArrayList<>();

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    /**
     * Agrega un libro a la colección.
     *
     * @param libro libro a agregar
     */
    public void agregarLibro(Libro libro) {
        if (libro == null) return;
        libros.add(libro);
    }

    /**
     * Busca todos los libros que contengan el título dado (insensible a mayúsculas/minúsculas).
     *
     * @param tituloBuscado parte del título a buscar
     * @return lista de libros que coinciden
     */
    public List<Libro> buscarPorTitulo(String tituloBuscado) {
        if (tituloBuscado == null || tituloBuscado.trim().isEmpty()) {
            return new ArrayList<>();
        }
        final String tituloLower = tituloBuscado.toLowerCase();

        // Usamos Stream API para una búsqueda filtrada
        return libros.stream()
                     // Filtramos por libros cuyo título contenga la cadena buscada
                     .filter(l -> l.getTitulo().toLowerCase().contains(tituloLower))
                     // Recogemos los resultados en una nueva lista
                     .collect(Collectors.toList());
    }

    /**
     * Busca todos los libros que coincidan exactamente con el autor dado
     * (insensible a mayúsculas/minúsculas).
     *
     * @param autorBuscado nombre del autor
     * @return lista de libros de ese autor
     */
    public List<Libro> buscarPorAutor(String autorBuscado) {
        if (autorBuscado == null || autorBuscado.trim().isEmpty()) {
            return new ArrayList<>();
        }
        final String autorLower = autorBuscado.toLowerCase();

        return libros.stream()
                     // Filtramos por autor exacto (ignorando caso)
                     .filter(l -> l.getAutor().toLowerCase().equals(autorLower))
                     .collect(Collectors.toList());
    }

    /**
     * Devuelve una copia de la colección completa de libros.
     */
    public List<Libro> getLibros() {
        return new ArrayList<>(libros);
    }
}
```

-----

## 📌 `Ejercicio23Test.java`

```java
package com.docencia.composicion.ejercicio23;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 23 (Biblioteca y Libro).
 */
public class Ejercicio23Test {

    @Test
    void testBibliotecaBusquedas() {
        // Crear libros
        Libro l1 = new Libro("Cien años de soledad", "Gabriel García Márquez");
        Libro l2 = new Libro("El amor en los tiempos del cólera", "Gabriel García Márquez");
        Libro l3 = new Libro("La casa de los espíritus", "Isabel Allende");

        // Crear biblioteca
        Biblioteca biblio = new Biblioteca("Mi Biblioteca");
        biblio.agregarLibro(l1);
        biblio.agregarLibro(l2);
        biblio.agregarLibro(l3);
        
        assertEquals(3, biblio.getLibros().size());

        // 1. Buscar por título: "años" (debe encontrar solo l1)
        List<Libro> porTitulo1 = biblio.buscarPorTitulo("años");
        assertEquals(1, porTitulo1.size());
        assertEquals("Cien años de soledad", porTitulo1.get(0).getTitulo());

        // 2. Buscar por título: "el" (debe encontrar l1 y l2)
        List<Libro> porTitulo2 = biblio.buscarPorTitulo("el");
        assertEquals(2, porTitulo2.size());
        // Verificamos que ambos autores sean GGM (l1 y l2)
        assertTrue(porTitulo2.stream().allMatch(l -> l.getAutor().equals("Gabriel García Márquez")));

        // 3. Buscar por autor: "gabriel garcía márquez" (insensible a mayúsculas/minúsculas)
        List<Libro> porAutor1 = biblio.buscarPorAutor("gabriel garcía márquez");
        assertEquals(2, porAutor1.size());
        assertTrue(porAutor1.contains(l1));
        assertTrue(porAutor1.contains(l2));

        // 4. Buscar por autor: "Allende" (debe encontrar l3)
        List<Libro> porAutor2 = biblio.buscarPorAutor("Isabel Allende");
        assertEquals(1, porAutor2.size());
        assertTrue(porAutor2.contains(l3));

        // 5. Buscar por autor inexistente
        List<Libro> porAutor3 = biblio.buscarPorAutor("Julio Verne");
        assertTrue(porAutor3.isEmpty());
    }
}
```

-----

# ✅ **EJERCICIO 24 – COMPOSICIÓN: Universidad y Departamento**

**Paquete:** `com.docencia.composicion.ejercicio24`
**Objetivo:** diseñar `Departamento` (nombre, lista de asignaturas) y `Universidad` (nombre, lista de departamentos) con métodos para agregar y consolidar todas las asignaturas.

-----

## 📌 `Asignatura.java`

```java
package com.docencia.composicion.ejercicio24;

/**
 * Clase Asignatura: representa una materia impartida.
 * Incluye nombre y créditos.
 */
public class Asignatura {

    // Nombre de la asignatura (e.g., "Programación Avanzada")
    private final String nombre;

    // Número de créditos (usamos int)
    private final int creditos;

    /**
     * Constructor.
     *
     * @param nombre nombre de la asignatura
     * @param creditos créditos ECTS
     */
    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }

    @Override
    public String toString() {
        return nombre + " (" + creditos + " ECTS)";
    }
}
```

-----

## 📌 `Departamento.java`

```java
package com.docencia.composicion.ejercicio24;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Departamento: demuestra composición. Un Departamento TIENE Asignaturas.
 * Es la unidad organizativa dentro de la Universidad.
 */
public class Departamento {

    // Nombre del departamento (e.g., "Informática")
    private final String nombre;

    // Lista de asignaturas adscritas a este departamento
    private final List<Asignatura> asignaturas = new ArrayList<>();

    public Departamento(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    /**
     * Agrega una asignatura al departamento.
     */
    public void agregarAsignatura(Asignatura a) {
        if (a == null) return;
        asignaturas.add(a);
    }

    /**
     * Devuelve una copia de las asignaturas del departamento.
     */
    public List<Asignatura> getAsignaturas() {
        return new ArrayList<>(asignaturas);
    }

    /**
     * Calcula el total de créditos gestionados por este departamento.
     *
     * @return suma de créditos
     */
    public int calcularTotalCreditos() {
        int total = 0;
        for (Asignatura a : asignaturas) {
            total += a.getCreditos();
        }
        return total;
    }
}
```

-----

## 📌 `Universidad.java`

```java
package com.docencia.composicion.ejercicio24;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Universidad: demuestra composición anidada. La Universidad TIENE Departamentos,
 * y cada Departamento TIENE Asignaturas.
 */
public class Universidad {

    // Nombre de la Universidad
    private final String nombre;

    // Lista de departamentos
    private final List<Departamento> departamentos = new ArrayList<>();

    public Universidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    /**
     * Agrega un departamento a la universidad.
     */
    public void agregarDepartamento(Departamento d) {
        if (d == null) return;
        departamentos.add(d);
    }

    /**
     * Obtiene una lista consolidada con TODAS las asignaturas
     * de TODOS los departamentos de la universidad.
     *
     * @return lista de todas las asignaturas
     */
    public List<Asignatura> obtenerTodasAsignaturas() {
        List<Asignatura> todas = new ArrayList<>();
        // Iteramos sobre los departamentos
        for (Departamento d : departamentos) {
            // Agregamos todas las asignaturas de cada departamento
            todas.addAll(d.getAsignaturas());
        }
        return todas;
    }

    /**
     * Devuelve el total de créditos que se imparten en la universidad.
     */
    public int calcularTotalCreditosUniversidad() {
        int total = 0;
        // Delegamos el cálculo a cada departamento
        for (Departamento d : departamentos) {
            total += d.calcularTotalCreditos();
        }
        return total;
    }

    public List<Departamento> getDepartamentos() {
        return new ArrayList<>(departamentos);
    }
}
```

-----

## 📌 `Ejercicio24Test.java`

```java
package com.docencia.composicion.ejercicio24;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 24 (Universidad y Departamento).
 */
public class Ejercicio24Test {

    @Test
    void testUniversidadDepartamentoConsolidacion() {
        // 1. Crear Asignaturas
        Asignatura a1 = new Asignatura("Cálculo I", 6);
        Asignatura a2 = new Asignatura("Álgebra", 6);
        Asignatura a3 = new Asignatura("Redes", 6);
        Asignatura a4 = new Asignatura("Bases de Datos", 4);

        // 2. Crear Departamentos y agregar asignaturas
        Departamento d1 = new Departamento("Matemáticas");
        d1.agregarAsignatura(a1);
        d1.agregarAsignatura(a2);
        assertEquals(12, d1.calcularTotalCreditos());

        Departamento d2 = new Departamento("Informática");
        d2.agregarAsignatura(a3);
        d2.agregarAsignatura(a4);
        assertEquals(10, d2.calcularTotalCreditos());

        // 3. Crear Universidad y agregar departamentos
        Universidad u = new Universidad("U. Tecnológica");
        u.agregarDepartamento(d1);
        u.agregarDepartamento(d2);

        // 4. Consolidar todas las asignaturas
        List<Asignatura> todas = u.obtenerTodasAsignaturas();
        // 2 asignaturas de D1 + 2 de D2 = 4
        assertEquals(4, todas.size());
        assertTrue(todas.stream().anyMatch(a -> a.getNombre().equals("Bases de Datos")));

        // 5. Calcular el total de créditos de la universidad
        // 12 (D1) + 10 (D2) = 22
        assertEquals(22, u.calcularTotalCreditosUniversidad());
    }
}
```

---

# ✅ **EJERCICIO 25 – HERENCIA/POLIMORFISMO: Figura geométrica**

**Paquete:** `com.docencia.herencia.ejercicio25`
**Objetivo:** diseñar la clase base abstracta `Figura` y subclases `Circulo` y `Rectangulo`. Usar polimorfismo con el método `area()`.

-----

## 📌 `Figura.java`

```java
package com.docencia.herencia.ejercicio25;

/**
 * Clase Figura: Clase base abstracta para cualquier figura geométrica.
 * Define la estructura común, pero no puede ser instanciada.
 */
public abstract class Figura {

    // Nombre de la figura (atributo común)
    private final String nombre;

    /**
     * Constructor para inicializar el nombre de la figura.
     *
     * @param nombre nombre de la figura
     */
    public Figura(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Método abstracto: obliga a todas las subclases a implementarlo.
     * Demuestra polimorfismo, ya que cada figura calcula su área de forma distinta.
     *
     * @return el área de la figura
     */
    public abstract double area();

    /**
     * Método concreto: implementación por defecto para todas las subclases.
     *
     * @return descripción de la figura
     */
    public String descripcion() {
        return "Soy una figura llamada " + nombre;
    }
}
```

-----

## 📌 `Circulo.java`

```java
package com.docencia.herencia.ejercicio25;

/**
 * Clase Circulo: extiende Figura.
 * Implementa el cálculo de área para un círculo (Pi * radio^2).
 */
public class Circulo extends Figura {

    // Atributo específico del círculo
    private final double radio;

    /**
     * Constructor. Llama al constructor de la superclase (Figura).
     *
     * @param radio el radio del círculo
     */
    public Circulo(double radio) {
        // Llama a Figura(nombre)
        super("Círculo");
        this.radio = radio;
    }

    public double getRadio() { return radio; }

    /**
     * Implementación obligatoria del método abstracto area() de Figura.
     * Área = PI * radio * radio
     *
     * @return el área del círculo
     */
    @Override
    public double area() {
        // Math.PI es una constante de Java
        return Math.PI * radio * radio;
    }
}
```

-----

## 📌 `Rectangulo.java`

```java
package com.docencia.herencia.ejercicio25;

/**
 * Clase Rectangulo: extiende Figura.
 * Implementa el cálculo de área para un rectángulo (base * altura).
 */
public class Rectangulo extends Figura {

    // Atributos específicos del rectángulo
    private final double base;
    private final double altura;

    /**
     * Constructor. Llama al constructor de la superclase (Figura).
     *
     * @param base la base del rectángulo
     * @param altura la altura del rectángulo
     */
    public Rectangulo(double base, double altura) {
        // Llama a Figura(nombre)
        super("Rectángulo");
        this.base = base;
        this.altura = altura;
    }

    public double getBase() { return base; }
    public double getAltura() { return altura; }

    /**
     * Implementación obligatoria del método abstracto area() de Figura.
     * Área = base * altura
     *
     * @return el área del rectángulo
     */
    @Override
    public double area() {
        return base * altura;
    }
}
```

-----

## 📌 `Ejercicio25Test.java`

```java
package com.docencia.herencia.ejercicio25;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 25 (Figura, Circulo, Rectangulo).
 * Demuestra el polimorfismo.
 */
public class Ejercicio25Test {

    // Precisión para comparaciones de números decimales
    private static final double DELTA = 1e-9;

    @Test
    void testAreaCirculo() {
        // Radio = 2.0. Área esperada: PI * 2 * 2 = 12.56637...
        Circulo c = new Circulo(2.0);
        assertEquals("Círculo", c.getNombre());
        assertEquals(Math.PI * 4, c.area(), DELTA);
    }

    @Test
    void testAreaRectangulo() {
        // Base = 5.0, Altura = 4.0. Área esperada: 5 * 4 = 20.0
        Rectangulo r = new Rectangulo(5.0, 4.0);
        assertEquals("Rectángulo", r.getNombre());
        assertEquals(20.0, r.area(), DELTA);
    }

    @Test
    void testPolimorfismo() {
        // Crear referencias a Figura, pero instanciar subclases
        Figura figura1 = new Circulo(1.0); // Área = PI * 1 = 3.14159...
        Figura figura2 = new Rectangulo(10.0, 2.0); // Área = 10 * 2 = 20.0

        // El método area() se comporta de forma diferente según el objeto real (Polimorfismo)
        assertEquals(Math.PI, figura1.area(), DELTA);
        assertEquals(20.0, figura2.area(), DELTA);

        // El método concreto de Figura funciona
        assertTrue(figura1.descripcion().contains("Círculo"));
    }
}
```

-----

# ✅ **EJERCICIO 26 – HERENCIA/POLIMORFISMO: Animales y Sonidos**

**Paquete:** `com.docencia.herencia.ejercicio26`
**Objetivo:** diseñar la clase base abstracta `Animal` y subclases `Perro` y `Gato`. Usar polimorfismo con el método `hacerSonido()`.

-----

## 📌 `Animal.java`

```java
package com.docencia.herencia.ejercicio26;

/**
 * Clase Animal: Clase base abstracta.
 * Define la capacidad de hacer un sonido, que es distinto para cada animal.
 */
public abstract class Animal {

    // Atributo común para el nombre de la especie
    private final String especie;

    /**
     * Constructor para inicializar la especie.
     *
     * @param especie nombre de la especie
     */
    public Animal(String especie) {
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    /**
     * Método abstracto: cada subclase debe definir su propio sonido.
     *
     * @return la cadena de texto que representa el sonido del animal
     */
    public abstract String hacerSonido();

    /**
     * Método concreto que utiliza el método polimórfico.
     *
     * @return la especie y el sonido que hace
     */
    public String describirSonido() {
        return especie + " hace el sonido: " + hacerSonido();
    }
}
```

-----

## 📌 `Perro.java`

```java
package com.docencia.herencia.ejercicio26;

/**
 * Clase Perro: extiende Animal.
 * Implementa el sonido específico de un perro.
 */
public class Perro extends Animal {

    /**
     * Constructor. Llama al constructor de la superclase con "Perro".
     */
    public Perro() {
        super("Perro");
    }

    /**
     * Implementación obligatoria del método abstracto hacerSonido().
     *
     * @return "Guau, guau!"
     */
    @Override
    public String hacerSonido() {
        return "Guau, guau!";
    }
}
```

-----

## 📌 `Gato.java`

```java
package com.docencia.herencia.ejercicio26;

/**
 * Clase Gato: extiende Animal.
 * Implementa el sonido específico de un gato.
 */
public class Gato extends Animal {

    /**
     * Constructor. Llama al constructor de la superclase con "Gato".
     */
    public Gato() {
        super("Gato");
    }

    /**
     * Implementación obligatoria del método abstracto hacerSonido().
     *
     * @return "Miau."
     */
    @Override
    public String hacerSonido() {
        return "Miau.";
    }
}
```

-----

## 📌 `Ejercicio26Test.java`

```java
package com.docencia.herencia.ejercicio26;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 26 (Animales y Sonidos).
 * Demuestra el polimorfismo.
 */
public class Ejercicio26Test {

    @Test
    void testSonidoPerro() {
        Perro p = new Perro();
        assertEquals("Perro", p.getEspecie());
        assertEquals("Guau, guau!", p.hacerSonido());
    }

    @Test
    void testSonidoGato() {
        Gato g = new Gato();
        assertEquals("Gato", g.getEspecie());
        assertEquals("Miau.", g.hacerSonido());
    }

    @Test
    void testPolimorfismoEnColeccion() {
        // Creamos un array de la clase base Animal
        Animal[] animales = new Animal[2];
        animales[0] = new Perro();
        animales[1] = new Gato();

        // Al llamar a hacerSonido, se ejecuta el método correcto en tiempo de ejecución (Polimorfismo)
        assertEquals("Guau, guau!", animales[0].hacerSonido());
        assertEquals("Miau.", animales[1].hacerSonido());
    }

    @Test
    void testMetodoConcretoUsandoPolimorfismo() {
        Perro p = new Perro();
        Gato g = new Gato();

        // El método describirSonido llama internamente al hacerSonido() correcto
        assertEquals("Perro hace el sonido: Guau, guau!", p.describirSonido());
        assertEquals("Gato hace el sonido: Miau.", g.describirSonido());
    }
}
```

---

# ✅ **EJERCICIO 27 – HERENCIA/POLIMORFISMO: Cuentas Bancarias**

**Paquete:** `com.docencia.herencia.ejercicio27`
**Objetivo:** diseñar la clase base abstracta `CuentaBancaria` y subclases `CuentaAhorro` y `CuentaCorriente` con diferente comportamiento polimórfico en el método `retirar`.

-----

## 📌 `CuentaBancaria.java`

```java
package com.docencia.herencia.ejercicio27;

/**
 * Clase CuentaBancaria: Clase base abstracta.
 * Define el comportamiento común de todas las cuentas (saldo, depositar).
 */
public abstract class CuentaBancaria {

    // Identificador único de la cuenta
    private final String numeroCuenta;

    // Saldo actual de la cuenta (protegido para acceso directo por subclases)
    protected double saldo;

    /**
     * Constructor.
     *
     * @param numeroCuenta identificador de la cuenta
     * @param saldoInicial saldo inicial
     */
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        // Asignación inicial, asegurando que no sea negativo
        this.saldo = Math.max(0, saldoInicial);
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }

    /**
     * Método concreto: aumenta el saldo de la cuenta.
     * Comportamiento idéntico para todas las subclases.
     *
     * @param cantidad monto a depositar
     */
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }

    /**
     * Método abstracto: obliga a las subclases a implementar la lógica de retiro,
     * ya que las reglas para retirar varían según el tipo de cuenta.
     *
     * @param cantidad monto a retirar
     * @return true si el retiro fue exitoso, false en caso contrario
     */
    public abstract boolean retirar(double cantidad);
}
```

-----

## 📌 `CuentaAhorro.java`

```java
package com.docencia.herencia.ejercicio27;

/**
 * Clase CuentaAhorro: extiende CuentaBancaria.
 * Regla de retiro: No se permite retirar si el saldo resultante es menor a cero.
 */
public class CuentaAhorro extends CuentaBancaria {

    /**
     * Constructor que llama al constructor de la superclase.
     *
     * @param numeroCuenta identificador
     * @param saldoInicial saldo inicial
     */
    public CuentaAhorro(String numeroCuenta, double saldoInicial) {
        super(numeroCuenta, saldoInicial);
    }

    /**
     * Implementación polimórfica del método retirar.
     * Retiro estricto: no permite descubierto (saldo < 0).
     *
     * @param cantidad monto a retirar
     * @return true si la operación se realizó
     */
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Cuenta Ahorro (" + getNumeroCuenta() + ") - Saldo: " + saldo;
    }
}
```

-----

## 📌 `CuentaCorriente.java`

```java
package com.docencia.herencia.ejercicio27;

/**
 * Clase CuentaCorriente: extiende CuentaBancaria.
 * Regla de retiro: Permite descubierto hasta un límite (`limiteDescubierto`).
 */
public class CuentaCorriente extends CuentaBancaria {

    // Límite de descubierto (atributo específico)
    private final double limiteDescubierto;

    /**
     * Constructor.
     *
     * @param numeroCuenta identificador
     * @param saldoInicial saldo inicial
     * @param limiteDescubierto monto máximo que se puede quedar en negativo
     */
    public CuentaCorriente(String numeroCuenta, double saldoInicial, double limiteDescubierto) {
        super(numeroCuenta, saldoInicial);
        // Aseguramos que el límite sea no negativo
        this.limiteDescubierto = Math.max(0, limiteDescubierto);
    }

    public double getLimiteDescubierto() { return limiteDescubierto; }

    /**
     * Implementación polimórfica del método retirar.
     * Permite descubierto hasta el límite definido.
     *
     * @param cantidad monto a retirar
     * @return true si la operación se realizó
     */
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad <= 0) return false;

        // Calculamos el saldo resultante después del retiro
        double nuevoSaldo = saldo - cantidad;

        // Comprobamos si el nuevo saldo está dentro del límite (e.g., -500.0 >= -1000.0)
        if (nuevoSaldo >= -limiteDescubierto) {
            saldo = nuevoSaldo;
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Cuenta Corriente (" + getNumeroCuenta() + ") - Saldo: " + saldo +
               " (Límite Descubierto: " + limiteDescubierto + ")";
    }
}
```

-----

## 📌 `Ejercicio27Test.java`

```java
package com.docencia.herencia.ejercicio27;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 27 (Cuentas Bancarias).
 * Demuestra el polimorfismo en el método retirar().
 */
public class Ejercicio27Test {

    private static final double DELTA = 1e-9;

    @Test
    void testCuentaAhorroRetiro() {
        // Inicial: 100.0
        CuentaAhorro ahorro = new CuentaAhorro("A100", 100.0);
        
        // 1. Depósito (comportamiento base)
        ahorro.depositar(50.0);
        assertEquals(150.0, ahorro.getSaldo(), DELTA);

        // 2. Retiro exitoso (150.0 - 50.0 = 100.0)
        assertTrue(ahorro.retirar(50.0));
        assertEquals(100.0, ahorro.getSaldo(), DELTA);

        // 3. Retiro límite (100.0 - 100.0 = 0.0)
        assertTrue(ahorro.retirar(100.0));
        assertEquals(0.0, ahorro.getSaldo(), DELTA);

        // 4. Retiro fallido (no permite saldo negativo)
        assertFalse(ahorro.retirar(1.0));
        assertEquals(0.0, ahorro.getSaldo(), DELTA);
    }

    @Test
    void testCuentaCorrienteRetiro() {
        // Inicial: 100.0, Límite descubierto: 500.0
        CuentaCorriente corriente = new CuentaCorriente("C200", 100.0, 500.0);

        // 1. Retiro que agota saldo, pero sin descubierto (100.0 - 100.0 = 0.0)
        assertTrue(corriente.retirar(100.0));
        assertEquals(0.0, corriente.getSaldo(), DELTA);

        // 2. Retiro con descubierto (0.0 - 200.0 = -200.0). Dentro del límite 500.0
        assertTrue(corriente.retirar(200.0));
        assertEquals(-200.0, corriente.getSaldo(), DELTA);

        // 3. Retiro que supera el límite de descubierto (ej: 301.0).
        // Saldo actual -200.0. Límite: -500.0.
        // Retirar 301.0 dejaría: -501.0 (fallido)
        assertFalse(corriente.retirar(301.0));
        assertEquals(-200.0, corriente.getSaldo(), DELTA);

        // 4. Retiro que llega al límite (-200.0 - 300.0 = -500.0)
        assertTrue(corriente.retirar(300.0));
        assertEquals(-500.0, corriente.getSaldo(), DELTA);
    }

    @Test
    void testPolimorfismo() {
        // Array de la clase base
        CuentaBancaria[] cuentas = new CuentaBancaria[2];
        cuentas[0] = new CuentaAhorro("A300", 50.0);
        cuentas[1] = new CuentaCorriente("C400", 50.0, 100.0);

        // La CuentaAhorro falla el retiro
        assertFalse(cuentas[0].retirar(100.0));
        assertEquals(50.0, cuentas[0].getSaldo(), DELTA);

        // La CuentaCorriente tiene éxito (saldo: 50 - 100 = -50.0)
        assertTrue(cuentas[1].retirar(100.0));
        assertEquals(-50.0, cuentas[1].getSaldo(), DELTA);
    }
}
```

-----

# ✅ **EJERCICIO 28 – HERENCIA/POLIMORFISMO: Formas de pago**

**Paquete:** `com.docencia.herencia.ejercicio28`
**Objetivo:** diseñar la clase base abstracta `Pago` y subclases para distintos métodos de pago, usando polimorfismo en el método `procesarPago`.

-----

## 📌 `Pago.java`

```java
package com.docencia.herencia.ejercicio28;

/**
 * Clase Pago: Clase base abstracta.
 * Define la estructura de cualquier proceso de pago.
 */
public abstract class Pago {

    // Atributo común para el identificador de la transacción
    private final String idTransaccion;

    /**
     * Constructor.
     *
     * @param idTransaccion identificador único de la transacción
     */
    public Pago(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public String getIdTransaccion() { return idTransaccion; }

    /**
     * Método abstracto: define la acción principal. Cada tipo de pago lo implementará
     * de forma diferente (validación de tarjeta, verificación de cuenta, etc.).
     *
     * @param cantidad monto a procesar
     * @return true si el pago fue exitoso, false en caso contrario
     */
    public abstract boolean procesarPago(double cantidad);

    /**
     * Método concreto: un paso que todas las transacciones realizan.
     *
     * @param cantidad el monto
     * @return el resultado de la preparación
     */
    public String prepararPago(double cantidad) {
        return "Preparando transacción " + idTransaccion + " por " + cantidad + " €.";
    }
}
```

-----

## 📌 `PagoTarjeta.java`

```java
package com.docencia.herencia.ejercicio28;

/**
 * Clase PagoTarjeta: extiende Pago.
 * Simula la lógica de procesamiento para tarjetas (implica validación de CVV, fecha, etc.).
 */
public class PagoTarjeta extends Pago {

    // Atributo específico: los últimos 4 dígitos de la tarjeta
    private final String ultimosCuatroDigitos;

    /**
     * Constructor.
     */
    public PagoTarjeta(String idTransaccion, String ultimosCuatroDigitos) {
        super(idTransaccion);
        this.ultimosCuatroDigitos = ultimosCuatroDigitos;
    }

    public String getUltimosCuatroDigitos() { return ultimosCuatroDigitos; }

    /**
     * Implementación polimórfica: Simula la validación y el cobro a la tarjeta.
     * Para el ejercicio, consideramos un pago exitoso si la cantidad es positiva
     * y el número de tarjeta tiene al menos 4 dígitos.
     *
     * @param cantidad monto a procesar
     * @return true si el pago se considera procesado
     */
    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println(prepararPago(cantidad));
        if (cantidad > 0 && ultimosCuatroDigitos != null && ultimosCuatroDigitos.length() >= 4) {
            System.out.println("Pago con Tarjeta ****" + ultimosCuatroDigitos + " aprobado.");
            return true;
        }
        System.out.println("Pago con Tarjeta rechazado.");
        return false;
    }
}
```

-----

## 📌 `PagoPayPal.java`

```java
package com.docencia.herencia.ejercicio28;

/**
 * Clase PagoPayPal: extiende Pago.
 * Simula la lógica de procesamiento para PayPal (implica redirección y autenticación).
 */
public class PagoPayPal extends Pago {

    // Atributo específico: el email del usuario de PayPal
    private final String emailUsuario;

    /**
     * Constructor.
     */
    public PagoPayPal(String idTransaccion, String emailUsuario) {
        super(idTransaccion);
        this.emailUsuario = emailUsuario;
    }

    public String getEmailUsuario() { return emailUsuario; }

    /**
     * Implementación polimórfica: Simula la conexión con el servidor de PayPal.
     * Para el ejercicio, consideramos un pago exitoso si la cantidad es positiva
     * y el email parece válido (contiene '@').
     *
     * @param cantidad monto a procesar
     * @return true si el pago se considera procesado
     */
    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println(prepararPago(cantidad));
        if (cantidad > 0 && emailUsuario != null && emailUsuario.contains("@")) {
            System.out.println("Pago con PayPal (Usuario: " + emailUsuario + ") aprobado tras redirección.");
            return true;
        }
        System.out.println("Pago con PayPal rechazado.");
        return false;
    }
}
```

-----

## 📌 `PagoTransferencia.java`

```java
package com.docencia.herencia.ejercicio28;

/**
 * Clase PagoTransferencia: extiende Pago.
 * Simula la lógica de procesamiento para Transferencia (implica generación de referencia).
 */
public class PagoTransferencia extends Pago {

    // Atributo específico: el código de referencia que debe usar el cliente
    private final String codigoReferencia;

    /**
     * Constructor.
     */
    public PagoTransferencia(String idTransaccion) {
        super(idTransaccion);
        // Generación de un código de referencia simulado
        this.codigoReferencia = "REF-" + idTransaccion;
    }

    public String getCodigoReferencia() { return codigoReferencia; }

    /**
     * Implementación polimórfica: Simula la generación de la instrucción de pago.
     * Para este método, el pago es 'procesado' si se generan las instrucciones
     * y la cantidad es positiva, asumiendo que el cliente pagará después.
     *
     * @param cantidad monto a procesar
     * @return true si la instrucción de pago se generó correctamente
     */
    @Override
    public boolean procesarPago(double cantidad) {
        System.out.println(prepararPago(cantidad));
        if (cantidad > 0) {
            System.out.println("Instrucciones de Transferencia generadas (Ref: " + codigoReferencia + "). Pendiente de confirmación bancaria.");
            return true;
        }
        System.out.println("No se pudieron generar instrucciones de pago por transferencia.");
        return false;
    }
}
```

-----

## 📌 `Ejercicio28Test.java`

```java
package com.docencia.herencia.ejercicio28;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 28 (Formas de Pago).
 * Demuestra el polimorfismo en el método procesarPago().
 */
public class Ejercicio28Test {

    @Test
    void testPagoTarjeta() {
        Pago p = new PagoTarjeta("T001", "1234");
        // Éxito
        assertTrue(p.procesarPago(99.99));
        // Fracaso por cantidad
        assertFalse(p.procesarPago(0.0));

        Pago p2 = new PagoTarjeta("T002", "12"); // Tarjeta inválida (simulado)
        // Fracaso por datos de tarjeta
        assertFalse(p2.procesarPago(10.0));
    }

    @Test
    void testPagoPayPal() {
        Pago p = new PagoPayPal("P001", "cliente@mail.com");
        // Éxito
        assertTrue(p.procesarPago(50.0));

        Pago p2 = new PagoPayPal("P002", "emailinvalido"); // Email inválido (simulado)
        // Fracaso por datos de email
        assertFalse(p2.procesarPago(1.0));
    }

    @Test
    void testPagoTransferencia() {
        PagoTransferencia p = new PagoTransferencia("R001");
        // Éxito (genera instrucciones)
        assertTrue(p.procesarPago(150.0));
        assertEquals("REF-R001", p.getCodigoReferencia());

        // Fracaso por cantidad
        assertFalse(p.procesarPago(-10.0));
    }

    @Test
    void testPolimorfismoEnArray() {
        // Array de la clase base Pago
        Pago[] pagos = new Pago[3];
        pagos[0] = new PagoTarjeta("TX1", "9876");
        pagos[1] = new PagoPayPal("PY2", "test@user.net");
        pagos[2] = new PagoTransferencia("TR3");

        // Todos deberían ser exitosos
        assertTrue(pagos[0].procesarPago(10.0));
        assertTrue(pagos[1].procesarPago(20.0));
        assertTrue(pagos[2].procesarPago(30.0));
    }
}
```

---

# ✅ **EJERCICIO 29 – HERENCIA/POLIMORFISMO: Sistema de roles de usuario**

**Paquete:** `com.docencia.herencia.ejercicio29`
**Objetivo:** diseñar la clase base `Usuario` y subclases `Admin`, `Moderador` y `UsuarioNormal` para demostrar el polimorfismo en la lista de acciones disponibles.

-----

## 📌 `Usuario.java`

```java
package com.docencia.herencia.ejercicio29;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Usuario: Clase base para todos los roles del sistema.
 * Define la estructura básica (nombre, email) y un método polimórfico clave.
 */
public abstract class Usuario {

    private final String nombre;
    private final String email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }

    /**
     * Método polimórfico: define las acciones que un rol puede realizar.
     * Cada subclase devolverá una lista diferente.
     *
     * @return Lista de Strings con las acciones disponibles para este usuario
     */
    public abstract List<String> accionesDisponibles();

    @Override
    public String toString() {
        return nombre + " (" + this.getClass().getSimpleName() + ")";
    }
}
```

-----

## 📌 `Admin.java`

```java
package com.docencia.herencia.ejercicio29;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Admin: Máximo nivel de acceso. Extiende Usuario.
 */
public class Admin extends Usuario {

    public Admin(String nombre, String email) {
        super(nombre, email);
    }

    /**
     * Devuelve todas las acciones posibles.
     */
    @Override
    public List<String> accionesDisponibles() {
        // Un administrador tiene todos los permisos
        List<String> acciones = new ArrayList<>();
        acciones.add("crear_usuario");
        acciones.add("eliminar_usuario");
        acciones.add("banear_usuario");
        acciones.add("moderar_contenido");
        acciones.add("publicar");
        acciones.add("comentar");
        return acciones;
    }
}
```

-----

## 📌 `Moderador.java`

```java
package com.docencia.herencia.ejercicio29;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Moderador: Nivel medio de acceso. Extiende Usuario.
 */
public class Moderador extends Usuario {

    public Moderador(String nombre, String email) {
        super(nombre, email);
    }

    /**
     * Devuelve acciones de moderación y básicas.
     */
    @Override
    public List<String> accionesDisponibles() {
        List<String> acciones = new ArrayList<>();
        acciones.add("banear_usuario");
        acciones.add("moderar_contenido");
        acciones.add("publicar");
        acciones.add("comentar");
        return acciones;
    }
}
```

-----

## 📌 `UsuarioNormal.java`

```java
package com.docencia.herencia.ejercicio29;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase UsuarioNormal: Nivel básico de acceso. Extiende Usuario.
 */
public class UsuarioNormal extends Usuario {

    public UsuarioNormal(String nombre, String email) {
        super(nombre, email);
    }

    /**
     * Devuelve solo acciones de participación.
     */
    @Override
    public List<String> accionesDisponibles() {
        List<String> acciones = new ArrayList<>();
        acciones.add("publicar");
        acciones.add("comentar");
        return acciones;
    }
}
```

-----

## 📌 `Ejercicio29Test.java`

```java
package com.docencia.herencia.ejercicio29;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 29 (Roles de Usuario).
 * Demuestra el polimorfismo en la lista de acciones.
 */
public class Ejercicio29Test {

    @Test
    void testAccionesPolimorfismo() {
        // Crear instancias de los diferentes roles
        Usuario u1 = new Admin("Jefe", "jefe@dominio.com");
        Usuario u2 = new Moderador("Mod", "mod@dominio.com");
        Usuario u3 = new UsuarioNormal("User", "user@dominio.com");

        // 1. Verificar número de acciones (Polimorfismo)
        assertEquals(6, u1.accionesDisponibles().size());
        assertEquals(4, u2.accionesDisponibles().size());
        assertEquals(2, u3.accionesDisponibles().size());

        // 2. Verificar acciones específicas
        // Admin tiene la acción más alta: 'eliminar_usuario'
        assertTrue(u1.accionesDisponibles().contains("eliminar_usuario"));
        assertFalse(u2.accionesDisponibles().contains("eliminar_usuario"));

        // Moderador tiene 'banear_usuario'
        assertTrue(u2.accionesDisponibles().contains("banear_usuario"));
        assertFalse(u3.accionesDisponibles().contains("banear_usuario"));

        // Usuario normal solo tiene acciones básicas
        assertTrue(u3.accionesDisponibles().contains("publicar"));
        assertFalse(u3.accionesDisponibles().contains("banear_usuario"));
    }
}
```

-----

# ✅ **EJERCICIO 30 – COMPOSICIÓN + HERENCIA: Grupo de Figuras**

**Paquete:** `com.docencia.herencia.ejercicio30`
**Objetivo:** diseñar `GrupoFiguras` (composición) para contener objetos `Figura` (herencia/polimorfismo) y calcular su área total.

*Nota: Reutilizaremos las clases **Figura**, **Circulo** y **Rectangulo** del Ejercicio 25, asumiendo que están disponibles en sus respectivos paquetes.*

-----

## 📌 `GrupoFiguras.java`

```java
package com.docencia.herencia.ejercicio30;

// Importamos las clases Figura, Circulo y Rectangulo del Ejercicio 25
import com.docencia.herencia.ejercicio25.Figura;
import com.docencia.herencia.ejercicio25.Circulo;
import com.docencia.herencia.ejercicio25.Rectangulo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase GrupoFiguras: Demuestra la combinación de Composición y Herencia/Polimorfismo.
 * Un GrupoFiguras TIENE una lista de Figuras.
 */
public class GrupoFiguras {

    // Lista de Figuras. La lista almacena referencias de la clase base. (Composición)
    private final List<Figura> figuras = new ArrayList<>();

    private final String nombreGrupo;

    public GrupoFiguras(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getNombreGrupo() { return nombreGrupo; }

    /**
     * Agrega una figura a la colección. Permite agregar cualquier subclase de Figura.
     *
     * @param f figura (Circulo, Rectangulo, etc.) a agregar
     */
    public void agregarFigura(Figura f) {
        if (f != null) {
            figuras.add(f);
        }
    }

    /**
     * Calcula la suma total de las áreas de todas las figuras en el grupo.
     * Se basa en el Polimorfismo, ya que f.area() llama al método de la subclase correcta.
     *
     * @return el área total
     */
    public double areaTotal() {
        double total = 0.0;
        for (Figura f : figuras) {
            // Llama a Circulo.area() o Rectangulo.area() según el tipo real de 'f'
            total += f.area();
        }
        return total;
    }

    /**
     * Método estático de utilidad para sumar las áreas totales de varios grupos.
     *
     * @param grupos Lista de GrupoFiguras
     * @return Suma de las áreas totales de todos los grupos
     */
    public static double areaTotalDeGrupos(List<GrupoFiguras> grupos) {
        double total = 0.0;
        if (grupos != null) {
            for (GrupoFiguras g : grupos) {
                total += g.areaTotal();
            }
        }
        return total;
    }

    public List<Figura> getFiguras() {
        return new ArrayList<>(figuras);
    }
}
```

-----

## 📌 `Ejercicio30Test.java`

```java
package com.docencia.herencia.ejercicio30;

import com.docencia.herencia.ejercicio25.Circulo;
import com.docencia.herencia.ejercicio25.Rectangulo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests para Ejercicio 30 (GrupoFiguras, composición con polimorfismo).
 */
public class Ejercicio30Test {

    private static final double DELTA = 1e-9;

    @Test
    void testAreaTotalGrupo() {
        // Crear figuras
        // C1: Radio 2.0. Area = 12.56637...
        Circulo c1 = new Circulo(2.0);
        // R1: Base 5.0, Altura 4.0. Area = 20.0
        Rectangulo r1 = new Rectangulo(5.0, 4.0);
        // R2: Base 1.0, Altura 1.0. Area = 1.0
        Rectangulo r2 = new Rectangulo(1.0, 1.0);

        // Crear grupo y agregar figuras
        GrupoFiguras grupo = new GrupoFiguras("Grupo A");
        grupo.agregarFigura(c1);
        grupo.agregarFigura(r1);
        grupo.agregarFigura(r2);

        // Área esperada: 12.56637... + 20.0 + 1.0 = 33.56637...
        double areaEsperada = c1.area() + r1.area() + r2.area();

        // 1. Verificar el cálculo del área total
        assertEquals(3, grupo.getFiguras().size());
        assertEquals(areaEsperada, grupo.areaTotal(), DELTA);
    }

    @Test
    void testAreaTotalDeVariosGrupos() {
        // Crear Grupo 1
        GrupoFiguras g1 = new GrupoFiguras("G1");
        g1.agregarFigura(new Circulo(1.0)); // Area ≈ 3.14159
        g1.agregarFigura(new Rectangulo(2.0, 2.0)); // Area = 4.0

        // Crear Grupo 2
        GrupoFiguras g2 = new GrupoFiguras("G2");
        g2.agregarFigura(new Circulo(3.0)); // Area ≈ 28.27433

        // Lista de grupos
        List<GrupoFiguras> grupos = new ArrayList<>();
        grupos.add(g1);
        grupos.add(g2);

        // Área total esperada: (3.14159 + 4.0) + (28.27433) = 35.41592...
        double areaEsperada = g1.areaTotal() + g2.areaTotal();

        // 2. Verificar el cálculo estático sobre la lista de grupos
        assertEquals(areaEsperada, GrupoFiguras.areaTotalDeGrupos(grupos), DELTA);
    }
}
```

---