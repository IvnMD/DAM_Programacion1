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
