## Bloque A — Listas (1–10)

### Ejercicio 01 – Máximo, mínimo y eliminar negativos

**Paquete:** `com.docencia.listas.ejercicio01`
**Clase:** `Ejercicio01`

```java
package com.docencia.listas.ejercicio01;

import java.util.List;
import java.util.Iterator;

public class Ejercicio01 {

    // Devuelve el máximo de la lista. Se asume lista no vacía.
    public static int maximo(List<Integer> numeros) {
        // Inicializamos con el primer elemento para soportar números negativos.
        int max = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            int v = numeros.get(i);
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    // Devuelve el mínimo de la lista. Se asume lista no vacía.
    public static int minimo(List<Integer> numeros) {
        int min = numeros.get(0);
        for (int i = 1; i < numeros.size(); i++) {
            int v = numeros.get(i);
            if (v < min) {
                min = v;
            }
        }
        return min;
    }

    // Elimina in-place todos los valores negativos de la lista.
    public static void eliminarNegativos(List<Integer> numeros) {
        // Usamos un Iterator para eliminar de forma segura durante la iteración.
        Iterator<Integer> it = numeros.iterator();
        while (it.hasNext()) {
            if (it.next() < 0) {
                it.remove();
            }
        }
    }
}
```

**Explicación:**

* `maximo` y `minimo` inicializan con el primer elemento (evita usar `Integer.MIN_VALUE`/`MAX_VALUE` y problemas si lista vacía; README dice lista no vacía).
* `eliminarNegativos` usa `Iterator.remove()` para evitar `ConcurrentModificationException`.
  **Casos borde:** lista con todos negativos (queda vacía), lista con un elemento, valores 0.

---

### Ejercicio 02 – Gestor de tareas simple

**Paquete:** `com.docencia.listas.ejercicio02`
**Clase:** `Ejercicio02.GestorTareas`

```java
package com.docencia.listas.ejercicio02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio02 {

    public static class GestorTareas {
        private final List<String> tareas = new ArrayList<>(); // lista interna mutable

        public void agregarTarea(String tarea) {
            if (tarea == null) throw new IllegalArgumentException("tarea no puede ser null");
            tareas.add(tarea);
        }

        public List<String> getTareas() {
            // Devolvemos una copia para evitar modificaciones externas sobre la lista interna.
            return new ArrayList<>(tareas);
            // Alternativa: Collections.unmodifiableList(tareas) para vista de solo lectura.
        }

        public String completarTarea(int indice) {
            // Validamos índice
            if (indice < 0 || indice >= tareas.size()) {
                throw new IndexOutOfBoundsException("indice fuera de rango");
            }
            // removemos y devolvemos la tarea completada
            return tareas.remove(indice);
        }

        public void borrarTodas() {
            tareas.clear();
        }
    }
}
```

**Explicación:**

* `getTareas()` devuelve copia para encapsular. Podríamos devolver `Collections.unmodifiableList(tareas)` si prefieres vista inmutable.
* Validaciones de `null` e índices para seguridad.

---

### Ejercicio 03 – Eliminar duplicados (mantener orden)

**Paquete:** `com.docencia.listas.ejercicio03`
**Clase:** `Ejercicio03`

```java
package com.docencia.listas.ejercicio03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ejercicio03 {

    // Devuelve nueva lista sin duplicados, manteniendo orden de primera aparición.
    public static List<Integer> sinDuplicados(List<Integer> original) {
        List<Integer> resultado = new ArrayList<>();
        Set<Integer> vistos = new HashSet<>(); // para chequear existencia O(1)
        for (Integer v : original) {
            if (!vistos.contains(v)) {
                resultado.add(v);
                vistos.add(v);
            }
        }
        return resultado;
    }
}
```

**Explicación:**

* Mantener orden: iteramos la lista original y solo añadimos la primera vez que aparece el elemento.
* No se permite usar `LinkedHashSet` para simplificar; aquí `HashSet` + `ArrayList` mantiene orden por construcción.
  **Casos:** lista vacía → retorna vacía.

---

### Ejercicio 04 – Buscar y reemplazar nombres

**Paquete:** `com.docencia.listas.ejercicio04`
**Clase:** `Ejercicio04`

```java
package com.docencia.listas.ejercicio04;

import java.util.List;

public class Ejercicio04 {

    // Reemplaza todas las apariciones de 'antiguo' por 'nuevo' en la misma lista.
    public static void reemplazar(List<String> nombres, String antiguo, String nuevo) {
        if (nombres == null) return;
        for (int i = 0; i < nombres.size(); i++) {
            String v = nombres.get(i);
            // usamos equals para comparar cadenas; permitimos que antiguo o nuevo sean null
            if (antiguo == null ? v == null : antiguo.equals(v)) {
                nombres.set(i, nuevo);
            }
        }
    }
}
```

**Explicación:**

* Se soportan `antiguo == null` comparando con `v == null`.
* Modifica la lista in-place con `set`.

