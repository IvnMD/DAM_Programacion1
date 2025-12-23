# DAM_Programacion1

Repositorio de la asignatura "Programación 1" del ciclo formativo de grado superior en Desarrollo de Aplicaciones Multiplataforma (DAM). Aquí se guardan las prácticas, proyectos, apuntes y ejemplos del primer curso, organizados por temas para que sea fácil consultarlos y ejecutar los ejercicios.

Descripción
-----------
Este repositorio reúne el material usado en clase: ejercicios, evaluables, exámenes, proyectos y guías. Los contenidos están organizados por carpetas llamadas `TEMA_1`, `TEMA_2`, `TEMA_3`, etc. Cada tema puede contener subcarpetas con prácticas, enunciados o ejemplos.

Índice
------
- [Estructura del repositorio](#estructura-del-repositorio)
- [Temas y proyectos](#temas-y-proyectos)
- [Archivos útiles](#archivos-útiles)
- [Cómo ejecutar las prácticas](#cómo-ejecutar-las-prácticas)
- [Licencia](#licencia)
- [Contribuir](#contribuir)
- [Contacto](#contacto)

Estructura del repositorio
--------------------------
En la raíz encontrarás carpetas por tema y algunos archivos sueltos. Resumen de lo detectado:

- TEMA_1/
  - Evaluables/
  - Repaso/
  - array/
  - condicionales/
- TEMA_2/
  - Evaluables/
  - docencia-clases/
  - docencia-programacion-repaso-I/
- TEMA_3/
  - Examenes/
  - Proyecto0_Clases/
  - ejercicios-1-eval-repaso-I/
  - ejercicios-listas-composicion-herencia/
  - ejercicios-repaso/
  - trabajando-con-clases 2/
  - trabajando-con-clases/
  - unidad3-ejercicios/
- Instalacion_Java.md — guía para preparar Java

Temas y proyectos
------------------
Enlace directo a las carpetas encontradas (haz clic para abrirlas en GitHub):

- Tema 1
  - [TEMA_1/Evaluables](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_1/Evaluables)
  - [TEMA_1/Repaso](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_1/Repaso)
  - [TEMA_1/array](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_1/array)
  - [TEMA_1/condicionales](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_1/condicionales)
- Tema 2
  - [TEMA_2/Evaluables](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_2/Evaluables)
  - [TEMA_2/docencia-clases](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_2/docencia-clases)
  - [TEMA_2/docencia-programacion-repaso-I](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_2/docencia-programacion-repaso-I)
- Tema 3
  - [TEMA_3/Examenes](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_3/Examenes)
  - [TEMA_3/Proyecto0_Clases](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_3/Proyecto0_Clases)
  - [TEMA_3/ejercicios-1-eval-repaso-I](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_3/ejercicios-1-eval-repaso-I)
  - [TEMA_3/ejercicios-listas-composicion-herencia](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_3/ejercicios-listas-composicion-herencia)
  - [TEMA_3/ejercicios-repaso](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_3/ejercicios-repaso)
  - [TEMA_3/trabajando-con-clases 2](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_3/trabajando-con-clases%202)
  - [TEMA_3/trabajando-con-clases](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_3/trabajando-con-clases)
  - [TEMA_3/unidad3-ejercicios](https://github.com/IvnMD/DAM_Programacion1/tree/main/TEMA_3/unidad3-ejercicios)

Archivos útiles
---------------
- [Instalacion_Java.md](https://github.com/IvnMD/DAM_Programacion1/blob/main/Instalacion_Java.md) — instrucciones para instalar y configurar Java (útil para las prácticas en Java).

Cómo ejecutar las prácticas
---------------------------
Cada práctica suele incluir un README propio con instrucciones. Si no existe, normalmente basta con localizar la clase `main` o el script principal. Ejemplos generales:

- Clonar el repositorio:
  ```bash
  git clone https://github.com/IvnMD/DAM_Programacion1.git
  cd DAM_Programacion1
  ```
- Java (si la práctica usa Maven):
  ```bash
  cd TEMA_3/Proyecto0_Clases
  mvn clean compile
  mvn exec:java -Dexec.mainClass="es.tu.paquete.Main"
  ```
- Python:
  ```bash
  python3 -m venv env
  source env/bin/activate  # Linux/macOS
  env\Scripts\activate   # Windows (PowerShell)
  pip install -r requirements.txt
  python main.py
  ```
- Node.js:
  ```bash
  npm install
  npm start
  ```

Licencia
--------
- Código fuente: Apache License 2.0. Consulta el archivo [LICENSE](https://github.com/IvnMD/DAM_Programacion1/blob/main/LICENSE) para el texto completo.
- Documentación y material didáctico (apuntes, enunciados): Creative Commons Attribution-NonCommercial-ShareAlike 4.0 (CC BY-NC-SA 4.0). Más información en [LICENSE-DOCS.md](https://github.com/IvnMD/DAM_Programacion1/blob/main/LICENSE-DOCS.md).

Nota: Con esta combinación el código puede reutilizarse ampliamente (incluso con fines comerciales) bajo Apache 2.0, mientras que los materiales docentes permanecen protegidos frente a usos comerciales sin permiso y requieren atribución y ShareAlike para obras derivadas.

Contribuir
----------
Si quieres colaborar, gracias. Sugerencias:

1. Haz fork del repositorio y crea una rama para tu trabajo:
   ```bash
   git checkout -b feature/nombre-corto
   ```
2. Añade tus cambios, comenta bien los commits y sube la rama al fork.
3. Abre un pull request describiendo el cambio y cómo probarlo.

Ten en cuenta que, al contribuir código, aceptas que ese código se publique bajo Apache License 2.0. Para contribuciones de documentación, aplicará CC BY-NC-SA 4.0.

Contacto
--------
- Autor: IvnMD (Iván Mesa Domínguez)
- Correo: ivan.mesa.dominguez@gmail.com
- Perfil: https://github.com/IvnMD

---

(Hecho para uso docente: si quieres que deje algún texto más corto u ordene las carpetas de otra forma, dímelo y lo ajusto.)
