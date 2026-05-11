package com.ejemplo.repository.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

abstract class CsvReaderAbstract {

    public List<String[]> read(Path path, String separatorRegex, boolean skipHeader) throws IOException {
        List<String[]> rows = new ArrayList<>();

        if (!Files.exists(path)) {
            return rows;
        }

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine && skipHeader) {
                    firstLine = false;
                    continue;
                }
                firstLine = false;

                if (line.trim().isEmpty()) {
                    continue;
                }

                rows.add(line.split(separatorRegex, -1));
            }
        }

        return rows;
    }
}































































// package com.docente.ficheros;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.List;

// import com.docente.modelo.Alumno;
// import com.docente.modelo.Asignatura;
// import static com.docente.utils.Utilidades.DELIMITER;

// public abstract class FicheroAbstract {

// File file;
// String path;

// public FicheroAbstract(String path) {
// this.path = path;
// file = new File(path);
// if (!file.exists()) {
// try {
// file.createNewFile();
// } catch (IOException e) {
// System.err.println("No se ha podido crear el fichero:" + path);
// e.printStackTrace();
// }
// }
// }

// public boolean cleanFile() {
// if (file.exists()) {
// file.delete();
// }
// try {
// file.createNewFile();
// } catch (IOException e) {
// System.err.printf("No se ha podido crear el fichero :%s", path);
// e.printStackTrace();
// }
// return true;
// }

// public List<Alumno> read() {
// List<Alumno> alumnos= new ArrayList<>();
// try {
// try (BufferedReader br = new BufferedReader(new FileReader(file))) {
// String line;
// while ((line = br.readLine()) != null) {
// String[] values = line.split(DELIMITER);
// alumnos.add(new Alumno(values[0],values[1],
// Integer.parseInt(values[2].strip()), values[3]));
// }
// }
// } catch (Exception e) {
// System.err.printf("No se ha podido leer el fichero :%s", path);
// }
// return alumnos;
// }
// // datos = 00000000H| pepe| 18| DAM
// // Alumno alumno, alumno.toCSV
// public void write(Alumno alumno) {
// try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
// bw.write(alumno.toCsv());
// bw.newLine();
// } catch (IOException e) {
// throw new IllegalStateException("Error al guardar el fichero CSV.", e);
// }
// }

// /**
// * Funcion que actualiza toda la lista dentro del fichero
// * @param alumnos lista de alumnos
// */
// public void updateFichero(List<Alumno> alumnos) {
// cleanFile();
// for (Alumno alumno : alumnos) {
// write(alumno);
// }
// }

// public List<Asignatura> readAsignatura() {
// List<Asignatura> asignaturas= new ArrayList<>();
// try {
// try (BufferedReader br = new BufferedReader(new FileReader(file))) {
// String line;
// while ((line = br.readLine()) != null) {
// String[] values = line.split(DELIMITER);
// asignaturas.add(new Asignatura(values[0],values[1],
// Integer.parseInt(values[2].strip())));
// }
// }
// } catch (Exception e) {
// System.err.printf("No se ha podido leer el fichero :%s", path);
// }
// return asignaturas;
// }

// public void writeAsignatura(Asignatura asignatura) {
// try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
// bw.write(asignatura.toCsv());
// bw.newLine();
// } catch (IOException e) {
// throw new IllegalStateException("Error al guardar el fichero CSV.", e);
// }
// }

// public void updateFicheroAsignatura(List<Asignatura> asignaturas) {
// cleanFile();
// for (Asignatura asignatura : asignaturas) {
// writeAsignatura(asignatura);
// }
// }

// }

// package com.docencia.ficheros;

// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Path;
// import java.util.ArrayList;
// import java.util.LinkedHashMap;
// import java.util.List;
// import java.util.Map;

// public class CsvServiceImpl implements CsvService {

//     @Override
//     public List<String> leerLineasCsv(Path ruta) {
//         if (ruta == null) {
//             throw new IllegalArgumentException();
//         }
//         if (!Files.exists(ruta)) {
//             throw new IllegalArgumentException();
//         }

//         List<String> lineas = new ArrayList<>();

//         try (BufferedReader br = new BufferedReader(new FileReader(ruta.toFile()))) {
//             String linea;
//             while ((linea = br.readLine()) != null) {
//                 lineas.add(linea);
//             }
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }

//         return lineas;
//     }

//     @Override
//     public List<String[]> leerRegistrosCsv(Path ruta) {
//         if (ruta == null) {
//             throw new IllegalArgumentException();
//         }
//         if (!Files.exists(ruta)) {
//             throw new IllegalArgumentException();
//         }

//         List<String[]> registros = new ArrayList<>();

//         try (BufferedReader br = new BufferedReader(new FileReader(ruta.toString()))) {
//             String linea;
//             while ((linea = br.readLine()) != null) {
//                 registros.add(linea.split(","));
//             }
//             return registros;
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     }

//     @Override
//     public void escribirLineasCsv(Path ruta, List<String> lineas) {
//         if (ruta == null || lineas == null || lineas.isEmpty()) {
//             throw new IllegalArgumentException();
//         }
//         try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta.toFile()))) {
//             for (String linea : lineas) {
//                 bw.write(linea);
//                 bw.newLine();
//             }
//         } catch (IOException e) {
//             throw new RuntimeException(e);
//         }
//     }

//     @Override
//     public Integer contarRegistrosCsv(Path ruta) {
//         Integer resultado = 0;
//         return leerRegistrosCsv(ruta).size();

//     }

//     @Override
//     public List<String[]> filtrarRegistrosPorValor(Path ruta, Integer columna, String valor) {
//         if (ruta == null || columna == null || valor == null || columna < 0) {
//             throw new IllegalArgumentException();
//         }
//         if (!Files.exists(ruta)) {
//             throw new IllegalArgumentException();
//         }

//         List<String[]> registros = leerRegistrosCsv(ruta);

//         for (String[] registro : registros) {
//             if (columna >= registro.length) {
//                 throw new IllegalArgumentException("Columna invalida");
//             }
//         }

//         List<String[]> filtrados = new ArrayList<>();
//         for (String[] registro : registros) {
//             if (registro[columna].equals(valor)) {
//                 filtrados.add(registro);
//             }
//         }

//         return filtrados;
//     }

//     @Override
//     public Map<String, Integer> contarFrecuenciaColumna(Path ruta, Integer columna) {
//         if (ruta == null || columna == null || columna < 0) {
//             throw new IllegalArgumentException();
//         }
//         if (!Files.exists(ruta)) {
//             throw new IllegalArgumentException();
//         }

//         Map<String, Integer> frecuencia = new LinkedHashMap<>();

//         List<String[]> registros = leerRegistrosCsv(ruta);

//         for (String[] registro : registros) {
//             if (registro.length > columna) {
//                 String valor = registro[columna];
//                 frecuencia.put(valor, frecuencia.getOrDefault(valor, 0) + 1);
//             }
//         }

//         return frecuencia;
//     }
// }