---

### Ejercicio 05 – Invertir una lista in-place

**Paquete:** `com.docencia.listas.ejercicio05`
**Clase:** `Ejercicio05`

```java
package com.docencia.listas.ejercicio05;

import java.util.List;
import java.util.Collections;

public class Ejercicio05 {

    // Invertir usando dos punteros y swap in-place, sin crear otra lista.
    public static void invertir(List<String> lista) {
        if (lista == null) return;
        int i = 0;
        int j = lista.size() - 1;
        while (i < j) {
            // intercambiamos elementos i y j
            String tmp = lista.get(i);
            lista.set(i, lista.get(j));
            lista.set(j, tmp);
            i++;
            j--;
        }
    }

    // Alternativa simple: Collections.reverse(lista) (si está permitido).
    public static void invertirConCollections(List<String> lista) {
        if (lista != null) Collections.reverse(lista);
    }
}
```

**Explicación:**

* Algoritmo clásico de intercambio con dos índices, O(n) tiempo, O(1) espacio.
* Alternativa `Collections.reverse` incluida como referencia.

---

### Ejercicio 06 – Filtrar mayores que

**Paquete:** `com.docencia.listas.ejercicio06`
**Clase:** `Ejercicio06`

```java
package com.docencia.listas.ejercicio06;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio06 {

    // Devuelve nueva lista con elementos estrictamente mayores que 'limite'.
    public static List<Integer> filtrarMayoresQue(List<Integer> lista, int limite) {
        List<Integer> resultado = new ArrayList<>();
        if (lista == null) return resultado;
        for (Integer v : lista) {
            if (v != null && v > limite) {
                resultado.add(v);
            }
        }
        return resultado;
    }
}
```

**Explicación:**

* Evitamos `NullPointerException` si la lista contiene `null` (saltamos `null`).
* Devuelve copia; no modifica original.

---

### Ejercicio 07 – Ordenar con y sin `Collections.sort`

**Paquete:** `com.docencia.listas.ejercicio07`
**Clase:** `Ejercicio07`

```java
package com.docencia.listas.ejercicio07;

import java.util.List;
import java.util.Collections;

public class Ejercicio07 {

    // Ordena usando Collections.sort (método estándar).
    public static void ordenarConSort(List<Integer> lista) {
        if (lista == null) return;
        Collections.sort(lista);
    }

    // Ordena sin Collections.sort: implementamos bubble sort usando operaciones de List.
    public static void ordenarSinSort(List<Integer> lista) {
        if (lista == null) return;
        int n = lista.size();
        // Burbuja simple
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                Integer a = lista.get(i - 1);
                Integer b = lista.get(i);
                if (a > b) {
                    lista.set(i - 1, b);
                    lista.set(i, a);
                    swapped = true;
                }
            }
            n--; // último elemento ya está en su sitio
        } while (swapped);
    }
}
```

**Explicación:**

* `ordenarConSort` usa la forma recomendada.
* `ordenarSinSort` implementa burbuja por simplicidad (no eficiente pero cumple la restricción de no usar `Collections.sort`).
  **Casos:** lista con `null` lanzaría NPE al comparar; asumimos lista de enteros válidos.

---

### Ejercicio 08 – Particionar en pares e impares

**Paquete:** `com.docencia.listas.ejercicio08`
**Clase:** `Ejercicio08` y `ResultadoParticion`

```java
package com.docencia.listas.ejercicio08;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio08 {

    public static class ResultadoParticion {
        private final List<Integer> pares;
        private final List<Integer> impares;

        public ResultadoParticion(List<Integer> pares, List<Integer> impares) {
            this.pares = pares;
            this.impares = impares;
        }

        public List<Integer> getPares() {
            return pares;
        }

        public List<Integer> getImpares() {
            return impares;
        }
    }

    // Separa en dos listas: pares e impares (preservando orden).
    public static ResultadoParticion partir(List<Integer> lista) {
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        if (lista != null) {
            for (Integer v : lista) {
                if (v == null) continue; // ignoramos nulls
                if (v % 2 == 0) pares.add(v);
                else impares.add(v);
            }
        }
        return new ResultadoParticion(pares, impares);
    }
}
```

**Explicación:**

* Preserva orden de aparición en cada sublista.
* Ignora `null`.

---

### Ejercicio 09 – Sublista (paginación)

**Paquete:** `com.docencia.listas.ejercicio09`
**Clase:** `Ejercicio09`
(ya lo implementamos antes; incluyo versión final con comentarios)

```java
package com.docencia.listas.ejercicio09;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio09 {

    public static List<String> pagina(List<String> elementos, int numeroPagina, int tamanoPagina) {
        // Validación básica: lista no nula y parámetros válidos
        if (elementos == null || numeroPagina < 1 || tamanoPagina < 1) {
            return new ArrayList<>();
        }
        int inicio = (numeroPagina - 1) * tamanoPagina;
        if (inicio >= elementos.size()) {
            return new ArrayList<>(); // página fuera de rango
        }
        int fin = Math.min(inicio + tamanoPagina, elementos.size());
        // devolvemos copia de la sublista para evitar vistas sobre la lista original
        return new ArrayList<>(elementos.subList(inicio, fin));
    }
}
```

