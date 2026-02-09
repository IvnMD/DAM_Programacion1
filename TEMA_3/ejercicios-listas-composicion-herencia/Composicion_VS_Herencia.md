 **Un único documento completo**, con:

1. ✔ Explicación detallada de **herencia vs composición**
2. ✔ Ejemplos avanzados
3. ✔ Ejemplo de **herencia mal usada → corregida con composición**
4. ✔ Ejercicios de práctica
5. ✔ **TODO mi mensaje anterior integrado al final**, para que puedas copiarlo todo junto.

---

# 📘 **COMPOSICIÓN vs HERENCIA:**

---

# 🧬 **HERENCIA**

La **herencia** es una relación **“es-un”** (*is-a*).
Una clase extiende a otra para reutilizar o especializar comportamiento.

### Ejemplo básico:

```java
class Animal {
    void comer() { }
}

class Perro extends Animal {
    void ladrar() { }
}
```

🔎 **Interpretación:**
**Perro ES un Animal.**

## ✔ Ventajas de la herencia

* Reutilización directa de atributos/métodos.
* Permite polimorfismo.
* Simplifica código cuando el modelo es correcto.

## ❌ Desventajas de la herencia

* Fuerte acoplamiento.
* Rigidez: no puedes cambiar jerarquías fácilmente.
* Propaga métodos que quizá no necesitas.
* Rompe encapsulamiento si se abusa.

---

# 🧱 **COMPOSICIÓN**

La **composición** es una relación **“tiene-un”** (*has-a*).
Una clase contiene otras clases como atributos.

### Ejemplo básico:

```java
class Motor {
    void encender() { }
}

class Coche {
    private Motor motor = new Motor();

    void arrancar() {
        motor.encender();
    }
}
```

🔎 **Interpretación:**
**Un coche TIENE un motor**, pero no es un motor.

## ✔ Ventajas de la composición

* Bajo acoplamiento.
* Mucho más flexible que la herencia.
* Cambiar comportamiento es fácil: cambia el objeto interno.
* Evita problemas de herencia múltiple.
* Encapsulamiento más limpio.

## ❌ Desventajas

* Hay que delegar métodos manualmente.
* No se hereda comportamiento automáticamente.

---

# 🥊 **TABLA COMPARATIVA**

| Concepto               | Herencia                  | Composición                      |
| ---------------------- | ------------------------- | -------------------------------- |
| Relación               | **ES-UN**                 | **TIENE-UN**                     |
| Acoplamiento           | Alto                      | Bajo                             |
| Flexibilidad           | Baja                      | Alta                             |
| Reutilización          | Implícita                 | Explícita                        |
| Cambiar comportamiento | Difícil                   | Fácil                            |
| Encapsulamiento        | Peor                      | Mejor                            |
| Jerarquías             | Rígidas                   | Flexibles                        |
| Cuándo usar            | Relación natural y fuerte | La mayoría de los casos modernos |

---

# 🧠 **Regla de oro**

👉 **Usa composición por defecto; usa herencia solo si la relación ES-UN es evidente y estable.**

---

# 📌 **EJEMPLOS AVANZADOS**

---

## 🔷 **1. Composición permitiendo comportamiento intercambiable (patrón Strategy)**

Objetivo: distintos tipos de movimiento sin herencia múltiple.

### Con composición:

```java
interface Movimiento {
    void mover();
}

class MovimientoTerrestre implements Movimiento {
    public void mover() { System.out.println("Caminando"); }
}

class MovimientoAcuatico implements Movimiento {
    public void mover() { System.out.println("Nadando"); }
}

class Animal {
    private Movimiento movimiento;

    public Animal(Movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public void moverse() {
        movimiento.mover();
    }

    public void setMovimiento(Movimiento nuevoMovimiento) {
        this.movimiento = nuevoMovimiento;
    }
}
```

### Uso:

```java
Animal perro = new Animal(new MovimientoTerrestre());
perro.moverse(); // Caminando

perro.setMovimiento(new MovimientoAcuatico());
perro.moverse(); // Nadando
```

✔ Comportamiento intercambiable
✔ No necesitas herencia múltiple

---

## 🔷 **2. Herencia bien usada (modelo estable)**

```java
abstract class Figura {
    abstract double area();
}

class Circulo extends Figura {
    double radio;
    Circulo(double r) { this.radio = r; }
    double area() { return Math.PI * radio * radio; }
}
```

🔎 Un círculo **es** una figura.
✔ Modelo estable.
✔ Herencia correcta.

---

# ⚠️ **HERENCIA MAL USADA — EJEMPLO REALISTA**

---

## ❌ MAL usado: herencia artificial

```java
class Empleado {
    String nombre;
    double salario;
}

class Jefe extends Empleado {
    List<Empleado> subordinados;
}
```

¿Por qué está mal?

* Un jefe **no es** un empleado, conceptualmente sí, pero funcionalmente tienen responsabilidades totalmente distintas.
* Si mañana un jefe deja de tener subordinados, ¿deja de ser jefe?
* El modelo es rígido.

---

## ✔ Solución con composición:

```java
class Persona {
    String nombre;
}

class Empleado {
    Persona persona;
    double salario;
}

class Jefe {
    Empleado empleadoBase;
    List<Empleado> subordinados;
}
```

Ahora:

* Un jefe **tiene** un empleado base.
* Un jefe **tiene** subordinados.
* Se puede agregar o quitar roles sin romper jerarquías.

Mucho más flexible.

---

# 📝 **EJERCICIOS PARA PRACTICAR**

---

## 🔹 **Ejercicio 1**

Modela un sistema con `Libro`, `Biblioteca`, `Autor`.

* Decide qué es herencia y qué es composición.
* Implementa el código.

👉 *Pista:* Una biblioteca TIENE libros, un libro TIENE autor(es).

---

## 🔹 **Ejercicio 2**

Implementa una clase `Robot` con diferentes modos de movimiento:

* caminar
* rodar
* volar

Usa **composición** (estrategia) para cambiar el comportamiento dinámicamente.

---

## 🔹 **Ejercicio 3**

Dime si estas relaciones son herencia o composición:

1. Círculo → Figura
2. Usuario → CarritoDeCompra
3. Profesor → Persona
4. Avión → Motor
5. Ordenador → Teclado

---

## 🔹 **Ejercicio 4**

Transforma este mal diseño basado en herencia en una versión correcta con composición:

```java
class Ventana { }
class VentanaEmergente extends Ventana { }
class VentanaConfiguracion extends Ventana { }
class VentanaError extends Ventana { }
```

¿Qué problema hay? ¿Cómo lo solucionas?

---

