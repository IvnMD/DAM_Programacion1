package TEMA_1.Repaso;

import java.util.Scanner;

public class ManejoArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] semana = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };

        for (int i = 0; i < semana.length; i++) {
            System.out.println(semana[i]);
        }
        System.out.println("\nO tambien: \n");
        for (String dia : semana) {
            System.out.println(dia);
        }
        sc.close();
    }
}