**Explicación:**

* `numeroPagina` 1-based.
* Si `inicio >= size` devolvemos vacía.
* `fin` exclusivo.

---

### Ejercicio 10 – Rotar una lista (mejorada: k puede ser grande/negativo)

**Paquete:** `com.docencia.listas.ejercicio10`
**Clase:** `Ejercicio10`

```java
package com.docencia.listas.ejercicio10;

import java.util.List;

public class Ejercicio10 {

    private Ejercicio10() {
        // clase utilitaria: no instanciable
    }

    public static void rotar(List<Integer> lista, int k) {
        // Validaciones básicas
        if (lista == null) return;
        int n = lista.size();
        if (n <= 1) return;

        // Normalizamos k para que esté en 0..n-1 y soporte negativos
        k = ((k % n) + n) % n;
        if (k == 0) return; // no hay rotación

        // Hacemos copia inmutable de la lista original para leer valores sin sobrescribir.
        List<Integer> copia = List.copyOf(lista);

        // Para cada índice original i, colocamos copia[i] en nuevaPos = (i + k) % n
        for (int i = 0; i < n; i++) {
            int nuevaPos = (i + k) % n;
            lista.set(nuevaPos, copia.get(i));
        }
    }
}
```

**Explicación:**

* `k` normalizado con `((k % n) + n) % n` para admitir negativos.
* Usamos `List.copyOf` para leer valores originales mientras escribimos en la lista objetivo.

---

## Bloque B — Composición (11–20)

Diseñaré clases útiles, con métodos solicitados y ejemplos de uso. Comentaré decisiones de diseño.

---

### Ejercicio 11 – `Direccion` y `Persona`

**Paquete:** `com.docencia.composicion.ejercicio11`

```java
package com.docencia.composicion.ejercicio11;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Direccion {
    private final String calle;
    private final String ciudad;
    private final String codigoPostal;

    public Direccion(String calle, String ciudad, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() { return calle; }
    public String getCiudad() { return ciudad; }
    public String getCodigoPostal() { return codigoPostal; }

    // Devuelve la dirección formateada en una sola línea.
    public String formateada() {
        return calle + ", " + ciudad + " (" + codigoPostal + ")";
    }

    @Override
    public String toString() {
        return formateada();
    }
}

class Persona {
    private final String nombre;
    private final int edad;
    private Direccion direccion; // composición: Persona tiene Direccion

    public Persona(String nombre, int edad, Direccion direccion) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return nombre + " (" + edad + ") - " + (direccion != null ? direccion.formateada() : "sin direccion");
    }

    // Método utilitario para filtrar personas por ciudad.
    public static List<Persona> filtrarPorCiudad(List<Persona> lista, String ciudad) {
        List<Persona> res = new ArrayList<>();
        if (lista == null || ciudad == null) return res;
        for (Persona p : lista) {
            if (p != null && p.getDireccion() != null && ciudad.equals(p.getDireccion().getCiudad())) {
                res.add(p);
            }
        }
        return res;
    }
}
```

**Explicación:**

* `Persona` **tiene** `Direccion`.
* `filtrarPorCiudad` devuelve nueva lista; se evita exponer colección interna.

---

### Ejercicio 12 – `Pedido` y `LineaPedido`

**Paquete:** `com.docencia.composicion.ejercicio12`

```java
package com.docencia.composicion.ejercicio12;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}

class LineaPedido {
    private final Producto producto;
    private int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = Math.max(0, cantidad);
    }
    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = Math.max(0, cantidad); }
    public double subtotal() { return producto.getPrecio() * cantidad; }
}

class Pedido {
    private final List<LineaPedido> lineas = new ArrayList<>();

    public void agregarLinea(Producto p, int cantidad) {
        if (p == null || cantidad <= 0) return;
        lineas.add(new LineaPedido(p, cantidad));
    }

    public double calcularTotal() {
        double total = 0.0;
        for (LineaPedido lp : lineas) total += lp.subtotal();
        return total;
    }

    public double calcularTotalConDescuento(double porcentaje) {
        double base = calcularTotal();
        if (porcentaje <= 0) return base;
        if (porcentaje >= 100) return 0.0;
        return base * (1 - porcentaje / 100.0);
    }

    public List<LineaPedido> getLineas() {
        return new ArrayList<>(lineas);
    }
}
```

**Explicación:**

* `Pedido` contiene `LineaPedido`s; cada línea contiene `Producto`.
* `calcularTotalConDescuento` aplica descuento porcentual de forma segura.

---

### Ejercicio 13 – Biblioteca y libros

**Paquete:** `com.docencia.composicion.ejercicio13`

