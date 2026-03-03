package com.docencia.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.docencia.model.Alumno;
import com.docencia.model.Persona;
import com.docencia.model.Profesor;
import com.docencia.service.CentroEducativo;
/**
 * @author IvnMD
 * @date 02/03/2026
 * @version 1.0.0
 * 
 * @brief Menu de la app
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CentroEducativo centro = new CentroEducativo();
        int op;
        do {
            imprimirMenu();
            System.out.print("Opción: ");
            // Leer opción (control básico)
            String linea = sc.nextLine();
            try {
                op = Integer.parseInt(linea.trim());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Introduce un número.");
                op = -1;
            }
            try {
                switch (op) {
                    case 1 -> registrarAlumno(sc, centro);
                    case 2 -> registrarProfesor(sc, centro);
                    case 3 -> listarPersonas(centro);
                    case 4 -> buscarPorId(sc, centro);
                    case 5 -> buscarPorDocumento(sc, centro);
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no reconocida.");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (op != 0);
        sc.close();
    }

    private static void imprimirMenu() {
        System.out.println("\n===== CENTRO EDUCATIVO =====");
        System.out.println("1) Registrar alumno");
        System.out.println("2) Registrar profesor");
        System.out.println("3) Listar personas");
        System.out.println("4) Buscar por ID");
        System.out.println("5) Buscar por documento");
        System.out.println("0) Salir");
    }

    // === Registro (siguiendo tu estilo: nextLine + parse) ===
    private static void registrarAlumno(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Registro Alumno ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine().trim());
        LocalDate fechaRegistro = LocalDate.now();
        System.out.print("Curso: ");
        String curso = sc.nextLine();
        Alumno alumno = new Alumno(id, nombre, documento, email,
                fechaNacimiento, fechaRegistro, curso);
        centro.registrarPersona(alumno);
        System.out.println("Alumno registrado.");
    }

    private static void registrarProfesor(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Registro Profesor ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Fecha nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine().trim());
        LocalDate fechaRegistro = LocalDate.now();
        System.out.print("Departamento: ");
        String departamento = sc.nextLine();
        Profesor profesor = new Profesor(id, nombre, documento, email,
                fechaNacimiento, fechaRegistro, departamento);
        centro.registrarPersona(profesor);
        System.out.println(" Profesor registrado.");
    }

    // === Otras opciones del menú ===
    private static void listarPersonas(CentroEducativo centro) {
        System.out.println("\n--- Listado de personas ---");
        List<Persona> personas = centro.listarPersonas();
        if (personas.isEmpty()) {
            System.out.println("(vacío)");
            return;
        }
        for (Persona p : personas) {
            System.out.println(p);
        }
    }

    private static void buscarPorId(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Buscar por ID ---");
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Persona p = centro.buscarPorId(id);
        System.out.println(p == null ? "No encontrado" : p.toString());
    }

    private static void buscarPorDocumento(Scanner sc, CentroEducativo centro) {
        System.out.println("\n--- Buscar por documento ---");
        System.out.print("Documento: ");
        String documento = sc.nextLine();
        Persona p = centro.buscarPorDocumento(documento);
        System.out.println(p == null ? "No encontrado" : p.toString());
    }
}