```java
package com.docencia.composicion.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private final String titulo;
    private final String autor;
    private final int año;

    public Libro(String titulo, String autor, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
    }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAño() { return año; }
    @Override
    public String toString() { return titulo + " - " + autor + " (" + año + ")"; }
}

class Biblioteca {
    private final List<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        if (libro == null) return;
        libros.add(libro);
    }

    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> res = new ArrayList<>();
        if (autor == null) return res;
        for (Libro l : libros) {
            if (autor.equals(l.getAutor())) res.add(l);
        }
        return res;
    }

    public boolean eliminarLibroPorTitulo(String titulo) {
        if (titulo == null) return false;
        for (int i = 0; i < libros.size(); i++) {
            if (titulo.equals(libros.get(i).getTitulo())) {
                libros.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Libro> getLibros() {
        return new ArrayList<>(libros);
    }
}
```

**Explicación:**

* `Biblioteca` encapsula lista interna. Métodos simples y predecibles.

---

### Ejercicio 14 – Universidad con facultades y estudiantes

**Paquete:** `com.docencia.composicion.ejercicio14`

```java
package com.docencia.composicion.ejercicio14;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Estudiante {
    private final String id;
    private final String nombre;

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    @Override
    public String toString() { return id + " - " + nombre; }
}

class Facultad {
    private final String nombre;
    private final List<Estudiante> estudiantes = new ArrayList<>();

    public Facultad(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    public void agregarEstudiante(Estudiante e) { if (e != null) estudiantes.add(e); }
    public List<Estudiante> getEstudiantes() { return new ArrayList<>(estudiantes); }
    public Optional<Estudiante> buscarPorId(String id) {
        if (id == null) return Optional.empty();
        for (Estudiante e : estudiantes) {
            if (id.equals(e.getId())) return Optional.of(e);
        }
        return Optional.empty();
    }
}

class Universidad {
    private final String nombre;
    private final List<Facultad> facultades = new ArrayList<>();

    public Universidad(String nombre) { this.nombre = nombre; }
    public void agregarFacultad(Facultad f) { if (f != null) facultades.add(f); }

    // Devuelve todos los estudiantes de todas las facultades
    public List<Estudiante> obtenerTodosEstudiantes() {
        List<Estudiante> res = new ArrayList<>();
        for (Facultad f : facultades) res.addAll(f.getEstudiantes());
        return res;
    }

    // Busca estudiante por id en toda la universidad
    public Optional<Estudiante> buscarEstudiantePorId(String id) {
        if (id == null) return Optional.empty();
        for (Facultad f : facultades) {
            Optional<Estudiante> e = f.buscarPorId(id);
            if (e.isPresent()) return e;
        }
        return Optional.empty();
    }
}
```

**Explicación:**

* Composición en varios niveles: `Universidad` tiene `Facultad`, `Facultad` tiene `Estudiante`.
* Uso de `Optional` para evitar `null`.

---

### Ejercicio 15 – Carrito de compra

**Paquete:** `com.docencia.composicion.ejercicio15`

```java
package com.docencia.composicion.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private final String id;
    private final String nombre;
    private final double precio;

    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}

class Carrito {
    private final List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) { if (p != null) productos.add(p); }

    public boolean eliminarProductoPorId(String id) {
        if (id == null) return false;
        for (int i = 0; i < productos.size(); i++) {
            if (id.equals(productos.get(i).getId())) {
                productos.remove(i);
                return true;
            }
        }
        return false;
    }

    public double calcularTotal() {
        double total = 0;
        for (Producto p : productos) total += p.getPrecio();
        return total;
    }

    public long contarPorNombre(String nombre) {
        if (nombre == null) return 0;
        return productos.stream().filter(p -> nombre.equals(p.getNombre())).count();
    }

    public List<Producto> getProductos() { return new ArrayList<>(productos); }
}
```

**Explicación:**

* Operaciones básicas y búsquedas por id/nombre. Encapsulamos la lista interna.

---

### Ejercicio 16 – Agenda de contactos con teléfonos

**Paquete:** `com.docencia.composicion.ejercicio16`

```java
package com.docencia.composicion.ejercicio16;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Telefono {
    private final String tipo; // ejemplo: "movil", "casa"
    private final String numero;

    public Telefono(String tipo, String numero) { this.tipo = tipo; this.numero = numero; }
    public String getTipo() { return tipo; }
    public String getNumero() { return numero; }
}

class Contacto {
    private final String nombre;
    private final List<Telefono> telefonos = new ArrayList<>();

    public Contacto(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    public List<Telefono> getTelefonos() { return new ArrayList<>(telefonos); }
    public void addTelefono(Telefono t) { if (t != null) telefonos.add(t); }

    public void borrarTelefonosPorTipo(String tipo) {
        telefonos.removeIf(t -> tipo == null ? t.getTipo() == null : tipo.equals(t.getTipo()));
    }

    public boolean tieneNumero(String numero) {
        for (Telefono t : telefonos) if (t.getNumero().equals(numero)) return true;
        return false;
    }
}

class Agenda {
    private final List<Contacto> contactos = new ArrayList<>();

    public void agregarContacto(Contacto c) { if (c != null) contactos.add(c); }

    public Optional<Contacto> buscarPorNombre(String nombre) {
        if (nombre == null) return Optional.empty();
        for (Contacto c : contactos) if (nombre.equals(c.getNombre())) return Optional.of(c);
        return Optional.empty();
    }

    public Optional<Contacto> buscarPorNumero(String numero) {
        if (numero == null) return Optional.empty();
        for (Contacto c : contactos) if (c.tieneNumero(numero)) return Optional.of(c);
        return Optional.empty();
    }

    public List<Contacto> getContactos() { return new ArrayList<>(contactos); }
}
```

**Explicación:**

* `Contact` agrupa `Telefono`s; operaciones para añadir, borrar por tipo y buscar por número.

---

### Ejercicio 17 – Empresa con empleados y proyectos

**Paquete:** `com.docencia.composicion.ejercicio17`

```java
package com.docencia.composicion.ejercicio17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Proyecto {
    private final String nombre;
    private final double presupuesto;
    public Proyecto(String nombre, double presupuesto) { this.nombre = nombre; this.presupuesto = presupuesto; }
    public String getNombre() { return nombre; }
    public double getPresupuesto() { return presupuesto; }
}

class Empleado {
    private final String nombre;
    private final double salario;
    private final List<Proyecto> proyectos = new ArrayList<>();

    public Empleado(String nombre, double salario) { this.nombre = nombre; this.salario = salario; }

    public String getNombre() { return nombre; }
    public double getSalario() { return salario; }

    public void asignarProyecto(Proyecto p) { if (p != null) proyectos.add(p); }
    public List<Proyecto> getProyectos() { return new ArrayList<>(proyectos); }
}

class Empresa {
    private final List<Empleado> empleados = new ArrayList<>();

    public void agregarEmpleado(Empleado e) { if (e != null) empleados.add(e); }

    // Coste total de salarios de empleados que participan en un proyecto concreto.
    public double costeSalarialPorProyecto(String nombreProyecto) {
        double suma = 0;
        if (nombreProyecto == null) return suma;
        for (Empleado e : empleados) {
            for (Proyecto p : e.getProyectos()) {
                if (nombreProyecto.equals(p.getNombre())) {
                    suma += e.getSalario();
                    break; // no sumar mismo empleado dos veces si tiene el proyecto repetido
                }
            }
        }
        return suma;
    }

    // Lista de proyectos únicos de la empresa
    public List<Proyecto> proyectosUnicos() {
        Set<String> vistos = new HashSet<>();
        List<Proyecto> res = new ArrayList<>();
        for (Empleado e : empleados) {
            for (Proyecto p : e.getProyectos()) {
                if (!vistos.contains(p.getNombre())) {
                    vistos.add(p.getNombre());
                    res.add(p);
                }
            }
        }
        return res;
    }
}
```

**Explicación:**

* Cada `Empleado` tiene proyectos; `Empresa` agrega empleados y calcula costes por proyecto.

---

### Ejercicio 18 – Carta de restaurante

**Paquete:** `com.docencia.composicion.ejercicio18`

```java
package com.docencia.composicion.ejercicio18;

import java.util.ArrayList;
import java.util.List;

public class Plato {
    private final String nombre;
    private final double precio;
    private final boolean esVegetariano;

    public Plato(String nombre, double precio, boolean esVegetariano) {
        this.nombre = nombre; this.precio = precio; this.esVegetariano = esVegetariano;
    }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public boolean isVegetariano() { return esVegetariano; }
}

class Categoria {
    private final String nombre;
    private final List<Plato> platos = new ArrayList<>();
    public Categoria(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    public void agregarPlato(Plato p) { if (p != null) platos.add(p); }
    public List<Plato> getPlatos() { return new ArrayList<>(platos); }
}

class Carta {
    private final List<Categoria> categorias = new ArrayList<>();
    public void agregarCategoria(Categoria c) { if (c != null) categorias.add(c); }

    public List<Plato> platosVegetarianos() {
        List<Plato> res = new ArrayList<>();
        for (Categoria c : categorias) {
            for (Plato p : c.getPlatos()) {
                if (p.isVegetariano()) res.add(p);
            }
        }
        return res;
    }

    public List<Plato> buscarPorRangoPrecio(double min, double max) {
        List<Plato> res = new ArrayList<>();
        for (Categoria c : categorias) {
            for (Plato p : c.getPlatos()) {
                if (p.getPrecio() >= min && p.getPrecio() <= max) res.add(p);
            }
        }
        return res;
    }
}
```

**Explicación:**

* Diseño lógico para la carta con categorías que contienen platos.

---

### Ejercicio 19 – Sistema de biblioteca con préstamos

**Paquete:** `com.docencia.composicion.ejercicio19`

```java
package com.docencia.composicion.ejercicio19;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Libro {
    private final String titulo;
    public Libro(String titulo) { this.titulo = titulo; }
    public String getTitulo() { return titulo; }
}

class Usuario {
    private final String id;
    public Usuario(String id) { this.id = id; }
    public String getId() { return id; }
}

class Prestamo {
    private final Libro libro;
    private final Usuario usuario;
    private final LocalDate fecha;
    private final boolean activo;

    public Prestamo(Libro libro, Usuario usuario, LocalDate fecha, boolean activo) {
        this.libro = libro; this.usuario = usuario; this.fecha = fecha; this.activo = activo;
    }

    public Libro getLibro() { return libro; }
    public Usuario getUsuario() { return usuario; }
    public LocalDate getFecha() { return fecha; }
    public boolean isActivo() { return activo; }
}

class GestorPrestamos {
    private final List<Prestamo> prestamos = new ArrayList<>();

    public void registrarPrestamo(Prestamo p) { if (p != null) prestamos.add(p); }

    public List<Prestamo> prestamosActivosDeUsuario(Usuario u) {
        if (u == null) return new ArrayList<>();
        return prestamos.stream()
                .filter(p -> p.isActivo() && p.getUsuario().getId().equals(u.getId()))
                .collect(Collectors.toList());
    }

    public List<Usuario> usuariosConLibro(String tituloLibro) {
        List<Usuario> res = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (p.isActivo() && p.getLibro().getTitulo().equals(tituloLibro)) {
                res.add(p.getUsuario());
            }
        }
        return res;
    }
}
```

**Explicación:**

* `Prestamo` contiene `Libro` y `Usuario` y un flag `activo`. `GestorPrestamos` filtra préstamos activos.

---

### Ejercicio 20 – Clínica veterinaria

**Paquete:** `com.docencia.composicion.ejercicio20`

```java
package com.docencia.composicion.ejercicio20;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private final String nombre;
    private final String especie;
    public Mascota(String nombre, String especie) { this.nombre = nombre; this.especie = especie; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
}

class Cita {
    private final LocalDate fecha;
    private final String motivo;
    private final Mascota mascota;
    public Cita(LocalDate fecha, String motivo, Mascota mascota) {
        this.fecha = fecha; this.motivo = motivo; this.mascota = mascota;
    }
    public LocalDate getFecha() { return fecha; }
    public String getMotivo() { return motivo; }
    public Mascota getMascota() { return mascota; }
}

class Clinica {
    private final List<Cita> citas = new ArrayList<>();
    public void agendarCita(Cita c) { if (c != null) citas.add(c); }

    public List<Cita> obtenerCitasDeMascota(Mascota m) {
        List<Cita> res = new ArrayList<>();
        if (m == null) return res;
        for (Cita c : citas) if (c.getMascota().getNombre().equals(m.getNombre())) res.add(c);
        return res;
    }

    public List<Cita> obtenerCitasPorFecha(LocalDate fecha) {
        List<Cita> res = new ArrayList<>();
        for (Cita c : citas) if (c.getFecha().equals(fecha)) res.add(c);
        return res;
    }
}
```

**Explicación:**

* Simple gestor de citas; comparar por nombre de mascota (podrías usar ID único si quieres).

---

## Bloque C — Herencia (21–30)

Ahora diseñaremos jerarquías con polimorfismo.

---

### Ejercicio 21 – Figuras geométricas (abstracta + subclases)

**Paquete:** `com.docencia.herencia.ejercicio21`

```java
package com.docencia.herencia.ejercicio21;

public abstract class Figura {
    // Método abstracto para calcular área; cada subclase implementa su fórmula.
    public abstract double area();
}

class Circulo extends Figura {
    private final double radio;
    public Circulo(double radio) { this.radio = radio; }
    @Override
    public double area() { return Math.PI * radio * radio; }
}

class Rectangulo extends Figura {
    private final double ancho;
    private final double alto;
    public Rectangulo(double ancho, double alto) { this.ancho = ancho; this.alto = alto; }
    @Override
    public double area() { return ancho * alto; }
}

class Triangulo extends Figura {
    private final double base;
    private final double altura;
    public Triangulo(double base, double altura) { this.base = base; this.altura = altura; }
    @Override
    public double area() { return base * altura / 2.0; }
}
```

**Explicación:**

* `Figura` abstracta con método `area()`. Subclases implementan fórmulas.
* Polimorfismo permite manejar `List<Figura>` y sumar áreas.

---

### Ejercicio 22 – Empleados de una empresa (por horas y fijos)

**Paquete:** `com.docencia.herencia.ejercicio22`

```java
package com.docencia.herencia.ejercicio22;

public abstract class Empleado {
    private final String nombre;
    public Empleado(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    // Método polimórfico para calcular sueldo
    public abstract double calcularSueldo();
}

class EmpleadoPorHoras extends Empleado {
    private final double horas;
    private final double tarifaHora;
    public EmpleadoPorHoras(String nombre, double horas, double tarifaHora) {
        super(nombre);
        this.horas = horas;
        this.tarifaHora = tarifaHora;
    }
    @Override
    public double calcularSueldo() { return horas * tarifaHora; }
}

class EmpleadoFijo extends Empleado {
    private final double salarioMensual;
    public EmpleadoFijo(String nombre, double salarioMensual) {
        super(nombre); this.salarioMensual = salarioMensual;
    }
    @Override
    public double calcularSueldo() { return salarioMensual; }
}
```

**Explicación:**

* Lista polimórfica `List<Empleado>` puede sumar `calcularSueldo()` de cada empleado.

---

### Ejercicio 23 – Vehículos con `descripcion()`

**Paquete:** `com.docencia.herencia.ejercicio23`

```java
package com.docencia.herencia.ejercicio23;

public abstract class Vehiculo {
    private final String marca;
    private final String modelo;
    public Vehiculo(String marca, String modelo) { this.marca = marca; this.modelo = modelo; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public abstract String descripcion();
}

class Coche extends Vehiculo {
    public Coche(String marca, String modelo) { super(marca, modelo); }
    @Override
    public String descripcion() { return "Coche " + getMarca() + " " + getModelo(); }
}

class Moto extends Vehiculo {
    public Moto(String marca, String modelo) { super(marca, modelo); }
    @Override
    public String descripcion() { return "Moto " + getMarca() + " " + getModelo(); }
}

class Camion extends Vehiculo {
    public Camion(String marca, String modelo) { super(marca, modelo); }
    @Override
    public String descripcion() { return "Camión " + getMarca() + " " + getModelo(); }
}
```

**Explicación:**

* Cada subclase sobrescribe `descripcion()` adaptando el texto.

---

### Ejercicio 24 – Sistema de notificaciones (polimórfico)

**Paquete:** `com.docencia.herencia.ejercicio24`

```java
package com.docencia.herencia.ejercicio24;

public abstract class Notificacion {
    protected final String destino;
    protected final String mensaje;
    public Notificacion(String destino, String mensaje) {
        this.destino = destino; this.mensaje = mensaje;
    }
    public abstract void enviar();
}

class EmailNotificacion extends Notificacion {
    public EmailNotificacion(String destino, String mensaje) { super(destino, mensaje); }
    @Override
    public void enviar() {
        // Aquí solo simulamos envío
        System.out.println("Enviando email a " + destino + ": " + mensaje);
    }
}

class SMSNotificacion extends Notificacion {
    public SMSNotificacion(String destino, String mensaje) { super(destino, mensaje); }
    @Override
    public void enviar() {
        System.out.println("Enviando SMS a " + destino + ": " + mensaje);
    }
}

class PushNotificacion extends Notificacion {
    public PushNotificacion(String destino, String mensaje) { super(destino, mensaje); }
    @Override
    public void enviar() {
        System.out.println("Enviando Push a " + destino + ": " + mensaje);
    }
}
```

**Explicación:**

* Polimorfismo con `enviar()`; permite manejar colección `List<Notificacion>` y enviar todas sin conocer tipo concreto.

---

### Ejercicio 25 – Animales y sonidos

**Paquete:** `com.docencia.herencia.ejercicio25`

```java
package com.docencia.herencia.ejercicio25;

public abstract class Animal {
    private final String nombre;
    public Animal(String nombre) { this.nombre = nombre; }
    public String getNombre() { return nombre; }
    public abstract String hacerSonido();
}

class Perro extends Animal {
    public Perro(String nombre) { super(nombre); }
    @Override public String hacerSonido() { return "Guau"; }
}

class Gato extends Animal {
    public Gato(String nombre) { super(nombre); }
    @Override public String hacerSonido() { return "Miau"; }
}

class Vaca extends Animal {
    public Vaca(String nombre) { super(nombre); }
    @Override public String hacerSonido() { return "Muu"; }
}
```

**Explicación:**

* Subclases implementan `hacerSonido()`.

---

### Ejercicio 26 – Productos digitales y físicos

**Paquete:** `com.docencia.herencia.ejercicio26`

```java
package com.docencia.herencia.ejercicio26;

public abstract class Producto {
    private final String id;
    private final String nombre;
    private final double precioBase;
    public Producto(String id, String nombre, double precioBase) {
        this.id = id; this.nombre = nombre; this.precioBase = precioBase;
    }
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }
    public abstract double calcularPrecioFinal();
}

class ProductoFisico extends Producto {
    private final double costeEnvio;
    public ProductoFisico(String id, String nombre, double precioBase, double costeEnvio) {
        super(id, nombre, precioBase); this.costeEnvio = costeEnvio;
    }
    @Override public double calcularPrecioFinal() { return getPrecioBase() + costeEnvio; }
}

class ProductoDigital extends Producto {
    private final double impuesto; // porcentaje
    public ProductoDigital(String id, String nombre, double precioBase, double impuesto) {
        super(id, nombre, precioBase); this.impuesto = impuesto;
    }
    @Override public double calcularPrecioFinal() { return getPrecioBase() * (1 + impuesto / 100.0); }
}
```

**Explicación:**

* Diferentes cálculos de precio final según tipo de producto.

---

### Ejercicio 27 – Cuenta bancaria (cuenta ahorro y corriente)

**Paquete:** `com.docencia.herencia.ejercicio27`

```java
package com.docencia.herencia.ejercicio27;

public abstract class CuentaBancaria {
    protected double saldo;
    public CuentaBancaria(double saldoInicial) { this.saldo = saldoInicial; }

    public void depositar(double cantidad) {
        if (cantidad > 0) saldo += cantidad;
    }

    // Retirar puede comportarse distinto según subclase
    public abstract boolean retirar(double cantidad);

    public double getSaldo() { return saldo; }
}

class CuentaAhorro extends CuentaBancaria {
    private final double interesAnual;
    public CuentaAhorro(double saldoInicial, double interesAnual) {
        super(saldoInicial); this.interesAnual = interesAnual;
    }
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
    public void aplicarInteres() {
        saldo += saldo * (interesAnual / 100.0);
    }
}

class CuentaCorriente extends CuentaBancaria {
    private final double descubiertoMaximo;
    public CuentaCorriente(double saldoInicial, double descubiertoMaximo) {
        super(saldoInicial); this.descubiertoMaximo = descubiertoMaximo;
    }
    @Override
    public boolean retirar(double cantidad) {
        if (cantidad <= saldo + descubiertoMaximo) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }
}
```

**Explicación:**

* `CuentaAhorro` no permite superar saldo; `CuentaCorriente` permite descubierto hasta un límite.

---

### Ejercicio 28 – Formas de pago (polimórfico)

**Paquete:** `com.docencia.herencia.ejercicio28`

```java
package com.docencia.herencia.ejercicio28;

public abstract class Pago {
    public abstract boolean procesarPago(double cantidad);
}

class PagoTarjeta extends Pago {
    @Override
    public boolean procesarPago(double cantidad) {
        // Simulación: siempre aceptamos si cantidad > 0
        return cantidad > 0;
    }
}

class PagoPayPal extends Pago {
    @Override
    public boolean procesarPago(double cantidad) {
        return cantidad > 0;
    }
}

class PagoTransferencia extends Pago {
    @Override
    public boolean procesarPago(double cantidad) {
        return cantidad > 0;
    }
}
```

**Explicación:**

* Implementaciones simples; en la práctica habría integraciones externas.

---

### Ejercicio 29 – Sistema de roles de usuario

**Paquete:** `com.docencia.herencia.ejercicio29`

```java
package com.docencia.herencia.ejercicio29;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    private final String nombre;
    private final String email;
    public Usuario(String nombre, String email) { this.nombre = nombre; this.email = email; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public abstract List<String> accionesDisponibles();
}

class Admin extends Usuario {
    public Admin(String nombre, String email) { super(nombre, email); }
    @Override
    public List<String> accionesDisponibles() {
        List<String> a = new ArrayList<>();
        a.add("crear_usuario"); a.add("borrar_usuario"); a.add("editar_permisos");
        return a;
    }
}

class Moderador extends Usuario {
    public Moderador(String nombre, String email) { super(nombre, email); }
    @Override
    public List<String> accionesDisponibles() {
        List<String> a = new ArrayList<>();
        a.add("banear_usuario"); a.add("moderar_contenido");
        return a;
    }
}

class UsuarioNormal extends Usuario {
    public UsuarioNormal(String nombre, String email) { super(nombre, email); }
    @Override
    public List<String> accionesDisponibles() {
        List<String> a = new ArrayList<>();
        a.add("publicar"); a.add("comentar");
        return a;
    }
}
```

**Explicación:**

* Polimorfismo para determinar acciones según rol.

---

### Ejercicio 30 – Grupo de figuras y área total

**Paquete:** `com.docencia.herencia.ejercicio30`

```java
package com.docencia.herencia.ejercicio30;

import com.docencia.herencia.ejercicio21.Figura; // reutilizamos la Figura del ejercicio 21
import java.util.ArrayList;
import java.util.List;

public class GrupoFiguras {
    private final List<Figura> figuras = new ArrayList<>();

    public void agregarFigura(Figura f) { if (f != null) figuras.add(f); }

    public double areaTotal() {
        double total = 0;
        for (Figura f : figuras) total += f.area(); // polimorfismo: cada figura calcula su área
        return total;
    }

    public static double areaTotalDeGrupos(List<GrupoFiguras> grupos) {
        double total = 0;
        for (GrupoFiguras g : grupos) total += g.areaTotal();
        return total;
    }
}
```

**Explicación:**

* `GrupoFiguras` agrega `Figura` (polimórfica) y suma áreas; utilidad para agregar varios grupos.

---

